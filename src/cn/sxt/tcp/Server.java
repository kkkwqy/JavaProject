package cn.sxt.tcp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author: wqy
 * 1、指定端口，使用ServerSocket创建服务器
 * 2、阻塞式等待连接accept
 * 3、操作：IO流操作
 * 4、释放资源
 * @description: javaProject:cn.sxt.tcp:Server
 * @date:2020/3/1 10:24
 **/
public class Server {
    public static void main(String[] args) throws IOException {
//        1、指定端口，使用ServerSocket创建服务器
        ServerSocket serverSocket = new ServerSocket(8888);
//        2、阻塞式等待连接accept
        Socket client = serverSocket.accept();
        System.out.println("one client accepted");
//        3、操作：IO流操作
        client.getInputStream();
        DataInputStream dis = new DataInputStream(client.getInputStream());
        String data =  dis.readUTF();
        System.out.println(data);
//        4、释放资源
        dis.close();
        client.close();
    }
}
