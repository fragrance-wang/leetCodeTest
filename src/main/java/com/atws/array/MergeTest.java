package com.atws.array;

/**
 * https://leetcode.cn/problems/merge-sorted-array/
 * <p>
 * https://leetcode.cn/problems/merge-sorted-array/solution/hua-jie-suan-fa-88-he-bing-liang-ge-you-xu-shu-zu-/
 * <p>
 * 从后向前遍历，这个思路比较好，不受影响
 * 因为 nums1 的空间都集中在后面，所以从后向前处理排序的数据会更好，节省空间
 *
 * @author wangshan
 * @date 2023-07-12 上午11:28
 */
public class MergeTest {

    public static void main(String[] args) {
        int[] nums1 = {4, 5, 6, 0, 0, 0};
        int[] nums2 = {1, 2, 3};
        new MergeTest().merge(nums1, 3, nums2, 3);
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (n == 0) {
            return;
        }
        int a = m - 1;
        int b = n - 1;
        int index = m + n - 1;
        while (a >= 0 && b >= 0) {
            if (nums1[a] >= nums2[b]) {
                nums1[index] = nums1[a];
                a--;
            } else {
                nums1[index] = nums2[b];
                b--;
            }
            index--;
        }
        System.arraycopy(nums2, 0, nums1, 0, b + 1);
    }
}
