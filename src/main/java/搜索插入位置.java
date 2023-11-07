//搜索插入位置
/**
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 *
 * 请必须使用时间复杂度为 O(log n) 的算法。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: nums = [1,3,5,6], target = 5
 * 输出: 2
 * 示例 2:
 *
 * 输入: nums = [1,3,5,6], target = 2
 * 输出: 1
 * 示例 3:
 *
 * 输入: nums = [1,3,5,6], target = 7
 * 输出: 4
 *
 * 作者：LeetCode
 * 链接：https://leetcode.cn/leetbook/read/array-and-string/cxqdh/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */


public class 搜索插入位置 {
    public static void main(String[] args) {
        int[] nums = {1,3,5,6};
        int res = searchInsert(nums, 7);
        int res2 = searchInsert2(nums, 7);
        System.out.println(res);
        System.out.println(res2);
    }

    /**
     * 暴力求解
     * @param nums
     * @param target
     * @return
     */
    public static int searchInsert(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            //命中返回
            if (target == nums[i] || nums[i] > target) {
                return i;
            }
        }
        //不存在且target > max(nums)
        return nums.length;
    }

    /**
     * 二分法，递归
     * @param nums
     * @param target
     * @return
     */
    public static int searchInsert2(int[] nums, int target) {
        return byRecursion(nums, target, 0, nums.length - 1);
    }

    public static int byRecursion(int[] nums, int target, int leftIndex, int rightIndex) {
        //不在区间内
        if (target < nums[leftIndex]) {
            return leftIndex;
        } else if (target > nums[rightIndex]) {
            return rightIndex + 1;
        }
        //在区间内，且为相邻区间
        if ((rightIndex - leftIndex) == 1) {
            if (target == nums[leftIndex]) {
                return leftIndex;
            } else if (target == nums[rightIndex]){
                return rightIndex;
            } else {
                return leftIndex + 1;
            }
        }
        //在区间内、且为非相邻区间，取中位数，若不命中位数，继续压缩区间
        int midIndex = (rightIndex + leftIndex) / 2;
        if (nums[midIndex] > target) {
            return byRecursion(nums, target, leftIndex, midIndex);
        } else if (nums[midIndex] < target){
            return byRecursion(nums, target, midIndex, rightIndex);
        } else {
            return midIndex;
        }
    }

}
