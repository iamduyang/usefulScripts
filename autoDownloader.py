# -*- coding:utf-8 -*-  

#------------------------------------------------------------#
# Author:    Yang Du 
# Email:     duyang2015 (-A-T-) iscas dot ac dot cn
# Date:      2016-11-30
#------------------------------------------------------------#
# Copyright (C) 2016       Yang DU
# This code is freely available for non-commercial purposes
#------------------------------------------------------------#
import os
import time

downloadurl1="wget -c "  ###main url address
downloadurl11=".pdf"
downloadurl2=" -O "
downloadurl3=".pdf"
#wget -c "www.baidu.com" -O baidu.index.html


downloadurl=""

f = open("f2.txt")              #txt 
line = f.readline()           
while line:  
    line=line.strip('\n')
    #print line+".pdf"              
    # print(line, end = '')　　　 
   
    downloadurl=downloadurl1+line+downloadurl11+downloadurl2+"p"+line+downloadurl3
    print downloadurl
    os.system(downloadurl)
    time.sleep(1)
    line = f.readline()  

f.close()  



