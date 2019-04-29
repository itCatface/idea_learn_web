package cc.catface.sbt_test.how2j.websocket;

import javax.servlet.ServletConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import java.util.Random;


@WebServlet(name="TestNumberServlet",urlPatterns = "/TestNumberServlet",loadOnStartup=1)
public class TestNumberServlet extends HttpServlet implements Runnable {

    public void init(ServletConfig config) {
        startup();
    }

    public void startup() {
        new Thread(this).start();
    }


    @Override
    public void run() {
        int initNumber = 10000;

        while (true) {
            int duration = 1000 + new Random().nextInt(2000);

            try {
                Thread.sleep(duration);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            float random = 1 + (float) (Math.random() - 0.5);
            int newNumber = (int) random * initNumber;

            int serverCount = TestNumberServerManager.getTotal();
            newNumber *= serverCount;

            String messageFormat = "{\"price\":\"%d\",\"total\":%d}";
            String message = String.format(messageFormat, newNumber, serverCount);
            //广播出去
            TestNumberServerManager.broadcast(message);
        }
    }
}
