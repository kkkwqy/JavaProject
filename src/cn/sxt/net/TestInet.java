package cn.sxt.net;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;

/**
 * @author: wqy
 * @description: cn.sxt.net
 * @date:2020/2/29 14:00
 * @version:1.0
 **/
public class TestInet {
    public static void main(String[] args) throws UnknownHostException {
//        InetAddress address = InetAddress.getLocalHost();
//        System.out.println(address.getHostAddress());//169.254.31.77
//        System.out.println(address.getHostName());//wqy
//
//        address = InetAddress.getByName("www.baidu.com");
//        System.out.println(address.getHostAddress());//返回百度服务器的IP
//        System.out.println(address.getHostName());//www.baidu.com


        InetSocketAddress socketAddress = new InetSocketAddress("127.0.0.1",8080);
        InetSocketAddress socketAddress1 = new InetSocketAddress("localhost",9000);
        System.out.println(socketAddress.getHostName());
        System.out.println(socketAddress1.getAddress());
    }
}
