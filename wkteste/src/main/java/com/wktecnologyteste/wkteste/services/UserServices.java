package com.wktecnologyteste.wkteste.services;

import org.springframework.beans.factory.annotation.Autowired;

public interface UserServices {
    public String login(String username, String password);

    public String register(String username, String password);

    public String logout();

}
