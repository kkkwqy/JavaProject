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
public class LoginTwoServer {
    public static void main(String[] args) throws IOException {
//        1、指定端口，使用ServerSocket创建服务器
        ServerSocket serverSocket = new ServerSocket(8888);
        String username = "";
        String password = "";
//        2、阻塞式等待连接accept
        Socket client = serverSocket.accept();
        System.out.println("one client accepted");
//        3、操作：IO流操作
        client.getInputStream();
        DataInputStream dis = new DataInputStream(client.getInputStream());
        String datas = dis.readUTF();
        String[] data = datas.split("&");
        for(String str : data){
            String[] userInfo = str.split("=");
//            System.out.println(userInfo[0]+"-->"+userInfo[1]);
            if(userInfo[0].equals("username")){
                username = userInfo[1];
            }else if(userInfo[0].equals("password")){
                password = userInfo[1];
            }
        }
        System.out.println(username+password);
        DataOutputStream dos = new DataOutputStream(client.getOutputStream());
        if(username.equals("wqy")&&password.equals("111")){
            dos.writeUTF("login successful");
        }else {
            dos.writeUTF("login fail");
        }
        dos.flush();
//        4、释放资源
        dis.close();
        client.close();
    }
}
