import pandas as pd
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
  pool = ConnectionPool(**config)
  return pool
with connection_pool().connection() as conn:
  pd.read_sql('SELECT * FROM user', conn)
 # 或者
  connection = connection_pool().borrow_connection()
  pd.read_sql('SELECT * FROM user', conn)
  connection_pool().return_connection(connection);