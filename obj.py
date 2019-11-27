#coding=utf-8
#类对象
class Myclass:
    """
    A simple example class
    __init__(self):类可以定义实例化方法
    """
    i = 12345;
    def f(self):
        return "hello world";

x = Myclass();
print(type(x));
print(x.f());
print(str(x.i),x.__doc__);


print("----"*10);
class Complex:
    def __init__(self,realpart,imagpart):
        self.r = realpart;
        self.i = imagpart;
x = Complex(3.0,4.0);
print(str(x.i),str(x.r));
# 实例对象
print(Myclass.i);
print(Myclass.f(x));#必须传入实例对象 调用 x.f() 相当于 MyClass.f(x)
print("---" *10);
#类和实例变量
class Dog:
    #类变量
    kind = 'canine'; # class variable shared by all instances.
    def __init__(self,name):
        self.name = name;#instance variable unique to each instance

d = Dog('Fido');
e = Dog('Buddy');
print(d.kind,d.name);
print(e.kind,e.name);

class Dog:
    tricks = [];#mistaken use of a class variable
    def __init__(self,name):
        self.name = name;

    def add_trick(self,trick):
        self.tricks.append(trick);

d = Dog('Fido');
e = Dog('Buddy');
print(d.tricks);
d.add_trick('roll over');
e.add_trick('play dead');
print(d.tricks);

#在__init(self):方法中创建变量

class Cat:
    def __init__(self,name):
        self.name = name;
        self.tricks = []; #create a new empty list for each instance;

    def add_trick(self,trick):
        self.tricks.append(trick);
print("----" * 10);
d = Cat('Fido');
e = Cat('Buddy');
d.add_trick('roll over');
e.add_trick('play dead');
print("dd:" , d.tricks);
print("ee:" , e.tricks);

s = 'abc';
it = iter(s);
print(it);
i = next(it);
print(i);
i = next(it);
print(i);

#名称重整是有助于子类重写方法，而不会打破组内的方法调用。例如:
#私有变量和类本地引用
'''
class Mapping:
    def __init__(self, iterable):
        self.items_list = []
        self.__update(iterable)

    def update(self, iterable):
        for item in iterable:
            self.items_list.append(item)

    __update = update   # private copy of original update() method

class MappingSubclass(Mapping):

    def update(self, keys, values):
        # provides new signature for update()
        # but does not break __init__()
        for item in zip(keys, values):
            self.items_list.append(item) ;
'''

class A:
    def __init__(self):
        self.__data=[]  #翻译成 self._A__data=[]
    def add(self,item):
        self.__data.append(item) #翻译成 self._A__data.append(item)
    def printData(self):
        print(self.__data);  #翻译成 self._A__data

a=A();
a.add('hello');
a.add('python');
a.printData();
#print(a.__data)  #外界不能访问私有变量 AttributeError: 'A' object has no attribute '__data'
print(a._A__data) #通过这种方式，在外面也能够访问“私有”变量；这一点在调试中是比较有用的！




class A():
    def __init__(self):
        self.__name='python' #私有变量，翻译成 self._A__name='python'
    def __say(self): #私有方法,翻译成 def _A__say(self)
        print(self.__name) #翻译成 self._A__name

a=A()
#print a.__name #访问私有属性,报错!AttributeError: A instance has no attribute '__name'
print(a.__dict__); #查询出实例a的属性的集合
print(a._A__name) #这样，就可以访问私有变量了
#a.__say()#调用私有方法，报错。AttributeError: A instance has no attribute '__say'
print(dir(a));#获取实例的所有属性和方法

#派生类和基类取相同的名字就可以使用基类的私有变量
class A():
    def __init__(self):
        self.__name='python'; #翻译成self._A__name='python'
print("-----"*10);
class B(A):
    def func(self):
        print(self.__name); #翻译成print self._B__name

instance=B();
#instance.func()#报错：AttributeError: B instance has no attribute '_B__name'
print(instance.__dict__);
print(instance._A__name);

#派生类和父类同名
class A():
    def __init__(self):
        self.__name='python' #翻译成self._A__name='python'

print("-----" * 10);
class A(A): #派生类和基类取相同的名字就可以使用基类的私有变量。
    def func(self):
        print(self.__name); #翻译成print self._A__name

instance=A();
instance.func();

#父类是object
class Student(object):
    def __init__(self,name='Jerry',score=60):
        self.name = name;
        self.score = score;

    def print_score(self):
        print('%s,%d'% (self.name,self.score));

    def get_grade(self):
        if self.score >= 90:
            return 'A';
        elif self.score >= 60:
            return 'B';
        else:
            return 'C';
    pass

bar = Student();
print(bar);
bar.name = 'Bar Simpson';
print(bar.name);
print(bar.score);
print(bar.print_score());

print(bar.get_grade());
bar.score = 70;
print(bar.get_grade());
class Person(object):
    def __init__(self,name={'Jerry'},sex={'Male'},age={30}):
        self.name = name;
        self.sex = sex;
        self.age = age;
    pass;
p = Person();
print(p,p.name,p.sex,str(p.age));
