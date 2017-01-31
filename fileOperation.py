# -*- coding:utf-8 -*-
"""
# Author:    Yang Du
# Email:     duyang2015 (-A-T-) iscas dot ac dot cn
# Date:      2017-01-20
# Purpose:
#------------------------------------------------------------#
# Copyright (C) 2017       Yang DU
# This code is freely available for non-commercial purposes
"""


import os
import time
import lineParser

test_file_path  ="./testIt.txt"


def join_path(target_path, filename):
    if target_path.endswith('/'):
        return target_path+filename
    else:
        return target_path+"/"+filename


def write_line2file(target_path, filename, writen_line, if_append=False):
    if if_append:
        file_write = open(join_path(target_path,filename), 'a')
    else :
        file_write = open(join_path(target_path,filename), 'w')

    file_write.write(writen_line)

    file_write.close()

def read_file_2_list(filePath):
    #####TODO
    return_list =[]
    file_read = open(filePath, 'r')


    while True:
        line = file_read.readline()
        if line:
            return_list.append(line)
        else:
            break


    file_read.close()
    return return_list

def get_all_filenames_in_dir():
    ### TODO
    filenames_list = []

    return filenames_list

if __name__ == "__main__":
    os.system("pwd")
    aList = read_file_2_list(test_file_path)
    final_out =""
    for x in aList:
        final_out = final_out + x

    print final_out
    print "End of The Work"







