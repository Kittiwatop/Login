package com.example.login;

import android.content.ContentValues;
import android.content.DialogInterface;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.login.db.DatabaseHelper;

public class Register extends AppCompatActivity {
    private EditText mNameEditText, mUserEditText,mPassEditText;
    private Button mSaveButton;

    private DatabaseHelper mHelper;
    private SQLiteDatabase mDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mHelper = new DatabaseHelper(this);
        mDb= mHelper.getWritableDatabase();

        mNameEditText =(EditText) findViewById(R.id.regisname);
        mUserEditText =(EditText) findViewById(R.id.regisuser);
        mPassEditText =(EditText) findViewById(R.id.regispass);
        mSaveButton =(Button) findViewById(R.id.createaccount);
        mSaveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name =mNameEditText.getText().toString();
                String user =mUserEditText.getText().toString();
                String pass =mPassEditText.getText().toString();

                ContentValues cv =new ContentValues();
                cv.put(DatabaseHelper.COL_NAME, name);
                cv.put(DatabaseHelper.COL_USERNAME, user);
                cv.put(DatabaseHelper.COL_PASSWORD, pass);
                mDb.insert(DatabaseHelper.TABLE_NAME, null, cv);


                if(false){
                    AlertDialog.Builder a = new AlertDialog.Builder(Register.this);
                    a.setTitle("Registration Failed");
                    a.setMessage("Username already usesd");
                    a.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                        }
                    });

                }else{
                    Toast.makeText(Register.this, "Create account successfully", Toast.LENGTH_SHORT).show();
                }
                finish();
            }
        });
    }
}
