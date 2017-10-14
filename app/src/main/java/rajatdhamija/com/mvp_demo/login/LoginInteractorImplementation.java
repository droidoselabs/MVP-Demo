package rajatdhamija.com.mvp_demo.login;

import android.os.Handler;
import android.text.TextUtils;

/**
 * Created by rajatdhamija on 14/10/17.
 */

public class LoginInteractorImplementation implements LoginInteractor {
    @Override
    public void loginUser(final String email, final String password, final OnLoginFinishedListener onLoginFinishedListener) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                boolean error = false;
                if (TextUtils.isEmpty(email)) {
                    onLoginFinishedListener.onEmailError();
                    error = true;
                    return;
                }
                if (TextUtils.isEmpty(password)) {
                    onLoginFinishedListener.onPasswordError();
                    error = true;
                    return;
                }
                if (!error) {
                    onLoginFinishedListener.onSuccess();
                }
            }
        }, 2000);
    }
}
