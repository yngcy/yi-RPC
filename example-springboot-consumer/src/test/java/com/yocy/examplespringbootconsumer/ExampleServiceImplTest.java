package com.yocy.examplespringbootconsumer;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import javax.annotation.Resource;

/**
 * 单元测试
 */
@SpringBootTest
class ExampleServiceImplTest {

    /**
     * 按照类型注入，使用 Resource 可能注入失败
     */
    @Autowired
    private ExampleServiceImpl exampleService;

    @Test
    void test1() {
        exampleService.test();
    }

    @Autowired
    private ApplicationContext applicationContext;

    @Test
    void testPrintAllBeans() {
        String[] beanNames = applicationContext.getBeanDefinitionNames();
        for (String beanName : beanNames) {
            System.out.println(beanName);
        }
    }
}