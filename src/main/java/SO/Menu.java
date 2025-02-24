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
    private Proceso proceso;
    private Archivo archivo;
   
    public Menu(){
        teclado = new Scanner(System.in);
        procesos = new ArrayList<>();
        SO = new SistemaOperativo("");
    }
   
    public void correrSimulacion(){
       
        while(true){
            System.out.println("Simulacion SO");
            System.out.println("1.) Crear un archivoTXT");
            System.out.println("2.) Ejecutar Proceso:");
            System.out.println("3.) Kill:");
            System.out.println("4.) Listar Procesos:");
            System.out.println("5.) Listar Hilos de un Proceso");
            System.out.println("6.) Enviar texto a dispositivo:");
            System.out.println("7.) Salir:");
           
            System.out.print("\nIngrese una opcion: ");
            String opcion = teclado.nextLine();

            switch(opcion){
                case "1":
                    crearArchivoTXT();
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
                    listarHilos();
                    break;
                    
                case "6":
                    enviarTextoADispositivo();
                    break;
                    
                case "7":
                    System.out.println("Saliendo...");
                return;
            }
       
        }

    }
    
    public void crearArchivoTXT(){
        //Crear Proceso
        crearProceso();
        
        System.out.print("\nIngrese el nombre del archivo: ");
        String nombreArchivo = teclado.nextLine();
        
        archivo = new Archivo(nombreArchivo +".txt");
        
        SO.CrearArchivo(nombreArchivo + ".txt");
        
    }
   
    public void crearProceso(){
        System.out.print("Ingrese el nombre al proceso: ");
        String nombreProceso = teclado.nextLine();
       
        String id = generarNumerosAleatorios();
       
        SO.crearProceso(id, nombreProceso);
        
       
        System.out.println("¿Desea crear hilos? ");
        System.out.println("1.) Si");
        System.out.println("2.) No\n");

        String opcion = teclado.nextLine();
        switch(opcion){
            case "1":
                crearHilo();
            break;
                
            case "2":
                //Salir
              return;
        }
    }
    
    public void crearHilo() {
        System.out.print("Ingrese el nombre del proceso donde se creará el hilo: ");
        String nombreProceso = teclado.nextLine();

        for (int i = 0; i < procesos.size(); i++) {
            Proceso p = procesos.get(i);
            if (p.getNombreProceso().equals(nombreProceso)) {
                System.out.print("Ingrese el nombre del hilo: ");
                String nombreHilo = teclado.nextLine();
                p.crearHilo(nombreHilo);
                return;
            }
        }
        System.out.println("No está en ejecución el proceso'" + nombreProceso + "'.");
    }
    
    public void listarHilos() {
        System.out.print("Ingrese el nombre del proceso para listar sus hilos: ");
        String nombreProceso = teclado.nextLine();

        for (int i = 0; i < procesos.size(); i++) {
            Proceso p = procesos.get(i);
            if (p.getNombreProceso().equals(nombreProceso)) {
                ArrayList<String> hilos = p.listarHilos();
                if (hilos.isEmpty()) {
                    System.out.println("El proceso '" + nombreProceso + "' no tiene hilos.");
                } else {
                    System.out.println("Hilos del proceso '" + nombreProceso + "':");
                    System.out.println("\n");
                    for (int j = 0; j < hilos.size(); j++) {
                        System.out.println("- " + hilos.get(j));
                    }
                }
                return;
            }
        }
        System.out.println("No se encontró el proceso '" + nombreProceso + "'.");
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