
package com.mycompany.codigobaserefactorizado;

class ImpresoraCuenta {
    public void imprimirDetalles(CuentaBancaria cuenta) {
        System.out.println("Titular: " + cuenta.getTitular());
        System.out.println("Saldo actual: $" + cuenta.getSaldo());
    }
}
