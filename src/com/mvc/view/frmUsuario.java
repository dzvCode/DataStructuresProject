package com.mvc.view;

import javax.swing.*;
import java.awt.*;

public class frmUsuario extends JDialog{
    public JTextField txtNombre;
    public JTextField txtEmail;
    public JTextField txtPhone;
    public JTextField txtAddress;
    public JButton buscarButton;
    public JButton guardarButton;
    public JButton modificarButton;
    public JButton eliminarButton;
    public JButton limpiarButton;
    public JTextField txtId;
    public JPanel panelUsuario;
    public JTextField txtPassword;

    public frmUsuario(JFrame parent) {
        super(parent);
        setTitle("Registar usuairio");
        setContentPane(panelUsuario);
        setMinimumSize(new Dimension(800, 600));
        setModal(true);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }
}
