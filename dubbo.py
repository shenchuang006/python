import json
import telnetlib


class Dubbo(telnetlib.Telnet):
    prompt = 'dubbo>'
    coding = 'utf-8'

    def __init__(self, host=None, port=0):
        super().__init__(host, port)
        self.write(b'\n')

    def command(self, flag, str_=""):
        data = self.read_until(flag.encode(),300000)
        self.write(str_.encode() + b"\n")
        return data

    def invoke(self, service_name, method_name,params):
        command_str = "invoke {0}.{1}({2})".format(
            service_name, method_name,params)
        print(command_str)
        self.command(Dubbo.prompt, command_str)
        data = self.command(Dubbo.prompt, "")
        print(data)
        # data = json.loads(data.decode(Dubbo.coding, errors='ignore').split('\n')[0].strip())
        return data


if __name__ == '__main__':
    # conn = Dubbo('localhost', 20177)
    # param_json = {'id': 'SO1901146034207327001', "status": 2}
    # result = conn.invoke(
    #     'com.yunji.oms.order.api.ICommonOrderService',
    #     "update",
    #     param_json
    # )
    # # result = conn.invoke(
    # #     "com.yunji.oms.order.api.ISrcOrderService",
    # #     "getById"
    # # )
    # print(result)
    conn = Dubbo('172.16.4.143', 20245)
    # conn = Dubbo(sys.argv[3], sys.argv[4])

    json_data = {
        "beginTime": "2017-10-01 00:00:00",
        "type": 2
    }
    set = ["2017-10-01 00:00:00", 2];
    # 一个参数的直接传值,对象传递json,多个字段传递json
    # result = conn.invoke("com.yunji.oms.stockaccount.history.api.IStockDataMoveService","moveDataByTime",("2017-10-01 00:00:00",2))
    set = ["2017-10-01 00:00:00", 2];
    # 一个参数的直接传值,对象传递json,多个字段传递json
    result = conn.invoke("com.yunji.ims.purchase.api.IPurchaseOrderService", "refundQueryStock",({"orderType": 24, "orderId": "123"}))
    # result = conn.invoke(sys.argv[0], sys.argv[1],(sys.argv[2]))
    print(result)

