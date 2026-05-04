
package com.mycompany.codigobaserefactorizado;

public abstract class CuentaBancaria {
    protected String numeroCuenta;
    protected Usuario titular;
    protected double saldo;

    public CuentaBancaria(String numeroCuenta, Usuario titular) {
        this.numeroCuenta = numeroCuenta;
        this.titular = titular;
        this.saldo = 0.0;
    }

    public void depositar(double monto) {
        saldo += monto;
    }

    public abstract boolean retirar(double monto);

    // Getters para que otras clases lean la info
    public Usuario getTitular() { return titular; }
    public double getSaldo() { return saldo; }
    public String getNumeroCuenta() {return numeroCuenta;}
}
