package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$x;

public class CheckboxesPage {
    SelenideElement checkboxesTitle = $x("//h3[text()='Checkboxes']"),
            checkboxFirst = $x("//form[@id='checkboxes']/input[@type='checkbox'][1]"),
            checkboxSecond = $x("//form[@id='checkboxes']/input[@type='checkbox'][2]");

    public CheckboxesPageAssert check() {
        return CheckboxesPageAssert.assertThat(this);
    }


    @Step("Пользователь выбрал первый чекбокс")
    public CheckboxesPage selectFirstCheckbox() {
        checkboxFirst.click();
        return this;
    }

    @Step("Пользователь выбрал второй чекбокс")
    public CheckboxesPage selectSecondCheckbox() {
        checkboxSecond.click();
        return this;
    }

}
