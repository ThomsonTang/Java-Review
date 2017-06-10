package com.thomson.concurrent.pattern.ch3immutableobject;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 在使用不可变对象的情况下更新车辆的位置信息
 *
 * <p>使用状态不可变对象的位置信息模型时，如果车辆的位置发生了变动，则更新车辆的位置信息是通过替换整个表示位置信息的对象
 * (即{@link Location}实例)来实现的。</p>
 *
 * @author Thomson Tang
 * @version Created: 10/06/2017.
 */
public class VehicleTracker {
    private Map<String, Location> locationMap = new ConcurrentHashMap<>();

    public void updateLocation(String vehicleId, Location newLocation) {
        locationMap.put(vehicleId, newLocation);
    }
}
