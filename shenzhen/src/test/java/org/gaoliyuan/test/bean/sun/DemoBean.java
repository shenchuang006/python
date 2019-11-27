package org.gaoliyuan.test.bean.sun;

import javax.annotation.PostConstruct;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component  
public class DemoBean implements BeanFactoryAware, BeanNameAware,  
        InitializingBean, DisposableBean {
	@Autowired
	private AnotherDemoBean AnotherDemoBean;
    @PostConstruct
    public void postConstruct(){
    	System.out.println("DemoBean: @postConstruct");
    }
    public void init() {  
       System.out.println("DemoBean: init-method");  
    }  
    public void destroy() throws Exception {  
       System.out.println("DemoBean: destroy-method!");  
    }  
    public void afterPropertiesSet() throws Exception {  
       System.out.println("DemoBean: after properties set!");  
    }  
    public void setBeanName(String name) {  
       System.out.println("DemoBean: beanName aware, [name=" + name + "]");  
    }  
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {  
       System.out.println("DemoBean: beanFactory aware, [beanFactory=" + beanFactory.toString() + "]");  
    }  
}  
