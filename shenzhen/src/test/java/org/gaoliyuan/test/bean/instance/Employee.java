package org.gaoliyuan.test.bean.instance;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Employee实现了3个接口：
 * InitializingBean：此接口提供afterPropertiesSet()方法，它的作用是为bean提供了定义初始化的功能。
 * DisposableBean：此接口提供destroy()方法，它的作用是在bean实例销毁前提供操作的功能。
 * BeanNameAware：此接口提供setBeanName()方法，它的作用是提供设置bean名称的功能，从上面的运行结果可以看出，此方法是在第二步进行的。
 */
//####################################################################################################
/**
 *  要想获取到一个bean对象，得先通过BeanFactory的getBean()方法获取，期间会经过一系列步骤来实例化这个bean对象：
 *	第一步：调用Bean的默认构造方法（当然也可以是指定的其它构造方法），生成bean实例：bean1。
 *	第二步：检查Bean配置文件中是否注入了Bean的属性值，如果有注入，则在bean1实例的基础上对其属性进行注入，把原来的bean1给覆盖掉形成新的bean实例：bean2。
 *	第三步：检查Bean是否实现了InitializingBean接口，如果实现了此接口，则调用afterPropertiesSet()方法对bean2进行相应操作后，把bean2覆盖形成新的bean实例：bean3。
 *	第四步：检查Bean配置文件中是否指定了init-method此属性，如果已指定，则调用此属性对应方法并对bean3进行相应操作后，最终把bean3覆盖形成新的实例：bean4。
 *	通过上面的步骤我们发现，Spring实例一个bean时，这个bean是在不断的变化的！
 */
/** 
 * 实体类 
 */  
public class Employee implements InitializingBean, DisposableBean, BeanNameAware {  
    private String id;//员工编号
    private String name;//员工姓名
    private String sex;//员工性别
    private String age;//员工年龄
    private String nativePlace;//员工籍贯
    private String department;//员工部门
    private String beanName;//bean的名称 
    //@Resource(name = "femaleEmployee")
    private FemaleEmployee femaleEmployee;
    //第一步	默认空参构造器
    public Employee() {  
        System.out.println("**********第一步：调用Bean的默认构造方法**********");  
        this.id = "bean1:G080405214";  
        System.out.println("bean1的 值：" + this);  
        System.out.println("**********第二步：检查Bean配置文件中是否注入了Bean的属性值**********");  
    }
    //第二步
    public void setBeanName(String arg0) {  
    	System.out.println("**********设置bean的名称**********");  
    	this.beanName = "myBeanName";
    }
    @PostConstruct
    public void construct(){
    	System.out.println("**********：通过@PostConstruct初始化bean**********---bean为:" + this);
    }
    //第三步
    public void afterPropertiesSet() throws Exception {  
        System.out.println("bean2的值：" + this);  
        System.out.println("**********第三步：检查Bean是否实现了InitializingBean接口**********");  
        this.name = "bean3:李晓红";  
        this.sex = "bean3:女";  
        this.age = "bean3:25";  
        System.out.println("bean3的值：" + this);  
    }
   //第四步
    public void init() {  
        System.out.println("**********第四步：检查Bean配置文件中是否指定了init-method此属性**********");  
        this.nativePlace = "bean3:北京";  
        System.out.println("bean4的值：" + this);  
    }
    //第五步
    public void destroy() throws Exception {  
        System.out.println("**********服务停止**********");  
    }
    public String getId() {  
        return id;  
    }
    public void setId(String id) {  
        this.id = id;  
    } 
    public String getName() {  
        return name;  
    }
    public void setName(String name) {  
        this.name = name;  
    }
    public String getSex() {  
        return sex;  
    }
    public void setSex(String sex) {  
        this.sex = sex;  
    }
    public String getAge() {  
        return age;  
    }
    public void setAge(String age) {  
        this.age = age;  
    }
    public String getNativePlace() {  
        return nativePlace;  
    }
    public void setNativePlace(String nativePlace) {  
        this.nativePlace = nativePlace;  
    }
    public String getDepartment() {  
        return department;  
    }
    public void setDepartment(String department) {  
        this.department = department;  
    }
    public String getBeanName() {  
        return beanName;  
    }
    
	public FemaleEmployee getFemaleEmployee() {
		return femaleEmployee;
	}
	public void setFemaleEmployee(FemaleEmployee femaleEmployee) {
		this.femaleEmployee = femaleEmployee;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", sex=" + sex
				+ ", age=" + age + ", nativePlace=" + nativePlace
				+ ", department=" + department + ", beanName=" + beanName
				+ ", femaleEmployee=" + femaleEmployee + "]";
	}
}  