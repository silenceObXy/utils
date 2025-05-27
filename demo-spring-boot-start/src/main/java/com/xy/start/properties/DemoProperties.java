package com.xy.start.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @Author: xy
 * @Date: 2025-05-27 16:54
 * @Description:
 */
@ConfigurationProperties(prefix = "demo")
@Data
public class DemoProperties {
    private String sayWhat;
    private String toWho;
}
