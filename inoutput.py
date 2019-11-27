# coding=utf8
name = input("Please input your name: ")
age = input("Please input your age: ")
sex = input("Please input your sex: ")

print("Information of " + name + ":" + "\n\tName:" + name + "\n\tAge:" + age + "\n\tSex:" + sex);

print("%拼接字符串");
name = input("Please input your name: ")
age = input("Please input your age: ")
sex = input("Please input your sex: ")

print("Information of \n\tName:%s\n\tAge:%s\n\tSex:%s" %(name,age,sex));


#使用单引号('''''')或者双引号("""""")的方式

name = input("Please input your name: ")
age = input("Please input your age: ")
sex = input("Please input your sex: ")
message = '''
Information of %s:
Name:%s
Age:%s
Sex:%s
'''%(name,name,age,sex)
print(message)