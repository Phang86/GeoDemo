package com.example.myapplication.utils;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.util.Log;

import java.security.SecureRandom;
import java.util.UUID;

public class UuidUtil {
    //UUID+设备号序列号 唯一识别码
    public static String getMyUUID(){
        UUID uuid = UUID.randomUUID();
        String uniqueId = uuid.toString();
        Log.e("debug","UUID----->"+uuid);
        return uniqueId;
    }



}
