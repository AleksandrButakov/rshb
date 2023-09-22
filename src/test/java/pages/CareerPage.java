package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$$;

public class CareerPage {

    private final SelenideElement
    button_vacancy = $$(".btn").findBy(text("Смотреть вакансии")),
    button_internship = $$(".btn").findBy(text("Выбрать стажировку"));

    public void checkingPageLoadingCareer() {
        button_vacancy.shouldBe(visible);
        button_internship.shouldBe(visible);
    }

}
