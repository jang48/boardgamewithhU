package project.thirdproject;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.config.annotation.*;

@Configuration
@EnableWebSocket  //webSocket 활성화
@EnableWebSocketMessageBroker
@RequiredArgsConstructor
//public class WebSocketConfig implements WebSocketConfigurer {
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer{

//    private final WebSocketHandler chatHandler;
    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry){
        // 서버 -> 클라이언트로 발행하는 메세지에 대한 endpoint 설정 : 구독
        registry.enableSimpleBroker("/queue","/topic");
        // 클라이언트->서버로 발행하는 메세지에 대한 endpoint 설정 : 구독에 대한 메세지
        registry.setApplicationDestinationPrefixes("/app");
    }
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry){
        registry.addEndpoint("/ChatingServer") // URL을 웹소켓 엔드포인트로 등록한다. 클라이언트는 이 URL을 통해 웹소켓 연결을 초기화
                .setAllowedOrigins("http://localhost:8800").withSockJS();
//                .setInterceptors(new HttpSessionHandshakeInterceptor()); // 세션에 접근하기 위한 인터셉터 추가
    }





//    @Override
//    // 클라이언트가 메시지를 구독할 endpoint를 정의합니다.
//    public void configureMessageBroker(MessageBrokerRegistry config) {
//        config.enableSimpleBroker("/send");
//    }

//    @Override
//    // connection을 맺을때 CORS 허용합니다.
//    public void registerStompEndpoints(StompEndpointRegistry registry) {
//        registry.addEndpoint("/ws/chatting").setAllowedOrigins("*").withSockJS();
//    }


//
//    private final WebSocketHandler webSocketHandler;
//    @Override
//    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry){
//        registry.addHandler(webSocketHandler,"/wss/chat")
//                .setAllowedOrigins("*")
//                .withSockJS();
//    }
}
