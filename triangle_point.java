import java.util.*;
public class triangle_point {
	
	public static void main(String[] args){
		/*int[][] arr = new int[4][2];
		for(int i=0;i<4;i++)
		for(int j=0;j<2;j++){
			 arr[i][j] = read(); 
		}*/
		double x1 =1.0; //read();
		double y1 =0.0;//read();
		double x2 =5.0 ;//read();
		double y2 =0.0;//read();
		double x3 =3.0; //read();
		double y3 =3.0;//read();
		double x4 = 7.0;//read();
		double y4 = 7.0;//read();
		
		
		if(area(x1,y1,x2,y2,x3,y3) == area(x1,y1,x2,y2,x4,y4) + area(x1,y1,x3,y3,x4,y4) + area(x2,y2,x3,y3,x4,y4)) {
			System.out.println("point inside the triangle");
		}
		else
			System.out.println("point lies outside ");
		
		
		
	}

public static double read(){
	Scanner in = new Scanner(System.in);
	double n = in.nextDouble();
	return n;
}

public static double area(double x1,double y1,double x2,double y2,double x3,double y3){
	double area =0 ;
	area = Math.abs((x1*(y2-y3) + x2*(y3-y1) + x3*(y1-y2))/2);

	return area;
}
	
}
