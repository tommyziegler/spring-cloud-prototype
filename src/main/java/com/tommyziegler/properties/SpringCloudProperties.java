package com.tommyziegler.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;

import java.util.LinkedHashMap;
import java.util.Map;

@RefreshScope
@ConfigurationProperties("com.tommyziegler.cloud-server")
public class SpringCloudProperties {

    @Getter @Setter
    private Map<String, HrefAndMethod> links = new LinkedHashMap<>();
}