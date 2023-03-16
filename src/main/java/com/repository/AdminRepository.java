package com.repository;

import org.springframework.stereotype.Repository;

import com.entities.Admin;

import org.springframework.data.jpa.repository.JpaRepository;
@Repository
public interface AdminRepository extends JpaRepository<Admin,Integer>{

}
