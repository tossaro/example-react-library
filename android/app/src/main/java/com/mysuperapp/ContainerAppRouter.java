package com.mysuperapp;

import android.content.Context;
import android.content.Intent;

import androidx.annotation.NonNull;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;

public class ContainerAppRouter extends ReactContextBaseJavaModule {
    private final Context context;

    ContainerAppRouter(ReactApplicationContext context) {
        super(context);
        this.context = context.getApplicationContext();
    }

    @NonNull
    @Override
    public String getName() {
        return "ContainerAppRouter";
    }

    @ReactMethod
    public void routeToContainerApp() throws ClassNotFoundException {
        Class<?> containerClazz = Class.forName("com.example.myandroidsuperapp.MainActivity");
        Intent containerHomeIntent = new Intent(context, containerClazz);
        containerHomeIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        this.context.startActivity(containerHomeIntent);
    }
}
