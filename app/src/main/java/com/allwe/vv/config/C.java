package com.allwe.vv.config;

/**
 * Created by taotao on 16-6-1.
 */

public class C {
    public static final boolean DEVELOPER_MODE = true;


    public static final String IMAGE_CACHE_PATH = "vv/Cache"; // 图片缓存路径

    public interface File{


    }

    public interface NetReq{
        String BASE_URL = "";
    }

    public interface Db{
        int VERSION = 1;
    }



}
