#coding=utf-8
class Fridge:
    """
    This class implements a fridge where ingredients can be added
    and removed individually , or in groups.
    The fridge will retain a count of every ingredient added or removed,
    and will raise an error if a sufficient quantity of an ingredient
    isn't present.
    Methods:
    has()
    """
    def __init__(self,items={}):
        """
        Optionally pass in an initial dictionary of items
        :param items:
        """
        if type(items) != type({}):
            raise TypeError("Fridge requires a dictionary but was given %s" % type(items));
        self.items = items;
        return;
    def _add_multi(self,food_name,quantity):
        if(not food_name in self.items):
            self.items[food_name] = 0;
        self.items[food_name] = self.items[food_name] + quantity;
    def add_one(self,food_name):
        if type(food_name) != type(""):
            raise TypeError("add_one requires a string ,given a %s" % type(food_name));
        else:
            self._add_multi(food_name,1);
        return True;
    def add_many(self,food_dict):
        if type(food_dict) != type({}):
            raise  TypeError("add_many requires a dictionary,got a %s " % food_dict);
        for item in food_dict.keys():
            self._add_multi(item,food_dict[item]);
        return ;
    def has(self,food_name,quantity=1):
        return self.has_various({food_name:quantity});
    def has_various(self,foods):
        try:
            for food in foods.keys():
                if self.items[food] < foods[food]:
                    return False;
            return True;
        except KeyError:
            return False;







