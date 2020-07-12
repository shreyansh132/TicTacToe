package com.shreyansh.tictictoe;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class TicTacTowFirebase extends AppCompatActivity implements ValueEventListener{
    FirebaseDatabase database;
    DatabaseReference readRef;
    DatabaseReference writeRef;
    TicTacToeModel ticTacToeModel;
    int flag = 0, ax = 10, zero = 1, win = 0, i, game = 1;
    int summ = 0, ctrflag = 0, resetchecker = 1, currentgamedonechecker = 0;
    int score1 = 0, score2 = 0, drawchecker = 0;
    static int[][] tracker = new int[3][3];
    int[] sum = new int[8];
    static int[][] buttonpressed = new int[3][3];
    boolean player1ax;
    TextView p1;
    TextView p2;
    String roomOwner;
    String player1 = "Player 1";
    String player2 = "Player 2";
    String roomName;
    String player_turn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tic_tic_tow_firebase);
        database = FirebaseDatabase.getInstance();
        roomName = getIntent().getStringExtra(MyConstants.roomName);
        player2 = getIntent().getStringExtra(MyConstants.player2);
        readRef = database.getReference("rooms").child(roomName);
        writeRef = database.getReference("rooms").child(roomName);
        readRef.addValueEventListener(this);
        if (player1ax) {
            ax = 1;
            zero = 10;
        }
        p1 = (TextView) findViewById(R.id.playerone);
        p2 = (TextView) findViewById(R.id.playertwo);
        p1.setText(player1);
        p2.setText(player2);
        Toast.makeText(this, "" + player1 + "\'s turn", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
       ticTacToeModel = dataSnapshot.getValue(TicTacToeModel.class);
       updateVariables();
       printBoard();
    }

    @Override
    public void onCancelled(@NonNull DatabaseError databaseError) {

    }

    public void updateVariables(){
        roomOwner = ticTacToeModel.getRoomOwner();
        flag = ticTacToeModel.getFlag();
        win = ticTacToeModel.getWin();
        score1 = ticTacToeModel.getScore1();
        score2 = ticTacToeModel.getScore2();
        player1 = ticTacToeModel.getPlayer1();
        player2 = ticTacToeModel.getPlayer2();
        player1ax = ticTacToeModel.isPlayer1ax();
        ax = ticTacToeModel.getAx();
        zero = ticTacToeModel.getZero();
        currentgamedonechecker = ticTacToeModel.getCurrentgamedonechecker();
        resetchecker = ticTacToeModel.getResetchecker();
        drawchecker = ticTacToeModel.getDrawchecker();
        ctrflag = ticTacToeModel.getCtrflag();
        buttonpressed[0][0] = ticTacToeModel.getButtonpressed00();
        buttonpressed[0][1] = ticTacToeModel.getButtonpressed01();
        buttonpressed[0][2] = ticTacToeModel.getButtonpressed02();
        buttonpressed[1][0] = ticTacToeModel.getButtonpressed10();
        buttonpressed[1][1] = ticTacToeModel.getButtonpressed11();
        buttonpressed[1][2] = ticTacToeModel.getButtonpressed12();
        buttonpressed[2][0] = ticTacToeModel.getButtonpressed20();
        buttonpressed[2][1] = ticTacToeModel.getButtonpressed21();
        buttonpressed[2][2] = ticTacToeModel.getButtonpressed22();
        tracker[0][0] = ticTacToeModel.getTracker00();
        tracker[0][1] = ticTacToeModel.getTracker01();
        tracker[0][2] = ticTacToeModel.getTracker02();
        tracker[1][0] = ticTacToeModel.getTracker10();
        tracker[1][1] = ticTacToeModel.getTracker11();
        tracker[1][2] = ticTacToeModel.getTracker12();
        tracker[2][0] = ticTacToeModel.getTracker20();
        tracker[2][1] = ticTacToeModel.getTracker21();
        tracker[2][2] = ticTacToeModel.getTracker22();
        sum[0] = ticTacToeModel.getSum0();
        sum[1] = ticTacToeModel.getSum1();
        sum[2] = ticTacToeModel.getSum2();
        sum[3] = ticTacToeModel.getSum3();
        sum[4] = ticTacToeModel.getSum4();
        sum[5] = ticTacToeModel.getSum5();
        sum[6] = ticTacToeModel.getSum6();
        sum[7] = ticTacToeModel.getSum7();
        player_turn = ticTacToeModel.getPlayer_turn();
        Log.e("Logging",ticTacToeModel.toString());
        p1.setText(player1);
        p2.setText(player2);
        if(!ticTacToeModel.getResult().equals("Not Yet")){
            if(ticTacToeModel.getResult().equals(MyConstants.drawMessage))
                showDialog(ticTacToeModel.getResult(),player1,""+score1,player2,""+score2);
            showDialog(ticTacToeModel.getResult(),player1,""+score1,player2,""+score2);
        }
    }
    public void kzz(View view) {
        if (win == 0 && buttonpressed[0][0] == 0) {
            if (flag % 2 == 0){
                tracker[0][0] = ax;
                writeRef.child(MyConstants.tracker00).setValue(ax);
            }
            else{
                tracker[0][0] = zero;
                writeRef.child(MyConstants.tracker00).setValue(zero);
            }
            winchecker();
            //printBoard();
            writeRef.child(MyConstants.flag).setValue(++flag);
            writeRef.child(MyConstants.buttonpressed00).setValue(++buttonpressed[0][0]);
        }
    }
    public void kzo(View view) {
            if (win == 0 && buttonpressed[0][1] == 0) {
                if (flag % 2 == 0) {
                    tracker[0][1] = ax;
                    writeRef.child(MyConstants.tracker01).setValue(ax);
                } else {
                    tracker[0][1] = zero;
                    writeRef.child(MyConstants.tracker01).setValue(zero);
                }
                // printBoard();
                winchecker();
                writeRef.child(MyConstants.flag).setValue(++flag);
                writeRef.child(MyConstants.buttonpressed01).setValue(++buttonpressed[0][1]);
            }
    }
    public void kzt(View view) {
            if (win == 0 && buttonpressed[0][2] == 0) {
                if (flag % 2 == 0) {
                    tracker[0][2] = ax;
                    writeRef.child(MyConstants.tracker02).setValue(ax);
                } else {
                    tracker[0][2] = zero;
                    writeRef.child(MyConstants.tracker02).setValue(zero);
                }
                //printBoard();
                winchecker();
                writeRef.child(MyConstants.flag).setValue(++flag);
                writeRef.child(MyConstants.buttonpressed02).setValue(++buttonpressed[0][2]);
            }
    }
    public void koz(View v) {
            if (win == 0 && buttonpressed[1][0] == 0) {
                if (flag % 2 == 0) {
                    tracker[1][0] = ax;
                    writeRef.child(MyConstants.tracker10).setValue(ax);
                } else {
                    tracker[1][0] = zero;
                    writeRef.child(MyConstants.tracker10).setValue(zero);
                }
                // printBoard();
                winchecker();
                writeRef.child(MyConstants.flag).setValue(++flag);
                writeRef.child(MyConstants.buttonpressed10).setValue(++buttonpressed[1][0]);
            }
    }
    public void koo(View v) {
            if (win == 0 && buttonpressed[1][1] == 0) {
                if (flag % 2 == 0) {
                    tracker[1][1] = ax;
                    writeRef.child(MyConstants.tracker11).setValue(ax);
                } else {
                    tracker[1][1] = zero;
                    writeRef.child(MyConstants.tracker11).setValue(zero);
                }
                //printBoard();
                winchecker();
                writeRef.child(MyConstants.flag).setValue(++flag);
                writeRef.child(MyConstants.buttonpressed11).setValue(++buttonpressed[1][1]);
            }
        }
    public void kot(View v) {
            if (win == 0 && buttonpressed[1][2] == 0) {
                if (flag % 2 == 0) {
                    tracker[1][2] = ax;
                    writeRef.child(MyConstants.tracker12).setValue(ax);
                } else {
                    tracker[1][2] = zero;
                    writeRef.child(MyConstants.tracker12).setValue(zero);
                }
                //printBoard();
                winchecker();
                writeRef.child(MyConstants.flag).setValue(++flag);
                writeRef.child(MyConstants.buttonpressed12).setValue(++buttonpressed[1][2]);
            }
        }
    public void ktz(View v) {
            if (win == 0 && buttonpressed[2][0] == 0) {
                if (flag % 2 == 0) {
                    tracker[2][0] = ax;
                    writeRef.child(MyConstants.tracker20).setValue(ax);
                } else {
                    tracker[2][0] = zero;
                    writeRef.child(MyConstants.tracker20).setValue(zero);
                }
                // printBoard();
                winchecker();
                writeRef.child(MyConstants.flag).setValue(++flag);
                writeRef.child(MyConstants.buttonpressed20).setValue(++buttonpressed[2][0]);
            }
    }
    public void kto(View v) {
            if (win == 0 && buttonpressed[2][1] == 0) {
                if (flag % 2 == 0) {
                    tracker[2][1] = ax;
                    writeRef.child(MyConstants.tracker21).setValue(ax);
                } else {
                    tracker[2][1] = zero;
                    writeRef.child(MyConstants.tracker21).setValue(zero);
                }
                //printBoard();
                winchecker();
                writeRef.child(MyConstants.flag).setValue(++flag);
                writeRef.child(MyConstants.buttonpressed21).setValue(++buttonpressed[2][1]);
            }
    }
    public void ktt(View v) {
            if (win == 0 && buttonpressed[2][2] == 0) {
                if (flag % 2 == 0) {
                    tracker[2][2] = ax;
                    writeRef.child(MyConstants.tracker22).setValue(ax);
                } else {
                    tracker[2][2] = zero;
                    writeRef.child(MyConstants.tracker22).setValue(zero);
                }
                //printBoard();
                winchecker();
                writeRef.child(MyConstants.flag).setValue(++flag);
                writeRef.child(MyConstants.buttonpressed22).setValue(++buttonpressed[2][2]);
            }
    }
    public void printBoard() {
        ImageView q1, q2, q3, q4, q5, q6, q7, q8, q9;
        q1 = (ImageView) findViewById(R.id.tzz);
        q2 = (ImageView) findViewById(R.id.tzo);
        q3 = (ImageView) findViewById(R.id.tzt);
        q4 = (ImageView) findViewById(R.id.toz);
        q5 = (ImageView) findViewById(R.id.too);
        q6 = (ImageView) findViewById(R.id.tot);
        q7 = (ImageView) findViewById(R.id.ttz);
        q8 = (ImageView) findViewById(R.id.tto);
        q9 = (ImageView) findViewById(R.id.ttt);

        if (tracker[0][0] == 1) q1.setImageResource(R.drawable.x);
        if (tracker[0][0] == 10) q1.setImageResource(R.drawable.oo);

        if (tracker[0][1] == 1) q2.setImageResource(R.drawable.x);
        if (tracker[0][1] == 10) q2.setImageResource(R.drawable.oo);

        if (tracker[0][2] == 1) q3.setImageResource(R.drawable.x);
        if (tracker[0][2] == 10) q3.setImageResource(R.drawable.oo);

        if (tracker[1][0] == 1) q4.setImageResource(R.drawable.x);
        if (tracker[1][0] == 10) q4.setImageResource(R.drawable.oo);

        if (tracker[1][1] == 1) q5.setImageResource(R.drawable.x);
        if (tracker[1][1] == 10) q5.setImageResource(R.drawable.oo);

        if (tracker[1][2] == 1) q6.setImageResource(R.drawable.x);
        if (tracker[1][2] == 10) q6.setImageResource(R.drawable.oo);

        if (tracker[2][0] == 1) q7.setImageResource(R.drawable.x);
        if (tracker[2][0] == 10) q7.setImageResource(R.drawable.oo);

        if (tracker[2][1] == 1) q8.setImageResource(R.drawable.x);
        if (tracker[2][1] == 10) q8.setImageResource(R.drawable.oo);

        if (tracker[2][2] == 1) q9.setImageResource(R.drawable.x);
        if (tracker[2][2] == 10) q9.setImageResource(R.drawable.oo);

        resetchecker++;
    }
    public void winchecker() {
        writeRef.child(MyConstants.ctrflag).setValue(++ctrflag);
        //ctrflag++;
        writeRef.child(MyConstants.sum0).setValue(tracker[0][0] + tracker[0][1] + tracker[0][2]);
        writeRef.child(MyConstants.sum1).setValue(tracker[1][0] + tracker[1][1] + tracker[1][2]);
        writeRef.child(MyConstants.sum2).setValue(tracker[2][0] + tracker[2][1] + tracker[2][2]);
        writeRef.child(MyConstants.sum3).setValue(tracker[0][0] + tracker[1][0] + tracker[2][0]);
        writeRef.child(MyConstants.sum4).setValue(tracker[0][1] + tracker[1][1] + tracker[2][1]);
        writeRef.child(MyConstants.sum5).setValue(tracker[0][2] + tracker[1][2] + tracker[2][2]);
        writeRef.child(MyConstants.sum6).setValue(tracker[0][0] + tracker[1][1] + tracker[2][2]);
        writeRef.child(MyConstants.sum7).setValue(tracker[0][2] + tracker[1][1] + tracker[2][0]);

        sum[0] = tracker[0][0] + tracker[0][1] + tracker[0][2];
        sum[1] = tracker[1][0] + tracker[1][1] + tracker[1][2];
        sum[2] = tracker[2][0] + tracker[2][1] + tracker[2][2];
        sum[3] = tracker[0][0] + tracker[1][0] + tracker[2][0];
        sum[4] = tracker[0][1] + tracker[1][1] + tracker[2][1];
        sum[5] = tracker[0][2] + tracker[1][2] + tracker[2][2];
        sum[6] = tracker[0][0] + tracker[1][1] + tracker[2][2];
        sum[7] = tracker[0][2] + tracker[1][1] + tracker[2][0];

        writeRef.child(MyConstants.currentgamedonechecker).setValue(++currentgamedonechecker);
        //currentgamedonechecker++;
        writeRef.child(MyConstants.resetchecker).setValue(++resetchecker);
        //resetchecker++;

        for (int i = 0; i < 8; i++)
            if (sum[i] == 3 || sum[i] == 30) {
                writeRef.child(MyConstants.win).setValue(++win);
                //win++;
                if ((sum[i] == 3) && (ax == 1)) {
                    writeRef.child(MyConstants.score1).setValue(++score1);
                    //score1++;
                    TextView q1 = (TextView) findViewById(R.id.p1score);
                    q1.setText("" + score1);
                    writeRef.child(MyConstants.result).setValue(player1+" Won");
                }
                if ((sum[i] == 3) && (zero == 1)) {
                    writeRef.child(MyConstants.score2).setValue(++score2);
                    //score2++;
                    TextView q1 = (TextView) findViewById(R.id.p2score);
                    q1.setText("" + score2);
                    //showDialog("" + player2 + " won!", "" + score2, "" + player1, "" + score1);
                    writeRef.child(MyConstants.result).setValue(player2+" Won");
                }
                if ((sum[i] == 30) && (ax == 10)) {
                    writeRef.child(MyConstants.score1).setValue(++score1);
                    //score1++;
                    TextView q1 = (TextView) findViewById(R.id.p1score);
                    q1.setText("" + score1);
                    //showDialog("" + player1 + " won!", "" + score1, "" + player2, "" + score2);
                    writeRef.child(MyConstants.result).setValue(player1+" Won");
                }
                if ((sum[i] == 30) && (zero == 10)) {
                    writeRef.child(MyConstants.score2).setValue(++score2);
                    //score2++;
                    TextView q1 = (TextView) findViewById(R.id.p2score);
                    q1.setText("" + score2);
                    //showDialog("" + player2 + " won!", "" + score2, "" + player1, "" + score1);
                    writeRef.child(MyConstants.result).setValue(player2+" Won");
                }
            }

        if ((ctrflag == 9) && (win == 0)) {
            showDialog(MyConstants.drawMessage,player1, ""+score1, player2, ""+score2);
            writeRef.child(MyConstants.drawchecker).setValue(++drawchecker);
            writeRef.child(MyConstants.result).setValue(MyConstants.drawMessage);
            //drawchecker++;
        }
    }
    //end winchecker()
    public void showDialog(String message, String player1, String score1, String player2, String score2) {
        final AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
        final View v = getLayoutInflater().inflate(R.layout.dialog_layout, null);
        TextView playerOneScore = v.findViewById(R.id.player_one_score);
        TextView playerTwoScore = v.findViewById(R.id.player_two_score);
        TextView playerOneName = v.findViewById(R.id.player_one_name);
        TextView playerTwoName = v.findViewById(R.id.player_two_name);
        TextView titleText = v.findViewById(R.id.title_text);
        Button resetButton = v.findViewById(R.id.reset_button);
        Button playAgainButton = v.findViewById(R.id.play_again_button);
        titleText.setText(message);
        playerOneName.setText(player1);
        playerTwoName.setText(player2);
        playerOneScore.setText(score1);
        playerTwoScore.setText(score2);
        alertDialog.setView(v);
        final AlertDialog alert = alertDialog.create();
        alert.setCanceledOnTouchOutside(false);
        alert.show();

        playAgainButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playmore();
                alert.dismiss();
            }
        });
        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                doreset();
                alert.dismiss();
            }
        });
    }
    private void playmore() {
        if ((drawchecker > 0) || (win > 0)) {
            game++;
            TextView qq = (TextView) findViewById(R.id.gamenumber);
            qq.setText("" + game);

            for (int i = 0; i < 8; i++)
                sum[i] = 0;

            drawchecker = 0;
            ImageView q1, q2, q3, q4, q5, q6, q7, q8, q9;
            q1 = (ImageView) findViewById(R.id.tzz);
            q2 = (ImageView) findViewById(R.id.tzo);
            q3 = (ImageView) findViewById(R.id.tzt);
            q4 = (ImageView) findViewById(R.id.toz);
            q5 = (ImageView) findViewById(R.id.too);
            q6 = (ImageView) findViewById(R.id.tot);
            q7 = (ImageView) findViewById(R.id.ttz);
            q8 = (ImageView) findViewById(R.id.tto);
            q9 = (ImageView) findViewById(R.id.ttt);
            q1.setImageDrawable(null);
            q2.setImageDrawable(null);
            q3.setImageDrawable(null);
            q4.setImageDrawable(null);
            q5.setImageDrawable(null);
            q6.setImageDrawable(null);
            q7.setImageDrawable(null);
            q8.setImageDrawable(null);
            q9.setImageDrawable(null);

            for (int i = 0; i < 3; i++)
                for (int j = 0; j < 3; j++)
                    buttonpressed[i][j] = 0;

            for (int i = 0; i < 3; i++)
                for (int j = 0; j < 3; j++)
                    tracker[i][j] = 0;

            if ((game + 1) % 2 == 0)
                Toast.makeText(this, "" + player1 + "\'s turn", Toast.LENGTH_SHORT).show();
            else
                Toast.makeText(this, "" + player2 + "\'s turn", Toast.LENGTH_SHORT).show();
            win = 0;
            summ = 0;
            ctrflag = 0;
            flag = (game + 1) % 2;
            currentgamedonechecker = 0;
            TicTacToeModel model = new TicTacToeModel(flag,0,0,0,0,0,0,0,0,0,0,0,0,
                    0,0,0,0,0,0,
                    score1,score2,0,0,0,
                    0,0,0,0,
                    0,0,true,player1,player2,roomOwner,
                    1,10,1,0,0,0,game,MyConstants.notYet,player1);
            writeRef.setValue(model);
        }
    }
    public void doreset() {
        TextView qq = (TextView) findViewById(R.id.gamenumber);
        qq.setText("" + 1);

        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                tracker[i][j] = 0;

        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                buttonpressed[i][j] = 0;

        ImageView q1, q2, q3, q4, q5, q6, q7, q8, q9;

        q1 = (ImageView) findViewById(R.id.tzz);
        q2 = (ImageView) findViewById(R.id.tzo);
        q3 = (ImageView) findViewById(R.id.tzt);
        q4 = (ImageView) findViewById(R.id.toz);
        q5 = (ImageView) findViewById(R.id.too);
        q6 = (ImageView) findViewById(R.id.tot);
        q7 = (ImageView) findViewById(R.id.ttz);
        q8 = (ImageView) findViewById(R.id.tto);
        q9 = (ImageView) findViewById(R.id.ttt);
        q1.setImageDrawable(null);
        q2.setImageDrawable(null);
        q3.setImageDrawable(null);
        q4.setImageDrawable(null);
        q5.setImageDrawable(null);
        q6.setImageDrawable(null);
        q7.setImageDrawable(null);
        q8.setImageDrawable(null);
        q9.setImageDrawable(null);
        win = 0;
        drawchecker = 0;
        summ = 0;
        resetchecker = 0;
        ctrflag = 0;
        score1 = 0;
        score2 = 0;
        game = 1;
        flag = 0;
        currentgamedonechecker = 0;
        TextView qqq = (TextView) findViewById(R.id.p1score);
        qqq.setText("" + score1);
        TextView qqqq = (TextView) findViewById(R.id.p2score);
        qqqq.setText("" + score2);
        TicTacToeModel model = new TicTacToeModel(0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
                0,0,0,0,0,0,0,0,0,0,0,true,player1,player2,roomOwner,
                1,10,1,0,0,0,1,MyConstants.notYet,player1);
        writeRef.setValue(model);
        Toast.makeText(this, "" + player1 + "\'s turn", Toast.LENGTH_SHORT).show();
    }
    private void showExitDialog() {
        final Dialog dialog = new Dialog(TicTacTowFirebase.this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_layout_exit);
        dialog.setCancelable(false);

        dialog.show();

        Button exit = dialog.findViewById(R.id.yes_button);
        final Button dismiss = dialog.findViewById(R.id.no_button);

        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                doreset();
                finish();
            }
        });

        dismiss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
    }
    @Override
    public void onBackPressed() {
        showExitDialog();
    }
}