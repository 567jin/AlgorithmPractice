<p align="center">
    <img src=https://s2.loli.net/2024/01/17/aP5tGLcBYpSlDKN.png />
</p>
<h1 align="center" style="font-size: 36px; text-align: center; color: #8f4794">题目数量: 82</h1>
<div align="center">
<a target="_blank" href="https://www.oracle.com/technetwork/java/javase/downloads/index.html">
        <img alt="" src="https://img.shields.io/badge/JDK-1.8-green.svg"/>
</a>
<a href="https://github.com/567jin/AlgorithmPractice" target="_blank"><img src='https://img.shields.io/github/stars/567jin/AlgorithmPractice' alt='GitHub stars' class="no-zoom">
</a>
</div>




# 刷题日记 ✍

这里记录一些自己做过的算法题，题单主要来源于[代码随想录](https://programmercarl.com/)和《剑指offer》。

每个题会写一些关键点和对应的知识点

文件命名规则：\_(题目编号)\_(题目名称)

## Index

- [x] 数组
  - [704.二分查找](#704二分查找)--双指针, 三种写法推荐左闭右开
  - [15.三数之和](#15三数之和)--三指针, 去重技巧🔞
  - [283.移动零](#283移动零)--双指针(真移动，假移动)
  - [238.除自身以外数组的乘积](#238除自身以外数组的乘积)--左乘右乘=总乘
  - [80.删除有序数组中的重复项II](#80删除有序数组中的重复项ii)--快慢指针
  - [121.买卖股票的最佳时机](#121买卖股票的最佳时机)--历史最小值
  - [35.搜索插入位置](#35搜索插入位置)--二分查找
  - [13.罗马数字转整数](#13罗马数字转整数)--哈希, 理解题目
  - [167.两数之和II-输入有序数组](#167两数之和ii-输入有序数组)--二分查找, 双指针
  - [228.汇总区间](#228汇总区间)--分组循环
  - [54.螺旋矩阵](#54螺旋矩阵)--模拟
  - [189.轮转数组](#189轮转数组)--三次反转=轮转
  - [122.买卖股票的最佳时机ii](#122买卖股票的最佳时机ii)--贪心, 动规
  - [73.矩阵置零](#73矩阵置零)--标记
  - [53.最大子数组和](#53最大子数组和)--动规
  - [55.跳跃游戏](#55跳跃游戏)--贪心
  - [11.盛最多水的容器](#11盛最多水的容器)--双指针, 贪心
  - [48.旋转图像](#48旋转图像)--矩阵操作
  - [56.合并区间](#56合并区间)--区间
  - [45.跳跃游戏ii](#45跳跃游戏ii)--贪心
  - [274.h指数](#274h指数)--理解题目
  - [66.加一](#66加一)--题目分析
  - [134.加油站](#134加油站)--遍历
  - [287.寻找重复数](#287寻找重复数)--哈希, 抽屉原理, Floyd 判圈
  - [42.接雨水](#42接雨水)--动态规划, 单调栈, 双指针

- [x] 字符串
  - [58.最后一个单词的长度](#58最后一个单词的长度)--正则, 倒序遍历
  - [151.反转字符串中的单词](#151反转字符串中的单词)--双指针, sb的应用
  - [28.找出字符串中第一个匹配项的下标](#28找出字符串中第一个匹配项的下标)--KMP🔞, 暴力匹配
  - [125.验证回文串](#125验证回文串)--双指针, 字符相关函数使用
  - [14.最长公共前缀](#14最长公共前缀)--横向, 纵向比较确定公共部分
  - [1446.连续字符](#1446连续字符)--分组循环
  - [6. Z 字形变换](#6z字形变换)--技巧
  - [392.判断子序列](#392判断子序列)--贪心, 双指针, 动规
  - [76.最小覆盖子串](#76最小覆盖子串)--滑动窗口

- [x] 链表
  - [206.反转链表](#206反转链表)
  - [83.删除排序链表中的重复元素](#83删除排序链表中的重复元素)
  - [82.删除排序链表中的重复元素II](#82删除排序链表中的重复元素ii)
  - [2.两数相加](#2两数相加)
  - [141.环形链表](#141环形链表)--两种解法(双指针, 哈希表)
  - [142.环形链表II](#142环形链表ii)--两种解法(双指针(利用一个推理来判断入口), 哈希表)
  - [19.删除链表的倒数第N个结点](#19删除链表的倒数第n个结点)--三种解法(双指针, 计算长度, 栈)
  - [160.相交链表](#160相交链表)--四种解法, 双指针、栈、哈希表、对齐(计算长度)
  - [21.合并两个有序链表](#21合并两个有序链表)--递归🔞, 迭代🥰
  - [61.旋转链表](#61旋转链表)--断链接链
  - [92.反转链表ii](#92反转链表ii)--头插, 断链接链
  - [138.随机链表的复制](#138随机链表的复制)--HashMap记录关系
  - [25.K个一组翻转链表](#25k个一组翻转链表)--前驱和后继，接链和断链


- [x] 哈希表
  - [1.两数之和](#1两数之和)--哈希表set
  - [49.字母异位词分组](#49字母异位词分组)--哈希map, key的选择
  - [383.赎金信](#383赎金信)--字符统计
  - [202.快乐数](#202快乐数)--哈希表, 快慢指针, 数学分析🔞
  - [205.同构字符串](#205同构字符串)--映射
  - [219.存在重复元素ii](#219存在重复元素ii)--滑动窗口+set
  - [128.最长连续序列](#128最长连续序列)--哈希但要优化查找过程

- [x] 栈
  - [20.有效的括号](#20有效的括号)--栈的经典应用, 括号匹配
  - [150.逆波兰表达式求值](#150逆波兰表达式求值)--栈的经典应用
  - [155.最小栈](#155最小栈)--双栈模拟, 定义新类保存值, 保存差值

- [x] 队列
  - [239.滑动窗口最大值](#239滑动窗口最大值)--单调队列
  - [209.长度最小的子数组](#209长度最小的子数组)--队列, 双指针确定窗口
  - [3.无重复字符的最长子串](#3无重复字符的最长子串)--滑动窗口大小确定🔞

- [x] 树
  - [144.二叉树的前序遍历](#144二叉树的前序遍历)
  - [94.二叉树的中序遍历](#94二叉树的中序遍历)
  - [145.二叉树的后序遍历](#145二叉树的后序遍历)--用处最多
  - [102.二叉树的层序遍历](#102二叉树的层序遍历)
  - [104.二叉树的最大深度](#104二叉树的最大深度)
  - [101.对称二叉树](#101对称二叉树)
  - [226.翻转二叉树](#226翻转二叉树)
  - [105.从前序与中序遍历序列构造二叉树](#105从前序与中序遍历序列构造二叉树)--前序找根, 中序分割
  - [230.二叉搜索树中第K小的元素](#230二叉搜索树中第k小的元素)--中序遍历, 二叉搜索树的性质
  - [106.从中序与后序遍历序列构造二叉树](#106从中序与后序遍历序列构造二叉树)--后序遍历就是倒着的前序遍历, 后序找根, 中序分割
  - [112.路径总和](#112路径总和)--递归(隐含回溯), 迭代(所有节点对应的路径和)
  - [199.二叉树的右视图](#199二叉树的右视图)--层序遍历, 递归记录层数
  - [637.二叉树的层平均值](#637二叉树的层平均值)--层序遍历, 深搜也可判断层级🔞
  - [114.二叉树展开为链表](#114二叉树展开为链表)--迭代, 递归🔞
  - [100.相同的树](#100相同的树)--遍历, 异或技巧
  - [129.求根节点到叶节点数字之和](#129求根节点到叶节点数字之和)--遍历,
  - [236.二叉树的最近公共祖先](#236二叉树的最近公共祖先)--迭代, 递归🔞
  - [173.二叉搜索树迭代器](#173二叉搜索树迭代器)--中序遍历
  - [98.验证二叉搜索树](#98验证二叉搜索树)--中序遍历, 递归

- [x] 堆
  - [347.前K个高频元素](#347前k个高频元素)--大顶堆，小顶堆的选择。

- [x] 回溯
  - [39.组合总和](#39组合总和)
  - [46.全排列](#46全排列)
  - [47.全排列II](#47全排列ii)--去重技巧, 排序去重
  - [7.电话号码的字母组合](#7电话号码的字母组合)--先选数字，再对字母回溯
  - [78.子集](#78子集)
  - [90.子集II](#90子集ii)
  - [51.N皇后](#51n皇后)🔞
  - [93.复原IP地址](#93复原ip地址)--ip的特点有四段

- [x] 动态规划
  - [509.斐波那契数](#509斐波那契数)--递归, 动规, 迭代
  - [62.不同路径](#62不同路径)--动规(其实就是推导出一个类似于斐波那契的结果,然后迭代求解)
  - [64.最小路径和](#64最小路径和)--Min的递推公式
  - [70.爬楼梯](#70爬楼梯)--找递推公式, 递归降维
  - [5.最长回文子串](#5最长回文子串)--朴素字符串匹配, 多维递归, 中心扩散
  - [1143.最长公共子序列](#1143最长公共子序列)--多维递归,
  - [198.打家劫舍](#198打家劫舍)--一维动态规划


- [x] 数据结构的设计
  - [146.LRU缓存](#146lru缓存)🔞--HashMap+链表=LinkedHashMap
  - [380.O(1)时间插入、删除和获取随机元素](#380-o1时间插入删除和获取随机元素)--HashMap+数组=支持O(1)查找和插入的数组

- [x] 其它
  - [136.只出现一次的数字](#136只出现一次的数字)--异或
  - [172.阶乘后的零](#172阶乘后的零)--问题转化

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
两种解法，但都建立在双指针基础上：[MoveZeroes](src/_283_MoveZeroes.java)
- 遍历，将所有非零点移动到最前面(直接覆盖)，然后slow的值就是非零点值的数量，最后在后面补零即可，但有点作弊，这不是真正的”移动“
- 真正的移动，即交换零值和非零值，注意是fast!=0时才交换，要不然就是移动零到最前面了。


### [238.除自身以外数组的乘积](https://leetcode.cn/problems/product-of-array-except-self/description/)
比较巧的方法，先计算所有点左边相乘的结果，再计算所有点右边相乘的结果，左边乘右边就是去掉自身后数组剩余所有元素相乘的结果。
[ProductExceptSelf](src/_238_ProductExceptSelf.java)


### [80.删除有序数组中的重复项II](https://leetcode.cn/problems/remove-duplicates-from-sorted-array-ii/description/)
两种解法，第一种是快慢指针，但是比较难想到，第二种是利用计数标记的方式。[RemoveDuplicates](src/_80_RemoveDuplicates.java)
- 快慢指针，与删除重复项的题类似，但是这里由于要保留两个重复项，因此比较方式变成了快指针与慢指针的前两个进行比较
- 计数标记，相等时的标记为true，并往后移动，在下次判断时只有相等并且允许重复复标记为true才保留，不相等时标记为false，

### [121.买卖股票的最佳时机](https://leetcode.cn/problems/best-time-to-buy-and-sell-stock/description/)
暴力法和技巧[MaxProfit](src/_121_MaxProfit.java)
- 暴力法，两层for循环，找到每个点与后面点之间的差的最大值，但是会超时
- 技巧，找一个变量记录**历史最小值**，每当当前值小于历史最小值就去更新历史最小值，反之就计算最大利润。

### [35.搜索插入位置](https://leetcode.cn/problems/search-insert-position/description/)
简单的二分查找题，只要看到题目有要求时间复杂度**O(logn)**或者是**排序好的数组**，那么就要考虑二分查找。[SearchInsert](src/_35_SearchInsert.java)

### [13.罗马数字转整数](https://leetcode.cn/problems/roman-to-integer/description/)
题目难度不算大，难点在于理解特殊规则，规则简单来说就是上一个值小于当前值，则上一个值就是负数(代表减去)，反之就是整数[RomanToInt](src/_13_RomanToInt.java)
两种解法：
- 直接减去，即每当相加前，判断一下当前值与上一个值谁大谁小，如果当前值小于上一个值则直接相加，反之需要减去再相加。
- 加负号，统一减去。即先记录上一个值，再判断当前值与上一个值的大小关系，如果当前值较大则上一个值加负号。不要忘了在最后加上pre(最后一个值)


### [167.两数之和II-输入有序数组](https://leetcode.cn/problems/two-sum-ii-input-array-is-sorted/description/)
两种解法：二分查找，双指针[TwoSum](src/_167_TwoSum.java)
- 二分查找，看到是排序好的数组就立马应该想到二分查找，但是这里复杂度较高，因为需要对每一个数的后面所有数进行二分查找。
- 双指针，双指针简单直接，因为数组是排好序的，相加太大则右指针左移，相加太小则左指针右移，直到找到符合条件的数。

### [228.汇总区间](https://leetcode.cn/problems/summary-ranges/description/)
**分组循环**，即简单来说外面一个for循环(或者while)内部使用while循环找到符合条件的终止位置，两层循环，对每一个数都用while循环找符合条件的终止点


### [54.螺旋矩阵](https://leetcode.cn/problems/spiral-matrix/description/)
一圈一圈的打印，难点在于边界条件的判定[SpiralOrder](src/_54_SpiralOrder.java)


### [189.轮转数组](https://leetcode.cn/problems/rotate-array/description/)
观察规律，两种方法，第一种使用一个额外的数组来保存轮转后的数组；第二种直接反转数组，经过三次反转后可以达到轮转的效果[Rotate](src/_189_Rotate.java)
- 额外数组保存元素,使用一个额外的数组保存轮转后的元素，位置是(i + k) % length
- 三次反转=轮转，观察规律。第一次整体反转，第二次反转前(0, k % nums.length - 1)个元素，第三次反转(k % nums.length, nums.length - 1)之间的元素
- 直接轮转，比较复杂。数学推导。[环状替换](https://leetcode.cn/problems/rotate-array/solutions/551039/xuan-zhuan-shu-zu-by-leetcode-solution-nipk/?envType=study-plan-v2&envId=top-interview-150)

### [122.买卖股票的最佳时机ii](https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-ii/description/)
贪心和动态规划。贪心的思想比较简单(只考虑当前最佳选项，不考虑以后情况)，局部最优可以推出全局最优，关键在于把问题分解成求多个局部最优；动态规划难点在于递推公式和保存状态的矩阵的定义。[MaxProfit](src/_122_MaxProfit.java)

### [73.矩阵置零](https://leetcode.cn/problems/set-matrix-zeroes/description/)
使用两个标记数组标记哪一行哪一列需要置零。然后遍历该数组，判断是否满足标记的条件，置零即可。[_73_SetZeroes.java](src/_73_SetZeroes.java)

### [53.最大子数组和](https://leetcode.cn/problems/maximum-subarray/description/)
题目只要求返回结果，不要求得到最大的连续子数组是哪一个。这样的问题通常可以使用动态规划解决。
首先定义dp的含义，表示以i结尾的连续数组的最大和，可以推出公式为dp\[i\]=max{dp\[i-1\]+nums\[i\], dp\[i-1\]} dp\[0\]=nums\[0\]；然后写出代码找出dp\[\]的最大值即可。
又因为只需要返回最大值即可，因此不需要记录每个元素位置对应的最大和，所以可以使用一个变量来记录中间值(即dp数组的元素)，使用另一个变量记录最大值。
[MaxSubArray](src/_53_MaxSubArray.java)

### [55.跳跃游戏](https://leetcode.cn/problems/jump-game/description/)
也是贪心。贪心好难。**核心思想是局部最优推导全局最优**。难点在于将问题细分成一个个小问题，从而推导出全局最优。这里的局部最优就是能到达的最远位置，
如果当前i超过了最远位置则说明最远距离卡住不动了，反之则可以一直更新能达到的最远距离，直到最远距离超过了n-1.[CanJump](src/_55_CanJump.java)
依次遍历数组中的每一个位置，并实时维护最远可以到达的位置。对于当前遍历到的位置，如果它在最远可以到达的位置的范围内，那么我们就可以从起点通过若干次跳跃到达该位置。

### [11.盛最多水的容器](https://leetcode.cn/problems/container-with-most-water/description/)
双指针加贪心的思想。双指针解题，贪心的思想证明这样做的正确性。
[_11_MaxArea.java](src/_11_MaxArea.java)

### [48.旋转图像](https://leetcode.cn/problems/rotate-image/description/)
[Rotate](src/_48_Rotate.java)


###  [56.合并区间](https://leetcode.cn/problems/merge-intervals/description/)
先对区间进行排序，然后判断后面的区间的起始值是否在前一个区间内部即可。难点在于对二维数组的排序，和最后答案的返回(res.toArray(new int\[\]\[\]{}))。
还有一个小知识点，这里用LinkedList比用ArrayList要好，因为过程中只需要获取最后一个元素。[Merge](src/_56_Merge.java)
```java
//        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));  // 这种排序方法很慢
Arrays.sort(intervals, new Comparator<int[]>() {
    @Override
    public int compare(int[] o1, int[] o2) {
        return o1[0] - o2[0];
    }
});
```

### [45.跳跃游戏ii](https://leetcode.cn/problems/jump-game-ii/description/)
最小跳跃次数，那么贪心的做法是，每次都选择跳跃最大位置，那么到达最终位置必定是最少跳跃次数。因此，使用一个变量定义一下右边界(当到达了边界时，进入下一次跳跃)，因为题目说是可达的，因此当边界等于i时不用跳跃(因为此时已经到达了)
[Jump](src/_45_Jump.java)


### [274.h指数](https://leetcode.cn/problems/h-index/description/)
至少有h篇论文引用指数大于h，先对数组排序，倒着找即可。[HIndex](src/_274_HIndex.java)

### [66.加一](https://leetcode.cn/problems/plus-one/submissions/514803425/)
题目本身比较简单直接，但是容易陷入思维误区，对于一个数加1，只有9加1时才需要考虑进位，其他情况均直接加1即可。  
因此可以倒着遍历数组，找到该数组第一个不为9的数，让其加1，其后面的数全置为0即可。  
还有一种情况是数组元素全是9，此时需要扩充数组元素个数为n+1，并将其首位置为1即可。  
[PlusOne](src/_66_PlusOne.java)

### [134.加油站](https://leetcode.cn/problems/gas-station/description/)
模拟，以每个站点为起点，看其是否能够回到起点，但是遍历过程中可以优化，即如果当前站点到不了下一个站点，  
则可以直接从当前站点的下一个站点开始(而不用回到最初的站点的下一个站点)，因为之前的站点都会经过当前站点，都到不了，因此直接从下一个站点开始即可。  
并且由于是环形数组，还涉及到环形数组的遍历，即到达末尾了，再回到起点开始遍历(对长度取余)。[CanCompleteCircuit](src/_134_CanCompleteCircuit.java)

### [287.寻找重复数](https://leetcode.cn/problems/find-the-duplicate-number/description/)
哈希最简单，但是需要O(N)的空间复杂度；抽屉原理(一个抽屉只能放一个，当超过时必有抽屉放多个)，下标是编号表示有几个抽屉，当数组元素小于当前抽屉号时，说明左边不存在重复数(抽屉足够)，因此往右边找，由于使用到二分时间复杂度为O(nlogn)；
Floyd 判圈算法，类似于链表找环入口，难点在于怎么从数组建成链表。[FindDuplicate](src/_287_FindDuplicate.java)


### [42.接雨水](https://leetcode.cn/problems/trapping-rain-water/description/)
本质上就是找当前柱子左右两边最大柱子的最小值，然后计算宽度减去当前柱子的高度就是接雨水的量。三种解法：[Trap](src/_42_Trap.java)
- 动态规划，用两个数组分别记录当前柱子左右两边的最高柱子，然后遍历找当前柱子左右两边最高柱子的最小值，即可计算接雨水的量。
- 单调栈，有点不太好理解，单调栈中存放柱子高度的单调下降的下标，因为只有柱子高度逐渐减小，并且当前柱子大于上一个柱子才能接雨水。
- 双指针，本质上还是动态规划，是动态规划的降维写法。两个变量记录左右两边柱子的最大高度(类似于动态规划的数组)，然后谁小以谁为基准，计算接雨水的量。

***[⬆ Back to Index](#index)***


---
<!--字符串-->

### [58.最后一个单词的长度](https://leetcode.cn/problems/length-of-last-word/description/)
很简单的一道题，反向遍历；或者正则表达式分隔字符串后得到一个字符串数组，数组的最后一个元素就是最后一个单词统计其长度即可，
[LengthOfLastWord](src/_58_LengthOfLastWord.java)

### [151.反转字符串中的单词](https://leetcode.cn/problems/reverse-words-in-a-string/description/)
两种解法：[ReverseWords](src/_151_ReverseWords.java)
- 双指针，双指针确定单词的长度，确定单词长度后，截取即可，left-right=单词长度。left记录上一次right不为空格的索引，在right遍历到下一个空格后(两个不连续空格之间就是单词)，即可确定单词的长度。
- 借助StringBuilder类，使用一个指针倒序遍历即可，跟58题很像，在一个循环中找到一个单词后，反转后得到真正的单词，加到结果集中即可。


### [28.找出字符串中第一个匹配项的下标](https://leetcode.cn/problems/find-the-index-of-the-first-occurrence-in-a-string/description/)
两种解法：[StrStr](src/_28_StrStr.java)
- 暴力，遍历haystack，每次截取needle.length()长度的字符串跟needle比较。注意遍历的次数是haystack.length()-needle.length()
- KMP，计算前缀表，根据前缀表减少回头比较的次数


### [125.验证回文串](https://leetcode.cn/problems/valid-palindrome/description/)
两种解法：[IsPalindrome](src/_125_IsPalindrome.java)
- 不使用内置函数，首先去掉字符串中的非字母数字，得到一个新的字符串，再在此字符串上使用双指针判断即可，注意使用while循环更好。只需判断left<right即可
- 使用内置函数来判断字符是否是数字字母Character.isLetterOrDigit()，并使用Character.toLowerCase()转大小写(如果是非字母返回其本身)，难点在于，要用两个while循环来找到左右两边为字母数字的字符。


### [14.最长公共前缀](https://leetcode.cn/problems/longest-common-prefix/description/)
两种解法，两种角度：[LongestCommonPrefix](src/_14_LongestCommonPrefix.java)
- 横向来看，最长公共前缀，就是两两比较，不断更新prefix，这样全部比较完后prefix就是最长公共前缀了。即所有字符串的最长公共前缀
- 纵向来看，最长公共前缀就是逐次比较每个字符串相应位置的字符，直到不相等，则出现最长公共前缀(但要注意判断字符长度)。即横向扫描

### [1446.连续字符](https://leetcode.cn/problems/consecutive-characters/description/)
与[228.汇总区间](#228汇总区间)类似，使用分组循环。即外面是一个while循环，里面用while循环找符合条件的值

### [6.Z字形变换](https://leetcode.cn/problems/zigzag-conversion/description/)
使用二维数组来模拟这个过程，关键在于找规律，一个周期内(即半个z)消耗的字符数是2(row-1)。则所需行数也可计算。
但是考虑到在每一行添加元素时，也只是将元素添加到该行上一个元素的右边，因此可以直接使用stringBuilder来记录元素。
还有一个难点在于，什么时候往下，什么时候往右上添加。当触底或在第一行时候需要变换添加的顺序，利用一个flag来判断什么时候该变换顺序。[Convert](src/_6_Convert.java)

```java
for (char ch : s.toCharArray()) {
    record[i].append(ch);
    if (i == 0 || i == row - 1) {
        flag = -flag;
    }
    i += flag;
}
```

### [392.判断子序列](https://leetcode.cn/problems/is-subsequence/)
贪心的思想，直接双指针挨个匹配即可，但是处理很多个字符匹配的情况复杂度很高，每次匹配都需要要遍历。
动态规划的思想，使用一个二维数组来记录t中每个位置i往后字符j出现的位置，这样的话就可以“跳着”匹配了，即匹配到了之后，下一个字符的位置保存在dp中，  
直接跳到该位置即可，而不逐一进行遍历比较了；二维数组的定义和理解比较复杂，有点类似于KMP了。[IsSubsequence](src/_392_IsSubsequence.java)

### [76.最小覆盖子串](https://leetcode.cn/problems/minimum-window-substring/description/)
滑动窗口，使用两个数组，分别记录窗口内的字符及其个数和t串，只有当s中的字符存在于t对应的hashMap中，
才更新window，只有window中的字符和map中的字符一样，才开始收缩窗口，即移动左指针，去除window中对应的字符。
[MinWindow](src/_76_MinWindow.java)


***[⬆ Back to Index](#index)***

---

<!--链表-->

### [206.反转链表](https://leetcode.cn/problems/reverse-linked-list/description/)

三个参数，一个记录cur，一个记录cur.next，一个记录pre.
[ReverseList](src/_206_ReverseList.java)

### [83.删除排序链表中的重复元素](https://leetcode.cn/problems/remove-duplicates-from-sorted-list/description/)

链表的题目。知识点：虚拟头结点(哨兵节点)处理删除头结点的情况；两种写法  [DeleteDuplicates](src/_83_DeleteDuplicates.java)

- 递归写法，问题可以分解成多个子问题，递归的思想。终止条件是cur==null或cur.next==null;后面分删除节点和不删除节点，不删除节点就是head.nex=deleteDuplicates(head.next)
  ;删除节点使用while循环
- 遍历，遍历找到重复节点逐个删除即可，因为需要保留重复节点中的一个，因此不需要pre记录上一个未被删除节点。


### [82.删除排序链表中的重复元素II](https://leetcode.cn/problems/remove-duplicates-from-sorted-list-ii/description/)

链表的题目。知识点：虚拟头结点(哨兵节点)处理删除头结点的情况；pre记录上一个不重复的节点。两种解法：  [DeleteDuplicates](src/_82_DeleteDuplicates.java)

- 递归，不太好写。终止条件是cur==null或cur.next==null；后面分两种情况，有重复元素不需要跳过元素，有重复元素需要跳过所有元素(因此是while循环)。
- 迭代，逐个遍历链表，注意到链表是排序的，因此重复元素都是相邻的。找到全部重复元素(值等于cur.val的节点)逐个跳过即可，用一个pre记录上一个不重复的元素。


### [2.两数相加](https://leetcode.cn/problems/add-two-numbers/)

两数相加但是链表，加法运算是从低位到高位开始的，并且会涉及到进位，因此不仅需要计算两个节点值的加add还要计算进位carry。
代码里有很多判空的三元表达式，并且最后的进位carry也要处理。
[AddTwoNumbers](src/_2_AddTwoNumbers.java)

### [141.环形链表](https://leetcode.cn/problems/linked-list-cycle/)

双指针，快慢指针的应用,链表中如果有环，则两个指针都会进入到环中，并且由于一个快一个慢，终将相遇；无环将永不相遇。

哈希表的解法，创建一个哈希表，遍历链表，不断地将节点添加进哈希表中，如果有相等的说明有环，反之无环，但是会占用额外的存储空间。
[HasCycle](src/_141_HasCycle.java)

### [142.环形链表II](https://leetcode.cn/problems/linked-list-cycle-ii/description/)

与[141.环形链表](#141环形链表)相似，也是两种解法：[DetectCycle](src/_142_DetectCycle.java)

- 哈希表，用一个哈希表记录一下，重复的节点就是环的入口点。哈希表中第一个相同的节点，就是环的入口节点。
- 快慢指针法，但是要用到一个推理，当判断有环后，slow回到原点，同时与fast前进一步终会相遇，且相遇点就是环的入口点。

### [19.删除链表的倒数第N个结点](https://leetcode.cn/problems/remove-nth-node-from-end-of-list/description/)

这个题的关键在于怎样定位到待删除节点，或者说得到链表的长度(然后遍历即可找到待删除节点),小细节就是注意头结点的删除，因此要用到虚拟头节点。
三种解法：  [RemoveNthFromEnd](src/_19_RemoveNthFromEnd.java)

- 双指针定位待删除节点
- 链表长度，定位到长度，就可以定位到待删除节点了。
- 栈，倒数的方式，最适合栈这种先进后出的数据结构了，第N个弹栈的就是待删除节点，N+1个弹栈的就是其前驱结点。



### [160.相交链表](https://leetcode.cn/problems/intersection-of-two-linked-lists/description/)
四种解法：[GetIntersectionNode](src/_160_GetIntersectionNode.java)
- 哈希表的解法，遍历其中一个链表添加节点到set中，遍历另一个链表，如果set中存在则直接返回即可(第一个就是相交节点)
- 双指针，借助推理，比较复杂，短链表的到末尾后移动到长链表的头部 长的到末尾后移动到短的头部，然后再相遇就是交叉节点，基本逻辑跟对齐的解法差不多，但是这里不用知道链表的长度，可见[相交链表官方题解](https://leetcode.cn/problems/intersection-of-two-linked-lists/solutions/811625/xiang-jiao-lian-biao-by-leetcode-solutio-a8jn/)
- 栈的解法，使用两个栈保存节点值，因为相交是从后往前比较的，如果不相交则栈顶节点不相等，栈顶节点相等说明相交，依次弹栈，找出第一个不相等节点的前一个节点即是相交节点。
- 计算二者长度后对齐，计算两链表长度后，相减得到差值，移动较长的链表，对齐后，遍历找第一个相等的节点即是相交节点。



### [21.合并两个有序链表](https://leetcode.cn/problems/merge-two-sorted-lists/description/)
两种解法：[MergeTwoLists](src/_21_MergeTwoLists.java)
- 迭代：很自然的想法，注意在最后别忘了判断l1的长度不等于l2长度的情况(需要拼接最后一段未进行比较的链表)
- 递归：结束条件的返回值，l1==null，返回l2，反之也是；较小节点的next指向合并后的其余节点(即递归调用)

### [61.旋转链表](https://leetcode.cn/problems/rotate-list/description/)
找到轮转规律(k为0或n(链表长度)的倍数时，是原链表，移动的步数以求余计算)，断开链表，再拼接即可[RotateRight](src/_61_RotateRight.java)


### [92.反转链表ii](https://leetcode.cn/problems/reverse-linked-list-ii/description/)
三种解法：先断链再接链；在遍历过程中反转，头插法。[ReverseBetween](src/_92_ReverseBetween.java)
- 断链接链。即找到要反转的子链，断开后进行反转，再接链，缺点是可能会遍历两次链表。
- 在遍历过程中直接反转。首先找到pre即待反转子链的前一个链表节点，然后对后面的链表进行反转。再拼接链表(因为反转过程中子链的第一个链表指向null，即断开了链表，因此在最后还需要拼接上去)
- 头插法。pre指向待反转链表的前一个节点，cur永远指向当前待翻转链表的第一个节点，要做的是把cur.next插入pre的后面。


### [138.随机链表的复制](https://leetcode.cn/problems/copy-list-with-random-pointer/description/)
本题难点在于节点中随机指针的复制，采用hashmap的方法，将原先节点与新节点的位置绑定在一起记录在map中，后面再遍历原链表，  
根据原链表和绑定关系，绑定新链表的next和random的指向。[CopyRandomList](src/_138_CopyRandomList.java)

### [25.k个一组翻转链表](https://leetcode.cn/problems/reverse-nodes-in-k-group/description/)
找到待翻转区域的前驱和后继节点。[ReverseKGroup](src/_25_ReverseKGroup.java)


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


### [383.赎金信](https://leetcode.cn/problems/ransom-note/description/)
简单的统计字符的题，难点在于先统计谁的值，这里先统计magazine中的字符，再在另一个字符遍历过程中，如果没有即record\[c-'a'\]==0则返回false。
[CanConstruct](src/_383_CanConstruct.java)

### [202.快乐数](https://leetcode.cn/problems/happy-number/description/)🔞
也是一个数学题，难在分析，三种情况，n==1是快乐数，进入了循环，无限增长(通过分析发现不会发生)[IsHappy](src/_202_IsHappy.java)
- hash表检测循环，n==1或set中包含了之前出现过的数，说明达到了条件，退出while循环，并在最后判断一下n是否等于1即可
- **双指针检测循环**，其实就是[链表是否有环](#141环形链表)的解法，快慢指针法，一个前进两步，一个前进一步，那么如果有环，他俩必定相遇。
得到数字各个位上的数字:先取余得到各位上的数字，再整除得到十位上的数字。不断循环就可以得到该数各个位置上的数字了。
 ```
 while (n > 0) {
    int num = n % 10;
    n = n / 10;
}
 ```
### [205.同构字符串](https://leetcode.cn/problems/isomorphic-strings/description/)
题目比较难读懂，两种解法，可以想象成两种不同的语言相互映射，第一种解法就相当于中译英，英译中然后看是否相等。第二种解法相当于中译日，英译日，看看二者都译成第三方语言后是否相等。
[IsIsomorphic](src/_205_IsIsomorphic.java)
- 直接相互映射，定义两个map，s2t，t2s，在遍历字符串过程中比较映射是否能对应起来。
- 映射为第三方，即s映射为其他数组，t映射为其他数组，比较这两个字符串映射后的第三方数组是否相等。


### [219.存在重复元素ii](https://leetcode.cn/problems/contains-duplicate-ii/description/)
两种解法。[ContainsNearbyDuplicate](src/_219_ContainsNearbyDuplicate.java)
- 首先是hashMap的解法，其key对应值，value是nums的索引。一旦map.containsKey(nums\[i\])则计算其差值是否满足k即可。
- 第二种滑动窗口加hashSet的解法。因为是需要找k个以内的子数组有没有重复值，因此可以使用一个set集合，维护set集合内的元素最多为k个。

### [128.最长连续序列](https://leetcode.cn/problems/longest-consecutive-sequence/description/)
直接使用哈希表存储所有的值。然后用while循环遍历找以每个num为起始点的最长连续序列(但是会超时)，因此可以优化一下，  
对于\[100,4,200,1,2,3\]来说可以发现在找的过程中如果2开始则没必要，因为存在1开始的更长的子序列，  
从3开始也没必要，因为存在从2开始的最长子序列，因此只有当前值的前一个值不存在与set集合中时，遍历才有意义。[LongestConsecutive](src/_128_LongestConsecutive.java)
或者直接调用库函数先对数组进行一个排序。


***[⬆ Back to Index](#index)***


---
<!--栈-->
### [20.有效的括号](https://leetcode.cn/problems/valid-parentheses/description/)
本题是栈的经典用法，括号的匹配，看着简单，实际上做的时候却很有技巧，比如压栈时，判断是左括号，是把右括号压进去，而不是直接把左括号压进去，这样在弹栈判断时更容易；
还有就是两个判断语句，")))("这种情况，是stack.isEmpty()即栈中元素为零，但是要弹栈比较因此直接返回false，还有就是栈中元素有剩余，即括号没有完全配对上，需要判断栈是否为空。
[IsValid](src/_20_IsValid.java)

### [150.逆波兰表达式求值](https://leetcode.cn/problems/evaluate-reverse-polish-notation/description/)
一道栈的经典应用的题目，逆波兰表达式利用了栈的先入先出的特点，简化了数学表达式的计算(仅仅利用一个栈这种计算机中很常见的数据结构)。
[EvalRPN](src/_150_EvalRPN.java)

### [155.最小栈](https://leetcode.cn/problems/min-stack/)
三种解法：双栈模拟，定义一个新类保存val和minVal，栈中记录和最小值的差值和不断更新最小值 [MinStack](src/_155_MinStack.java)
- 双栈模拟，即额外定义一个栈来保存最小值，每次压val入栈时，同时压一个当前最小值入另一个栈。
- 定义一个类入Pair，保存val和minVal，跟双栈模拟一个意思。
- 记录差值。即栈中记录当前val与minVal的差值，当差值小于0时说明要更新最小值了，在弹栈时，同样需要更新最小值(差值为零更新最小值即最小值要变大)，peek的值永远是当前最小值加差值。


***[⬆ Back to Index](#index)***

---

<!--队列-->

### [239.滑动窗口最大值](https://leetcode.cn/problems/sliding-window-maximum/description/)

单调队列的应用，关键在于怎么维护单调队列，两点值得注意：移出队列的时机(队列中的值不在窗口内，后来的值比队列最大值要大)，队列中保存数组下标。  
[MaxSlidingWindow](src/_239_MaxSlidingWindow.java)

### [209.长度最小的子数组](https://leetcode.cn/problems/minimum-size-subarray-sum/description/)
窗口值，用两个指针或队列来当做滑动窗口，用一个变量sum记录窗口内所有元素的和。当元素和大于等于target时就更新最小长度，否则继续往窗口内添加值。
注意，题目要求的是**大于等于，而不是等于**。
[MinSubArrayLen](src/_209_MinSubArrayLen.java)

### [3.无重复字符的最长子串](https://leetcode.cn/problems/longest-substring-without-repeating-characters/)🔞
使用双指针确定滑动窗口的大小，但是这里为了确定窗口内的字符是无重复的，还需要一个HashSet来记录窗口内无重复子串[LengthOfLongestSubstring](src/_3_LengthOfLongestSubstring.java)
遍历过程中有两种情况，当前字符不在窗口内，则直接添加并更新窗口长度；第二种情况，当前字符在窗口内，则需要确定窗口内那个重复字符的位置并更新left的位置到重复字符的位置上。


***[⬆ Back to Index](#index)***


---

<!--二叉树-->

### [144.二叉树的前序遍历](https://leetcode.cn/problems/binary-tree-preorder-traversal/description/)

二叉树的前序遍历，实际解题用得不多(后序遍历最多，因为其需要先处理完所有左右子树)。
两种写法：[PreorderTraversal](src/_144_PreorderTraversal.java)

- 递归的深度优先搜索
- 迭代的深度优先搜索

层序遍历迭代使用队列。深度遍历使用栈。

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

两种写法：  [IsSymmetric](src/_101_IsSymmetric.java)

- 递归，注意比较的条件left.left和right.right比，left.right和right.left比，和其他不相称的条件判断。
- 迭代，两种实现**栈和队列**(栈和队列在这里都一样，因为只要保证相邻节点是要比较的节点即可，无关节点进出顺序)，不太好写，主要是比较是成对比较的，因此队列/栈中添加元素也是成对添加的，不太好想到。


### [226.翻转二叉树](https://leetcode.cn/problems/invert-binary-tree/description/)
两种写法：[InvertTree](src/_226_InvertTree.java)
- 递归，主要在于确定结束条件和递归条件。本题都比较好写
- 迭代，无论是使用队列还是栈都可以，因为只需要能够遍历到每个节点并再下次循环中取出即可。推荐使用队列


### [105.从前序与中序遍历序列构造二叉树](https://leetcode.cn/problems/construct-binary-tree-from-preorder-and-inorder-traversal/description/)
难在分析，而不是递归，递归的写法很自然，但是如何递归难写，需要分析前序中序遍历的特点，并且只能树的节点值互不相同才可以。
难点在于分析出前序遍历确定根节点，根据根节点在中序遍历中的位置从中序遍历中分割出左右子树，再递归(即重复这个过程即可)。
两种写法：[BuildTree](src/_105_BuildTree.java)
- 借助Arrays.copyOfRange()来分割左右子树，因为需要复制数组，效率不太高
- 借助数组的索引下标来界定范围，优点是不用复制数组了，缺点是难写(**代码还未解决**)。


### [230.二叉搜索树中第K小的元素](https://leetcode.cn/problems/kth-smallest-element-in-a-bst/description/)
两种解法：[KthSmallest](src/_230_KthSmallest.java)
- 暴力，直接中序遍历得到二叉搜索树的全部节点值(中序遍历二叉搜索树返回的是升序排列的数组)，再找到第k小的即可。
- 利用性质，第k个最小值 即第k个中序遍历过程中被弹栈的值，中序遍历过程中判断弹了K次栈即可找到第k个最小值。代码中多了健壮性判断，找不到返回Integer.MIN_VALUE，实际上题目的意思是一定能找到。


### [106.从中序与后序遍历序列构造二叉树](https://leetcode.cn/problems/construct-binary-tree-from-inorder-and-postorder-traversal/description/)
**后序遍历就是倒着的前序遍历**，因此本题与105题的解法是一样的。注意使用递归的方式，迭代的方式太麻烦了。
[BuildTree](src/_106_BuildTree.java)

### [112.路径总和](https://leetcode.cn/problems/path-sum/description/)
两种解法：[HasPathSum](src/_112_HasPathSum.java)
- 递归，这题递归反而更简单了。递归过程中找到根节点判断一下即可，反之则继续寻找。这里的递归隐含着回溯，**归的过程就是回溯的过程**。
- 迭代，使用队列保存节点及其节点对应的路径和，一旦该节点是叶子结点并且保存的对应的路径和是targetNum则返回true。注意，可以使用两个队列，一个队列用于层序遍历，另一个队列保存对应节点的路径和;或者直接使用一个队列，队列中的元素是一个Object\[\]数组，直接保存这两个值。

迭代一个值得注意的概念是，节点路径和，这里保存的是每个节点的路径和，根节点到此节点之间所有节点的和。通过迭代所有节点的路径和来找到符合条件的路径和。
具体示例如下:
```java
/*
		    1
		  /   \
		 2     3
		/ \   / \
		4  5 6   7
节点1的路径和是1
节点2的路径和是1+2=3
节3的路径和是1+3=4
...
节点6的路径和是1+3+6=10
节点7的路径和是1+3+7=11
*/
```

### [199.二叉树的右视图](https://leetcode.cn/problems/binary-tree-right-side-view/description/)
两种解法[RightSideView](src/_199_RightSideView.java)：层序遍历最直接。递归的方法，需要额外的变量来记录递归的层数，每一层最先到达的节点就是最右节点(**注意是先右后左的顺序递归的**)。每一次递归代表来到了新的层，有多少层就是多少栈深，**递归的深度反映了在二叉树深度优先遍历中的层次**。
- 层序遍历(广度优先搜索)，迭代，从题目中可知右视图就是树的每一层的最右边的节点值，那么在层序遍历时，最后一次的节点就是右边的节点(先左后右进队列的情况，反之是左视图)。
- 深度遍历(深度优先搜索)，递归，在递归时，只需要判断每一层(也即每一个深度)最先到达的节点就是右视图(因为按照先右后左递归的，那么在每一层递归时，第一个到达的节点就是每一层的最右节点)

### [637.二叉树的层平均值](https://leetcode.cn/problems/average-of-levels-in-binary-tree/description/)

计算每一层的和再去求平均，难点在于怎么区分哪些节点是同一层，两种解法：[AverageOfLevels](src/_637_AverageOfLevels.java)
- 层序遍历，最直接的方法
- 深度遍历，需要两个数组，一个数组计算每一层的和，另一个数组计算每一层的节点数，最后再计算平均值。区分每一层节点的方法：sums保存的是每一层的和，位置就是层级，当level<sums.size()时，说明当前层级在sums中已经保存了，只需要加上当前节点值即可，反之就未保存是一个新的层级，需要新添加进sums和nodes中

### [114.二叉树展开为链表](https://leetcode.cn/problems/flatten-binary-tree-to-linked-list/description/)🔞
两种解法：递归，迭代。[Flatten](src/_114_Flatten.java)
- 迭代，先把右子树平移到左边，在整体平移左子树到右边。或者先把左子树平移到右边，再将保存的右子树连接到左子树的最右节点。
- 递归，采用后序遍历的方式，因为前序遍历的话，右子树就丢了，采用后序遍历，确保遍历到当前节点时其右子树已经处理过了。用pre记录上一个处理过的节点，并将当前遍历到的节点指向pre。

### [100.相同的树](https://leetcode.cn/problems/same-tree/description/)
两种遍历方法：[IsSameTree](src/_100_IsSameTree.java)
- 深度优先, 先判断是否为null 再判断节点值是否相等。
- 广度优先, 两个队列分别记录两树的节点，一一进行比较，一个小技巧，判断同时为null或有一个为null的技巧是 异或表达式。
```
if (right1 == null ^ right2 == null) {
    return false;
}
当同时为null或同时不为null时才需要后续判断。当只有一方为null时，直接返回false;
```

### [129.求根节点到叶节点数字之和](https://leetcode.cn/problems/sum-root-to-leaf-numbers/description/)
两种遍历方式：[SumNumbers](src/_129_SumNumbers.java)
- 深度优先搜索, 记录路径和，直到找到根节点到叶子结点的路径和，则加到最终结果中。
- 广度优先搜索, 需要两个队列，一个用来维护节点，一个用来维护节点对应的路径和。

### [236.二叉树的最近公共祖先](https://leetcode.cn/problems/lowest-common-ancestor-of-a-binary-tree/description/)🔞
递归判断的条件思想很难，代码简单；迭代的思想简单，代码稍复杂。[LowestCommonAncestor](src/_236_LowestCommonAncestor.java)
- 递归，主要思想就是，查看以root为节点的子树是否能够找到p和q，如果可以则该节点就是最近公共祖先；只找到一个则p和q其中有一个当祖先；都没找到返回null。
- 迭代，定义一个hashmap来记录所有节点的父节点。从p开始不断地找其父结点，并记录在set集合中，同样地从q开始不断地找其父结点，判断是否和p的有重合，如果有则该节点就是最近公共祖先(因为是从下往上找的 因此是最近的 又因为p和q的共同父结点因此是公共祖先)

### [173.二叉搜索树迭代器](https://leetcode.cn/problems/binary-search-tree-iterator/description/)
二叉搜索树与中序遍历密不可分，因为中序遍历的结果刚好是二叉搜索树从小到达排列的结果。并且还有一个技巧，倒着的中序遍历(即先从右边遍历)等于二叉搜索树从大到小。[BSTIterator](src/_173_BSTIterator.java)

### [98.验证二叉搜索树](https://leetcode.cn/problems/validate-binary-search-tree/description/)
两种解法：递归。中序遍历[IsValidBST](src/_98_IsValidBST.java)
- 递归：对于一个二叉搜索树而言，其子树也是二叉搜索树，因此可以使用递归去解决。但是边界条件难以判断，边界条件用左右子树不能大于一个边界判断，例左子树最大值不能大于root，最小值不能大于右子树的最小值，因此是两个边界。
- 中序遍历：判断当前节点值是否大于上一个遍历的值，如果满足则是一个二叉搜索树，反之不是。

***[⬆ Back to Index](#index)***

---

### [347.前K个高频元素](https://leetcode.cn/problems/top-k-frequent-elements/description/)
使用最小堆来找前K个最大元素,反之使用最大堆找前K个最小元素.本题是找高频元素，因此需要先使用一个map统计各元素出现的次数。[TopKFrequent](src/_347_TopKFrequent.java)
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

组合的问题。求子集三种解法：前两种解法区别只是path添加进结果集的时机不同，一个后添加，一个先添加。[Subsets](src/_78_Subsets.java)

- 回溯，先递归到最深度，在回溯过程中添加值；后添加
- 回溯，可以先添加元素到结果集中，直至遍历完整个树；先添加
- 也可以选择动态规划的思想(逐个添加元素)，其实就是取子集的过程，逐个添加元素形成子集；

**难点**在于递归的终止条件和结果集的添加很难对应，之前的对应关系是path.size==length即可，难判断path添加进结果集的时机。
组合的问题，取过的元素不能再取，因此需要一个Index来标识，在遍历过程中收集所有节点即是子集，因此不能剪枝(需要完全遍历)。

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


### [93.复原ip地址](https://leetcode.cn/problems/restore-ip-addresses/description/)
ip分为四段，因此终止条件也是四段找完了，并且索引到了字符串的最后一位(题目说必须要用上所有的字符)。
回溯过程中有个难点就是不能包含前导0，一旦一段有一个0了，则必须去寻找下一段。
[RestoreIpAddresses](src/_193_RestoreIpAddresses.java)


***[⬆ Back to Index](#index)***

---
<!--动态规划-->

### [509.斐波那契数](https://leetcode.cn/problems/fibonacci-number/description/)
两种方法：直接根据递归公式递归，动态规划 保存中间值 避免重复计算[Fib](src/_509_Fib.java)
- 递归，直接根据推导的公式$f(n)=f(n-1)+f(n-2),f(0)=0,f(1)=1$ 写出相应的递归代码
- 动态规划，动态规划就是将问题分解成子问题(即可以推导出递归的数学公式)，根据此，缓存中间值，避免重复计算，直到求解出最后的答案。还涉及到降维的处理，缓存中间值时通常用二维一维数组或变量，他们之间是可以降维的。

### [62.不同路径](https://leetcode.cn/problems/unique-paths/description/)
dp的解题步骤，首先就是分析出问题递归公式，本题的公式是
```text
f[i][j] = f[i - 1][j] + f[i][j - 1] f[0][j]=1 f[i][0]=1
```
然后需要一个二维数组来保存中间值按照公式编写代码即可。[UniquePaths](src/_62_UniquePaths.java)

### [64.最小路径和](https://leetcode.cn/problems/minimum-path-sum/description/)
动态规划的方法(自己解出来了)就是先推导递推公式，再找初始条件即可。本题的递推公式是
```text
dp[m][n] = Math.min(grid[m][n] + dp[m - 1][n], grid[m][n] + dp[m][n - 1]);  
初始条件是 第一行和第一列 都是直接相加的结果
然后递推找到最后一个最小值即可
```
[MinPathSum](src/_64_MinPathSum.java)

### [70.爬楼梯](https://leetcode.cn/problems/climbing-stairs/description/)
难在找递推公式，需要仔细推导，每次只能上1或2阶台阶，因此当前台阶只与前一个或前两个台阶有关，
得出递推公式为dp\[i\]=dp\[i-1\]+dp\[i-2\]确定边界条件dp\[0\]=1,dp\[1\]=1，再自己递推一下确定是否正确就可以写代码了。[ClimbStairs](src/_70_ClimbStairs.java)

### [5.最长回文子串](https://leetcode.cn/problems/longest-palindromic-substring/description/)
非常经典的二维动态规划的题目。三种解法：朴素匹配，动态规划，中心扩散[LongestPalindrome](src/_5_LongestPalindrome.java)
- 朴素匹配，两层for循环，不断的以i为起始位置，查看后面的字符是否是回文串。
- 动态规划，由于一个回文串去掉两端字符后仍然是回文串，因此定义dp\[i\]\[j\]=dp\[i + 1\]\[j - 1\] && s.charAt(i) == s.charAt(j),
即当前区间字符是否是回文串与前一个区间及其两端是否相等有关。又或者区间内只有一个字符即i==j的情况则直接是true，又或者区间内有两个或三个字符的情况则只有当s.charAt(i) == s.charAt(j)才是回文串。
但是由于计算dp\[i\]\[j\]与dp\[i+1\]\[j-1\]有关 所以外层循环的i要倒着遍历。确保在计算dp\[i\]\[j\]时 dp\[i+1\]\[j-1\]的结果已经计算出来了
- 中心扩散，即对于区间内一个字符而言或者两个字符而言，向其两端不断地扩展，判断s.charAt(i) == s.charAt(j)就能保证其一直是回文子串。


### [1143.最长公共子序列](https://leetcode.cn/problems/longest-common-subsequence/description/)
注意和最长公共子串相区分。都是一样的解法，二维动态规划
dp\[i\]\[j\]表示当前字符串text1的第i个位置和字符串text2第j个位置的最长公共子序列，列出一个表格更好理解。[LongestCommonSubsequence](src/_1143_LongestCommonSubsequence.java)


### [198.打家劫舍](https://leetcode.cn/problems/house-robber/description/)
一维动态规划的入门题。难点在于递推公式和dp的定义，这里dp定义为偷盗i个房子能获得的最大金额
[Rob](src/_198_Rob.java)

### [139.单词拆分](https://leetcode.cn/problems/word-break/description/)
使用动态规划比较好，因为最后的答案跟前面的答案有关系，即问题可以拆成很多小问题，然后定义dp\[i\]的含义表示以i位置结尾的字符串是否存在set中。  
外层for循环遍历i,内层从i开始遍历，截取i到j之间的字符串，看起是否存在于set中；如果存在则dp\[j\]=true，反之继续寻找。如果所有的i遍历完了，即字符串遍历一遍了，如果最后一个dp为true，则可以满足题意。  
[WordBreak](src/_139_WordBreak.java)


***[⬆ Back to Index](#index)***

---

<!--数据结构的设计-->

### [146.LRU缓存](https://leetcode.cn/problems/lru-cache/description/)🔞
hashMap有O(1)的存入和查找效率，但是不记录元素插入的位置，链表记录插入的位置，但是链表的查找效率不高，因此结合两者的优点使用双向链表+hashMap的组合。
使用双向链表的意义是便于删除节点，头部节点是最少使用的节点，一旦节点被使用(get)则删除该节点后，移动该节点到链表尾部(链表没有移动节点的操作，删除节点后再在新的位置插入该节点是最简单的移动节点操作)。  
链表存储两个值key和value，这样的话便于在map中根据key删除节点，map的value存储链表的节点。
难点在于几个辅助函数和删除逻辑的判断。

### [380-o1时间插入删除和获取随机元素](https://leetcode.cn/problems/insert-delete-getrandom-o1/description/)
hashmap的插入和删除是O(1)但是无法根据索引定位， 数组支持随机访问 但是插入或查找不是O(1)。
因此结合二者，hashmap用来保存值和其在数组中对应的索引，数组来保存值，用来实现getRandom()方法随机返回值。
map中的key是值，val是下标，注意数组的下标从0开始。map中保存的是**真实的下标值还是需要减1的下标值是个坑**，不一样的选择，后面操作就决定了是否要减1。
[RandomizedSet](src/_380_RandomizedSet.java)


***[⬆ Back to Index](#index)***

----

<!--技巧-->

### [136.只出现一次的数字](https://leetcode.cn/problems/single-number/)

利用异或的技巧，注意题目中，其他数均出现两次，找单值。利用异或的推理。  [SingleNumber](src/_136_SingleNumber.java)

- 0 ^ 0 = 0;
- 1 ^ 0 = 1;
- 0 ^ 1 = 1;
- 1 ^ 1 = 0;
- 0 ^ a = a; 任何数异或0 都等于其本身
- a ^ a = 0; 自己异或自己等于0
- 综合上面两个可以推出 a^b^a = b; 即三个数异或其中两个数相等则结果等于另一个数，即单值。


### [172.阶乘后的零](https://leetcode.cn/problems/factorial-trailing-zeroes/)
找特点。后面能补零的只有10，因此找到n的质因数为2或5他俩之间的最小数量即可。又因为2的数量肯定大于5的数量(一个5就包含两个2)，  
所以问题转化为找n的质因数为5的个数。
[TrailingZeroes](src/_172_TrailingZeroes.java)


***[⬆ Back to Index](#index)***

