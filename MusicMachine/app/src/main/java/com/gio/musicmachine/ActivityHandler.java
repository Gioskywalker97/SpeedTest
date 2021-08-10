package com.gio.musicmachine;

import android.os.Handler;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;

import androidx.annotation.NonNull;

public class ActivityHandler extends Handler {
    private MainActivity mMainActivity;

    public ActivityHandler(MainActivity mainActivity) {
        mMainActivity = mainActivity;
    }

    @Override
    public void handleMessage(@NonNull Message msg) {
        if (msg.arg1 == 0) {
            //Music is NOT playing
            if (msg.arg2 == 1) {
                mMainActivity.changePlayButtonText("Play");
            } else {
                // Play the music
                Message message = Message.obtain();
                message.arg1 = 0;
                try {
                    msg.replyTo.send(message);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
                //Change Play button to say "Pause"
                mMainActivity.changePlayButtonText("Pause");
            }
        } else if (msg.arg1 == 1) {
            //Music is playing
            if (msg.arg2 == 1) {
                mMainActivity.changePlayButtonText("Pause");
            } else {
                // Pause the music
                Message message = Message.obtain();
                message.arg1 = 1;
                try {
                    msg.replyTo.send(message);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
                //Change Play button to say "Play"
                mMainActivity.changePlayButtonText("Play");
            }
        }
    }
}
