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
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

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
    public String getResidentRegister(HttpServletRequest request, Model model) {
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        String id = authentication.getName();
        String sessionId = CookieUtils.getCookieValue(request, "SESSION");
        log.warn("세션아이디는 : " + sessionId);
        if (sessionId == null) {
            return "home";
        }
        String id = (String) redisTemplate.opsForHash().get(sessionId, "id");

        model.addAttribute("id", id);
        Resident resident = residentService.getResident(id);
        HouseholdCompositionResident householdCompositionResident =
                householdCompositionResidentService.getHouseholdCompositionResident(resident.getResidentSerialNumber());

        int householdSerialNumber = householdCompositionResident.getPk().getHouseholdSerialNumber();

        List<HouseholdCompositionResident> householdCompositionResidents =
                householdCompositionResidentService.getHouseholdCompositionResidents(householdSerialNumber);
        model.addAttribute("household_composition_residents", householdCompositionResidents);
        return "home";
    }
}
