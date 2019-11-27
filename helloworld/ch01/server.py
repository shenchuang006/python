#ecoding=utf-8
# server.py
# 从wsgiref模块导入:
from wsgiref.simple_server import make_server
# 导入我们自己编写的application函数:
from ch01.hello import application

# 创建一个服务器，IP地址为空，端口是8000，处理函数是application:
httpd = make_server('', 8000, application)
print("Serving HTTP on port 8000...");
# 开始监听HTTP请求:
httpd.serve_forever();

if __name__ == '__main__':
    print('---wsgi服务端启动---');