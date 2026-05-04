package com.mycompany.codigobaserefactorizado;

public class CuentaCorriente extends CuentaBancaria{
    private double limite;
    public CuentaCorriente(String numeroCuenta, Usuario titular, double limite) {
        super(numeroCuenta, titular);
        this.limite = limite;
    }

    @Override
    public boolean retirar(double monto) {
        if ((this.limite + this.saldo) >= monto){
            this.saldo -= monto;
        }
        return false;
    }
}
