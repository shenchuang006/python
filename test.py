#this is the first comment
#from Kitchen import Fridge;
import glob;
import os;
import os.path;
import string;
import sys;
import time;
from imp import reload;
import Kitchen;
from eat import food;
import eat;
import dbm;


SPAM = 1
STRING = "# This is not a comment."
print(SPAM)
print(STRING)
# 数字 python作为计算器
print(2 + 2)
print(50 - 5 * 6)#long or int 类型
print((50 - 5.0*6)/4)#float类型
print(8/5.0) #float类型
print("------------------------>")
print(17/3) #int /int --> int
print(17/3.0) #int / float --> float
print(17//3.0) # explicit floor division discards the fractional part 去除小数点后面的数字补0
print(17%3) #the % operator returns the remainder of the division 取余数
print(5*3+2) # result * divisor + remainder
print("** 运算符计算幂乘方")
print(5**2)
print(2**7)
width = 20
height = 5*9
sum = width * height
print(width)
print(height)
print(sum)
print("浮点型数据:")
print(3*3.75/1.5)
print(7.0/2);
print("交互模式的赋值变量")

print("字符串,单引号引用的部分会原因输出 '\' 转移字符")
print("span eggs")
print("doesn\'t")
print('"Yes," he said.')
print('"Yes," he said.')
print('"Isn\'t," she said.')

print("针对有'\n'这种换行的操作的字符串,可以在引号前加上一个r,这样就不用换行")
print("'C:\some\name'")
print(r'C:\some\name')
print("字符串的拼接")
print('py' 'thon')
print("this is " + "python")
print(3 * 'un' +"ium");
print("字符串的截取 数组从0索引开始")
word = "python";
print(word[0] + word[4] +word[-0])
print("字符串索引也可以是负数,从右边开始计算 -0和0是一样的 不会从右边计算");
print(word[-1])
print(word[-6])
print("截取数组--包含起始字符串,不包含末位字符串")
print(word[:2])
print(word[:1] +word[1:]) #==和word这字符串是一样的
print("内置函数len() 返回字符串的长度");
print(len("i love you"))
print(u"沈闯".encode('utf-8'))
print("列表")
squares = [1,4,9,16,25];
print(squares)
print(squares[0])
print(squares[-1])
print(squares[-3:])
print(squares[:]) #获取所有
print(squares + [36,49,64,81,100]) # 列表拼接
print("列表允许修改,不像不可变的字符串");
cubes = [1,8,27,65,125];
cubes[3] = 64
print(cubes);
print("字符串的 数组的拼接 append()");
cubes.append(6**3)
print(cubes);
print("也可以通过切片赋值 清空数组");
letters = ['a','b','c','d','e','f','g'];
print(letters[2:5]);
letters[2:5] = ['C','D','E'];
print(letters);
letters[2:5] = [];
print(letters);
letters = []; #清空数组
print(letters);
a = ['a','b','c','d'];
print(len(a)); #内置函数 查询数组长度
n = [1,2,3];
x = [a,n];#数组中嵌套数组
print(x[0]);
# 编程的第一步
a,b = 0,1;
while b  < 10:
    print(b),
    a,b = b,a+b;

#r = Fridge({});
#s = r.items;
#print(s);
print("-----" * 10);
w = Kitchen.function.fib2;
print(w(10));
'''
通过sys.modules.keys 返回的列表,可以看到已经加载过的每个模块的名称.
'''
print("---------" * 10);
print(list(sys.modules.keys()))
print(sys.modules['Kitchen']);
print(reload(Kitchen));

#文件和目录
def make_text_file():
    a = open("a.txt","w");
    a.write('This is how you create a new text file\n');
    a.close();
make_text_file();
b = open("a.txt","r");
m = b.readlines();
print(m);

#判断文件是否存在
def make_another_file():
    if os.path.isfile("a.txt"):
        print("You are trying to create a file that already exists!");
    else:
        f = open("a.txt","w");
        f.write("This is how you create a new text file\n");
        f.close();
make_another_file();
print(m);
#向文件中追加文本 "r"：读,"w":写,"a":追加内容
def add_some_text():
    a = open("a.txt","a");
    a.write('Here is some additional text!');
    a.close();

add_some_text();
b = open("a.txt","r");
m = b.readlines();
b.close();
print(m);
print("--------" * 10);

#路径 将目录名称组合成路径
print(os.path.join("snakes","python"));
#相反的功能 将路径的最后一个组件提取出来,
print(os.path.split("C:\\Program Files\\Python30\\Lib"));
#系统自动分解
parent_path,name = os.path.split("C:\\Program Files\\Python30\\Lib");
print(parent_path);
print(name);
def split_full(path):
    parent_path,name = os.path.split(path);
    if name == "":
        return (parent_path,);
    else:
        return split_full(parent_path) + (name,);

print(split_full("C:\\Program Files\\Python30\\Lib"));

#splitext
parts = os.path.splitext("image.jpg");
print(parts[1]);
#normpath
print(os.path.normpath(r"C:\\Program Files\Perl\..\Python30"));
#绝对路径os.path.abspath
print(os.path.abspath("calc.py"));
#判断某个路径是否存在os.path.exists
print(os.path.exists("err.py"));
print(os.path.exists("errs.py"));
#列出python按照目录的所有东西
print(os.listdir("D:\\python"));
#判断某个目录拼接路径
print("------" * 10);
def print_dir(dir_path):
    for name in os.listdir(dir_path):
        print(os.path.join(dir_path,name));

print_dir("D:\\python")
#判断是目录还是文件
print(os.path.isfile("calc.py"));
print(os.path.isdir("D:\\python"));
#目录树
print("--------" * 10);
def print_tree(dir_path):
    for name in os.listdir(dir_path):
        full_path = os.path.join(dir_path,name);
        print(full_path);
        if os.path.isdir(full_path):
            print_tree(full_path);
print_tree("D:\\python");
print("---------" * 10);
#时间
mod_time = os.path.getmtime("D:\\python");
print(time.ctime(mod_time));

#重命名 移动 复制 删除文件
"""
重命名 移动 复制 删除文件
"""
#模块shutil中包含了操作文件的函数
#shutil.move();
#shutil.move("1.json","Kitchen");
#shutil.move("Kitchen\\1.json","..");
#shutil.copy("a.txt","Kitchen");
#os.remove("Kitchen\\a.txt");
#文件权限 os.chmod

#创建目录
#os.mkdir("test");
#os.rmdir("test");
#os.makedirs("");
#shutil.rmtree("");#删除目录树
"""
统配和大小写区分
"""

print(glob.glob("C:\\Program File\\M*"));

#python的其他特性 lambda filter
#filter
"""
filter()函数是 Python 内置的另一个有用的高阶函数，
filter()函数接收一个函数 f 和一个list，这个函数 f 的作用是对每个元素进行判断，
返回 True或 False，filter()根据判断结果自动过滤掉不符合条件的元素，
返回由符合条件元素组成的新list
"""
filter_me = [1,2,3,4,5,6,7,8,9,11,12,14,15,19,22];
func = lambda x : x % 2 == 0;
result = filter(func,filter_me);
print(*result);
print(*filter_me);
#print(*values, sep=' ', end='\n', file=sys.stdout, flush=False)
print(*filter_me, sep='\n', end='\n');

#字典
person = {"name":"James","camera":"nikon",
"handedness":"lefty","baseball_team":"angels","instrument":"guitar"};
print("%(name)s,%(camera)s,%(baseball_team)s" % person);
person['height'] = 1.6;
person['weight'] = 80;
t = string.Template("$name is $height m high and $weight kilos");
print(t.substitute(person));

#重要模块 getopt 从命令行中得到选项
print(dir(Kitchen.function));
#模块创建
from eat.food import favoriteFood;
b = favoriteFood;
print(b(),b);

b = food.favoriteFood();
#test 模块
meal = eat.Meal.Meal('omelet','coffee');
breakfast = eat.Meal.Breakfast();
print(meal.name);
print(breakfast.name,breakfast.food);
print("--------------" * 10);
print(dir(eat.food));

import eat;
from eat import Meal;
def test():
    '''
    Test function .
    :return:
    '''
    print("Testing Meal class.");
    m = eat.Meal.Meal();
    m.printIt("\t");
    m = eat.Meal.Meal('green eggs and ham','tea');
    m.printIt("\t");

    #Test Breakfast
    print("Testing Breakfast class.");
    b = eat.Meal.Breakfast();
    b.printIt("\t");
    b.setName("breaking of the fast");
    b.printIt("\t");
    #Test dinner
    print("Testing Dinner class.");
    d = eat.Meal.Dinner();
    d.printIt("\t");
    #Test lunch
    print("Testing Lunch class.");
    l = eat.Meal.Lunch();
    l.printIt("\t");
    print("Calling Lunch.setFood().");
    try:
        l.setFood('hotdog');
    except eat.error.AngryChefException:
        print("\t",'The chef is angry. Pick an omelet.');

if __name__ == '__main__':
    test();

db = dbm.open('websites', 'c');
#Add an item.
db['www.python.org'] = 'Python home page';
print(db['www.python.org']);
#Close and save to disk.
db.close();

t = (1,2,3);
s = set(t);
print(t,s);
m = list(t);
print(m);


