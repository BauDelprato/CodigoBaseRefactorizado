package com.mycompany.codigobaserefactorizado;

public class UsuarioEstandar extends Usuario{
    public UsuarioEstandar(int ID, String nombre, String contrasena) {
        super(ID, nombre, contrasena);
    }

    @Override
    public double calcularRecargo(double monto) {
        return monto * 0.02;
    }
}
