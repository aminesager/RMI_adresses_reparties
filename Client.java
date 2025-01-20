
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
            String inputPassword = scanner.nextLine();
            if (!ServeurCarnetAdresses.auth(inputPassword)) {
                System.out.println("Mot de passe incorrect !");
                return;
            }
            Registry registry = LocateRegistry.getRegistry("localhost");
            CarnetAdresses CarnetAdressesService = (CarnetAdresses) registry.lookup("Adresses");
            List<String> contactsList;
            


            
            CarnetAdressesService.supprimerContact("ali");
            contactsList = CarnetAdressesService.listerContacts();
            System.out.println("avant de modifier");
            System.out.println("Contacts restants: " + contactsList);

            CarnetAdressesService.modifierContact("iheb", "9999");
            

            contactsList = CarnetAdressesService.listerContacts();
            System.out.println("apres de modifier");
            System.out.println("Contacts restants: " + contactsList);

            CarnetAdressesService.ajouterContact("mohamed amine", "7777" );
            CarnetAdressesService.ajouterContact("mohamed ali ", "8888" );
            CarnetAdressesService.ajouterContact("mohamed bechir", "6666" );
            CarnetAdressesService.ajouterContact("examen tp reparties", "94194" );

            contactsList = CarnetAdressesService.listerContacts();
            try {
                File Obj = new File("myfile.txt");
                FileWriter Writer = new FileWriter("myfile.txt", true);
                for (int i = 0 ; i < contactsList.size(); i++) {
                    Writer.write(contactsList.get(i) + "\n");
                } 
                Writer.close();
                System.err.println("le contenu du fichier: ");
                Scanner Reader = new Scanner(Obj);
                while (Reader.hasNextLine()) {
                    String data = Reader.nextLine();
                    System.out.println(data);
                }
                Reader.close();
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
