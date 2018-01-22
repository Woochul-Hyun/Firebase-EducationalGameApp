package com.example.woochulhyun.educationalgameapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.woochulhyun.educationalgameapp.Common.Common;
import com.example.woochulhyun.educationalgameapp.Model.User;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.rengwuxian.materialedittext.MaterialAutoCompleteTextView;
import com.rengwuxian.materialedittext.MaterialEditText;

public class MainActivity extends AppCompatActivity {

    MaterialEditText edtNewUser, edtNewPassword;                        //for sign up
    MaterialEditText edtUser, edtPassword;                              // for sign in

    Button btnSignup, btnSignIn;

    FirebaseDatabase database;                                    //connecting Firebase Database
    DatabaseReference users;                                     //connecting Firebase Database


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Firebase
        database= FirebaseDatabase.getInstance();
        users = database.getReference("Users");                                   //The Name on category in Firebase Database where this java class call

        edtUser = (MaterialEditText)findViewById(R.id.edtUser);                      //Refers
        edtPassword = (MaterialEditText)findViewById(R.id.edtPassword);

        btnSignIn = (Button)findViewById(R.id.btn_sign_in);
        btnSignup = (Button)findViewById(R.id.btn_sign_up);

        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showSignUpDialog();
            }
        });

        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signIn(edtUser.getText().toString(),edtPassword.getText().toString());
            }
        });
    }

    private void signIn(final String user, final String pwd) {
        users.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot.child(user).exists())
                {
                    if(!user.isEmpty())                                                                          //Id section must be filled
                    {
                        User login = dataSnapshot.child(user).getValue(User.class);                              //Checking user Id is exist or not
                        if(login.getPassword().equals(pwd))                                                      //checking user id and password is matching or not
                        {
                            Intent homeActivity = new Intent(MainActivity.this,Home.class);     //if user id and password is matching and click button
                                                                                                                //page move from MainActivity to Home
                            Common.currentUser = login;
                            startActivity(homeActivity);
                            finish();
                        }
                        else                                                                                  //When the password is not matching with id
                            Toast.makeText(MainActivity.this, "Wrong password!", Toast.LENGTH_SHORT).show();
                    }

                    else                                                                                    //When ID section is empty
                    {
                        Toast.makeText(MainActivity.this, "Please enter your user name!", Toast.LENGTH_SHORT).show();
                    }
                }
                else                                                                                         //When the Id is not exist
                    Toast.makeText(MainActivity.this, "User is not exists!", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    private void  showSignUpDialog(){
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(MainActivity.this);   //make AlertDialog for sign up
        alertDialog.setTitle("Sign up");                                                    //display the word in sign up AlertDialog
        alertDialog.setMessage("Please fill full information");

        LayoutInflater inflater= this.getLayoutInflater();
        View sign_up_layout = inflater.inflate(R.layout.sign_up_layout,null);

        edtNewUser = (MaterialEditText)sign_up_layout.findViewById(R.id.edtNewUserName);
        edtNewPassword = (MaterialEditText)sign_up_layout.findViewById(R.id.edtNewPassword);

        alertDialog.setView(sign_up_layout);
        alertDialog.setIcon(R.drawable.ic_account_circle_black_24dp);                    //icon for sign up AlertDialog

        alertDialog.setNegativeButton("NO", new DialogInterface.OnClickListener() {
            @Override                                                                    //No button in AlertDialog
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });

        alertDialog.setPositiveButton("YES", new DialogInterface.OnClickListener() {
            @Override                                                                    //Yes button in AlertDialog to create new Id and password
            public void onClick(DialogInterface dialogInterface, int i) {
                final User user= new User(edtNewUser.getText().toString(),
                        edtNewPassword.getText().toString());

                users.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        if(dataSnapshot.child(user.getUserName()).exists())          //when user same user id is already exits
                            Toast.makeText(MainActivity.this, "User already exits!", Toast.LENGTH_SHORT).show();

                        else
                        {
                            users.child(user.getUserName()).setValue(user);             //user id is created successfully
                            Toast.makeText(MainActivity.this, "User registration success!", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });

                dialogInterface.dismiss();
            }
        });

        alertDialog.show();
    }
}
