## Principio Aplicado: Responsabilidad Única (SRP)
Este código hace uso del principio de responsabilidad única dividiendo métodos que anteriormente se encontraban juntos en la clase CuentaBancaria,
dividiendo así responsabilidades a otras clases y evitando acoplamiento.

Por un lado la cuenta bancaria guarda unicamente el nombre del titular y un saldo junto con dos funciones para retirar o depositar cierto monto.
Por otro, la clase ImpresoraCuenta posee un método que imprime la información de una cuenta cualquiera, mostrando el nombre y el saldo por consola.
Y la clase ServicioNotificaciones envía un mensaje en forma de string a un titular en particular.
## Estructura
```
src/
│
└── mycompany/
    ├── NotificacionFactory.java
    ├── EmailFactory.java
    ├── EmailFactory.java
    └── SMSFactory.java
```
