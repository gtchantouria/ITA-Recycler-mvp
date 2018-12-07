package com.example.gtachantouria.mimeliapp.Login;

import android.os.Handler;
import android.text.TextUtils;

public class LoginHelper {
    interface OnLoginFinishedListener {
        void onUsernameError();
        void onPasswordError();
        void onSuccess();
        void updateUsername(String user);
        void updatePass(String pass);
    }

    public void login(final String username, final String password, final OnLoginFinishedListener listener) {
        // Mock login. I'm creating a handler to delay the answer a couple of seconds
        new Handler().postDelayed(() -> {
            if (TextUtils.isEmpty(username)) {
                listener.onUsernameError();
                return;
            }
            if (TextUtils.isEmpty(password)) {
                listener.onPasswordError();
                return;
            }
            listener.updateUsername(username);
            listener.updatePass(password);
            listener.onSuccess();
        }, 2000);
    }
}
