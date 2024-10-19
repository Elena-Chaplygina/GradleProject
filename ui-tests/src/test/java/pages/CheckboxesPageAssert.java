package pages;

import io.qameta.allure.Step;
import org.assertj.core.api.AbstractAssert;

import static com.codeborne.selenide.Condition.*;

public class CheckboxesPageAssert extends AbstractAssert<CheckboxesPageAssert, CheckboxesPage> {

    public CheckboxesPageAssert(CheckboxesPage actual) {
        super(actual, CheckboxesPageAssert.class);
    }

    public static CheckboxesPageAssert assertThat(CheckboxesPage actual) {
        return new CheckboxesPageAssert(actual);
    }

    public CheckboxesPage page() {
        return actual;
    }


    @Step("Пользователь видит заголовок Checkboxes на странице https://the-internet.herokuapp.com/checkboxes")
    public CheckboxesPageAssert checkTitleCheckboxes() {
        actual.checkboxesTitle.should(visible);
        return this;
    }
    @Step("Первый чекбокс выделен")
    public CheckboxesPageAssert checkFirstCheckboxStateChecked() {
        actual.checkboxFirst.shouldBe(checked);
        return this;
    }


    @Step("Второй чекбокс не выделен")
    public CheckboxesPageAssert checkSecondCheckboxStateUnchecked() {
        actual.checkboxSecond.shouldNotBe(checked);
        return this;
    }



}
