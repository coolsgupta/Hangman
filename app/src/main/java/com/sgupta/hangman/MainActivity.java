package com.sgupta.hangman;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView mHint;
    private TextView mStatus;
    private TextView mString;
    private EditText mAnswer;
    private Button mOkButton;
    private Game mGame = new Game();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mHint = (TextView) findViewById(R.id.hintTextView);
        mStatus = (TextView) findViewById(R.id.statusTextView);
        mString = (TextView) findViewById(R.id.stringTextView);
        mAnswer = (EditText) findViewById(R.id.input);
        mOkButton = (Button) findViewById(R.id.okButton);

        final int[] end = {0};

        start();


        mOkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                   try{
                       if (end[0] == 1 || end[0] == -1) {
                           end[0] = 0;
                           start();
                       } else if (end[0] == 0) {
                           //try {
                               mGame.checkAnswer(mAnswer.getText().toString());
                           /*}catch(Exception e){
                               mGame.setStatus(-3);
                               mStatus.setText(mGame.getStatus());
                               end[0]=0;
                           }*/
                           end[0] = mGame.checkWin();
                           mStatus.setText(mGame.getStatus());
                           mString.setText(mGame.getFakeAnswer());
                           mAnswer.setText("");
                           if (end[0] == 1 || end[0] == -1) {
                               mOkButton.setText(R.string.play_again);
                               mStatus.setText(mGame.getStatus());
                               mAnswer.setVisibility(View.INVISIBLE);
                           }
                       }
                   }catch(Exception e){

                   }
            }
        });
    }

    private void start(){
        mGame.StartGame();
        mHint.setText(mGame.getHint());
        mString.setText(mGame.getFakeAnswer());
        mStatus.setText(mGame.getStatus());
        mOkButton.setText("OK");
        mAnswer.setVisibility(View.VISIBLE);
    }
}