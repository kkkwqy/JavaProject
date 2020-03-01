package cn.sxt.tcpchat.chat02;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author: wqy
 * @description: javaProject:cn.sxt.tcpchat:Chat
 * 在线聊天室服务端
 * @date:2020/3/1 13:29
 **/
public class MultiChat {
    public static void main(String[] args) throws IOException {
        System.out.println("----Server----");
        ServerSocket server = new ServerSocket(8888);
        while(true){
            Socket client = server.accept();
            System.out.println("a client has connectted!");
            //reveive message
            DataInputStream dis = new DataInputStream(client.getInputStream());
            DataOutputStream dos = new DataOutputStream(client.getOutputStream());
            boolean isRunning = true;
            while(isRunning){
                String datas = dis.readUTF();
                //resend message
                dos.writeUTF(datas);
                dos.flush();

            }
            dis.close();
            dos.close();
            client.close();
        }
    }
}
