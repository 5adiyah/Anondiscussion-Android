package com.example.guest.discussionboard;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class NewPostActivity extends AppCompatActivity implements View.OnClickListener {
    private DatabaseReference mPostInformation;
    @Bind(R.id.titleText) EditText mTitleText;
    @Bind(R.id.postText) EditText mPostText;
    @Bind(R.id.category) Spinner mCategory;
    @Bind(R.id.addPost) Button mAddPost;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        mPostInformation = FirebaseDatabase
                .getInstance()
                .getReference()
                .child(Constants.FIREBASE_ADDED_POST);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_post);
        ButterKnife.bind(this);

        Spinner spinner = (Spinner) findViewById(R.id.category);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.category_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        mAddPost.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        if(v == mAddPost) {
            String title = mTitleText.getText().toString();
            String post = mPostText.getText().toString();
            String category = mCategory.getSelectedItem().toString();
            ArrayList<String> responses = new ArrayList<>();

            savePostToFirebase(title, post, category, responses);

            Intent intent = new Intent(NewPostActivity.this, CategoryActivity.class);
            intent.putExtra("title", title);
            intent.putExtra("post", post);
            intent.putExtra("spinner", category);
            startActivity(intent);
        }
    }
    public void savePostToFirebase(String title, String post, String category, ArrayList<String> responses) {
        Post newPost = new Post(title, post, category, responses);
        mPostInformation.push().setValue(newPost);
    }
}
