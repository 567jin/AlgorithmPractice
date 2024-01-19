import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author jzy
 * @since 2024-01-19 8:45:52
 */
public class _380_RandomizedSet {
    Map<Integer, Integer> numToLocation;  // hashmap的插入和删除是O(1)但是无法根据索引定位 其用来保存值和数组中对应的下标
    List<Integer> nums;  // nums支持随机访问 但是插入或查找不是O(1)


    public _380_RandomizedSet() {
        this.numToLocation = new HashMap<>();
        nums = new ArrayList<>();
    }

    public boolean insert(int val) {
        if (numToLocation.containsKey(val)) {  // 集合中存在该元素
            return false;
        }
        // 下面的添加顺序反了的话 map中的val就需要是nums.size()-1了
        numToLocation.put(val, nums.size());  // 放入的就是数组下标值
        nums.add(val);
        return true;
    }

    public boolean remove(int val) {
        if (!numToLocation.containsKey(val)) {
            return false;
        }
        // 获取待删除值的索引 和尾部元素值
        Integer index = numToLocation.get(val);
        Integer tail = nums.get(nums.size() - 1);
        nums.set(index, tail); // 用尾部元素值覆盖待删除元素

        // 在map中更新尾部索引为待删除值的索引index
        numToLocation.put(tail, index);

        // 删除尾部元素
        nums.remove(nums.size() - 1);
        numToLocation.remove(val);  // 删除map中的该值

        return true;
    }

    public int getRandom() {
        return nums.get((int) (Math.random() * nums.size()));
    }
}


