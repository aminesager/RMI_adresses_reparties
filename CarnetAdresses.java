import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface CarnetAdresses extends Remote {
    void ajouterContact(String nom, String numero) throws RemoteException;
    void supprimerContact(String nom) throws RemoteException;
    String rechercherContact(String nom) throws RemoteException;
    List<String> listerContacts() throws RemoteException;
    void modifierContact(String nom, String newNum) throws RemoteException;

}
