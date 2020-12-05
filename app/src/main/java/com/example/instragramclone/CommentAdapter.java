package com.example.instragramclone;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.w3c.dom.Comment;

import java.util.List;

public class CommentAdapter extends ArrayAdapter<Comment> {

    private Context context;

    public CommentAdapter(@NonNull Context context, int resource, @NonNull List<Comment> objects) {
        super(context, resource, objects);
        this.context = context;
    }

    private static class ViewHolder{
        private TextView tvComnt;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        final ViewHolder holder;
        if (convertView == null){
            convertView = LayoutInflater.from(context).inflate(position, parent, false);
            holder = new ViewHolder();

            holder.tvComnt = convertView.findViewById(R.id.tvComnt);
            convertView.setTag(holder);
        }else {
            holder = (ViewHolder) convertView.getTag();
        }

        Comment commentData = getItem(position);

        return convertView;
    }
}
