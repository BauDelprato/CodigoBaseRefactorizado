
package com.mycompany.codigobaserefactorizado;

public class AplicacionBancaria {
    public static void main(String[] args) {
        GestorUsuario gestorUsuarios = new GestorUsuario();
        Notificador notificacionDefault = new NotificacionMail();
        GestorTransacciones gestorTransacciones = new GestorTransacciones(notificacionDefault);
        ImpresoraCuenta impresora = new ImpresoraCuenta();

        Menu menu = new Menu(gestorTransacciones, gestorUsuarios, impresora);
        menu.iniciar();
    }
}
