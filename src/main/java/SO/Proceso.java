package SO;

import java.util.ArrayList;

public class Proceso {
    private int contadorProceso;
    private String unicoID;
    private String nombreProceso;
    private String estado;
    private ArrayList<Hilo> hilos;

    public Proceso(String unicoID, String nombreProceso) {
        this.unicoID = unicoID;
        this.nombreProceso = nombreProceso;
        this.estado = "Esperando"; //Estado inicial
        this.hilos = new ArrayList<>();
    }
    

    public int getContadorProceso() {
        return contadorProceso;
    }

    public String getUnicoID() {
        return unicoID;
    }
    
    public String getNombreProceso() {
        return nombreProceso;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    public void crearHilo(String nombreHilo, SistemaOperativo sistema, String nombreArchivo) {
        Hilo nuevoHilo = new Hilo(nombreHilo, sistema, nombreArchivo);
        hilos.add(nuevoHilo);
        nuevoHilo.start(); // Iniciar el hilo automáticamente
        System.out.println("Hilo '" + nombreHilo + "' creado y en ejecución en el proceso '" + nombreProceso + "'.");
    }
    
    public ArrayList<String> listarHilos(){
        ArrayList<String> nombresHilos = new ArrayList<>();
        for (int i = 0; i < hilos.size(); i++) {
            nombresHilos.add(hilos.get(i).getNombre());
        }
        return nombresHilos;
    }
}
