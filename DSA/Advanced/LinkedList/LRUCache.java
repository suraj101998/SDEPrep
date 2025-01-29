package DSA.Advanced.LinkedList;
/*
 * Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and set.
get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
set(key, value) - Set or insert the value if the key is not already present. When the cache reaches its capacity, it should invalidate the least recently used item before inserting the new item.
The LRUCache will be initialized with an integer corresponding to its capacity. Capacity indicates the maximum number of unique keys it can hold at a time.
Definition of "least recently used" : An access to an item is defined as a get or a set operation of the item. "Least recently used" item is the one with the oldest access time.
NOTE: If you are using any global variables, make sure to clear them in the constructor.

Example :
Input : 
         capacity = 2
         set(1, 10)
         set(5, 12)
         get(5)        returns 12
         get(1)        returns 10
         get(10)       returns -1
         set(6, 14)    this pushes out key = 5 as LRU is full. 
         get(5)        returns -1 
 */

import java.util.*;
public class LRUCache {
    static class Node {
        int key;
        int val;
        Node prev, next;
        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
    Node head;
    Node tail;
    int N;
    int MAX;
    HashMap<Integer, Node> mMap;
    public void updateAccessList(Node node){
        Node temp = node.prev;
        temp.next = node.next;
        temp = node.next;
        if (temp != null)
            temp.prev = node.prev;   
        node.next = head;
        head.prev = node;
        node.prev = null;
        head = node;
    }  
    public LRUCache(int capacity) {
        head = null;
        tail = null;
        MAX = capacity;
        N = 0;
        mMap = new HashMap<>();
    }
    public int get(int key) {
        if (N == 0)
            return -1;   
        if (mMap.containsKey(key)) {
            Node node = mMap.get(key);           
            if (key == head.key) {
                return node.val;
            }
            if (tail.key == key) {
                tail = tail.prev;
            }         
            updateAccessList(node);
            return node.val;
        }
        return -1;
    }
    public void set(int key, int value) {   
        if (mMap.containsKey(key)) {
            Node node = mMap.get(key);
            if (node.key == head.key) {
                node.val = value;
                return;
            }
            if (tail.key == key) {
                tail = tail.prev;
            }
            updateAccessList(node);
            node.val = value;
            return;
        }
        if (N == MAX) {
            if (tail != null) {
                mMap.remove(tail.key);
                tail = tail.prev;       
                if (tail != null) {
                    tail.next.prev = null;
                    tail.next = null;
                }
                N--;
            }
        }
        Node node = new Node(key, value);
        node.next = head;
        if (head != null)
            head.prev = node;
        head = node;
        N++;
        if (N == 1)
            tail = head;
        mMap.put(key, node);    
    }
}
