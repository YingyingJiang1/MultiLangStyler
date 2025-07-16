import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
public class CutRibbon {

	public static int [] mem;
	public static int a,b,c;

	public static void main(String[] args) {

		Scanner s= new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		//BufferedReader n = new BufferedReader(new InputStreamReader(System.in));

		int valor=s.nextInt();
		a=s.nextInt();
		b=s.nextInt();
		c=s.nextInt();


		mem=new int [4001];
		for(int i=0;i<mem.length;i++){
			mem[i]=-10000;
		}
		mem[0]=0;
		for(int i = 1;i<mem.length;i++){
			if(i>=a && i>=b && i>=c){
				mem[i]= Math.max(1+mem[i-a], Math.max(1+mem[i-b],1+mem[i-c]));
			}
			else
			if(i>=a && i>=b)
				mem[i]= Math.max(1+mem[i-a],1+mem[i-b]);
			else
			if(i>=c && i>=b)
				mem[i]= Math.max(1+mem[i-c],1+mem[i-b]);
			else
			if(i>=a && i>=c)
				mem[i]= Math.max(1+mem[i-a],1+mem[i-c]);
			else
			if(i>=a)
				mem[i]= 1+mem[i-a];
			else
			if(i>=b)
				mem[i]= 1+mem[i-b];
			else
			if(i>=c)
				mem[i]= 1+mem[i-c];
		}
		System.out.println(mem[valor]);

	}

}
