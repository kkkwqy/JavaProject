package cn.sxt.tcp;

import java.io.*;
import java.net.Socket;

/**
 * 模拟登陆
 * @author: wqy
 *  * 1、建立连接，使用Socket创建客户端，需要指定服务器地址和端口
 *  * 2、操作：IO流操作
 *  * 3、释放资源
 * @description: javaProject:cn.sxt.tcp:Client
 * @date:2020/3/1 10:30
 **/
public class LoginTwoClient {
    public static void main(String[] args) throws IOException {
//        1、建立连接，使用Socket创建客户端，需要指定服务器地址和端口
        Socket client = new Socket("localhost",8888);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("input username");
        String username = br.readLine();
        System.out.println("input password");
        String password = br.readLine();

//        2、操作：IO流操作
//        data流
        DataOutputStream dos = new DataOutputStream(client.getOutputStream());
        dos.writeUTF("username="+username+"&password="+password);
        dos.flush();

        DataInputStream dis = new DataInputStream(client.getInputStream());
        String datas = dis.readUTF();
        System.out.println(datas);
//        3、释放资源
        dos.close();
        client.close();
    }
}
