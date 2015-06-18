package com.example.oladapo.groupapp.activities;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.TextView;
import com.example.oladapo.groupapp.R;

/**
 * A login screen that offers login via email/password.
 */
public class LoginActivity extends Activity  {


    // UI references.
    private EditText mEmailView;
    private EditText mPasswordView;
    private View signInButton;
    private boolean hasEmail;
    private boolean hasPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        signInButton = findViewById(R.id.email_sign_in_button);
        // Set up the login form.
        mEmailView = (EditText) findViewById(R.id.email);
        mPasswordView = (EditText) findViewById(R.id.password);
        final int action = getResources().getInteger(R.integer.customImeActionId);
        mPasswordView.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int id, KeyEvent keyEvent) {
                if (id == action) {
                    attemptLogin();
                }
                return false;
            }
        });
        mEmailView.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                hasEmail = s.length() != 0;
                updateButtonState();
            }
        });
        mPasswordView.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                hasPassword = s.length() != 0;
                updateButtonState();
            }
        });

        signInButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                attemptLogin();
            }
        });
        findViewById(R.id.email_forgot_password).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                forgotPassword();
            }
        });
        updateButtonState();

    }

    private void updateButtonState() {
        if (hasEmail && hasPassword) {
            signInButton.setEnabled(true);
            hideErrorText();
        } else {
            signInButton.setEnabled(false);
        }
    }

    /**
     * Attempts to sign in or register the account specified by the login form.
     * If there are form errors (invalid email, missing fields, etc.), the
     * errors are presented and no actual login attempt is made.
     */
    public void attemptLogin() {


        // Store values at the time of the login attempt.
        String email = mEmailView.getText().toString();
        String password = mPasswordView.getText().toString();
        showProgress();
        login(email, password);

    }


    protected void login(String username, String password) {

    }

    private void goMain() {

    }

    protected void forgotPassword() {

    }

    private void showErrorText() {
        if (findViewById(R.id.prompt).getVisibility() == View.VISIBLE) {
            findViewById(R.id.prompt).setVisibility(View.GONE);
            findViewById(R.id.error).setVisibility(View.VISIBLE);
            findViewById(R.id.error_box).setVisibility(View.VISIBLE);
            mPasswordView.setText("");
        }
    }

    private void hideErrorText() {
        if (findViewById(R.id.prompt).getVisibility() == View.GONE) {
            findViewById(R.id.prompt).setVisibility(View.VISIBLE);
            findViewById(R.id.error).setVisibility(View.GONE);
            findViewById(R.id.error_box).setVisibility(View.GONE);
        }
    }

    private void showProgress() {
        findViewById(R.id.login_progress).setVisibility(View.VISIBLE);
    }

    private void hideProgress() {
        findViewById(R.id.login_progress).setVisibility(View.GONE);
    }



}



