/*
Enter your query here.
Please append a semicolon ";" at the end of the query and enter your query in a single line to avoid error.
*/
import java.util.*;
class Solution{

public static void main(String args[]){

int n = getvalue();
	int[][] arr = new int[n][3];
	for(int i =0 ; i< n;i++)
		for(int j=0;j<3;j++)
			arr[i][j] = getvalue();


for(int i=0;i<n;i++){
if(arr[i][0]<= 0 && arr[i][1]<= 0 && arr[i][2] <= 0){
System.out.println("Not A Triangle");
//System.exit(0);
continue;
}

if(arr[i][0]+arr[i][1] < arr[i][2] || arr[i][1]+arr[i][2] < arr[i][0] || arr[i][2]+arr[i][0] < arr[i][1]){
System.out.println("Not A Triangle");	
continue;
//System.exit(0);
}

if(arr[i][0] == arr[i][1]  && arr[i][1] == arr[i][2] ){
System.out.println("Equilateral");
continue;
//System.exit(0);

}

if(arr[0] == arr[1] || arr[1] == arr[2] || arr[0]== arr[2]){
System.out.println("Isosceles");
continue;
//System.exit(0);
}
else
System.out.println("Scalene");


}
}

static int getvalue(){
Scanner in = new Scanner(System.in);
System.out.println("enter the side of the traingle");
int s = in.nextInt();
return s;
}

}