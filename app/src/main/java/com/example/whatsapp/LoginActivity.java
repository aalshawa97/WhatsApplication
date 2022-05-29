package com.example.whatsapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthOptions;
import com.google.firebase.auth.PhoneAuthProvider;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class LoginActivity extends AppCompatActivity {
    private EditText mPhoneNumber, mCode;
    private Button mVerify;
    private Button mSend;
    private PhoneAuthProvider.OnVerificationStateChangedCallbacks mCallbacks = null;
    String mVerificationId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FirebaseApp.initializeApp(this);
        userIsLoggedIn();
        mPhoneNumber = findViewById(R.id.phoneNumber);
        mCode = findViewById(R.id.code);
        mSend = findViewById(R.id.send);
        //auth.setLanguageCode("fr");
        try{
            mSend.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(mVerificationId != null){
                        verifyPhoneNumberWithCode();
                    }
                    else{
                        startPhoneNumberVerification();
                    }
                }
            });
        }
        catch (Exception e){
            Log.d("Verification send", "onCreate: verify");
        }

        mCallbacks = new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
            @Override
            public void onVerificationCompleted(@NonNull PhoneAuthCredential phoneAuthCredential) {
                signInWithPhoneAuthCredential(phoneAuthCredential);
            }

            @Override
            public void onVerificationFailed(@NonNull FirebaseException e) {

            }

            @Override
            public void onCodeSent(@NonNull String verificationId, @NonNull PhoneAuthProvider.ForceResendingToken forceResendingToken) {
                super.onCodeSent(verificationId, forceResendingToken);
                mVerificationId = verificationId;
                mSend.setText(R.string.verifyCode);
            }
        };
    }

    private void verifyPhoneNumberWithCode(){
        try{
            PhoneAuthCredential credential = PhoneAuthProvider.getCredential(mVerificationId, mCode.getText().toString());
        }
        catch (Exception e)
        {
            Log.d("Verify phone number", "verifyPhoneNumberWithCode: Illegal argument " + e.toString());
        }
        /*signInWithPhoneCredential(credential);
         */
    }

    private void signInWithPhoneAuthCredential(PhoneAuthCredential phoneAuthCredential){
        FirebaseAuth.getInstance().signInWithCredential(phoneAuthCredential).addOnCompleteListener(this, (task -> {
            if(task.isSuccessful()){
                FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

                if(user != null){
                    final DatabaseReference mUserDB = FirebaseDatabase.getInstance().getReference().child("user").child(user.getUid());
                    mUserDB.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            if(!snapshot.exists()){
                                Map<String, Object> userMap = new HashMap<>();
                                userMap.put("phone", user.getPhoneNumber());
                                userMap.put("name", user.getDisplayName());
                                mUserDB.updateChildren(userMap);
                            }
                            userIsLoggedIn();
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });
                }
            }
        }));
    }

    private void userIsLoggedIn() {
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if(user != null){
            startActivity(new Intent(getApplicationContext(), MainPageActivity.class));
            finish();
            return;
        }
    }

    private void startPhoneNumberVerification() {
        PhoneAuthProvider.getInstance().verifyPhoneNumber(
                mPhoneNumber.getText().toString(),
                60,
                TimeUnit.SECONDS,
                this,
                mCallbacks
        );
    }
}