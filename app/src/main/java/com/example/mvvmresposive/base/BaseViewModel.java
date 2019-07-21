package com.example.mvvmresposive.base;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import androidx.lifecycle.ViewModel;

import com.example.mvvmresposive.event.LoadingEvent;

public class BaseViewModel extends ViewModel implements LifecycleObserver {

    private LoadingEvent loadingEvent;
    public BaseViewModel() {
    }
    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public void onViewModelCreate() {
        //do something
    }
    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public void onViewModelDelete(){
        loadingEvent = null;
    }
    public void setLoading(LoadingEvent event) {
        loadingEvent = event;
    }

    protected void showProgress() {
        if (loadingEvent != null)
            loadingEvent.showProgress();
    }

    protected void hideProgress() {
        if (loadingEvent != null)
            loadingEvent.hideProgress();
    }

}
