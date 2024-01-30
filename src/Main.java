import com.ceica.controller.AppController;
import com.ceica.modelos.Rol;
import com.ceica.modelos.User;

import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        AppController appController = new AppController();
        Rol rol = new Rol("admin");
        User user = new User("pepe", "42", rol);
        if (appController.changeRolUser(3,2))
            System.out.println("todo bien");
    }
}