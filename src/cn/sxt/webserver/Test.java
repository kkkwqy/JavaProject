package cn.sxt.webserver;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

/**
 * @author: wqy
 * @description: javaProject:cn.sxt.webserver:Test
 * @date:2020/3/4 12:00
 **/
//public class Test {
//    public static void main(String[] args) {
//        List nums = new ArrayList<>();
//        nums.add(5);
//        nums.add(3);
//        nums.add(1);
//        nums.add(6);
//        nums.add(0,4);
//        nums.remove(1);
//        for (int i = 0; i < nums.size() ; i++) {
//            System.out.println(nums.get(i));
//        }
//    }
//
//}


public class Test {
    public static void main(String[] args) {

        TreeSet<Integer> set = new TreeSet<Integer>();
        TreeSet<Integer> subSet = new TreeSet<Integer>();
        for(int i=606;i<613;i++){
            if(i%2==0){
                set.add(i);
            }
        }
        subSet = (TreeSet)set.subSet(608,true,611,true);
        set.add(629);
        System.out.println(set+" "+subSet);
//        System.out.println(test());

    }
    private static int test() {
        int temp = 1;
        try {
            System.out.println(temp);
            return ++temp;
        } catch (Exception e) {
            System.out.println(temp);
            return ++temp;
        } finally {
            ++temp;
            System.out.println(temp);
        }
    }
}

//
//public class Demo {
//    class Super{
//        int flag=1;
//        Super(){
//            test();
//        }
//        void test(){
//            System.out.println("Super.test() flag="+flag);
//        }
//    }
//    class Sub extends Super{
//        Sub(int i){
//            flag=i;
//            System.out.println("Sub.Sub()flag="+flag);
//        }
//        void test(){
//            System.out.println("Sub.test()flag="+flag);
//        }
//    }
//    public static void main(String[] args) {
//        new Demo().new Sub(5);
//    }
//}