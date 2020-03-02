package cn.sxt.webserver;

import java.awt.image.CropImageFilter;
import java.io.*;
import java.net.ContentHandler;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

/**
 * @author: wqy
 * @description: javaProject:cn.sxt.webserver:Server02
 * @date:2020/3/2 14:37
 **/
public class Server02 {
    private ServerSocket serverSocket = null;
    public static void main(String[] args) {
        Server02  server02 = new Server02();
        server02.start();

//        server01.stop();
    }

    /**
     * 启动服务
     */
    public void start(){
        try {
            serverSocket = new ServerSocket(8888);
            reveive();

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("启动服务器失败");
        }

    }

    /**
     *接受连接处理
     */
    public void reveive(){
        try {
            //获取请求协议
            Socket client = serverSocket.accept();
            System.out.println("一个客户端建立了连接:");
            InputStream is = client.getInputStream();
            byte[] datas = new byte[1024*1024];
            int len = is.read(datas);
            String requestInfo = new String(datas,0,len);
            System.out.println(requestInfo);

            StringBuilder content = new StringBuilder();
            content.append("<html>");
            content.append("<head>");
            content.append("<title>");
            content.append("服务器响应成功");
            content.append("</title>");
            content.append("<head>");
            content.append("<body>");
            content.append("响应体内容");
            content.append("</body>");
            content.append("</html>");
            int size = content.toString().getBytes().length;

            StringBuilder response = new StringBuilder();
            String blank = " ";
            String CRLF = "\r\n";



            //返回数据
            //1、响应行
            response.append("HTTP/1.1").append(blank)
                    .append("200").append(blank)
                    .append("OK").append(CRLF);
//            2、响应头 最后一行存在空行
            response.append("Date:").append(new Date()).append(CRLF);
            response.append("Server:shsxt Server/0.0.1;charset=GBK").append(CRLF);
            response.append("Content-type:text/html").append(CRLF);
            response.append("Content-length:").append(size).append(CRLF);
            response.append(CRLF);
            //3、正文
            response.append(content.toString());
//         写出到客户端
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
            bw.write(response.toString());
            bw.flush();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("客户端错误！");
        }

    }

    /**
     * 停止服务
     *
     */
    public void stop(){

    }


}
