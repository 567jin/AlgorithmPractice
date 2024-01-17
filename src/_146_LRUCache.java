import java.util.HashMap;
import java.util.Map;

/**
 * @author jzy
 * @since 2024-01-17 14:25:16
 */
public class _146_LRUCache {
    public static void main(String[] args) {
        _146_LRUCache lruCache = new _146_LRUCache(2);
        lruCache.put(1, 1);
        lruCache.put(2, 2);
        System.out.println(lruCache.get(1));

    }

    // 一个hsahMap保存链表中的节点 用一个双向链表存储节点的key 节点的头部就是最近最少使用的key
    static class ListNode {  // 双向链表存储key
        ListNode prev;
        ListNode next;
        int key;
        int val;

        ListNode(int _key, int _val) {// 使用_key是一种约定 表明方法传参的参数名 与类的字段名作区分 当然不加也是可以的
            this.key = _key;
            this.val = _val;
        }
    }

    private ListNode tail;
    private ListNode head;
    private int capacity;
    private Map<Integer, ListNode> map;

    public _146_LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>(capacity);
        this.tail = new ListNode(-1, -1);
        this.head = new ListNode(-1, -1);
        tail.prev = head;
        head.next = tail;
    }

    public int get(int key) {
        ListNode node = map.get(key);
        if (node == null) {
            return -1;
        }
        moveToTail(node, node.val);
        return node.val;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            moveToTail(map.get(key), value);
        } else {
            if (map.size() >= capacity) {  // 删除头部节点 即head.next
                ListNode next = head.next;
                deleteNode(next);
                map.remove(next.key);
            }
            ListNode newNode = new ListNode(key, value);
            insertTail(newNode);
            map.put(key, newNode);
        }
    }

    private void moveToTail(int key, int value) {
        ListNode node = map.get(key);
        node.val = value; // 更新值

        // 插入到尾部
        tail.prev.next = node;
        node.prev = tail.prev;
        node.next = tail;
        tail.prev = node;
    }

    private void deleteNode(ListNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    /**
     * 首先删除该节点，然后将该节点插入到尾部
     *
     * @param node   待移动的节点
     * @param newVal 新值(为了处理put时key已经存在情况)
     */
    private void moveToTail(ListNode node, int newVal) {
        deleteNode(node);
        node.val = newVal;
        insertTail(node);
    }

    private void insertTail(ListNode node) {
        tail.prev.next = node;
        node.prev = tail.prev;

        node.next = tail;
        tail.prev = node;
    }

}
