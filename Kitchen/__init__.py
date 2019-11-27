#coding=utf-8
#相当于一个管理各个类 函数 对象的 统一包路径管理文件
#Kitchen是包,function,Fridge,Omelet是模块
'''
python 提供一个特殊字符*,它用于from...import...语句.记住,在导入到全局作用域时,只能
使用*导入,理解这一点很重要:
模块创建的作用域有一个有趣的用法.程序中有一个特殊的名称__name__
测试的时候 经常看到模块的尾部有如下代码:
if __name__ == "__main__";
通过sys.modules.keys 返回的列表,可以看到已经加载过的每个模块的名称.
'''
from Kitchen import Fridge;
from Kitchen import Omelet;
from Kitchen import function;
__all__ = ['Fridge','Omelet','function'];
