#coding=utf-8

from functools import reduce;
a = [66.25,333,333,1,1234.5];
print(a.count(333));#返回333在list中出现的次数
a.insert(0,-1);#在指定位置插入元素相当于a.append(x); 追加元素
print(a);
a.append(333);
print(a);
n = a.index(333);
print(n);
a.remove(333);
print(a);
a.reverse();
print(a);
a.sort();
print(a);
a.pop();
print(a);
#把链表当做堆栈使用使用append()在链表后面追加元素,使用pop()从链表后面删除数据
#先进后出
stack = [3,4,5];
stack.append(6);
stack.append(7);
print(stack);
stack.pop();
print(stack);

#把链表当做队列使用
#先进先出
'''
要实现队列，使用 collections.deque，它为在首尾两端快速插入和删除而设计
'''
from collections import deque
deque = deque(["Eric", "John", "Michael"]);
deque.append("Terry");
deque.append("Graham");
print(deque);
deque.popleft();
deque.popleft();
print(deque);

'''
filter(function, sequence) 返回一个 sequence(序列)，
包括了给定序列中所有调用 function(item) 后返回值为 true 的元素(如果可能的话，
会返回相同的类型)。如果该 序列 (sequence)是一个 str, unicode 或者 tuple，返回值必定是同一类型，否则，
它总是 list。例如，以下程序可以计算一个被 3 或者 5 整除的序列:
'''
#函数式编程 filter();map();reduce();
def f(x): return x % 3 == 0 or x % 5 == 0;
print(filter(f,range(2,25)));

print("#" * 10);
'''
map(function, sequence) 为每一个元素依次调用 function(item) 并将返回值组成一个链表返回。
例如，以下程序计算立方:
'''
def cube(x): return x*x*x;
map(cube,range(1,11));

print("#" * 10);
seq = range(8);
def add(x, y): return x+y;
map(add, seq, seq);

print("#" * 10);
'''
reduce(function, sequence) 返回一个单值，它是这样构造的：首先以序列的前两个元素调用函数 
function，再以返回值和第三个参数调用，依次执行下去。
例如，以下程序计算 1 到 10 的整数之和:
'''
def add(x,y): return x+y;
a = reduce(add, range(1, 11),0);
print(a);

def sum(seq):
        def add(x,y): return x+y;
        return reduce(add, seq, 0);
mount = sum(range(1,11));
print(mount);
# del 语句
a = [-1,1,66.25,333,333,1234.5];
print(a);
del a[0];
print(a);
del a ;#删除整个链表
#print(a); 删除操作后 显示变量没有定义
#元数据
t = 12345,54321,'hello!';
print(t[0]);
u = t,(1,2,3,4,5);
print(u);
#集合 set
baset = ['apple','orange','apple','pear','orange','banana'];
print(baset); #['apple', 'orange', 'apple', 'pear', 'orange', 'banana']
fruit = set(baset);
print(fruit); #{'pear', 'apple', 'orange', 'banana'}

print('apple' in fruit);

a = set('abracadabra');
b = set('alacazam');
print(a);
print(b);
# a - b
print(a - b); #去除重复的a剩余元素
# | b
print(a | b) #合并并去重复
# a & b;
print(a & b); # ab 重复元素
# a ^ b
print(a ^ b); # 排除相同元素后 合并元素


# 字典对象
tel = {'jack':4098,'sape':4139};
print(tel);
tel['guido'] = 4127
print(tel);
print(tel['jack']);
del tel['sape'];
print(tel);
tel['irv'] = 4127;
print(tel);
print(tel.keys());
print(tel.values());
print('guido' in tel);
#字典的构造函数 dict();
scop = dict([('sape', 4139), ('guido', 4127), ('jack', 4098)]);
print(scop);
scope = dict(sape=4139, guido=4127, jack=4098);
print(scope);


# 循环技巧
for i,v in enumerate(scope) :
        print(str(i) +" : " + v);

# 同时循环两个或者更多的序列,可以使用zip();整体打包
questions = ['name', 'quest', 'favorite color'];
answers = ['lancelot', 'the holy grail', 'blue'];
for q,a in zip(questions,answers) :
    print('What is your {0}?  It is {1}.'.format(q, a)); #字符串的formate方法
'''
需要逆向循环序列的话，先正向定位序列，然后调用 reversed() 函数:
'''
#for i in reversed(xrange(1,10,2)):
   # print(i);

for f in sorted(baset):
   print(f);
# iteritems 返回的是迭代器
'''
python字典中还存在items()方法。两者有些许区别。

items方法是可以将字典中的所有项，以列表方式返回。
iteritems方法与items方法相比作用大致相同，只是它的返回值不是列表，而是一个迭代器
'''
knights = {'gallahad': 'the pure', 'robin': 'the brave'};
#for k,v in knights.iteritems() :
 #   print(k +" : " + v);

#items()返回的是列表
print(knights.items());
for i in knights.items() :
    print(i);

x = [4,6,2,1,7,9];
y = x[:];
y.sort();
print(y);
print(x);
'''
sorted方法 
sorted返回一个有序的副本，并且类型总是列表，如下：
'''
x = [4,6,2,1,7,9];
y = sorted(x);
print(y);
print(x);

print(sorted("python"));

def comp(x, y):
    if x < y:
        return 1;
    elif x > y:
        return -1;
    else:
        return 0;












