/*Запрограммируйте Drag&Drop с помощью Selenide.actions()
- Откройте https://the-internet.herokuapp.com/drag_and_drop
- Перенесите прямоугольник А на место В
- Проверьте, что прямоугольники действительно поменялись
- В Selenide есть команда $(element).dragAndDrop($(to-element)),
проверьте работает ли тест, если использовать её вместо actions()
*/

package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.DragAndDropOptions.to;

public class DragAndDropTest {
    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://the-internet.herokuapp.com";
        Configuration.pageLoadStrategy = "eager";
        //Configuration.holdBrowserOpen = true;
    }

    @Test
    void drag_and_drop_test() {

        //Запрограммируйте Drag&Drop с помощью Selenide.actions()
        open("/drag_and_drop");
        actions().dragAndDrop($("#column-a"), $("#column-b")).perform();
        $("#column-a").shouldHave((text("B")));
        $("#column-b").shouldHave((text("A")));

        //В Selenide есть команда $(element).dragAndDrop($(to-element)),
        //проверьте работает ли тест, если использовать её вместо actions()
        $("#column-a").dragAndDrop(to("#column-b"));
        $("#column-a").shouldHave((text("A")));
        $("#column-b").shouldHave((text("B")));

    }
}
