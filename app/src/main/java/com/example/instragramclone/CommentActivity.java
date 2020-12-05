package com.example.instragramclone;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.instragramclone.fragments.PostFragment;
import com.parse.ParseException;
import com.parse.ParseFile;
import com.parse.ParseUser;
import com.parse.SaveCallback;

import org.w3c.dom.Comment;

import java.io.File;
import java.util.ArrayList;

public class CommentActivity extends AppCompatActivity {

    //public static final int MAX_COMMENT_LENGTH = 140;

    private ImageButton btnBack;
    private EditText etComment;
    private TextView tvPostComment;
    private ListView lvcomments;
    private ArrayList<Comment> list;
    private CommentAdapter adapter;
    private Post post;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comment);

        final ActionBar actionBar = getSupportActionBar(); // or getActionBar();

        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.comment_action_bar);
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#FFFFFF")));

        etComment = findViewById(R.id.etComment);
        tvPostComment = findViewById(R.id.tvPostComment);
        lvcomments = findViewById(R.id.lvcomments);
        list = new ArrayList<>();
        btnBack = findViewById(R.id.btnBack);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CommentActivity.this, PostFragment.class);
                startActivity(intent);
            }
        });

        postComment(post);
    }


    private void postComment(Post post){
        tvPostComment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String postComment = etComment.getText().toString();
                if (postComment.isEmpty()){
                    Toast.makeText(CommentActivity.this, "Sorry, your comment box is empty!", Toast.LENGTH_LONG).show();
                    return;
                }
                Intent intent = new Intent(CommentActivity.this, PostFragment.class);
                //post.setNumComments("jfmckmlkmkl");
                startActivity(intent);
                //Toast.makeText(CommentActivity.this, postComment, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
