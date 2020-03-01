package cn.sxt.tcp;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * @author: wqy
 *  * 1、建立连接，使用Socket创建客户端，需要指定服务器地址和端口
 *  * 2、操作：IO流操作
 *  * 3、释放资源
 * @description: javaProject:cn.sxt.tcp:Client
 * @date:2020/3/1 10:30
 **/
public class Client {
    public static void main(String[] args) throws IOException {
//        1、建立连接，使用Socket创建客户端，需要指定服务器地址和端口
        Socket client = new Socket("localhost",8888);
//        2、操作：IO流操作
//        data流
        DataOutputStream dos = new DataOutputStream(client.getOutputStream());
        String data = "hello";
        dos.writeUTF(data);
        dos.flush();
//        3、释放资源
        dos.close();
        client.close();
    }
}
