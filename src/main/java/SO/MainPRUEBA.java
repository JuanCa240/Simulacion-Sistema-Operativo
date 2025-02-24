package SO;

import java.util.Scanner;


public class MainPRUEBA {
      private Scanner teclado;

    public MainPRUEBA() {
        this.teclado = teclado;
    }
    
    public void correrSO(){
        boolean iniciar = true;
        while(iniciar){
            System.out.println("Simulacion SO");
            System.out.println("1.) Crear Archivo TXT:");
            System.out.println("2.) Escribir en el archivo");
            System.out.println("3.) Kill:");
            System.out.println("4.) Listar Procesos:");
            System.out.println("5.) Salir:");
            
            System.out.print("\nIngrese una opcion: ");
            String opcion = teclado.nextLine();

            switch(opcion){
                case "1":
                
                    break;
                
                case "2":
                   
                    break;
                
                case "3":
                   
                    break;
                
                case "4":
                   
                    break;
                
                case "5":
                    System.out.println("Saliendo del Sistema Operativo....");
                    iniciar = false;
                    
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
