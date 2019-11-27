package org.gaoliyuan.test.bean.sun;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

@Component
public class AnotherDemoBean implements InitializingBean {
	
	   
    public AnotherDemoBean() {
		System.err.println("---AnotherDemoBean初始化---");
	}
	@PostConstruct  
    public void postConstruct() {  
       System.out.println("AnotherDemoBean: postConstruct-method");  
    }    
    public void init() {  
       System.out.println("AnotherDemoBean: init-method");  
    }  
    public void afterPropertiesSet() throws Exception {  
       System.out.println("AnotherDemoBean: after properties set!");  
    }  
}  
