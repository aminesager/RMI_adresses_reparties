import java.rmi.registry.*;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;

public class ServeurCarnetAdresses {
    public static void main(String[] args) {
        try {
            CarnetAdressesImpl carnetAdressesService = new CarnetAdressesImpl(new HashMap<>());
            CarnetAdresses carnetAdresses = (CarnetAdresses) UnicastRemoteObject.exportObject(carnetAdressesService, 0);
            Registry registre = LocateRegistry.createRegistry(1099); // Create registry if not existing
            registre.bind("Adresses", carnetAdresses);
            System.err.println("Le serveur est en marche");
        } catch (Exception e) {
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
