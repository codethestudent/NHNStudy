package com.nhnacademy.springjpa.repository;

import com.nhnacademy.springjpa.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AddressRepository extends JpaRepository<Address, Integer> {
    List<Address> findByUserUserId(String userId);

    List<Address> findByAddressName(String addressName);
}
