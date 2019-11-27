package com.ssm.mongodb;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.annotation.Id;

/**
 * 人信息
* @ClassName:Person 
* @version:1.0.0
* @Description:  
* @author: Sc 
* @date: 2019年8月22日 下午7:09:17
 */
public class Person implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 481128421559410726L;
	private String name;
	private String sex;
	private Integer age;
	private String country;
	private String city;
	private String county;
	private String town;
	private String phone;
	private List<String> hobbies;
	private List<Detail> details;
	@Id
	private Integer id;
	public Person() {
		super();
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
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getCounty() {
		return county;
	}
	public void setCounty(String county) {
		this.county = county;
	}
	public String getTown() {
		return town;
	}
	public void setTown(String town) {
		this.town = town;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public List<String> getHobbies() {
		return hobbies;
	}
	public void setHobbies(List<String> hobbies) {
		this.hobbies = hobbies;
	}
	public List<Detail> getDetails() {
		return details;
	}
	public void setDetails(List<Detail> details) {
		this.details = details;
	}

	static class Detail implements Serializable{
		
		/**
		 * 
		 */
		private static final long serialVersionUID = 6917426661578072584L;
		private String userName;
		private String password;
		private Integer id;
		public Detail() {
		}
		public String getUserName() {
			return userName;
		}
		public void setUserName(String userName) {
			this.userName = userName;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public Integer getId() {
			return id;
		}
		public void setId(Integer id) {
			this.id = id;
		}
		@Override
		public String toString() {
			return "Detail [userName=" + userName + ", password=" + password
					+ ", id=" + id + "]";
		}
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", sex=" + sex + ", age=" + age
				+ ", country=" + country + ", city=" + city + ", county="
				+ county + ", town=" + town + ", phone=" + phone + ", hobbies="
				+ hobbies + ", details=" + details + ", id=" + id + "]";
	}
	
}
