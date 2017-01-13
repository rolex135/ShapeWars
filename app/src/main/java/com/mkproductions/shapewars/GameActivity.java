package com.mkproductions.shapewars;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.ImageView;


public class GameActivity extends AppCompatActivity {
    Game game;
    ImageView mainCharacter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        mainCharacter = (ImageView)findViewById(R.id.main_character);
        game = new Game(this);
        setContentView(game);
        game.start();
    }

    @Override
    public void onBackPressed(){
        super.onBackPressed();
        game.pause();
    }

    @Override
    public boolean onTouchEvent(MotionEvent e){
        game.onTouchEvent(e);
        return true;
    }
}
