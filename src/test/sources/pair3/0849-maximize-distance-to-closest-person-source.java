package pair3;

class Solution {
    public int maxDistToClosest(int[] seats) {
        
        int maxDistance = Integer.MIN_VALUE;
        int lastOccupiedIndex = -1;
        int n = seats.length;
        
        for(int i=0;i<n;i++){
            
            if(seats[i]==1){
                
                if(lastOccupiedIndex==-1){
                    //-- if the first seat itself is taken
                    maxDistance = i;
                }
                else{
                    //-- to check the maximum distance between two occupied seats
                maxDistance = Math.max(maxDistance, (i-lastOccupiedIndex)/2);
                }
                
                lastOccupiedIndex = i; //-- update the index of last occupied seat
            }
        }
        
        //-- to check the distance from last occupied seat to the end of row
        maxDistance = Math.max(maxDistance, (n-1-lastOccupiedIndex));
        
        return maxDistance;
    }
}