a = 1
b = 2
h = ""
#为真时的结果 if 判定条件 else 为假时的结果
h = a-b if a>b else a+b

print(h);


# 字符串、列表、元组、字典、集合每个常用的5个方法？
# 字符串：title(),join(),replace(),strip(),split(),eval()
# 元组：count(),index(),sorted(tuple)
# 列表：insert(),extend(),append(),pop(),remove(),sort()
# 字典：get(),items(),values(),keys(),clear(),copy(),pop(),setdefault()
# 集合:add(),deference(),discard(),remove(),pop(),symmetric_difference(),union(),intersection_update

c = "abc";
print(c.title());
print(c.join('mx'));#追加
c.replace('abc','f')
print(c.replace('b','d'));


"""
可以这样认为,lambda作为一个表达式，定义了一个匿名函数，上例的代码x为入口参数，x+1为函数体。
在这里lambda简化了函数定义的书写形式。是代码更为简洁，但是使用函数的定义方式更为直观，易理解。

Python中，也有几个定义好的全局函数方便使用的，filter, map, reduce。
"""
from functools import reduce
foo = [2, 18, 9, 22, 17, 24, 8, 12, 27]
print (list(filter(lambda x: x % 3 == 0, foo)))
#[18, 9, 24, 12, 27]
print (list(map(lambda x: x * 2 + 10, foo)))
#[14, 46, 28, 54, 44, 58, 26, 34, 64]
#计算结果
print (reduce(lambda x, y: x + y, foo))
"""
比如上面
map的例子，可以写成:print ([x * 2 + 10 for x in foo]) 非常的简洁，易懂。 　　

filter的例子可以写成:print ([x for x in foo if x % 3 == 0]) 同样也是比lambda的方式更容易理解。
"""
print ([x * 2 + 10 for x in foo]);

print ([x for x in foo if x % 3 == 0])
import json
map = {"name":"jerry","age":10}
ss = json.dumps(map)
print(ss)
a = json.loads(ss)
print(a)
import hashlib

class Student(object):
    __slots__ = ('name', 'age') # 用tuple定义允许绑定的属性名称

student = Student()
student.name = "Jerry"
student.age = 10
student.abc = 9
