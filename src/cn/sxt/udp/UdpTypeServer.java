package cn.sxt.udp;

import com.sun.media.jfxmediaimpl.HostUtils;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.DataInput;
import java.io.DataInputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * @author: wqy
 * @description: cn.sxt.udp
 * @date:2020/2/29 16:07
 * @version:1.0
 * 接收端
 * DatagramSocket
 * DatagramPacket
 * Receive
 * analysis 字节数组-》对应类型
 * release resource
 *
 **/

public class UdpTypeServer {
    public static void main(String[] args) throws Exception {
        System.out.println("receive");
        DatagramSocket server = new DatagramSocket(9999);
        byte[] container = new byte[1024];
        DatagramPacket packet = new DatagramPacket(container,0,container.length);
        server.receive(packet);//阻塞
        byte[] datas = packet.getData();
        int len = datas.length;

        DataInputStream dis = new DataInputStream(new BufferedInputStream(new ByteArrayInputStream(datas)));
        String msg = dis.readUTF();
        int age = dis.readInt();
        boolean flag = dis.readBoolean();
        char ch = dis.readChar();
        System.out.println(msg);

        server.close();

    }
}
