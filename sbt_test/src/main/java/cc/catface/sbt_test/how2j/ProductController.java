package cc.catface.sbt_test.how2j;

import cc.catface.sbt_test.how2j.mds.pojo.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

/**
 Created by catfaceWYH --> tel|wechat|qq 130 128 92925
 */
@Controller
public class ProductController {

    @RequestMapping("/product")
    public String product(Model model) {
        String html = "<p style='color:red'>红色文字</p>";
        Product product = new Product(1, "第一个产品", 1999);

        model.addAttribute("html", html);
        model.addAttribute("product", product);

        model.addAttribute("flag", true);

        return "product";
    }


    /** 遍历 */
    @RequestMapping("/products")
    public String products(Model model) {
        String html = "<p style='color:red'>红色文字</p>";
        Product product = new Product(1, "第一个产品", 1999);

        model.addAttribute("html", html);
        model.addAttribute("product", product);

        model.addAttribute("flag", true);

        List<Product> products = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            products.add(new Product(i, "产品" + i, i % 3 * 100));
        }
        model.addAttribute("products", products);

        return "product";
    }

}
