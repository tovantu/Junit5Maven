import hooks.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UiTest extends TestBase {
    @Test(groups = {"group1"})
    public void test1() throws InterruptedException {
        webPage.homePage.inputIntoSearchField("Text Test");
    }

    @Test
    public void test111111111() throws InterruptedException {
        webPage.homePage.inputIntoSearchField("Text Test");
        Assert.assertTrue(false);
    }
}
