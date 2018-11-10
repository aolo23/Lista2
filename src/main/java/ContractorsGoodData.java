import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class ContractorsGoodData {

    private String FirstName;
    private String LastName;
    private String Address;
    private final ArrayList<String> Contractorslist = new ArrayList<>();

    public void CreateKontrahenci(){
        String sprzedawcy = getFirstName()+"$"+getLastName()+"$"+getAddress()+"$";
        Contractorslist.add(sprzedawcy);
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

    public void SaveObjectOfKontrahenci(){
        try {
            String save = "src/zapis/ListofKontrahenci.ser";
            FileOutputStream fs = new FileOutputStream(save);
            ObjectOutputStream os = new ObjectOutputStream(fs);
            os.writeObject(Contractorslist);
            os.close();
        } catch (Exception ex1) {

            ex1.printStackTrace();
        }
    }
}