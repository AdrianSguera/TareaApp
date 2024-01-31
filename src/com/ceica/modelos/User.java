package com.ceica.modelos;

import java.util.ArrayList;
import java.util.List;

public class User extends ModeloBase{
    private static int idUser = 1;
    private int id;
    private String username, password;
    private Rol rol;


    public User() {
        //this.id = idUser++;
    }

    public User(String username, String password, Rol rol) {
        this.id = idUser++;
        this.username = username;
        this.password = password;
        this.rol = rol;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", rol=" + rol +
                '}';
    }

    @Override
    protected String getNombreTabla() {
        return "users_roles";
    }

    public static List<User> getUsersBD() {
        List<User> userList = new ArrayList<>();
        List<Object> objectList = new User().leerTodos();
        for (Object obj : objectList) {
            Object[] objects = (Object[]) obj;
            User user = new User();
            Rol rol = new Rol();
            user.setId((int) objects[0]);
            user.setUsername((String) objects[1]);
            user.setPassword((String) objects[2]);
            rol.setId((int) objects[3]);
            rol.setDescription((String) objects[4]);
            user.setRol(rol);
            userList.add(user);
        }
        return userList;
    }
}
