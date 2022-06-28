package com.mvc.app;

import com.mvc.controller.CtrlUsuario;
import com.mvc.model.ConsultaUsuario;
import com.mvc.model.User;
import com.mvc.view.frmUsuario;

public class App {
    public static void main(String[] args) {
        User mod = new User();
        ConsultaUsuario modC = new ConsultaUsuario();
        frmUsuario frm = new frmUsuario(null);

        CtrlUsuario ctrl = new CtrlUsuario(mod, modC, frm);
        ctrl.iniciar();
        frm.setVisible(true);
    }
}
