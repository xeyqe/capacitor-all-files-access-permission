package com.xeyqe.plugins.example;

import android.net.Uri;

import com.getcapacitor.JSObject;
import com.getcapacitor.Plugin;
import com.getcapacitor.PluginCall;
import com.getcapacitor.PluginMethod;
import com.getcapacitor.annotation.CapacitorPlugin;

import java.io.IOException;

@CapacitorPlugin(name = "AllFilesAccess")
public class AllFilesAccessPlugin extends Plugin {

    private final AllFilesAccess implementation = new AllFilesAccess();

    @PluginMethod
    public void access(PluginCall call) {
        implementation.access(call, getContext());
    }

    @PluginMethod
    public void copyFile(PluginCall call) {
        String source = call.getString("sourceUri");
        String dest = call.getString("destinationUri");
        try {
            implementation.copyFile(call, getContext(), source, dest);
        } catch (IOException e) {
            call.reject(e.getLocalizedMessage());
        }
    }
}
