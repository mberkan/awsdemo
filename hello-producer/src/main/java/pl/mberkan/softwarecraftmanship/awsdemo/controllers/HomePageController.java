package pl.mberkan.softwarecraftmanship.awsdemo.controllers;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.mberkan.softwarecraftmanship.awsdemo.Hello;

@Controller
public class HomePageController {

    @RequestMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Hello helloWorld() {
        return new Hello("Hello producer!");
    }
}