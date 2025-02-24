package SO;

import AparatosElectronicos.Dispositivo;
import AparatosElectronicos.Impresora;
import AparatosElectronicos.Monitor;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class SistemaOperativo {
    private ArrayList<Proceso> procesos;
    private String nombreArchivo;

    public SistemaOperativo(String nombreArchivo) {
        procesos = new ArrayList<>();
    }
    
    public void crearProceso(String id, String nombreProceso){
        for (int i = 0; i < procesos.size(); i++) {
            if (procesos.get(i).getNombreProceso().equals(nombreProceso)) {
                System.out.println("Error: Ya existe un proceso con el nombre '" + nombreProceso + "'.");
                return;
            }
        }
        
        Proceso nuevoProceso = new Proceso(id,nombreProceso);
        procesos.add(nuevoProceso);
        System.out.println("Se ha creado el '" + nombreProceso + "'\n");
    }
    
    public ArrayList<Proceso> listarProceso(){
       return procesos;
    }
    
    //busca en el arreglo de procesos si se estan ejecutando o no. 
    public void ejecutarProceso(String nombre){
       boolean encontrado = false;
       if(procesos.isEmpty())
           System.out.println("No hay Procesos en ejecucion");
       
       else{
        for(int i = 0; i < procesos.size(); i++){
           Proceso proceso = procesos.get(i);  //Obtener el proceso de la lista

            if(proceso.getNombreProceso().equals(nombre)){
                if(proceso.getEstado().equals("Ejecutando"))
                    System.out.println("Proceso " + nombre + " ya está en ejecución");
                else{
                   proceso.setEstado("Ejecutando");
                   System.out.println("Ejecutando proceso... " + nombre + "\n");
                }
                 encontrado = true;
                 break; // aqui para el bucle
            }
        }
        if (!encontrado)
             System.out.println("No se encontró el proceso '" + nombre + "'.");
          
       }
   }
   
    public void terminarProceso(String nombre) {
        boolean encontrado = false;

        for (int i = 0; i < procesos.size(); i++) {
            Proceso proceso = procesos.get(i);

            if (proceso.getNombreProceso().equals(nombre)) {
           
                if (proceso.getEstado().equals("Ejecutando") || proceso.getEstado().equals("Esperando")) {
                    proceso.setEstado("Terminado");
                    procesos.remove(i); 
                    System.out.println("Terminando proceso... '" + nombre + "'\n.");
                    return; 
                } else {
                    System.out.println("El proceso '" + nombre + "' ya estaba terminado.");
                    return; // No seguir buscando
                }
            }
        }

        System.out.println("No se encontró el proceso.");
    }
    
    public void CrearArchivo(String nombreArchivo){
        try {
            File archivo = new File(nombreArchivo);
            if (archivo.createNewFile()) 
                System.out.println("Archivo creado correctamente !: '" + archivo.getName() + "' \n");
            else 
                System.out.println("El archivo ya fue creado");
            
        } catch (IOException e) {
            System.out.println("Error al crear el archivo");
            e.printStackTrace();
        }
    }
    public synchronized void escribirArchivo(String contenido, String nombreArchivo){
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(nombreArchivo,true))) {
            bw.write(contenido);
            bw.newLine();
        } catch (IOException e) {
            System.out.println("Error al escribir en el archivo: " + e.getMessage());
        }
    }
   
    public void leerArchivo(String nombreArchivo){
        try {
            FileReader lector = new FileReader(nombreArchivo);
            BufferedReader bufferedReader = new BufferedReader(lector);
            String linea;
            
            System.out.println("Contenido del archivo: ");
            while ((linea = bufferedReader.readLine()) != null) {
                System.out.println(linea);
            }
            bufferedReader.close();
        } catch (IOException e) {
            System.out.println("Error al leer el archivo");
            e.printStackTrace();
        }
    }
   
    public void enviarImpresion(Dispositivo dispositivo, String texto, String nombreProceso) {
        boolean encontrado = false;
        
         if (!encontrado) 
            System.out.println("No se encontro el proceso '" + nombreProceso + "'.");

        for (int i = 0; i < procesos.size(); i++) {
            Proceso proceso = procesos.get(i);
            if (proceso.getNombreProceso().equals(nombreProceso)) {
                encontrado = true;
                if (dispositivo.getClass() == Impresora.class) {
                    ((Impresora) dispositivo).imprimirTexto(texto, proceso);
                } else if (dispositivo.getClass() == Monitor.class) {
                    ((Monitor) dispositivo).mostrarTexto(texto, proceso);
                }
                break;
            }
        }
    }
}
