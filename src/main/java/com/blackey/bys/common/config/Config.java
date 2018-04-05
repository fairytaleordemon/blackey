package com.blackey.bys.common.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    @Value("${http.domain}")
    public static String domain;


    public static String getDomain() {
        return domain;
    }

    public static void setDomain(String domain) {
        Config.domain = domain;
    }
}
