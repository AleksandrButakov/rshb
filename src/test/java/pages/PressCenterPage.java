package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$$;

public class PressCenterPage {

    private final SelenideElement
    news_link = $$(".link").findBy(text("Новости")),
    publications_link = $$(".link").findBy(text("Публикации")),
    for_media_link = $$(".link").findBy(text("Для СМИ"));

    public void checkingPageLoadingPressCenter() {
        news_link.shouldBe(visible);
        publications_link.shouldBe(visible);
        for_media_link.shouldBe(visible);
    }

}
