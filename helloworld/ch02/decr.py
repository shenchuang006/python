#装饰器

def funA(arg):
    print('A');
    def inner():
        arg()
    return inner;
@funA
def funB():
    print('B');
#t = funB();
funB();

#一般的作法
def use_logging(func):
  print("%s is running" % func.__name__)
  func()
def bar():
  print('i am bar')
use_logging(bar)
#result:
#bar is running
#i am bar
#-----------------------无参数的装饰器--------------------------------------#
print('-----------------');
#使用装饰器
def use_logging(func):
  print("%s is running" % func.__name__);
  return func;
@use_logging
def bar():
  print('i am bar');
bar();

"""
python提供了@符号作为装饰器的语法糖，使我们更方便的应用装饰函数。
但使用语法糖要求装饰函数必须return一个函数对象。因此我们将上面的func函数使用内嵌函数包裹并return。

装饰器相当于执行了装饰函数use_loggin后又返回被装饰函数bar,
因此bar()被调用的时候相当于执行了两个函数。等价于use_logging(bar)()
"""
print('----------------------------------');
def use_logging(func):
  def _deco():
    print("%s is running" % func.__name__);
    func();
  return _deco
@use_logging
def bar():
  print('i am bar');
bar();

#不带参数装饰器版本，这个格式适用于不带参数的装饰器。
print('---------------------------------');
def use_logging(func):
  def _deco(*args,**kwargs):
    print("%s is running" % func.__name__)
    func(*args,**kwargs)
  return _deco
@use_logging
def bar(a,b):
  print('i am bar:%s'%(a+b))
@use_logging
def foo(a,b,c):
  print('i am bar:%s'%(a+b+c))
bar(1,2)
foo(1,2,c=3);
print('--------没有使用functools 反射调用后 函数名称会发生变化-------------------------')
def use_logging(func):
  def _deco(*args,**kwargs):
    print("%s is running" % func.__name__)
    func(*args,**kwargs)
  return _deco
@use_logging
def bar():
  print('i am bar')
  print(bar.__name__)
bar()
#bar is running
#i am bar
#_deco
#函数名变为_deco而不是bar，这个情况在使用反射的特性的时候就会造成问题。因此引入了functools.wraps


print('------------使用functools--------------');
import functools
def use_logging(func):
  @functools.wraps(func)
  def _deco(*args,**kwargs):
    print("%s is running" % func.__name__)
    func(*args,**kwargs)
  return _deco
@use_logging
def bar():
  print('i am bar')
  print(bar.__name__)
bar();
#6、实现带参数和不带参数的装饰器自适应
print('-------------使用functools实现自适应 ----------------');
import functools
def use_logging(arg):
  if callable(arg):#判断参入的参数是否是函数，不带参数的装饰器调用这个分支
    @functools.wraps(arg)
    def _deco(*args,**kwargs):
      print("%s is running" % arg.__name__)
      arg(*args,**kwargs)
    return _deco
  else:#带参数的装饰器调用这个分支
    def _deco(func):
      @functools.wraps(func)
      def __deco(*args, **kwargs):
        if arg == "warn":
          print("warn%s is running" % func.__name__);
        return func(*args, **kwargs)
      return __deco
    return _deco
@use_logging("warn")
#@use_logging
def bar():
  print('i am bar')
  print(bar.__name__)
bar();
print(callable(use_logging));
print('-------------类装饰器----------------------');
#类装饰器
import functools;
class loging(object):
  def __init__(self,level="warn"):
    self.level = level
  def __call__(self,func):
    @functools.wraps(func)
    def _deco(*args, **kwargs):
      if self.level == "warn":
        self.notify(func)
      return func(*args, **kwargs)
    return _deco
  def notify(self,func):
    # logit只打日志，不做别的
    print("%s is running" % func.__name__);
@loging(level="warn")#执行__call__方法
def bar(a,b):
  print('i am bar:%s'%(a+b))
bar(1,3)