package com.nj127.dsa.arraylinked;

import java.util.Arrays;

/**
 * 自定义动态数组列表实现类
 * 支持动态扩容、元素增删改查等基本操作
 */
public class MyList {
    // 存储元素的数组
    private int[] array;
    // 当前存储的元素个数
    private int size;
    // 数组的总容量
    private int capacity;
    // 扩容因子，当数组满时按照此倍数扩容
    private static final int extendFactor = 2;

    /**
     * 构造函数，初始化列表
     * 默认容量为10
     */
    public MyList(){
        capacity = 10;
        array = new int[capacity];
        size = 0;
    }

    /**
     * 获取列表当前元素数量
     * @return 当前元素数量
     */
    public int getSize(){
        return size;
    }

    /**
     * 获取列表当前容量
     * @return 当前数组容量
     */
    public int getCapacity(){
        return capacity;
    }

    /**
     * 获取指定索引位置的元素
     * @param index 元素索引
     * @return 指定索引位置的元素值
     * @throws IndexOutOfBoundsException 索引越界异常
     */
    public int get(int index){
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException("索引越界");
        }
        return array[index];
    }

    /**
     * 更新指定索引位置的元素
     * @param index 元素索引
     * @param element 新的元素值
     * @throws IndexOutOfBoundsException 索引越界异常
     */
    public void set(int index, int element){
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException("索引越界");
        }
        array[index] = element;
    }

    /**
     * 在列表末尾添加元素
     * @param element 要添加的元素
     */
    public void add(int element){
        // 如果当前元素数量等于容量，则需要扩容
        if(size == getCapacity()){
            extendCapacity();
        }
        // 在末尾添加元素
        array[size] = element;
        size++;
    }

    /**
     * 在指定索引位置插入元素
     * @param index 插入位置索引
     * @param element 要插入的元素
     * @throws IndexOutOfBoundsException 索引越界异常
     */
    public void add(int index, int element){
        // 检查索引是否合法（允许在size位置插入）
        if(index < 0 || index > size){
            throw new IndexOutOfBoundsException("索引越界");
        }
        // 如果当前元素数量等于容量，则需要扩容
        if(size == getCapacity()){
            extendCapacity();
        }
        // 将index及之后的元素向后移动一位
        for(int i = size; i > index; i--){
            array[i] = array[i-1];
        }
        // 在指定位置插入新元素
        array[index] = element;
        size++;
    }

    /**
     * 删除指定索引位置的元素
     * @param index 要删除元素的索引
     * @return 被删除的元素值
     * @throws IndexOutOfBoundsException 索引越界异常
     */
    public int remove(int index){
        // 检查索引是否合法
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException("索引越界");
        }
        // 保存要删除的元素
        int removedElement = array[index];
        // 将index之后的元素向前移动一位
        for(int i = index; i < size-1; i++){
            array[i] = array[i+1];
        }
        size--;
        return removedElement;
    }

    /**
     * 将列表转换为数组
     * @return 包含列表所有元素的新数组
     */
    public int[] toArray(){
        int currentSize = getSize();  // 避免局部变量遮蔽成员变量
        int[] newArray = new int[currentSize];
        for(int i = 0; i < currentSize; i++){
            newArray[i] = array[i];
        }
        return newArray;
    }

    /**
     * 扩容方法，按照extendFactor倍数扩展数组容量
     */
    private void extendCapacity() {
        capacity *= extendFactor;  // 直接计算新容量
        array = Arrays.copyOf(array, capacity);
    }

    /**
     * 重写toString方法，方便打印列表内容
     * @return 列表元素的字符串表示
     */
    @Override
    public String toString() {
        return Arrays.toString(toArray());
    }

    /**
     * 主函数，用于测试MyList的各种功能
     * @param args 命令行参数
     */
    public static void main(String[] args) {
        MyList list = new MyList();
        System.out.println("初始列表长度为：" + list.getSize());
        System.out.println("初始列表容量为：" + list.getCapacity());
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(8);
        list.add(9);
        list.add(10);
        list.add(11);
        System.out.println("添加元素后的列表长度为：" + list.getSize());
        System.out.println("添加元素后的列表容量为：" + list.getCapacity());
        System.out.println("列表中的元素为：" + list.toString());
        System.out.println("列表中的第3个元素为：" + list.get(2));
        list.set(2, 20);
        System.out.println("更新列表中的第3个元素后的列表为：" + list.toString());
        list.remove(2);
        System.out.println("删除列表中的第3个元素后的列表为：" + list.toString());
        System.out.println("列表的长度为：" + list.getSize());
        System.out.println("列表的容量为：" + list.getCapacity());
        list.add(5, 30);
        System.out.println("在第5个位置插入元素30后的列表为：" + list.toString());
        System.out.println("列表的长度为：" + list.getSize());
        System.out.println("列表的容量为：" + list.getCapacity());
    }
}
