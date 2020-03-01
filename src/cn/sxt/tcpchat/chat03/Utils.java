package cn.sxt.tcpchat.chat03;

import java.io.Closeable;
import java.io.IOException;

/**
 * @author: wqy
 * @description: javaProject:cn.sxt.tcpchat.chat03:Utils
 * @date:2020/3/1 14:17
 **/
public class Utils {

    /**
     * release
     */
    public static void close(Closeable... targets){
        for(Closeable target:targets){
            try{
                if(null!=target){
                    target.close();
                }
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }
}
