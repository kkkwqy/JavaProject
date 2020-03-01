package cn.sxt.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;

/**
 * @author: wqy
 * @description: cn.sxt.udp
 * @date:2020/2/29 17:40
 * @version:1.0
 **/
public class TalkReceive implements Runnable {
    private DatagramSocket server;
    private String from;
    public TalkReceive(int port, String from) {
        this.from = from;
        try{
            server = new DatagramSocket(port);
        }catch (SocketException e){
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        while(true){
            byte[] container = new byte[1024];
            DatagramPacket packet = new DatagramPacket(container,0,container.length);
            try {
                server.receive(packet);//阻塞
                byte[] datas = packet.getData();
                int len = datas.length;
                String str = new String(datas, 0,len);
                System.out.println(from+":"+str);
                if(str.equals("bye")){
                    break;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        server.close();
    }
}
