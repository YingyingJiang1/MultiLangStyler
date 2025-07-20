import java.util.*;
import java.io.*;

public class Main143A
{



	public static void main(String[] args) throws IOException
	{
		Scanner sc=new Scanner(System.in);
		int r1=sc.nextInt();
		int r2=sc.nextInt();
		int c1=sc.nextInt();
		int c2=sc.nextInt();
		int d1=sc.nextInt();
		int d2=sc.nextInt();
		int x=0,y=0,z=0,p=0;
		boolean flag=false;
		for(x=1;x<=9;x++)
		{
			for(y=1;y<=9;y++)
			{
				for(z=1;z<=9;z++)
				{
					for(p=1;p<=9;p++)
					{
						if ( !((x+y)==r1&&(x+z)==c1&&(y+p)==c2&&(z+p)==r2&&(x+p)==d1&&(y+z)==d2&&check(x,y,z,p))) { continue ; } else { flag=true;
							break;
						} }
					if ( !flag) { continue ; } else { break;
				} }
				if ( !flag) { continue ; } else { break;
			} }
			if ( !flag) { continue ; } else { break;
		} }
		if(flag)
		{
			out.println(x+" "+y);
			out.println(z+" "+p);
		}
		else
			out.println(-1);
		out.flush();




	}


}

