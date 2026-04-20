
package com.mycompany.codigobaserefactorizado;

public class AplicacionBancaria {
    public static void main(String[] args) {
        CuentaBancaria cuenta = new CuentaBancaria("Pepe", 1000);
        ServicioNotificaciones notificador = new ServicioNotificaciones();
        ImpresoraCuenta impresora = new ImpresoraCuenta();

        cuenta.depositar(500);
        impresora.imprimirDetalles(cuenta);
        notificador.enviarEmail(cuenta.getTitular(), "Depósito exitoso");
    }
}
