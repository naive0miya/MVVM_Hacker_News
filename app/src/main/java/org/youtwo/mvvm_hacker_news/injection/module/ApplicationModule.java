package org.youtwo.mvvm_hacker_news.injection.module;

import android.app.Application;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;
import org.youtwo.mvvm_hacker_news.data.DataManager;

/**
 * Created by Bill on 2017/8/27.
 */
@Module
public class ApplicationModule {
  protected final Application mApplication;

  public ApplicationModule(Application application) {
    mApplication = application;
  }

  @Provides
  @Singleton
  Application provideApplication() {
    return mApplication;
  }

  @Provides
  @Singleton
  DataManager provideDataManager() {
    return new DataManager(mApplication);
  }
}
