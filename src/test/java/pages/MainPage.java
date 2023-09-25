package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class MainPage {
    private final SelenideElement
            menu_private_clients = $$(".inline-block").findBy(text("Частным клиентам"));

    public MainPage openPage() {
        open("/");
        return this;
    }

    public MainPage clickPrivateClients() {
        menu_private_clients.click();
        return this;
    }

}
