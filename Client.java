
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.rmi.registry.*;
import java.util.List;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("donner le mot de passe: ");
            String mdp_user = scanner.nextLine();
            if (!ServeurCarnetAdresses.authentification(mdp_user)) {
                System.out.println("Mot de passe incorrect !");
                return;
            }
            Registry registry = LocateRegistry.getRegistry("localhost");
            CarnetAdresses CarnetAdressesService = (CarnetAdresses) registry.lookup("Adresses");
            List<String> contactsList;
            

            System.err.println("essaye de differents methodes : ↓↓↓");
            //ajouter les contacts
            CarnetAdressesService.ajouterContact("mohamed amine", "7777" );
            CarnetAdressesService.ajouterContact("mohamed ali ", "8888" );
            CarnetAdressesService.ajouterContact("mohamed bechir", "6666" );
            CarnetAdressesService.ajouterContact("examen tp reparties", "94194" );
            System.out.println("avant de modifier :");
            contactsList = CarnetAdressesService.listerContacts();
            System.err.println(contactsList);
            
            //supression des contacts
            CarnetAdressesService.supprimerContact("mohamed ali");
            CarnetAdressesService.supprimerContact("mohamed bechir");
            System.out.println("apres:");
            contactsList = CarnetAdressesService.listerContacts();
            System.err.println(contactsList);

            CarnetAdressesService.modifierContact("mohamed amine", "0000");
            CarnetAdressesService.modifierContact("exmaen tp reparties", "0001");
            CarnetAdressesService.ajouterContact("mohamed aziz", "0002" );
            System.out.println("apres modifier:");
            contactsList = CarnetAdressesService.listerContacts();
            System.err.println(contactsList);

            

            
            


            try {
                File Obj = new File("myfile.txt");
                FileWriter Writer = new FileWriter("myfile.txt", true);
                for (int i = 0 ; i < contactsList.size(); i++) {
                    Writer.write(contactsList.get(i) + "\n");
                } 
                Writer.close();
            
            } catch (IOException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }



        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
