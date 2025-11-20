// 包声明，定义了该类所在的包路径
package com.nj127.dsa.arraylinked;

// 导入所需的Java工具类库
import java.util.*;                    // 导入java.util包中的所有类，用于Arrays.toString()等方法
import java.util.concurrent.ThreadLocalRandom;  // 导入ThreadLocalRandom类，用于生成线程安全的随机数

/**
 * array类演示了数组的基本操作，包括初始化、访问、插入、删除、扩容和查找等功能
 */
public class array {

    /**
     * 随机访问数组中的元素
     *
     * @param nums 输入的整型数组
     * @return 返回数组中随机位置的元素值
     */
    static int randomAccess(int[] nums) {
        // 使用ThreadLocalRandom生成一个在[0, nums.length)范围内的随机索引
        int randomIndex = ThreadLocalRandom.current().nextInt(0, nums.length);
        // 获取并返回该随机索引处的元素值
        int randomNum = nums[randomIndex];
        return randomNum;
    }

    /**
     * 对数组进行扩容操作
     *
     * @param nums 原始数组
     * @param enlarge 扩容大小
     * @return 返回扩容后的新数组
     */
    static int[] extend(int[] nums, int enlarge) {
        // 创建一个新的数组，其长度为原始数组长度加上扩容量
        int[] res = new int[nums.length + enlarge];
        // 将原数组的所有元素逐个复制到新数组中
        for (int i = 0; i < nums.length; i++) {
            res[i] = nums[i];
        }
        // 返回扩容后的新数组
        return res;
    }

    /**
     * 在数组指定索引位置插入元素
     *
     * @param nums 操作的目标数组
     * @param num 要插入的元素值
     * @param index 插入的位置索引
     */
    static void insert(int[] nums, int num, int index) {
        // 从数组末尾开始向前遍历，将index及之后的所有元素向后移动一位
        for (int i = nums.length - 1; i > index; i--) {
            nums[i] = nums[i - 1];
        }
        // 将要插入的元素放置在指定位置
        nums[index] = num;
    }

    /**
     * 删除数组中指定索引位置的元素
     *
     * @param nums 操作的目标数组
     * @param index 要删除元素的索引位置
     */
    static void remove(int[] nums, int index) {
        // 从index开始，将后面的所有元素向前移动一位，覆盖掉要删除的元素
        for (int i = index; i < nums.length - 1; i++) {
            nums[i] = nums[i + 1];
        }
    }

    /**
     * 遍历并打印数组中的所有元素
     *
     * @param nums 要遍历的数组
     */
    static void traverse(int[] nums) {
        // 使用for循环通过索引依次访问数组中的每个元素并打印
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }

        // 另一种遍历方式（已被注释）：使用增强for循环直接遍历数组元素
        // for (int num : nums) {
        //     System.out.print(num + " ");
        // }
    }

    /**
     * 在数组中查找指定的目标元素
     *
     * @param nums 被搜索的数组
     * @param target 要查找的目标元素
     * @return 如果找到目标元素则返回其索引，否则返回-1
     */
    static int find(int[] nums, int target) {
        // 遍历数组查找目标元素
        for (int i = 0; i < nums.length; i++) {
            // 如果当前元素等于目标元素，则返回当前索引
            if (nums[i] == target)
                return i;
        }
        // 如果未找到目标元素，返回-1表示未找到
        return -1;
    }

    /**
     * 主方法，程序执行入口
     *
     * @param args 命令行参数
     */
    public static void main(String[] args) {
        /* 初始化数组 */
        // 动态初始化一个长度为6的整型数组，默认值都为0
        int[] arr = new int[6];
        System.out.println("动态初始化数组 arr = " + Arrays.toString(arr));

        // 手动初始化一个包含具体数值的数组
        int[] nums = { 1, 2, 3, 4, 5, 6 };
        System.out.println("手动初始化数组 nums = " + Arrays.toString(nums));

        /* 随机访问 */
        // 调用randomAccess方法获取数组中的随机元素
        int randomNum = randomAccess(nums);
        System.out.println("在 nums 中获取随机元素 " + randomNum);

        /* 长度扩展 */
        // 调用extend方法将数组长度增加6个单位
        nums = extend(nums, 6);
        System.out.println("将 nums 的长度扩展 6 ，得到 nums = " + Arrays.toString(nums));

        /* 插入元素 */
        // 在索引3的位置插入元素6
        insert(nums, 6, 3);
        System.out.println("在 nums 的索引 3 处插入元素 6 ，得到 nums = " + Arrays.toString(nums));

        /* 删除元素 */
        // 删除索引2处的元素
        remove(nums, 2);
        System.out.println("删除 nums 的索引 2 处的元素，得到 nums = " + Arrays.toString(nums));

        /* 遍历数组 */
        // 调用traverse方法输出数组所有元素
        System.out.print("遍历数组 nums: ");
        traverse(nums);
        System.out.println(); // 添加换行

        /* 查找元素 */
        // 在数组中查找元素3，并返回其索引
        int index = find(nums, 3);
        System.out.println("在 nums 中查找元素 3，得到索引  " + index);
    }
}
