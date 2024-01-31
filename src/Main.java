import com.ceica.controller.AppController;
import com.ceica.controller.LoginController;
import com.ceica.modelos.Rol;
import com.ceica.modelos.User;

import java.time.LocalDateTime;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        AppController appController = new AppController();
        if (LoginController.login("admin","1234")){
            appController.setUserLogged(LoginController.getUser("admin","1234"));
            System.out.println(appController.isAdmin(appController.getUserLogged()));
        }
    }
}