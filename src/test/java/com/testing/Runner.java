package com.testing;


import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features=".",
        //tags = {"@register"}
        //tags = {"@register2"}
        //tags = {"@register3"}
        tags = {"@register4"}
        )
public class Runner {
}
