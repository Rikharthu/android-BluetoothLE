package com.example.uberv.bluetoothle;

import java.util.HashMap;
import java.util.Map;

public abstract class GattAttributes {
    private static Map<String, String> attributes = new HashMap<>();
    public static final String HM10_BLUETOOTH_MODULE = "0000ffe0-0000-1000-8000-00805f9b34fb";

    static {
        attributes.put(HM10_BLUETOOTH_MODULE, "HM10 Bluetooth Adapter");
    }

    public static String lookup(String uuid, String defaultName) {
        String name = attributes.get(uuid);
        return name == null ? defaultName : name;
    }
}

