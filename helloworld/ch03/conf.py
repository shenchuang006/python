import sys,os

if "CONFIG_ENV" in os.environ:
    evn_config = os.environ["CONFIG_ENV"]
elif "config_env" in os.environ:
    evn_config = os.environ["config_env"]
else:
    evn_config = sys.argv[0]
    if not evn_config:
        evn_config = 'local'

config = {
    'local':{
        'host': '172.16.4.143',
        'port': '20245'
    }
}
