package com.edsonhoraciojunior.verifyautomaticdatetimezone;

import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaWebView;
import org.apache.cordova.CallbackContext;
import org.json.JSONArray;
import org.json.JSONException;

import android.app.Activity;
import android.content.Context;
import android.provider.Settings;
import android.os.Build;

public class VerifyAutomaticDateTimeZone extends CordovaPlugin {
    public static final String TAG = "VerifyAutomaticDateTimeZone";

    /**
     * Constructor.
     */
    public VerifyAutomaticDateTimeZone() {
    }

    /**
     * Sets the context of the Command.
     *
     * @param cordova The context of the main Activity.
     * @param webView The CordovaWebView Cordova is running in.
     */
    public void initialize(CordovaInterface cordova, CordovaWebView webView) {
        super.initialize(cordova, webView);

        Log.d(TAG, "Initializing VerifyAutomaticDateTimeZone Plugin");
    }

    /**
     * Executes the request and returns PluginResult.
     *
     * @param action            The action to execute.
     * @param args              JSONArry of arguments for the plugin.
     * @param callbackContext   The callback id used when calling back into JavaScript.
     * @return                  True if the action was valid, false if not.
     */
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        if ("isAutomaticChecked".equals(action)) {
            boolean result = this.isAutomaticChecked();
            callbackContext.success(result);
        } else {
            return false;
        }
        return true;
    }

    private static boolean isAutomaticChecked() throws Settings.SettingNotFoundException {

        Integer dateTime, timezone;

        Activity activity = cordova.getActivity();

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            dateTime = Settings.Global.getInt(activity.getContentResolver(), Settings.Global.AUTO_TIME, 0);
            timezone = Settings.Global.getInt(activity.getContentResolver(), Settings.Global.AUTO_TIME_ZONE, 0);

        } else {
            dateTime = android.provider.Settings.System.getInt(
                activity.getContentResolver(),
                android.provider.Settings.System.AUTO_TIME_ZONE,
                0
            );

            timezone = android.provider.Settings.System.getInt(
                activity.getContentResolver(),
                android.provider.Settings.System.AUTO_TIME,
                0
            );
        }

        if (dateTime == 0 || timezone == 0) {
            return false;
        } else {
            return true;
        }
    }

    private static boolean isAutomaticChecked(Activity activity, Context context) throws Settings.SettingNotFoundException {

        Integer dateTime, timezone;

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            dateTime = Settings.Global.getInt(activity.getContentResolver(), Settings.Global.AUTO_TIME, 0);
            timezone = Settings.Global.getInt(activity.getContentResolver(), Settings.Global.AUTO_TIME_ZONE, 0);

        } else {
            dateTime = android.provider.Settings.System.getInt(
                activity.getContentResolver(),
                android.provider.Settings.System.AUTO_TIME_ZONE,
                0
            );

            timezone = android.provider.Settings.System.getInt(
                activity.getContentResolver(),
                android.provider.Settings.System.AUTO_TIME,
                0
            );
        }

        if (dateTime == 0 || timezone == 0) {
            return false;
        } else {
            return true;
        }
    }
}
