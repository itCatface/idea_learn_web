package cc.catface.sbt_test.iflytek.yys.engine;

/**
 Created by catfaceWYH --> tel|wechat|qq 130 128 92925
 */
public class Common {

    public static final String rootPathAH = "D:\\projects\\idea\\idea_learn_web\\sbt_test\\src\\main\\java\\cc\\catface\\iflytek\\yys\\results\\ahyd\\";
    public static final String rootPathSD = "D:\\projects\\idea\\idea_learn_web\\sbt_test\\src\\main\\java\\cc\\catface\\iflytek\\yys\\results\\sdyd\\";


    public static void sleep(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
