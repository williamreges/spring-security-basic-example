package com.example.springsecurityexample.sts.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface UsersRepository extends JpaRepository<Users, Long>, JpaSpecificationExecutor<Users> {

    Users findByUserName(String userName);

}