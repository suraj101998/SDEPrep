package CodingInterview;
import java.util.HashMap;

public class LRUCache{
    static class Node{
        int key, value;
        Node prev, next;

        Node(int key, int value){
                    this.key = key;
                    this.value = value;
        }
    }

    Node head;
    Node tail;
    int N;
    int MAX;
    HashMap<Integer, Node> mMap;

    public LRUCache(int capacity){
        head = null;
        tail = null;
        MAX = capacity;
        N=0;
        mMap =new HashMap<>();
    }

    public int get(int key){
        if(N==0){
            return -1;
        }
        if(mMap.containsKey(key)){
            Node node = mMap.get(key);
            if(key == head.key){
                return node.value;
            }
            if(tail.key == key){
                tail = tail.prev;
            }
            updateAccessList(node);
            return node.value;
        }
        return -1;
    }
    public void updateAccessList(Node node){
       if(node == head){
        return;
       }
       if(node == tail){
        tail = tail.prev;
        if(tail != null){
            tail.next = null;
        }
       }
       else{
        node.prev.next = node.next;
        node.next.prev = node.prev;
       }
       node.next = head;
       node.prev = null;
       if(head != null){
        head.prev = node;
       }
       head = node;
    }

    public void put(int key, int value){
        if(mMap.containsKey(key)){
            Node node = mMap.get(key);
            node.value = value;
            return;
        }

        if(N==MAX){
            if(tail != null){
                mMap.remove(tail.key);
                tail = tail.prev;
                if(tail != null){
                    tail.next = null;
                }
                N--;
            }
        }
            Node node = new Node(key, value);
            node.next = head;
            if(head != null){
                head.prev = node;
            }
            head = node;
            if(N==0){
                tail = head;
            }
            mMap.put(key, node);
            N++;
        }

    public static void main(String[] args){
        LRUCache cache = new LRUCache(4);
        cache.put(1, 10); // cache is {1=1}
        cache.put(5, 12); // cache is {1=1, 2=2}
        System.out.println(cache.get(5));    // return 1
        cache.put(3, 3);
        // System.out.println(cache.get(2));
        System.out.println(cache.get(3));
        System.out.println(cache.get(1));
        cache.put(4, 15);
        cache.put(6, 40);
        System.out.println(cache.get(5));
    }
}