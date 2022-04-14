package com.cihatturhan.busseatreservation.com.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cihatturhan.busseatreservation.com.main.model.Role;
@Repository
public interface RoleRepository extends JpaRepository<Role, Integer>  {

}
