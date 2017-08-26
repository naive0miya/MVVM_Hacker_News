package org.youtwo.mvvm_hacker_news.injection.component;

import dagger.Component;
import org.youtwo.mvvm_hacker_news.data.DataManager;
import org.youtwo.mvvm_hacker_news.injection.module.DataManagerModule;
import org.youtwo.mvvm_hacker_news.injection.scope.PerDataManager;

/**
 * Created by Bill on 2017/8/27.
 */


@PerDataManager
@Component(dependencies = ApplicationComponent.class, modules = DataManagerModule.class)
public interface DataManagerComponent {

  void inject(DataManager dataManager);
}
