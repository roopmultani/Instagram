package com.example.instragramclone.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.instragramclone.EndlessScrollListener;
import com.example.instragramclone.Post;
import com.example.instragramclone.PostAdapter;
import com.example.instragramclone.R;
import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseQuery;

import java.util.ArrayList;
import java.util.List;


public class PostFragment extends Fragment {

    public static final String TAG = "PostFragment";
    private RecyclerView rvPost;
    protected PostAdapter adapter;
    protected List<Post> allPosts;
    private EndlessScrollListener scrollListener;
    private SwipeRefreshLayout swipeRefreshLayout;

    public PostFragment(){

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_post, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rvPost = view.findViewById(R.id.rvPost);

        allPosts = new ArrayList<>();
        adapter = new PostAdapter(getContext(), allPosts);


        // steps to use the recycler view:
        // create layout for one row in the list
        // create the adapter
        // set the adapter on the recycler view
        rvPost.setAdapter(adapter);
        // set the layout manager on the recycler view
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        rvPost.setLayoutManager(layoutManager);
        //rvPost.setLayoutManager(new LinearLayoutManager(getContext()));

        //scroll listener
        scrollListener = new EndlessScrollListener(layoutManager) {
            @Override
            public void onLoadMore(int page, int totalItemsCount, RecyclerView view) {

                Log.i(TAG,"onLoadMOre"+ page);
                loadMoreData(page);
            }
        };

        //rvPost.addOnScrollListener(scrollListener);
        queryPosts();
    }

    void loadMoreData(int page) {
        queryPosts();
    }

    protected void queryPosts() {
        // Specify which class to query
        ParseQuery<Post> query = ParseQuery.getQuery(Post.class);
        query.include(Post.KEY_USER);
        //Post.Query query = new Post.Query();
        //query.getTop().withUser();
        query.setLimit(20);
        query.addDescendingOrder(Post.KEY_CREATED_KEY);

        query.findInBackground(new FindCallback<Post>() {
            @Override
            public void done(List<Post> posts, ParseException e) {
                if (e !=null ) {
                    Log.e(TAG, "issue with getting post", e);
                    return;
                }

                for( Post post : posts ){
                    //Log.i(TAG, "Post:" + post.getDescription() + ", username:" + post.getUser().getUsername());
                }

                allPosts.addAll(posts);
                adapter.notifyDataSetChanged();
//                swipeRefreshLayout.setRefreshing(false);
            }
        });
    }
}