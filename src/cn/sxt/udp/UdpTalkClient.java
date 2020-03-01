package cn.sxt.udp;

import java.awt.image.BufferStrategy;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

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
public class UdpTalkClient {
    public static void main(String[] args) throws Exception {
        System.out.println("send");
        DatagramSocket client = new DatagramSocket(8888);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            String data = bufferedReader.readLine();
            byte[] datas = data.getBytes();
            DatagramPacket packet = new DatagramPacket(datas,0,datas.length,
                    new InetSocketAddress("localhost",9999));
            client.send(packet);
            if(data.equals("bye")){
                break;
            }
        }
        client.close();
    }

}
