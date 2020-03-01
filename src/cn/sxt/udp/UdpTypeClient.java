package cn.sxt.udp;

import com.sun.xml.internal.ws.util.pipe.StandaloneTubeAssembler;

import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

/**
 * @author: wqy
 * @description: cn.sxt.udp
 * @date:2020/2/29 16:08
 * @version:1.0
 *  DatagramSocket
 *  基本类型-》字节数组数据
 *  DatagramPocket
 *  send
 *  release resource
 *  *
 **/
//发送端
public class UdpTypeClient {
    public static void main(String[] args) throws Exception {
        System.out.println("send");
        DatagramSocket client = new DatagramSocket(8888);
        String data = "hello virus!";

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(baos));
        dos.writeUTF("测试数据转换为字节数组");
        dos.writeInt(18);
        dos.writeBoolean(false);
        dos.writeChar('a');
        dos.flush();
        byte[] datas = baos.toByteArray();
        System.out.println(datas.length);


        DatagramPacket packet = new DatagramPacket(datas,0,datas.length,
                new InetSocketAddress("localhost",9999));
        client.send(packet);
        client.close();
    }

}
