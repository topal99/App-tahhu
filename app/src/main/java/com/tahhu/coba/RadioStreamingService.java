package com.tahhu.coba;

import android.app.Service;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.os.Handler;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.io.IOException;

public class RadioStreamingService extends Service {

    private MediaPlayer mediaPlayer;
    private final Handler handler = new Handler();

    @Override
    public void onCreate() {
        super.onCreate();
        mediaPlayer = new MediaPlayer();
        mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);  // Untuk mendengarkan audio
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        String radioUrl = intent.getStringExtra("radio_url");

        try {
            mediaPlayer.setDataSource(radioUrl);
            mediaPlayer.prepareAsync(); // Asynchronous prepare
            mediaPlayer.setOnPreparedListener(mp -> {
                mediaPlayer.start();
                Toast.makeText(RadioStreamingService.this, "Radio Streaming Started", Toast.LENGTH_SHORT).show();
            });
        } catch (IOException e) {
            e.printStackTrace();
            stopSelf();
        }

        return START_STICKY; // Menjaga service agar tetap berjalan meskipun aplikasi dihentikan
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mediaPlayer != null) {
            mediaPlayer.stop();
            mediaPlayer.release();
        }
        Toast.makeText(this, "Radio Streaming Stopped", Toast.LENGTH_SHORT).show();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

}
