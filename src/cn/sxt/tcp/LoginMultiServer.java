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
public class LoginMultiServer {
    public static void main(String[] args) throws IOException {
//        1、指定端口，使用ServerSocket创建服务器
        ServerSocket serverSocket = new ServerSocket(8888);
        boolean isRunning = true;
//        2、阻塞式等待连接accept
        while(isRunning){
            Socket client = serverSocket.accept();
            System.out.println("one client accepted");
            new Thread(new Channel(client)).start();
        }
        serverSocket.close();
    }

    static class Channel implements Runnable{
        private Socket client;
        private DataInputStream dis;
        private DataOutputStream dos;
        public Channel(Socket client){
            this.client = client;
            try{
                dis = new DataInputStream(client.getInputStream());
                dos = new DataOutputStream(client.getOutputStream());
            }catch (IOException e){
                e.printStackTrace();
                release();
            }

        }

        private String receive(){
            String datas = "";
            try{
                datas = dis.readUTF();
            }catch (IOException e){
                e.printStackTrace();
            }
            return datas;
        }
        private void send(String msg){
            try {
                dos.writeUTF(msg);
                dos.flush();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
        private void release(){
            try{
                if(null!=dos){
                    dos.close();
                }
            }catch (IOException e){
                e.printStackTrace();
            }
            try{
                if(null!=dis){
                    dis.close();
                }
            }catch (IOException e){
                e.printStackTrace();
            }
            try{
                if(null!=client){
                    client.close();
                }
            }catch (IOException e){
                e.printStackTrace();
            }
        }
        @Override
        public void run() {
//        3、操作：IO流操作
            try {
                client.getInputStream();
                String username = "";
                String password = "";
                String[] data = receive().split("&");

                for(String str : data){
                    String[] userInfo = str.split("=");
                    if(userInfo[0].equals("username")){
                        username = userInfo[1];
                    }else if(userInfo[0].equals("password")){
                        password = userInfo[1];
                    }
                }
                System.out.println(username+password);
                if(username.equals("wqy")&&password.equals("111")){
                    send("login successful");
                }else {
                    send("login fail");
                }
//                4、释放资源
                release();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }


}
