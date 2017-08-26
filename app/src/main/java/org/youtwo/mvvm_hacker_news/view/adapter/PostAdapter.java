package org.youtwo.mvvm_hacker_news.view.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;
import org.youtwo.mvvm_hacker_news.R;
import org.youtwo.mvvm_hacker_news.databinding.ItemPostBinding;
import org.youtwo.mvvm_hacker_news.model.Post;
import org.youtwo.mvvm_hacker_news.viewModel.PostViewModel;

/**
 * Created by Bill on 2017/8/27.
 */

public class PostAdapter  extends RecyclerView.Adapter<PostAdapter.BindingHolder> {

  private List<Post> mPosts;
  private Context mContext;
  private boolean mIsUserPosts;

  public PostAdapter(Context context, boolean isUserPosts) {
    mContext = context;
    mIsUserPosts = isUserPosts;
    mPosts = new ArrayList<>();
  }

  @Override
  public BindingHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    ItemPostBinding postBinding = DataBindingUtil.inflate(
        LayoutInflater.from(parent.getContext()),
        R.layout.item_post,
        parent,
        false);
    return new BindingHolder(postBinding);
  }

  @Override
  public void onBindViewHolder(BindingHolder holder, int position) {
    ItemPostBinding postBinding = holder.binding;
    postBinding.setViewModel(new PostViewModel(mContext, mPosts.get(position), mIsUserPosts));
  }

  @Override
  public int getItemCount() {
    return mPosts.size();
  }

  public void setItems(List<Post> posts) {
    mPosts = posts;
    notifyDataSetChanged();
  }

  public void addItem(Post post) {
    if (!mPosts.contains(post)) {
      mPosts.add(post);
      notifyItemInserted(mPosts.size() - 1);
    } else {
      mPosts.set(mPosts.indexOf(post), post);
      notifyItemChanged(mPosts.indexOf(post));
    }
  }

  public static class BindingHolder extends RecyclerView.ViewHolder {
    private ItemPostBinding binding;

    public BindingHolder(ItemPostBinding binding) {
      super(binding.cardView);
      this.binding = binding;
    }
  }

}
