package SO;

import AparatosElectronicos.Dispositivo;
import AparatosElectronicos.Impresora;
import AparatosElectronicos.Monitor;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Menu {
    private SistemaOperativo SO;
    private Scanner teclado;
    private ArrayList<Proceso> procesos;
   
    public Menu(){
        teclado = new Scanner(System.in);
        procesos = new ArrayList<>();
        SO = new SistemaOperativo();
    }
   
    public void correrSimulacion(){
       
        while(true){
            System.out.println("Simulacion SO");
            System.out.println("1.) Crear Proceso:");
            System.out.println("2.) Ejecutar Proceso:");
            System.out.println("3.) Kill:");
            System.out.println("4.) Listar Procesos:");
            System.out.println("5.) Enviar texto a dispositivo:");
            System.out.println("6.) Salir:");
           
            System.out.print("\nIngrese una opcion: ");
            String opcion = teclado.nextLine();

            switch(opcion){
                case "1":
                    crearProceso();
                break;
               
                case "2":
                    ejecutarProceso();
                break;
               
                case "3":
                    kill();
                break;
               
                case "4":
                    listarProcesos();
                break;
               
                case "5":
                    enviarTextoADispositivo();
                    break;
                case "6":
                    System.out.println("Saliendo...");
                return;
            }
       
        }

    }
   
    public void crearProceso(){
        System.out.print("Ingrese el nombre al proceso: ");
        String nombreProceso = teclado.nextLine();
       
        String id = generarNumerosAleatorios();
       
        SO.crearProceso(id, nombreProceso);
        System.out.println("Se ha creado el '" + nombreProceso + "'\n");
    }
   
    public void ejecutarProceso(){
        System.out.print("Ingrese el nombre del proceso que desea buscar: ");
        String nombreProceso = teclado.nextLine();
       
        SO.ejecutarProceso(nombreProceso);
    }
   
    public void kill(){
        System.out.print("Escoga el nombre del proceso que desea terminar: ");
        String nombreProceso = teclado.nextLine();
       
        SO.terminarProceso(nombreProceso);
    }
   
    public void listarProcesos(){
          procesos = SO.listarProceso();
        if(procesos.isEmpty())
            System.out.println("No hay procesos en el sistema.");
        else{
            for(int i = 0; i < procesos.size(); i++){
                Proceso proceso = procesos.get(i);
                System.out.println("\nProceso ID: " + proceso.getUnicoID() +
                                   "\nNombre: " + proceso.getNombreProceso() +
                                   "\nEstado: " + proceso.getEstado());
            }
           
            System.out.println();
        }
    }
   
    //Generar 3 dígitos para los números aleatorios.
    public String generarNumerosAleatorios(){
        String resultado = " ";
        Random random = new Random();
       
        for(int i = 0; i < 3; i++){
            int digitos = random.nextInt(10);
            resultado += digitos;
        }
        return resultado;
    }
   
    public void enviarTextoADispositivo() {
        System.out.print("Ingrese el nombre del proceso que envia la solicitud: ");
        String nombreProceso = teclado.nextLine();

        System.out.print("Ingrese el texto a enviar: ");
        String texto = teclado.nextLine();

        System.out.print("Seleccione el dispositivo (1. Monitor, 2. Impresora): ");
        String opcion = teclado.nextLine();

        Dispositivo dispositivo = (opcion.equals("1")) ? new Monitor() : new Impresora();
        SO.enviarImpresion(dispositivo, texto, nombreProceso);
}
   
   
   
    public static void main(String[] args) {
        Menu m = new Menu();
        m.correrSimulacion();  
    }        
}
