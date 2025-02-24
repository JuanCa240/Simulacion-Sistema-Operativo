package SO;

public class Hilo extends Thread{
    private String nombre;

    public Hilo(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }
   
    @Override
    public void run() {
        System.out.println("el Hilo 1 " + nombre + " esta en ejecucion...");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            System.out.println("el Hilo 2 " + nombre + " ha sido interrumpido");
        }
        System.out.println(" el Hilo " + nombre + " ha terminado");
    }

    public void crearHilo() {
        System.out.println("el Hilo ha sido creado con el nombre: " + nombre);
    }

    public void ejecutarHilo() {
        System.out.println("ejecutando el Hilo " + nombre);
        this.start();
    }

    public void terminarHilo() {
        System.out.println("el Hilo ha sido finalizado" + nombre);
        this.interrupt();
    }
   
}
