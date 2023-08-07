package com.example.calculator2.thread;

import android.content.Context;
import android.content.res.ColorStateList;
import android.os.Build;
import android.widget.Button;
import androidx.core.content.ContextCompat;
import com.example.calculator2.R;


public class ChangeColorThread extends Thread {
    private final Button button;
    private final Context context;

    public ChangeColorThread(Context context, Button button) {
        this.button = button;
        this.context = context;
    }

    @Override
    public void run() {
        int buttonColorGreen = ContextCompat.getColor(context, R.color.green);
        int buttonColorGrey = ContextCompat.getColor(context, R.color.layoutButton);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            button.setBackgroundTintList(ColorStateList.valueOf(buttonColorGreen));
        }
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            throw new RuntimeException("Thread could not weak up " + Thread.currentThread().getName(), e);
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            button.setBackgroundTintList(ColorStateList.valueOf(buttonColorGrey));
        }
    }
}