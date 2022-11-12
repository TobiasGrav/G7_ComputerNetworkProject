package no.ntnu.sensor;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home")
public class WebController {

    @GetMapping
    public String getHome() {
        System.out.println("hei");
        return "index";
    }

}
