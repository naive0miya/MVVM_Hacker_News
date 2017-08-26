package org.youtwo.mvvm_hacker_news.injection.module;

import dagger.Module;
import dagger.Provides;
import org.youtwo.mvvm_hacker_news.data.remote.HackerNewsService;
import org.youtwo.mvvm_hacker_news.data.remote.RetrofitHelper;
import org.youtwo.mvvm_hacker_news.injection.scope.PerDataManager;
import rx.Scheduler;
import rx.schedulers.Schedulers;

/**
 * Created by Bill on 2017/8/27.
 */
@Module
public class DataManagerModule {
  public DataManagerModule() {

  }

  @Provides
  @PerDataManager
  HackerNewsService provideHackerNewsService() {
    return new RetrofitHelper().newHackerNewsService();
  }

  @Provides
  @PerDataManager
  Scheduler provideSubscribeScheduler() {
    return Schedulers.io();
  }
}
