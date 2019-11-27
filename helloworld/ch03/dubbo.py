"""
Name: dubbo.py

Tesed in python3.5
"""

import json
import telnetlib
import socket
import conf


class Dubbo(telnetlib.Telnet):

    prompt = 'dubbo>'
    coding = 'utf-8'

    def __init__(self, host=None, port=0,
                 timeout=socket._GLOBAL_DEFAULT_TIMEOUT):
        super().__init__(host, port)
        self.write(b'\n')

    def command(self, flag, str_=""):
        data = self.read_until(flag.encode())
        self.write(str_.encode() + b"\n")
        return data

    def invoke(self, service_name, method_name, arg):
        #dumps是将dict转化成str格式，loads是将str转化成dict格式
        if str(arg).startswith("{"):
            command_str = "invoke {0}.{1}({2})".format(
                service_name, method_name, json.dumps(arg))
            self.command(Dubbo.prompt, command_str)
            data = self.command(Dubbo.prompt, "")
            data = json.loads(data.decode(Dubbo.coding,
                                          errors='ignore').split('\n')[0].strip())
            return data
        else:
            command_str = "invoke {0}.{1}{2}".format(
                service_name, method_name, arg)
            self.command(Dubbo.prompt, command_str)
            data = self.command(Dubbo.prompt, "")
            data = json.loads(data.decode(Dubbo.coding,
                                          errors='ignore').split('\n')[0].strip())
            return data

if __name__ == '__main__':

    conn = Dubbo(conf.config[conf.evn_config]['host'], conf.config[conf.evn_config]['port'])

    json_data = {
        "beginTime":"2017-10-01 00:00:00",
        "type": 2
    }
    set = ["2017-10-01 00:00:00",2];
    #一个参数的直接传值,对象传递json,多个字段传递json
    # result = conn.invoke("com.yunji.oms.stockaccount.history.api.IStockDataMoveService","moveDataByTime",("2017-10-01 00:00:00",2))
    set = ["2017-10-01 00:00:00", 2];
    # 一个参数的直接传值,对象传递json,多个字段传递json
    result = conn.invoke("com.yunji.ims.purchase.api.IPurchaseOrderService", "refundQueryStock",({"orderType": 24, "orderId": "123"}))
    print(result)