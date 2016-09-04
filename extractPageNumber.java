import java.io.*;
import java.util.*;
import java.util.regex.*;

 
public class extractPageNumber {

public static void main(String[] args)throws Exception{
              
	 	//String finalString="";
		FileReader fr=new FileReader("11.txt");
		
		BufferedReader br=new BufferedReader(fr);
		while(br.readLine()!=null){
            String s1=br.readLine();
			// String s1 = "Thor (Page 23) ";
	    String pageNumberString="";
	    int pagePlace = 0,backPlace=0;
        Pattern p = Pattern.compile("Page");
		Matcher m = p.matcher(s1);  
			while (m.find()) {
			
			pagePlace=m.start();
			}
			//System.out.println("pagePlace appeared： " + pagePlace);
				 	
		p = Pattern.compile("\\)");
		m = p.matcher(s1);  
			while (m.find()) {
			
			backPlace=m.start();
			}
			//System.out.println("backPlace appeared： " + backPlace);
		if( (pagePlace>0)&&(backPlace>pagePlace)){
					pageNumberString=s1.substring((pagePlace+5),backPlace);

     			 System.out.println(pageNumberString);
		}

			
		}

		//str = str.replaceAll("[\\pP‘’“”]", " ");
		//finalString=finalString.replaceAll("[\\pP‘’“”]", " ");
		//System.out.print(finalString);
		br.close();


	}
	

     

     
}