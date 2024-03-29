# Проект по автоматизации тестирования для RSHB
## <a target="_blank" href="https://rshb.ru/">Веб сайт https://rshb.ru</a>
## :o2: Содержание:

- <a href="#shinto_shrine-общая-информация-о-тестовом-фреймворке">Общая информация о тестовом фреймворке</a>
- <a href="#shinto_shrine-технологии-и-инструменты">Технологии и инструменты</a>
- <a href="#shinto_shrine-реализованные-проверки">Реализованные проверки</a>
- <a href="#shinto_shrine-сборка-в-Jenkins">Сборка в Jenkins</a>
- <a href="#shinto_shrine-запуск-из-терминала">Запуск из терминала</a>
- <a href="#shinto_shrine-allure-отчет">Allure отчет</a>
- <a href="#shinto_shrine-отчет-в-telegram">Отчет в Telegram</a>
- <a href="#shinto_shrine-видео-примеры-прохождения-тестов">Видео примеры прохождения тестов</a>

## :o2: Общая информация о тестовом фреймворке
&nbsp;&nbsp;&nbsp;Для реализации данного тестового фреймворка на хостинге был развернут VPS
с Ubuntu 22.04, установлен Docker, в Docker Compose подняты Jenkins, Selenoid and Selenoid UI,
настроены роли в Jenkins для доступа, загружены необходимые образы браузеров. Создан чат бот
в Telegram для получения уведомлений о прохождении тестов из Jenkins. Создан проект в
IntellijIDEA. Реализована параметризация с использованием библиотеки Owner и параллелизация
выполнения тестовых сценариев. Обработка данных из API запросов выполняется с использованием
библиотеки Lombok. Код запушен на GitHub. В коде добавлены все аттачменты для сохранения
статистики проходжения тестов, такие как: Screenshot, PageSource, BrowserConsole addVideo and
API тестов. 

## :o2: Технологии и инструменты
<p align="center">
<img width="6%" title="IntelliJ IDEA" src="images/logo/IntelliJ_IDEA.svg">
<img width="6%" title="Java" src="images/logo/Java.svg">
<img width="6%" title="Gradle" src="images/logo/Gradle.png">
<img width="6%" title="JUnit5" src="images/logo/JUnit5.svg">
<img width="6%" title="Selenide" src="images/logo/Selenide.svg">
<img width="6%" title="Selenoid" src="images/logo/Selenoid.svg">
<img width="6%" title="GitHub" src="images/logo/Github.png">
<img width="6%" title="GitHub" src="images/logo/Docker.svg">
<img width="6%" title="Jenkins" src="images/logo/Jenkins.svg">
<img width="6%" title="Allure Report" src="images/logo/Allure_Report.svg">
<img width="6%" title="Telegram" src="images/logo/Telegram.svg">
</p>

## :o2: Реализованны проверки UI and API запросов

    1. Тест-кейс 1
        - Открытие сайта rshb.ru
        - Переход по ссылке меню: «Частным клиентам»
        - Кликнуть ссылку: «Кредиты»
       Рассчитать кредит
        - выбрать тип платежа «Дифференцированный»
        - установить сумму кредита 1 500 000 р
        - выбрать срок кредита 30 месяцев
        - кликнуть чекбоксы "Получаю зарплату на счёт в россельхозбанке" и
        "Комплексная страховая защита"
        - Сравнить что ставка = 15.5%, а ежемесячный платеж = 69 375 ₽

    2. Тест-кейс 2
        - Зайти на сайт rshb.ru
        - Переход по ссылке меню: «Частным клиентам»
        - Кликнуть ссылку: «Кредиты»
       Рассчитать кредит
        - тип платежа «Аннуитетный»
        - установить сумму кредита 2 500 000 р
        - выбрать срок кредита 40 месяцев
        - кликнуть чекбокс «Получаю зарплату на счёт в россельхозбанке»,
        остальные чекбоксы не должны быть активны
        - Сравнить что ставка = 15.5%, а ежемесячный платеж = 80 424 ₽

    3. Тест-кейс 3
        - Проверка endpoint меню запросами API

### <a target="_blank" href="http://62.113.108.218:8888/job/rshb/">Сборка в Jenkins</a>
<p align="center">
  <img title="Jenkins Dashboard" src="images/screenshots/jenkins_dashboard.png">
</p>

### Параметры сборки в Jenkins:
Сборка в Jenkins
- browser (браузер, по умолчанию chrome)
- browserVersion (default 112.0)
- browserSize (default 1920x1080)
- threads (количество потоков)

## :o2: Запуск из терминала
Локальный запуск:
```bash
gradle clean test
gradle clean ui_test
gradle clean api_test
```

Удаленный запуск:
```bash
clean
-Dbrowser=${BROWSER}
-DbrowserVersion=${BROWSER_VERSION}
-Dthreads=${THREADS}
test
```

## :o2: Allure отчет    
- ### <a target="_blank" href="http://62.113.108.218:8888/job/rshb/12/allure/">Главный экран отчета</a>
<p align="center">
<img title="Allure Overview Dashboard" src="images/screenshots/allure_main_page.png">
</p>

- ### Страница с проведенными тестами
<p align="center">
<img title="Allure Test Page" src="images/screenshots/allure_test_page.png">
</p>

## :o2: Отчет в Telegram
<p align="center">
<img title="Telegram notification message" src="images/screenshots/telegram_notification.png">
</p>

## :o2: Видео примеры прохождения тестов
> К каждому тесту в отчете прилагается видео. Одно из таких видео представлено ниже.
<p align="center">
  <img title="Selenoid Video" src="images/gif/video.gif">
</p>