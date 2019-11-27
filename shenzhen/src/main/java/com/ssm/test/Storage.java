package com.ssm.test;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Storage {
	private Student student;

    // 仓库存储的载体
    private LinkedBlockingQueue<Object> list = new LinkedBlockingQueue<Object>(2);
    
    private ConcurrentLinkedQueue<Object> nio = new ConcurrentLinkedQueue<Object> ();

    public void produce() {
        try{
            list.put(this.student);
            System.out.println("【生产者" + Thread.currentThread().getName()
                    + "】生产一个产品，现库存" + list.size()+",存入对象为:" +this.student);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    public void consume() {
        try{
            Student student = (Student) list.take();
            System.out.println("【消费者" + Thread.currentThread().getName()
                    + "】消费了一个产品，现库存" + list.size()+",消费的数据为:" +student);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }
    
    public void nioproduce() {
        try{
        	nio.offer(this.student);
            System.out.println("【生产者" + Thread.currentThread().getName()
                    + "】生产一个产品，现库存" + nio.size()+",存入对象为:" +this.student);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public void nioconsume() {
        try{
            Student student = (Student) nio.poll();
            System.out.println("【消费者" + Thread.currentThread().getName()
                    + "】消费了一个产品，现库存" + nio.size()+",消费的数据为:" +student);
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    
    
    public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public static void main(String[] args) {
		Storage storage = new Storage();
		Student s1 = new Student();
		s1.setAge(30);
		s1.setName("Jerry");
		storage.setStudent(s1);
		storage.nioproduce();
		Student s2 = new Student();
		s2.setAge(32);
		s2.setName("Jackson");
		storage.setStudent(s2);
		storage.nioproduce();
		Student s3 = new Student();
		s3.setAge(36);
		s3.setName("Tony");
		storage.setStudent(s3);
		storage.nioproduce();
		storage.nioconsume();
		storage.nioconsume();
		storage.nioconsume();
		storage.nioconsume();
		
	}
}
