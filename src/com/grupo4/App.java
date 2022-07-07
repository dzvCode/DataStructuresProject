package com.grupo4;

import com.grupo4.controller.UserController;
import com.grupo4.model.entity.User;
import com.grupo4.model.repository.UserDAO;
import com.grupo4.view.frmRegister;

public class App {
    public static void main(String[] args) throws InterruptedException {
        User mod = new User();
        UserDAO modC = new UserDAO();
        frmRegister frm = new frmRegister(null);

        UserController ctrl = new UserController(mod, modC, frm);
        ctrl.iniciar();
        frm.setVisible(true);
    }
}
