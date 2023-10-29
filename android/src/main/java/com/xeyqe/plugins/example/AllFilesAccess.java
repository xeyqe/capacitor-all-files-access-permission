package com.xeyqe.plugins.example;


import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.provider.Settings;

import com.getcapacitor.PluginCall;

public class AllFilesAccess {

    public void access(PluginCall call, Context context) {
        if(android.os.Build.VERSION.SDK_INT >= 30) {
            if (Environment.isExternalStorageManager()) {
                call.resolve();
            } else {
                Uri uri = Uri.parse("package:" + context.getPackageName());
                Intent intent = new Intent(Settings.ACTION_MANAGE_APP_ALL_FILES_ACCESS_PERMISSION, uri);
                context.startActivity(intent);
                call.resolve();
            }
        } else {
            call.unavailable("Available from sdk version 30");
        }

    }

}
