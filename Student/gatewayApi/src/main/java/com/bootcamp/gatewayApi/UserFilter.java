package com.bootcamp.gatewayApi;

import lombok.Data;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.stereotype.Component;


import java.util.List;
import java.util.function.Consumer;

@Component
public class UserFilter extends AbstractGatewayFilterFactory<UserFilter.Config> {

    public UserFilter(){
        super(Config.class);
    }

    @Override
    public GatewayFilter apply(Config config) {
        return null;
    }

    @Data
    public static class Config{
        private String firstName;
        private String lastName;
    }


}
