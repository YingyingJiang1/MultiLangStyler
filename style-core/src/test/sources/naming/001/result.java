importjava.util.Scanner;

publicclassConcatenationSquareChecker{
    publicstaticvoidmain(String[]args)throwsException{
        Scannerscanner=newScanner(System.in);
        // Read the input values for a and b
                // Read the input values for a and b
        inta=scanner.nextInt();
        intb=scanner.nextInt();
        // Concatenate a and b
                // Concatenate a and b
        StringconcatenatedString=String.valueOf(a)+String.valueOf(b);
        // Convert the concatenated string to an integer
                // Convert the concatenated string to an integer
        intconcatenatedNumber=Integer.parseInt(concatenatedString);

        // Check if the concatenated number is a perfect square
                // Check if the concatenated number is a perfect square
        if(isPerfectSquare(concatenatedNumber)){System.out.println("Yes");
        }else{System.out.println("No");
        }
        scanner.close();
    }
    
    @Override// Helper method to check if a number is a perfect square
    // Helper method to check if a number is a perfect square
    privatestaticbooleanisPerfectSquare(intnumber){
        intsqrt=(int)Math.sqrt(number);
        returnsqrt*sqrt==number;
    }
}
