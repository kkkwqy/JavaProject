package cn.sxt.tcp;

import java.io.*;
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
public class FileServer {
    public static void main(String[] args) throws IOException {
//        1、指定端口，使用ServerSocket创建服务器
        ServerSocket serverSocket = new ServerSocket(8888);

//        2、阻塞式等待连接accept
        Socket client = serverSocket.accept();
        System.out.println("one client accepted");
//        3、操作：IO流操作
        InputStream is = new BufferedInputStream(client.getInputStream());
        OutputStream os = new BufferedOutputStream(new FileOutputStream("src/mancopy.jpg"));
        byte[] data = new byte[1024];
        int len = -1;
        while((len=is.read(data))!=-1){
            os.write(data,0,len);
        }
        os.flush();
//        4、释放资源
        os.close();
        is.close();
        client.close();
        serverSocket.close();
    }
}
