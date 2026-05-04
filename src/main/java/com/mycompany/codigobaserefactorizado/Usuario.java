package com.mycompany.codigobaserefactorizado;

public abstract class Usuario {
    private int ID;
    private String nombre;
    private String contrasena;

    public Usuario(int ID, String nombre, String contrasena) {
        this.ID = ID;
        this.nombre = nombre;
        this.contrasena = contrasena;
    }

    public int getID() {
        return ID;
    }

    public String getNombre() {
        return nombre;
    }
    public boolean validarContrasena(String intento) {
        return this.contrasena.equals(intento);
    }
}
