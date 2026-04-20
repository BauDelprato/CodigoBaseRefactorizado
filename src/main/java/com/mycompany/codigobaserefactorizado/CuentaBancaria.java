
package com.mycompany.codigobaserefactorizado;

class CuentaBancaria {
    private String titular;
    private double saldo;

    public CuentaBancaria(String titular, double saldo) {
        this.titular = titular;
        this.saldo = saldo;
    }

    public void depositar(double monto) {
        saldo += monto;
    }

    public void retirar(double monto) {
        if (saldo >= monto) saldo -= monto;
    }

    // Getters para que otras clases lean la info
    public String getTitular() { return titular; }
    public double getSaldo() { return saldo; }
}
