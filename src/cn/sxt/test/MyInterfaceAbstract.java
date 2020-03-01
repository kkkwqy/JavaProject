package cn.sxt.test;

public interface MyInterfaceAbstract {
    //常量 public static final int num=10;


    //抽象方法
    public abstract void methodabs();


    //默认方法 default====新添加的方法
    public default void defultMethod(){
        System.out.println("新添加的默认方法");
    }


    //静态方法
    public static void staticMethod(){
        System.out.println("静态方法");
    }

//    //私有方法
//    private void method(){
//
//    }
//    private static void method2(){}


}

