package mundopc;

import mundopc.modelo.Computadora;
import mundopc.modelo.Monitor;
import mundopc.modelo.Raton;
import mundopc.modelo.Teclado;
import mundopc.servicio.Orden;

public class VentaComputadorasApp {
    public static void main(String[] args) {

        Raton ratonLenovo = new Raton("usb","Lenovo");

        Teclado tecladoLenovo = new Teclado("usb", "Lenovo");

        Monitor monitorLenovo = new Monitor("Lenovo", 26);

        Computadora computadoraLenovo = new Computadora("Computadora Lenovo", monitorLenovo, tecladoLenovo, ratonLenovo);


        Orden orden1 = new Orden();
        orden1.agregarComputadora(computadoraLenovo);
        orden1.mostrarOrden();

        //Herencia, POO, relacion entre clases, sobreescritura de metodos

    }
}
