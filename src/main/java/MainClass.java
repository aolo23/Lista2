/**
 Instance of the main class of the program
 @author Patrycja Paradowska, W11 informatyka
 */
class MainClass {
    public static void main(String args[]){
        WindowApperance wa = new WindowApperance();
        BazaDanych bd = new BazaDanych();
        System.out.println(bd.getKontrahentAddress());
        System.out.println(bd.getKontrahentName());
        System.out.println(bd.getKontrahentSurname());
        System.out.println(bd.getSprzedawcaAddress());
        System.out.println(bd.getSprzedawcaName());
        System.out.println(bd.getSprzedawcaSurname());
        System.out.println(bd.getProdukt());
    }

}
