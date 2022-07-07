package com.grupo4.view;

import javax.swing.*;
import java.awt.*;

public class frmRegister extends JDialog {
    public JTextField txtDNI;
    public JTextField txtEmail;
    public JTextField txtName;
    public JTextField txtPhone;
    public JButton btnCancel;
    public JButton btnRegister;
    public JPanel panelRegister;
    public JTextField txtDestiny;

    public frmRegister(JFrame parent) {
        super(parent);
        setTitle("Registro de usuario");
        setContentPane(panelRegister);
        setMinimumSize(new Dimension(500, 500));
        setResizable(false);
        setModal(true);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }
}
