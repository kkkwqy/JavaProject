package cn.sxt.tcpchat.chat05;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * @author: wqy
 * @description: javaProject:cn.sxt.tcpchat.chat03:Send
 * @date:2020/3/1 14:42
 **/
public class Send implements Runnable {
    private BufferedReader br;
    private DataOutputStream dos;
    private Socket client;
    private boolean isRunning = true;
    private String username;
    public Send(Socket client, String username){
        this.client = client;
        this.username =  username;
        br = new BufferedReader(new InputStreamReader(System.in));
        try {
            dos = new DataOutputStream(client.getOutputStream());
            send(username);
        } catch (IOException e) {
            e.printStackTrace();
            this.release();
        }
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
        Utils.close(dos,client);
    }

    private String getStringFromConsole(){
        try {
            return br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }

    @Override
    public void run() {
        while(isRunning){
            String msg = getStringFromConsole();
            if(!msg.equals("")){
                this.send(msg);
            }
        }
    }
}
