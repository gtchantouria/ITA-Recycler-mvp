package com.example.gtachantouria.mimeliapp.Login;

public class Login {
    private String password = "", email = "";

    public Login() {
    }

    public Login(String fullName, String email) {
        this.password = fullName;
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
