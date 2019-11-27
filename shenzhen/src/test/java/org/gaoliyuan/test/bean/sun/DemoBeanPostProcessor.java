package org.gaoliyuan.test.bean.sun;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

@Component  
public class DemoBeanPostProcessor implements BeanPostProcessor {  
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {  
       System.out.println("DemoBeanPostProcessor: post process before initialization, [beanName=" + beanName + ", bean=" + bean + "]");  
       return bean;  
    }  
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {  
       System.out.println("DemoBeanPostProcessor: post process before initialization, [beanName=" + beanName + ", bean=" + bean + "]");  
       return bean;  
    }  
}  
