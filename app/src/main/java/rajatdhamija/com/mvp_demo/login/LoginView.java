package rajatdhamija.com.mvp_demo.login;

/**
 * Created by rajatdhamija on 14/10/17.
 */

public interface LoginView {
    void showProgress();

    void hideProgress();

    void setEmailError();

    void setPasswordError();

    void navigateToHomeActivity();
}
