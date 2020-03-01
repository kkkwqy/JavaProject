package cn.sxt.udp;

/**
 * @author: wqy
 * @description: cn.sxt.udp
 * @date:2020/2/29 17:56
 * @version:1.0
 **/
public class TalkStudent {
    public static void main(String[] args) {
        new Thread(new TalkSend(9999,"localhost",7777)).start();
        new Thread(new TalkReceive(8888,"Teacher")).start();
    }
}
