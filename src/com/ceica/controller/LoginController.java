package com.ceica.controller;

import com.ceica.modelos.User;

import java.util.List;

public class LoginController {

    public static boolean login(String usu, String pass){
        List<User> userList = User.getUsersBD();
        return userList.stream()
                .anyMatch(usuario -> usu.equals(usuario.getUsername()) && pass.equals(usuario.getPassword()));
    }

    public static User getUser(String usu, String pass){
        List<User> userList = User.getUsersBD();
        for (User user : userList){
            if (usu.equals(user.getUsername())&&pass.equals(user.getPassword()))
                return user;
        }
        return null;
    }
}
