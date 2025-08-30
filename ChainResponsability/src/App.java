import Servicios.*;

public class App {
    public static void main(String[] args) throws Exception {
        Handler cienMil = new CienMilHandler();
        Handler cincuentaMil = new CincuentaMilHandler();
        Handler veinteMil = new VeinteMilHandler();
        Handler diezMil = new DiezMilHandler();
        Handler cincoMil = new CincoMilHandler();

        // Construcción de la cadena
        cienMil.setNext(cincuentaMil);
        cincuentaMil.setNext(veinteMil);
        veinteMil.setNext(diezMil);
        diezMil.setNext(cincoMil);

        System.out.printf ("Procesando para $375.000 \n\n");
        cienMil.handle(375000);

        System.out.printf("------------------------------- \n\n");
        System.out.printf("Procesando para $45.000 \n\n");
        cienMil.handle(45000);
    }
}
