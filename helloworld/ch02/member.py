class Provice:
    """
    分别有静态字段、静态方法、类方法、特性、普通字段、普通方法、
    """
    # 静态字段
    country = 'China'

    def __init__(self, name):
        # 普通字段
        self.name = name

    # 普通方法
    def show(self):
        print('show')

    @staticmethod  # 静态方法
    def xo(arg):
        print('xo')
        print(arg)

    @classmethod  # 类方法，必须要有个cls参数：自动传入类名
    def xxoo(cls):
        print('xxoo', cls)

    def start(self):  #对象普通方法
        print('start')

    @property  # 特性 get方法
    def end(self):
        print('end')

    @end.setter #set方法
    def end(self, values):
        print(values)
        self.name = values  # 也可以更改内存里的值


Provice.country  # 类访问静态字段
Provice.xo('alex')  # 类访问静态方法
Provice.xxoo()  # 访问类方法

# 获取特性值
obj = Provice('alex')
obj.end
# 设置特性值
obj1 = Provice('alex')
obj1.end = '123'
print(obj1.name)

# 普通方法
obj1 = Provice('alex')
obj1.show()

# 普通字段
obj1 = Provice('alex')
print(obj1.name)

#访问普通方法
#Provice.start(); #报错 需要当前对象调用,
#成员信息小结
"""
静态字段：存在类中 ,静态字段存在的意：把对象里面重复的数据只在类里保存一份
静态方法 ：没有self 可以传参数,调用的时候也需要传入参数 ,存在的意义:不需要创建对象，就可以访问此方法 ,为类而生
类方法:必须要有个cls参数：自动传入类名
特性  对象调用 、不能加参数，执行不用加括号

普通字段,存放在对象中
普通方法  存在的意义:普通方法如果要想被调用就需要创建self ,为对象而生

各成员存在的意义

"""