package com.example.saucedemo.config;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.open;

public abstract class TestBase {

    @BeforeAll
    static void setUpConfig() {
        Configuration.baseUrl = "https://www.saucedemo.com";
        Configuration.browser = "chrome";
        Configuration.timeout = 8000;
        Configuration.pageLoadStrategy = "normal";
    }

    @BeforeEach
    void openBaseUrl() {
        open("/");
    }
}