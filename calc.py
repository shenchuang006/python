# coding=utf-8
import sys;
def add(a, b):
    return a + b;
# 这时，要解析传递的参数，需要用到 sys 模块：
if __name__ == '__main__': #意思是说：模块既可以被导入（到 Python shell 或者其他模块中），也可以作为脚本来执行
    args = sys.argv  # 用于获取命令行参数
    print(args)
    print(add(int(args[1]), int(args[2])));

'''
没错，通过 sys.argv 可以获取命令行参数，它是一个 list 类型。
sys.argv[0] 表示代码本身文件路径，参数索引从 1 开始。
使用很简单，参数之间以空格隔开：

$ python calc.py 2 3
['calc.py', '2', '3']
5
$ python calc.py 4 5
['calc.py', '4', '5']
9
'''
print("__name__",__name__);