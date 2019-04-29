package cc.catface.sbt_test;

import cc.catface.sbt_test.how2j.mds.mapper.CategoryMapper;
import cc.catface.sbt_test.how2j.mds.pojo.Category;
import cn.hutool.core.util.ZipUtil;
import cn.hutool.http.HttpUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SbtTestApplicationTests {

    @Test
    public void contextLoads() {
    }


    @Autowired
    CategoryMapper mapper;

    @Test
    public void getAllCategory() {
        List<Category> all = mapper.findAll();
        for (Category c : all) {
            System.out.println("category-->" + c.getName());
        }
    }


    @Test
    public void http() {
        String s = HttpUtil.get("https://www.baidu.com");
        System.out.println(s);
    }


    @Test
    public void zip() {
        ZipUtil.zip("D:\\softwares\\小程序");
    }
}

