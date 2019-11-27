# coding=utf8
# python 流程控制
# if 语句
#x = int(raw_input("Please enter an integer: "));
x = -2;
x = 4;
if x < 0:
    x = 0
    print("Negative changed to zero");
elif x == 0:
    print("Zero");
elif x == 1:
    print("Single");
else:
    print("More");
# for 语句.
words = ['cat','window','defenestrate'];
#主要包括两种形式进行转换：
#第一种是str()，将值转换为用户便于阅读的形式；
#另一种是repr()，将值转换为合法的python表达式
num = 82;
print(str(num));
for w in words :
    print(w +" " + repr(len(w)));

#迭代过程中可以插入数据的数据
# Loop over a slice copy of the entire list.
for w in words[:] : # 遍历的时候 还是有必要添加这个操作
    if len(w) > 6 :
        words.insert(0,"xmyz");
print(words);
# range() 函数 生成一个数值序列
m = range(10);
print(range(10))
print(m);
print(len(m));

#迭代数组并且根据数组索引获取值
a = ['Mary','had','a','little','lamb'];
for i in range(len(a)) :
    print(str(i) + " : " + a[i]);
# enumerate() 函数可以方便的定位索引已经值 相当于java中的map
for i,v in enumerate(a) :
    print(str(i) + ":" + v);

# 流程控制语句中的 break和 contine语句 以及 循环中的else 字句
# break 语句用于跳出最近的一级for or while 循环
print("\n");
for n in range(2,10) :
    for x in range(2,n) :
        if n % x == 0:
            print(str(n) +",equals x");
            break;
    else :
        print(str(n) + ",is a prime number");
print("\n");
for i in range(2,10) :
    print(str(i));
print("\n")
for i in range(2,3) :
    print(str(i));
print("\n");
# continue 中的迭代
for num in range(2,10) :
    if num % 2 == 0 :
        print("Found an even number," + str(num));
        continue;
    print("Found an add number," + str(num));


# pass 语句
# pass 语句什么也不做.它用于那些语法上必须要有什么语句,但程序什么也不做的场合,例如:
for element in "python" :
    if element == "y" :
        pass; # 用于流程语句,def 函数中,定影的类中
        print("this is pass 块");
    else :
        print("其他字符," + element);

print ("#" * 10);

for element in "python" :
    if element == "t" :
        print("即将退出程序");
        #exit(); 退出程序 下面的代码不执行
    else :
        print("其他没有匹配的字符," + element);

print("#" * 10);
for element in "python" :
    print("所有字符," + element);

print("#" * 10); #输出10相同的字符
# 定义函数
# 关键字def 引入了一个函数定义.在其后必须跟有函数名和包括形式参数的圆括号。
#函数体语句从下一行开始,必须是缩进的。
def fib(n):
    a,b = 0,1;
    while a < n :
        print(str(a) + ",-- " + str(b));
        a,b = b,a+b;
        pass;

# Now call the function we just defined:
fib(2000);
print("#" * 10);
#函数 调用 会为函数局部变量生成一个新的符号表。
# 确切地说，所有函数中的变量赋值都是将值存储在局部符号表。
# 变量引用首先在局部符号表中查找，然后是包含函数的局部符号表，
# 然后是全局符号表，最后是内置名字表。
# 因此，全局变量不能在函数中直接赋值 (除非用 global 语句命名)，尽管他们可以被引用
#多行注释 """ """ or ''' '''
"""
函数 调用 会为函数局部变量生成一个新的符号表。确切地说，
所有函数中的变量赋值都是将值存储在局部符号表。变量引用首先在局部符号表中查找，
然后是包含函数的局部符号表，然后是全局符号表，最后是内置名字表。因此，
全局变量不能在函数中直接赋值 (除非用 global 语句命名)，尽管他们可以被引用
"""
'''
函数引用的实际参数在函数调用时引入局部符号表，因此，
实参总是 传值调用 (这里的 值 总是一个对象引用，而不是该对象的值)。
[1] 一个函数被另一个函数调用时，一个新的局部符号表在调用过程中被创建。
一个函数定义会在当前符号表内引入函数名。
函数名指代的值(即函数体)存在一个被 Python 解释器认定为 用户自定义函数 的类型。
这个值可以赋予其他的名字(即变量名)，然后它也可以被当做函数使用。这可以作为通用的重命名机制:
'''
f =fib;
f(100);
# 没有return 返回值的函数 返回一个None
print(fib(10));
print("#" * 10);
def fib2(n) :
    a,b = 0,1;
    result = [];
    while a < n:
        result.append(a);#链表中在最后新增加一个值
        a,b = b,a+b;
    #位置放的不对 返回结果不对
    return result;

print(fib2(100));
# lambda函数
'''
出于实际需要，有几种通常在函数式编程语言例如 Lisp 中出现的功能加入到了 Python 中。
通过 lambda 关键字，可以创建短小的匿名函数。
这里有一个函数返回它的两个参数的和：lambda a, b: a+b。Lambda 形式可以用于任何需要的函数对象。
出于语法限制，它们只能有一个单独的表达式。语义上讲，它们只是普通函数定义中的一个语法技巧。
类似于嵌套函数定义，lambda 形式可以从外部作用域引用变量:
'''
def make_incrementor(n) :
    return lambda x : x + n;
f = make_incrementor(42);
print(f(0));

print("#" * 10);
# lambda 是匿名函数
pairs = [(1,'one'),(2,'two'),(3,'three'),(4,'four')];
pairs.sort(key=lambda pair : pair[1]);
print(pairs);

print("#" * 10);
'''
匿名函数lambda：是指一类无需定义标识符（函数名）的函数或子程序。
lambda 函数可以接收任意多个参数 (包括可选参数) 并且返回单个表达式的值
'''

'''
lambda匿名函数的格式：冒号前是参数，可以有多个，用逗号隔开，冒号右边的为表达式。
其实lambda返回值是一个函数的地址，也就是函数对象。
'''
a=lambda x:x*x
print(a);
print(a(3));

def sum(x,y):
    return x+y;
print(sum(1,2));

p = lambda x,y:x+y;
print(p(4,6));

a=lambda x:x*x
print(a(3));

a = lambda x,y,z:(x+8)*y-z;
print(a(5,6,8));




