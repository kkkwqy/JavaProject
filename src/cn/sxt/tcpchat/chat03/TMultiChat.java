package cn.sxt.tcpchat.chat03;

import javax.rmi.CORBA.Util;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author: wqy
 * @description: javaProject:cn.sxt.tcpchat:Chat
 * 在线聊天室服务端
 * @date:2020/3/1 13:29
 **/
public class TMultiChat {
    public static void main(String[] args) throws IOException {
        System.out.println("----Server----");
        ServerSocket server = new ServerSocket(8888);
        while(true){
            Socket client = server.accept();
            System.out.println("a client has connectted!");
            //reveive message
            new Thread(new Channel(client)).start();
        }
    }
    static class Channel implements Runnable{
        private DataInputStream dis;
        private DataOutputStream dos;
        private Socket client;
        private boolean isRunning = true;
        public Channel(Socket client){
            this.client = client;
            try {
                dos = new DataOutputStream(client.getOutputStream());
                dis = new DataInputStream(client.getInputStream());
                isRunning = true;
            } catch (IOException e) {
                e.printStackTrace();
                release();
            }
        }

        //receive
        private String receive(){
            String str = "";
            try {
                str = dis.readUTF();
            } catch (IOException e) {
                e.printStackTrace();
                release();
            }
            return str;
        }
        //send
        private void send(String msg){
            try {
                dos.writeUTF(msg);
                dos.flush();
            } catch (IOException e) {
                e.printStackTrace();
                release();
            }
        }
        //release
        private void release(){
            this.isRunning = false;
            Utils.close(dis,dos,client);
        }

        @Override
        public void run() {
            while(isRunning){
                String msg = this.receive();
                if(!msg.equals("")){
                    send(msg);
                }
            }
        }
    }
}
