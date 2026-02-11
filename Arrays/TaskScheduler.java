public class TaskScheduler {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        for (char c: tasks){
            freq[c - 'A']++;
        }

        int maxFreq = 0;
        for (int f: freq){
            maxFreq = Math.max(maxFreq, f);
        }

        int maxCount = 0;
        for (int i: freq){
            if (i == maxFreq) maxCount++;
        }

        int partCount = maxFreq - 1;
        int partLength = n + 1;
        int minTime = partCount * partLength + maxCount;

        return Math.max(tasks.length, minTime);
    }
    public static void main(String[] args) {
        TaskScheduler scheduler = new TaskScheduler();
        System.out.println(scheduler.leastInterval(new char[]{'A', 'A', 'A', 'B', 'B', 'B'}, 2));
    }
}
