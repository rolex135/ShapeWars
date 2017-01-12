package com.mkproductions.shapewars;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.ImageView;


public class GameActivity extends AppCompatActivity {
    Game newGame;
    ImageView mainCharacter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        mainCharacter = (ImageView)findViewById(R.id.main_character);
        newGame = new Game(mainCharacter);
        newGame.startRun();
    }

    @Override
    public void onBackPressed(){
        super.onBackPressed();
        newGame.stopRun();
    }

    @Override
    public boolean onTouchEvent(MotionEvent e){
        newGame.onTouchEvent(e);
        return true;
    }
}
