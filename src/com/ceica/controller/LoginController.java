package com.ceica.controller;

import com.ceica.modelos.User;

import java.util.List;

public class LoginController {

    public static boolean login(String usu, String pass){
        List<User> userList = User.getUsersBD();
        return userList.stream()
                .anyMatch(usuario -> usu.equals(usuario.getUsername()) && pass.equals(usuario.getPassword()));
    }
}
