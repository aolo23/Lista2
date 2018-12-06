import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class DataCheckingTest {
    @Mock
    ContractorsGoodData kgd;
    @Mock
    SellersGoodData sgd;
    @InjectMocks
    private
    DataChecking dataChecking =  new DataChecking("Name", "Surname",  "", 0);

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testIsEmptyFiles() throws Exception {
        boolean result = dataChecking.isEmptyFiles();
        Assert.assertEquals(false, result);
    }


}
//;)
