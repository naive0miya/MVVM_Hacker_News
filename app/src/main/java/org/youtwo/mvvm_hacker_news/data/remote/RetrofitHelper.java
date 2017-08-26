package org.youtwo.mvvm_hacker_news.data.remote;

import com.google.gson.GsonBuilder;
import retrofit.RestAdapter;
import retrofit.converter.GsonConverter;

/**
 * Created by Bill on 2017/8/27.
 */

public class RetrofitHelper {
  public HackerNewsService newHackerNewsService() {
    RestAdapter restAdapter = new RestAdapter.Builder()
        .setEndpoint(HackerNewsService.ENDPOINT)
        .setLogLevel(RestAdapter.LogLevel.FULL)
        .setConverter(new GsonConverter(new GsonBuilder().create()))
        .build();
    return restAdapter.create(HackerNewsService.class);
  }
}
