/**    
*------------------------------------------------------------*
* Author:    Yang Du 
* Email:     duyang2015 (-A-T-) iscas dot ac dot cn
* Date:      2017-02-28
* Purpose:  Some useful small math scripts in Java
*------------------------------------------------------------*
* Copyright (C) 2017       Yang DU
* This code is freely available for non-commercial purposes
*------------------------------------------------------------*
*/

import java.util.ArrayList;

public class FactorMaster {

	public static void main(String[] args) {
		ArrayList<Integer> hh =  findAllFactor(10);
		for(int a:hh)
		System.out.println(a);
	
	}

	public static ArrayList<Integer> findAllFactor(int num) {
		ArrayList<Integer> returnArrayList = new ArrayList<Integer>();
		ArrayList<Integer> primeList =  resolve_Prime(num);
		int primeListLen = primeList.size();
		int lenPrimeListPower2MinusOne =(int)Math.pow(2,primeListLen)-1;
		int addCandidate =1;
		for(int i=0;i<lenPrimeListPower2MinusOne;i++){
			String iString = Integer.toBinaryString(i);
			int iStringLen = primeListLen-iString.length();
			while(iStringLen>0){
				iString = "0"+iString;
				iStringLen--;
			}
			for(int countStr = 0;countStr<primeListLen;countStr++){
				if(iString.charAt(countStr)=='1')
					addCandidate*=primeList.get(countStr);
			}
			returnArrayList.add(addCandidate);
			addCandidate=1;
			
		}
		return returnArrayList;
	}
	
	public static ArrayList<Integer> resolve_Prime(int num) {
		ArrayList<Integer> returnArrayList = new ArrayList<Integer>();
		int i = 2;
		while (i <= num) {
			if (num % i == 0) {	
				returnArrayList.add(i);		
				num = num / i;		
				i = 2;
			} else 	
				i++;			
		}
		return returnArrayList;
	}
}