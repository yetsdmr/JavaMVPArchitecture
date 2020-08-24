package com.yetsdmr.javamvparchitecture.view.Main;

import com.yetsdmr.javamvparchitecture.model.User;

import java.util.List;

public class MainPresenter implements MainView.Presenter{

    MainView.View view;

    public MainPresenter(MainView.View view) {
        this.view = view;
    }

    @Override
    public void doLogin(User user) {
        //username: yetsdmr
        //password: Pass123
        if (user.getUsername().equals("yetsdmr") && user.getPassword().equals("Pass123")){
            view.onSuccess("Successful!");
        }else {
            view.onError("Wrong username or password!");
        }

    }
}
