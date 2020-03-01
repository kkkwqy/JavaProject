package cn.sxt.tcpchat.chat02;

import java.io.*;
import java.net.Socket;

/**
 * @author: wqy
 * @description: javaProject:cn.sxt.tcpchat:Client
 * 在线聊天室客户端
 * 实现一个客户可以正常收发多条信息。
 * @date:2020/3/1 13:29
 **/
public class TMultiClient {
    public static void main(String[] args) throws IOException {
        System.out.println("----Client----");
        Socket client = new Socket("localhost",8888);

        //send message
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        DataOutputStream dos = new DataOutputStream(client.getOutputStream());
        DataInputStream dis = new DataInputStream(client.getInputStream());
        boolean isRunning = true;

        while(isRunning){
            String msg = br.readLine();
            dos.writeUTF(msg);
            dos.flush();
            String datas = dis.readUTF();
            System.out.println(datas);
        }

        dos.close();
        dis.close();
        client.close();
    }

}
