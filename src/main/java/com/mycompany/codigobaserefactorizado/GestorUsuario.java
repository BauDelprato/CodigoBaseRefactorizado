package com.mycompany.codigobaserefactorizado;
import java.util.ArrayList;
import java.util.List;

public class GestorUsuario {
    private List<Usuario> bdUsuarios;

    public GestorUsuario() {
        this.bdUsuarios = new ArrayList<>();
    }

    public void registrarUsuario(Usuario nuevoUsuario) {
        bdUsuarios.add(nuevoUsuario);
    }

    public Usuario iniciarSesion(int id, String contrasena) {
        for (Usuario u : bdUsuarios) {
            if (u.getID() == id && u.validarContrasena(contrasena)) {
                return u;
            }
        }
        return null;
    }
}
