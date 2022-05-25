package com.example.whatsapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.text.BreakIterator;
import java.util.ArrayList;

public class UserListAdapter extends RecyclerView {
    public ArrayList<UserObject> userList;
    public View mUserList;
    private Object TextView;
    private TextView mName;
    private TextView mPhone;

    public UserListAdapter(Context context) {
        super(context);
        //super(context);
        this.mUserList = findViewById(R.id.userList);
        //this.userList = userList;

    }

    public UserListAdapter(ArrayList<UserObject> userList) {
        super(null);
        //super(context);
        this.userList = userList;
    }

    public class UserListViewHolder extends RecyclerView.ViewHolder{
        public UserListViewHolder view;
        public TextView mName, mPhone;
        public UserListViewHolder(@NonNull View itemView) {
            super(itemView);
            mName = view.findViewById(R.id.name);
            mPhone = view.findViewById(R.id.phone);
        }

        private TextView findViewById(int name) {
            return (android.widget.TextView) TextView;
        }
    }

    @NonNull
    public UserListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_user, null, false);
        RecyclerView.LayoutParams lp = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        layoutView.setLayoutParams(lp);

        UserListViewHolder rcv = new UserListViewHolder(layoutView);
        return rcv;
    }

    /*
    public UserListAdapter(@NonNull View itemView) {
        super(itemView);
    }
    */


    public void onBindViewHolder(@NonNull UserListAdapter holder, int position) {
        holder.mName.setText(userList.get(position).getName());
        holder.mPhone.setText(userList.get(position).getPhone());
    }

    public int getItemCount() {
        return userList.size();
    }

}
