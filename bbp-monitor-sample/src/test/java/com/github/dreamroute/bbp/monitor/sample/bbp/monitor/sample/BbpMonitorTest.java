package com.github.dreamroute.bbp.monitor.sample.bbp.monitor.sample;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BbpMonitorTest {

    /**
     * 1. 正常启动，使用@SpringBootApplication(scanBasePackageClasses = {Application.class})
     * 2. 异常启动，使用@SpringBootApplication(scanBasePackageClasses = {Application.class, A.class, B.class})
     */
    @Test
    void normalTest() {}


}
