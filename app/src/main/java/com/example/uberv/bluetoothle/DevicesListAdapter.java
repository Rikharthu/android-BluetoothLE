package com.example.uberv.bluetoothle;

import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class DevicesListAdapter extends BaseAdapter {

    private ArrayList<BluetoothDevice> mLeDevices;
    private Context mContext;

    public DevicesListAdapter(Context context) {
        super();
        mContext = context;
        mLeDevices=new ArrayList<>();
    }

    public void addDevice(BluetoothDevice device) {
        if (!mLeDevices.contains(device)) {
            mLeDevices.add(device);
            notifyDataSetChanged();
        }
    }

    public BluetoothDevice getDevice(int position) {
        return mLeDevices.get(position);
    }

    @Override
    public int getCount() {
        return mLeDevices.size();
    }

    @Override
    public Object getItem(int position) {
        return mLeDevices.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            // create new ViewHolder
            convertView = View.inflate(mContext, R.layout.list_item_device, null);
            viewHolder = new ViewHolder();
            viewHolder.deviceAddress = (TextView) convertView.findViewById(R.id.device_address);
            viewHolder.deviceName = (TextView) convertView.findViewById(R.id.device_name);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        BluetoothDevice device = mLeDevices.get(position);
        final String deviceName = device.getName();
        if (deviceName != null && deviceName.length() > 0) {
            viewHolder.deviceName.setText(deviceName);
        } else {
            viewHolder.deviceName.setText("Unknown device");
        }
        viewHolder.deviceAddress.setText(device.getAddress());

        return convertView;
    }

    static class ViewHolder {
        TextView deviceName;
        TextView deviceAddress;
    }
}
