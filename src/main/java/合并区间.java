//合并区间

import java.util.Arrays;
import java.util.List;

/**
 *以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
 * 输出：[[1,6],[8,10],[15,18]]
 * 解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * 示例 2：
 *
 * 输入：intervals = [[1,4],[4,5]]
 * 输出：[[1,5]]
 * 解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。
 *
 * 作者：LeetCode
 * 链接：https://leetcode.cn/leetbook/read/array-and-string/c5tv3/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */



public class 合并区间 {

    public static void main(String[] args) {

        int[][] nums = {{1,3},{2,6},{8,10},{15,18}};
        int[][] mergeRes = merge(nums);
        System.out.println(mergeRes);

        List<Integer> numbers = Arrays.asList(1,2,5,2,1,6,3,5);
        System.out.println("排序前：");
        System.out.println(numbers);
        System.out.println("排序后：");
        System.out.println(sortByAsc(numbers));

        int[] a = new int[2];
        a[0] = 1;
        a[1] = 2;
        int[] b = new int[2];
        b[0] = 0;
        b[1] = 7;
        System.out.println(isIntersect(a, b));
    }

    public static int[][] merge(int[][] intervals) {

        return null;
    }

    /**
     * 判断两个一维数组是否有交集
     * @param a 第一个一维数组
     * @param b 第二个一维数组
     * @return 如果有交集则返回true，否则返回false
     */
    public static boolean isIntersect(int[] a, int[] b) {
        if (a[0] <= b[0] && a[1] >= b[0]) {
            return true;
        }
        if (a[0] <= b[1] && a[1] >= b[1]) {
            return true;
        }
        if (b[0] <= a[0] && b[1] >= a[0]) {
            return true;
        }
        if (b[0] <= a[1] && b[1] >= a[1]) {
            return true;
        }
        return false;
    }

    /**
     * 以升序对给定整数列表进行排序
     *
     * @param aList 待排序的整数列表
     * @return 排序后的整数列表
     */
    public static List<Integer> sortByAsc(List<Integer> aList) {
        int len = aList.size();
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len - 1 - i; j++) {
                if (aList.get(j) > aList.get(j + 1)) {
                    int temp = aList.get(j);
                    aList.set(j, aList.get( j + 1));
                    aList.set(j + 1, temp);
                }
            }
        }
        return aList;
    }

}
