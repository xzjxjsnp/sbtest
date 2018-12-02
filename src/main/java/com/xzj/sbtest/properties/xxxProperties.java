package com.xzj.sbtest.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "xxx")
@Data
public class xxxProperties {
    private String ppa;
    private String ppb;
}
