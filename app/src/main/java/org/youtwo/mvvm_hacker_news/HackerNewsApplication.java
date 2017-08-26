package org.youtwo.mvvm_hacker_news;

import android.app.Application;
import android.content.Context;
import org.youtwo.mvvm_hacker_news.injection.component.ApplicationComponent;
import org.youtwo.mvvm_hacker_news.injection.component.DaggerApplicationComponent;
import org.youtwo.mvvm_hacker_news.injection.module.ApplicationModule;
import timber.log.Timber;

/**
 * Created by Bill on 2017/8/26.
 */

public class HackerNewsApplication extends Application {

  ApplicationComponent mApplicationComponent;

  @Override
  public void onCreate() {
    super.onCreate();
    if (BuildConfig.DEBUG) Timber.plant(new Timber.DebugTree());
    mApplicationComponent = DaggerApplicationComponent.builder()
        .applicationModule(new ApplicationModule(this))
        .build();
  }

  public static HackerNewsApplication get(Context context) {
    return (HackerNewsApplication) context.getApplicationContext();
  }

  public ApplicationComponent getComponent() {
    return mApplicationComponent;
  }

  // Needed to replace the component with a test specific one
  public void setComponent(ApplicationComponent applicationComponent) {
    mApplicationComponent = applicationComponent;
  }
}
