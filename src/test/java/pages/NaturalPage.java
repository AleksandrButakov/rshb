package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class NaturalPage {

    private final SelenideElement
            menu_credits = $("div[class^='container']")
            .$$("span[class^='font-sans']")
            .findBy(text("Кредиты"));

//    menu_credits = $$("div[class^='relative']").findBy(text("Кредиты"));
//    menu_credits = $$("nav[class^='relative']").findBy(text("Кредиты"));
//    menu_credits = $("div[class^='overflow-hidden']").$("span[class^='font-sans']");    //findBy(text("Кредиты"));
//    menu_credits = $("nav[class^='relative']").findBy(text("Кредиты"));
//    menu_credits = $$("header[class^='@container font-sans group bg-white text-primary-text pt-3xl px-20 pb-m col-span-12']").findBy(text("Кредиты"));
//    menu_credits = $$("header[class^='@container']").findBy(text("Кредиты"));

    public NaturalPage clickCredits() {
        menu_credits.click();
        return this;
    }


}
