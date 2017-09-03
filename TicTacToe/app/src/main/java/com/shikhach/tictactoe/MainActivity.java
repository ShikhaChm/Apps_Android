package com.shikhach.tictactoe;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    static int[][] tt = new int[3][3];
    static int gameOn = 1;
    static int userToggle = 1;

    public void gameReset() {
        for(int i=0;i<3;i++) {
            for(int j=0;j<3;j++) {
                tt[i][j] = 0;
            }
        }
        gameOn = 1;
        userToggle = 1;
        ImageView iv11 = (ImageView) findViewById(R.id.iv11);
        ImageView iv12 = (ImageView) findViewById(R.id.iv12);
        ImageView iv13 = (ImageView) findViewById(R.id.iv13);
        ImageView iv21 = (ImageView) findViewById(R.id.iv21);
        ImageView iv22 = (ImageView) findViewById(R.id.iv22);
        ImageView iv23 = (ImageView) findViewById(R.id.iv23);
        ImageView iv31 = (ImageView) findViewById(R.id.iv31);
        ImageView iv32 = (ImageView) findViewById(R.id.iv32);
        ImageView iv33 = (ImageView) findViewById(R.id.iv33);
        iv11.setImageResource(R.drawable.board);
        iv12.setImageResource(R.drawable.board);
        iv13.setImageResource(R.drawable.board);
        iv21.setImageResource(R.drawable.board);
        iv22.setImageResource(R.drawable.board);
        iv23.setImageResource(R.drawable.board);
        iv31.setImageResource(R.drawable.board);
        iv32.setImageResource(R.drawable.board);
        iv33.setImageResource(R.drawable.board);
    }

    public void toggleUser() {
        if(userToggle==1) {
            userToggle=2;
        } else {
            userToggle=1;
        }
    }
    public void makeToast(String s) {
        Toast.makeText(this, s, Toast.LENGTH_LONG).show();
    }
    public boolean userWon(int user) {
        int resId =R.drawable.cross;
        if(user==2) {
            resId = R.drawable.round;
        }
        boolean won = false;
        ImageView iv11 = (ImageView) findViewById(R.id.iv11);
        ImageView iv12 = (ImageView) findViewById(R.id.iv12);
        ImageView iv13 = (ImageView) findViewById(R.id.iv13);
        ImageView iv21 = (ImageView) findViewById(R.id.iv21);
        ImageView iv22 = (ImageView) findViewById(R.id.iv22);
        ImageView iv23 = (ImageView) findViewById(R.id.iv23);
        ImageView iv31 = (ImageView) findViewById(R.id.iv31);
        ImageView iv32 = (ImageView) findViewById(R.id.iv32);
        ImageView iv33 = (ImageView) findViewById(R.id.iv33);

        if((tt[0][0]==user) && (tt[0][1]==user) && (tt[0][2]==user)) {
            iv11.setImageResource(resId);
            iv12.setImageResource(resId);
            iv13.setImageResource(resId);
            won = true;
        }
        if((tt[1][0]==user) && (tt[1][1]==user) && (tt[1][2]==user)) {
            iv21.setImageResource(resId);
            iv22.setImageResource(resId);
            iv23.setImageResource(resId);
            won = true;
        }
        if((tt[2][0]==user) && (tt[2][1]==user) && (tt[2][2]==user)) {
            iv31.setImageResource(resId);
            iv32.setImageResource(resId);
            iv33.setImageResource(resId);
            won = true;
        }
        if((tt[0][0]==user) && (tt[1][0]==user) && (tt[2][0]==user)) {
            iv11.setImageResource(resId);
            iv21.setImageResource(resId);
            iv31.setImageResource(resId);
            won = true;
        }
        if((tt[0][1]==user) && (tt[1][1]==user) && (tt[2][1]==user)) {
            iv12.setImageResource(resId);
            iv22.setImageResource(resId);
            iv32.setImageResource(resId);
            won = true;
        }
        if((tt[0][2]==user) && (tt[1][2]==user) && (tt[2][2]==user)) {
            iv13.setImageResource(resId);
            iv23.setImageResource(resId);
            iv33.setImageResource(resId);
            won = true;
        }
        if((tt[0][0]==user) && (tt[1][1]==user) && (tt[2][2]==user)) {
            iv11.setImageResource(resId);
            iv22.setImageResource(resId);
            iv33.setImageResource(resId);
            won = true;
        }
        if((tt[2][0]==user) && (tt[1][1]==user) && (tt[0][2]==user)) {
            iv31.setImageResource(resId);
            iv22.setImageResource(resId);
            iv13.setImageResource(resId);
            won = true;
        }
        if(won) {
            makeToast("Player "+String.valueOf(user)+" won, yay!!");
        }

        return won;
    }

    public void resetClick(View view) {
        gameReset();
    }
    public boolean gameFillOver() {
        int sum = 0;
        for(int i =0;i<3;i++) {
            for(int j=0;j<3;j++) {
                if(tt[i][j]>0) {
                    sum = sum+1;
                }
            }
        }
        return (sum==9);
    }
    public void click(ImageView iview,int i,int j) {
        if(gameOn==1) {
            if(tt[i][j]==0) {
                tt[i][j] = userToggle;
                if(userToggle==1) {
                    iview.setImageResource(R.drawable.cross);
                } else {
                    iview.setImageResource(R.drawable.round);
                }
                if(userWon(userToggle)) {
                    gameOn=0;
                }
                if(gameFillOver()) {
                    gameOn=0;
                    makeToast("Game Over: No winner. Click Restart to play again!");
                }
                toggleUser();
            } else {
                makeToast("Invalid Click, Click Elsewhere");
            }
        } else {
            makeToast("Game Over. Click Restart to play again!");
        }
    }
    public void play1(View view) {
        ImageView iview = (ImageView) findViewById(R.id.iv11);
        click(iview,0,0);
    }
    public void play2(View view) {
        ImageView iview = (ImageView) findViewById(R.id.iv12);
        click(iview,0,1);
    }
    public void play3(View view) {
        ImageView iview = (ImageView) findViewById(R.id.iv13);
        click(iview,0,2);
    }
    public void play4(View view) {
        ImageView iview = (ImageView) findViewById(R.id.iv21);
        click(iview,1,0);
    }
    public void play5(View view) {
        ImageView iview = (ImageView) findViewById(R.id.iv22);
        click(iview,1,1);
    }
    public void play6(View view) {
        ImageView iview = (ImageView) findViewById(R.id.iv23);
        click(iview,1,2);
    }
    public void play7(View view) {
        ImageView iview = (ImageView) findViewById(R.id.iv31);
        click(iview,2,0);
    }
    public void play8(View view) {
        ImageView iview = (ImageView) findViewById(R.id.iv32);
        click(iview,2,1);
    }
    public void play9(View view) {
        ImageView iview = (ImageView) findViewById(R.id.iv33);
        click(iview,2,2);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}