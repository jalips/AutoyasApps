package com.autoyas.app.autoyas.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import android.util.Log;

import com.autoyas.app.autoyas.BuildConfig;

/**
 * Manage internet information
 */
public class Network {

    /**
     * More simplest way to know if we got internet
     * @return boolean at true if we got internet
     */
    public static boolean isInternet(Context context) {
        ConnectivityManager connMgr = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
        return (networkInfo != null && networkInfo.isConnected());
    }

    /**
     * Method use to check which network is on
     * @return String with network name
     */
    public static String getNetworkClass(Context context) {
        TelephonyManager mTelephonyManager = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
        int networkType = mTelephonyManager.getNetworkType();

        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo info = cm.getActiveNetworkInfo();
        int type = info.getType();
        if(type == ConnectivityManager.TYPE_WIFI){
            if(BuildConfig.DEBUG) {
                Log.i("getNetworkClass", "NETWORK : Wifi");
            }
            return "Wifi";
        }

        switch (networkType) {
            case TelephonyManager.NETWORK_TYPE_GPRS:
            case TelephonyManager.NETWORK_TYPE_EDGE:
            case TelephonyManager.NETWORK_TYPE_CDMA:
            case TelephonyManager.NETWORK_TYPE_1xRTT:
            case TelephonyManager.NETWORK_TYPE_IDEN:
                if(BuildConfig.DEBUG) {
                    Log.i("getNetworkClass", "NETWORK : 2G");
                }
                return "2G";
            case TelephonyManager.NETWORK_TYPE_UMTS:
            case TelephonyManager.NETWORK_TYPE_EVDO_0:
            case TelephonyManager.NETWORK_TYPE_EVDO_A:
            case TelephonyManager.NETWORK_TYPE_HSDPA:
            case TelephonyManager.NETWORK_TYPE_HSUPA:
            case TelephonyManager.NETWORK_TYPE_HSPA:
            case TelephonyManager.NETWORK_TYPE_EVDO_B:
            case TelephonyManager.NETWORK_TYPE_EHRPD:
            case TelephonyManager.NETWORK_TYPE_HSPAP:
                if(BuildConfig.DEBUG) {
                    Log.i("getNetworkClass", "NETWORK : 3G");
                }
                return "3G";
            case TelephonyManager.NETWORK_TYPE_LTE:
                if(BuildConfig.DEBUG) {
                    Log.i("getNetworkClass", "NETWORK : 4G");
                }
                return "4G";
            default:
                if(BuildConfig.DEBUG) {
                    Log.i("getNetworkClass", "NETWORK : Unknown");
                }
                return "Unknown";
        }
    }


}
