#encoding=utf-8
import sys

try:
    f = open('b.txt')
    s = f.readline()
    i = int(s.strip())
except IOError as e:
    print("I/O error({0}): {1}".format(e.errno, e.strerror));
except ValueError:
    print("Could not convert data to an integer.");
except:
    print("Unexpected error:", sys.exc_info()[0]);
    raise; # 抛出异常
else:
    print("没有找到合适的解决方法");
    f.close();


class B:
    pass;
class C(B):
    pass;
class D(C):
    pass;
'''
for c in [B, C, D]:
    try:
        raise c();
    except D:
        print("D");
    except C:
        print("C");
    except B:
        print("B");
'''

#
'''
name Error 变量没定义
Systax Error 语法错误
IO Error 文件错误
Zero DivisionError 10/0,除零错误
Value Error 值错误，例如a = int（‘aa’）
keyboard Interrupt 强制终止程序产生，ctrl+c强制终止程序运行
'''
try:
    a
except NameError as e:
    print('Error:',e);
print('over');


try:
    f = open('test.txt','rb');
    line = f.read(2);
    num = int(line);
    print('read num=%d' % num);
except IOError as e:
    print('catch IOError:', e);
except ValueError as e:
    print('catch ValueError:', e);
finally:
    print('close file');
    f.close();

