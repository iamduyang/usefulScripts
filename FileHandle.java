/**    
*------------------------------------------------------------*
* Author:    Yang Du 
* Email:     duyang2015 (-A-T-) iscas dot ac dot cn
* Date:      2016-11-17
* Purpose:  Some useful IO scripts in Java
*------------------------------------------------------------*
* Copyright (C) 2016       Yang DU
* This code is freely available for non-commercial purposes
*------------------------------------------------------------*
*/


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

import org.apache.commons.lang.ArrayUtils;


public class FileHandle 
{
	public FileHandle()
	{
		 
	}

	public FileHandle(String dirName) throws IOException
	{
		 
	}
	
	public static String [] listFiles(String filePath2list)
	{
		File file = new File(filePath2list);
		String[] textNames=null;
		if(!file.isDirectory())
		{
			System.out.println( filePath2list +" is not directory!" );
		}
		else 
		{	
			textNames = file.list();
			for( int i=0; i<textNames.length; ++i )
			{
				if( textNames[i].trim().charAt(0) == '.' ){
					//System.out.println("Start with 0: "+textNames[i]);
					textNames = (String[]) ArrayUtils.remove(textNames, i);
					i--; // which is important 
				}
					
			}
			
			//for(String printString: textNames)
				//System.out.println(textNames.length);
		}
		return textNames.clone();
		
	}

	
	public static int getFilength(String fileName) throws IOException
	{
		
		int lengthOfFile=0;
		File f = new File(fileName);

		InputStreamReader read = new InputStreamReader (new FileInputStream(f),"UTF-8");

		BufferedReader reader=new BufferedReader(read);

		String line;

		while ((line = reader.readLine()) != null) {	 
			lengthOfFile+=line.length();
		}
		reader.close();
		return lengthOfFile;

	}
	
	


	public static String handleSemicolonMark(String originString)  
	{
		if( !originString.contains(";") ) 
			return originString;
		
		String outPutString="";
		String analyzedString=null;
		String reg = "[\u4e00-\u9fa5]";
        int index = -2;
        if (originString.matches (".*" + reg + ".*"))
        {
            index = originString.split (reg)[0].length ();
        }
        
        if(index>0){
        	analyzedString=originString.substring(0,index);
        }
        reg="^\\d+$";// to match number
        String [] lineArray = analyzedString.split(",|，|\\s+");
        for (String Hello:lineArray)
        	if( !Hello.contains(";") ) 
        		outPutString+=Hello+" ";
         
        return outPutString;
		 
	}

}
