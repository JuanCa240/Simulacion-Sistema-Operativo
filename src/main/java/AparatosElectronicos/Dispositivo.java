package AparatosElectronicos;

import SO.Proceso;


public class Dispositivo {
    private Proceso proceso;
    protected String tipoDispositivo;

    public Dispositivo(String tipoDispositivo) {
        this.tipoDispositivo = tipoDispositivo;
    }

    public String getTipoDispositivo() {
        return tipoDispositivo;
    }
    
    public void procesarTexto(String texto, Proceso proceso) {
        System.out.println("Proceso '" + proceso.getNombreProceso() + "' envio texto a " + tipoDispositivo + ": " + texto);
    }
}
