package cn.sxt.tcpchat.chat03;

import java.io.*;
import java.net.Socket;

/**
 * @author: wqy
 * @description: javaProject:cn.sxt.tcpchat:Client
 * 在线聊天室客户端
 * 封装实现duo个客户可以正常收发多条信息。
 * @date:2020/3/1 13:29
 **/
public class TMultiClient {
    public static void main(String[] args) throws IOException {
        System.out.println("----Client----");
        Socket client = new Socket("localhost", 8888);

        new Thread(new Send(client)).start();
        new Thread(new Receive(client)).start();

    }

}
