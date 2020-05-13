package com.gxun.mycalc;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

public class MyViewModel extends ViewModel {
    private MutableLiveData<String> number;
    public MutableLiveData<String> getNumber() {
        if (number == null) {
            number = new MutableLiveData<>();
            number.setValue("");
        }
        return number;
    }

    public void save(String x) {
        number.setValue(x);
        if (number.getValue() == null) {
            number.setValue("");
        }
    }
}
