package cn.sxt.test;

import java.util.HashMap;

/**
 * @author: wqy
 * @description: cn.sxt.test
 * @date:2020/2/25 13:27
 * @version:1.0
 **/

public class TestHashMap {

    Node[] table; //位桶数组
    int size;
    public TestHashMap(){
        table = new Node[16];//2的整数次幂

    }

    public void put(Object key, Object value){
        Node newNode = new Node();
        newNode.hash = myhash(key.hashCode(),table.length);
        newNode.key = key;
        newNode.value = value;
        newNode.next = null;
        Node temp = table[newNode.hash];
        if(temp==null){
            table[newNode.hash] = newNode;
        }else {

        }
    }
    public int myhash(int v, int length){
        System.out.println(v&(length-1));
        System.out.println(v%(length-1));
        return v&(length-1);
    }

    public static void main(String[] args) {
        TestHashMap testHashMap = new TestHashMap();
        testHashMap.put("1","a");
        testHashMap.put("2","b");
        testHashMap.put("3","c");
    }
}

class Node{
    int hash;
    Object key;
    Object value;
    Node next;

}