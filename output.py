#coding=utf-8
import math;
s = "Hello,world.";
print(str(s));
print("#"*20);
print(repr(s));
print(str(1/7));
x = 10 * 3.25;
y = 200 * 200;
s = "The value of x is " + repr(x) + ", and y is " + repr(y) + "...";
print(s);
hello = "hello,world\n";
hellos = repr(hello);
print(hello);
print(repr(2));
print("Jerry,","I love you .");
print("The number is :%s %d %f" % (4,5,8));

#平方 立方
for x in range(1,11) :
    print(repr(x).rjust(2),repr(x).rjust(3));


for x in range(1,11) :
    print("{0:2d} {1:3d} {2:4d}".format(x,x*x,x*x*x));


#str.zfill()用于向数值的字符串表达式左侧填充0
print("12".zfill(3));

#str.format();
print('We are the {0} who say {1}!'.format('knights', 'Ni'));
print('This {food} is {adjective}.'.format(food='spam', adjective='absolutely horrible'));

print('The value of PI is approximately {}.'.format(math.pi));

print ('The value of PI is approximately {!r}.'.format(math.pi));

print('The value of PI is approximately {0:.3f}.'.format(math.pi));
#旧式的字符串格式化
print ('The value of PI is approximately %5.3f.' % math.pi);
