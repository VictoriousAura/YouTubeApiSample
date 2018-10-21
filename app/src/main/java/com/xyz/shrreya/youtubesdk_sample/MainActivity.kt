package com.xyz.shrreya.youtubesdk_sample

import android.nfc.Tag
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import com.google.android.youtube.player.YouTubeBaseActivity
import com.google.android.youtube.player.YouTubeInitializationResult
import com.google.android.youtube.player.YouTubePlayer
import com.google.android.youtube.player.YouTubePlayerView

class MainActivity : YouTubeBaseActivity() {
     private val TAG : String="MainActivity"

     lateinit var buttonPlay :Button
     lateinit var mYouTubePlayerView :YouTubePlayerView
     lateinit var mOnInitializedListener : YouTubePlayer.OnInitializedListener


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        buttonPlay= findViewById<Button>(R.id.button_Play)
        mYouTubePlayerView= findViewById<YouTubePlayerView>(R.id.youtubePlayer)

        mOnInitializedListener= object : YouTubePlayer.OnInitializedListener{
            override fun onInitializationSuccess(provider: YouTubePlayer.Provider, youTubePlayer: YouTubePlayer, b: Boolean) {
                Log.d(TAG,"onCreate: Done Initializing")
                youTubePlayer.loadVideo("URL to your Video")
                //for adding a playlist
                //youTubePlayer.loadPlaylist("")
            }

            override fun onInitializationFailure(provider: YouTubePlayer.Provider, youTubeInitializationResult: YouTubeInitializationResult) {
                Log.d(TAG,"onCreate: Failed to Initialize")

            }
        }

        buttonPlay.setOnClickListener(object : View.OnClickListener{
            override fun onClick(v: View?) {
                Log.d(TAG,"onClick: Initializing YouTubePlayer")

                mYouTubePlayerView.initialize(YouTubeConfig.apiKey,mOnInitializedListener)
            }

            })


    }


}
