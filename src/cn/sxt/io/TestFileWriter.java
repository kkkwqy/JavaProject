package cn.sxt.io;

import java.io.*;

/**
 * @author: wqy
 * @description: cn.sxt.io
 * @date:2020/2/27 10:09
 * @version:1.0
 **/
public class TestFileWriter {
    public static void main(String[] args) {
        File src = new File("src/cn/sxt/io/a.txt");
        File dest = new File("src/cn/sxt/io/b.txt");
        Writer writer = null;
        try{
            writer = new FileWriter(dest);
            char[] flush = new char[1024];
            int len = -1;
//            while((len=writer.write(flush))!=-1){
//                String str = new String(flush,0,len);
//                System.out.println(str);
//            }
            String tt = "sdfdsf第三方看来";
            char[] datas = tt.toCharArray();
            writer.write(datas,0,datas.length);
        }catch (FileNotFoundException e){

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try{
                if(writer!=null){
                    writer.close();
                }
            }catch (IOException e){

            }
        }
    }
}
