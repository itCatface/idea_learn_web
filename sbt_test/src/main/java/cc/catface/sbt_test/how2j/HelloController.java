package cc.catface.sbt_test.how2j;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

/**
 Created by catfaceWYH --> tel|wechat|qq 130 128 92925
 */
@Controller
public class HelloController {

    @RequestMapping("/hello")
    public String hello(Model m) {
        m.addAttribute("name", new Date().toLocaleString());
        return "hello";
    }


    @RequestMapping(value = "/exception")
    public void exception() {
        int i = 1 / 0;
    }
}
