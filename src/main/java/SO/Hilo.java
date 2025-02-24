package SO;

public class Hilo extends Thread{
   private String nombre;
    private SistemaOperativo SO;
    private String nombreArchivo;
    private String estado;

    public Hilo(String nombre, SistemaOperativo SO, String nombreArchivo) {
        this.nombre = nombre;
        this.SO = SO;
        this.nombreArchivo = nombreArchivo;
        this.estado = "Esperando";
    }

    @Override
    public void run() {
        for (int i = 1; i <= 3; i++) {
            synchronized (SO) { // Bloqueo para evitar interferencias
                SO.escribirArchivo("Holaaaaa " + nombre, nombreArchivo);
            }
            try {
                Thread.sleep(1000); // Simula la interrupción
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Hilo " + nombre + "" + nombreArchivo);
    }

    public String getNombre() {
        return nombre;
    }

    public String getNombreArchivo() {
        return nombreArchivo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    } 
}