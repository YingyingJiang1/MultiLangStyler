importjava.util.Scanner;
importjava.util.Arrays;

publicclassFrogJump{
    publicstaticvoidmain(String[]args){
        Scannerscanner=newScanner(System.in);
        // Read inputs
                // Read inputs
        intN=scanner.nextInt();
        intK=scanner.nextInt();
        int[]h=newint[N];
        for(inti=0;i<N;i++){
            h[i]=scanner.nextInt();
        }
        // Initialize dp array
                // Initialize dp array
        int[]dp=newint[N];
        Arrays.fill(dp,Integer.MAX_VALUE);
        
        dp[0]=0;// Starting point
        // Starting point
        // Compute minimum cost for each stone
                // Compute minimum cost for each stone
        for(inti=1;i<N;i++){
            for(intj=Math.max(0,i-K);j<i;j++){
                dp[i]=Math.min(dp[i],dp[j]+Math.abs(h[i]-h[j]));
            }
        }
        // Output the minimum cost to reach the last stone
                // Output the minimum cost to reach the last stone
        System.out.println(dp[N-1]);
        
        scanner.close();
    }
}
