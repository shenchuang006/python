package com.ssm.mongodb;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import org.bson.Document;
import org.junit.Test;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.util.StringUtils;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.WriteResult;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Sorts;
import com.ssm.mongodb.Person.Detail;

public class MongodbTest {
	
	
	@Test
	public void testabcd(){
		String abc = "abc";
		String mx = "amx:33";
		System.err.println(abc.split(":")[0].toString()+"," + abc.split(":").length);
		System.err.println(mx.split(":").toString());
	}
	
	/**
	 * 插入
	* @Description: 
	* @throws Exception 
	* void
	*
	 */
	@Test
	public void insert() throws Exception{
		MongoTemplate  mongo = this.mongodb();
		System.err.println(mongo);
		String table = "person";
		//mongo.createCollection(table);
		Person person = new Person();
		person.setId(7);
		person.setAge(30);
		person.setName("Tome");
		person.setSex("Male");
		person.setCountry("中国");
		person.setCity("驻马店市");
		person.setTown("王勿桥乡");
		person.setCounty("正阳县");
		List<String> hobbies = new ArrayList<String>();
		hobbies.add("baseketball");
		hobbies.add("dance");
		hobbies.add("sing");
		hobbies.add("football");
		
		List<Person.Detail> details = new ArrayList<Person.Detail>();
		Detail detail1 = new Detail();
		detail1.setId(1);
		detail1.setUserName("abc");
		detail1.setPassword("1234");
		details.add(detail1);
		
		Detail detail2 = new Detail();
		detail2.setId(2);
		detail2.setUserName("abc");
		detail2.setPassword("123456");
		details.add(detail2);
		
		Detail detail3 = new Detail();
		detail3.setId(3);
		detail3.setUserName("abcdf");
		detail3.setPassword("12345678");
		details.add(detail3);
		
		person.setHobbies(hobbies);
		person.setDetails(details);
		
		mongo.insert(person, table);
	}
	
	/**
	 * 查询
	* @Description: 
	* @throws Exception 
	* void
	*
	 */
	@Test
	public void query() throws Exception{
		MongoTemplate  mongo = this.mongodb();
		System.err.println(mongo);
		ObjectMapper mapper = new ObjectMapper();
		String table = "person";
		//mongo.createCollection(table);
		Person person = new Person();
		person.setId(1);
		/*person.setAge(20);
		person.setName("Jim");
		person.setSex("Male");
		person.setCountry("中国");
		person.setCity("驻马店市");
		person.setTown("王勿桥乡");
		person.setCounty("正阳县");*/
		Query query = new Query();
		query.query(Criteria.where("_id").is(4));
		List<Person> moList = mongo.find(query, Person.class);
		System.err.println(mapper.writeValueAsString(moList));
		
	}
	
	/**
	 * 更新
	* @Description: 
	* @return
	* @throws Exception 
	* MongoTemplate
	*
	 */
	@Test
	public void update() throws Exception{
		MongoTemplate  mongo = this.mongodb();
		System.err.println(mongo);
		String table = "person";
		//mongo.createCollection(table);
		Person person = new Person();
		person.setId(1);
		person.setAge(30);
		person.setPhone("10086");
		Query query = new Query();
		query.query(Criteria.where("id").is(person.getId()));
		Update update = new Update();
		if(person.getAge() != null){
			update.set("age", person.getAge());
		}
		if(!StringUtils.isEmpty(person.getPhone())){
			update.set("phone", person.getPhone());
		}
		//返回旧数据
		Person result = mongo.findAndModify(query, update, Person.class);
		System.err.println(JSONObject.toJSON(result));
	}
	
	private Update updateBulid(){
		Update update = new Update();
		return update;
	}
	
	@Test
	public void remove() throws Exception{
		MongoTemplate  mongo = this.mongodb();
		System.err.println(mongo);
		String table = "person";
		//mongo.createCollection(table);
		Person person = new Person();
		person.setId(1);
		
		WriteResult result = mongo.remove(person, table);
		System.err.println(JSONObject.toJSON(result));
	}
	
	/**
	 * 内嵌文档查询
	* @Description: 
	* @throws Throwable 
	* void
	*
	 */
	@Test
	public void testDocument() throws Throwable{
		MongoTemplate  mongo = this.mongodb();
		System.err.println(mongo);
		//Criteria cri = Criteria.where("$gt").is(90).and("$lt").is(100); 
		Criteria cri = Criteria.where("_id").is(2).and("userName").is("abcd");  
	    Query query = new Query(Criteria.where("details").elemMatch(cri));  
	    query.query(Criteria.where("_id").gte(1))/*.fields().include("details")*/;  
	    List<Person> pesons = mongo.find(query, Person.class);  
	    for(Person man : pesons) {  
	        System.out.println(man.toString());  
	    }     
	}
	
	/**
	 * 修改匹配到的内嵌文档中的数据
	* @Description: 
	* @throws Throwable 
	* void
	*
	 */
	@Test
	public void testUpdateDocument() throws Throwable{
		MongoTemplate  mongo = this.mongodb();
		System.err.println(mongo);
		
		Criteria cri = Criteria.where("userName").is("abc");  
	    Query query = new Query(Criteria.where("details").elemMatch(cri));  
	    query.query(Criteria.where("_id").is(7))/*.fields().include("details")*/; 
	    //批量更新数据
	    List<Person> persons = mongo.find(query, Person.class);
	    for(Person person : persons){
	    	List<Detail> details = person.getDetails();
	    	Update update = new Update();
	    	for(int i = 0;i < details.size();i++){
	    		if(details.get(i).getId() == 1){
	    			update.set("details."+i+".userName", "efghi");
	    			update.set("details."+i+".password", "9098766");
	    		}else if(details.get(i).getId() ==2){
	    			update.set("details."+i+".userName", "mmineee");
	    			update.set("details."+i+".password", "5522146");
	    		}
	    		WriteResult result = mongo.upsert(query, update, Person.class);
	    		System.out.println(result.toString());  
	    	}
	    }
	}
	
	/**
	 * 删除数组中制定的原始
	* @Description: 
	* @throws Exception 
	* void
	*
	 */
	@Test
	public void testRemoveDocument() throws Exception{
		MongoTemplate  mongo = this.mongodb();
		System.err.println(mongo);
		
		Criteria cri = Criteria.where("_id").is(2).and("userName").is("abcd");  
	    Query query = new Query(Criteria.where("details").elemMatch(cri));  
	    query.query(Criteria.where("_id").is(6))/*.fields().include("details")*/; 
	    Update update = new Update();
	    //update.unset("details.$");//会出现null
	    Document doc = new Document();
	    doc.put("_id", 2);
	    update.pull("details", doc);//避免出现null值情况
	    WriteResult result = mongo.upsert(query, update, Person.class);
	    System.out.println(result.toString());  
	}
	
	
	
	@Test
	public void testQueryDocument() throws Exception{
		MongoCollection<Document> collection = this.collection();
		ObjectMapper mapper = new ObjectMapper();
		//System.err.println(mapper.writeValueAsString(collection));
        BasicDBObject query = new BasicDBObject();
        
        query.put("_id", new BasicDBObject("$gte", 1));
        MongoCursor<Document> cursor = 
        		collection.find(query).skip(0).limit(10).iterator();
        while (cursor.hasNext()) {
            Document user = cursor.next();
            System.err.println(mapper.writeValueAsString(user));
        }
        //根据索引查询
        FindIterable<Document> documents = collection.find(Filters.eq("hobbies.$.1", "dance"));
        Document d = documents.first();
        System.out.println("$.index:"+d);
        
        //全量匹配
        documents = collection.find(Filters.all("hobbies", new String[]{"baseketball","dance"}));
        for(Document document : documents){
        	System.err.println("$all:"+document.toJson());
        }
        //内嵌文档查询
        //new BasicDBObject("","$elemMatch", new BasicDBObject("userName","abcd").append("_id", 2)
        BasicDBObject q = new BasicDBObject();
        q.put("_id", new BasicDBObject("$gte",1));
        q.put("details",new BasicDBObject("$elemMatch",new BasicDBObject("userName","abcd").append("_id", 2)));
        FindIterable<Document> docs = collection.find(q);
        for(Document document : docs){
        	System.err.println("$eleMatch:"+document.toJson());
        }
        //内嵌文档更新
        BasicDBObject qs = new BasicDBObject();
        qs.put("_id", 3);
        qs.put("details",new BasicDBObject("$elemMatch",new BasicDBObject("userName","efghi").append("_id", 2)));   
	}
	
	
	public void testabc(){
		MongoClient mongoClient = new MongoClient( "localhost" , 27017 );

        MongoDatabase mongoDatabase =mongoClient.getDatabase("xxxx");

        MongoCollection<Document> collection = mongoDatabase.getCollection("test_logs");
        

        //加入查询条件
        BasicDBObject query = new BasicDBObject();
        //时间区间查询 记住如果想根据这种形式进行时间的区间查询 ，存储的时候 记得把字段存成字符串，就按yyyy-MM-dd HH:mm:ss 格式来
        query.put("times", new BasicDBObject("$gte", "2018-06-02 12:20:00").append("$lte","2018-07-04 10:02:46"));
        //模糊查询
        Pattern pattern = Pattern.compile("^.*王.*$", Pattern.CASE_INSENSITIVE);
        query.put("userName", pattern);
        //精确查询
        query.put("id", "11");
        //skip 是分页查询，从第0条开始查10条数据。 Sorts是排序用的。有descending 和ascending
        MongoCursor<Document> cursor = collection.find(query).sort(Sorts.orderBy(Sorts.descending("times"))).skip(0).limit(10).iterator();
	}
	
	private MongoCollection<Document> collection(){
		MongoClient mongoClient = new MongoClient( "localhost" , 27017 );
        MongoDatabase mongoDatabase =mongoClient.getDatabase("animal");
        MongoCollection<Document> collection = mongoDatabase.getCollection("person");
        return collection;
	}
	
	private MongoTemplate mongodb() throws Exception{
		MongoClient bean = new MongoClient("localhost:27017");
		MongoTemplate  mongo = new MongoTemplate(bean,"animal");
		return mongo;
	}

}
