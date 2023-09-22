package tests.rshb;

import org.junit.jupiter.api.*;
import pages.*;

import static org.assertj.core.api.Assertions.assertThat;

public class MainPageTest extends BaseTest {

    MainPage mainPage = new MainPage();
    ProductsPage productsPage = new ProductsPage();
    ServicesPage servicesPage = new ServicesPage();
    ClientsPage clientsPage = new ClientsPage();
    PartnersPage partnersPage = new PartnersPage();
    AboutPage aboutPage = new AboutPage();
    PressCenterPage pressCenterPage = new PressCenterPage();
    CareerPage careerPage = new CareerPage();

    @Test
    @Tag("ui")
    @DisplayName("Проверка в меню ссылки 'Продукты'")
    void checkingLinkMenuProducts() {
        mainPage.openPage()
                .clickProductsMenu();
        productsPage
                .checkingPageLoadingProducts();
    }

    @Test
    @Tag("ui")
    @DisplayName("Проверка в меню ссылки 'Услуги'")
    void checkingLinkMenuServices() {
        mainPage.openPage()
                .clickServicesMenu();
        servicesPage
                .checkingPageLoadingServices();
    }

    @Test
    @Tag("ui")
    @DisplayName("Проверка в меню ссылки 'Клиенты'")
    void checkingLinkMenuClients() {
        mainPage.openPage()
                .clickClientsMenu();
        clientsPage
                .checkingPageLoadingClients();
    }

    @Test
    @Tag("ui")
    @DisplayName("Проверка в меню ссылки 'Партнеры'")
    void checkingLinkMenuPartners() {
        mainPage.openPage()
                .clickPartnersMenu();
        partnersPage
                .checkingPageLoadingPartners();
    }

    @Test
    @Tag("ui")
    @DisplayName("Проверка в меню ссылки 'О НАС'")
    void checkingLinkMenuAbout() {
        mainPage.openPage()
                .clickAboutMenu();
        aboutPage
                .checkingPageLoadingAbout();
    }

    @Test
    @Tag("ui")
    @DisplayName("Проверка в меню ссылки 'Пресс-центр'")
    void checkingLinkMenuPressCenter() {
        mainPage.openPage()
                .clickPressCenterMenu();
        pressCenterPage
                .checkingPageLoadingPressCenter();
    }

    @Test
    @Tag("ui")
    @DisplayName("Проверка в меню ссылки 'Карьера'")
    void checkingLinkMenuCareer() {
        mainPage.openPage()
                .clickCareerMenu();
        careerPage
                .checkingPageLoadingCareer();
    }

    @Test
    @DisplayName("Ложный тест для отображения на диаграмме")
    void falseTest() {
        assertThat(false);
    }

    @Test
    @Disabled
    @DisplayName("@Disable тест для отображения на диаграмме")
    void falseDisableTest() {
        assertThat(false);
    }

}