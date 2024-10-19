import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;

import static io.qameta.allure.Allure.step;

public class UiTest extends BasicTest {
    @DisplayName("Проверка на странице Checkboxes")
    @ParameterizedTest(name = "Порядок нажатия: {0}")
    @ValueSource(strings = {"forward", "back"})
    void checkCheckboxAndStateVerification(String order) {
        internetMainPage.clickCheckboxesButton();
        checkboxesPage.check().checkTitleCheckboxes();
        if (order.equals("forward")) {
            step("Нажатие чекбоксов в порядке  checkbox 1, checkbox 2", () -> {
                checkboxesPage.selectFirstCheckbox().check().checkFirstCheckboxStateChecked()
                        .page().selectSecondCheckbox().check().checkSecondCheckboxStateUnchecked();
            });
        } else {
            step("Нажатие чекбоксов в порядке  checkbox 2, checkbox 1", () -> {
                checkboxesPage.selectSecondCheckbox().check().checkSecondCheckboxStateUnchecked()
                        .page().selectFirstCheckbox().check().checkFirstCheckboxStateChecked();
            });
        }
    }

    @DisplayName("Проверка на странице Dropdown")
    @CsvSource({
            "1, Option 1",
            "2, Option 2"
    })
    @ParameterizedTest(name = "При выборе значения {0} состояние - {1}")
    void dropdownSelectionAndTextOutput(int i, String value) {
        internetMainPage.clickDropdownButton();
        dropdownPage.check().checkTitleDropdown().page().selectItemInDropdown(i).check().checkTextInDropdown(value);
    }

    @DisplayName("Проверка на странице Disappearing Elements")
    @RepeatedTest(value = 3, name = "Попытка {currentRepetition}")
    void disappearingElementsVisibility() {
        internetMainPage.clickDisappearingElementsButton();
        disappearingElementsPage.check().checkTitleDisappearingElements().checkElementsCount(5);
    }

    @DisplayName("Проверка на странице Inputs")
    @TestFactory
    List<DynamicTest> inputFieldRandomNumber() {
        internetMainPage.clickInputsButton();
        inputsPage.check().checkTitleInputs();
        List<DynamicTest> tests = new ArrayList<>();
        String[] negativeInputs = {"abc", "@#$%", "\n", " ", "йцуке"};
        for (String invalidInput : negativeInputs) {
            tests.add(DynamicTest.dynamicTest("Негативный тест: Попытка ввести '" + invalidInput + "'", () -> {
                inputsPage.inputDate(invalidInput).check().checkValueInInput("");
            }));
        }
        tests.add(DynamicTest.dynamicTest(
                "Проверка удаления пробелов", () -> {
                    String testData = " 1 121  ";
                    inputsPage.inputDate(testData).check().checkValueInInput("1121");
                }
        ));
        tests.add(DynamicTest.dynamicTest(
                "Проверка сохранения точки", () -> {
                    String testData = "23.23";
                    inputsPage.inputDate(testData).check().checkValueInInput("23.23");
                }
        ));
        tests.add(DynamicTest.dynamicTest(
                "Проверка удаления /", () -> {
                    String testData = "1/2";
                    inputsPage.inputDate(testData).check().checkValueInInput("12");
                }
        ));
        tests.add(DynamicTest.dynamicTest(
                "Проверка сохранения введенного числа", () -> {
                    String testData = "102";
                    inputsPage.inputDate(testData).check().checkValueInInput("102");
                }
        ));
        tests.add(DynamicTest.dynamicTest(
                "Проверка сохранения ведущих и замыкающих нулей", () -> {
                    String testData = "001.00000001000";
                    inputsPage.inputDate(testData).check().checkValueInInput("001.00000001000");
                }
        ));
        return tests;
    }
}


