package dev.edmt.aplikasipetanifix.admin;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import dev.edmt.aplikasipetanifix.R;

public class admin_buatakunadd extends AppCompatActivity implements View.OnClickListener{


    private Button daftarkan;
    private EditText email;
    private EditText password;
    private FirebaseAuth firebaseAuth;
    private ProgressDialog progressDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_buatakunadd);

        firebaseAuth = FirebaseAuth.getInstance();
        email = (EditText) findViewById(R.id.etemail);
        password = (EditText) findViewById(R.id.etpassword);
        daftarkan = (Button) findViewById(R.id.daftarkan);

        progressDialog = new ProgressDialog(this);

        daftarkan.setOnClickListener(this);
    }

    private void usrdaftarkan(){
        String em = email.getText().toString().trim();
        String pa = password.getText().toString().trim();

        if(TextUtils.isEmpty(em)){
            Toast.makeText(this, "Mohon masukan email ",Toast.LENGTH_LONG).show();
            return;
        }

        if (TextUtils.isEmpty(pa)){
            Toast.makeText(this, "Mohon masukan password ",Toast.LENGTH_LONG).show();
            return;

        }
        progressDialog.setMessage("Sedang proses ....");
        progressDialog.show();

        firebaseAuth.createUserWithEmailAndPassword(em,pa)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        progressDialog.dismiss();

                        if (task.isSuccessful()){
                        Toast.makeText(admin_buatakunadd.this, "pendaftaran berhasil", Toast
                        .LENGTH_LONG).show();
                       }else{
                            Toast.makeText(admin_buatakunadd.this, "pendaftaran gagal", Toast
                                    .LENGTH_LONG).show();
                        }
                    }
                });
    }

    @Override
    public void onClick(View v) {
        if(v == daftarkan){
            usrdaftarkan();
        }

    }
}
