package com.tahhu.coba;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;

import androidx.annotation.OptIn;
import androidx.appcompat.app.AppCompatActivity;
import androidx.media3.common.MediaItem;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.exoplayer.ExoPlayer;



public class RadioStreamin extends AppCompatActivity {
    private ExoPlayer player;
    private SeekBar seekBar;
    private Handler handler = new Handler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radio_streamin);
        player = new ExoPlayer.Builder(this).build();
        MediaItem mediaItem = MediaItem.fromUri(Uri.parse("https://stream.swadesifm.com/radio/8000/radio.mp3"));
        player.setMediaItem(mediaItem);

        ImageView playButton = findViewById(R.id.play_pause);
        ImageView back = findViewById(R.id.back_beranda);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
            }
        });
        seekBar = findViewById(R.id.seekBar);

        playButton.setOnClickListener(new View.OnClickListener() {
            @OptIn(markerClass = UnstableApi.class)
            @Override
            public void onClick(View v) {
                if (player.isPlaying()) {
                    player.pause();
                    playButton.setImageResource(R.drawable.play_icon);
                } else {
                    player.prepare();
                    player.play();
                    playButton.setImageResource(R.drawable.pause);
                    updateSeekBar(); // Mulai memperbarui SeekBar
                }
            }
        });
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (fromUser) {
                    long seekPosition = (player.getDuration() * progress) / 100;
                    player.seekTo(seekPosition);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                handler.removeCallbacks(updateSeekBarRunnable);
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                updateSeekBar();
            }
        });


    }
    private Runnable updateSeekBarRunnable = new Runnable() {
        @Override
        public void run() {
            if (player != null && player.isPlaying()) {
                int progress = (int) ((player.getCurrentPosition() * 100) / player.getDuration());
                seekBar.setProgress(progress);
                handler.postDelayed(this, 1000);
            }
        }
    };

    private void updateSeekBar() {
        handler.postDelayed(updateSeekBarRunnable, 0);
    }
    @Override
    protected void onStop() {
        super.onStop();
        player.release();
    }

}