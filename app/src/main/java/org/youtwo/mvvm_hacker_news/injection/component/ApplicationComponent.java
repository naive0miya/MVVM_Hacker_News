package org.youtwo.mvvm_hacker_news.injection.component;

import android.app.Application;
import dagger.Component;
import javax.inject.Singleton;
import org.youtwo.mvvm_hacker_news.data.DataManager;
import org.youtwo.mvvm_hacker_news.injection.module.ApplicationModule;
import org.youtwo.mvvm_hacker_news.view.activity.MainActivity;

/**
 * Created by Bill on 2017/8/27.
 */

@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {

  void inject(MainActivity mainActivity);

  Application application();
  DataManager dataManager();
}