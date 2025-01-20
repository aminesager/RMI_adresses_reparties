import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CarnetAdressesImpl implements CarnetAdresses {
    private HashMap<String, String> Adresses;

    public CarnetAdressesImpl(HashMap<String, String> adresses) {
        this.Adresses = adresses;
    }

    @Override
    public void ajouterContact(String nom, String numero) throws RemoteException {
        Adresses.put(nom, numero);
    }

    @Override
    public void supprimerContact(String nom) throws RemoteException {
        Adresses.remove(nom);
    }

    @Override
    public String rechercherContact(String nom) throws RemoteException {
        return Adresses.getOrDefault(nom, "Contact non trouvé");
    }

    @Override
    public List<String> listerContacts() throws RemoteException {
        List<String> contacts = new ArrayList<>();
        for (Map.Entry<String, String> entry : Adresses.entrySet()) {
        contacts.add(entry.getKey() + " : " + entry.getValue());
        }
        return contacts;
    }

    
    @Override
    public void modifierContact(String nom, String nvNum) throws RemoteException {
        Adresses.put(nom, nvNum);
    }
}
