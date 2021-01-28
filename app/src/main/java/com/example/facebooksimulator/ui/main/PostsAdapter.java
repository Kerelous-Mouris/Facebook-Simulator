package com.example.facebooksimulator.ui.main;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.facebooksimulator.R;
import com.example.facebooksimulator.pojo.PostModel;

import java.util.ArrayList;
import java.util.List;

import static com.example.facebooksimulator.R.layout.post_item;

public class PostsAdapter extends RecyclerView.Adapter<PostsAdapter.PostViewHolder> {

    private List<PostModel> postsList = new ArrayList<>();

    public void setList(List<PostModel> postsList) {
        this.postsList = postsList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new PostViewHolder(LayoutInflater.from(parent.getContext()).inflate(post_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull PostViewHolder holder, int position) {

        holder.titleTV.setText(postsList.get(position).getTitle());
        holder.userIDTV.setText(String.format("%d", postsList.get(position).getUserId()));
        holder.bodyTV.setText(postsList.get(position).getBody());

    }

    @Override
    public int getItemCount() {
        return postsList.size();
    }

    public class PostViewHolder extends RecyclerView.ViewHolder {

        TextView titleTV, userIDTV, bodyTV;

        public PostViewHolder(@NonNull View itemView) {
            super(itemView);

            titleTV = itemView.findViewById(R.id.titleTV);
            userIDTV = itemView.findViewById(R.id.userIDTV);
            bodyTV = itemView.findViewById(R.id.bodyTV);

        }
    }
}
