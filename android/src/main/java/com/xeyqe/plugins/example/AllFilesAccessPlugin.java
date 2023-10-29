package com.xeyqe.plugins.example;

import com.getcapacitor.JSObject;
import com.getcapacitor.Plugin;
import com.getcapacitor.PluginCall;
import com.getcapacitor.PluginMethod;
import com.getcapacitor.annotation.CapacitorPlugin;

@CapacitorPlugin(name = "AllFilesAccess")
public class AllFilesAccessPlugin extends Plugin {

    private final AllFilesAccess implementation = new AllFilesAccess();

    @PluginMethod
    public void access(PluginCall call) {
        implementation.access(call, getContext());
    }
}
