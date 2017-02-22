# -*- coding:utf-8 -*-
"""
# Author:    Yang Du
# Email:     duyang2015 (-A-T-) iscas dot ac dot cn
# Date:      2017-02-22
# Main Feature(compare to createPdf.py):
# 	delete the old files first
#------------------------------------------------------------#
# Copyright (C) 2017       Yang DU
# This code is freely available for non-commercial purposes
"""

import os,sys

def exetheShell(fileName):
	os.system("rm *aux")
	os.system("rm *log")
	os.system("rm *bbl")
	os.system("rm *blg")
	os.system("latex "+fileName)
	os.system("bibtex "+fileName)
	os.system("latex "+fileName)
	os.system("latex "+fileName)
	os.system("dvipdfm "+fileName+".dvi")

	print 'Down!'
	os.system("open "+fileName+".pdf")


if __name__ == '__main__':
	#fileName="paperNote1"
	sysArgv=sys.argv
	lenArg=len(sysArgv)
	#print lenArg
	if lenArg>=2:
		try:
			argvZero=sysArgv[1]
			print argvZero
			fileName =argvZero
			exetheShell(fileName)
		except IOError, e:
			pass
	else:
		print "Did NOT generate PDFs!"
		print "USAGE: python createPdf.py FILENAME(without '.tex' )"


	

