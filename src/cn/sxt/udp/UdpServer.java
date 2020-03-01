package cn.sxt.udp;

import javax.xml.crypto.Data;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * @author: wqy
 * @description: cn.sxt.udp
 * @date:2020/2/29 16:07
 * @version:1.0
 * 接收端
 * DatagramSocket
 * DatagramPacket
 * Receive
 * analysis
 * release resource
 *
 **/

public class UdpServer {
    public static void main(String[] args) throws Exception {
        System.out.println("receive");
        DatagramSocket server = new DatagramSocket(9999);
        byte[] container = new byte[1024];
        DatagramPacket packet = new DatagramPacket(container,0,container.length);
        server.receive(packet);//阻塞
        byte[] datas = packet.getData();
        int len = datas.length;
        System.out.println(new String(datas, 0,len));
        server.close();
    }
}
