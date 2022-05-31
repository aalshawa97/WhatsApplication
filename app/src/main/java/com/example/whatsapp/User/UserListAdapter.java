package com.example.whatsapp.User;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.whatsapp.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class UserListAdapter extends RecyclerView.Adapter<UserListAdapter.UserListViewHolder> {
    public ArrayList<UserObject> userList;
    public View mUserList;
    private Object TextView;
    private TextView mName;
    private TextView mPhone;

    public UserListAdapter(ArrayList<UserObject>  userList) {
        //super(context);
        this.userList = userList;
    }

    public class UserListViewHolder extends RecyclerView.ViewHolder{
        public UserListViewHolder view;
        public TextView mName, mPhone;
        public LinearLayout mLayout;

        public UserListViewHolder(@NonNull View itemView) {
            super(itemView);
            mName = view.findViewById(R.id.name);
            mPhone = view.findViewById(R.id.phone);
        }

        public TextView findViewById(int name) {
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

    @Override
    public void onBindViewHolder(@NonNull UserListViewHolder holder, int position) {
        holder.mName.setText(userList.get(position).getName());
        holder.mPhone.setText(userList.get(position).getPhone());
        holder.mLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String key = FirebaseDatabase.getInstance().getReference().child("chat").push().getKey();
                FirebaseDatabase.getInstance().getReference().child("user").child(FirebaseAuth.getInstance().getUid()).setValue(true);
                FirebaseDatabase.getInstance().getReference().child("user").child(FirebaseAuth.getInstance().getUid()).setValue(true);
            }
        });
    }


    public UserListAdapter(@NonNull View itemView) {
        //super(itemView);
    }

    public int getItemCount() {
        return userList.size();
    }

}
