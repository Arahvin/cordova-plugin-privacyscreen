/**
 * PrivacyScreenPlugin.java Cordova Plugin Implementation
 * Created by Tommy-Carlos Williams on 18/07/14.
 * Copyright (c) 2014 Tommy-Carlos Williams. All rights reserved.
 * MIT Licensed
 */
package org.devgeeks.privacyscreen;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaWebView;
import org.apache.cordova.CallbackContext;

import android.app.Activity;
import android.view.Window;
import android.view.WindowManager;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;

/**
 * This class sets the FLAG_SECURE flag on the window to make the app
 *  private when shown in the task switcher
 */
public class PrivacyScreenPlugin extends CordovaPlugin {

  @Override
  public void initialize(CordovaInterface cordova, CordovaWebView webView) {
    super.initialize(cordova, webView);
    Activity activity = cordova.getActivity();

    if (!isDebug(activity)) {
      activity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_SECURE);
    }
  }

  @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        if (action.equals("setStatus")) {
            boolean enable = args.getBoolean(0); // get the boolean value from JavaScript
            setStatus(enable);
            callbackContext.success();
            return true;
        }
        return false;
    }

  private boolean isDebug(Activity activity) {
    try {
      Class<?> buildConfigClass = Class.forName(activity.getPackageName() + ".BuildConfig");
      return (boolean)buildConfigClass.getField("DEBUG").get(null);
    }
    catch (Exception e) {
      Log.w("PrivacyScreenPlugin", e);
      return false;
    }
  }

  private void setStatus(boolean enable) {
        Activity activity = this.cordova.getActivity();
        if (enable) {
            activity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_SECURE);
        } else {
            activity.getWindow().clearFlags(WindowManager.LayoutParams.FLAG_SECURE);
        }
    }
}

