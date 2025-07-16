import java.util.*;
import java.io.*;
public class EdE {

	public static void main(String[] args) throws Exception{
		long num=1000000007;
		// TODO Auto-generated method stub
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out=new PrintWriter(System.out);
		int n=Integer.parseInt(bf.readLine());
		long[] dp=new long[n+1];
		int[] isPrime=new int[n+1];
		int[] mu=new int[n+1];
		long sum=0;
		Arrays.fill(isPrime, 1);
		Arrays.fill(mu,  1);
		for(int i=2;i<=n;i++){
			if (isPrime[i]==1)
			{
				for(int j=i;j<=n;j+=i){
					if (j>i)
						isPrime[j]=0;
					if (j%(i*i)==0)
						mu[j]=0;
					mu[j]=-mu[j];
				}
			}
		}
		for(int i=2;i<=n;i++){
			sum+=(((long)(0-mu[i])*((((long)(n/i))*power(n-n/i, num-2, num))%num))%num+num)%num;

			sum%=num;

		}
		sum+=1;
		sum%=num;
		out.println(sum);



		out.close();



	}
	public static long power(long x, long y, long mod){
		long ans=1;
		while(y>0){
			if (y%2==1)
				ans=(ans*x)%mod;
			x=(x*x)%mod;
			y/=2;
		}
		return ans;
	}
}


//StringJoiner sj = new StringJoiner(" ");
//sj.add(strings)
//sj.toString() gives string of those stuff w spaces or whatever that sequence is







