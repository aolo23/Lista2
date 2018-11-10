import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The class responsible for the appearance of the window for the seller.
 *
 */
class ContractorsWindow extends JFrame implements ActionListener {

    private final JTextField FirstName;
    private final JTextField tLastName;
    private final JTextField tAddress;
    private final JButton Save;
    private final JButton Exit;

    ContractorsWindow() {
        setTitle("CONTRACTORS");
        setBounds(300, 50, 500, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel sellerPanel = new JPanel();
        sellerPanel.setLayout(null);
        sellerPanel.setBackground(new Color(255, 208, 143));
        sellerPanel.setBounds(300, 50, 500, 500);
        add(sellerPanel);

        FirstName = new JTextField("");
        FirstName.setFont(new Font("Arial", Font.BOLD, 15));
        FirstName.setBounds(210, 30, 260, 30);
        FirstName.setBackground(new Color(255, 253, 163));
        sellerPanel.add(FirstName);

        JLabel firstname = new JLabel("First Name: ");
        firstname.setFont(new Font("Arial", Font.BOLD, 18));
        firstname.setBounds(50, 30, 200, 30);
        sellerPanel.add(firstname);

        tLastName = new JTextField("");
        tLastName.setFont(new Font("Arial", Font.BOLD, 15));
        tLastName.setBounds(210, 65, 260, 30);
        tLastName.setBackground(new Color(255, 253, 163));
        sellerPanel.add(tLastName);

        JLabel lastname = new JLabel("Last Name: ");
        lastname.setFont(new Font("Arial", Font.BOLD, 18));
        lastname.setBounds(50, 65, 200, 30);
        sellerPanel.add(lastname);

        tAddress = new JTextField("");
        tAddress.setFont(new Font("Arial", Font.BOLD, 14));
        tAddress.setBounds(210, 100, 260, 50);
        tAddress.setBackground(new Color(255, 253, 163));
        tAddress.addActionListener(this);
        sellerPanel.add(tAddress);

        JLabel jaddress = new JLabel("Address:");
        jaddress.setFont(new Font("Arial", Font.BOLD, 18));
        jaddress.setBounds(50, 100, 100, 30);
        sellerPanel.add(jaddress);

        Save = new JButton("SAVE");
        Save.setFont(new Font("Arial", Font.BOLD, 18));
        Save.setBounds(140, 190, 100, 50);
        Save.addActionListener(this);
        sellerPanel.add(Save);

        Exit = new JButton("EXIT");
        Exit.setFont(new Font("Arial", Font.BOLD, 18));
        Exit.setBounds(250, 190, 100, 50);
        Exit.addActionListener(this);
        sellerPanel.add(Exit);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object Source = e.getSource();
        if (Source == Save) {
            System.out.print("Save");
            String imie = FirstName.getText();
            String nazwisko = tLastName.getText();
            String adres = tAddress.getText();
            DataChecking kd = new DataChecking(imie, nazwisko, adres, 0);
            FirstName.setText("");
            tLastName.setText("");
            tAddress.setText("");
        }
        if (Source == Exit) {
            dispose();
        }
    }
}