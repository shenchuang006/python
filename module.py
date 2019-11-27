#coding=utf-8
import importlib;

import calc;
from Kitchen import function

'''
现在进入 Python 解释器并使用以下命令导入这个模块:
import function;
调用函数 function.fib(10);
'''

'''
模块是包括 Python 定义和声明的文件。文件名就是模块名加上 .py 后缀。
模块的模块名(做为一个字符串)可以由全局变量 __name__ 得到。
例如，你可以用自己惯用的文件编辑器在当前目录下创建一个叫 fibo.py 的文件，录入如下内容:
'''
function.fib(10);
print(function.__name__);
'''
如果打算频繁使用一个函数，你可以将它赋予一个本地变量:
'''
fib2 = function.fib2;
print(fib2(10));

'''
每个模块都有自己私有的符号表，被模块内所有的函数定义作为全局符号表使用。
因此，模块的作者可以在模块内部使用全局变量，而无需担心它与某个用户的全局变量意外冲突。从另一个方面讲，
如果你确切的知道自己在做什么，你可以使用引用模块函数的表示法访问模块的全局变量，modname.itemname

模块可以导入其他的模块。一个(好的)习惯是将所有的 import 语句放在模块的开始(或者是脚本)，这并非强制。
被导入的模块名会放入当前模块的全局符号表中
'''
'''
对于 Python 2.X：
import sys
reload(sys)
sys.setdefaultencoding("utf-8")
1
2
3
对于 <= Python 3.3：
import imp
imp.reload(sys)
1
2
注意： 
1. Python 3 与 Python 2 有很大的区别，其中Python 3 系统默认使用的就是utf-8编码。 
2. 所以，对于使用的是Python 3 的情况，就不需要sys.setdefaultencoding("utf-8")这段代码。 
3. 最重要的是，Python 3 的 sys 库里面已经没有 setdefaultencoding() 函数了。

对于 >= Python 3.4：
import importlib
importlib.reload(sys)
'''
importlib.reload(function);
# calc.py模块
print("计算结果:" + str(calc.add(1,3)));
print(dir(function));
#无参数调用时,dir()函数返回当前定义的命名列表:
print(dir());
# 必须包含__init__.py


