importjava.util.Scanner;

publicclassMain{
    publicstaticvoidmain(String[]args){
        Scannerscanner=newScanner(System.in);
        // Read input
                // Read input
        intn=scanner.nextInt();
        // Check if N can be represented as product of two integers between 1 and 9
                // Check if N can be represented as product of two integers between 1 and 9
        booleanpossible=false;
        // Try all possible combinations of numbers between 1 and 9
                // Try all possible combinations of numbers between 1 and 9
        for(inti=1;i<=9;i++){
            for(intj=1;j<=9;j++){
                if(i*j==n){possible=true;
                    break;
                }}
            if(possible){break;
            }}
        // Print result
                // Print result
        if(possible)System.out.println("Yes");
        elseSystem.out.println("No");
        
        scanner.close();
    }
}
