/*
Enter your query here.
Please append a semicolon ";" at the end of the query and enter your query in a single line to avoid error.
*/
import java.util.*;
class Triangletype{

public static void main(String args[]){


	int[] arr = new int[3];
arr[0] = getvalue();
arr[1] = getvalue();
arr[2] = getvalue();
Arrays.sort(arr);

if(arr[0]<0 && arr[1]<0 && arr[2] < 0)
System.out.println("Not A Triangle");


if(arr[0] == arr[1]  && arr[1] == arr[2] )
System.out.println("Equilateral");

if(arr[0]+arr[1] < arr[2] || arr[1]+arr[2] < arr[0] || arr[2]+arr[0] < arr[1])
System.out.println("Not A Triangle");	

if(arr[0] == arr[1] || arr[1] == arr[2] || arr[0]== arr[2])
System.out.println("Isosceles");

else
System.out.println("Scalene");


}

static int getvalue(){
Scanner reader = new Scanner(System.in);
System.out.println("enter the side of the traingle");
int s = reader.nextInt();
return s;
}

}