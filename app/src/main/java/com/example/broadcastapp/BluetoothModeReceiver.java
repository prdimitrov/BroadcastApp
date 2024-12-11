package com.example.broadcastapp;

import android.bluetooth.BluetoothAdapter;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class BluetoothModeReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction() != null && intent.getAction().equals(BluetoothAdapter.ACTION_STATE_CHANGED)) {
            int bluetoothState = intent.getIntExtra(BluetoothAdapter.EXTRA_STATE, BluetoothAdapter.ERROR);

            String msg;

            switch (bluetoothState) {
                case BluetoothAdapter.STATE_ON:
                    msg = "Bluetooth is ON";
                    break;
                case BluetoothAdapter.STATE_OFF:
                    msg = "Bluetooth is OFF";
                    break;
                case BluetoothAdapter.STATE_TURNING_ON:
                    msg = "Bluetooth is turning ON";
                    break;
                case BluetoothAdapter.STATE_TURNING_OFF:
                    msg = "Bluetooth is turning OFF";
                    break;
                default:
                    msg = "Bluetooth state is unknown";
                    break;
            }


            Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
        }
    }
}