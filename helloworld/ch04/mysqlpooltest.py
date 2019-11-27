from pymysqlpool import ConnectionPool
config = {
 'host': 'localhost',
 'port': 3306,
 'user': 'root',
 'password': 'root',
 'database': 'test'
}
def connection_pool():
  # Return a connection pool instance
  pool = ConnectionPool(size = 5,name = 'test',**config,autocommit = True)
  return pool
# 直接访问并获取一个 cursor 对象，自动 commit 模式会在这种方式下启用
with connection_pool().get_connection() as cursor:
   print('Truncate table user')
   #cursor.execute("create table user(`id` int(4) not null AUTO_INCREMENT primary key COMMENT '主键ID',`name` varchar(10) not null comment'名称',`age` int(3) not null comment '年龄')");
   cursor.execute('TRUNCATE Table user')
   print('Insert one record')
   result = cursor.execute('INSERT INTO user (name, age) VALUES (%s, %s)', ('Jerry', 20))
   print(result, cursor.lastrowid)
   print('Insert multiple records')
   users = [(name, age) for name in ['Jacky', 'Mary', 'Micheal'] for age in range(10, 15)]
   result = cursor.executemany('INSERT INTO user (name, age) VALUES (%s, %s)', users)
   print(result)
   print('View items in table user')
   cursor.execute('SELECT * FROM user')
   for user in cursor:
    print(user)
   print('Update the name of one user in the table')
   cursor.execute('UPDATE user SET name="Chris", age=29 WHERE id = 16')
   cursor.execute('SELECT * FROM user ORDER BY id DESC LIMIT 1')
   print(cursor.fetchone())
   print('Delete the last record')
   cursor.execute('DELETE FROM user WHERE id = 16')