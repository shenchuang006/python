package com.ssm.json;

import java.util.Arrays;

import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

public class JacksonXMLTest {
    public static void main(String[] args) throws Exception {

        XmlMapper xmlMapper = new XmlMapper();  
        //xmlMapper.setDefaultUseWrapper(false);
        //字段为null，自动忽略，不再序列化
        //xmlMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        //XML标签名:使用骆驼命名的属性名，  
       // xmlMapper.setPropertyNamingStrategy(PropertyNamingStrategy.CAMEL_CASE_TO_LOWER_CASE_WITH_UNDERSCORES); 
        //设置转换模式 
        //xmlMapper.enable(MapperFeature.USE_STD_BEAN_NAMING);  

        //序列化 bean--->xml
        Group group = new Group();  //忍者班级

        Teacher teacher = new Teacher();
        teacher.setTeacherTypeCode(new TeacherType("0","严师"));
        teacher.setName("卡卡西");
        teacher.setAge("25");
        teacher.setGender("1");

        Student student1 = new Student();
        student1.setId("001");  //学号
        student1.setName("鸣人");
        student1.setAge("18");
        student1.setGender("1");

        Student student2 = new Student();
        student2.setId("002");  //学号
        student2.setName("佐助");
        student2.setAge("18");
        student2.setGender("1");

        Student student3 = new Student();
        student3.setId("003");  //学号
        student3.setName("小樱");
        student3.setAge("18");
        student3.setGender("0");

        group.setTeacher(teacher);
        group.setStudent(Arrays.asList(student1,student2,student3));

        String result = xmlMapper.writeValueAsString(group);
        System.out.println("序列化结果：" + result);
        String xml = xmlMapper.writer().with(SerializationFeature.WRAP_ROOT_VALUE).withRootName("Class").writeValueAsString(group);
        System.out.println("xml:" + xml);
        //Group gro = xmlMapper.readValue(xml, Group.class);
        //System.err.println(gro);
       /* XStream xstream = new XStream();
        xstream.alias("Class", Group.class);
        String xmls = xstream.toXML(group);
        System.out.println("xml:" + xmls);*/
       }
}
