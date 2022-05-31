package com.example.whatsapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.whatsapp.Chat.ChatListAdapter;
import com.example.whatsapp.Chat.ChatObject;
import com.example.whatsapp.User.UserListAdapter;
import com.example.whatsapp.User.UserObject;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Objects;

public class MainPageActivity extends AppCompatActivity {
    private RecyclerView mChatList;
    private RecyclerView.Adapter mChatListAdapter;
    private RecyclerView.LayoutManager mUserListLayoutManager;

    ArrayList<ChatObject> userList, contactList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);

        Button mLogout =  findViewById(R.id.logout);
        Button mFindUser = findViewById(R.id.findUser);
        mFindUser.setOnClickListener(view -> {
            /*
            FirebaseAuth.getInstance().signOut();
            Intent intent = new Intent(getApplicationContext(), FindUserActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
            finish();
            return;
            */

            startActivity(new Intent(getApplicationContext(), FindUserActivity.class));
        });
        mLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                finish();
                return;
            }
        });
        getPermissions();
        initializeRecyclerView();
        getUserChatList();
    }

    private void requestPermission(String[] strings) {
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
            requestPermissions(new String[] {Manifest.permission.WRITE_CONTACTS}, 1);
            requestPermissions(new String[] {Manifest.permission.READ_CONTACTS}, 1);
        }
    }

    private void getUserChatList(){
        DatabaseReference mUserChatDB = FirebaseDatabase.getInstance().getReference().child("user").child(Objects.requireNonNull(FirebaseAuth.getInstance().getUid())).child("chat");
        mUserChatDB.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists()){
                    for(DataSnapshot childSnapshot : snapshot.getChildren()){
                        ChatObject mChat = new ChatObject(childSnapshot.getKey());
                        boolean exists = false;
                        for(ChatObject mChatIterator : userList){
                            if(mChatIterator.getChatId().equals(mChat.getChatId())){
                                exists = true;
                            }
                        }
                        if(exists)
                            continue;
                        userList.add(mChat);
                        mChatListAdapter.notifyDataSetChanged();
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    private void initializeRecyclerView() {
        mChatList = findViewById(R.id.userList);
        mChatList.setNestedScrollingEnabled(false);
        mChatList.setHasFixedSize(false);
        mUserListLayoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);
        mChatList.setLayoutManager(mUserListLayoutManager);
        mChatListAdapter = new ChatListAdapter(userList);
        mChatList.setAdapter(mChatListAdapter);
    }

    private void getPermissions() {
        requestPermission(new String[]{Manifest.permission.WRITE_CONTACTS});
        requestPermission(new String[]{Manifest.permission.READ_CONTACTS});
    }
}