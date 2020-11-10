package com.muragwa.backend.Dao;

import java.util.Optional;

import com.muragwa.backend.Domain.System_User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SystemUserDao extends JpaRepository<System_User, Integer>{
    Optional<System_User>findByuuid(String uuid);
	Optional<System_User>findById(int  id);
    public System_User findByUsernameAndPassword(String username, String password);
}