package com.itproject.android.song2go.Activities;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FileDownloadTask;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.itproject.android.song2go.R;

import java.io.File;
import java.io.IOException;

public class LoginActivity extends AppCompatActivity {

    Button btnlog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

    btnlog= (Button) findViewById(R.id.btnlogin);


    }

    public void login(View view)
    {

        Intent intent=new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}
