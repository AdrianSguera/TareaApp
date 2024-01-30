package com.ceica.controller;

import com.ceica.modelos.Rol;
import com.ceica.modelos.Task;
import com.ceica.modelos.User;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AppController {
    private boolean admin;

    public AppController() {

    }

    private boolean isAdmin(String usu, String pass) {
        List<User> userList = User.getUsersBD();
        Optional<Integer> admin = userList.stream()
                .filter(user -> usu.equals(user.getUsername()) && pass.equals(user.getPassword()))
                .map(user -> user.getRol().getId())
                .findFirst();
        return admin.isPresent() && admin.get() == 2;
    }

    public List<User> getUsers(){
        return User.getUsersBD();
    }

    public List<Task> getTasks(){
        return Task.getTasksBD();
    }

    public List<Rol> getRoles(){
        return Rol.getRolesBD();
    }

    public boolean newTask(String title, String description, LocalDateTime deadline, User user){
        return new Task().insertar("(title,description,deadline,iduser) values (?,?,?,?)", title, description, deadline, user.getId());
    }

    public boolean newUser(String username, String password, Rol rol){
        return new User().insertar("(username,password,idrol) values (?,?,?)", username, password, rol.getId());
    }

    public boolean deleteTaskById(int idTask) {
        return new Task().eliminar("idtask=?", idTask);
    }

    public boolean deleteUserById(int idUser) {
        return new User().eliminar("iduser=?", idUser);
    }

    public boolean changeUsernameUser(int idUser, String dato) {
        return new User().modificar("username = ? WHERE iduser = ?", dato, idUser);
    }

    public boolean changePasswordUser(int idUser, String dato) {
        return new User().modificar("password = ? WHERE iduser = ?", dato, idUser);
    }

    public boolean changeRolUser(int idUser, int dato) {
        return new User().modificar("idrol = ? WHERE iduser = ?", dato, idUser);
    }

    public boolean changeTitleTask(int idTask, String dato) {
        return new Task().modificar("title = ? WHERE idtask = ?", dato, idTask);
    }

    public boolean changeDescriptionTask(int idTask, String dato) {
        return new Task().modificar("description = ? WHERE idtask = ?", dato, idTask);
    }

    public boolean changeCreationTimeTask(int idTask, LocalDateTime dato) {
        return new Task().modificar("create_time = ? WHERE idtask = ?", dato, idTask);
    }

}
