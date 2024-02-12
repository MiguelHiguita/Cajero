package org.example;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner leer=new Scanner(System.in);

        String nombreUsuario;
        String nombreUsuarioBD="pepe";
        String contrasenaUsuario;
        String contrasenaUsuarioBD="123";
        String opcion;
        String nombreCuentaExterna;
        Integer intentosFallidos=0;
        Integer saldo=0;
        Integer retirar;
        Integer consignar;
        Integer transferir;


        System.out.println("\n*****Bienvenido a banco bbva*****");

        do {

            System.out.println("\nDigite su usuario: ");
            nombreUsuario = leer.nextLine();

            if (nombreUsuario.equals(nombreUsuarioBD)) {
                //pedir contraseña
                System.out.println("Digite su contraseña: ");
                contrasenaUsuario = leer.nextLine();
                if (contrasenaUsuario.equals(contrasenaUsuarioBD)) {
                    //Ingresando
                    System.out.println("Bienvenido, "+nombreUsuario);
                    System.out.println("¿Que desea hacer?");
                    System.out.println("Digite 1 para consultar saldo");
                    System.out.println("Digite 2 para retirar saldo");
                    System.out.println("Digite 3 para consignar saldo");
                    System.out.println("Digite 4 para transferir saldo");
                    opcion= leer.nextLine();
                    if (opcion.equals("1")){

                        //Consultar saldo
                        System.out.println("Su saldo es de: "+saldo);

                    }else if (opcion.equals("2")){

                        //Retirar saldo
                        System.out.println("Digite la cantidad que desea retirar");
                        retirar= leer.nextInt();
                        if (retirar<=saldo){
                            //Retirar
                            System.out.println("Retiro Exitoso");
                            saldo=saldo-retirar;
                        }else{
                            //Saldo insuficiente
                            System.out.println("Saldo insuficiente");
                        }

                    }else if (opcion.equals("3")){

                        //consignar saldo
                        System.out.println("Digite la cantidad que desea consignar");
                        consignar=leer.nextInt();

                        saldo=saldo+consignar;

                        System.out.println("Consigna Exitosa");

                    }else if (opcion.equals("4")) {
                        //transferir saldo

                        System.out.println("Digite el nombre de la cuenta a transferir: ");
                        nombreCuentaExterna= leer.nextLine();

                        System.out.println("Digite la cantidad a transferir a: "+nombreCuentaExterna);
                        transferir= leer.nextInt();

                        if (transferir<=saldo){
                            System.out.println("Transferencia Exitosa");
                            saldo=saldo-transferir;
                        }else{
                            System.out.println("saldo insuficiente");
                        }

                    }else{
                        System.out.println("Digite una opcion valida.");
                    }
                } else {
                    //contraseña inmcorrecta
                    System.out.println("Contraseña incorrecta");
                    intentosFallidos = intentosFallidos + 1;
                }
            } else {
                //Usuario incorrecto
                System.out.println("Nombre de Usuario Incorrecto");
                intentosFallidos = intentosFallidos + 1;
            }

        }while (intentosFallidos<3);

        System.out.println("Demasiados intentos, intentelo denuevo mas tarde");

    }
}