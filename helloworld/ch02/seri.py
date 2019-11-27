"""
python-序列化与反序列化
 序列化模块
# 序列化方法
# 格式转换
# 把python中的数据转换成str---序列化
# 可以str转换成python的数据---反序列化
json模块
# json所有的语言都通用，它能序列化的数据是有限的：字典列表和元组
import json
# json.dumps()与json.loads()是一对
# json.dump()与json.load()是一对
# json.dumps()#序列号 “obj” 数据类型 转换为 JSON格式的字符串
# ret = json.dumps({'k':(1,2,3)})
# print(repr(ret),type(ret))      #str()是将作用对象“以字符串格式输出”，重在输出；repr()是“显示对象是什么东西”，重在表述。所以在调试程序时常常用后者打印。
# ret2 = json.loads(ret)    #将包含str类型的JSON文档反序列化为一个python对象
# print(repr(ret2),type(ret2))
# #json.dump()#理解为两个动作，一个动作是将”obj“转换为JSON格式的字符串，还有一个动作是将字符串写入到文件中，也就是说文件描述符fp是必须要的参数 """
 #View Code
#pickle模块
#是python特有的
# 也是有dumps() loads()
#       dump()  load()使用方法和json一模一样
# pickle在python中可以序列化任何数据类型，python专有的不能喝其他语言兼容，结果是bytes
# 用pickle序列化的数据，反序列化也必须用pickle
# 总结：
# 1.json序列化方法：dumps：无文件操作            dump：序列化+写入文件
# 2.json反序列化方法： loads：无文件操作              load： 读文件+反序列化
# 3.  json模块序列化的数据 更通用
#     picle模块序列化的数据 仅python可用，但功能强大，可以序列号函数
# 4.json模块可以序列化和反序列化的数据类型见python对象（obj） 与json对象的对应关系表
#     python对象（obj)             json
#         dict                        object
#         list,tuple                  array
#         str                         string
#         int, float                  number
#         True                        true
#         False                       false
#         None                         null
# 5.格式化写入文件利用indent = 4
#shelve模块
# shelve也是python提供给我们的序列化工具，比pickle用起来更简单一些
# shelve只提供给我们一个open方法，是用key来访问的，使用起来和字典类似

#复制代码
 #import shelve
# f = shelve.open('shelve_file')
# f['key'] = {'int':10,'float':9.5,'string':'Sample data'}    #直接对文件句柄操作，就可以存入数据
# f.close()
#
# f1 = shelve.open('shelve_file')
# existing = f1['key']
# f1.close()
# print(existing)
# 这个模块有个限制，它不支持多个应用同一时间往同一个DB进行写操作。所以当我们知道我们的应用如果只进行读操作，我们可以让shelve通过只读方式打开DB

# 不支持多个人同时写，支持多个人同时读，如果只是读的化，就设置flag='r'
#import shelve
# f = shelve.open('shelve_file',flag = 'r')
# existing = f['key']
# f.close()
# print(existing)
# 由于shelve在默认情况下是不会记录待持久化对象的任何修改的，所以我们在shelve.open()时候需要修改默认参数，否则对象的修改不会保存。
# 正常情况下shelve打开的文件句柄感知不到值的修改，设置writeback = True就可以保存修改内容了
# f2 = shelve.open('shelve_file',writeback=True)
# # print(f2['key'])
# f2['key']['new_value'] = 'this was not here before'
# print(f2['key'])
# f2.close()
#复制代码
# 大总结：
# json：所有语言通用，能转换的数据类型有限，重要程度  五颗星*****
# pickle：只限于python，能转换所有的数据类型     做游戏的时候会用到
# shelve：只限于python语言，能转换所有的数据类型，使用方法类似字典