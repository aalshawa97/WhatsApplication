package com.example.whatsapp.Utils;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.whatsapp.Chat.ChatListAdapter;
import com.example.whatsapp.Chat.ChatObject;
import com.example.whatsapp.R;

import java.util.ArrayList;

public class ChatActivity extends AppCompatActivity {
    private RecyclerView mChatList;
    private RecyclerView.Adapter mChatListAdapter;
    ArrayList<ChatObject> userList;
    private RecyclerView.LayoutManager mUserListLayoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
        initializeRecyclerView();
    }

    private void initializeRecyclerView() {
        userList = new ArrayList<>();
        mChatList = findViewById(R.id.recyclerView);
        mChatList.setNestedScrollingEnabled(false);
        mChatList.setHasFixedSize(false);
        mUserListLayoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);
        mChatList.setLayoutManager(mUserListLayoutManager);
        mChatListAdapter = new ChatListAdapter(userList);
        mChatList.setAdapter(mChatListAdapter);
    }
}