package com.shreyansh.tictictoe;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ChooseGameType extends AppCompatActivity {
    LinearLayout onlinePlayLayout, gameTypeLayout, myRoomLayout,createRoomLayout;
    EditText roomOwnerET,roomNameET,roomIdET;
    TextView roomIdTv, roomOwnerTV,player2Name;
    Button findPlayerButton;
    String roomOwner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_game_type);
        //createRoomET = findViewById(R.id.createRoomET);
        player2Name = findViewById(R.id.player2Name);
        roomOwnerET = findViewById(R.id.roomOwnerET);
        roomNameET = findViewById(R.id.roomNameET);
        roomIdET = findViewById(R.id.roomIdET);
        onlinePlayLayout = findViewById(R.id.onlinePlayLayout);
        gameTypeLayout = findViewById(R.id.gameTypeLayout);
        myRoomLayout = findViewById(R.id.myRoomLayout);
        createRoomLayout = findViewById(R.id.createRoomLayout);
        roomIdTv = findViewById(R.id.roomIdTv);
        roomOwnerTV = findViewById(R.id.roomOwnerTV);
        findPlayerButton = findViewById(R.id.findPlayerButton);
        if(checkIfIdAvailable()) visibleRoomDetails();
    }

    private boolean checkIfIdAvailable() {
        SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", MODE_PRIVATE);
        if(pref.getString("myRoomName","noData").equals("noData"))
            return false;
        return true;
    }

    public void playOnline(View view) {
        gameTypeLayout.setVisibility(View.GONE);
        onlinePlayLayout.setVisibility(View.VISIBLE);
    }

    public void playOffline(View view) {
        startActivity(new Intent(ChooseGameType.this, MainActivity.class));
    }

    public void playWithComputer(View view) {
    }


    public void startOnline(final View view) {
        String roomName = roomIdET.getText().toString();
        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        if(findPlayerButton.getText().equals(MyConstants.startGame)){
                DatabaseReference myRef = database.getReference("rooms").child(roomName.toUpperCase());
                TicTacToeModel model = new TicTacToeModel(0,0,0,0,0,0,0,0,0,0,0,0,
                        0,0,0,0,0,0,0,0,0,0,0,0,
                        0,0,0,0,0,0,true,roomOwner,
                        player2Name.getText().toString(),roomOwner,1,10,1,0,0,0,1,"Not Yet",roomOwner);
                myRef.setValue(model);
                Intent i = new Intent(ChooseGameType.this, TicTacTowFirebase.class);
                i.putExtra(MyConstants.roomName,roomName.toUpperCase());
                i.putExtra(MyConstants.player2,player2Name.getText().toString());
                startActivity(i);
                finish();
        }
        else if(findPlayerButton.getText().equals(MyConstants.findPlayer)){
            if(roomName.isEmpty())
                Toast.makeText(this, "Room ID can't be Empty", Toast.LENGTH_SHORT).show();
            else{
                DatabaseReference myRef = database.getReference("rooms").child(roomName.toUpperCase());
                final ProgressDialog progressDialog = new ProgressDialog(ChooseGameType.this);
                progressDialog.setMessage("Processing.. please wait");
                progressDialog.show();
                myRef.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if(!dataSnapshot.exists()) {
                            Toast.makeText(ChooseGameType.this, "Room Doesn't Exists", Toast.LENGTH_SHORT).show();
                            progressDialog.dismiss();
                        }
                        else {
                            TicTacToeModel ticTacToeModel = dataSnapshot.getValue(TicTacToeModel.class);
                            roomIdET.setVisibility(View.GONE);
                            roomOwnerTV.setVisibility(View.VISIBLE);
                            roomOwner = ticTacToeModel.getRoomOwner();
                            roomOwnerTV.setText("Player Name: "+ ticTacToeModel.getRoomOwner());
                            findPlayerButton.setText(MyConstants.startGame);
                            progressDialog.dismiss();
                        }
                    }
                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }
        }

    }

    public void shareRoomId(View view) {

    }

    public void createRoom(View view) {
        // Write a message to the database
        if(!roomNameET.getText().toString().isEmpty()){
            FirebaseDatabase database = FirebaseDatabase.getInstance();
            DatabaseReference myRef = database.getReference("rooms").child(roomNameET.getText().toString().toUpperCase());
            TicTacToeModel model = new TicTacToeModel(0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,true,roomOwnerET.getText().toString(),"",roomOwnerET.getText().toString(),1,10,1,0,0,0,1,"Not Yet","");
            myRef.setValue(model);
            Toast.makeText(this, "Room Created!!!", Toast.LENGTH_SHORT).show();
            SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", MODE_PRIVATE);
            SharedPreferences.Editor editor = pref.edit();
            editor.putString("myRoomName",roomNameET.getText().toString()).apply();
            visibleRoomDetails();
        }
        else Toast.makeText(this, "Please fill all Mendatory Fields", Toast.LENGTH_SHORT).show();
    }
    private void visibleRoomDetails() {
        createRoomLayout.setVisibility(View.GONE);
        SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", MODE_PRIVATE);
        myRoomLayout.setVisibility(View.VISIBLE);
        roomIdTv.setText(pref.getString("myRoomName","noData"));
    }

    @Override
    public void onBackPressed() {
        if(onlinePlayLayout.getVisibility() == View.VISIBLE){
            onlinePlayLayout.setVisibility(View.GONE);
            gameTypeLayout.setVisibility(View.VISIBLE);
        }
        else super.onBackPressed();
    }
}
