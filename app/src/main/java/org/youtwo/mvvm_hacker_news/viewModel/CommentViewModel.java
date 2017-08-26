package org.youtwo.mvvm_hacker_news.viewModel;

import android.content.Context;
import android.databinding.BaseObservable;
import android.databinding.BindingAdapter;
import android.text.Html;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import java.util.Date;
import org.ocpsoft.prettytime.PrettyTime;
import org.youtwo.mvvm_hacker_news.R;
import org.youtwo.mvvm_hacker_news.model.Comment;
import org.youtwo.mvvm_hacker_news.util.ViewUtils;

/**
 * Created by Bill on 2017/8/27.
 */

public class CommentViewModel extends BaseObservable {


  private Context context;
  private Comment comment;

  public CommentViewModel(Context context, Comment comment) {
    this.context = context;
    this.comment = comment;
  }

  @BindingAdapter("containerMargin")
  public static void setContainerMargin(View view, boolean isTopLevelComment) {
    if (view.getTag() == null) {
      view.setTag(true);
      ViewGroup.MarginLayoutParams layoutParams = (ViewGroup.MarginLayoutParams)
          view.getLayoutParams();
      float horizontalMargin = view.getContext().getResources().getDimension(R.dimen.activity_horizontal_margin);
      float topMargin = isTopLevelComment
          ? view.getContext().getResources().getDimension(R.dimen.activity_vertical_margin) : 0;
      layoutParams.setMargins((int) horizontalMargin, (int) topMargin, (int) horizontalMargin, 0);
      view.setLayoutParams(layoutParams);
    }
  }

  @BindingAdapter("commentDepth")
  public static void setCommentIndent(View view, int depth) {
    if (view.getTag() == null) {
      view.setTag(true);
      RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams)
          view.getLayoutParams();
      float margin = ViewUtils.convertPixelsToDp(depth * 20, view.getContext());
      layoutParams.setMargins((int) margin, 0, 0, 0);
      view.setLayoutParams(layoutParams);
    }
  }

  public String getCommentText() {
    return Html.fromHtml(comment.text.trim()).toString();
  }

  public String getCommentAuthor() {
    return context.getResources().getString(R.string.text_comment_author, comment.by);
  }

  public String getCommentDate() {
    return new PrettyTime().format(new Date(comment.time * 1000));
  }

  public int getCommentDepth() {
    return comment.depth;
  }

  public boolean getCommentIsTopLevel() {
    return comment.isTopLevelComment;
  }
}
