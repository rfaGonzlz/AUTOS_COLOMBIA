package edu.iudigital;
import java.time.LocalDateTime;
import java.util.Scanner;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        VehiculoDAO vehiculoDAO = new VehiculoDAO();
        CeldaDAO celdaDAO = new CeldaDAO();

        int opcion;

        do{

            System.out.println("\n=== AUTOS COLOMBIA ===");
            System.out.println("1 Registrar Vehiculo");
            System.out.println("2 Registrar Entrada");
            System.out.println("3 Salir");

            opcion = sc.nextInt();
            sc.nextLine();

            switch(opcion){

                case 1:

                    System.out.print("Placa: ");
                    String placa = sc.nextLine();

                    System.out.print("Tipo: ");
                    String tipo = sc.nextLine();

                    System.out.print("Marca: ");
                    String marca = sc.nextLine();

                    System.out.print("Color: ");
                    String color = sc.nextLine();

                    Vehiculo v = new Vehiculo(placa,tipo,marca,color);

                    vehiculoDAO.guardarVehiculo(v);

                    break;

                case 2:

                    System.out.print("Placa: ");
                    String placaEntrada = sc.nextLine();

                    if(!vehiculoDAO.existeVehiculo(placaEntrada)){
                        System.out.println("Vehiculo no registrado");
                        break;
                    }

                    Integer celda = celdaDAO.buscarCeldaLibre();

                    if(celda==null){
                        System.out.println("No hay celdas disponibles");
                    }else{

                        celdaDAO.ocuparCelda(celda);

                        System.out.println("Vehiculo ingresado en celda "+celda);

                    }

                    break;

            }

        }while(opcion!=3);



    }
}