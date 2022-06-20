package org.datastructures.g4;

public class Main {
    public static void main(String[] args) {
        RegistrationForm myForm = new RegistrationForm(null);
        User user = myForm.user;
        if (user != null) {
            System.out.println("Registro exitoso de: " + user.name);
        } else {
            System.out.println("Registro cancelado");
        }
    }
}
