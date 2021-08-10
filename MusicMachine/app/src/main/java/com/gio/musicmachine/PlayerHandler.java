package com.gio.musicmachine;

import android.os.Handler;
import android.os.Message;
import android.os.RemoteException;

import androidx.annotation.NonNull;

public class PlayerHandler extends Handler {
    private PlayerService mplayerService;

    public PlayerHandler(PlayerService playerService){
        mplayerService = playerService;
    }

    @Override
    public void handleMessage(@NonNull Message msg) {
        switch (msg.arg1) {
            case 0: // Play
                mplayerService.play();
                break;
            case 1:// Pause
                mplayerService.pause();
                break;
            case 2: //isPlaying
                int isPlaying = mplayerService.isPlaying() ? 1 : 0;
                Message message = Message.obtain();
                message.arg1 = isPlaying;
                if (msg.arg2 == 1 ) {
                    message.arg2 = 1;
                }
                message.replyTo = mplayerService.mMessenger;
                try {
                    msg.replyTo.send(message);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
                break;
        }
    }
}
