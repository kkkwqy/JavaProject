package cn.sxt.io;

import java.io.*;

/**
 * @author: wqy
 * @description: cn.sxt.io
 * @date:2020/2/27 9:57
 * @version:1.0
 **/
public class FileCopy {
    public static void main(String[] args) {
        File src = new File("src/cn/sxt/io/a.txt");
        File dest = new File("src/cn/sxt/io/b.txt");
        FileInputStream is = null;
        FileOutputStream os = null;
        try{
            is = new FileInputStream(src);
            os = new FileOutputStream(dest);
            byte[] flush = new byte[1024];
            int len = -1;
            while((len=is.read(flush))!=-1){
                os.write(flush,0,len);
            }
            os.flush();
        }catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try{
                if(null!=os) {
                    os.close();
                }
            }catch (IOException e){
                e.printStackTrace();
            }
            try{
                if(null!=is) {
                    is.close();
                }
            }catch (IOException e){
                e.printStackTrace();
            }


        }
    }
}
