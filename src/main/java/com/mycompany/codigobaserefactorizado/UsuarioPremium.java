package com.mycompany.codigobaserefactorizado;

public class UsuarioPremium extends Usuario{
    public UsuarioPremium(int ID, String nombre, String contrasena) {
        super(ID, nombre, contrasena);
    }

    @Override
    public double calcularRecargo(double monto) {
        return monto; //no tiene recargo  xq es premium
    }
}
