import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 * The class responsible for the appearance of the start window.
 */
class WindowApperance extends JFrame implements ActionListener {

    private final JButton AddTheSeller;
    private final JButton AddTheBuyer;
    private final JButton AddTheProduct;
    private final JButton IssueAnInvoice;
    private final JTextField term;
    private final JTextField tplace;
    private final JComboBox jComboBox ;

    public WindowApperance() {
        setTitle("InvoiceApp");
        setBounds(500, 200, 400, 450);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(new Color(162, 255, 151));
        panel.setBounds(300, 100, 400, 450);
        add(panel);

        JLabel add = new JLabel("Add the data needed to issue an invoice");
        add.setFont(new Font("Arial", Font.BOLD, 15));
        add.setBounds(35, 10, 350, 40);
        panel.add(add);

        JLabel seller  = new JLabel("Seller:");
        seller.setFont(new Font("Arial", Font.BOLD, 18));
        seller.setBounds(55, 50, 150, 40);
        panel.add(seller);

        AddTheSeller = new JButton("ADD");
        AddTheSeller.setBounds(200, 55, 70, 30);
        AddTheSeller.addActionListener(this);
        panel.add(AddTheSeller);

        JLabel Buyer = new JLabel("Contractor:");
        Buyer.setFont(new Font("Arial", Font.BOLD, 18));
        Buyer.setBounds(55, 90, 150, 40);
        panel.add(Buyer);

        AddTheBuyer = new JButton("ADD");
        AddTheBuyer.setBounds(200, 95, 70, 30);
        AddTheBuyer.addActionListener(this);
        panel.add(AddTheBuyer);

        JLabel product  = new JLabel("Product:");
        product.setFont(new Font("Arial", Font.BOLD, 18));
        product.setBounds(55, 130, 150, 40);
        panel.add(product);

        AddTheProduct = new JButton("ADD");
        AddTheProduct.setBounds(200, 135, 70, 30);
        AddTheProduct.addActionListener(this);
        panel.add(AddTheProduct);

        JLabel paymentform  = new JLabel("Payment form:");
        paymentform.setFont(new Font("Arial", Font.BOLD, 17));
        paymentform.setBounds(55, 180, 150, 40);
        panel.add(paymentform);

        String list[] = {"transfer","cash"};
        jComboBox = new JComboBox(list);
        jComboBox.setBounds(230, 185, 100, 30);
        jComboBox.addActionListener(this);
        panel.add(jComboBox);

        JLabel paymentterm = new JLabel("Date of payment:");
        paymentterm.setFont(new Font("Arial", Font.BOLD, 17));
        paymentterm.setBounds(55, 223, 200, 40);
        panel.add(paymentterm);

        term = new JTextField();
        term.setBounds(230, 228, 100, 30);
        panel.add(term);

        JLabel place= new JLabel("Place of issue:");
        place.setFont(new Font("Arial", Font.BOLD, 17));
        place.setBounds(55, 265, 150, 40);
        panel.add(place);

        tplace = new JTextField();
        tplace.setBounds(230, 270, 100, 30);
        panel.add(tplace);

        IssueAnInvoice = new JButton("ISSUE AN INVOICE");
        IssueAnInvoice.setBounds(70, 330, 245, 40);
        IssueAnInvoice.setFont(new Font("Arial", Font.BOLD, 17));
        IssueAnInvoice.setForeground(new Color(255, 13, 75));
        IssueAnInvoice.addActionListener(this);
        panel.add(IssueAnInvoice);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        Object Source = e.getSource();
        if (Source == AddTheBuyer) {
            ContractorsWindow kontrahenciWindow = new ContractorsWindow();
        }
        if (Source == AddTheSeller) {
            SellersWindow sprzedawcaWindow = new SellersWindow();
        }
        if (Source == AddTheProduct) {
            ProductsWindow produktyWindow = new ProductsWindow();
        }
        if (Source == IssueAnInvoice) {
            String form = (String)jComboBox.getSelectedItem();
            String termp = term.getText();
            String place = tplace.getText();

            IssueAnInvoiceWindow wf = new IssueAnInvoiceWindow(form,termp,place);
        }
    }
}