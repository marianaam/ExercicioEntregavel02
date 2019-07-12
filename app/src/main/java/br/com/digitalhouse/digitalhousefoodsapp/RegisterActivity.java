package br.com.digitalhouse.digitalhousefoodsapp;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class RegisterActivity extends AppCompatActivity {

    private TextInputEditText registerNameEditText;
    private TextInputEditText registerEmailEditText;
    private TextInputEditText registerPasswordEditText;
    private TextInputEditText registerRepeatPasswordEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        registerNameEditText = findViewById(R.id.register_name_edit_text);
        registerEmailEditText = findViewById(R.id.register_email_edit_text);
        registerPasswordEditText = findViewById(R.id.register_password_edit_text);
        registerRepeatPasswordEditText = findViewById(R.id.register_repeat_password_edit_text);

        Button botaoRegisterRegister = findViewById(R.id.register_register_button);
        botaoRegisterRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                botaoClicado(v);
            }
        });


    }

    private void botaoClicado(View view) {

        registerNameEditText.setError(null);
        registerEmailEditText.setError(null);
        registerPasswordEditText.setError(null);
        registerRepeatPasswordEditText.setError(null);


        if(!registerPasswordEditText.getEditableText().toString().equals(registerRepeatPasswordEditText.getEditableText().toString())) {
            registerPasswordEditText.setError("As senhas não conferem");
            registerRepeatPasswordEditText.setError("As senhas não conferem");
        }else if(registerPasswordEditText.getEditableText().toString().equals("")){
            registerPasswordEditText.setError("Campo obrigatório");
        } else if (registerEmailEditText.getEditableText().toString().equals("")){
            registerEmailEditText.setError("Campo obrigatório");
        } else {
            Snackbar.make(view, "Usuário cadastro com sucesso", Snackbar.LENGTH_INDEFINITE)
                    .setAction("OK", new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            irParaHome();
                        }
                    }).setActionTextColor(getResources().getColor(R.color.azulFacebook))
                    .show();
        }



    }

    private void irParaHome() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
