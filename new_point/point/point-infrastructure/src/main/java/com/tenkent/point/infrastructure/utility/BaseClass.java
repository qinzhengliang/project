package com.tenkent.point.infrastructure.utility;

import com.google.gson.Gson;

import java.util.List;
import java.util.Map;

/**
 * Created by 6418000384 on 2016/7/18.
 */
public class BaseClass {

    private Gson mGson = new Gson();

    //实现对象到json的转换
    protected String ConvertObjectToJson(Object object) {
        return mGson.toJson(object);
    }

    /***
     * 根据KEY值获取MAP中的对应数据并转化成Long类型
     * @param map
     * @param key
     * @return
     */
    public Long getMapLong(Map map, String key) {
        return (map.get(key) == null || StringUtility.isEmpty(String.valueOf(map.get(key)))) ? null : Long.parseLong(String.valueOf(map.get(key)));
    }

    /***
     * 根据KEY值获取MAP中的对应数据并转化成String类型
     * @param map
     * @param key
     * @return
     */
    public String getMapString(Map map, String key) {
        return (map.get(key) == null || StringUtility.isEmpty(String.valueOf(map.get(key)))) ? null : String.valueOf(map.get(key));
    }

    /***
     * 根据KEY值获取MAP中的对应数据是否为空
     * @param map
     * @param key
     * @return
     */
    public boolean isMapKeyNull(Map map, String key) {
        return map.get(key) == null || map.get(key) == "";
    }

    /***
     * 根据KEY值获取MAP中的对应数据并转化成String的List
     * @param map
     * @param key
     * @return
     */
    public List<String> getMapStringList(Map map, String key) {
        if (!this.isMapKeyNull(map, key)) {
            return (List<String>) map.get(key);
        }
        return null;
    }

    public boolean isListNull(List<String> list) {
        if (list == null) {
            return true;
        }
        if (list.size() <= 0) {
            return true;
        }
        if (list.size() == 1 && StringUtility.isEmpty(list.get(0))) {
            return true;
        }
        return false;
    }
}
