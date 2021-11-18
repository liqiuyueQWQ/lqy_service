package com.liqiuyue.array;

/**
@ClassName: TwoAdd
@Description: 两数相加
@Author: liqiuyue
@Date: 2021-08-31
 */
public class TwoAdd {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);
        ListNode listNode1 = addTwoNumbers1(l1, l2);
        System.out.println(1);
/*
        // 可 通过debug查看head tail的内存地址变化
        ListNode head = null, tail = null;
        head = tail = new ListNode(7);
        tail.next = new ListNode(0);
        tail = tail.next;
        System.out.println(1);
*/

    }


    public static ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        ListNode head = null, tail = null;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int n1 = l1 != null ? l1.val : 0;
            int n2 = l2 != null ? l2.val : 0;
            int sum = n1 + n2 + carry;
            if (head == null) {
                // head tail 指向同一个内存地址
                head = tail = new ListNode(sum % 10);
            } else {
                // tail = head  tail对应内存地址的值改变对应改变head的值
                tail.next = new ListNode(sum % 10);
                // tail.next 指向 head.next 故tail =tail.next = head.next tail=head最后一个节点的内存地址
                tail = tail.next;
            }
            carry = sum / 10;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (carry > 0) {
            tail.next = new ListNode(carry);
        }
        return head;
    }

    
}
