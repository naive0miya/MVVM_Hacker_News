package org.youtwo.mvvm_hacker_news.util;

import android.content.Context;
import android.util.DisplayMetrics;

/**
 * Created by Bill on 2017/8/27.
 */

public class ViewUtils {
  public static float convertPixelsToDp(float px, Context context){
    DisplayMetrics metrics = context.getResources().getDisplayMetrics();
    return px / (metrics.densityDpi / 160f);
  }

}
