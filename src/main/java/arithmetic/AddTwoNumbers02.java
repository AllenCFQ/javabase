package arithmetic;

import java.util.ArrayList;

/**
 * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 *
 * 数据结构：
 *  1. 两个链表：存放现有数据
 *  2. 新增一个链表：存放计算的结果； 涉及链式存储
 *    NodeList head = new LodeList;
 *    NodeList p = head;
 *    p.next = new LodeList();
 *    p = p.next;
 *
 *  算法：
 *  1. 遍历链表
 *      停止条件：两个链表都为空
 *      计算： 取数相加，/10 保留进位，%10 入节点，最后一个节点需要将保留进位入节点
 */
public class AddTwoNumbers02 {

    public static void main(String[] args) {
        ListNode node = new ListNode(9);
        node.next = new ListNode(9);
        node.next.next = new ListNode(9);
        ListNode node2 = new ListNode(9);

        ListNode result =  addTwoNumbers(node,node2);

        while (result !=null) {
            System.out.println("result.val = " + result.val);
            result = result.next;
        }
    }


    public static  ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode();
        ListNode p = head;
        int remain = 0;
        while (l1!=null || l2!=null) {
            int var1 = 0;
            if (l1 != null) {
                var1 = l1.val;
                l1 = l1.next;
            }
            int var2 = 0;
            if (l2!=null) {
                var2 = l2.val;
                l2 = l2.next;
            }

            int temp = (var1+var2+remain) % 10;
            remain = (var1+var2+remain)/10;
            p.next = new ListNode(temp);
            p = p.next;
        }
        if (remain > 0) {
            p.next = new ListNode(remain);
        }
        return head.next; // or head
    }

}
