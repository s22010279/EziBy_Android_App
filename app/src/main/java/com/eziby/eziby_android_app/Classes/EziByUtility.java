package com.eziby.eziby_android_app.Classes;

import android.content.Context;
import android.widget.Toast;

public class EziByUtility {
    public static final String patternCurrency = "##,##0.00";
    public static final String dateFormat = "yyyy-MM-dd HH:mm:ss";
    public static void ShowToastMessage(Context context, String message) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }
}
