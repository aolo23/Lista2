import javax.swing.*;

/**
 * The class responsible for checking data in fields entered into the contractors' and sellers' window
 */

class DataChecking {
    private final int ID;
    private final String Name;
    private final String LastName;
    private final String address;
    private ContractorsGoodData kgd;
    private SellersGoodData sgd;

    DataChecking(String Name, String LastName, String address, int ID) {
        this.Name = Name;
        this.LastName = LastName;
        this.address = address;
        this.ID = ID;

        isEmptyFiles();
        if(ID == 0  && isEmptyFiles()){
            CreateGoodDataContractors();
        }
        else if (ID == 1 && isEmptyFiles()) {
            CreateGoodDataSellers();
        }
    }

    private void CreateGoodDataContractors(){
        kgd = new ContractorsGoodData();
        kgd.setFirstName(Name);
        kgd.setLastName(LastName);
        kgd.setAddress(address);
        kgd.CreateKontrahenci();
        kgd.SaveObjectOfKontrahenci();
        JOptionPane.showMessageDialog(null, "" +
                "The contractor has been added", "Information", JOptionPane.INFORMATION_MESSAGE);
    }

    private void CreateGoodDataSellers(){
        sgd = new SellersGoodData();
        sgd.setFirstName(Name);
        sgd.setLastName(LastName);
        sgd.setAddress(address);
        sgd.CreateSprzedawcy();
        sgd.SaveObjectOfSprzedawcy();
        JOptionPane.showMessageDialog(null, "" +
                "The seller has been added", "Information ", JOptionPane.INFORMATION_MESSAGE);
    }

    public boolean isEmptyFiles() {
        if (Name.length() < 1 || LastName.length() < 1 || address.length() <  1) {
            JOptionPane.showMessageDialog(null, "" +
                    "All fields have not been filled out.", "Information ", JOptionPane.INFORMATION_MESSAGE);
            return false;
        }
        return true;
    }
}