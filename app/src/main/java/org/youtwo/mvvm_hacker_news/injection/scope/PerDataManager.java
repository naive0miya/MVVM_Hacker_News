package org.youtwo.mvvm_hacker_news.injection.scope;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import javax.inject.Scope;

/**
 * Created by Bill on 2017/8/27.
 */

@Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface PerDataManager {
}
