import java.util.*;

class Example{
	
	
	public static void main(String args[]){
		
		System.out.println("Get string 1");
		String x = getstring();
		char[] s1 = x.toCharArray();
		Arrays.sort(s1);
		
		System.out.println("Get string 2");
		String x = getstring();
		char[] s2 = x.toCharArray();
		Arrays.sorts(s2);
		
		
		String s3 = sortstring(s1);
		String s4 = sortstring(s2);
		
		
		
	}
	
	
	public static String sortstrin(char[] str){
		
		
	}
	
	
	
	public static String getstring(){
		
		String s;
		Scanner in = new Scanner(System.in);
		s = in.nextline();
		return s;
	}
	
}

