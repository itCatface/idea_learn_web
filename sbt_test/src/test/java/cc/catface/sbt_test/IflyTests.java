package cc.catface.sbt_test;

import cc.catface.sbt_test.domain.FourTypeBean;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class IflyTests {

    @Test
    public void sort4Type() {
        List<FourTypeBean> list = new ArrayList<>();
        List<FourTypeBean> list1 = new ArrayList<>();
        List<FourTypeBean> list2 = new ArrayList<>();
        List<FourTypeBean> list3 = new ArrayList<>();
        List<FourTypeBean> list4 = new ArrayList<>();

        list1.add(new FourTypeBean("zhangsan1", 3));
        list1.add(new FourTypeBean("lisi1", 0));
        list1.add(new FourTypeBean("wanger1", 1));
        list1.add(new FourTypeBean("ashe1", 2));

        list2.add(new FourTypeBean("zhangsan2", 2));
        list2.add(new FourTypeBean("lisi2", 3));
        list2.add(new FourTypeBean("wanger2", 0));
        list2.add(new FourTypeBean("ashe2", 1));

        list3.add(new FourTypeBean("zhangsan3", 0));
        list3.add(new FourTypeBean("lisi3", 2));
        list3.add(new FourTypeBean("wanger3", 3));
        list3.add(new FourTypeBean("ashe3", 1));

        list4.add(new FourTypeBean("zhangsan4", 1));
        list4.add(new FourTypeBean("lisi4", 0));
        list4.add(new FourTypeBean("wanger4", 3));
        list4.add(new FourTypeBean("ashe4", 2));

        list.addAll(list1);
        list.addAll(list2);
        list.addAll(list3);
        list.addAll(list4);


        System.out.println(list);


    }

}
