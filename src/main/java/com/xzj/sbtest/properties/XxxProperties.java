package com.xzj.sbtest.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * xxxProperties class
 *
 * @author ppx
 * @date 2018/12/09
 */
@Component
@ConfigurationProperties(prefix = "xxx")
@Data
public class XxxProperties {
    private String ppa;
    private String ppb;
}
