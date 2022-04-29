package com.gulsahakca.veterineruygulamasii.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.gulsahakca.veterineruygulamasii.Models.RegisterPojo;
import com.gulsahakca.veterineruygulamasii.R;
import com.gulsahakca.veterineruygulamasii.RestApi.ManagerAll;
import com.gulsahakca.veterineruygulamasii.Utils.Warnings;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class KayitOlActivity extends AppCompatActivity {
    private Button signUpButton;
    private EditText registerUserName,registerMailAdress,registerPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kayit_ol);
        define();
        registerToUser();
    }
    public void define(){
        signUpButton=(Button) findViewById(R.id.signUpButton);
        registerUserName=(EditText) findViewById(R.id.registerUserName);
        registerMailAdress=(EditText) findViewById(R.id.registerMailAdress);
        registerPassword=(EditText) findViewById(R.id.registerPassword);
    }

    public void registerToUser(){
        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String mail=registerMailAdress.getText().toString();
                String userN=registerUserName.getText().toString();
                String pass=registerPassword.getText().toString();
                register(mail,userN,pass);

            }
        });
    }

    public void register(String userMailAdres, String userName, String userPass){
        Call<RegisterPojo> req= ManagerAll.getInstance().kayitOl(userMailAdres,userName,userPass);
        req.enqueue(new Callback<RegisterPojo>() {
            @Override
            public void onResponse(Call<RegisterPojo> call, Response<RegisterPojo> response) {
                if(response.body().isTf()){
                    Toast.makeText(getApplicationContext(), response.body().getText(), Toast.LENGTH_LONG).show();
                }
                else{
                    Toast.makeText(getApplicationContext(), response.body().getText(), Toast.LENGTH_LONG).show();
                }

            }

            @Override
            public void onFailure(Call<RegisterPojo> call, Throwable t) {
                Toast.makeText(getApplicationContext(), Warnings.internetProblemText, Toast.LENGTH_LONG).show();

            }
        });
    }

}