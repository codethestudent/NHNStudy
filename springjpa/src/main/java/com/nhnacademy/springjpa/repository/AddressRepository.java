package com.nhnacademy.springjpa.repository;

import com.nhnacademy.springjpa.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Integer> {

}
