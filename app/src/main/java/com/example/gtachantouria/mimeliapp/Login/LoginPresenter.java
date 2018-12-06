package com.example.gtachantouria.mimeliapp.Login;

public class LoginPresenter {
    private Login login;
    private View view;

    public LoginPresenter(View view) {
        this.login = new Login();
        this.view = view;
    }

    public void updatePassword(String pass){
        login.setPassword(pass);
    }

    public void updateEmail(String email){
        login.setEmail(email);
    }

    public boolean checkLogin(String email, String pass){
        return (email == "email" && pass == "123");
    }

    public interface View{
        void validarLogin();
    }
}
