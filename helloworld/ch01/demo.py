from wsgiref.simple_server import make_server


def demo_app(environ, start_response):
    # 回调 状态码、响应头
    start_response("200 OK", [('Content-Type', 'text/plain; charset=utf-8')])
    # 返回内容，注意返回内容应该是一个可迭代的bytes, python2.x是str
    # 详情请看PEP-3333
    return [b"Hello World!"]


if __name__ == '__main__':
    with make_server('', 8000, demo_app) as httpd:
        httpd.serve_forever();