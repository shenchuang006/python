class Annimal:
    """
    父类初始化方法
    """
    def __init__(self):
        print('Annimal的构造方法')

        self.ty = '动物'

class Cat(Annimal):
    """
    子类初始化方法
    """
    def __init__(self):
        print('Cat的构造方法')
        self.n = '猫'
        super(Cat, self).__init__()  #推荐用这种
        # Annimal.__init__(self)        #第二种方式
c = Cat();