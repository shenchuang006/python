#! /usr/bin/env python
# -*- coding: utf-8 -*-
def  hello(name):
    strHello='Hello, '+name
    return strHello;

print (hello("Python!"))

print (hello("你好，世界!"))

def foo():
    str="function"
    print(str);

def foo1(num):
    print('num' ,num);

def foo2(name ,age):
    print('name' ,name);
    print('age' ,age);

if __name__=="__main__":
    print("main")
    foo2('yuhui' ,30)
    foo1(6)
    foo()

if True:
    print("true")
else:
    print("false")

encouter=100
name="Jim"
fmx=100.98
print (encouter)
print (name)
print (fmx)

a=b=c=d=1
e,f,g=1,2,"Jerry"
print(c)
print(g)
s="abcdefg"
print(s)
s=s[1:4]#包含头,不包含尾部
print(s)
#list
list = [ 'runoob', 786 , 2.23, 'john', 70.2 ]
tinylist = [123, 'john']
print(list)
print(list[1:3])
#元组
tuple=('Jerry','Jim','Tom','Jack')
print(tuple[1:3])
#字典
dict = {}
dict['one'] = "This is one"
dict[2] = "This is two"

tinydict = {'name': 'john','code':6734, 'dept': 'sales'}


print (dict['one'])         # 输出键为'one' 的值
print (dict[2])              # 输出键为 2 的值
print (tinydict)             # 输出完整的字典
print (tinydict.keys())      # 输出所有键
print (tinydict.values())    # 输出所有值


Money = 2000
def AddMoney():
    # 想改正代码就取消以下注释:
    global Money
    Money = Money + 1

print (Money)
AddMoney()
print (Money)
#
print(111)