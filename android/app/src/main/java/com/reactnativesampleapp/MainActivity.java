package com.reactnativesampleapp;

import com.facebook.react.ReactRootView;
import com.facebook.react.ReactInstanceManager;
import com.facebook.react.ReactPackage;
import com.facebook.soloader.SoLoader;
import com.facebook.react.common.LifecycleState;

import android.app.Activity;
import android.os.Bundle;
import android.os.Build;


import java.util.List;

import com.reactnativesampleapp.PackageList;

import com.applitools.vhs.EyesUfg;

public class MainActivity extends Activity {
    private ReactRootView mReactRootView;
    private ReactInstanceManager mReactInstanceManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SoLoader.init(this, false);

        mReactRootView = new ReactRootView(this);
        List<ReactPackage> packages = new PackageList(getApplication()).getPackages();
        // Packages that cannot be autolinked yet can be added manually here, for example:
        // packages.add(new MyReactNativePackage());
        // Remember to include them in `settings.gradle` and `app/build.gradle` too.

        mReactInstanceManager = ReactInstanceManager.builder()
                .setApplication(getApplication())
                .setCurrentActivity(this)
                .setBundleAssetName("index.android.bundle")
                .setJSMainModulePath("index")
                .addPackages(packages)
                .setInitialLifecycleState(LifecycleState.RESUMED)
                .setUseDeveloperSupport(BuildConfig.DEBUG)

                .build();
        // The string here (e.g. "MyReactNativeApp") has to match
        // the string in AppRegistry.registerComponent() in index.js
        mReactRootView.startReactApplication(mReactInstanceManager, "ReactNativeSampleApp", null);

        setContentView(mReactRootView);
        EyesUfg.setup(this.getApplication(), EyesUfg.Mode.LOCAL);
    }

}
