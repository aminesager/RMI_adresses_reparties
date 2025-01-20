import java.rmi.registry.*;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;

public class ServeurCarnetAdresses  {
    HashMap<String, String> Adresses = new HashMap<>();
    private static final String PSW = "say my name";
    CarnetAdressesImpl carnet = new CarnetAdressesImpl(Adresses);

    public static void main(String[] args) {
        try {
            CarnetAdressesImpl CarnetAdressesImpl = new CarnetAdressesImpl(new HashMap<>());
            CarnetAdresses CarnetAdressesService = (CarnetAdresses) UnicastRemoteObject.exportObject(CarnetAdressesImpl, 0);
            Registry registre = LocateRegistry.createRegistry(1099); // Create registry if not existing
            registre.bind("Adresses", CarnetAdressesService);
            System.err.println("Serveur ok");
        } catch (Exception e) {
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
        }
    }
    
    public static boolean authentification(String password) {
        return PSW.equals(password);
    }
}
