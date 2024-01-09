# 刷题日记 ✍

这里记录一些自己做过的算法题，题单主要来源于[代码随想录](https://programmercarl.com/)和《剑指offer》。

每个题会写一些关键点和对应的知识点

文件命名规则：\_(题目编号)\_(题目名称)

- [x] 数组
    - [704.二分查找](https://leetcode.cn/problems/binary-search/description/)
- [x] 字符串
- [x] 链表
    - [206.反转链表](https://leetcode.cn/problems/reverse-linked-list/description/)
- [x] 哈希表
    - [1.两数之和](https://leetcode.cn/problems/two-sum/)
- [x] 栈
- [x] 队列
    - [239.滑动窗口最大值](https://leetcode.cn/problems/sliding-window-maximum/description/)
- [x] 树
- [x] 堆
- [x] 回溯
    - [39.组合总和](https://leetcode.cn/problems/combination-sum/description/)
    - [46.全排列](https://leetcode.cn/problems/permutations/description/)
    - [7.电话号码的字母组合](https://leetcode.cn/problems/letter-combinations-of-a-phone-number/description/)
    - [78.子集](https://leetcode.cn/problems/subsets/description/)
- [x] 动态规划
- [x] 数据结构的设计

## 每日一题 😡😡😡

[1.两数之和](https://leetcode.cn/problems/two-sum/)

哈希表的应用，哈希表的应用关键在于确定key和value，比如这个题目要求返回下标值，就需要记录值的同时记录下标值。
[TwoSum](src/_1_TwoSum.java)
 
---

[239.滑动窗口最大值](https://leetcode.cn/problems/sliding-window-maximum/description/)

单调队列的应用，关键在于怎么维护单调队列，两点值得注意：移出队列的时机(队列中的值不在窗口内，后来的值比队列最大值要大)，队列中保存数组下标。
[MaxSlidingWindow](src/_239_MaxSlidingWindow.java)

---

[704.二分查找](https://leetcode.cn/problems/binary-search/description/)

三种写法：左闭右开，左开右开，左闭右闭，三种写法对应不同的if判断条件。
[DichotomousSearch](src/_704_DichotomousSearch.java)

---

[206.反转链表](https://leetcode.cn/problems/reverse-linked-list/description/)

三个参数，一个记录cur，一个记录cur.next，一个记录pre。
[ReverseList](src/_206_ReverseList.java)

---

[39.组合总和](https://leetcode.cn/problems/combination-sum/description/)

回溯的一个大类题型，组合。组合需要一个Index来记录索引位置防止重复元素。[CombinationSum](src/_39_CombinationSum.java)


---
[46.全排列](https://leetcode.cn/problems/permutations/description/)

回溯的另一个大类题型，排列。排列是跟元素顺序有关的，也即一个元素用过之后就不能再用了，元素之间交换位置就是两个不同的组合。
这个全排列关键在于使用一个visited数组来记录曾访问过哪些元素，访问过的元素不可以在访问了。[Permute](src/_46_Permute.java)

---

[7.电话号码的字母组合](https://leetcode.cn/problems/letter-combinations-of-a-phone-number/description/)

排列的题型。这个题关键在于判断出for循环的终止条件是str的长度，而不是digits的长度。
digits的长度即是目标字符串长度，str的长度才是每次回溯选择的个数。[LetterCombinations](src/_17_LetterCombinations.java)

---
[78.子集](https://leetcode.cn/problems/subsets/description/)

组合的问题。可以选择回溯的方法(先递归到最深度，在回溯过程中添加值)；也可以选择动态规划的思想(逐个添加元素)
[Subsets](src/_78_Subsets.java)


