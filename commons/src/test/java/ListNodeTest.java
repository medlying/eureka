import com.simao.common.ListNode;
import com.simao.common.MergeListNode;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author bosong
 * @date 2019-07-02
 */

public class ListNodeTest {

    @Test
    public void should_success_merge_2_list_node() {
        MergeListNode mergeListNode = new MergeListNode();
        ListNode listNode = new ListNode(1);
        ListNode listNode1 = new ListNode(2);
        ListNode listNode2 = new ListNode(4);
        listNode.next = listNode1;
        listNode1.next = listNode2;

        ListNode l2 = new ListNode(1);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        l2.next = listNode3;
        listNode3.next = listNode4;

        ListNode listNode5 = mergeListNode.merge2List(listNode, l2);
        assertEquals(listNode5.val, 1);
    }

    @Test
    public void should_success_reverse_list_node_iteratively() {
        MergeListNode mergeListNode = new MergeListNode();
        ListNode listNode = new ListNode(1);
        ListNode listNode1 = new ListNode(2);
        ListNode listNode2 = new ListNode(3);
        ListNode listNode3 = new ListNode(4);
        ListNode listNode4 = new ListNode(5);
        listNode.next = listNode1;
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        long start = System.currentTimeMillis();
        ListNode reverse = mergeListNode.reverse(listNode);
        System.out.println(System.currentTimeMillis() - start);
        assertEquals(reverse.val, 5);
    }

    @Test
    public void should_success_reverse_list_node_recursively() {
        MergeListNode mergeListNode = new MergeListNode();
        ListNode listNode = new ListNode(1);
        ListNode listNode1 = new ListNode(2);
        ListNode listNode2 = new ListNode(3);
        ListNode listNode3 = new ListNode(4);
        ListNode listNode4 = new ListNode(5);
        listNode.next = listNode1;
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        long start = System.currentTimeMillis();
        ListNode reverse = mergeListNode.reverseList(listNode);
        System.out.println(System.currentTimeMillis() - start);
        assertEquals(reverse.val, 5);
    }
}
