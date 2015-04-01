package com.example.ledzee.timedquiz;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;


public class MainActivity extends ActionBarActivity {
   @Override
   protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView question;
        Button trueButton;
        QuestionnAnswers qa = new QuestionnAnswers();
        Random randomGenerator = new Random();
        int randomNumber = randomGenerator.nextInt(qa.questions.size());
        question = (TextView) findViewById(R.id.questionView);

       question.setText(qa.getQuestion(randomNumber));
        trueButton = (Button)findViewById(R.id.trueButton);


       new CountDownTimer(16000, 1000) {

            //Log.v(MyTaG, "index=" + i);
            public void onFinish() {
                Log.d("myTag","CountDownTimer is running");
                Intent startActivity = new Intent(MainActivity.this, SecondQuestion.class);
                startActivity(startActivity);
                finish();

                question.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Log.d("OnclickTag", "Onclick is working");
                        Intent startActivity2 = new Intent(MainActivity.this, WrongAnswerActivity.class);
                        startActivity(startActivity2);

                    }
                });

            }
            public void onTick(long millisUntilFinished) {
            }
        }.start();

        trueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("OnclickTag", "Onclick is working");
                Intent startActivity2 = new Intent(MainActivity.this, SecondQuestion.class);
                startActivity(startActivity2);
            }
        });

    }

}
