//GenerateNewGoodFeatureCsv.java




import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;


import java.util.Properties; 
 

public class GenerateNewGoodFeatureCsv {
	public static final String commaCharacter = ",";
	public static final String curFilePath = "./";

	
	public static void main(String[] args) throws IOException  
	{ 
		if(args.length<2){
			System.out.println("ERROR!");
			System.out.println("USAGE: java GenerateNewGoodFeatureCsv dictionFile inputfile outputfile");
			return;
		}
		System.out.println("Checking!.......  ");
		System.out.println("dictionFile:  "+args[0]);
		System.out.println("inputfile:  "+args[1]);
		System.out.println("outputfile:  "+args[2]);
		System.out.println("featureNumber  "+args[3]);
		int featureNumber = Integer.parseInt(args[3]);
		newGoodFeatureCsvAction(args[0],args[1],args[2],featureNumber);
		System.out.println("End of the work!");
		
	}

	public static void newGoodFeatureCsvAction(String dictionFile,String inputfile,String outputfile,int featureNumber ) throws IOException  {
		String dictionFilePath = joinPath(curFilePath,dictionFile);
		String dictionString =readLine(dictionFilePath).get(0);
		String[] dictionStringArray=dictionString.split(commaCharacter);
		int attributeNum = dictionStringArray.length;
		int[] attributeInt  = new int[attributeNum];
		System.out.println("attribute Numbers: "+attributeNum);
		for(int i=0;i<attributeNum;i++){
			attributeInt[i]=Integer.parseInt(dictionStringArray[i])-1;
		}
		
		
		String inputFilePath = joinPath(curFilePath,inputfile);

		writeToFile("",curFilePath,outputfile, false);
		File sourceFile = new File(inputFilePath);
		BufferedReader reader = new BufferedReader(new FileReader(sourceFile));
		
		String currentLine = reader.readLine();
		
		while(currentLine != null){
			
			String curWriteLine = getWriteLine(attributeInt,currentLine,featureNumber);
			writeToFile(curWriteLine+"\n",curFilePath,outputfile, true);
			currentLine = reader.readLine();
		}
		reader.close();			
			
		
	
		
		
	}
	


	public static String getWriteLine(int[] attributeInt,String currentLine,int featureNumber) {
		String returnLine="";
		String[] currentLineArray = currentLine.split(commaCharacter); 
		returnLine +=  currentLineArray[attributeInt[0]];
		int minFeatureNumber =featureNumber;
		if(attributeInt.length<minFeatureNumber)
			minFeatureNumber =attributeInt.length;
		for(int i=1;i<minFeatureNumber;i++){
			returnLine += commaCharacter+currentLineArray[attributeInt[i]];
		}
		returnLine += commaCharacter+currentLineArray[currentLineArray.length-1];
		
		return returnLine;
	}
	
	
	

	
	public static String joinPath( String str1, String str2 )
	{
		String reString = ""+str1;
		reString.trim();
		
		if( reString.charAt(reString.length()-1) == '/')
		{
			reString += str2.trim();
		}
		else
		{
			reString += "/" + str2.trim();
		}
		
		return reString;
			
	}
	
	public static void writeToFile( String aStr, String aFileDir, String aFileName, boolean aAppend)
	{
		File outDir = new File(aFileDir);
		
		if(!outDir.exists())
		{
			outDir.mkdirs();
		}
		
		File fp = new File( outDir, aFileName );
		
		FileWriter writer = null;
		try {
			// "Entry_RL.java": assign true to aAppend
			writer = new FileWriter(fp, aAppend);

		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		try {
			writer.write(aStr);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}
	

	
	
	public static List<String> readLine(String path) throws IOException
	{
		List<String> list = new LinkedList<String>();
		File sourceFile = new File(path);
		BufferedReader reader = new BufferedReader(new FileReader(sourceFile));
		
		String temp = null;
		temp = reader.readLine();
		while(temp != null)
		{
			list.add(temp);
			temp = reader.readLine();
		}
		reader.close();
		
		return list;
	}
	
	
	

}
