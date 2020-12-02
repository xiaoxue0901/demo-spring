package com.fall;

import static org.junit.Assert.assertTrue;

import com.fall.ioc.config.MyConfig;
import com.sun.xml.internal.xsom.parser.AnnotationContext;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }

    @Test
    public void beanPostProcessor() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);
        System.out.println("容器初始化完成");
        context.close();
    }
}
