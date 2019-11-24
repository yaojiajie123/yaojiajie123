package mobileshop.edu.huatec.com.mobileshop.acitvit.utils;

import android.content.Context;
import android.content.SharedPreferences;

import mobileshop.edu.huatec.com.mobileshop.acitvit.common.MobileShopApp;

public class SpTools {

    private static final String CONFIG_FILE_NAME = "mobileshop_config_file";

    public static void putBoolean(String key, boolean value){
        SharedPreferences sp = MobileShopApp.getsContext().getSharedPreferences(CONFIG_FILE_NAME, Context.MODE_PRIVATE);
        sp.edit().putBoolean(key, value).commit();

    }

    public static boolean getBoolean(String key, boolean defValue) {
        SharedPreferences sp = MobileShopApp.getsContext().getSharedPreferences(CONFIG_FILE_NAME, Context.MODE_PRIVATE);
        return sp.getBoolean(key, defValue);
    }

    public static void putString(String key, String value){
        SharedPreferences sp = MobileShopApp.getsContext().getSharedPreferences(CONFIG_FILE_NAME, Context.MODE_PRIVATE);
        sp.edit().putString(key, value).commit();

    }

    public static String getString(String key, String defValue) {
        SharedPreferences sp = MobileShopApp.getsContext().getSharedPreferences(CONFIG_FILE_NAME, Context.MODE_PRIVATE);
        return sp.getString(key, defValue);
    }

    public static void putInt(String key, int value){
        SharedPreferences sp = MobileShopApp.getsContext().getSharedPreferences(CONFIG_FILE_NAME, Context.MODE_PRIVATE);
        sp.edit().putInt(key, value).commit();

    }

    public static int  getInt(String key, int defValue) {
        SharedPreferences sp = MobileShopApp.getsContext().getSharedPreferences(CONFIG_FILE_NAME, Context.MODE_PRIVATE);
        return sp.getInt(key, defValue);
    }

}
