importjava.util.HashMap;
importjava.util.ArrayList;
importjava.util.Scanner;
importjava.util.regex.Pattern;
importjava.util.Collections;
publicclassMain{
	publicstaticScannersc=newScanner(System.in);publicstaticvoidmain(String[]args)throwsException{
		intr=sc.nextInt();
		intc=sc.nextInt();
		int[][]ary=newint[r+1][c+1];

		for(inti=0;i<r;i++){
			for(intj=0;j<c;j++){
				ary[i][j]=sc.nextInt();
			}
		}
		
		for(inti=0;i<r;i++){
			for(intj=0;j<c;j++){
				ary[i][c]+=ary[i][j];
			}
		}
		
		for(inti=0;i<c+1;i++){
			for(intj=0;j<r;j++){
				ary[r][i]+=ary[j][i];
			}
		}
		
		for(inti=0;i<r+1;i++){
			StringBuildersb=newStringBuilder();

			for(intj=0;j<c+1;j++){
				sb.append(ary[i][j]).append(" ");
			}
			sb.delete(sb.length()-1,sb.length());
			System.out.println(sb);
		}
	}
}
