package com.wktecnologyteste.wkteste.services.imp;

import com.wktecnologyteste.wkteste.repository.UsersRepository;
import com.wktecnologyteste.wkteste.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServicesImp  implements UserServices {
@Autowired
private UsersRepository repository;

    @Override
    public String login(String username, String password) {
        return "";
    }

    @Override
    public String register(String username, String password) {
        return "";
    }

    @Override
    public String logout() {
        return "";
    }
}
