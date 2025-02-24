package AparatosElectronicos;

import SO.Proceso;


public class Monitor extends Dispositivo {
    public Monitor() {
        super("Monitor");
    }

    public void mostrarTexto(String texto, Proceso proceso) {
        procesarTexto(texto, proceso);
        System.out.println("Mostrando en pantalla... " + texto);
    }
}
