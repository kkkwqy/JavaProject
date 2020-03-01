package cn.sxt.udp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;

/**
 * @author: wqy
 * @description: cn.sxt.udp
 * @date:2020/2/29 17:39
 * @version:1.0
 **/
public class TalkSend implements Runnable {
    private DatagramSocket client;
    private BufferedReader bufferedReader;
    private String toIP;
    private int toPort;
    private int port;
    public TalkSend(int toPort, String toIP,int port){
        this.toIP = toIP;
        this.toPort = toPort;

        try{
            client = new DatagramSocket(port);
            bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        while(true){
            String data = null;
            try {
                data = bufferedReader.readLine();
                byte[] datas = data.getBytes();
                DatagramPacket packet = new DatagramPacket(datas,0,datas.length,
                        new InetSocketAddress(this.toIP, this.toPort));
                client.send(packet);
                if(data.equals("bye")){
                    break;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        client.close();
    }
}
