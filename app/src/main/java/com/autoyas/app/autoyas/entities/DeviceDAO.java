package com.autoyas.app.autoyas.entities;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by link on 12/05/17.
 */

public class DeviceDAO {

    /**
     * Select all
     *
     * @return List of articles
     */
    public static List<Device> findAllFake() {
        List<Device> devices = new ArrayList<>();
        for(int i = 0; i < 10; i++){
            Device device = new Device();
            device.setName("Device n°"+i);
            devices.add(device);
        }
        return devices;
    }

    public static List<Device> findNone() {
        List<Device> devices = new ArrayList<>();
        return devices;
    }

}
