import java.util.ArrayList;
import java.util.List;

public class InsertIntervals {
    public static int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> arrayList = new ArrayList<>();
        int n = intervals.length;
        int i = 0;

        // left part
        while (i < n && intervals[i][1] < newInterval[0]){
            arrayList.add(intervals[i]);
            i+=1;
        }

        // middle part
        while (i < n && intervals[i][0] <= newInterval[1]){
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i += 1;
        }
        arrayList.add(newInterval);

        //right part
        while (i < n){
            arrayList.add(intervals[i]);
            i += 1;
        }

        return arrayList.toArray(new int[arrayList.size()][]);
    }

    public static void main(String[] args) {
        int[][] arr = insert(new int[][]{{1, 3}, {6, 9}}, new int[]{2, 5});
        int[][] arr4 = insert(new int[][]{{1, 5}}, new int[]{2, 7});
        int[][] arr3 = insert(new int[][]{{1, 3}, {6, 9}}, new int[]{2, 5});
        int[][] arr1 = insert(new int[][]{{1,2},{3,5},{6,7},{8,10},{12,16}}, new int[]{4, 8}); // [[1,2],[3,10],[12,16]]
//        System.out.println(arr1.length);
        for (int[] ar: arr4){
            System.out.println(ar[0] + " " + ar[1]);
        }
    }
}
