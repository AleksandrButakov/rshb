package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static constants.Constants.*;
import static org.assertj.core.api.Assertions.*;

public class NaturalLoansPage {
    private final SelenideElement
            buttonInformationCookies = $("div[class^='bg-white m-xl']").$("button[class^='flex']"),
            radioButtonAnnuitant = $$("label[class^='flex']").find(text("Аннуитетный")),
            radioButtonAnnuity = $$("label[class^='flex']").find(text("Аннуитетный")),
            radioButtonDifferentiated = $$("label[class^='flex']").find(text("Дифференцированный")),
            inputLoanAmount = $$("input[class^='mt-xs font-sans']").get(0),
            inputMonth = $$("input[class^='mt-xs font-sans']").get(1),
            checkBoxSalaryInBankStatus = $$("label[class^='flex']").get(0).$(".appearance-none"),
            checkBoxSalaryInBank = $$("label[class^='flex']").get(0),
            checkBoxInsuranceStatus = $$("label[class^='flex']").get(1).$(".appearance-none"),
            checkBoxInsurance = $$("label[class^='flex']").get(1),
            percent = $(".font-mohave"),
            monthlyPayment = $$("span[class^='font-sans text-h3']").get(1);


    public NaturalLoansPage clickButtonInformationCookies() {
        buttonInformationCookies.click();
        return this;
    }

    public NaturalLoansPage clickRadiobuttonAnnuitant() {
        radioButtonAnnuitant.click();
        return this;
    }

    public NaturalLoansPage clickRadioButtonAnnuity() {
        radioButtonAnnuitant.click();
        return this;
    }

    public NaturalLoansPage clickRadioButtonDifferentiated() {
        radioButtonDifferentiated.click();
        return this;
    }

    public NaturalLoansPage setLoanAmountDifferentiated() {
        for (int i = 0; i < 7; i++) {
            inputLoanAmount.sendKeys(Keys.BACK_SPACE);
        }

        inputLoanAmount.sendKeys(Keys.NUMPAD1);
        inputLoanAmount.sendKeys(Keys.NUMPAD5);
        inputLoanAmount.sendKeys(Keys.NUMPAD0);
        inputLoanAmount.sendKeys(Keys.NUMPAD0);
        inputLoanAmount.sendKeys(Keys.NUMPAD0);
        inputLoanAmount.sendKeys(Keys.NUMPAD0);
        inputLoanAmount.sendKeys(Keys.NUMPAD0);
        return this;
    }

    public NaturalLoansPage setMonthDifferentiated() {
        inputMonth.sendKeys(Keys.BACK_SPACE);
        inputMonth.sendKeys(Keys.BACK_SPACE);

        inputMonth.sendKeys(Keys.NUMPAD3);
        inputMonth.sendKeys(Keys.NUMPAD0);
        return this;
    }

    public NaturalLoansPage setLoanAmountAnnuity() {
        for (int i = 0; i < 7; i++) {
            inputLoanAmount.sendKeys(Keys.BACK_SPACE);
        }

        inputLoanAmount.sendKeys(Keys.NUMPAD2);
        inputLoanAmount.sendKeys(Keys.NUMPAD5);
        inputLoanAmount.sendKeys(Keys.NUMPAD0);
        inputLoanAmount.sendKeys(Keys.NUMPAD0);
        inputLoanAmount.sendKeys(Keys.NUMPAD0);
        inputLoanAmount.sendKeys(Keys.NUMPAD0);
        inputLoanAmount.sendKeys(Keys.NUMPAD0);
        return this;
    }

    public NaturalLoansPage setMonthAnnuity() {
        inputMonth.sendKeys(Keys.BACK_SPACE);
        inputMonth.sendKeys(Keys.BACK_SPACE);

        inputMonth.sendKeys(Keys.NUMPAD4);
        inputMonth.sendKeys(Keys.NUMPAD0);
        return this;
    }

    public NaturalLoansPage setCheckBoxSalaryInBank() {
        if (!Boolean.parseBoolean(checkBoxSalaryInBankStatus.getAttribute("aria-checked"))) {
            checkBoxSalaryInBank.click();
        }
        return this;
    }

    public NaturalLoansPage setCheckBoxInsurance() {
        if (!Boolean.parseBoolean(checkBoxInsuranceStatus.getAttribute("aria-checked"))) {
            checkBoxInsurance.click();
        }
        return this;
    }

    public NaturalLoansPage removeCheckBoxInsurance() {
        if (Boolean.parseBoolean(checkBoxInsuranceStatus.getAttribute("aria-checked"))) {
            checkBoxInsurance.click();
        }
        return this;
    }


    public NaturalLoansPage checkRadioButtonAnnuitant() {
        assertThat(radioButtonAnnuitant.isSelected()).isEqualTo(false);
        return this;
    }

    public NaturalLoansPage checkPercentDifferentiated() {
        assertThat(percent.getText()).isEqualTo(PERCENT_DIFFERENTIATED);
        return this;
    }

    public NaturalLoansPage checkMonthlyPaymentDifferentiated() {
        System.out.println(monthlyPayment);
        System.out.println(monthlyPayment.getText());

        assertThat(monthlyPayment.getText()).isEqualTo(MONTHLY_PAYMENT_DIFFERENTIATED);
        return this;
    }

    public NaturalLoansPage checkPercentAnnuity() {
        assertThat(percent.getText()).isEqualTo(PERCENT_ANNUITY);
        return this;
    }

    public NaturalLoansPage checkMonthlyPaymentAnnuity() {
        System.out.println(monthlyPayment);
        System.out.println(monthlyPayment.getText());

        assertThat(monthlyPayment.getText()).isEqualTo(MONTHLY_PAYMENT_ANNUITY);
        return this;
    }

}