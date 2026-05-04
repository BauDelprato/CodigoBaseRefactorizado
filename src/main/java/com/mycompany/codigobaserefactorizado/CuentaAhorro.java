package com.mycompany.codigobaserefactorizado;

public class CuentaAhorro extends CuentaBancaria {
    public CuentaAhorro(String numeroCuenta, Usuario titular) {
        super(numeroCuenta, titular);
    }

    @Override
    public void depositar(double monto) {
        super.depositar(monto);
    }

    @Override
    public boolean retirar(double monto) {
       if (this.saldo >= monto){
           this.saldo -= monto;
           return true;
       }
       return false;
    }
}
