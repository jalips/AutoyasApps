package com.autoyas.app.autoyas.Entity;

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

        List<Device> devices = new ArrayList<Device>();

        for(int i = 0; i < 10; i++){
            Device device = new Device();
            device.setName("Device n°"+i);

            devices.add(device);
        }

        return devices;
    }

}
