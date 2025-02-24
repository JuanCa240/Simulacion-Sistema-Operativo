package SO;

import java.io.IOException;
import java.util.Scanner;


public class MainPRUEBA {
      private Scanner teclado;
      private SistemaOperativo SO;
      private Archivo archivo;
      private Hilo hilo;

    public MainPRUEBA() {
        teclado = new Scanner(System.in);
    }
    
    public void correrSO(){
        while(true){
            System.out.println("Simulacion SO");
            System.out.println("1.) Crear Archivo TXT:");
            System.out.println("2.) Escribir hilos en el archivo");
            
            System.out.print("\nIngrese una opcion: ");
            String opcion = teclado.nextLine();

            switch(opcion){
                case "1":
                        
                    break;
                
                case "2":
                        
                    break;
                    
                case "3":
                    System.out.println("Saliendo del Sistema Operativo....");
                    
                    
                default:
                    System.out.println("ERROR, Ingrese una opcion válida");
                    break;
            }
        }
    }
    

    
 

    public static void main(String[] args) {
        MainPRUEBA m = new MainPRUEBA();
        m.correrSO();
    }   
}
