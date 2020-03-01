package cn.sxt.udp;

/**
 * @author: wqy
 * @description: cn.sxt.udp
 * @date:2020/2/29 17:58
 * @version:1.0
 **/
public class TalkTeacher {
    public static void main(String[] args) {
        new Thread(new TalkReceive(9999,"Student")).start();
        new Thread(new TalkSend(8888,"localhost",5555)).start();
    }
}
