#coding=utf-8
import os;
import shutil;
import glob;
import sys;
import re;
import math;
import random;
from datetime import date;
import threading, zipfile;
import logging;
#操作系统接口
#print(dir(os));
print("-----" * 10);
#print(help(os));
#日常的文件和目录管理任务
#shutil.copyfile("","");赋值数据
#shutil.move('','');#移动
#文件通配符
#print("-----" * 10);
#print(glob.glob("*.py"));
#命令行参数
print(sys.argv);
#字符串正则匹配
print("-----" * 10);
r = re.findall(r'\bf[a-z]*', 'which foot or hand fell fastest');
print(r);
s = re.sub(r'(\b[a-z]+) \1', r'\1', 'cat in the the hat');
print(s);
w = "tea for too".replace('too','two');
print(w);
#数字
print(math.cos(math.pi/4.0));
print(math.log(1024,2));
#random
print(random.choice(['apple','pear','banana']));
print(random.sample(range(100),10));
print(random.random());
print(random.randrange(6));
#互联网访问

#日期和时间
now = date.today();
print(now);
print(now.strftime("%m-%d-%y. %d %b %Y is a %A on the %d day of %B."));

birthday =date(1964,7,31);
age = now -birthday;
print(age.days);

#多线程

class AsyncZip(threading.Thread):
    def __init__(self, infile, outfile):
        threading.Thread.__init__(self)
        self.infile = infile
        self.outfile = outfile
    def run(self):
        f = zipfile.ZipFile(self.outfile, 'w', zipfile.ZIP_DEFLATED)
        f.write(self.infile)
        f.close()
        print('Finished background zip of:', self.infile);

#background = AsyncZip('mydata.txt', 'myarchive.zip');
#background.start();
#print('The main program continues to run in foreground.');
#background.join();    # Wait for the background task to finish
#print('Main program waited until background was done.');
#日志

logging.debug('Debugging information');
logging.info('Informational message');
logging.warning('Warning:config file %s not found', 'server.conf');
logging.error('Error occurred');
logging.critical('Critical error -- shutting down');


