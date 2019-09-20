package com.simao.common;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * @author bosong
 * @date 2019-06-28
 * https://leetcode-cn.com/problems/merge-k-sorted-lists/
 */

public class MergeListNode {

    public ListNode mergeKLists(ListNode[] lists) {
        int len = lists.length;
        if (len == 0) {
            return null;
        }
        return mergeKLists(lists, 0, len - 1);
    }

    public ListNode mergeKLists(ListNode[] lists, int l, int r) {
        // 思考这里为什么取等于？这是因为根据下文对 mergeKLists 的递归调用情况，区间最窄的时候，只可能是左右端点重合
        if (l == r) {
            return lists[l];
        }
        int mid = (r - l) / 2 + l;
        ListNode l1 = mergeKLists(lists, l, mid);
        ListNode l2 = mergeKLists(lists, mid + 1, r);
        return merge2List(l1, l2);
    }

    /**
     * 迭代
     */
    public ListNode reverse(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode result = null, index;
        while (head != null) {
            index = new ListNode(head.val);
            index.next = result;
            result = index;
            head = head.next;
        }

        return result;
    }

    /**
     * 递归
     */
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode p = reverseList(head.next); //这里只是把最后一个节点返回至顶层，最终其实返回的是最后一个节点
        head.next.next = head;
        head.next = null;
        return p;
    }

    public ListNode merge2List(ListNode l1, ListNode l2) {
        ListNode listNode = new ListNode(0);
        ListNode result = listNode;
        while (l1 != null || l2 != null) {
            if (l1 == null) {
                listNode.next = l2;
                l2 = l2.next;
            } else if (l2 == null) {
                listNode.next = l1;
                l1 = l1.next;
            } else {
                if (l1.val < l2.val) {
                    listNode.next = l1;
                    l1 = l1.next;
                } else {
                    listNode.next = l2;
                    l2 = l2.next;
                }
            }
            listNode = listNode.next;
        }
        return result.next;
    }

    /**
     * 递归的方式，leetcode方法
     *
     * @param l1
     * @param l2 123
     *           134
     *           => 112334
     * @return
     */
    public ListNode mergeTwoSortedListNode(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        if (l1.val < l2.val) {
            l1.next = mergeTwoSortedListNode(l1.next, l2);
            return l1;
        }
        l2.next = mergeTwoSortedListNode(l1, l2.next);
        return l2;
    }

    /**
     * 获取中位数
     *
     * @param A
     * @param B
     * @return
     */
    public double findMedianSortedArrays(int[] A, int[] B) {
        int m = A.length;
        int n = B.length;
        if (m > n) { // to ensure m<=n，exchange A to B
            int[] temp = A;
            A = B;
            B = temp;
            int tmp = m;
            m = n;
            n = tmp;
        }
        int iMin = 0, iMax = m, halfLen = (m + n + 1) / 2;
        while (iMin <= iMax) {
            int i = (iMin + iMax) / 2;
            int j = halfLen - i;
            if (i < iMax && B[j - 1] > A[i]) {
                iMin = i + 1; // i is too small
            } else if (i > iMin && A[i - 1] > B[j]) {
                iMax = i - 1; // i is too big
            } else { // i is perfect
                int maxLeft = 0;
                if (i == 0) {
                    maxLeft = B[j - 1];
                } else if (j == 0) {
                    maxLeft = A[i - 1];
                } else {
                    maxLeft = Math.max(A[i - 1], B[j - 1]);
                }
                if ((m + n) % 2 == 1) {
                    return maxLeft;
                }

                int minRight = 0;
                if (i == m) {
                    minRight = B[j];
                } else if (j == n) {
                    minRight = A[i];
                } else {
                    minRight = Math.min(B[j], A[i]);
                }

                return (maxLeft + minRight) / 2.0;
            }
        }
        return 0.0;
    }

    public int singleNumber(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length;) {
            if (i == nums.length - 1) {
                return nums[i];
            }
            if (nums[i] - nums[i+1] != 0) {
                return nums[i];
            }
            i = i + 2;
        }
        return 0;
    }

    public int majorityElement(int[] nums) {

        return 0;
    }

    public static void main(String[] args) {
        MergeListNode mergeListNode = new MergeListNode();
        int[] nums = {4,1,2,1,2};
        System.out.println(mergeListNode.singleNumber(nums));
    }
}
