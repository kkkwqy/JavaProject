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
public class FileClient {
    public static void main(String[] args) throws IOException {
//        1、建立连接，使用Socket创建客户端，需要指定服务器地址和端口
        Socket client = new Socket("localhost",8888);

//        2、操作：文件拷贝
//        data流
        InputStream is = new BufferedInputStream(new FileInputStream("src/man.jpg"));
        OutputStream os = new BufferedOutputStream(client.getOutputStream());
        byte[] data = new byte[1024];
        int len = -1;
        while((len=is.read(data))!=-1){
            os.write(data,0,len);
        }
        os.flush();
//        3、释放资源
        os.close();
        is.close();
        client.close();
    }
}
