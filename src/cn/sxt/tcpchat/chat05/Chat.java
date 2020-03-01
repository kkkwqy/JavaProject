package cn.sxt.tcpchat.chat05;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author: wqy
 * @description: javaProject:cn.sxt.tcpchat:Chat
 * 在线聊天室服务端
 * @date:2020/3/1 13:29
 **/
public class Chat {

    private static CopyOnWriteArrayList<Channel> all =  new CopyOnWriteArrayList<Channel>();

    public static void main(String[] args) throws IOException {
        System.out.println("----Server----");
        ServerSocket server = new ServerSocket(8888);
        while(true){
            Socket client = server.accept();
            System.out.println("a client has connectted!");
            //reveive message
            Channel c = new Channel(client);
            all.add(c);
            new Thread(c).start();
        }
    }
    static class Channel implements Runnable{
        private DataInputStream dis;
        private DataOutputStream dos;
        private Socket client;
        private boolean isRunning = true;
        private String username;
        public Channel(Socket client){
            this.client = client;
            try {
                dos = new DataOutputStream(client.getOutputStream());
                dis = new DataInputStream(client.getInputStream());
                isRunning = true;
                this.username = receive();
                this.send("welcome");
                this.sendOthers(this.username+"fighting",true);
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

        //send
        private void sendOthers(String msg,boolean isSys){

            boolean isPrivate = msg.startsWith("@");
            if(isPrivate){
                int idx = msg.indexOf(":");
                String targetName = msg.substring(1,idx);
                msg =  msg.substring(idx+1);
                for(Channel other:all){
                    if(other.username.equals(targetName)){
                        other.send(this.username+"对您说"+msg);
                        break;
                    }
                }
            }else{
                for(Channel other:all){
                    if(other==this){
                        continue;
                    }else{
                        if(!isSys){
                            other.send(this.username+":"+msg);
                        }else{
                            other.send(this.username+"的系统消息:"+msg);
                        }

                    }
                }
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
//                    send(msg);
                    sendOthers(msg,false);
                }
            }
        }
    }
}
