# 刷题日记 ✍

这里记录一些自己做过的算法题，题单主要来源于[代码随想录](https://programmercarl.com/)和《剑指offer》。

每个题会写一些关键点和对应的知识点

文件命名规则：\_(题目编号)\_(题目名称)

- [x] 数组
    - [704.二分查找](#704二分查找)
- [x] 字符串
- [x] 链表
    - [206.反转链表](#206反转链表)
    - [83.删除排序链表中的重复元素](#83删除排序链表中的重复元素)
    - [82.删除排序链表中的重复元素II](#82删除排序链表中的重复元素II)
    - [2.两数相加](#2两数相加)
    - [141.环形链表](#141环形链表)
    - [142.环形链表II](#142环形链表II)
    - [19.删除链表的倒数第N个结点](#19删除链表的倒数第N个结点)


- [x] 哈希表
    - [1.两数之和](#1两数之和)

- [x] 栈
- [x] 队列
    - [239.滑动窗口最大值](#239滑动窗口最大值)

- [x] 树
    - [144.二叉树的前序遍历](#144二叉树的前序遍历)
    - [94.二叉树的中序遍历](#94二叉树的中序遍历)
    - [145.二叉树的后序遍历](#145二叉树的后序遍历)
    - [102.二叉树的层序遍历](#102二叉树的层序遍历)
    - [104.二叉树的最大深度](#104二叉树的最大深度)
    - [101.对称二叉树](#101对称二叉树)

- [x] 堆
- [x] 回溯
    - [39.组合总和](#39组合总和)
    - [46.全排列](#46全排列)
    - [47.全排列II](#47全排列II)
    - [7.电话号码的字母组合](#7电话号码的字母组合)
    - [78.子集](#78子集)
    - [90.子集II](#90子集II)
- [x] 动态规划
- [x] 数据结构的设计
- [x] 技巧题
    - [136.只出现一次的数字](#136只出现一次的数字)

## 每日一题 🤢🤮🤬😡🥵🥰

[//]: # (数组)

### [704.二分查找](https://leetcode.cn/problems/binary-search/description/)

三种写法：左闭右开，左开右开，左闭右闭，三种写法对应不同的if判断条件。  
[DichotomousSearch](src/_704_DichotomousSearch.java)

---

[//]: # (链表)

### [206.反转链表](https://leetcode.cn/problems/reverse-linked-list/description/)

三个参数，一个记录cur，一个记录cur.next，一个记录pre。  
[ReverseList](src/_206_ReverseList.java)

### [83.删除排序链表中的重复元素](https://leetcode.cn/problems/remove-duplicates-from-sorted-list/description/)

链表的题目。知识点：虚拟头结点(哨兵节点)处理删除头结点的情况；两种写法

- 递归写法，问题可以分解成多个子问题，递归的思想。终止条件是cur==null或cur.next==null；后面分删除节点和不删除节点，不删除节点就是head.nex=deleteDuplicates(head.next)
  ;删除节点while循环
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

### [1.两数之和](https://leetcode.cn/problems/two-sum/)

哈希表的应用，哈希表的应用关键在于确定key和value，比如这个题目要求返回下标值，就需要记录值的同时记录下标值。  
[TwoSum](src/_1_TwoSum.java)

---

[//]: # (队列)

### [239.滑动窗口最大值](https://leetcode.cn/problems/sliding-window-maximum/description/)

单调队列的应用，关键在于怎么维护单调队列，两点值得注意：移出队列的时机(队列中的值不在窗口内，后来的值比队列最大值要大)，队列中保存数组下标。  
[MaxSlidingWindow](src/_239_MaxSlidingWindow.java)

---

[//]: # (二叉树)

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

本题关键点：要判断是否处理完右子树了，因此需要拿到当前要弹出的节点peek = stack.peek()；要判断是否处理过右子树,需要记录上一次处理过的子节点pre；
左右子树是否处理过的逻辑是，只有当前要弹出节点的右节点等于上一个节点pre或为null时，说明右子树处理过了，可以弹出了；没有处理过的话，先去处理当前要弹出节点的右子树即cur=peek.right。
左子树不用管，因为首先处理的就是左子树，因此只需要判断右子树是否处理过了就好。
[PostorderTraversal](src/_145_PostorderTraversal.java)

### [102.二叉树的层序遍历](https://leetcode.cn/problems/binary-tree-level-order-traversal/description/)

层序遍历的题目很容易看出来。层序遍历适合那些题目中要求对树的每层进行操作，如每层的和，每层的最大值，之字形遍历等。

本体关键点：层序遍历使用队列先进先出。深度遍历使用栈，先进后出。[LevelOrder](src/_102_LevelOrder.java)

### [104.二叉树的最大深度](https://leetcode.cn/problems/maximum-depth-of-binary-tree/description/)

深度优先搜索，每次dfs都是深度加1，因此dfs(root,depth+1)不断地递归，直到root==null即可找到最大深度。
当然了广度优先搜索也可以，但是麻烦了。
[MaxDepth](src/_104_MaxDepth.java)

### [101.对称二叉树](https://leetcode.cn/problems/symmetric-tree/description/)

两种写法：

- 递归，注意比较的条件left.left和right.right比，left.right和right.left比，和其他不相称的条件判断。
- 迭代，两种实现**栈和队列**(栈和队列在这里都一样，因为只要保证相邻节点是要比较的节点即可，无关节点进出顺序)，不太好写，主要是比较是成对比较的，因此队列/栈中添加元素也是成对添加的，不太好想到。
  [IsSymmetric](src/_101_IsSymmetric.java)

---

[//]: # (回溯)

### [39.组合总和](https://leetcode.cn/problems/combination-sum/description/)

回溯的一个大类题型，组合。组合需要一个Index来记录索引位置防止重复元素。[CombinationSum](src/_39_CombinationSum.java)

### [46.全排列](https://leetcode.cn/problems/permutations/description/)

回溯的另一个大类题型，排列。排列是跟元素顺序有关的，也即一个元素用过之后就不能再用了，元素之间交换位置就是两个不同的组合。  
这个全排列关键在于使用一个visited数组来记录曾访问过哪些元素，访问过的元素不可以在访问了。[Permute](src/_46_Permute.java)

### [47.全排列II](https://leetcode.cn/problems/permutations-ii/)

在[46.全排列](#46全排列)的基础上增加了去重操作。

```
if (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1]) {  // 找出重复数字
    continue;
 } 
```

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

组合中的一个题型，求子集但是要去重，相当于[78.子集](#78子集)题目和[47.全排列II](#47全排列II)的组合题，求子集还要去重。
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

---

[//]: # (技巧)

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

