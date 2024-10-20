import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Step;
import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import pages.*;
import utils.UIProps;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class BasicTest {

    UIProps props = ConfigFactory.create(UIProps.class);

    protected InternetMainPage internetMainPage = new InternetMainPage();
    protected InputsPage inputsPage = new InputsPage();
    protected DropdownPage dropdownPage = new DropdownPage();
    protected CheckboxesPage checkboxesPage = new CheckboxesPage();
    protected DisappearingElementsPage disappearingElementsPage = new DisappearingElementsPage();

    @BeforeEach
    @Step("Открыть сайт 'https://the-internet.herokuapp.com'")
    void setup() {
        Configuration.browser = "chrome";
        open(props.baseUrl());
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide()
                .screenshots(true)
                .savePageSource(true));
    }


    @AfterEach
    @Step("Закрыть драйвер")
    void tearDown() {
        getWebDriver().quit();
    }
}
