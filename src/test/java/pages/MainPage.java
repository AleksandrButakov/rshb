package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class MainPage {

    private final SelenideElement
            headerTitle = $(".logo"),
            menu_product = $$(".link").findBy(text("Продукты")),
            menu_services = $$(".link").findBy(text("Услуги")),
            menu_clients = $$(".link").findBy(text("Клиенты")),
            menu_partners = $$(".link").findBy(text("Партнеры")),
            menu_about = $$(".link").findBy(text("О нас")),
            menu_press_center = $$(".link").findBy(text("Пресс-центр")),
            menu_career = $$(".link").findBy(text("Карьера"));

    public MainPage openPage() {
        open("/");
        return this;
    }

    public MainPage clickProductsMenu() {
        menu_product.click();
        return this;
    }

    public MainPage clickServicesMenu() {
        menu_services.click();
        return this;
    }

    public MainPage clickClientsMenu() {
        menu_clients.click();
        return this;
    }

    public MainPage clickPartnersMenu() {
        menu_partners.click();
        return this;
    }

    public MainPage clickAboutMenu() {
        menu_about.click();
        return this;
    }

    public MainPage clickPressCenterMenu() {
        menu_press_center.click();
        return this;
    }

    public MainPage clickCareerMenu() {
        menu_career.click();
        return this;
    }

}
