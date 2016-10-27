package com.tenkent.point.infrastructure.utility;

import com.google.gson.Gson;

/**
 * Created by Administrator on 2016/7/23.
 */
public class JsonUtility {
    public static String toJSONString(Object object) {
        Gson gSon = new Gson();
        return gSon.toJson(object);
    }
}
