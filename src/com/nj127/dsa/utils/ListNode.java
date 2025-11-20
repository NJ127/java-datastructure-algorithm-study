// 包声明，定义该类所属的包路径
package com.nj127.dsa.utils;

/**
 * 链表节点类
 * 用于表示单向链表中的节点结构
 */
public class ListNode {
    // 节点存储的整型数据值
    public int val;

    // 指向下一个节点的引用（指针）
    public ListNode next;

    /**
     * 构造函数，创建一个带有指定值的链表节点
     *
     * @param x 节点要存储的整型值
     */
    public ListNode(int x) {
        // 将传入的值赋给节点的val属性
        val = x;
        // next指针默认为null，表示暂时不指向任何节点
    }

    /**
     * 静态工具方法，将整型数组转换为链表结构
     *
     * @param arr 输入的整型数组
     * @return 返回构建好的链表头节点
     */
    public static ListNode arrToLinkedList(int[] arr) {
        // 创建虚拟头节点，简化链表操作逻辑
        ListNode dum = new ListNode(0);
        // 使用head指针指向当前操作的节点，初始指向虚拟头节点
        ListNode head = dum;

        // 遍历输入数组中的每个元素
        for (int val : arr) {
            // 为当前元素创建新的链表节点，并连接到当前节点的后面
            head.next = new ListNode(val);
            // 移动head指针到新创建的节点，为下一次连接做准备
            head = head.next;
        }

        // 返回真正的链表头节点（跳过虚拟头节点）
        return dum.next;
    }
}
