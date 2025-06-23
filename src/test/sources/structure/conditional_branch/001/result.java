importjava.util.Scanner;

publicclassMain{
    publicstaticvoidmain(String[]args){
        Scannerscanner=newScanner(System.in);
        // Read input strings
                // Read input strings
        Strings=scanner.nextLine();
        Stringt=scanner.nextLine();
        // Check if rotation is possible
                // Check if rotation is possible
        booleanisRotationPossible=checkRotation(s,t);
        // Print result
                // Print result
        System.out.println(isRotationPossible?"Yes":"No");
        
        scanner.close();
    }
    
    publicstaticbooleancheckRotation(Strings,Stringt){
        // Concatenate S with itself
        // This will contain all possible rotations of S
                // Concatenate S with itself
                // This will contain all possible rotations of S
        StringdoubledS=s+s;// If lengths are different, rotation is impossible
        // If lengths are different, rotation is impossible
        if(s.length()!=t.length()){returnfalse;
        }// If T is a substring of doubledS, then T is a rotation of S
        // If T is a substring of doubledS, then T is a rotation of S
        returndoubledS.contains(t);
    }
}
