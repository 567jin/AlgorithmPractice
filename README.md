# 刷题日记

这里记录一些自己刷过的题，主要是按照[代码随想录](https://programmercarl.com/)和《剑指offer》中的题目刷的。

文件命名：_(题目编号)_(题目名称)

## 日行一善，每日一题

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
