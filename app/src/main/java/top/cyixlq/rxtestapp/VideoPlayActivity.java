package top.cyixlq.rxtestapp;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

public class VideoPlayActivity extends AppCompatActivity {

    private VideoView mVideoVIew;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_play);
        mVideoVIew=findViewById(R.id.video);
        mVideoVIew.setMediaController(new MediaController(this));
        mVideoVIew.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                Toast.makeText(VideoPlayActivity.this, "播放完成了", Toast.LENGTH_SHORT).show();
            }
        });
        startPlay();
    }

    private void startPlay(){
        Intent intent=getIntent();
        String url=intent.getStringExtra("url");
        if(null!=url) {
            mVideoVIew.setVideoURI(Uri.parse(url));
            mVideoVIew.start();
        }
    }
}
