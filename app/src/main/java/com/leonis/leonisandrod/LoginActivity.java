package com.leonis.leonisandrod;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class LoginActivity extends AppCompatActivity {
    private static final String TAG = "LoginActivity";
    private static final int REQUEST_SIGNUP = 0;

    // имена переменных для сохранения пароля
    public static final String APP_PREFERENCES = "loginsettings";
    public static final String APP_PREFERENCES_LOGIN = "login";
    public static final String APP_PREFERENCES_PASSWORD = "password";

    SharedPreferences mSettings;

    @InjectView(R.id.input_login)
    EditText _loginText;

    @InjectView(R.id.input_password)
    EditText _passwordText;

    @InjectView(R.id.btn_login)
    Button _loginButton;

    @InjectView(R.id.link_smsSignIn)
    TextView _signupLink;

    @InjectView(R.id.passwordRadioButton)
    RadioButton _passwordSave;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.inject(this);

        _loginButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                login();
            }
        });

        _signupLink.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // Start the Signup activity
                //            Intent intent = new Intent(getApplicationContext(), SignupActivity.class);
                //   startActivityForResult(intent, REQUEST_SIGNUP);
            }
        });

        _passwordSave.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

            }
        });

        _passwordSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                _passwordSave.setChecked(!(_passwordSave.isChecked()));
            }
        });


        mSettings = getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE);
        if (mSettings.contains(APP_PREFERENCES_LOGIN) && mSettings.contains(APP_PREFERENCES_PASSWORD)) {
            _loginText.setText(mSettings.getString(APP_PREFERENCES_LOGIN, ""));
            _passwordText.setText(mSettings.getString(APP_PREFERENCES_PASSWORD, ""));
        }
    }

    public void login() {
        Log.d(TAG, "Login");

        if (!validate()) {
            onLoginFailed();
            return;
        }

        _loginButton.setEnabled(false);

        final ProgressDialog progressDialog = new ProgressDialog(LoginActivity.this,
                R.style.AppTheme_Dark_Dialog);
        progressDialog.setIndeterminate(true);
        progressDialog.setMessage("Авторизация...");
        progressDialog.show();
        progressDialog.setCancelable(false);

        String email = _loginText.getText().toString();
        String password = _passwordText.getText().toString();

        // TODO: Implement your own authentication logic here.

        new android.os.Handler().postDelayed(
                new Runnable() {
                    public void run() {
                        // On complete call either onLoginSuccess or onLoginFailed
                        onLoginSuccess();
                        //  onLoginFailed();
                        progressDialog.dismiss();

                        startActivity(new Intent(LoginActivity.this, MainActivity.class));
                    }
                }, 3000);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_SIGNUP) {
            if (resultCode == RESULT_OK) {

                // TODO: Implement successful signup logic here
                // By default we just finish the Activity and log them in automatically
                this.finish();
            }
        }
    }

    @Override
    public void onBackPressed() {
        // disable going back to the MainActivity
        moveTaskToBack(true);
    }

    public void onLoginSuccess() {
        if (_passwordSave.isChecked()) {
            //login and password save
            String sharedLogin = _loginText.getText().toString();
            String sharedPassword = _passwordText.getText().toString();
            SharedPreferences.Editor editor = mSettings.edit();
            editor.putString(APP_PREFERENCES_LOGIN, sharedLogin);
            editor.putString(APP_PREFERENCES_PASSWORD, sharedPassword);
            editor.apply();
        }

        _loginButton.setEnabled(true);
    }

    public void onLoginFailed() {
        Toast.makeText(getBaseContext(), "Не получилось авторизировать пользователя", Toast.LENGTH_LONG).show();

        _loginButton.setEnabled(true);
    }

    public boolean validate() {
        boolean valid = true;

        String email = _loginText.getText().toString();
        String password = _passwordText.getText().toString();

        if (email.isEmpty()) {
            _loginText.setError("Введите логин");
            valid = false;
        } else {
            _loginText.setError(null);
        }

        if (password.isEmpty()) {
            _passwordText.setError("Введите пароль");
            valid = false;
        } else {
            _passwordText.setError(null);
        }

        return valid;
    }
}