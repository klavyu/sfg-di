package guru.springframework.sfgdi.controllers;

import guru.springframework.sfgdi.services.GreetingService;

public class PropertyInjectedController {
    public GreetingService greetingService;
    //least preferred method
    public String getGreeting(){
        return greetingService.sayGreeting();
    }
}
