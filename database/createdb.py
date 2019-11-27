#coding=utf-8
import os ;
import sqlite3;
import smtplib;
conn = sqlite3.connect('sample_database');
cursor = conn.cursor();

'''
cursor.execute("""
drop table user;
""");

cursor.execute("""
drop table department;
""");
cursor.execute("""
drop table employee;
""");
'''

'''
cursor.execute("""
create table employee(
empid integer,
firstname varchar,
lastname varchar,
dept integer,
manager integer,
phone varchar,
PRIMARY key (empid)
)""");
cursor.execute("""
create table department(
departmentid integer,
name VARCHAR ,
manager INTEGER,
PRIMARY key (departmentid)
);
""");

cursor.execute("""
create table user(
userid INTEGER ,
username VARCHAR ,
employeeid INTEGER,
PRIMARY key (userid)
);
""");

'''

'''
cursor.execute("""
create index userid on user(userid);
""");
cursor.execute("""
create index empid on employee(empid);
""");
cursor.execute("""
create index deptid on department(departmentid);
""");
cursor.execute("""
create index deptfk on employee (dept);
""");
cursor.execute("""
create index mgr on employee (manager);
""");
cursor.execute("""
create index emplid on user(employeeid);
""");
cursor.execute("""
create index deptmgr on department(manager);
""");
cursor.execute("""
create unique index userid on user(userid);
""");
cursor.execute("""
select * from employee""");
cursor.execute("""
select * from department""");
cursor.execute("""
select * from user """);
cursor.execute("""
  insert into user(userid,username,employeeid)values(3,'jerry',3)""");
'''



conn.commit();

'''
cursor.execute("""
delete from user """);
'''
cursor.execute("""
select * from user """);

for row in cursor.execute('select * from user'):
    print(row);
cursor.close();
conn.close();

#python处理xml

server = smtplib.SMTP("smtp.partner.outlook.cn",587);
server.sendMail("oms@yunjiweidian.com","shenchuang@yunjiglobal.com","你好");
