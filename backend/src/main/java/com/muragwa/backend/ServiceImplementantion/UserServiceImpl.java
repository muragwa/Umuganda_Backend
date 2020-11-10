package com.muragwa.backend.ServiceImplementantion;

import java.util.List;
import java.util.Optional;

import com.muragwa.backend.Dao.SystemUserDao;
import com.muragwa.backend.Domain.System_User;
import com.muragwa.backend.Service.SystemUserService;
import com.muragwa.backend.Utility.Encryption;
import com.muragwa.backend.Utility.Msg;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements SystemUserService {
    @Autowired
    private SystemUserDao userDao;
    @Override
    public String create(System_User user) {
        String message="";
        try {
            user.setPassword(Encryption.md5(user.getPassword()));
            userDao.save(user);
            message=Msg.save;
        } catch (Exception e) {
            message = Msg.error;
        }
        return message;
    }

    @Override
    public String update(System_User systemUser) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String delete(System_User systemUser) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<System_User> all() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Optional<System_User> findById(long id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Optional<System_User> findByuuid(String uuid) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public System_User findByUsername(String username) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public System_User findByUsernameAndPassword(String username, String password) {
        
        return userDao.findByUsernameAndPassword(username, password);
    }
    
}