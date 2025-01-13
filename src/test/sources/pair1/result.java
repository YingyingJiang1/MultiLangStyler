package pair1;

class Solution {
public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
    PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (b[1] - a[1]));
    int p = 0;
    Arrays.sort(worker);
    for (int i = worker.length - 1;i >= 0 && pq.isEmpty() == false;i--) {
        if (worker[i] >= pq.peek()[0])
        p += 1;
        else{
            while (pq.isEmpty() == false && worker[i] < pq.peek()[0])
            pq.poll();
            if (pq.isEmpty() == false)
            p += 1;

            }
        }
    return p;
    }
}
