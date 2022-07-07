package com.grupo4.controller;

import com.grupo4.model.entity.User;
import com.grupo4.model.repository.UserDAO;
import com.grupo4.view.frmRegister;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserController implements ActionListener {
    private User mod;
    private UserDAO modC;
    private frmRegister frm;

    public UserController(User mod, UserDAO modC, frmRegister frm) {
        this.mod = mod;
        this.modC = modC;
        this.frm = frm;
        this.frm.btnCancel.addActionListener(this);
        this.frm.btnRegister.addActionListener(this);
    }

    public void iniciar() {
        frm.setTitle("Registro");
        frm.setLocationRelativeTo(null);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == frm.btnRegister) {
            mod.setName(frm.txtName.getText());
            mod.setDni(frm.txtDNI.getText());
            mod.setPhone(frm.txtPhone.getText());
            mod.setEmail(frm.txtEmail.getText());
            mod.setDestiny(frm.txtDestiny.getText());

            if (modC.register(mod)) {
                JOptionPane.showMessageDialog(null, "Registro guardado");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Error al guardar");
                limpiar();
            }
        }

        if (e.getSource() == frm.btnCancel) {
            limpiar();
        }
    }

    public void limpiar() {
        frm.txtName.setText(null);
        frm.txtDNI.setText(null);
        frm.txtPhone.setText(null);
        frm.txtEmail.setText(null);
        frm.txtDestiny.setText(null);
        }
}