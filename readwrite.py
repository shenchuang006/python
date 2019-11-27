#coding=utf-8
import json;
#文件读写
# windows平台 b 模式以二进制方式打开文件,
#所以就以rb wb r+b
f = open("calc.py","rb");
print (f);
#print(f.read());
print("#"*20);
print(f.readline());

print(f.readlines());
print("---" *20);
f.close();
f = open("output.py","rb");
for line in f :
    print(line,end="");

f.close();
print("\n");
f = open("test.txt","r+");
f.write("This is a test\n");
print(f.readline());
#写入非字符串数据
value=("the answer",42);
s = str(value);
f.write(s);
print(f.readlines());
f.close();
'''
f.tell() 返回一个整数，代表文件对象在文件中的指针位置，
该数值计量了自文件开头到指针处的比特数。需要改变文件对象指针话话，
使用 f.seek(offset,from_what)。指针在该操作中从指定的引用位置移动 offset 比特，
引用位置由 from_what 参数指定。 
from_what 值为 0 表示自文件起始处开始，1 表示自当前文件指针位置开始，2 表示自文件末尾开始。
from_what 可以忽略，其默认值为零，此时从文件头开始:
'''
f = open("t.txt","rb");
#文件对象文职f.tell();
#f.write("0123456789abcdef");
#f.seek(5);
#print(f.read(1));

f.seek(-1,2);
print(f.read(1));
f.close();

x = json.dumps([1,2,3,4]);
print(x);
#json.dumps()函数的使用，将字典转化为字符串
dict = {"age":12};
json_info = json.dumps(dict);
print("dict的类型:",str(type(dict)));
print("通过json.dumps()函数处理,转化后数据类型:" +str(type(json_info)));
print("转化后数据:" + json_info)

#json字符串转换成对象
json_info = "{'age':12}";
#f = open("1.json","w",encoding='utf-8');
#json.dump(json_info,f);
#json.load() 函数读取json信息
file = open("1.json","r",encoding='utf-8');
info = json.load(file);
print(info);


