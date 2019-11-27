def test(func):
    # 判断func如果是函数，就执行他，如果不是函数，直接返回
    # 判断func是否可调用，如果可以调用，就是true
    if callable(func):
        print('-----------');
        ret = func
    else:
        print('$$$$$$$$$$$$$$$$');
        ret = func
    return ret


print(test(123))


def test2():
    return '111'

print(test(test2()));
print('#####################');
print(test(test2));


print("--------------\n")
#! /usr/bin/env python
# -*- coding:utf-8 -*-
# __author__ = "TKQ"
def use_logging(level):
  def _deco(func):
    def __deco(*args, **kwargs):
      if level == "warn":
        print("%s is running" % func.__name__);
      return func(*args, **kwargs)
    return __deco
  return _deco
@use_logging(level="warn")
def bar(a,b):
  print('i am bar:%s'%(a+b))
bar(1,3)
# 等价于use_logging(level="warn")(bar)(1,3)