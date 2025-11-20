# Java数据结构核心知识点总结

## 1. 数组（Array）

### 1.1 数组基本概念
- **定义**：数组是一种线性数据结构，用于存储相同类型的元素，通过索引访问
- **特点**：固定大小、连续内存空间、随机访问效率高
- **时间复杂度**：
    - 随机访问：O(1)
    - 插入/删除：O(n)

### 1.2 Java数组操作

#### 初始化
```java
// 方式1：指定大小初始化（默认值初始化）
int[] arr = new int[5]; // [0, 0, 0, 0, 0]

// 方式2：直接赋值初始化
int[] nums = {1, 3, 2, 5, 4};
```

#### 随机访问
```java
// 使用ThreadLocalRandom生成随机索引
int randomIndex = ThreadLocalRandom.current().nextInt(0, nums.length);
int randomNum = nums[randomIndex];
```

#### 扩展数组
```java
int[] res = new int[nums.length + enlarge];
for (int i = 0; i < nums.length; i++) {
    res[i] = nums[i];
}
```

#### 插入元素
```java
// 在索引index处插入元素num
for (int i = nums.length - 1; i > index; i--) {
    nums[i] = nums[i - 1];
}
nums[index] = num;
```

#### 删除元素
```java
// 删除索引index处的元素
for (int i = index; i < nums.length - 1; i++) {
    nums[i] = nums[i + 1];
}
```

#### 遍历方式
```java
// 方式1：通过索引遍历
for (int i = 0; i < nums.length; i++) {
    // 操作nums[i]
}

// 方式2：for-each遍历
for (int num : nums) {
    // 操作num
}
```

#### 查找元素
```java
for (int i = 0; i < nums.length; i++) {
    if (nums[i] == target)
        return i;
}
return -1; // 未找到返回-1
```

## 2. 链表（Linked List）

### 2.1 链表基本概念
- **定义**：链表是一种线性数据结构，通过指针连接节点，节点包含数据和指向下一节点的引用
- **特点**：非连续内存、动态大小、插入删除效率高
- **时间复杂度**：
    - 随机访问：O(n)
    - 插入/删除（已知位置）：O(1)

### 2.2 链表操作

#### 链表节点（ListNode）
- 包含两个属性：数据（val）和下一节点引用（next）

#### 初始化链表
```java
// 初始化各个节点
ListNode n0 = new ListNode(1);
ListNode n1 = new ListNode(3);
ListNode n2 = new ListNode(2);

// 构建节点之间的引用
n0.next = n1;
n1.next = n2;
n2.next = null; // 尾节点指向null
```

#### 插入节点
```java
// 在节点n0之后插入节点P
ListNode n1 = n0.next;
P.next = n1;
n0.next = P;
```

#### 删除节点
```java
// 删除节点n0之后的首个节点
if (n0.next == null) return;
ListNode P = n0.next;
ListNode n1 = P.next;
n0.next = n1;
```

#### 访问节点
```java
// 访问链表中索引为index的节点
for (int i = 0; i < index; i++) {
    if (head == null) return null;
    head = head.next;
}
return head;
```

#### 查找节点
```java
// 查找值为target的首个节点
int index = 0;
while (head != null) {
    if (head.val == target) return index;
    head = head.next;
    index++;
}
return -1;
```

## 3. Java集合框架 - List接口

### 3.1 List接口概述
- **定义**：List是Java集合框架中的接口，代表有序的元素集合
- **主要实现类**：ArrayList（基于动态数组）、LinkedList（基于双向链表）
- **特点**：允许重复元素、支持索引访问、保持插入顺序

### 3.2 List常用操作

#### 初始化List
```java
// 方式1：使用Arrays.asList()
Integer[] numbers = new Integer[] {1, 3, 2, 5, 4};
List<Integer> nums = new ArrayList<>(Arrays.asList(numbers));

// 方式2：使用add()逐个添加
List<Integer> nums = new ArrayList<>();
nums.add(1);
nums.add(3);
```

#### 访问元素
```java
int num = nums.get(1); // 访问索引1的元素
```

#### 更新元素
```java
nums.set(1, 0); // 将索引1的元素更新为0
```

#### 清空列表
```java
nums.clear(); // 清空所有元素
```

#### 添加元素
```java
nums.add(1); // 尾部添加
nums.add(3, 6); // 在索引3处插入
```

#### 删除元素
```java
nums.remove(3); // 删除索引3的元素
```

#### 遍历列表
```java
// 方式1：索引遍历
for (int i = 0; i < nums.size(); i++) {
    count += nums.get(i);
}

// 方式2：for-each遍历
for (int x : nums) {
    count += x;
}
```

#### 拼接列表
```java
List<Integer> nums1 = new ArrayList<>();
nums.addAll(nums1); // 将nums1拼接到nums后
```

#### 排序
```java
Collections.sort(nums); // 对列表进行排序
```

## 4. 自定义列表实现

### 4.1 MyList类设计
- **核心属性**：
    - `arr[]`：底层数组存储元素
    - `capacity`：列表容量
    - `size`：当前元素数量
    - `extendRatio`：扩容倍数

### 4.2 自定义列表关键实现

#### 构造方法
```java
public MyList() {
    arr = new int[capacity];
}
```

#### 访问与修改
```java
public int get(int index) {
    if (index < 0 || index >= size) throw new IndexOutOfBoundsException("索引越界");
    return arr[index];
}

public void set(int index, int num) {
    if (index < 0 || index >= size) throw new IndexOutOfBoundsException("索引越界");
    arr[index] = num;
}
```

#### 添加元素（含自动扩容）
```java
public void add(int num) {
    if (size == capacity()) extendCapacity(); // 检查扩容
    arr[size] = num;
    size++;
}

public void insert(int index, int num) {
    if (index < 0 || index >= size) throw new IndexOutOfBoundsException("索引越界");
    if (size == capacity()) extendCapacity();
    // 元素后移
    for (int j = size - 1; j >= index; j--) {
        arr[j + 1] = arr[j];
    }
    arr[index] = num;
    size++;
}
```

#### 删除元素
```java
public int remove(int index) {
    if (index < 0 || index >= size) throw new IndexOutOfBoundsException("索引越界");
    int num = arr[index];
    // 元素前移
    for (int j = index; j < size - 1; j++) {
        arr[j] = arr[j + 1];
    }
    size--;
    return num;
}
```

#### 扩容机制
```java
public void extendCapacity() {
    arr = Arrays.copyOf(arr, capacity() * extendRatio);
    capacity = arr.length;
}
```

## 5. 数组与链表对比

| 操作 | 数组（Array） | 链表（Linked List） |
|------|--------------|--------------------|
| 内存结构 | 连续内存空间 | 非连续内存空间 |
| 随机访问 | O(1) | O(n) |
| 头部插入/删除 | O(n) | O(1) |
| 中间插入/删除 | O(n) | O(1)（已知位置） |
| 尾部插入/删除 | O(1)（固定大小）/O(n)（动态扩展） | O(1) |
| 空间效率 | 浪费（预分配） | 额外指针开销 |
| 适用场景 | 频繁随机访问，元素数量固定 | 频繁插入删除，元素数量动态变化 |

## 6. 核心实现要点

### 6.1 数组操作关键
- **索引越界检查**：所有涉及索引的操作都需要进行边界检查
- **元素移动**：插入删除时需要正确移动元素位置
- **扩容机制**：动态数组需要在容量不足时进行扩容

### 6.2 链表操作关键
- **指针管理**：正确处理节点之间的引用关系
- **空指针检查**：操作前检查节点是否为null
- **边界情况**：处理链表为空、只有一个节点等特殊情况

### 6.3 自定义列表设计原则
- **封装性**：将底层实现细节隐藏，提供简洁API
- **安全性**：严格的边界检查和异常处理
- **性能优化**：合理的扩容策略，避免频繁扩容

## 7. 代码优化建议

### 7.1 数组操作优化
- 使用`System.arraycopy()`或`Arrays.copyOf()`代替手动复制数组
- 对于已知大小的数组，预先分配足够空间避免动态扩容
- 使用增强型for循环（for-each）简化遍历代码

### 7.2 链表操作优化
- 可以实现双向链表提高反向遍历效率
- 维护头节点和尾节点引用，优化头尾操作
- 实现哨兵节点简化边界条件处理

### 7.3 自定义列表优化
- 考虑实现迭代器模式支持for-each循环
- 添加更多便捷方法如contains()、indexOf()等
- 考虑线程安全性（可加锁或使用并发集合）

---

**总结**：本笔记总结了Java中数组、链表和列表的核心概念、实现原理及常用操作。理解这些基础数据结构对于编写高效、健壮的Java程序至关重要，也是进一步学习高级数据结构的基础。