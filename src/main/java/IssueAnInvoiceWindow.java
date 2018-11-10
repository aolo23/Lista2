import javax.swing.*;
import java.awt.*;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

class IssueAnInvoiceWindow extends JFrame {

    private final ArrayList<String> productslist = new ArrayList<>();
    private final ArrayList<String> sellerlist = new ArrayList<>();
    private final ArrayList<String> contractorslist = new ArrayList<>();
    private final String[] tabContractors = new String[3];
    private final String[] tabSellers = new String[3];
    private final Object[][] data = {
            {null, null, null, null, null, null, null, null}, {null, null, null, null, null, null, null, null},
            {null, null, null, null, null, null, null, null}, {null, null, null, null, null, null, null, null},
            {null, null, null, null, null, null, null, null}, {null, null, null, null, null, null, null, null},
            {null, null, null, null, null, null, null, null}, {null, null, null, null, null, null, null, null}
    };
    private double sum = 0;
    private int counter;
    private final String FormOfPayment;
    private final String TermOfPayment;
    private final String PlaceOfPayment;
    public IssueAnInvoiceWindow(String FormOfPayment,String TermOfPayment,String PlaceOfPayment) {

        this.FormOfPayment = FormOfPayment;
        this.TermOfPayment = TermOfPayment;
        this.PlaceOfPayment = PlaceOfPayment;

        setTitle("The invoice");
        setBounds(300, 50, 1350, 630);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        addCounter();
        addProducts();
        CreateTabeOfProducts();
        addContractors();
        addSellers();
        FillTableOfSellers();
        FillTableOfContractors();

        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Date currentDate = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(currentDate);

        JPanel fakturaPanel = new JPanel();
        fakturaPanel.setLayout(null);
        fakturaPanel.setBackground(new Color(166, 200, 192));
        fakturaPanel.setBounds(300, 50, 1350, 700);
        add(fakturaPanel);

        JLabel lDateofIssue = new JLabel("Date of issue:    " +dateFormat.format(currentDate));
        lDateofIssue.setFont(new Font("Arial", Font.BOLD, 15));
        lDateofIssue.setBounds(1080, 30, 400, 20);
        fakturaPanel.add(lDateofIssue);

        JLabel lPlaceofIssue = new JLabel("Place of issue:    " + PlaceOfPayment);
        lPlaceofIssue.setFont(new Font("Arial", Font.BOLD, 15));
        lPlaceofIssue.setBounds(1080, 51, 400, 30);
        fakturaPanel.add(lPlaceofIssue);

        JLabel lSeller = new JLabel("SELLER");
        lSeller.setFont(new Font("Arial", Font.BOLD, 18));
        lSeller.setForeground(new Color(25, 78, 200));
        lSeller.setBounds(25, 60, 300, 25);
        fakturaPanel.add(lSeller);

        JLabel lFirstName = new JLabel("First name: " + tabSellers[0]);
        lFirstName.setFont(new Font("Arial", Font.BOLD, 15));
        lFirstName.setBounds(25, 90, 300, 25);
        fakturaPanel.add(lFirstName);

        JLabel lLastName = new JLabel("Last name:  " + tabSellers[1]);
        lLastName.setFont(new Font("Arial", Font.BOLD, 15));
        lLastName.setBounds(25, 120, 300, 25);
        fakturaPanel.add(lLastName);

        JLabel lAddress = new JLabel("Address:   " + tabSellers[2]);
        lAddress.setFont(new Font("Arial", Font.BOLD, 15));
        lAddress.setBounds(25, 150, 400, 25);
        fakturaPanel.add(lAddress);

        JLabel lContractor = new JLabel("CONTRACTOR");
        lContractor.setFont(new Font("Arial", Font.BOLD, 18));
        lContractor.setForeground(new Color(25, 78, 200));
        lContractor.setBounds(25, 190, 300, 25);
        fakturaPanel.add(lContractor);

        JLabel lFirstName2 = new JLabel("First name: " + tabContractors[0]);
        lFirstName2.setFont(new Font("Arial", Font.BOLD, 15));
        lFirstName2.setBounds(25, 220, 300, 25);
        fakturaPanel.add(lFirstName2);

        JLabel lLastName2= new JLabel("Last name:  " + tabContractors[1]);
        lLastName2.setFont(new Font("Arial", Font.BOLD, 15));
        lLastName2.setBounds(25, 250, 300, 25);
        fakturaPanel.add(lLastName2);

        JLabel lAddress2 = new JLabel("Address:   " + tabContractors[2]);
        lAddress2.setFont(new Font("Arial", Font.BOLD, 15));
        lAddress2.setBounds(25, 280, 400, 25);
        fakturaPanel.add(lAddress2);

        String[] columnNames = {"Lp", "Name", "Unit of measure ", "Gross price", "Number", "VAT rate", "The value of VAT", "Net price"};
        JTable table = new JTable(data, columnNames);
        table.setFillsViewportHeight(true);
        table.setPreferredScrollableViewportSize(new Dimension(900, 300));
        table.setAutoCreateColumnsFromModel(true);
        table.setRowHeight(35);
        table.setFont(new Font("Arial", Font.BOLD, 15));
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(410, 130, 900, 300);
        fakturaPanel.add(scrollPane);

        JLabel jTogether = new JLabel("Together to pay:  "+sum);
        jTogether.setFont(new Font("Arial", Font.BOLD, 15));
        jTogether.setBounds(1000, 470, 300+150, 30);
        fakturaPanel.add(jTogether);

        JLabel PForm= new JLabel("Payment form:  "+FormOfPayment);
        PForm.setFont(new Font("Arial", Font.BOLD, 15));
        PForm.setBounds(1000, 500, 300, 30);
        fakturaPanel.add(PForm);

        c.add(Calendar.DATE, 15);
        Date currentDatePlusOne = c.getTime();

        JLabel PDate = new JLabel("Date of payment:  "+TermOfPayment);
        PDate.setFont(new Font("Arial", Font.BOLD, 15));
        PDate.setBounds(1000, 530, 400, 30);
        fakturaPanel.add(PDate);

        setVisible(true);
    }

    @SuppressWarnings("unchecked")
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

    @SuppressWarnings("unchecked")
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
            nazwa = cutting(kod);
            kod = cutting2(kod);
            cena = cutting(kod);
            kod = cutting2(kod);
            jm = cutting(kod);
            kod = cutting2(kod);
            ilosc = cutting(kod);
            data[i][0] = i + 1;
            data[i][1] = nazwa;
            data[i][2] = jm;
            data[i][3] = Double.parseDouble(cena) * Integer.parseInt(ilosc);
            data[i][4] = ilosc;
            data[i][5] = "23%";
            data[i][6] = Double.parseDouble(cena)* Integer.parseInt(ilosc) * (0.23);
            data[i][7] = Double.parseDouble(cena) * Integer.parseInt(ilosc) - Double.parseDouble(cena) * Integer.parseInt(ilosc) * (0.23);
            sum = sum +Double.parseDouble(cena)*Integer.parseInt(ilosc);
        }
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
}