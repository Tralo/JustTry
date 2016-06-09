package com.allwe.vv.util;

import android.util.Log;

import com.allwe.vv.config.C;

/**
 * Created by taotao on 16-6-1.
 */

public class LogUtils {


    private static boolean isLog = C.DEVELOPER_MODE;

    /**
     * 错误
     * @param tag
     * @param msg
     */
    public static void e(String tag,String msg){
        if(isLog){
            Log.e(tag, msg + "");
        }
    }

    /**
     * 信息
     * @param tag
     * @param msg
     */
    public static void i(String tag,String msg){
        if(isLog){
            Log.i(tag, msg + "");
        }
    }
    /**
     * 警告
     * @param tag
     * @param msg
     */
    public static void w(String tag,String msg){
        if(isLog){
            Log.i(tag, msg + "");
        }
    }

}
