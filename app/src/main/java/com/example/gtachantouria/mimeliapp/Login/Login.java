package com.example.gtachantouria.mimeliapp.Login;

import com.example.gtachantouria.mimeliapp.rest.event.MessageEvent;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class Login {
    EventBus bus = EventBus.getDefault();

    private String password = "", username = "";

    public Login() {
    }

    public Login(String fullName, String email) {
        this.password = fullName;
        this.username = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void sentMessageEvent(){
        String message =  "Username : " + this.username + "\nPass : " + this.password;
        bus.post(new MessageEvent(message));
    }
}
