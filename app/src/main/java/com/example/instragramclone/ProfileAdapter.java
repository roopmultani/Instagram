package com.example.instragramclone;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.instragramclone.fragments.EditActivity;
import com.google.android.material.shape.RoundedCornerTreatment;
import com.parse.ParseFile;
import com.parse.ParseUser;

import java.io.Serializable;
import java.util.List;

public class ProfileAdapter extends RecyclerView.Adapter<ProfileAdapter.ViewHolder> {

    private Context context;
    private List<Post> posts;

    public ProfileAdapter(Context context, List<Post> posts){
        this.context = context;
        this.posts = posts;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //return null;
        context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.item_profile, parent, false);
       // View view = LayoutInflater.from(context).inflate(R.layout.item_profile, parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ProfileAdapter.ViewHolder holder, int position) {
        Post post = posts.get(position);
        holder.bind(post);
    }

    @Override
    public int getItemCount() {
        return posts.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
       // public ImageView rvPost;
       private ImageView ivPposts;
       private TextView tvUserName;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            ivPposts = itemView.findViewById(R.id.ivPposts);
            tvUserName = itemView.findViewById(R.id.tvUserName);
            }

        public void bind(Post post) {
           // tvUserName.setText(post.getUser().getUsername());
            ivPposts.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    goUserDetailActivity(post);
                }
            });
        }
    }

    private void goUserDetailActivity(Post post) {
        Intent intent = new Intent(context, UserDetailActivity.class);
        intent.putExtra("image", post.getImage().getUrl());
        context.startActivity(intent);
    }
}
