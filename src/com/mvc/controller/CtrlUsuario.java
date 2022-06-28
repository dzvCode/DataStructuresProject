package com.mvc.controller;

import com.mvc.model.ConsultaUsuario;
import com.mvc.model.User;
import com.mvc.view.frmUsuario;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CtrlUsuario implements ActionListener {

    private User mod;
    private ConsultaUsuario modC;
    private frmUsuario frm;

    public CtrlUsuario(User mod, ConsultaUsuario modC, frmUsuario frm) {
        this.mod = mod;
        this.modC = modC;
        this.frm = frm;
        this.frm.buscarButton.addActionListener(this);
        this.frm.modificarButton.addActionListener(this);
        this.frm.guardarButton.addActionListener(this);
        this.frm.eliminarButton.addActionListener(this);
        this.frm.limpiarButton.addActionListener(this);
    }

    public void iniciar() {
        frm.setTitle("Hola ");
        frm.setLocationRelativeTo(null);
        frm.txtId.setVisible(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == frm.guardarButton) {
            mod.setName(frm.txtNombre.getText());
            mod.setEmail(frm.txtEmail.getText());
            mod.setPhone(frm.txtPhone.getText());
            mod.setAddress(frm.txtAddress.getText());
            //mod.setPassword(frm.txt.getText());

            if (modC.registrar(mod)) {
                JOptionPane.showMessageDialog(null, "Registro guardado");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Error al guardar");
                limpiar();
            }
        }

        if (e.getSource() == frm.modificarButton) {
            mod.setId(Integer.parseInt(frm.txtId.getText()));
            mod.setName(frm.txtNombre.getText());
            mod.setEmail(frm.txtEmail.getText());
            mod.setPhone(frm.txtPhone.getText());
            mod.setAddress(frm.txtAddress.getText());
            //mod.setPassword(frm.txt.getText());

            if (modC.registrar(mod)) {
                JOptionPane.showMessageDialog(null, "Registro modificado");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Error al modificar");
                limpiar();
            }
        }

        if (e.getSource() == frm.eliminarButton) {
            mod.setId(Integer.parseInt(frm.txtId.getText()));

            if (modC.eliminar(mod)) {
                JOptionPane.showMessageDialog(null, "Registro eliminado");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Error al eliminar");
                limpiar();
            }
        }

        if (e.getSource() == frm.buscarButton) {
            mod.setPhone(frm.txtPhone.getText());

            if (modC.buscar(mod)) {
                frm.txtId.setText(String.valueOf(mod.getId()));
                frm.txtNombre.setText(mod.getName());
                frm.txtEmail.setText(mod.getEmail());
                frm.txtPhone.setText(mod.getPhone());
                frm.txtAddress.setText(mod.getAddress());
            } else {
                JOptionPane.showMessageDialog(null, "No se encontro registro");
                limpiar();
            }
        }

        if (e.getSource() == frm.limpiarButton) {
            limpiar();
        }
    }

    public void limpiar() {
        frm.txtId.setText(null);
        frm.txtNombre.setText(null);
        frm.txtEmail.setText(null);
        frm.txtPhone.setText(null);
        frm.txtAddress.setText(null);
    }

}
