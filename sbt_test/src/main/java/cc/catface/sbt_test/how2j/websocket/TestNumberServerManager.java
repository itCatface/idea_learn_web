package cc.catface.sbt_test.how2j.websocket;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class TestNumberServerManager {

    private static Collection<TestNumberServer> servers = Collections.synchronizedCollection(new ArrayList<TestNumberServer>());

    public static void broadcast(String msg) {
        for (TestNumberServer server : servers) {
            try {
                server.sendMsg(msg);
            } catch (Exception e) {
                System.out.println("TestNumberServerManager->broadcast异常：" + e.getMessage());
            }
        }
    }

    public static int getTotal() {
        return servers.size();
    }

    public static void add(TestNumberServer server) {
        System.out.println("有新连接接入 & 当前连接数：" + servers.size());
        servers.add(server);
    }

    public static void remove(TestNumberServer server) {
        System.out.println("有连接退出 & 当前连接数：" + servers.size());
        servers.remove(server);
    }

}
