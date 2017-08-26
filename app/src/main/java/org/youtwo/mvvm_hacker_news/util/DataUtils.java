package org.youtwo.mvvm_hacker_news.util;

import android.content.Context;
import android.net.ConnectivityManager;

/**
 * Created by Bill on 2017/8/27.
 */

public class DataUtils {

  public static boolean isNetworkAvailable(Context context) {
    ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(
        Context.CONNECTIVITY_SERVICE);
    return connectivityManager.getActiveNetworkInfo() != null;
  }
}
