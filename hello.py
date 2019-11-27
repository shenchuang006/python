#ecoding=utf-8
#list
L = [x * x for x in range(10)];
print(L);

#要创建一个generator;
#如果要一个一个打印出来，可以通过next()函数获得generator的下一个返回值
G = (x * x for x in range(10));
print(next(G));

print(next(G));

print(next(G));


def odd():
    print('step 1');
    yield(1)
    print('step 2');
    yield(3)
    print('step 3');
    yield(5)

o = odd();

next(o);

next(o);

next(o);

#
print(repr(3),str(4));
#迭代器
from collections import Iterable;
print(isinstance([],Iterable));

print(isinstance({},Iterable));

it = iter({"abc":"jerry","name":"Tom"});
x = next(it);
print(x);
x = next(it);
print(x);
#x = next(it);
#print(x);
#x = next(it);
#print(x);
for x in iter([1,2,3,4]):
    print(x);

for x in str("abc"):
    print(x);

def calc_sum(*args):
    ax = 0
    for n in args:
        ax = ax + n
    return ax;
#*args表示多个参数
calc = calc_sum(1,3,5)
print(calc);

#闭包
def count():
    fs = []
    for i in range(1, 4):
        def f():
            return i*i
    fs.append(f);
    return fs;

f1 = count();
print(len(f1));
f = f1[0]();
print(str(f));
#匿名函数
f = lambda x:x*x;
print(f(5));

def build(x,y):
    return lambda : x*x + y*y;
f = build;
b = f(5,6);
print(b());

#偏函数
import functools;
def int2(x, base=2):
    return int(x, base);
int2 = functools.partial(int,base=2);
print(int2('10'));

import sys;
def test():
    args = sys.argv;
    if len(args) == 1:
        print('Hello,world!');
    elif len(args) == 2:
        print('Hello,%s!' % args[1]);
    else:
        print('Too many arguments!');

if __name__ == '__main__':
    test();
