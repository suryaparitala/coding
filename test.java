import java.util.*;
 class Solution {
	 
	 
	 int shift = 0;
     public void decodeString(String s) {
        char[] ch = s.toCharArray();
        int x=0;
		int num=0;;
		int contcount = -1;
        for(int y=0;y<ch.length;y++){
			contcount++;
            if(Character.isDigit(ch[y])){
                
               num =  isnext(y,ch);
			   System.out.println(num);
			   y = y + shift+1;
			   shift =0;
            }
			String app = "";
			System.out.println("reached here" +y);
			int z=y;
			while(Character.isLetter(ch[z])){
				System.out.println("reached string count");
				app = app + ch[z];
				z++;
			}
			System.out.println(app + num);
			StringBuilder sb = new StringBuilder();
			for(int i=0;i<num;i++)
				sb.append(app);
			System.out.println("finally here app is " + sb);
			app = "";
        }
        
	}
     public int isnext(int i,char[] ch){
        int j = i;
		//System.out.println("lol" + (ch[i] - '0'));
        int count =1;
        int num = 0;
        while(Character.isDigit(ch[j++]) );
			//System.out.println("inside find num loop"+(ch[j]-'0'));
        for(int x = j-2; x>=i;x--){
			//System.out.println(ch[x]-'0');
            num = num + count*(ch[x]-'0');
            count = count*10;
            
        }
       // System.out.println(num);
		//System.out.println("Starting from i these many places are numbers "+ (j-2 - i));
		shift = j-(2-i);
        return num;
    
        
        
    }
}
public class test{
public static void main(String[] args){
	Solution sol = new Solution();
	sol.decodeString("3Abc4c");
	
	
	
	
}
}