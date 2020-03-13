package cn.sxt.webserver;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Date;
import java.util.concurrent.BlockingDeque;

/**
 * @author: wqy
 * @description: javaProject:cn.sxt.webserver:Response
 * @date:2020/3/3 11:46
 **/
public class Response {
    private BufferedWriter bw;
    private StringBuilder content;
    private StringBuilder headInfo;
    private int len;
    private final String BLANK = " ";
    private String CRLF = "\r\n";

    private Response(){
        content = new StringBuilder();
        headInfo = new StringBuilder();
        len = 0;

    }
    public Response(Socket client){
        this();
        try {
            bw = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
        } catch (IOException e) {
            e.printStackTrace();
            headInfo = null;

        }
    }
    public Response(OutputStream outputStream){
        this();
        bw =  new BufferedWriter(new OutputStreamWriter(outputStream));
    }

    public Response print(String info){
        content.append(info);
        len += info.getBytes().length;
        return this;
    }
    public Response println(String info){
        content.append(info).append(CRLF);
        len += (info+CRLF).getBytes().length;
        return this;
    }
    //推送头信息
    public void pushToBrowser(int code){
        if(null == headInfo){
            code = 505;
        }
        createHeadInfo(code);
        try {
            bw.append(headInfo);
            bw.append(content);
            bw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    //构建头信息
    private void createHeadInfo(int code){
        headInfo.append("HTTP/1.1").append(BLANK)
                .append("200").append(BLANK);

        switch (code){
            case 200:
                headInfo.append("OK").append(CRLF);
                break;
            case 404:
                headInfo.append("NOT FOUND").append(CRLF);
                break;
            case 505:
                headInfo.append("SERVER ERROR").append(CRLF);
                break;
        }
        headInfo.append("Date:").append(new Date()).append(CRLF);
        headInfo.append("Server:shsxt Server/0.0.1;charset=GBK").append(CRLF);
        headInfo.append("Content-type:text/html").append(CRLF);
        headInfo.append("Content-length:").append(len).append(CRLF);
        headInfo.append(CRLF);
        //3、正文
        headInfo.append(content.toString());

    }
}

