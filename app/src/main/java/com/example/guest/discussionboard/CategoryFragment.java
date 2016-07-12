package com.example.guest.discussionboard;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.parceler.Parcels;

import butterknife.Bind;
import butterknife.ButterKnife;

public class CategoryFragment extends Fragment {
    @Bind(R.id.title) TextView mTitle;
    @Bind(R.id.icon) ImageView mIcon;
    private Post mPost;

    public CategoryFragment() {}

    public static CategoryFragment newInstance(Post post){
        CategoryFragment categoryFragment = new CategoryFragment();
        Bundle args = new Bundle();
        args.putParcelable("post", Parcels.wrap(post));
        categoryFragment.setArguments(args);
        return categoryFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        mPost = Parcels.unwrap(getArguments().getParcelable("post"));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_category, container, false);
        ButterKnife.bind(this, view);

        if(mPost.getCategory().equals("work")){
            Picasso.with(view.getContext()).load(R.drawable.swords).into(mIcon);
        } else if(mPost.getCategory().equals("love")){
            Picasso.with(view.getContext()).load(R.drawable.calvin).into(mIcon);
        } else if(mPost.getCategory().equals("miscellaneous")){
            Picasso.with(view.getContext()).load(R.drawable.lobster).into(mIcon);
        }
        mTitle.setText(mPost.getTitle());
        return view;
    }

}
