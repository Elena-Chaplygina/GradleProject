package pages;

import io.qameta.allure.Step;
import org.assertj.core.api.AbstractAssert;

import static com.codeborne.selenide.Condition.value;
import static com.codeborne.selenide.Condition.visible;

public class InputsPageAssert extends AbstractAssert<InputsPageAssert, InputsPage> {


    public InputsPageAssert(InputsPage actual) {
        super(actual, InputsPageAssert.class);
    }

    public static InputsPageAssert assertThat(InputsPage actual) {
        return new InputsPageAssert(actual);
    }

    public InputsPage page() {
        return actual;
    }

    @Step("Пользователь видит заголовок Inputs на странице  https://the-internet.herokuapp.com/inputs")
    public InputsPageAssert checkTitleInputs() {
        actual.inputsTitle.should(visible);
        return this;
    }

    @Step("Пользователь в поле ввода видит {assertData}")
    public InputsPageAssert checkValueInInput(String assertData) {
        actual.input.shouldHave(value(assertData));
        return this;
    }
}
