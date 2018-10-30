package com.elegant.mining;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.elegant.mining.interfaces.ApiService;
import com.elegant.mining.models.Authenticate;
import com.elegant.mining.models.AuthenticateResponse;
import com.elegant.mining.models.AuthenticateResponseResult;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {
    private static final String TAG = LoginActivity.class.getSimpleName();

    private EditText _emailText;
    private EditText _passwordText;
    private AppCompatButton _loginButton;
    private ApiService _apiService;
    private ProgressDialog _progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initialize();
        _apiService = ApiClient.getRetrofitInstance().create(ApiService.class);
    }

    private void initialize() {
        _progressDialog = new ProgressDialog(this);
        _emailText = findViewById(R.id.input_email);
        _passwordText = findViewById(R.id.input_password);
        _loginButton = findViewById(R.id.btn_login);
    }

    public void click(View view) {
        switch (view.getId()){
            case R.id.btn_login:
                login();
                break;
        }
    }

    private void login() {
        Log.d(TAG, "Login");

        if (!checkConnection()){
            Toast.makeText(getApplicationContext(), "Internet Baglantinizda Sorun Var", Toast.LENGTH_LONG).show();
            return;
        }

        if (!validate()) {
            onLoginFailed();
            return;
        }

        _loginButton.setEnabled(false);

        _progressDialog.setIndeterminate(true);
        _progressDialog.setMessage("Authenticating...");
        _progressDialog.show();

        String email = _emailText.getText().toString();
        String password = _passwordText.getText().toString();

        Authenticate authenticate = new Authenticate();
        authenticate.setUserNameOrEmailAddress(email);
        authenticate.setPassword(password);
        authenticate.setRememberClient(true);
        Call<AuthenticateResponseResult> call = _apiService.authenticate(authenticate);
        call.enqueue(new Callback<AuthenticateResponseResult>() {
            @Override
            public void onResponse(Call<AuthenticateResponseResult> call, Response<AuthenticateResponseResult> response) {
                if (response.isSuccessful()){
                    AuthenticateResponseResult resp = response.body();
                    assert resp != null;
                    Log.d(TAG,resp.getResult().getAccessToken()+"");
                    onLoginSuccess();

                }else {
                    onLoginFailed();

                }

            }

            @Override
            public void onFailure(Call<AuthenticateResponseResult> call, Throwable t) {
                onLoginFailed();
            }
        });


    }
    public void onLoginSuccess() {
        _loginButton.setEnabled(true);
        _progressDialog.dismiss();

        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);

    }

    public void onLoginFailed() {
        Toast.makeText(getBaseContext(), "Login failed", Toast.LENGTH_LONG).show();

        _loginButton.setEnabled(true);
        _progressDialog.dismiss();

    }

    public boolean validate() {
        boolean valid = true;

        String email = _emailText.getText().toString();
        String password = _passwordText.getText().toString();

        if (email.isEmpty()) {
            _emailText.setError("enter a valid user name or email address");
            valid = false;
        } else if(email.contains("@")){
            if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                _emailText.setError("enter a valid user name or email address");
                valid = false;
            }
        }
        else {
            _emailText.setError(null);
        }

        if (password.isEmpty() || password.length() < 4 || password.length() > 10) {
            _passwordText.setError("between 4 and 10 alphanumeric characters");
            valid = false;
        } else {
            _passwordText.setError(null);
        }

        return valid;
    }

    public boolean checkConnection() {

        ConnectivityManager conMgr = (ConnectivityManager) getSystemService (Context.CONNECTIVITY_SERVICE);

        if (conMgr.getActiveNetworkInfo() != null

                && conMgr.getActiveNetworkInfo().isAvailable()

                && conMgr.getActiveNetworkInfo().isConnected()) {

            return true;

        } else {

            return false;

        }

    }
}

