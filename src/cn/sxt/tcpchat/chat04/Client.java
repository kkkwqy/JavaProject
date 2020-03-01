package cn.sxt.tcpchat.chat04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.nio.Buffer;

/**
 * @author: wqy
 * @description: javaProject:cn.sxt.tcpchat:Client
 * 在线聊天室客户端
 * 封装实现duo个客户可以正常收发多条信息。
 * @date:2020/3/1 13:29
 **/
public class Client {
    public static void main(String[] args) throws IOException {
        System.out.println("----Client----");
        BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
        System.out.println("input username");
        String username = br.readLine();
        Socket client = new Socket("localhost", 8888);

        new Thread(new Send(client,username)).start();
        new Thread(new Receive(client)).start();

    }

}
