package guru.springframework.sfgdi.controllers;

import guru.springframework.sfgdi.services.GreetingService;
import org.springframework.stereotype.Controller;

@Controller
public class MyController {
    private final GreetingService greetingService;
//we do not need to have the autowire when we use to constructor based injection.
    public MyController(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    public String sayHello(){

        return greetingService.sayGreeting();
    }
}
