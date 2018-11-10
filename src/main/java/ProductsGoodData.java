import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
/**
 * The class that stores verified data from the Products window
 */
class ProductsGoodData {

    private String NameOfProductorService;
    private String Price;
    private String JM;
    private String Number;
    private int indexofarray;
    private final ArrayList<String> ListofProdukty = new ArrayList<>();
    private int counter;

    public void addProduct() {
        String products = getNameOfProductorService() + "$" + getPrice() + "$" + getJM() + "$" + getNumber() + "$";
        ListofProdukty.add(getindexofarray(), products);
        SaveObjectOfProduct();
        SaveCounter();
    }

    public ArrayList getListOfrodukty() {
        return ListofProdukty;
    }

    private String getNameOfProductorService() {
        return NameOfProductorService;
    }

    public void setNameOfProductorService(String NameOfProductorService) {
        this.NameOfProductorService = NameOfProductorService;
    }

    private String getPrice() {
        return Price;
    }

    public void setPrice(String Price) {
        this.Price = Price;
    }

    private String getNumber() {
        return Number;
    }

    public void setNumber(String Number) {
        this.Number = Number;
    }

    private String getJM() {
        return JM;
    }

    public void setJM(String JM) {
        this.JM = JM;
    }

    public void setindexofarray(int indexofarray) {
        this.indexofarray = indexofarray;
    }

    private int getindexofarray() {
        return indexofarray;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    private int getCounter() {
        return counter;
    }

    private void SaveObjectOfProduct() {
        try {
            String save = "src/zapis/ListofProdukty" + getCounter() + ".ser";
            ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(save));
            os.writeObject(ListofProdukty);
            os.close();
        } catch (Exception ex1) {
            ex1.printStackTrace();
        }
    }

    private void SaveCounter() {
        try {
            String save = "src/zapis/Licznik.ser";
            ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(save));
            os.writeObject(counter);
            os.close();
        } catch (Exception ex1) {
            ex1.printStackTrace();
        }
    }
}

