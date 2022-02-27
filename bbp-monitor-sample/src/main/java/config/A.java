package config;

import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author w.dehi.2022-02-27
 */
@Component
public class A implements BeanPostProcessor {
    @Resource
    private B b;
}
