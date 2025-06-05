package ru.iFellow.Hooks;
import io.cucumber.java.Before;
import ru.iFellow.API.Specifications.SetBaseUrlAPI;

public class Hooks {
    @Before("@rickAndMorty")
    public void setURLrickAndMorty() {
        SetBaseUrlAPI.SetUp("baseURLRickAndMorty");
    }

    @Before("@testUserAPI")
    public void setURLuserAPI() {
        SetBaseUrlAPI.SetUp("baseURLusers");
    }
}

