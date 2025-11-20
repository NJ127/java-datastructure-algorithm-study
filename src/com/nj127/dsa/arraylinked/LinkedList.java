// 包声明，定义该类所属的包路径
package com.nj127.dsa.arraylinked;

// 导入链表节点类
import com.nj127.dsa.utils.ListNode;

/**
 * 链表操作演示类
 * 提供链表的基本操作：插入、删除、访问、查找等
 */
// 类名应使用驼峰命名法
public class LinkedList {
    // 方法和变量名已经符合规范


    /**
     * 在链表的指定节点之后插入新节点
     *
     * @param n0 指定的节点，在其后插入新节点
     * @param newNode  要插入的新节点
     */
    static void insert(ListNode n0, ListNode newNode) {
        if (n0 == null) return;
        // 保存n0的下一个节点引用
        ListNode n1 = n0.next;
        // 将n0的next指向新节点newNode
        n0.next = newNode;
        // 将新节点newNode的next指向原来的下一个节点n1，完成插入操作
        newNode.next = n1;
    }

    /**
     * 删除链表中指定节点之后的第一个节点
     *
     * @param n0 指定节点，删除其后的第一个节点
     */
    static void remove(ListNode n0) {
        if (n0 == null || n0.next == null) return;
        // 获取要删除的节点（n0的下一个节点）
        ListNode n1 = n0.next;
        // 将n0的next指向要删除节点的下一个节点，跳过要删除的节点
        n0.next = n1.next;
        // 将被删除节点的next置为null，断开其与链表的连接（便于垃圾回收）
        n1.next = null;
    }

    /**
     * 访问链表中指定索引位置的节点
     *
     * @param head  链表的头节点
     * @param index 要访问的节点索引（从0开始）
     * @return 返回索引位置的节点，如果索引超出范围则返回null
     */
    static ListNode access(ListNode head, int index) {
        if (index < 0) return null;
        // 从头节点开始遍历
        ListNode cur = head;
        // 循环index次，每次向后移动一个节点
        for (int i = 0; i < index; i++) {
            if (cur == null) return null;
            // 移动到下一个节点
            cur = cur.next;
        }
        // 返回到达的节点
        return cur;
    }

    /**
     * 在链表中查找具有指定值的第一个节点
     *
     * @param head   链表的头节点
     * @param target 要查找的目标值
     * @return 返回第一个值为target的节点，如果未找到则返回null
     */
    static ListNode find(ListNode head, int target) {
        // 从头节点开始遍历
        ListNode cur = head;
        // 当当前节点不为null且值不等于目标值时继续遍历
        while (cur != null && cur.val != target) {
            // 移动到下一个节点
            cur = cur.next;
        }
        // 返回找到的节点（可能是目标节点，也可能是null）
        return cur;
    }

    /**
     * 打印链表的所有节点值
     *
     * @param head 链表的头节点
     */
    static void printLinkedList(ListNode head) {
        // 从头节点开始遍历
        while (head != null) {
            // 打印当前节点的值和箭头符号
            System.out.print(head.val + " -> ");
            // 移动到下一个节点
            head = head.next;
        }
        // 打印换行符，结束本次打印
        System.out.println();
    }

    /**
     * 主方法，程序执行入口
     * 演示链表的各种操作
     *
     * @param args 命令行参数
     */
    public static void main(String[] args) {
        /* 初始化链表 */
        // 初始化各个节点
        ListNode n0 = new ListNode(1);
        ListNode n1 = new ListNode(3);
        ListNode n2 = new ListNode(4);
        ListNode n3 = new ListNode(5);
        ListNode n4 = new ListNode(6);
        // 构建节点之间的引用
        n0.next = n1;
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;

        System.out.println("初始链表:");
        printLinkedList(n0);

        /* 插入节点 */
        insert(n1, new ListNode(2));
        System.out.println("在节点3后插入节点2后:");
        printLinkedList(n0);

        /* 删除节点 */
        remove(n0);
        System.out.println("删除节点1后的第一个节点后:");
        printLinkedList(n0);

        /* 访问节点 */
        ListNode accessedNode = access(n0, 2);
        if (accessedNode != null) {
            System.out.println("访问索引为2的节点值: " + accessedNode.val);
        } else {
            System.out.println("索引越界或节点不存在");
        }
        System.out.print("当前链表: ");
        printLinkedList(n0);

        /* 查找节点 */
        ListNode foundNode = find(n0, 4);
        if (foundNode != null) {
            System.out.println("找到值为4的节点");
        } else {
            System.out.println("未找到值为4的节点");
        }
    }
}
