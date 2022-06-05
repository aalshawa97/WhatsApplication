package com.example.whatsapp.Chat;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.whatsapp.R;

import java.util.ArrayList;

public class MessageAdapter extends RecyclerView.Adapter<MessageAdapter.MessageViewHolder> {
    public ArrayList<MessageObject> messageList;
    public View mChatList;
    private static final String ONESIGNAL_APP_ID = "db663f05-b87a-4087-b394-30f8dd4ee644";
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
        holder.mMessage.setText(messageList.get(position).getMessage());
        holder.mSender.setText(messageList.get(position).getSenderId());
        holder.mLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        holder.mViewMedia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //new ImageViewer.Builder(context);
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
        public Button mViewMedia;

        public MessageViewHolder(@NonNull View itemView) {
            super(itemView);
            //mTitle = itemView.findViewById(R.id.title);
            mLayout = itemView.findViewById(R.id.layout);
            mMessage = itemView.findViewById(R.id.message);
            mSender = itemView.findViewById(R.id.sender);
            mViewMedia = itemView.findViewById(R.id.viewMedia);
        }

    }

}

