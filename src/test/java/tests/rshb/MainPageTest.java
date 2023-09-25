package tests.rshb;

import org.junit.jupiter.api.*;
import pages.*;

public class MainPageTest extends BaseTest {

    MainPage mainPage = new MainPage();
    NaturalPage naturalPage = new NaturalPage();
    NaturalLoansPage naturalLoansPage = new NaturalLoansPage();

    @Test
    @Tag("ui")
    @DisplayName("Проверка страницы: 'Кредиты' дифференцированный платеж")
    void creditsDifferentiated() {
    /*
    1. Тест-кейс 1
        - Зайти на сайт rshb.ru
        - Кликнуть «Частным клиентам»
        - Кликнуть «Кредиты»
       Рассчитать кредит
        - тип платежа «Дифференцированный»
        - сумма кредита 1 500 000 р
        - Срок кредита 30 м
        - кликнуть чекбоксы "Получаю зарплату на счёт в россельхозбанке" и
        "Комплексная страховая защита"
        - Сравнить что ставка = 15.5%, а ежемесячный платеж = 69 375 ₽
    */

        mainPage
                .openPage()
                .clickPrivateClients();
        naturalPage
                .clickCredits();
        naturalLoansPage
                .clickButtonInformationCookies()
                .clickRadioButtonDifferentiated()
                .setLoanAmountDifferentiated()
                .setMonthDifferentiated()
                .setCheckBoxSalaryInBank()
                .setCheckBoxInsurance();

        naturalLoansPage
                .checkRadioButtonAnnuitant()
                .checkPercentDifferentiated()
                .checkMonthlyPaymentDifferentiated();

    }

    @Test
    @Tag("ui")
    @DisplayName("\"Проверка страницы: 'Кредиты' аннуитетный платеж\"")
    void creditsAnnuity() {
    /*
    1. Тест-кейс 1
        - Зайти на сайт rshb.ru
        - Кликнуть «Частным клиентам»
        - Кликнуть «Кредиты»
       Рассчитать кредит
        - тип платежа «Аннуитетный»
        - сумма кредита 2 500 000 р
        - Срок кредита 40 м
        - кликнуть чекбокс «Получаю зарплату на счёт в россельхозбанке», остальные чекбоксы не должны быть активны
        - Сравнить что ставка = 15.5%, а ежемесячный платеж = 80 424 ₽
    */

        mainPage
                .openPage()
                .clickPrivateClients();
        naturalPage
                .clickCredits();
        naturalLoansPage
                .clickButtonInformationCookies()
                .clickRadioButtonAnnuity()
                .setLoanAmountAnnuity()
                .setMonthAnnuity()
                .setCheckBoxSalaryInBank()
                .removeCheckBoxInsurance();

        naturalLoansPage
                .checkRadioButtonAnnuitant()
                .checkPercentAnnuity()
                .checkMonthlyPaymentAnnuity();
        
    }

}