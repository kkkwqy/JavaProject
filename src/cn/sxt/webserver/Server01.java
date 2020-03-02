package cn.sxt.webserver;

import cn.sxt.tcp.Server;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author: wqy
 * 使用serversocket建立与浏览器的连接，获取请求协议
 * @description: javaProject:cn.sxt.webserver:Server01
 * @date:2020/3/2 13:46
 **/
public class Server01 {
    private ServerSocket serverSocket = null;
    public static void main(String[] args) {
        Server01  server01 = new Server01();
        server01.start();

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
            Socket client = serverSocket.accept();
            System.out.println("一个客户端建立了连接:");
            InputStream is = client.getInputStream();
            byte[] datas = new byte[1024*1024];
            int len = is.read(datas);
            String requestInfo = new String(datas,0,len);
            System.out.println(requestInfo);
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
