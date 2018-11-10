import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class BazaDanych implements Database {
    private final ArrayList<String> productslist = new ArrayList<>();
    private final ArrayList<String> sellerlist = new ArrayList<>();
    private final ArrayList<String> contractorslist = new ArrayList<>();
    private final ArrayList<String[]> goodproductslist = new ArrayList<>();
    private final String[] tabContractors = new String[3];
    private final String[] tabSellers = new String[3];
    private final String[] tabProducts = new String[4];

    private int counter;
    private int indexofProducts = 0;


    public BazaDanych(){
        addCounter();
        addProducts();
        CreateTabeOfProducts();
        addContractors();
        addSellers();
        FillTableOfSellers();
        FillTableOfContractors();
    }
    @Override
    public String getKontrahentName() {
        return tabContractors[0];
    }

    @Override
    public String getKontrahentSurname() {
        return tabContractors[1];
    }

    @Override
    public String getKontrahentAddress() {
        return tabContractors[2];
    }

    @Override
    public String getSprzedawcaName() {
        return tabSellers[0];
    }

    @Override
    public String getSprzedawcaSurname() {
        return tabSellers[1];
    }

    @Override
    public String getSprzedawcaAddress() {
        return tabSellers[2];
    }

    @Override
    public String getProdukt() {
        if(goodproductslist.size() == 0){return null;}
        String tab[] = goodproductslist.get(indexofProducts);
        indexofProducts++;
        if(indexofProducts == 8 ){return null;}
        return tab[0]+"  "+tab[1]+"  "+tab[2]+"  "+tab[3];
    }

    private String cutting(String nazwa) {
        int i = 0;
        while (nazwa.charAt(i) != '$') {
            i++;
        }
        return nazwa.substring(0, i);
    }

    private String cutting2(String nazwa) {
        int i = 0;
        while (nazwa.charAt(i) != '$') {
            i++;
        }
        return nazwa.substring(i + 1);
    }

    private void addSellers() {
        try {
            ObjectInputStream os = new ObjectInputStream((new FileInputStream("src/zapis/ListofSprzedawcy.ser")));
            ArrayList<String> a = (ArrayList<String>) os.readObject();
            sellerlist.add(a.get(0));
            os.close();

        } catch (Exception e2x) {
            e2x.printStackTrace();
        }
    }

    private void addContractors() {
        try {
            ObjectInputStream os = new ObjectInputStream((new FileInputStream("src/zapis/ListofKontrahenci.ser")));
            @SuppressWarnings("unchecked") ArrayList<String> a = (ArrayList<String>) os.readObject();
            contractorslist.add(a.get(0));
            os.close();

        } catch (Exception e2x) {
            e2x.printStackTrace();
        }
    }

    private void addCounter() {
        try {
            ObjectInputStream os = new ObjectInputStream((new FileInputStream("src/zapis/Licznik.ser")));
            counter = (int)os.readObject();
            os.close();
        } catch (Exception e2x) {
            e2x.printStackTrace();
        }
    }

    private void addProducts() {
        try {
            for (int i = 0; i <= counter; i++) {
                String in = "src/zapis/ListofProdukty" + i + ".ser";
                ObjectInputStream os = new ObjectInputStream((new FileInputStream(in)));
                ArrayList<String> a = (ArrayList<String>) os.readObject();
                productslist.add(a.get(0));
                os.close();
            }

        } catch (Exception e2x) {
            e2x.printStackTrace();
        }
    }

    private void FillTableOfContractors(){
        String kod = contractorslist.get(0);
        tabContractors[0] = cutting(kod);
        kod = cutting2(kod);
        tabContractors[1] = cutting(kod);
        kod = cutting2(kod);
        tabContractors[2] = cutting(kod);
    }

    private void FillTableOfSellers(){
        String kod = sellerlist.get(0);
        tabSellers[0] = cutting(kod);
        kod = cutting2(kod);
        tabSellers[1] = cutting(kod);
        kod = cutting2(kod);
        tabSellers[2] = cutting(kod);
    }

    private void CreateTabeOfProducts() {
        String nazwa,cena,jm,ilosc;
        for (int i = 0; i < productslist.size(); i++) {
            String kod = productslist.get(i);
            tabProducts[0] = cutting(kod);//nazwa
            kod = cutting2(kod);
            tabProducts[1] = cutting(kod);//cena
            kod = cutting2(kod);
            tabProducts[2] = cutting(kod);//jm
            kod = cutting2(kod);
            tabProducts[3] = cutting(kod);//ilość
            goodproductslist.add(tabProducts);
        }

    }
}