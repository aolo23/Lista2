import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
/**
 * The class that stores verified data from the seller window
 */
public class SellersGoodData {

    private String FirstName;
    private String LastName;
    private String Address;
    private final ArrayList<String> ListOfSellers = new ArrayList<>();

    public void CreateSprzedawcy(){
        String sprzedawcy = getFirstName()+"$"+getLastName()+"$"+getAddress()+"$";
        ListOfSellers.add(sprzedawcy);
    }

    private String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String FirstName) { this.FirstName = FirstName; }

    private String getAddress() {
        return Address;
    }

    public void setAddress(String adres) {
        this.Address = adres;
    }

    private String getLastName() {
        return LastName;
    }

    public void setLastName(String LastName) {
        this.LastName = LastName;
    }

    public void SaveObjectOfSprzedawcy(){
        try {
            String save = "src/zapis/ListofSprzedawcy.ser";
            FileOutputStream fs = new FileOutputStream(save);
            ObjectOutputStream os = new ObjectOutputStream(fs);
            os.writeObject(ListOfSellers);
            os.close();
        } catch (Exception ex1) {
            ex1.printStackTrace();
        }
    }
}