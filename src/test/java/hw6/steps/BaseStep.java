package hw6.steps;

import hw6.DifferentServices;
import hw6.HomePage;
import hw6.UserTablePage;
import hw6.hooks.TestContext;

public class BaseStep {

    protected HomePage hp;
    protected DifferentServices dsp;
    protected UserTablePage utp;

    public BaseStep() {
        hp = HomePage.getInstance(TestContext.getDriver());
        dsp = DifferentServices.getInstance(TestContext.getDriver());
        utp = UserTablePage.getInstance(TestContext.getDriver());
    }
}
