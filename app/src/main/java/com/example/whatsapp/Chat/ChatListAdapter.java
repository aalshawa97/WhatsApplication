package com.example.whatsapp.Chat;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.whatsapp.R;
import com.example.whatsapp.Utils.ChatActivity;

import java.util.ArrayList;

public class ChatListAdapter extends RecyclerView.Adapter<ChatListAdapter.ChatListViewHolder> {
    public ArrayList<ChatObject> chatList;
    public View mChatList;
    private Object TextView;
    private android.widget.TextView mName;
    private TextView mPhone;

    public ChatListAdapter(ArrayList<ChatObject>  chatList) {
        //super(context);
        this.chatList = chatList;
    }

    @NonNull
    @Override
    public ChatListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_chat, null, false);
        RecyclerView.LayoutParams lp = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        layoutView.setLayoutParams(lp);

        ChatListViewHolder rcv = new ChatListViewHolder(layoutView);
        return rcv;
    }

    public void onBindViewHolder(@NonNull final ChatListAdapter.ChatListViewHolder holder, int position) {
        holder.mTitle.setText(chatList.get(position).getChatId());
        holder.mLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent (view.getContext(), ChatActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("chatID", chatList.get(holder.getAdapterPosition()).getChatId());
                intent.putExtras(bundle);
                view.getContext().startActivity(intent);
            }
        });
    }


    public ChatListAdapter(@NonNull View itemView) {
        //super(itemView);
    }

    public int getItemCount() {
        return chatList.size();
    }

    public class ChatListViewHolder extends RecyclerView.ViewHolder{
        public TextView mTitle;
        public LinearLayout mLayout;

        public ChatListViewHolder(@NonNull View itemView) {
            super(itemView);
            mTitle = itemView.findViewById(R.id.title);
            mLayout = itemView.findViewById(R.id.layout);
        }

    }

}

