package com.mycompany.codigobaserefactorizado;

import java.util.List;
import java.util.Scanner;

public class Menu {
    GestorTransacciones gestorTransacciones;
    GestorUsuario gestorUsuarios;
    ImpresoraCuenta impresora;
    Scanner sc = new Scanner(System.in);
    List<CuentaBancaria> cuentasBancarias;

    public Menu(GestorTransacciones gestorTransacciones, GestorUsuario gestorUsuarios, ImpresoraCuenta impresora) {
        this.gestorTransacciones = gestorTransacciones;
        this.gestorUsuarios = gestorUsuarios;
        this.impresora = impresora;
        this.sc = sc;
        this.cuentasBancarias = cuentasBancarias;
    }

    public void iniciar() {
        boolean salir = false;
        while (!salir) {
            System.out.println("BANCO:");
            System.out.println("1. Ingresar a su cuenta");
            System.out.println("2. Crear una cuenta");
            System.out.println("3. Salir");
            int menu1 = sc.nextInt();

            switch (menu1) {
                case 1:
                    login();
                    break;
                case 2:
                    register();
                    break;
                case 3:
                    System.out.println("Saliendo del banco...Gracias");
                    salir = true;
                    break;
                case 4:
                    System.out.println("Opcion inválida. Ingrese un número válido.");
            }
        }
    }

    private void register() {
        System.out.println("CREAR USUARIO");
        System.out.print("Ingrese un ID de usuario (ej su DNI): ");
        int id = sc.nextInt();
        System.out.print("Ingrese su nombre y apellido: ");
        String nombre = sc.nextLine();
        System.out.print("Ingrese una contraseña: ");
        String pass = sc.nextLine();
        System.out.println("Tipo de Usuario: 1. Estándar, 2. Premium");
        int tipoUser = sc.nextInt();

        Usuario nuevoUsuario;
        if (tipoUser == 2) {
            nuevoUsuario = new UsuarioPremium(id, nombre, pass);
        } else {
            nuevoUsuario = new UsuarioEstandar(id, nombre, pass);
        }
        gestorUsuarios.registrarUsuario(nuevoUsuario);

        System.out.print("Ingrese un número para su cuenta: ");
        String nroCuenta = sc.nextLine();

        System.out.println("Tipo de Cuenta: 1. Caja de Ahorro | 2. Cuenta Corriente");
        int tipoCuenta = sc.nextInt();

        CuentaBancaria nuevaCuenta;
        if (tipoCuenta == 2) {
            nuevaCuenta = new CuentaCorriente(nroCuenta, nuevoUsuario, 10000.0);
        } else {
            nuevaCuenta = new CuentaAhorro(nroCuenta, nuevoUsuario);
        }

        cuentasBancarias.add(nuevaCuenta);

        System.out.println("Cuenta creada con éxito!!");
    }

    private void login() {
        System.out.println("Iniciar Sesión");
        System.out.print("ID de usuario: ");
        int id = sc.nextInt();
        System.out.print("Contraseña: ");
        String pass = sc.nextLine();

        Usuario usuarioLogueado = gestorUsuarios.iniciarSesion(id, pass);

        if (usuarioLogueado != null) {
            CuentaBancaria miCuenta = null;
            for (CuentaBancaria c : cuentasBancarias) {
                if (c.getTitular().getID() == usuarioLogueado.getID()) {
                    miCuenta = c;
                    break;
                }
            }

            if (miCuenta != null) {
                menuCuenta(miCuenta);
            } else {
                System.out.println("Error: El usuario no tiene cuenta.");
            }
        } else {
            System.out.println("Credenciales incorrectas");
        }
    }

    private void menuCuenta(CuentaBancaria cuenta) {
        boolean salir = false;
        while (!salir) {
            System.out.println("1. Ver saldo");
            System.out.println("2. Ingresar dinero");
            System.out.println("3. Sacar dinero");
            System.out.println("4. Cambiar metodo de notificacion (Wpp/Mail)");
            System.out.println("5. Cerrar sesion");
            int menu2 = sc.nextInt();

            switch (menu2) {
                case 1:
                    impresora.imprimirDetalles(cuenta);
                    break;
                case 2:
                    System.out.print("Monto a ingresar: $");
                    double ingreso = sc.nextDouble();
                    gestorTransacciones.realizarDeposito(cuenta, ingreso);
                    break;
                case 3:
                    System.out.print("Monto a sacar: $");
                    double retiro = sc.nextDouble();
                    gestorTransacciones.realizarRetiro(cuenta, retiro);
                    break;
                case 4:
                    System.out.println("1. WhatsApp, 2. Email");
                    int notif = sc.nextInt();
                    if (notif == 1) {
                        gestorTransacciones.setNotificador(new NotificacionWhatsapp());
                        System.out.println("Notificaciones configuradas por WhatsApp.");
                    } else {
                        gestorTransacciones.setNotificador(new NotificacionMail());
                        System.out.println("Notificaciones configuradas por Email.");
                    }
                    break;
                case 5:
                    salir = true;
                    System.out.println("cerraste sesion");
                    break;
                default:
                    System.out.println("opcion invalida. Ingrese un número válido");
            }
        }
    }
}