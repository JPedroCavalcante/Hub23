/* package com.guina.tasklist;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class TestConnection {
     public static boolean isConnected(Context context) {
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);

        if ( cm != null ) {
            NetworkInfo ni = cm.getActiveNetworkInfo();

            return ni != null && ni.isConnected();
        }

        return false;
    }
}
*/