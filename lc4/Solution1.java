package lc4;

public class Solution1 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length, m = nums2.length;
        int[] total = new int[n + m];
        int left = 0, right = 0, i = 0;
        while (left < n && right < m) {
            if (nums1[left] < nums2[right]) {
                total[i++] = nums1[left++];
            } else {
                total[i++] = nums2[right++];
            }
        }
        if (left < n) {
            while (left < n) {
                total[i++] = nums1[left++];
            }
        } else {
            while (right < m) {
                total[i++] = nums2[right++];
            }
        }

        return (total.length % 2) == 1 ? total[total.length/2] : (total[total.length/2 - 1] + total[total.length/2])/2.0;
    }
}
