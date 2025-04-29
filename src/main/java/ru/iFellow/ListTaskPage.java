package ru.iFellow;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$x;

public class ListTaskPage {


    private final SelenideElement dropDownProject = $x("//div[@class='aui-header-inner']" +
            "/div[@class='aui-header-primary']//a[@title='Просмотр недавних проектов или списка всех проектов']");

    private final SelenideElement testProject = $x("//div[@class='aui-header-inner']/div[@class='aui-header-primary']" +
            "/ul[@class='aui-nav']//div[@id='project_current']//a[@id='admin_main_proj_link_lnk']");


    public void clickDropList() {
        dropDownProject.shouldBe(Condition.visible, Duration.ofSeconds(8));
        dropDownProject.click();
        testProject.shouldBe(Condition.visible, Duration.ofSeconds(8));
        testProject.click();
    }
}


