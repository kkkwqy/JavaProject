package cn.sxt.tcpchat.chat03;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * @author: wqy
 * @description: javaProject:cn.sxt.tcpchat.chat03:reveive
 * @date:2020/3/1 14:42
 **/
public class Receive implements Runnable {
    private DataInputStream dis = null;
    private boolean isRunning = true;
    private Socket client;
    public Receive(Socket client){
        this.client = client;
        try {
            dis = new DataInputStream(client.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
            release();
        }
    }
    //release
    private void release(){
        this.isRunning = false;
        Utils.close(dis,client);
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

    @Override
    public void run() {
        while(isRunning){
            String msg = receive();
            if(!msg.equals("")){
                System.out.println(msg);
            }
        }
    }
}
