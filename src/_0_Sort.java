import java.util.Arrays;

/**
 * @author jzy
 * @GitHub <a href="https://github.com/567jin">567jin</a>
 * @since 2024-03-18 21:22:07
 */
public class _0_Sort {

    public static void main(String[] args) {
        int[] arr = {1, 5, 9, -3, 6, 500, 200, 300};
        System.out.println("排序前：" + Arrays.toString(arr));
//        System.out.println("冒泡排序：" + Arrays.toString(bubbleSort(arr)));
//        System.out.println("选则排序：" + Arrays.toString(selectionSort(arr)));
//        System.out.println("插入排序：" + Arrays.toString(insertionSort(arr)));
//        System.out.println("归并排序：" + Arrays.toString(mergeSort(arr)));
//        quickSort(arr, 0, arr.length - 1);
//        System.out.println("快速排序：" + Arrays.toString(arr));
        System.out.println("计数排序: " + Arrays.toString(countingSort(arr)));
    }

    /**
     * 冒泡排序 时间复杂度：O(n^2)
     * 最好的时间复杂度：O(n)
     * 稳定性：不稳定
     * 排序方式：In-place
     */
    public static int[] bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {  // 外层比较次数为n-i
            boolean flag = true;  // 做优化，如果上一次没有交换，说明已经有序，直接跳出
            for (int j = 0; j < n - i; j++) {  // 内层次数为n-i
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    flag = false;
                }
            }
            if (flag) {
                break;
            }
        }
        return arr;
    }

    /**
     * 选择排序  无论如何时间复杂度都是O(n^2)
     * 稳定性：不稳定
     * 排序方式：In-place
     */
    public static int[] selectionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                int tmp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = tmp;
            }
        }
        return arr;
    }

    /**
     * 插入排序
     * 最坏：O(n^2)
     * 最好：O(n)
     * 稳定性：稳定
     * 排序方式：In-place
     */
    public static int[] insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int preIndex = i - 1;
            int current = arr[i];
            while (preIndex >= 0 && current < arr[preIndex]) {  // 当前值小于上一个值时 将上一个值往后移
                arr[preIndex + 1] = arr[preIndex];
                preIndex -= 1;
            }
            arr[preIndex + 1] = current;
        }
        return arr;
    }

    /**
     * 归并排序
     * 采用分治的思想
     */
    public static int[] mergeSort(int[] arr) {
        if (arr.length <= 1) {  // 边界条件
            return arr;
        }
        int middle = arr.length / 2;
        int[] arr_1 = Arrays.copyOfRange(arr, 0, middle);
        int[] arr_2 = Arrays.copyOfRange(arr, middle, arr.length);
        return merge(mergeSort(arr_1), mergeSort(arr_2));
    }

    /**
     * Merge two sorted arrays
     * 合并两个有序数组
     */
    public static int[] merge(int[] arr_1, int[] arr_2) {
        int[] sorted_arr = new int[arr_1.length + arr_2.length];
        int idx = 0, idx_1 = 0, idx_2 = 0;
        while (idx_1 < arr_1.length && idx_2 < arr_2.length) {
            if (arr_1[idx_1] < arr_2[idx_2]) {
                sorted_arr[idx] = arr_1[idx_1];
                idx_1 += 1;
            } else {
                sorted_arr[idx] = arr_2[idx_2];
                idx_2 += 1;
            }
            idx += 1;
        }
        // 处理剩余的元素
        if (idx_1 < arr_1.length) {
            while (idx_1 < arr_1.length) {
                sorted_arr[idx] = arr_1[idx_1];
                idx_1 += 1;
                idx += 1;
            }
        } else {
            while (idx_2 < arr_2.length) {
                sorted_arr[idx] = arr_2[idx_2];
                idx_2 += 1;
                idx += 1;
            }
        }
        return sorted_arr;
    }

    /**
     * 对给定的数组进行分区操作，使得所有小于等于基准元素的值位于基准元素的左侧，所有大于基准元素的值位于基准元素的右侧。
     *
     * @param array 待分区的数组
     * @param low   分区的起始索引
     * @param high  分区的结束索引（包含）
     * @return 基准元素最终位置的索引
     */
    public static int partition(int[] array, int low, int high) {
        int pivot = array[high];  // 选择最后一个元素作为基准元素
        int pointer = low;
        // 遍历数组，将所有小于等于基准元素的值放到基准元素的左侧
        for (int i = low; i < high; i++) {
            if (array[i] <= pivot) {
                // 交换当前元素和指针所指元素，逐步将指针向右移动
                int temp = array[i];
                array[i] = array[pointer];
                array[pointer] = temp;
                pointer++;
            }
            // 打印每次交换后的数组状态
//            System.out.println(Arrays.toString(array));
        }
        // 将基准元素放置到正确的位置上  即所有比其小的在其左边 用pointer表示有多少个元素在左边
        int temp = array[pointer];
        array[pointer] = pivot;
        array[high] = temp;
        // 返回基准元素的最终位置
        return pointer;
    }

    /**
     * 快速排序算法。
     * 该算法通过不断划分序列，将待排序数组分为较小的子序列，然后递归地对这些子序列进行排序。
     * 划分策略是选择一个基准元素，将小于基准元素的放在基准的左边，大于基准的放在基准的右边，基准元素的位置即为划分后两部分的分界点。
     * 这个过程从数组的头部和尾部开始，逐步缩小范围，直到整个数组排序完成。
     *
     * @param array 待排序的整型数组。
     * @param low   排序范围的起始下标。
     * @param high  排序范围的终止下标。
     */
    public static void quickSort(int[] array, int low, int high) {
        // 如果起始下标小于终止下标，即待排序部分不为空，则进行排序
        if (low < high) {
            // 找到划分位置，使得划分后的两部分满足左边元素均小于右边元素
            int position = partition(array, low, high);
            // 递归排序基准的左边部分
            quickSort(array, low, position - 1);
            // 递归排序基准的右边部分
            quickSort(array, position + 1, high);
        }
    }

    /**
     * Gets the maximum and minimum values in the array
     *
     * @param arr
     * @return
     */
    private static int[] getMinAndMax(int[] arr) {
        int maxValue = arr[0];
        int minValue = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > maxValue) {
                maxValue = arr[i];
            } else if (arr[i] < minValue) {
                minValue = arr[i];
            }
        }
        return new int[]{minValue, maxValue};
    }

    /**
     * Counting Sort 计数排序
     * 一种基于计数的排序算法，只能用于整数排序且范围有限。
     *
     * @param arr 待排序的整数数组
     * @return 排序后的整数数组
     */
    public static int[] countingSort(int[] arr) {
        // 如果数组长度小于2，则无需排序，直接返回
        if (arr.length < 2) {
            return arr;
        }
        // 获取数组中的最小值和最大值
        int[] extremum = getMinAndMax(arr);
        int minValue = extremum[0];
        int maxValue = extremum[1];

        // 创建计数数组，长度为最大值和最小值之差加1
        int[] countArr = new int[maxValue - minValue + 1];


        // 遍历原数组，统计每个元素出现的次数
        for (int j : arr) {
            countArr[j - minValue] += 1;
        }

        // 计算累加和，以便确定每个元素在排序后数组中的位置
        for (int i = 1; i < countArr.length; i++) {
            countArr[i] += countArr[i - 1];
        }
        /*
         * 1. 从后往前遍历原数组，将每个元素放置在正确的位置上
         * 2. 遍历计数数组，将每个元素放置在正确的位置上
         * 3. 从前往后遍历原数组，将每个元素放置在正确的位置上
         */
        int[] result = new int[arr.length];
        // 根据计数数组，将元素放置在正确的位置上
        for (int i = arr.length - 1; i >= 0; i--) {
            int idx = countArr[arr[i] - minValue] - 1;
            result[idx] = arr[i];

            // 更新计数数组 重复数 表示处理了一个了
            countArr[arr[i] - minValue] -= 1;
        }
        return result;
    }


}

