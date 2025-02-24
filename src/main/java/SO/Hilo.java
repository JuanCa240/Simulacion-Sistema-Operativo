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
        try {
            for (int i = 0; i < 3; i++) {
                System.out.println(nombre + " ejecutando...");
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            System.out.println(nombre + " interrumpido.");
        }
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