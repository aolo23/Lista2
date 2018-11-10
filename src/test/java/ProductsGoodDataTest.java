import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Arrays;

public class ProductsGoodDataTest {
    @Mock
    ArrayList<String> ListofProdukty;
    @InjectMocks
    ProductsGoodData productsGoodData;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testAddProduct() throws Exception {
        productsGoodData.addProduct();
    }

    @Test
    public void testGetListOfrodukty() throws Exception {
        ArrayList result = productsGoodData.getListOfrodukty();
        Assert.assertEquals(new ArrayList(Arrays.asList("String")), result);
    }

    @Test
    public void testSetindexofarray() throws Exception {
        productsGoodData.setindexofarray(0);
    }
}