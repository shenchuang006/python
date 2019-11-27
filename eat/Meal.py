#coding=utf-8
from eat import error
class Meal:
    def __init__(self,food='omelet',drink='coffee'):
        self.name = 'generic meal';
        self.food = food;
        self.drink = drink;
    def printIt(self,prefix=''):
        print(prefix,'A fine',self.name,'with',self.food,'and',self.drink);
    def setFood(self,food='omelet'):
        self.food = food;
    def setDrink(self,drink='coffee'):
        self.drink = drink;
    def setName(self,name=''):
        self.name = name;
#扩展已有的类
class Breakfast(Meal):
    def __init__(self):
        Meal.__init__(self,'omelet','coffee');
        self.setName('breakfast');

class Lunch(Meal):
    def __init__(self):
        Meal.__init__(self,'sandwich','gin and tonic');
        self.setName('midday meal');

    def setFood(self,food='omelet'):
        if food != 'sandwich' and food != 'omelet':
            raise error.AngryChefException;
            Meal.setFood(self,food);
    def makeLunch(self):
        return Lunch();
class Dinner(Meal):
    def __init__(self):
        Meal.__init__(self,'steak','merlot');
        self.setName('dinner');
    def printIt(self,prefix=''):
        print(prefix,'A gourment',self.name,'with',self.food,'and',self.drink);



#整体模块测试
def test():
    '''
    Test function .
    :return:
    '''
    print("Testing Meal class.");
    m = Meal();
    m.printIt("\t");
    m = Meal('green eggs and ham','tea');
    m.printIt("\t");

    #Test Breakfast
    print("Testing Breakfast class.");
    b = Breakfast();
    b.printIt("\t");
    b.setName("breaking of the fast");
    b.printIt("\t");
    #Test dinner
    print("Testing Dinner class.");
    d = Dinner();
    d.printIt("\t");
    #Test lunch
    print("Testing Lunch class.");
    l = Lunch();
    l.printIt("\t");
    print("Calling Lunch.setFood().");
    try:
        l.setFood('hotdog');
    except AngryChefException:
        print("\t",'The chef is angry. Pick an omelet.');

if __name__ == '__main__':
    test();

