package com.yetsdmr.javamvparchitecture.view.Main;

import com.yetsdmr.javamvparchitecture.model.User;

import java.util.List;

public interface MainView {

    interface View{
        void onSuccess(String message);
        void onError(String message);
    }

    interface Presenter{
        void doLogin(User user);
    }
}
