package com.example.whatsapp.Utils;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.widget.Button;
import android.widget.EditText;

import com.example.whatsapp.Chat.ChatListAdapter;
import com.example.whatsapp.Chat.ChatObject;
import com.example.whatsapp.Chat.MessageAdapter;
import com.example.whatsapp.Chat.MessageObject;
import com.example.whatsapp.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ChatActivity extends AppCompatActivity {
    private RecyclerView mChatList;
    private RecyclerView.Adapter mChatListAdapter;
    ArrayList<MessageObject> userList;
    private RecyclerView.LayoutManager mUserListLayoutManager;
    String chatID;
    DatabaseReference mChatDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
        chatID = getIntent().getExtras().getString("chatID");
        mChatDb = FirebaseDatabase.getInstance().getReference().child("chat").child(chatID);
        Button mSend = findViewById(R.id.send);
        initializeRecyclerView();
        getChatMessages();
    }

    private void getChatMessages() {
        mChatDb.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                if(snapshot.exists()){
                    String message = "", creatorID = "";

                    if(snapshot.child("text").getValue() != null){
                        message = snapshot.child("text").getValue().toString();
                    }

                    if(snapshot.child("creator").getValue() != null){
                        creatorID = snapshot.child("creator").getValue().toString();
                    }

                    MessageObject mMessage = new MessageObject(snapshot.getKey(), creatorID, message);
                    userList.add(mMessage);
                    mUserListLayoutManager.scrollToPosition(userList.size()-1);
                    mChatListAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot snapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        FirebaseDatabase.getInstance().getReference().child("chat").child(chatID);
    }

    private void sendMessage(){
        EditText mMessage = findViewById(R.id.message);
        if(!mMessage.getText().toString().isEmpty()){
            DatabaseReference newMessageDb = mChatDb.push();

            Map newMessageMap = new HashMap<>();
            newMessageMap.put("text", mMessage.getText().toString());
            newMessageMap.put("creator", FirebaseAuth.getInstance().getUid());

            newMessageDb.updateChildren(newMessageMap);
        }
        mMessage.setText(null);
    }

    private void initializeRecyclerView() {
        userList = new ArrayList<>();
        mChatList = findViewById(R.id.recyclerView);
        mChatList.setNestedScrollingEnabled(false);
        mChatList.setHasFixedSize(false);
        mUserListLayoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);
        mChatList.setLayoutManager(mUserListLayoutManager);
        mChatListAdapter = new MessageAdapter(userList);
        mChatList.setAdapter(mChatListAdapter);
    }
}