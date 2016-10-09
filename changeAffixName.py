# -*- coding:utf-8 -*-  

#------------------------------------------------------------#
# Author:    Yang Du 
# Email:     duyang (-A-T-) iscas dot ac dot cn
# Date:      2016-10-19
# Purpose:  Change suffix of assigned files of the current file directory 
# Usage: python changeAffixName.py originFilename afterFilename
#------------------------------------------------------------#
# Copyright (C) 2016       Yang DU
# RegimeCast is freely available for non-commercial purposes
#------------------------------------------------------------#

import os,sys

def  changeFileName(sourceName,targetname):
	lenSourceName = len(sourceName)
	remainPartFileName= ""
	oriFilename=sourceName
	targetFilename=targetname
	nameChangedNumeber=0


	for filename in os.listdir(r'./'):
		if filename[0]=='.':
			continue

		lenFilename=len(filename)
		if lenFilename < (lenSourceName+1):	 
			continue

		filenameAffix=filename[(lenFilename-lenSourceName):lenFilename]
		 
		if filenameAffix==sourceName:
			remainPartFileName=filename[0:(lenFilename-lenSourceName)]

			oriFilename=remainPartFileName+oriFilename
			targetFilename=remainPartFileName+targetname

			operationConmmand = "mv "+oriFilename+" "+targetFilename
			os.system(operationConmmand)
			nameChangedNumeber = nameChangedNumeber+1

	return nameChangedNumeber
		 




if __name__ == '__main__':
	commandArgs=sys.argv

	try:
		sourceName=commandArgs[1]
		targetname=commandArgs[2]
		 
		nameChangedNumeber= changeFileName(sourceName,targetname)
		print "Done! "+str(nameChangedNumeber)+" of files have been chaneged"
	except:
		print "Error: Usage \'python changeAffixName.py BEFOREnAME AFTERnAME\' "
