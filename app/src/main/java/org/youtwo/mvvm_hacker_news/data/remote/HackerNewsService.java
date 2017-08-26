package org.youtwo.mvvm_hacker_news.data.remote;

import java.util.List;
import org.youtwo.mvvm_hacker_news.model.Comment;
import org.youtwo.mvvm_hacker_news.model.Post;
import org.youtwo.mvvm_hacker_news.model.User;
import retrofit.http.GET;
import retrofit.http.Path;
import rx.Observable;

/**
 * Created by Bill on 2017/8/27.
 */

public interface HackerNewsService {

  String ENDPOINT = "https://hacker-news.firebaseio.com/v0/";

  /**
   * Return a list of the latest post IDs.
   */
  @GET("/topstories.json")
  Observable<List<Long>> getTopStories();

  /**
   * Return a list of a users post IDs.
   */
  @GET("/user/{user}.json")
  Observable<User> getUser(@Path("user") String user);

  /**
   * Return story item.
   */
  @GET("/item/{itemId}.json")
  Observable<Post> getStoryItem(@Path("itemId") String itemId);

  /**
   * Returns a comment item.
   */
  @GET("/item/{itemId}.json")
  Observable<Comment> getCommentItem(@Path("itemId") String itemId);
}
