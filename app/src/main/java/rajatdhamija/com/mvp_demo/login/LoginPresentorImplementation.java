package rajatdhamija.com.mvp_demo.login;

/**
 * Created by rajatdhamija on 14/10/17.
 */

public class LoginPresentorImplementation implements LoginInteractor.OnLoginFinishedListener, LoginPresenter {

    private LoginView loginView;
    private LoginInteractor loginInteractor;

    public LoginPresentorImplementation(LoginView loginView) {
        this.loginView = loginView;
        this.loginInteractor = new LoginInteractorImplementation();
    }

    @Override
    public void validateCredentials(String email, String password) {
        if (loginView != null) {
            loginView.showProgress();
        }
        loginInteractor.loginUser(email, password, this);
    }

    @Override
    public void onDestroy() {
        loginView = null;
    }

    @Override
    public void onEmailError() {
        if (loginView != null) {
            loginView.setEmailError();
            loginView.hideProgress();
        }

    }

    @Override
    public void onPasswordError() {
        if (loginView != null) {
            loginView.setPasswordError();
            loginView.hideProgress();
        }

    }

    @Override
    public void onSuccess() {
        if (loginView != null) {
            loginView.navigateToHomeActivity();
        }
    }
}
