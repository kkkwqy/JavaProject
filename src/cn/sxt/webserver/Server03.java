package cn.sxt.webserver;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

/**
 * @author: wqy
 * 封装相应信息
 * @description: javaProject:cn.sxt.webserver:Server02
 * @date:2020/3/2 14:37
 **/
public class Server03 {
    private ServerSocket serverSocket = null;
    public static void main(String[] args) {
        Server03 server02 = new Server03();
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

            Response response = new Response(client);


            StringBuilder content = new StringBuilder();
            response.print("<html>");
            response.print("<head>");
            response.print("<title>");
            response.print("服务器响应成功");
            response.print("</title>");
            response.print("<head>");
            response.print("<body>");
            response.print("响应体内容");
            response.print("</body>");
            response.print("</html>");
            response.pushToBrowser(200);
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
