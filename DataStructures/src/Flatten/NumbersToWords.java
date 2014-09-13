package Flatten;

import java.util.HashMap;
import java.util.Map;

public class NumbersToWords {
	
	enum digits {
		UNITS,
		TENS,
		HUNDREDS
	}
	

	
	private static final Map<String,String> otherToWordMap = new HashMap<String,String>(){{

		put("3","Thousand");
		put("4","Thousand");
		put("5","Thousand");
		put("6","Million");
		put("7","Million");
		put("8","Million");
	}};
	

	private static final Map<String,String> hundredsToWordMap = new HashMap<String,String>(){{
		put("0","");
		put("1","one hundred");
		put("2","two hundred");
		put("3","three hundred");
		put("4","four hundred");
		put("5","five hundred");
		put("6","six hundred");
		put("7","seven hundred");
		put("8","eight hundred");
		put("9","nine hundred");
		
		///568128
		//3210
		//01234
	}};
	
	private static final Map<String,String> unitsToWordMap = new HashMap<String,String>(){{
		put("0","");
		put("1","one");
		put("2","two");
		put("3","three");
		put("4","four");
		put("5","five");
		put("6","six");
		put("7","seven");
		put("8","eight");
		put("9","nine");
		
		///568128
		//3210
	}};
	
	private static final Map<String,String> tensToWordMap = new HashMap<String,String>(){{
		put("0","");
		put("1","ten");
		put("2","twenty");
		put("3","thirty");
		put("4","fourty");
		put("5","fifty");
		put("6","sixty");
		put("7","seventy");
		put("8","eighty");
		put("9","ninty");
		
		///68128
		//3210
	}};
	
	String wordToNumbers(String number) {
     final String highestNumber = otherToWordMap.get(String.valueOf(number.length()-1));
     String currNumber = highestNumber;
      String str="";
     int size=4;
     for(int i=0;i<number.length();i++) {
    	 int k=i;
    	 boolean flag=false;
    	 //6543
    	 while(size-k>=3&&highestNumber==currNumber) {
    		 currNumber=otherToWordMap.get(String.valueOf(size-k));
    		 k++; 
    		 flag=true;
    	 }
    	 if(flag) {
    	 str = str  +" "+sayThreeDigits(number.substring(i, k))+" "+otherToWordMap.get(String.valueOf(size-i));
    	 k--;
    	 i=k;
    	 }
    	 else {
    		 str = str  +" "+sayThreeDigits(number.substring(i, number.length()));
    		 i=i+3;
    	 }
     }
     return str.trim();
     
	}
	
	private static final Map<Integer,Map<String,String>> digitsToWordsMap = new HashMap<Integer,Map<String,String>>() {{
		put(0,unitsToWordMap);
		put(1,tensToWordMap);
		put(2,hundredsToWordMap);
	}};
	
	 String sayThreeDigits( String num) {
		String numberInWords="";
		while(num.length()!=3){
			num="0"+num;
		}
		for(int i=0;i<num.length();i++){
			if(num.charAt(i)!=0) {
				numberInWords=numberInWords+" "+digitsToWordsMap.get(2-i).get(String.valueOf(num.charAt(i)));
			}
		}
		
		return numberInWords;
	}

}
