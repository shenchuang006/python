package com.ssm.json;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class Teacher {
	protected static final String FORMAT = "yyyy-MM-dd";
    @JacksonXmlProperty(localName = "TypeCode")
    private TeacherType teacherTypeCode;
    private String name;
    private String gender;
    private String age;

    public TeacherType getTeacherTypeCode() {
        return teacherTypeCode;
    }

    public void setTeacherTypeCode(TeacherType teacherTypeCode) {
        this.teacherTypeCode = teacherTypeCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
    public static void main(String[] args) throws Exception {
		String abc = "abcDXy";
		System.err.println(abc.substring(abc.indexOf("DX")));
		System.err.println(Teacher.getTableSuffix("SO1904200533115658735"));
		System.err.println(Teacher.commonTableSuffix("SO1904235641700748280"));
		System.err.println("CGTH".endsWith("TH"));
		System.err.println(Teacher.changelog("Y21307"));
		System.err.println(Teacher.dateImx("2019-07-25"));
		Date date  = Teacher.dateImx("2019-04-24");
		System.err.println(Teacher.getDailyDate(date, 92));
		
	}
    
    
    public static String getTableSuffix(String id){
        if(id.indexOf("SO")>-1) {
            Integer num = Integer.valueOf(id.substring(9, 13));
            long index = num % 1024;
            String format = "%0"+("_0000".length()-1)+"d";
            return "_"+ String.format(format, index);
        }
        return null;
    }
    
    public static String commonTableSuffix(String id){
        long index = Math.abs(id.hashCode()) % 64;
        String format = "%0"+2+"d";
        return "_"+ String.format(format, index);
    }
    
    public static String changelog(String id){
        long routeValue = Math.abs(id.hashCode());
        long index = routeValue%1024;
        String format = "%0"+(5-1)+"d";
        return "_"+ String.format(format, index);
    }
    
 // 获取两天后的时间.
 	public static Date getDailyDate(Date dy, int day) throws Exception {
 		SimpleDateFormat sdf = new SimpleDateFormat(FORMAT);
 		Calendar date = Calendar.getInstance();
 		date.setTime(dy);
 		date.add(Calendar.DAY_OF_MONTH, day);
 		date.set(Calendar.HOUR_OF_DAY, 0);
 		date.set(Calendar.MINUTE, 0);
 		date.set(Calendar.SECOND, 0);
 		return sdf.parse(sdf.format(date.getTime()));
 	}
 	
 	public static Date dateImx(String date) throws Exception{
 		SimpleDateFormat sdf = new SimpleDateFormat(FORMAT);
 		return sdf.parse(date);
 	}
}
