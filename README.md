# 刷题日记 ✍

这里记录一些自己做过的算法题，题单主要来源于[代码随想录](https://programmercarl.com/)和《剑指offer》。

每个题会写一些关键点和对应的知识点

文件命名规则：\_(题目编号)\_(题目名称)

## Index

- [x] 数组
  - [704.二分查找](#704二分查找)--双指针, 三种写法推荐左闭右开
  - [15.三数之和](#15三数之和)--三指针, 去重技巧🔞
  - [283.移动零](#283移动零)--双指针(真移动，假移动)

- [x] 字符串

- [x] 链表
  - [206.反转链表](#206反转链表)
  - [83.删除排序链表中的重复元素](#83删除排序链表中的重复元素)
  - [82.删除排序链表中的重复元素II](#82删除排序链表中的重复元素ii)
  - [2.两数相加](#2两数相加)
  - [141.环形链表](#141环形链表)--两种解法(双指针, 哈希表)
  - [142.环形链表II](#142环形链表ii)--两种解法(双指针(利用一个推理来判断入口), 哈希表)
  - [19.删除链表的倒数第N个结点](#19删除链表的倒数第n个结点)--三种解法(双指针, 统计长度, 栈)


- [x] 哈希表
  - [1.两数之和](#1两数之和)--哈希表set
  - [49.字母异位词分组](#49字母异位词分组)--哈希map, key的选择

- [x] 栈
  - [20.有效的括号](#20有效的括号)--栈的经典应用

- [x] 队列
  - [239.滑动窗口最大值](#239滑动窗口最大值)--单调队列

- [x] 树
  - [144.二叉树的前序遍历](#144二叉树的前序遍历)
  - [94.二叉树的中序遍历](#94二叉树的中序遍历)
  - [145.二叉树的后序遍历](#145二叉树的后序遍历)--用处最多
  - [102.二叉树的层序遍历](#102二叉树的层序遍历)
  - [104.二叉树的最大深度](#104二叉树的最大深度)
  - [101.对称二叉树](#101对称二叉树)
  - [226.翻转二叉树](#226翻转二叉树)
  - [105.从前序与中序遍历序列构造二叉树](#105从前序与中序遍历序列构造二叉树)--前序找根，中序分割

- [x] 堆
  - [347.前K个高频元素](#347前k个高频元素)--大顶堆，小顶堆的选择。

- [x] 回溯
  - [39.组合总和](#39组合总和)
  - [46.全排列](#46全排列)
  - [47.全排列II](#47全排列ii)--去重技巧
  - [7.电话号码的字母组合](#7电话号码的字母组合)
  - [78.子集](#78子集)
  - [90.子集II](#90子集ii)
  - [51.N皇后](#51n皇后)🔞

- [x] 动态规划

- [x] 数据结构的设计

- [x] 技巧题
  - [136.只出现一次的数字](#136只出现一次的数字)--异或

## 每日一题 🤢🤮🤬😡🥵🥰

<!--数组-->

### [704.二分查找](https://leetcode.cn/problems/binary-search/description/)

三种写法：左闭右开，左开右开，左闭右闭，三种写法对应不同的if判断条件.
[DichotomousSearch](src/_704_DichotomousSearch.java)

### [15.三数之和](https://leetcode.cn/problems/3sum/description/)🔞

使用哈希表很难，主要难在去重(去重要点是，当前数和后一个数相等(或前一个数)则需要跳过)。这题很巧妙地使用三指针，首先对数组进行排序，然后使用三指针，第一个指针指向第一个元素，第二个指向第二个元素，第三个指向最后一个元素(左闭右闭的形式更方便计算三数和)，
然后固定第一个指针，移动后面两个指针，如果三个数之和大于0，说明三个数之和太大，需要左移第二个指针；
如果三个数之和小于0，说明三个数之和太小，需要右移第三个指针；如果三个数之和等于0，说明找到了三个数之和为0，添加进结果集，然后在num\[i\]的基础上继续找(left++,
right--)。[ThreeSum](src/_15_ThreeSum.java)

### [283.移动零](https://leetcode.cn/problems/move-zeroes/description/)
两种解法，但都建立在双指针基础上：
- 遍历，将所有非零点移动到最前面(直接覆盖)，然后slow的值就是非零点的值，最后在后面补零即可，但有点作弊，这不是真正的”移动“
- 真正的移动，即交换零值和非零值，注意是fast!=0时才交换，要不然就是移动零到最前面了。
[MoveZeroes](src/_283_MoveZeroes.java)

***[⬆ Back to Index](#index)***

---


<!--链表-->

### [206.反转链表](https://leetcode.cn/problems/reverse-linked-list/description/)

三个参数，一个记录cur，一个记录cur.next，一个记录pre.
[ReverseList](src/_206_ReverseList.java)

### [83.删除排序链表中的重复元素](https://leetcode.cn/problems/remove-duplicates-from-sorted-list/description/)

链表的题目。知识点：虚拟头结点(哨兵节点)处理删除头结点的情况；两种写法

- 递归写法，问题可以分解成多个子问题，递归的思想。终止条件是cur==null或cur.next==null;后面分删除节点和不删除节点，不删除节点就是head.nex=deleteDuplicates(head.next)
  ;删除节点使用while循环
- 遍历，遍历找到重复节点逐个删除即可，因为需要保留重复节点中的一个，因此不需要pre记录上一个未被删除节点。
  [DeleteDuplicates](src/_83_DeleteDuplicates.java)

### [82.删除排序链表中的重复元素II](https://leetcode.cn/problems/remove-duplicates-from-sorted-list-ii/description/)

链表的题目。知识点：虚拟头结点(哨兵节点)处理删除头结点的情况；pre记录上一个不重复的节点。两种解法：

- 递归，不太好写。终止条件是cur==null或cur.next==null；后面分两种情况，有重复元素不需要跳过元素，有重复元素需要跳过所有元素(因此是while循环)。
- 迭代，逐个遍历链表，注意到链表是排序的，因此重复元素都是相邻的。找到全部重复元素(值等于cur.val的节点)逐个跳过即可，用一个pre记录上一个不重复的元素。
  [DeleteDuplicates](src/_82_DeleteDuplicates.java)

### [2.两数相加](https://leetcode.cn/problems/add-two-numbers/)

两数相加但是链表，加法运算是从低位到高位开始的，并且会涉及到进位，因此不仅需要计算两个节点值的加add还要计算进位carry。
代码里有很多判空的三元表达式，并且最后的进位carry也要处理。
[AddTwoNumbers](src/_2_AddTwoNumbers.java)

### [141.环形链表](https://leetcode.cn/problems/linked-list-cycle/)

双指针，快慢指针的应用,链表中如果有环，则两个指针都会进入到环中，并且由于一个快一个慢，终将相遇；无环将永不相遇。

哈希表的解法，创建一个哈希表，遍历链表，不断地将节点添加进哈希表中，如果有相等的说明有环，反之无环，但是会占用额外的存储空间。
[HasCycle](src/_141_HasCycle.java)

### [142.环形链表II](https://leetcode.cn/problems/linked-list-cycle-ii/description/)

与[141.环形链表](#141环形链表)相似，也是两种解法：

- 哈希表，用一个哈希表记录一下，重复的节点就是环的入口点。哈希表中第一个相同的节点，就是环的入口节点。
- 快慢指针法，但是要用到一个推理，当判断有环后，slow回到原点，同时与fast前进一步终会相遇，且相遇点就是环的入口点。

### [19.删除链表的倒数第N个结点](https://leetcode.cn/problems/remove-nth-node-from-end-of-list/description/)

这个题的关键在于怎样定位到待删除节点，或者说得到链表的长度(然后遍历即可找到待删除节点),小细节就是注意头结点的删除，因此要用到虚拟头节点。
三种解法：

- 双指针定位待删除节点
- 链表长度，定位到长度，就可以定位到待删除节点了。
- 栈，倒数的方式，最适合栈这种先进后出的数据结构了，第N个弹栈的就是待删除节点，N+1个弹栈的就是其前驱结点。
  [RemoveNthFromEnd](src/_19_RemoveNthFromEnd.java)

***[⬆ Back to Index](#index)***


---

<!--哈希表-->

### [1.两数之和](https://leetcode.cn/problems/two-sum/)

哈希表的应用，哈希表的应用关键在于确定key和value，比如这个题目要求返回下标值，就需要记录值的同时记录下标值。  
[TwoSum](src/_1_TwoSum.java)

### [49.字母异位词分组](https://leetcode.cn/problems/group-anagrams/description/)

异位词的特点：由相同字符组成，但是顺序不同。因此其特点是互为异位词的字符顺序经过排序后的字符相同，或字符的统计个数是相同的。因此可以得到两种解法(都是基于哈希的只是键的选择不同)：
- 排序后的字符当做key，

```
   Arrays.sort(chars);
   List<String> list = map.getOrDefault(String.valueOf(chars), new ArrayList<String>());
```

- 统计字符个数的数组当做key，此解法需要一个数组来统计字符出现的次数，并转成字符串之后当做key，其实最直接的是把数组当做键，但是Java不支持这样做(可以让数组的hashCode当做key)
  [LeetCode 字母异位词哈希表中 Key 的选择](https://leetcode.cn/problems/group-anagrams/solutions/2604788/zi-mu-yi-wei-ci-ha-xi-biao-zhong-keyde-x-me1t/)

[GroupAnagrams](src/_49_GroupAnagrams.java)

***[⬆ Back to Index](#index)***


---
<!--栈-->
### [20.有效的括号](https://leetcode.cn/problems/valid-parentheses/description/)
本题是栈的经典用法，括号的匹配，看着简单，实际上做的时候却很有技巧，比如压栈时，判断是左括号，是把右括号压进去，而不是直接把左括号压进去，这样在弹栈判断时更容易；
还有就是两个判断语句，")))("这种情况，是stack.isEmpty()即栈中元素为零，但是要弹栈比较因此直接返回false，还有就是栈中元素有剩余，即括号没有完全配对上，需要判断栈是否为空。
[IsValid](src/_20_IsValid.java)




***[⬆ Back to Index](#index)***

---

<!--队列-->

### [239.滑动窗口最大值](https://leetcode.cn/problems/sliding-window-maximum/description/)

单调队列的应用，关键在于怎么维护单调队列，两点值得注意：移出队列的时机(队列中的值不在窗口内，后来的值比队列最大值要大)，队列中保存数组下标。  
[MaxSlidingWindow](src/_239_MaxSlidingWindow.java)



***[⬆ Back to Index](#index)***


---

<!--二叉树-->

### [144.二叉树的前序遍历](https://leetcode.cn/problems/binary-tree-preorder-traversal/description/)

二叉树的前序遍历，实际解题用得不多(后序遍历最多，因为其需要先处理完所有左右子树)。
两种写法：

- 递归的深度优先搜索
- 迭代的深度优先搜索

层序遍历迭代使用队列。深度遍历使用栈。[PreorderTraversal](src/_144_PreorderTraversal.java)

### [94.二叉树的中序遍历](https://leetcode.cn/problems/binary-tree-inorder-traversal/description/)

[如前所述](#144二叉树的前序遍历).[InorderTraversal](src/_94_InorderTraversal.java)

### [145.二叉树的后序遍历](https://leetcode.cn/problems/binary-tree-postorder-traversal/description/)

二叉树的**后序遍历**，实际解题用的非常多，很多题都可以转化成二叉树的后序遍历。因为后序遍历的优点是先处理完两边的左右子树再去处理本节点。

本题关键点：要判断是否处理完右子树了，因此需要拿到当前要弹出的节点peek =
stack.peek()；要判断是否处理过右子树,需要记录上一次处理过的子节点pre；
左右子树是否处理过的逻辑是，只有当前要弹出节点的右节点等于上一个节点pre或为null时，说明右子树处理过了，可以弹出了；没有处理过的话，先去处理当前要弹出节点的右子树即cur=peek.right。
左子树不用管，因为首先处理的就是左子树，因此只需要判断右子树是否处理过了就好。
[PostorderTraversal](src/_145_PostorderTraversal.java)

### [102.二叉树的层序遍历](https://leetcode.cn/problems/binary-tree-level-order-traversal/description/)

层序遍历的题目很容易看出来。层序遍历适合那些题目中要求对树的每层进行操作，如每层的和，每层的最大值，之字形遍历等。

本体关键点：层序遍历使用队列先进先出。深度遍历使用栈，先进后出。[LevelOrder](src/_102_LevelOrder.java)

### [104.二叉树的最大深度](https://leetcode.cn/problems/maximum-depth-of-binary-tree/description/)

深度优先搜索，每次dfs都是深度加1，因此dfs(root,
depth+1)不断地递归，直到root==null即可找到最大深度。
当然了广度优先搜索也可以，但是麻烦了。 [MaxDepth](src/_104_MaxDepth.java)

### [101.对称二叉树](https://leetcode.cn/problems/symmetric-tree/description/)

两种写法：

- 递归，注意比较的条件left.left和right.right比，left.right和right.left比，和其他不相称的条件判断。
- 迭代，两种实现**栈和队列**(栈和队列在这里都一样，因为只要保证相邻节点是要比较的节点即可，无关节点进出顺序)，不太好写，主要是比较是成对比较的，因此队列/栈中添加元素也是成对添加的，不太好想到。
  [IsSymmetric](src/_101_IsSymmetric.java)

### [226.翻转二叉树](https://leetcode.cn/problems/invert-binary-tree/description/)
两种写法：
- 递归，主要在于确定结束条件和递归条件。本题都比较好写
- 迭代，无论是使用队列还是栈都可以，因为只需要能够遍历到每个节点并再下次循环中取出即可。推荐使用队列
[InvertTree](src/_226_InvertTree.java)

### [105.从前序与中序遍历序列构造二叉树](https://leetcode.cn/problems/construct-binary-tree-from-preorder-and-inorder-traversal/description/)
难在分析，而不是递归，递归的写法很自然，但是如何递归难写，需要分析前序中序遍历的特点，并且只能树的节点值互不相同才可以。
难点在于分析出前序遍历确定根节点，根据根节点在中序遍历中的位置从中序遍历中分割出左右子树，再递归(即重复这个过程即可)。
两种写法：
- 借助Arrays.copyOfRange()来分割左右子树，因为需要复制数组，效率不太高
- 借助数组的索引下标来界定范围，优点是不用复制数组了，缺点是难写(**代码还未解决**)。
[BuildTree](src/_105_BuildTree.java)

***[⬆ Back to Index](#index)***

---

### [347.前K个高频元素](https://leetcode.cn/problems/top-k-frequent-elements/description/)
使用最小堆来找前K个最大元素,反之使用最大堆找前K个最小元素.本题是找高频元素，因此需要先使用一个map统计各元素出现的次数。
Java中没有专门堆的实现，**优先级队列就相当于堆**，在创建优先级队列时，通过传入一个比较函数(lambda表达式, Comparator, Comparable接口)，可以实现堆元素的比较。

Comparator, Comparable接口的区别:
- 如果一个类实现了 Comparable 接口，表示该类具有自然排序的能力，并且排序的规则已经定义在类的 compare 方法中。
- 如果你需要实现一个独立的比较器，或者想要提供多种不同的比较方式，可以使用 Comparator 接口 实现其中的compareTo方法

在堆中元素转数组中，可以直接遍历的方式，也可以选择forEach函数配合Lambda表达式实现元素的转换。

但要注意：
> 在 Java 中，Lambda 表达式中引用的外部局部变量必须是 final 或 effectively final（一旦赋值后不再修改）。  
直接使用基本数据类型的 int 变量在 Lambda 表达式中是不允许的，因为该变量无法被修改，而 Lambda 表达式可能会尝试修改该变量的值，这违反了 effectively final 的规则

因此使用一个数组来包装一下Index(引用类型是可变的符合Lambda要求)，或者使用原子类AtomicInteger
```
使用数组包装一下index：
final int[] index = {0};
minHeap.forEach(e-> res[index[0]++] = e.getKey()); 

或使用原子类：
AtomicInteger index = new AtomicInteger(0);
minHeap.forEach(e -> res[index.getAndIncrement()] = e.getKey());
```

[TopKFrequent](src/_347_TopKFrequent.java)




***[⬆ Back to Index](#index)***

---

<!--回溯-->

### [39.组合总和](https://leetcode.cn/problems/combination-sum/description/)

回溯的一个大类题型，组合。组合需要一个Index来记录索引位置防止重复元素。[CombinationSum](src/_39_CombinationSum.java)

### [46.全排列](https://leetcode.cn/problems/permutations/description/)

回溯的另一个大类题型，排列。排列是跟元素顺序有关的，也即一个元素用过之后就不能再用了，元素之间交换位置就是两个不同的组合。

这个题关键在于使用一个visited数组来记录曾访问过哪些元素，访问过的元素不可以在访问了。[Permute](src/_46_Permute.java)

### [47.全排列II](https://leetcode.cn/problems/permutations-ii/)

在[46.全排列](#46全排列)的基础上增加了去重操作。
这里出现重复的原因是数组中两个重复元素比如 1, 1,...
xx.标记为1a和1b，出现重复的原因就是1a,1b
和1b,1a的出现，因为排列是顺序敏感的，1a和1b交换位置就是两个不同的排列。
因此去重的关键就是限制1a和1b的访问顺序。[LeetCode题解](https://leetcode.cn/problems/permutations-ii/solutions/2601182/fang-wen-shun-xu-min-gan-de-quan-pai-lie-6zga/)

visited\[i-1\]与!visited\[i-1\]的区别：

- visited\[i - 1\] 只取1b 1a只有当visit nums\[i\]之后我们才去visit
  nums\[i-1\] 即visited\[i - 1\]访问过(因为要先访问后者1b) 直接continue
- !visited\[i - 1\] 这个只取1a 1b只有当visit nums\[i-1\]之后我们才去visit
  nums\[i\] 即visited\[i - 1\]没被访问过(因为要先访问前者) 直接continue

```
if (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1]) {  // 找出重复数字
    continue;
 } 
```

[PermuteUnique](src/_47_PermuteUnique.java)

### [7.电话号码的字母组合](https://leetcode.cn/problems/letter-combinations-of-a-phone-number/description/)

排列的题型。这个题关键在于判断出for循环的终止条件是str的长度，而不是digits的长度。  
digits的长度即是目标字符串长度，str的长度才是每次回溯选择的个数。[LetterCombinations](src/_17_LetterCombinations.java)

### [78.子集](https://leetcode.cn/problems/subsets/description/)

组合的问题。求子集三种解法：前两种解法区别只是path添加进结果集的时机不同，一个后添加，一个先添加。

- 回溯，先递归到最深度，在回溯过程中添加值；后添加
- 回溯，可以先添加元素到结果集中，直至遍历完整个树；先添加
- 也可以选择动态规划的思想(逐个添加元素)，其实就是取子集的过程，逐个添加元素形成子集；

**难点**在于递归的终止条件和结果集的添加很难对应，之前的对应关系是path.size==length即可，难判断path添加进结果集的时机。
组合的问题，取过的元素不能再取，因此需要一个Index来标识，在遍历过程中收集所有节点即是子集，因此不能剪枝(需要完全遍历)。
[Subsets](src/_78_Subsets.java)

### [90.子集II](https://leetcode.cn/problems/subsets-ii/description/)

组合中的一个题型，求子集但是要去重，相当于[78.子集](#78子集)题目和[47.全排列II](#47全排列ii)的组合题，求子集还要去重。
去重核心思想就是先把数组排列一下，跳过重复元素。[SubsetsWithDup](src/_90_SubsetsWithDup.java)

```
不使用visited数组 判断跳过 需要从Index开始
if (i > index && nums[i] == nums[i - 1]) {
    continue;
  };
或: 使用visited数组判断重复元素跳过
if (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1]) {  // 找出重复数字
    continue;
 }
```

### [51.N皇后](https://leetcode.cn/problems/n-queens/description/)🔞

很难，但主要还是用回溯，关键在于判断落棋的条件。棋盘的宽度就是for循环的长度，递归的深度就是棋盘的高度
[SolveNQueens](src/_51_SolveNQueens.java)


***[⬆ Back to Index](#index)***

----

<!--技巧-->

### [136.只出现一次的数字](https://leetcode.cn/problems/single-number/)

利用异或的技巧，注意题目中，其他数均出现两次，找单值。利用异或的推理。

- 0 ^ 0 = 0;
- 1 ^ 0 = 1;
- 0 ^ 1 = 1;
- 1 ^ 1 = 0;
- 0 ^ a = a; 任何数异或0 都等于其本身
- a ^ a = 0; 自己异或自己等于0
- 综合上面两个可以推出 a^b^a = b; 即三个数异或其中两个数相等则结果等于另一个数，即单值。
  [SingleNumber](src/_136_SingleNumber.java)



***[⬆ Back to Index](#index)***

