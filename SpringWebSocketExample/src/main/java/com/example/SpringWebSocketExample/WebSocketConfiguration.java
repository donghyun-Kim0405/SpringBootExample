package com.example.SpringWebSocketExample;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;

@Configuration
@EnableWebSocket
@EnableWebSocketMessageBroker
public class WebSocketConfiguration extends AbstractWebSocketMessageBrokerConfigurer {


    private static final String URL = "http://000.000.00.000:80";



    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/mobileServer").setAllowedOrigins(URL).withSockJS();
    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry config) {
        config.setApplicationDestinationPrefixes("/app");
        // android -> send("/app/message") 수행 할 경우
        //Controller의  @MessageMapping("/message")로 보내진다.
        config.enableSimpleBroker("/sub");
        // -> /app/message 수행시 -> /sub/message구독하는 clinet들에게 모두 전송

        config.setUserDestinationPrefix("/sub");
    }

}



