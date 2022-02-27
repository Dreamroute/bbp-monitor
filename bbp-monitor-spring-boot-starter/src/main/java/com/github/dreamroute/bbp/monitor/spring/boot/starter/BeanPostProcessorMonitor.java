package com.github.dreamroute.bbp.monitor.spring.boot.starter;

import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.UnsynchronizedAppenderBase;
import lombok.Getter;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * 描述：监控控制台is not eligible for getting processed by all BeanPostProcessors信息，如果有，那么抛出异常，否则正常启动
 * 原理：
 * <ol>
 *     <li>首先将出发onApplicationEvent方法之前的日志记录在INFO中</li>
 *     <li>当触发onApplicationEvent时候检查是否有警告，并且通知appender关闭自定义appender</li>
 *     <li>如果是STOP，那么关闭Appender</li>
 * </ol>
 *
 *
 * @author w.dehi.2022-02-27
 */
@Getter
@Component
public class BeanPostProcessorMonitor extends UnsynchronizedAppenderBase<ILoggingEvent> implements ApplicationListener<ContextRefreshedEvent> {

    /**
     * 在onApplicationEvent方法中无法调用UnsynchronizedAppenderBase的stop方法，所以这里使用ThreadLocal，通过参数值的方式来确定关闭appender
     */
    private static final ThreadLocal<String> INFO = ThreadLocal.withInitial(String::new);
    private static final String STOP = "STOP";

    @Override
    public void append(ILoggingEvent event) {
        if (Objects.equals(STOP, INFO.get())) {
            super.stop();
            INFO.remove();
        }

        String info = INFO.get();
        info += event.getFormattedMessage();
        INFO.set(info);
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        String info = INFO.get();
        if (info.contains("is not eligible for getting processed by all BeanPostProcessors")) {
            throw new IllegalArgumentException("你的日志中存在is not eligible for getting processed by all BeanPostProcessors，请检查并处理");
        }
        System.out.println("BeanPostProcessorMonitor检查执行完毕，正常！");
        INFO.set(STOP);
    }
}