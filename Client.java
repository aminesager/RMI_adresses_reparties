import java.rmi.registry.*;
import java.util.List;

public class Client {
    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.getRegistry("localhost");
            CarnetAdresses carnetAdresses = (CarnetAdresses) registry.lookup("Adresses");
            List<String> contactsList;

            carnetAdresses.ajouterContact("ali", "1234");
            carnetAdresses.ajouterContact("iheb", "4321");

            System.out.println("Recherche ali: " + carnetAdresses.rechercherContact("ali"));

            carnetAdresses.supprimerContact("ali");

            contactsList = carnetAdresses.listerContacts();
            System.out.println("Contacts restants: " + contactsList);

            carnetAdresses.modifierContact("iheb", "9999");

            System.out.println("Recherche mohamed amine: " + carnetAdresses.rechercherContact("mohamed amine"));

            contactsList = carnetAdresses.listerContacts();
            System.out.println("Contacts restants apres modification: " + contactsList);

            carnetAdresses.ajouterContact("mohamed amine", "7777");
            carnetAdresses.ajouterContact("mohamed ali", "8888");
            carnetAdresses.ajouterContact("mohamed bechir", "6666");
            carnetAdresses.ajouterContact("examen tp reparties", "5555");
            carnetAdresses.ajouterContact("distributed systems", "1919");

        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
