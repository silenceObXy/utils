package com.example.utilsdemo.util;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class BeanInitTimeTracker implements BeanPostProcessor, ApplicationListener<ContextRefreshedEvent>, InitializingBean {

    // 存储 Bean 名称及其初始化耗时（单位：毫秒）
    private final Map<String, Long> beanInitTimes = new ConcurrentHashMap<>();
    // 临时存储每个 Bean 的初始化开始时间
    private final ThreadLocal<Map<String, Long>> startTimeHolder = ThreadLocal.withInitial(HashMap::new);

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        // 记录初始化开始时间
        startTimeHolder.get().put(beanName, System.currentTimeMillis());
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        // 计算耗时并保存
        Long startTime = startTimeHolder.get().remove(beanName);
        if (startTime != null) {
            long cost = System.currentTimeMillis() - startTime;
            beanInitTimes.put(beanName, cost);
        }
        return bean;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        // 应用启动完成后，打印耗时报告
        ApplicationContext context = event.getApplicationContext();
        String[] beanNames = context.getBeanDefinitionNames();

        System.out.println("\n===== Bean 初始化耗时报告 =====");
        beanInitTimes.entrySet().stream()
                .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                .forEach(entry -> {
                    String beanName = entry.getKey();
                    long cost = entry.getValue();
                    System.out.printf("[Bean: %-40s] 耗时: %4d ms\n", beanName, cost);
                });
        System.out.println("===============================");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("我完成了");
    }
}
