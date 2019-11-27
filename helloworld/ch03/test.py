# -*- coding: UTF-8 -*-

#from helloworld.helloworld.ch03.PropertiesUtiil import PropertiesUtil
import PropertiesUtiil
dictProperties=PropertiesUtiil.Properties("global.properties").getProperties()
print(dictProperties)