package Flatten;

public class StringReverse {
	
	
	public  static char[] reverseString(char[] arr, int pos,int len) {
		if(pos==len) {
			char[] c = new char[len+1];
			c[0]=arr[pos];
			return c;
		}
		else {
			char [] retArr = reverseString(arr,pos+1,len);
			retArr[len-pos]=arr[pos];
			return retArr;

		}
	}
	
	

}
