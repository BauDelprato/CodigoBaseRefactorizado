package com.mycompany.codigobaserefactorizado;

public class GestorTransacciones {
    private Notificador notificador;

    public GestorTransacciones(Notificador notificador) {
        this.notificador = notificador;
    }

    public void setNotificador(Notificador nuevoNotificador) {
        this.notificador = nuevoNotificador;
    }

    public void realizarDeposito(CuentaBancaria cuenta, double monto) {
        cuenta.depositar(monto);
        String mensaje = "Se deposiaron $" + monto + ". Saldo actual: $" + cuenta.getSaldo();
        notificador.enviar(mensaje, cuenta.getTitular());
    }

    public void realizarRetiro(CuentaBancaria cuenta, double monto) {
        boolean exito = cuenta.retirar(monto);
        if (exito) {
            String mensaje = "Extraccion exitosa de $" + monto + ". Saldo actual: $" + cuenta.getSaldo();
            notificador.enviar(mensaje, cuenta.getTitular());
        } else {
            String mensaje = "Intento de extraccion de $" + monto + " fallido. Saldo insuficiente o limite excedido.";
            notificador.enviar(mensaje, cuenta.getTitular());
        }
    }
}
