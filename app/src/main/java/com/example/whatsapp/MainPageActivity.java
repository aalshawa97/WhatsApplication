package com.example.whatsapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.whatsapp.User.UserListAdapter;
import com.example.whatsapp.User.UserObject;
import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;

public class MainPageActivity extends AppCompatActivity {
    private RecyclerView mChatList;
    private RecyclerView.Adapter mChatListAdapter;
    private RecyclerView.LayoutManager mUserListLayoutManager;

    ArrayList<UserObject> userList, contactList;

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
    }

    private void getPermissions() {
        requestPermission(new String[]{Manifest.permission.WRITE_CONTACTS});
        requestPermission(new String[]{Manifest.permission.READ_CONTACTS});
    }

    private void requestPermission(String[] strings) {
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
            requestPermissions(new String[] {Manifest.permission.WRITE_CONTACTS}, 1);
            requestPermissions(new String[] {Manifest.permission.READ_CONTACTS}, 1);
        }
    }

    private void initializeRecyclerView() {
        mChatList = findViewById(R.id.userList);
        mChatList.setNestedScrollingEnabled(false);
        mChatList.setHasFixedSize(false);
        mUserListLayoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);
        mChatList.setLayoutManager(mUserListLayoutManager);
        mChatListAdapter = new UserListAdapter(userList);
        mChatList.setAdapter(mChatListAdapter);
    }
}