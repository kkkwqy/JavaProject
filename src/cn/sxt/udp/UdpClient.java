package cn.sxt.udp;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;

/**
 * @author: wqy
 * @description: cn.sxt.udp
 * @date:2020/2/29 16:08
 * @version:1.0
 *  DatagramSocket
 *  字节数组数据
 *  DatagramPocket
 *  send
 *  release resource
 *  *
 **/
//发送端
public class UdpClient {
    public static void main(String[] args) throws Exception {
        System.out.println("send");
        DatagramSocket client = new DatagramSocket(8888);
        String data = "hello virus!";
        byte[] datas = data.getBytes();
        DatagramPacket packet = new DatagramPacket(datas,0,datas.length,
                new InetSocketAddress("localhost",9999));
        client.send(packet);
        client.close();
    }

}
