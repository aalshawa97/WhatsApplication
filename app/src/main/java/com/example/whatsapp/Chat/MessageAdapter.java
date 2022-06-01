package com.example.whatsapp.Chat;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.whatsapp.R;

import java.util.ArrayList;

public class MessageAdapter extends RecyclerView.Adapter<MessageAdapter.MessageViewHolder> {
    public ArrayList<MessageObject> messageList;
    public View mChatList;
    private Object TextView;
    private android.widget.TextView mName;
    private TextView mPhone;

    public MessageAdapter(ArrayList<MessageObject>  messageList) {
        //super(context);
        this.messageList = messageList;
    }

    @NonNull
    @Override
    public MessageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_message, null, false);
        RecyclerView.LayoutParams lp = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        layoutView.setLayoutParams(lp);

        MessageViewHolder rcv = new MessageViewHolder(layoutView);
        return rcv;
    }

    public void onBindViewHolder(@NonNull MessageAdapter.MessageViewHolder holder, int position) {
        //holder.mTitle.setText(messageList.get(position).getChatId());
        holder.mLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }


    public MessageAdapter(@NonNull View itemView) {
        //super(itemView);
    }

    public int getItemCount() {
        return messageList.size();
    }

    class MessageViewHolder extends RecyclerView.ViewHolder{
        public TextView mMessage, mSender;
        public LinearLayout mLayout;

        public MessageViewHolder(@NonNull View itemView) {
            super(itemView);
            //mTitle = itemView.findViewById(R.id.title);
            mLayout = itemView.findViewById(R.id.layout);
            mMessage = itemView.findViewById(R.id.message);
            mSender = itemView.findViewById(R.id.sender);

        }

    }

}

