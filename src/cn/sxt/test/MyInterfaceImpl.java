package cn.sxt.test;

public class MyInterfaceImpl implements MyInterfaceAbstract {
    @Override
    public void methodabs() {
    System.out.println("first");
}


    public static void main(String[] args) {
        MyInterfaceImpl im = new MyInterfaceImpl();
        im.methodabs();
        im.defultMethod();
        MyInterfaceAbstract.staticMethod();

    }


}
