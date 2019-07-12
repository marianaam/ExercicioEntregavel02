package br.com.digitalhouse.digitalhousefoodsapp;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LoginActivity extends AppCompatActivity {

    private TextInputEditText emailEditText;
    private TextInputEditText senhaEditText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        emailEditText = findViewById(R.id.login_email_edit_text);

        Button botaoLogin = findViewById(R.id.login_button);
        botaoLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                irParaHome();
            }
        });

        Button botaoRegister = findViewById(R.id.register_button);
        botaoRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                irParaRegister();
            }
        });
    }

    private void irParaHome() {

        Intent intent = new Intent(this, MainActivity.class);
        Bundle bundle = new Bundle();
        String email = emailEditText.getEditableText().toString();
        bundle.putString("EMAIL", email);
        intent.putExtras(bundle);
        startActivity(intent);

    }

    private void irParaRegister() {

        Intent intent = new Intent(this, RegisterActivity.class);
        startActivity(intent);

    }
}
