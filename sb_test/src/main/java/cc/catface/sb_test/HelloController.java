package cc.catface.sb_test;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class HelloController {

    @RequestMapping("/hello")
    public String hello() {
        String content = "hello SpringBoot! ^ now time is: " + new Date().toLocaleString();
        System.out.println(content);
        return content;
    }


    @RequestMapping(value = "/exception")
    public void exception() {
        int i = 1 / 0;
    }

}
