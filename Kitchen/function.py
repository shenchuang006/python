# coding=utf-8
# Fibonacci numbers module
import sys;
def fib(n):    # write Fibonacci series up to n
    '''
    This is a add
    :param n:
    :return:
    '''
    a, b = 0, 1;
    while b < n:
        print(b);
        a, b = b, a+b;


def fib2(n): # return Fibonacci series up to n
    result = []
    a, b = 0, 1
    while b < n:
        result.append(b)
        a, b = b, a+b
    return result;

print("%s"%fib.__doc__);

special_sauce=['ketchup','mayonnaise','french dressing'];
def make_new_sauce():
    """
    This function makes a new special sauce all its own
    :return:
    """
    special_sauce = ['mustard','yogurt'];
    return special_sauce;
print("%s" % special_sauce);
new_sauce = make_new_sauce();
print(new_sauce);

#类和对象
omelet_type = "Cheese";
print(omelet_type.lower());
print(omelet_type.upper());
print(dir(omelet_type));

print("--------" * 10);

print(sys.path);

print("This was given the command line parameters : %s" % sys.argv);