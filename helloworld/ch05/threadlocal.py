#ecoding=utf-8
from threading import current_thread,Thread,local;
"""
1.使用字典来存放每个对象的数据key为当前线程的名称
"""
g_dit = {};

def test():
    cur_thread = current_thread();
    g_dit[cur_thread.name] = cur_thread.name;
    print('g_dit = %s' % g_dit);

p1 = Thread(target=test);

p2 = Thread(target=test);

p1.start();
p2.start();

local_school = local();
print(local_school.__dict__);
def process_student():
    std = local_school.student;
    print("Hello,%s (in %s)" % (std,current_thread().name));

def process_thread(name):
    local_school.student = name;
    process_student();

#name是线程名字，args是target的参数
t1 = Thread(target=process_thread,name = "Thread-A",args=("老王",));

t2 = Thread(target=process_thread,name = "Thread-B",args=("老张",));

t1.start();
print(local_school.__dict__);
t2.start();
print(local_school.__dict__);

t1.join();
t2.join();

#去重
arr = [1,2,3,1,2,3,4,3];
print(set(arr));



#异步
from multiprocessing import Process, Pool
from multiprocessing import Manager
import time


def Foo(i):
    time.sleep(1)
    return i + 50


def Bar(arg):
    print(arg)


if __name__ == '__main__':
    pool = Pool(5)
    for i in range(10):
        '''apply是去简单的去执行，而apply_async是执行完毕之后可以执行一
        个回调函数，起提示作用'''
        pool.apply_async(func=Foo, args=(i,), callback=Bar)  # 是异步的
        print('你好')
    pool.close()  # 不执行close会报错，因为join的源码里面有个断言会检验是否执行了该方法
    pool.join()  # 等待所有子进程运行完毕，否则的话由于apply_async里面daemon是设置为True的，主进程不会等子进程，所欲函数可能会来不及执行完毕就结束了
'''apply_async里面，等函数Foo执行完毕，它的返回结果会被当做参数
    传给Bar''';

#同步

from multiprocessing import Process, Pool
from multiprocessing import Manager
import time


def f1(a):
    time.sleep(2)
    print(a)


if __name__ == '__main__':
    pool = Pool(5)
    for i in range(5):  # 每次使用的时候会去进程池里面申请一个进程
        pool.apply(func=f1, args=(i,))
        print('你好')  # apply里面是每个进程执行完毕了才执行下一个进程
    pool.close()  # 执行完close后不会有新的进程加入到pool,join函数等待所有子进程结束
    pool.join()  # 等待进程运行完毕，先调用close函数，否则会出错

