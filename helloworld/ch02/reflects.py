#ecoding=utf-8
#import的两种方式
#import sys;
__import__('sys');
#from list.text import commons;
#多层导入
#__import__(' list.text.commons',fromlist=True);#如果不加上fromlist=True,只会导入list目录
a = (1,2,3);
print(list(a));
#返回一个数据
t = __import__('sys');
print(t.path);
#反射的四个方法
"""
反射的四个方法:hasattr,getattr,setattr,delattr
"""
class Foo(object):

    def __init__(self):
        self.name = 'abc'

    def func(self):
        return 'ok'


obj = Foo();
# 获取成员
print('------get---------');
ret = getattr(obj, 'func')  # 获取的是个对象
r = ret()
print(r)
print('------has---------');
# 检查成员
ret = hasattr(obj, 'func')  # 因为有func方法所以返回True
print(ret)
print('------set---------');
# 设置成员
print(obj.name)  # 设置之前为:abc
ret = setattr(obj, 'name', 19)
print(ret);#没有数据返回
print(obj.name)  # 设置之后为:19
print('-------del--------');
# 删除成员
print(obj.name)  # abc
delattr(obj, 'name')
#print(obj.name)  # 报错