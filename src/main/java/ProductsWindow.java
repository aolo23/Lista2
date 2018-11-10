import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 *  The class responsible for the appearance of the window for the products.
 */

class ProductsWindow extends JFrame implements ActionListener {

    private final JTextField Name;
    private final JTextField tPrice;
    private final JTextField tJM;
    private final  JTextField tnumber;
    private final JButton Save;
    private final JButton Exit;
    private int counter =0;

    ProductsWindow(){

        setTitle("PRODUCTS");
        setBounds(320,70,470,350);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel productPanel = new JPanel();
        productPanel.setLayout(null);
        productPanel.setBackground(new Color(255, 208, 143));
        productPanel.setBounds(320,70,470,350);
        add(productPanel);

        Name = new JTextField("");
        Name.setFont( new Font("Arial", Font.BOLD, 15));
        Name.setBounds(200,70,200,30);
        Name.setBackground(new Color(255, 253, 163));
        productPanel.add(Name);

        JLabel jName = new JLabel("Name:");
        jName.setFont( new Font("Arial", Font.BOLD, 18));
        jName.setBounds(68,70,100,30);
        productPanel.add(jName);

        tPrice = new JTextField("");
        tPrice.setFont( new Font("Arial", Font.BOLD, 15));
        tPrice.setBounds(200,105,200,30);
        tPrice.setBackground(new Color(255, 253, 163));
        productPanel.add(tPrice);

        JLabel jPrice = new JLabel("Price(PLN):");
        jPrice.setFont( new Font("Arial", Font.BOLD, 18));
        jPrice.setBounds(68,105,150,30);
        productPanel.add(jPrice);

        tJM = new JTextField("");
        tJM.setFont( new Font("Arial", Font.BOLD, 15));
        tJM.setBounds(200,140,200,30);
        tJM.setBackground(new Color(255, 253, 163));
        tJM.addActionListener(this);
        productPanel.add(tJM);

        JLabel jJM = new JLabel("Unit of mass:");
        jJM.setFont( new Font("Arial", Font.BOLD, 18));
        jJM.setBounds(68,140,180,30);
        productPanel.add(jJM);

        JLabel jnumber = new JLabel("Number:");
        jnumber.setFont(new Font("Arial", Font.BOLD, 18));
        jnumber.setBounds(68,175,100,30);
        productPanel.add(jnumber);

        tnumber = new JTextField("");
        tnumber.setFont( new Font("Arial", Font.BOLD, 15));
        tnumber.setBounds(200,175,200,30);
        tnumber.setBackground(new Color(255, 253, 163));
        tnumber.addActionListener(this);
        productPanel.add(tnumber);

        Save = new JButton("SAVE");
        Save.setFont( new Font("Arial", Font.BOLD, 15));
        Save.setBounds(150,235,80,40);
        Save.addActionListener(this);
        productPanel.add(Save);

        Exit = new JButton("EXIT");
        Exit.setFont( new Font("Arial", Font.BOLD, 15));
        Exit.setBounds(250,235,80,40);
        Exit.addActionListener(this);
        productPanel.add(Exit);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object Source = e.getSource();

        if(Source == Save){
            String NameOfProductOrService = Name.getText();
            String Price = tPrice.getText();
            String JM = tJM.getText();
            String Amount = tnumber.getText();
            ProductsDataChecking productsDataChecking = new ProductsDataChecking(NameOfProductOrService, Price, JM, Amount, counter);
            counter = productsDataChecking.getLicznik();
            if(counter == 7){
                JOptionPane.showMessageDialog(null, "" +
                        "The maximum number of products has been added.", "Information ", JOptionPane.INFORMATION_MESSAGE);
            }
            Name.setText("");
            tPrice.setText("");
            tJM.setText("");
            tnumber.setText("");
        }
        if(Source == Exit){ dispose();
        }
    }
}
