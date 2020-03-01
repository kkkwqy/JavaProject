package cn.sxt.tcp;

import java.io.*;
import java.net.Socket;

/**
 * 模拟登陆
 * @author: wqy
 *  * 1、建立连接，使用Socket创建客户端，需要指定服务器地址和端口
 *  * 2、操作：IO流操作
 *  * 3、释放资源
 * @description: javaProject:cn.sxt.tcp:Client
 * @date:2020/3/1 10:30
 **/
public class LoginMultiClient {
    public static void main(String[] args) throws IOException {
//        1、建立连接，使用Socket创建客户端，需要指定服务器地址和端口
        System.out.println("----ckient----");
        Socket client = new Socket("localhost",8888);
//        2、操作：IO流操作
//        data流
        new Send(client).send();
        new Receive(client).receive();
        client.close();
    }


    static class Send{
       private DataOutputStream dos;
       private Socket client;
       private BufferedReader br;
       private String msg;
       public Send(Socket client) throws IOException {
           this.client = client;
           br = new BufferedReader(new InputStreamReader(System.in));
           this.msg = init();
           try {
               dos = new DataOutputStream(client.getOutputStream());
           }catch (IOException e){
               e.printStackTrace();
           }
        }
        private String init(){

            try {
                System.out.println("input username");
                String username = br.readLine();
                System.out.println("input password");
                String password = br.readLine();
                return "username="+username+"&password="+password;
            } catch (IOException e) {
                e.printStackTrace();
                return "";
            }

        }
        public void send(){
            try {
                dos.writeUTF(msg);
                dos.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    static class Receive{
        private DataInputStream dis;
        private Socket client;
        public Receive(Socket client){
            this.client = client;
            try {
                dis = new DataInputStream(client.getInputStream());
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        public void receive(){
            try {
                String datas = dis.readUTF();
                System.out.println(datas);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
