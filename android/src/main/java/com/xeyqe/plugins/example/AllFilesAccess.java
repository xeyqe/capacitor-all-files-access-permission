package com.xeyqe.plugins.example;


import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.FileUtils;
import android.provider.Settings;

import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

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
            call.resolve();
        }
    }

    public void copyFile(PluginCall call, Context context, String source, String dest) throws IOException {
        Path destPath = getFilePath(dest);
        InputStream stream = getInputStream(context, source);
        Files.copy(
                stream,
                destPath,
                StandardCopyOption.REPLACE_EXISTING
        );
        call.resolve();
    }

    public InputStream getInputStream(Context context, String source) throws FileNotFoundException {
        return context.getContentResolver().openInputStream(Uri.parse(source));
    }

    public Path getFilePath(String path) {
        Uri u = Uri.parse(path);
        if (u.getScheme() == null || u.getScheme().equals("file")) {
            return Paths.get(u.getPath());
        }
        return null;
    }
}
