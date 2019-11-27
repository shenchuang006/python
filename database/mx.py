#coding=utf-8
import dbm;
#c 打开数据文件以便对其进行读写,必要时创建文件
#N 打开文件以便对其进行读写,但总是创建一个新的空文件,
# 如果该文件存在,则将被覆盖,已有的内容将会丢失
# w 打开文件以便对其进行读写，但是如果该文件不存在,那么不会创建它.
db = dbm.open('websites', 'c');
#Add an item.
db['www.python.org'] = 'Python home page';
print(db['www.python.org']);
#Close and save to disk.
db.close();

db = dbm.open("websites","w");
db['www.wrox.com'] = 'wrox home page';
if db['www.python.org'] != None:
    print('Found www.python.org');
else:
    print('Error: Missing item');
for key in db.keys():
    print('key =',key,'value = ',db[key]);
db.close();
#删除,key value 都是字符串的字典
#del db[''];

