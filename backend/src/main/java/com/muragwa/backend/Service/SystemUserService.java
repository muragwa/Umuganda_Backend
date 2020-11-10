package com.muragwa.backend.Service;

import java.util.List;
import java.util.Optional;

import com.muragwa.backend.Domain.System_User;

public interface SystemUserService {
    public String create(System_User user);
	public String update (System_User systemUser);
	public String delete(System_User systemUser);
	public List<System_User>all();
    public Optional<System_User> findById(long id);
    public Optional<System_User> findByuuid(String uuid); 
	public System_User findByUsername(String username);
	public System_User findByUsernameAndPassword(String username, String password);
}