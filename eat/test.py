#coding=utf-8
import eat;
from eat import Meal;
def test():
    '''
    Test function .
    :return:
    '''
    print("Testing Meal class.");
    m = eat.Meal.Meal();
    m.printIt("\t");
    m = eat.Meal.Meal('green eggs and ham','tea');
    m.printIt("\t");

    #Test Breakfast
    print("Testing Breakfast class.");
    b = eat.Meal.Breakfast();
    b.printIt("\t");
    b.setName("breaking of the fast");
    b.printIt("\t");
    #Test dinner
    print("Testing Dinner class.");
    d = eat.Meal.Dinner();
    d.printIt("\t");
    #Test lunch
    print("Testing Lunch class.");
    l = eat.Meal.Lunch();
    l.printIt("\t");
    print("Calling Lunch.setFood().");
    try:
        l.setFood('hotdog');
    except eat.error.AngryChefException:
        print("\t",'The chef is angry. Pick an omelet.');

if __name__ == '__main__':
    test();

