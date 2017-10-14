package rajatdhamija.com.mvp_demo.login;

/**
 * Created by rajatdhamija on 14/10/17.
 */

public interface LoginPresenter {

    void validateCredentials(String email, String password);

    void onDestroy();
}
