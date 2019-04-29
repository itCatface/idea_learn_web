package cc.catface.sbt_test.how2j.websocket;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;

@ServerEndpoint("/ws/testNumberServer")
public class TestNumberServer {

    private Session session;

    @OnOpen
    public void onOpen(Session session) {
        this.session = session;
        TestNumberServerManager.add(this);
    }

    public void sendMsg(String msg) throws IOException {
        this.session.getBasicRemote().sendText(msg);
    }

    @OnClose
    public void onClose() {
        TestNumberServerManager.remove(this);
    }

    @OnMessage
    public void onMessage(String msg, Session session) {
        System.out.println("来自客户端消息：" + msg);
    }

    @OnError
    public void onError(Session session, Throwable throwable) {
        System.out.println("onError-->发生错误：" + throwable.getMessage());
    }

}
