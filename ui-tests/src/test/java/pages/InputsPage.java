package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$x;

public class InputsPage {
    SelenideElement inputsTitle = $x("//h3[text()='Inputs']");
    SelenideElement input = $x("//input");

    public InputsPageAssert check() {
        return InputsPageAssert.assertThat(this);
    }


    @Step("Пользователь ввел {testData}")
    public InputsPage inputDate(String testData) {
        input.clear();
        input.sendKeys(testData);
        return this;
    }
}
