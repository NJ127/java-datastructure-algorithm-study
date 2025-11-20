// 包声明，定义该类所属的包路径
package com.nj127.dsa.arraylinked;

// 导入Java集合框架相关类
import java.util.*;

/**
 * 列表演示类
 * 展示Java中List接口及其实现类ArrayList的基本操作
 */
public class ListDemo {
    /**
     * 主方法，程序执行入口
     * 演示List的各种常用操作
     *
     * @param args 命令行参数
     */
    public static void main(String[] args) {
        System.out.println("=== Java List操作演示 ===\n");

        /* 1. 初始化列表 */
        // 注意数组的元素类型是 int[] 的包装类 Integer[]
        // 创建一个Integer类型的数组，包含初始元素
        Integer[] numbers = new Integer[] { 1, 3, 2, 5, 4 };
        // 使用Arrays.asList()将数组转换为List，然后用ArrayList包装
        List<Integer> list = new ArrayList<>(Arrays.asList(numbers));
        System.out.println("1. 初始列表: " + list);

        /* 2. 访问元素 */
        System.out.println("\n--- 访问元素 ---");
        // 通过索引访问列表中的元素
        if (!list.isEmpty() && list.size() > 0) {
            int val = list.get(0);  // 获取索引为0的元素
            System.out.println("索引0的元素: " + val);
        }

        if (list.size() > 3) {
            System.out.println("索引1的元素: " + list.get(1));
            System.out.println("索引2的元素: " + list.get(2));
            System.out.println("索引3的元素: " + list.get(3));
        }

        /* 3. 更新元素 */
        System.out.println("\n--- 更新元素 ---");
        // 使用set方法更新指定索引位置的元素
        if (!list.isEmpty()) {
            list.set(0, 0);  // 将索引为0的元素更新为 0
            System.out.println("更新索引0元素后的列表: " + list);
        }

        /* 4. 清空列表 */
        System.out.println("\n--- 清空列表 ---");
        // 清除列表中的所有元素
        list.clear();
        System.out.println("清空后的列表: " + list);

        /* 5. 添加元素 */
        System.out.println("\n--- 添加元素 ---");
        // 向列表尾部依次添加元素
        list.add(1);  // 在列表尾部添加元素 1
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        System.out.println("添加元素后的列表: " + list);

        // 在指定索引位置插入元素，原有元素向后移动
        list.add(1, 0);  // 在索引1的位置插入元素0
        System.out.println("在索引1插入元素0后的列表: " + list);

        /* 6. 删除元素 */
        System.out.println("\n--- 删除元素 ---");
        // 通过索引删除元素
        if (!list.isEmpty()) {
            list.remove(0);  // 删除索引为0的元素
            System.out.println("删除索引0元素后的列表: " + list);
        }

        // 通过值删除元素（需要使用包装类避免歧义）
        if (list.contains(3)) {
            list.remove(Integer.valueOf(3));  // 删除值为3的元素
            System.out.println("删除值为3的元素后的列表: " + list);
        }

        /* 7. 遍历列表 */
        System.out.println("\n--- 遍历列表 ---");
        // 使用for循环配合size()和get()方法遍历列表
        System.out.print("通过索引遍历列表: ");
        for (int i = 0; i < list.size(); i++) {
            System.out.printf("%d ", list.get(i));
        }
        System.out.println();  // 换行

        // 使用增强for循环（foreach）直接遍历列表元素
        System.out.print("直接遍历列表元素: ");
        for (Integer num : list) {
            System.out.printf("%d ", num);
        }
        System.out.println();  // 换行

        /* 8. 拼接列表 */
        System.out.println("\n--- 拼接列表 ---");
        // 创建第二个列表
        List<Integer> list2 = new ArrayList<>(Arrays.asList(new Integer[]{6, 7, 8}));
        System.out.println("第二个列表: " + list2);
        // 将list2中的所有元素添加到list中
        list.addAll(list2);
        System.out.println("拼接后的列表: " + list);

        /* 9. 排序列表 */
        System.out.println("\n--- 排序列表 ---");
        // 使用Collections工具类对列表进行排序
        Collections.sort(list);
        System.out.println("排序后的列表: " + list);

        System.out.println("\n=== 演示结束 ===");
    }
}
