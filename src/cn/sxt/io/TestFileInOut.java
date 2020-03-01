package cn.sxt.io;

import com.sun.javafx.runtime.SystemProperties;

import java.io.*;
import java.util.Properties;

/**
 * @author: wqy
 * @description: cn.sxt.io
 * @date:2020/2/27 9:34
 * @version:1.0
 **/
public class TestFileInOut {
    public static void main(String[] args) {
        System.out.println(System.getProperty("user.dir"));
        File src = new File("src/cn/sxt/io/a.txt");
        File dest = new File("src/cn/sxt/io/b.txt");
        InputStream inputStream = null;

        OutputStream outputStream = null;

        try{
//            inputStream = new FileInputStream(src);
//            byte[] car = new byte[5];
//            int len = -1;
//            while((len = inputStream.read(car))!=-1){
//                String str = new String(car,0,len);
//                System.out.println(str);
//            }
            outputStream = new FileOutputStream(dest);
            String msg = "ioadjifajsdf";
            byte[] datas = msg.getBytes();
            outputStream.write(datas,0,datas.length);
            outputStream.flush();
        }catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try{
                if(null!=outputStream){
                    outputStream.close();
                }
            }catch (IOException e){
                e.printStackTrace();
            }

        }

    }
}
