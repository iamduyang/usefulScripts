import os,sys

def exetheShell(fileName):
	os.system("latex "+fileName)
	os.system("bibtex "+fileName)
	os.system("latex "+fileName)
	os.system("latex "+fileName)
	os.system("dvipdfm "+fileName+".dvi")
	print('Down!')
	os.system("open "+fileName+".pdf")


if __name__ == '__main__':
	#fileName="paperNote1"
	sysArgv=sys.argv
	lenArg=len(sysArgv)
	#print lenArg
	if lenArg>=2:
		try:
			argvZero=sysArgv[1]
			print(argvZero)
			fileName =argvZero
			exetheShell(fileName)
		except IOError as e:
			pass
	else:
		print("Did NOT generate PDFs!")
		print("USAGE: python createPdf.py FILENAME(without '.tex' )")


	

