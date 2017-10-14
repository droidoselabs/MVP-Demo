package rajatdhamija.com.mvp_demo.login;

/**
 * Created by rajatdhamija on 14/10/17.
 */

public interface LoginInteractor {
    interface OnLoginFinishedListener {
        void onEmailError();

        void onPasswordError();

        void onSuccess();
    }

    void loginUser(String email, String password, OnLoginFinishedListener onLoginFinishedListener);
}
