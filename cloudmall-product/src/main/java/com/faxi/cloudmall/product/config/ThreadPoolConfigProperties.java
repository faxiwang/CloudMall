package com.faxi.cloudmall.product.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/** faxi
 * @date 2021-08-16 21:40
 */

@ConfigurationProperties(prefix = "cloudmall.thread")
@Data
public class ThreadPoolConfigProperties {

    private Integer coreSize;

    private Integer maxSize;

    private Integer keepAliveTime;


}
