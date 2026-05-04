
package com.mycompany.codigobaserefactorizado;

public abstract class ServicioNotificaciones {
    public void enviar(String titular, String mensaje) {
        System.out.println("Enviando a " + titular + ": " + mensaje);
    }
}

