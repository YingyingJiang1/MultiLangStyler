importjava.util.Scanner;

publicclassMain{
    publicstaticvoidmain(String[]args){
        Scannerscanner=newScanner(System.in);
        // Read input
                // Read input
        intN=scanner.nextInt();
        StringS=scanner.next();// Check if the string length is even
        // If it's odd, it can't be a concatenation of two identical strings
        // Check if the string length is even
                // If it's odd, it can't be a concatenation of two identical strings
        if(N%2!=0){System.out.println("No");
            return;
        }// Get the first half of the string
        // Get the first half of the string
        StringfirstHalf=S.substring(0,N/2);
        // Get the second half of the string
                // Get the second half of the string
        StringsecondHalf=S.substring(N/2);// Compare the two halves
        // Compare the two halves
        if(firstHalf.equals(secondHalf)){System.out.println("Yes");
        }else{System.out.println("No");
        }
        scanner.close();
    }
}
