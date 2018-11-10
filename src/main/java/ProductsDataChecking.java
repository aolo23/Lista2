import javax.swing.*;
/**
 *The class responsible for checking data in fields entered into the Products window
 */

class ProductsDataChecking {

    private final String NameOfProductorService;
    private final String Price;
    private final String JM;
    private final String Number;
    private boolean isCorrectData = true;
    private int counter;

    ProductsDataChecking(String NameOfProductorService, String Price, String JM, String Number, int counter) {
        this.Price = Price;
        this.NameOfProductorService = NameOfProductorService;
        this.JM = JM;
        this.Number = Number;
        this.counter = counter;

        isEmptyFiles();
        if (isCorrectData ) {
            isCheckJM();
        }
        if(isCorrectData && isCheckJM() && isCheckCena() && counter < 8 && isCheckIlość()){
            ProductsGoodData pgd = new ProductsGoodData();
            pgd.setNameOfProductorService(NameOfProductorService);
            pgd.setPrice(Price);
            pgd.setJM(JM);
            pgd.setNumber(Number);
            int indexofarray = 0;
            pgd.setindexofarray(indexofarray);
            pgd.setCounter(counter);
            pgd.addProduct();
            indexofarray++;
            this.counter = counter +1;
            JOptionPane.showMessageDialog(null, "" +
                    "The product has been added.", "Information ", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public int getLicznik(){
        return counter;
    }

    void isEmptyFiles() {
        if (NameOfProductorService.length() < 1 || Price.length() < 1 || JM.length() < 1) {
            JOptionPane.showMessageDialog(null, "" +
                    "All fields have not been filled out", "Information ", JOptionPane.INFORMATION_MESSAGE);
            isCorrectData = false;
        }
    }

    public boolean isCheckJM() {
        String goodJM[] = {"op", "szt", "karton"};
        boolean isgood = false;
        for (String s : goodJM) {
            if (JM.equals(s)) {
                return  true;
            }
        }
        if (isgood == false) {
            JOptionPane.showMessageDialog(null, "" +
                    "Units of measure: \"op\",\"szt\",\"karton \"", "Information ", JOptionPane.INFORMATION_MESSAGE);
        }
        return  false;
    }

    public boolean isCheckCena() {
        try {
            double tempCena = Double.parseDouble(Price);
            return  true;
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "" +
                    "Incorrect value of price has been added", "Information ", JOptionPane.INFORMATION_MESSAGE);
            return  false;
        }

    }

    public boolean isCheckIlość() {
        try {
            int tempCena = Integer.parseInt(Number);
            return   true;
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "" +
                    "Incorrect value of amount has been added.", "Information ", JOptionPane.INFORMATION_MESSAGE);
            return  false;
        }
    }
}