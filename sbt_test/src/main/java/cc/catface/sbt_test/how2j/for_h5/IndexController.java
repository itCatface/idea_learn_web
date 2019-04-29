package cc.catface.sbt_test.how2j.for_h5;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 Created by catfaceWYH --> tel|wechat|qq 130 128 92925
 */
@Controller
@RequestMapping("/h5")
public class IndexController {

    @RequestMapping("/index")
    public String index() {
        return "h5_index";
    }


    @RequestMapping("/jquery")
    public String jquery() {
        return "h5_index_jquery";
    }


    @RequestMapping("/bootstrap")
    public String bootstrap() {
        return "h5_index_bootstrap";
    }


    @RequestMapping("/bootstrap2")
    public String bootstrap2() {
        return "h5_index_bootstrap_2";
    }


    @RequestMapping("/bootstrap3")
    public String bootstrap3() {
        return "h5_index_bootstrap_3";
    }
}
