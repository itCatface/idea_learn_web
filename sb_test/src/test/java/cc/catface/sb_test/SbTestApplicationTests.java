package cc.catface.sb_test;

import cc.catface.sb_test.how2j.dao.CategoryDAO;
import cc.catface.sb_test.how2j.pojo.Category;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SbTestApplicationTests {


    @Autowired
    CategoryDAO dao;

    @Test
    public void getAllCategory() {
        List<Category> all = dao.findAll();
        for (Category c : all) {
            System.out.println("category-->" + c.getName());
        }
    }

}

