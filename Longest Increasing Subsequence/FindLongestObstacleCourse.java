import java.util.ArrayList;
import java.util.List;

public class FindLongestObstacleCourse {
    public static int[] longestObstacleCourseAtEachPosition(int[] obstacles) {
        int n = obstacles.length;
        int[] ans = new int[n];
        List<Integer> lis = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int height = obstacles[i];
            if (lis.isEmpty() || lis.get(lis.size() - 1) <= height) {
                lis.add(height);
                ans[i] = lis.size();
            } else {
                int idx = findInsertionPoint(lis, height);
                lis.set(idx, height);
                ans[i] = idx + 1;
            }
        }

        return ans;
    }

    private static int findInsertionPoint(List<Integer> lis, int target) {
        int left = 0, right = lis.size() - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (lis.get(mid) <= target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        int[] obstacles = {1, 2, 3, 2, 1, 5, 1};
        int[] ans = longestObstacleCourseAtEachPosition(obstacles);
        for (int length : ans) {
            System.out.print(length + " ");
        }
        // Output: 1 2 3 3 3 4 4
    }
}


//You want to build some obstacle courses. You are given a 0-indexed integer array obstacles of length n, where obstacles[i] describes the height of the ith obstacle.

//For every index i between 0 and n - 1 (inclusive), find the length of the longest obstacle course in obstacles such that:

//You choose any number of obstacles between 0 and i inclusive.
//You must include the ith obstacle in the course.
//You must put the chosen obstacles in the same order as they appear in obstacles.
//Every obstacle (except the first) is taller than or the same height as the obstacle immediately before it.
//Return an array ans of length n, where ans[i] is the length of the longest obstacle course for index i as described above.