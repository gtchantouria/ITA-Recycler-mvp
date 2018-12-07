package com.example.gtachantouria.mimeliapp.Login;

public class LoginPresenter implements LoginHelper.OnLoginFinishedListener {

    private Login login;
    private LoginView loginView;
    private LoginHelper loginInteractor;

    LoginPresenter(LoginView loginView, LoginHelper loginInteractor) {
        this.loginView = loginView;
        this.loginInteractor = loginInteractor;
        this.login = new Login();
    }

    public void validateCredentials(String username, String password) {
        if (loginView != null) {
            loginView.showProgress();
        }

        loginInteractor.login(username, password, this);
    }

    public void onDestroy() {
        loginView = null;
    }

    @Override
    public void onUsernameError() {
        if (loginView != null) {
            loginView.setUsernameError();
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
            this.login.sentMessageEvent();
            loginView.navigateToHome();
        }
    }

    @Override
    public void updateUsername(String user) {
        this.login.setUsername(user);
    }

    @Override
    public void updatePass(String pass) {
        this.login.setPassword(pass);
    }
}