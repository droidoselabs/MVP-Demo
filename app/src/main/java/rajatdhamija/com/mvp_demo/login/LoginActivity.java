package rajatdhamija.com.mvp_demo.login;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatEditText;
import android.view.View;
import android.widget.ProgressBar;

import butterknife.BindView;
import butterknife.ButterKnife;
import rajatdhamija.com.mvp_demo.R;

public class LoginActivity extends AppCompatActivity implements LoginView, View.OnClickListener {
    @BindView(R.id.etEmail)
    AppCompatEditText etEmail;

    @BindView(R.id.etPassword)
    AppCompatEditText etPassword;

    @BindView(R.id.btnLogin)
    AppCompatButton btnLogin;

    private ProgressBar pbLogin;

    private LoginPresenter loginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        btnLogin.setOnClickListener(this);
        pbLogin = (ProgressBar) findViewById(R.id.pbLogin);
        loginPresenter = new LoginPresentorImplementation(this);
    }

    @Override
    public void onClick(View view) {
        loginPresenter.validateCredentials(etEmail.getText().toString().trim(), etPassword.getText().toString().trim());
    }

    @Override
    public void showProgress() {
        pbLogin.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        pbLogin.setVisibility(View.INVISIBLE);
    }

    @Override
    public void setEmailError() {
        etEmail.setError(getString(R.string.error_invalid_email));
        etEmail.requestFocus();
    }

    @Override
    public void setPasswordError() {
        etPassword.setError(getString(R.string.error_invalid_password));
        etEmail.requestFocus();
    }

    @Override
    public void navigateToHomeActivity() {
        pbLogin.setVisibility(View.GONE);
        Snackbar snackbar = Snackbar
                .make(pbLogin, "Login Successful", Snackbar.LENGTH_LONG);

        snackbar.show();
    }

    @Override
    protected void onDestroy() {
        loginPresenter.onDestroy();
        super.onDestroy();
    }
}
