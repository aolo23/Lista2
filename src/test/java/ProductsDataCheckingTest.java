import org.junit.Assert;
import org.junit.Test;

public class ProductsDataCheckingTest {
    private final ProductsDataChecking productsDataChecking = new ProductsDataChecking("NameOfProductorService", "50", "szt", "10", 0);

    @Test
    public void testIsEmptyFiles() throws Exception {
        productsDataChecking.isEmptyFiles();
    }

    @Test
    public void testIsCheckJM() throws Exception {
        boolean result = productsDataChecking.isCheckJM();
        Assert.assertEquals(true, result);
    }

    @Test
    public void testIsCheckCena() throws Exception {
        boolean result = productsDataChecking.isCheckCena();
        Assert.assertEquals(true, result);
    }

    @Test
    public void testIsCheckIlość() throws Exception {
        boolean result = productsDataChecking.isCheckIlość();
        Assert.assertEquals(true, result);
    }
}

