package com.ssm.test.compare;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Person implements Comparator<Person>{
	public String name;
    public Integer age;
    
    public long count;
    
    public Person(String n, Integer a,Long count){
        name = n;
        age = a;
        count = count;
    }
    
    public Person(String n, Integer a){
        name = n;
        age = a;
    }
    
    public Person() {
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}
	
	public Long getCount() {
		return count;
	}

	public void setCount(Long count) {
		this.count = count;
	}

	@Override
    public int compare(Person o1, Person o2) {
        return o2.getCount() - o1.getCount() >= 0 ? 1 : -1;
    }

	public  String toString() {
        return String.format("Name is %s, Age is %d%n", name, age);
    }
	public static void main(String[] args) {
		for(int i = 0;i<200000;i++){
			Person p1 = new Person("bob", 9);
			p1.setCount(2L);
	        Person p2 = new Person("albert", 8);
	        p2.setCount(3L);
	        Person p3 = new Person("bob", 13);
	        p3.setCount(4L);
	        
	        Person p4 = new Person("bob", 13);
	        p4.setCount(4L);
	        
	        List<Person> list = new ArrayList<Person>();
	        list.add(p1);
	        list.add(p2);
	        list.add(p3);
	        list.add(p4);
	        System.out.printf("排序前：%n");
	        for (Person person : list) {
	            System.out.printf(person.toString());
	        }
	        //PersonComparator comparator = new PersonComparator();
	        Person comparator = new Person();
	        Collections.sort(list, comparator);
	        System.out.printf("排序后：%n");
	        for (Person person : list) {
	            System.out.printf(i+":<--->"+person.toString());
	        }
		}
		
	}
}
