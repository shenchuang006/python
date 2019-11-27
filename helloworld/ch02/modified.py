"""

公有成员：任何地方都能访问
 私有成员：只有在类的内部才能访问，定义方式为命名时，前两个字符为下划线，如 "__test"
"""
"""
类的一些特殊特性
__doc__       表示类的描述信息
__module__     表示当前操作的对象在那个模块
__class__      表示当前操作的对象的类是什么
__init__       构造方法，通过类创建对象时，自动触发执行
__call__       对象后面加括号，触发执行。
__dict__       类或对象中的所有成员
__str__       如果一个类中定义了__str__方法，那么在打印 对象 时，默认输出该方法的返回值。
__init__    构造方法，通过类创建对象时，自动触发执行
 
__setitem__，__getitem__，__delitem__ 用于索引操作，如字典。分别表示获取、设置、删除数据
"""
class Person:
    country = 'China'  # 静态字段，属于公有成员
    __planet = 'Earth'  # 静态字段，属于私有成员

    def __init__(self, name):
        print('Person build self.name')
        self.name = name

    def say(self):
        print('The planet is %s' % Person.__planet)  # 在类的内部访问私有静态字段


p1 = Person('Nothing')
p1.say()
print(p1.country)  # 访问公有静态字段
print(p1.__planet)  # 访问私有静态字段,私有属性 方法 不能对外访问

# 执行结果：
# Person
# build
# self.name
# The
# planet is Earth  # 在类的内部可以访问
# print(p1.__planet)
# China  # 外部可以访问公有静态字段
# AttributeError: 'Person'
# object
# has
# no
# attribute
# '__planet'  # 外部无法访问私有静态字段