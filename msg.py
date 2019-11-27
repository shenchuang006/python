import smtplib;
from email.mime.multipart import MIMEMultipart;
from email.mime.text import MIMEText;

msg = MIMEMultipart();

#构造附件1
att1 = MIMEText(open('obj.py', 'rb').read(), 'base64', 'gb2312')
att1["Content-Type"] = 'application/octet-stream'
att1["Content-Disposition"] = 'attachment; filename="hello.txt"'#这里的filename可以任意写，写什么名字，邮件中显示什么名字
msg.attach(att1)

#构造附件2
#att2 = MIMEText(open('/home/a2bgeek/develop/python/mail.py', 'rb').read(), 'base64', 'gb2312')
#att2["Content-Type"] = 'application/octet-stream'
#att2["Content-Disposition"] = 'attachment; filename="123.txt"'
#msg.attach(att2)

#加邮件头
strTo = ['745372213@qq.com', 'hnscily@163.com', 'shenchuang@yunjiglobal.com']
msg['to']=','.join(strTo)
msg['from'] = 'hnscily@163.com'
msg['subject'] = '邮件主题'
#发送邮件
try:
    #连接邮件服务器
    server = smtplib.SMTP('smtp.163.com',25)
    #server.connect('smtp.163.com')
    # 登录
    server.login('hnscily@163.com','19890302DEAR')
    #发送消息
    server.sendmail(msg['from'], strTo ,msg.as_string())
    server.quit()
    print('发送成功');
except Exception as e:
    print(str(e));