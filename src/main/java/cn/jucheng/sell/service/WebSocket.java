package cn.jucheng.sell.service;

import cn.jucheng.sell.config.WebSocketConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.util.concurrent.CopyOnWriteArraySet;

@Component
@ServerEndpoint("/socket")
@Slf4j
public class WebSocket {

    private Session session;

    private static CopyOnWriteArraySet<WebSocket> webSockets = new CopyOnWriteArraySet<>();

    @OnOpen
    public void onOpen(Session session){
        this.session = session;
        webSockets.add(this);
        log.info("新的链接");
    }

    @OnClose
    public void onClose(Session session){
        webSockets.remove(this);
        log.info("断开链接");
    }

    @OnMessage
    public void onMessage(String message){

        log.info("收到消息:" + message);
    }

    public void sendMessage(String message){
        for (WebSocket webSocket : webSockets){
            try {
                webSocket.session.getBasicRemote().sendText(message);
            }catch (Exception e){
                log.error(e.getMessage());
            }

        }
    }
}

