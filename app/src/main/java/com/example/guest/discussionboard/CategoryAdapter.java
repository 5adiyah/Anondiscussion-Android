package com.example.guest.discussionboard;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder> {
    private ArrayList<Post> mPosts = new ArrayList<>();
    private Context mContext;

    public CategoryAdapter(Context context, ArrayList<Post> posts) {
        mContext =context;
        mPosts = posts;
    }

    @Override
    public CategoryAdapter.CategoryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_category, parent, false);
        CategoryViewHolder viewHolder = new CategoryViewHolder(view);
        return viewHolder;
    }
    @Override
    public void onBindViewHolder(CategoryAdapter.CategoryViewHolder holder, int position) {
        holder.bindPost(mPosts.get(position));
    }
    @Override
    public int getItemCount() {
        return mPosts.size();
    }
    public class CategoryViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.icon) ImageView mIcon;
        @Bind(R.id.title) TextView mTitle;
        private Context mContext;

        public CategoryViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            mContext = itemView.getContext();
        }
        public void bindPost(Post post) {
            mTitle.setText(post.getTitle());
        }
    }
}