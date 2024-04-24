/*На главной странице GitHub выберите меню Solutions -> Enterprize
с помощью команды hover для Solutions. Убедитесь что загрузилась нужная страница
(например что заголовок - "Build like the best."
 */

package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.url;

public class SolutionsTest {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://github.com/";
        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen = true;
    }

    @Test
    void solutions_test(){

        open("https://github.com/");
        $(byTagAndText("button", "Solutions")).hover();
        $(byTagAndText("a", "Enterprise")).click();
        webdriver().shouldHave(url("https://github.com/enterprise"));

    }
}
