package pair3;

class Solution {
  public int maxDistToClosest(int[] seats) {

    int n = seats.length;
    int[] left = new int[n];
    int[] right = new int[n];

    // Find closest occupied seat to the left
    for(int i=0; i<n; i++) {
      if(seats[i] == 1) left[i] = 0;
      else if(i==0) left[i] = n;
      else left[i] = left[i-1]+1;
    }

    // Find closest occupied seat to the right
    for(int i=n-1; i>=0; i--) {
      if(seats[i] == 1) right[i] = 0;
      else if(i==n-1) right[i] = n;
      else right[i] = right[i+1]+1;
    }

    int res = 0;
    // Return maximum of distances to left and right
    for(int i=0; i<n; i++) {
      if(seats[i]==0) {
        res = Math.max(res, Math.min(left[i], right[i]));
      }
    }
    return res;
  }
}
