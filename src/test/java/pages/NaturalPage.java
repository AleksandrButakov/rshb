package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class NaturalPage {

    private final SelenideElement
            menu_credits = $("div[class^='container']")
            .$$("span[class^='font-sans']")
            .findBy(text("Кредиты"));

    public NaturalPage clickCredits() {
        menu_credits.click();
        return this;
    }

}