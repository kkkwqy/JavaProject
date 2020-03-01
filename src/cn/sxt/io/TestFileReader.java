package cn.sxt.io;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.io.*;

/**
 * @author: wqy
 * @description: cn.sxt.io
 * @date:2020/2/27 10:09
 * @version:1.0
 **/
public class TestFileReader {
    public static void main(String[] args) {
        File src = new File("src/cn/sxt/io/a.txt");
        Reader rd = null;
        try{
            rd = new FileReader(src);
            char[] flush = new char[1024];
            int len = -1;
            while((len=rd.read(flush))!=-1){
                String str = new String(flush,0,len);
                System.out.println(str);
            }
        }catch (FileNotFoundException e){

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try{
                if(rd!=null){
                    rd.close();
                }
            }catch (IOException e){

            }
        }
    }
}
