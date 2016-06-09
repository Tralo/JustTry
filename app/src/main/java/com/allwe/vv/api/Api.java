package com.allwe.vv.api;

import android.content.Context;
import android.telephony.TelephonyManager;

import com.allwe.vv.util.LogUtils;

import net.tsz.afinal.FinalHttp;
import net.tsz.afinal.http.AjaxCallBack;
import net.tsz.afinal.http.AjaxParams;

import java.util.HashMap;
import java.util.Map;


/**
 * Created by taotao on 16-3-8.
 */
public class Api {
    private static volatile Map<String,String> headerMap = new HashMap<String,String>();
    /**
     * 用户请求接口
     * @param context
     * @param requestMap
     * @param callBack
     */
    public static void post(String url,Context context,Map<String,String> requestMap,AjaxCallBack callBack) {
        FinalHttp finalHttp = new FinalHttp();
        AjaxParams params = new AjaxParams();

        String imei = ((TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE))
                .getDeviceId();
        requestMap.put("imei",imei);
        LogUtils.i("tt",requestMap.toString());

        initRequestMap(context, params, requestMap);
        finalHttp.post(url, params, callBack);
    }

    public static void get(String url,Context context,AjaxCallBack callBack) {
        FinalHttp finalHttp = new FinalHttp();
        finalHttp.get(url,callBack);
    }


    /**
     * 初始化请求参数
     */
    private static void initRequestMap(Context context,AjaxParams params, Map<String, String>
            requestMap) {
        for(Map.Entry<String,String> entry: requestMap.entrySet()){
            params.put(entry.getKey(),entry.getValue());
        }
    }
}
