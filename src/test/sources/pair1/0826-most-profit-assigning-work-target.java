package pair1;

class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int n = difficulty.length;

        for (int i = 0; i < n; i++) {
            jobs.add(new Job(difficulty[i], profit[i]));
        }
        Collections.sort(jobs, Comparator.comparingInt(j -> j.difficulty));
        Arrays.sort(worker);
        int totalProfit = 0, bestProfit = 0, bestDifficulty = 0, j = 0;
        for (int ability : worker) {
            while (j < n && ability >= jobs.get(j).difficulty) {
                Job job = jobs.get(j);
                if (job.profit > bestProfit) {
                    bestProfit = job.profit;
                    bestDifficulty = job.difficulty;
                }
                j++;
            }
            if (bestProfit > 0) {
                totalProfit += bestProfit;
            }
        }
        return totalProfit;
    }
}

class Job {
    int difficulty;
    int profit;

    Job(int difficulty, int profit) {
        this.difficulty = difficulty;
        this.profit = profit;
    }
}