package com.nhnacademy.certificateissuancesecurityboot.controller;

import com.nhnacademy.certificateissuancesecurityboot.entity.Household;
import com.nhnacademy.certificateissuancesecurityboot.entity.HouseholdCompositionResident;
import com.nhnacademy.certificateissuancesecurityboot.entity.Resident;
import com.nhnacademy.certificateissuancesecurityboot.service.HouseholdCompositionResidentService;
import com.nhnacademy.certificateissuancesecurityboot.service.HouseholdService;
import com.nhnacademy.certificateissuancesecurityboot.service.ResidentService;
import com.nhnacademy.certificateissuancesecurityboot.utils.CookieUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Slf4j
@Controller
@RequestMapping({"/", "/home"})
@RequiredArgsConstructor
public class HomeController {

    private final ResidentService residentService;
    private final RedisTemplate<Object, Object> redisTemplate;
    private final HouseholdCompositionResidentService householdCompositionResidentService;

    @GetMapping
    public String getResidentRegister(@RequestParam(value = "page", defaultValue = "0") int page,
                                      @RequestParam(value = "size", defaultValue = "3") int size,
                                      HttpServletRequest request, Model model) {
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        String id = authentication.getName();
        String sessionId = CookieUtils.getCookieValue(request, "SESSION");
        if (sessionId == null) {
            return "home";
        }
        String id = (String) redisTemplate.opsForHash().get(sessionId, "id");

        model.addAttribute("id", id);
        Resident resident = residentService.getResident(id);
        HouseholdCompositionResident householdCompositionResident =
                householdCompositionResidentService.getHouseholdCompositionResident(resident.getResidentSerialNumber());

        int householdSerialNumber = householdCompositionResident.getPk().getHouseholdSerialNumber();

        Page<HouseholdCompositionResident> householdCompositionResidents =
                householdCompositionResidentService.getHouseholdCompositionResidents(householdSerialNumber, page, size);
        model.addAttribute("householdCompositionResidents", householdCompositionResidents.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", householdCompositionResidents.getTotalPages());
        log.warn("페이지 : " + page);
        log.warn("사이즈 : " + size);
        log.warn("총 페이지 : " + model.getAttribute("totalPages"));
        return "home";
    }
}
