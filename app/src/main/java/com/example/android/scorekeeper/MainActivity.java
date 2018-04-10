package com.example.android.scorekeeper;

import android.app.Activity;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.VideoView;
import java.util.ArrayList;

/**
 * An App for tracking soccer game statistics
 * Version 6
 */

public class MainActivity extends Activity {
    String[] teamGroups = {"Russia","Saudi Arabia","Egypt","Uruguay","Portugal","Spain", "Morocco","Iran",
            "France","Australia","Peru","Denmark","Argentina","Iceland", "Croatia","Nigeria",
            "Brazil","Switzerland","Costa Rica","Serbia","Germany","Mexico", "Sweden","Korea Republic",
            "Belgium","Panama","Tunisia","England","Poland","Senegal", "Colombia","Japan"};
    boolean groupA = true;
    boolean groupB = false;
    boolean groupC = false;
    boolean groupD = false;
    boolean groupE = false;
    boolean groupF = false;
    boolean groupG = false;
    boolean groupH = false;
    int teamCountA = 0; //counts the clicks to cycle through teams for Team A
    int teamCountB = 1; //counts the clicks to cycle through teams for Team A
    Button groupAButton;
    Button groupBButton;
    Button groupCButton;
    Button groupDButton;
    Button groupEButton;
    Button groupFButton;
    Button groupGButton;
    Button groupHButton;
    Button teamAButton;
    Button teamBButton;
    int secondsA = 0;
    int secondsB = 0;
    boolean startRunA;
    boolean startRunB;
    int goalA = 0; // Counts number of Goals Team A
    int goalB = 0; // Counts number of Goals Team B
    int shotA = 0; // Counts number of Shots Team A
    int shotB = 0; // Counts number of Shots Team B
    int onTargetA = 0; // Counts number of Shots on Target Team A
    int onTargetB = 0; // Counts number of Shots on Target Team B
    int cornerA = 0; // Counts number of Corners Team A
    int cornerB = 0; // Counts number of Corners Team B
    Button possessionA_Button;
    Button possessionB_Button;
    Button shotAccuracyTeamA;
    Button shotAccuracyTeamB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState != null) {
            secondsA = savedInstanceState.getInt("seconds");
            secondsB = savedInstanceState.getInt("seconds");
            startRunA = savedInstanceState.getBoolean("startRun");
            startRunB = savedInstanceState.getBoolean("startRun");

        }
        groupAButton = (Button) findViewById(R.id.group_a_button);
        groupBButton = (Button) findViewById(R.id.group_b_button);
        groupCButton = (Button) findViewById(R.id.group_c_button);
        groupDButton = (Button) findViewById(R.id.group_d_button);
        groupEButton = (Button) findViewById(R.id.group_e_button);
        groupFButton = (Button) findViewById(R.id.group_f_button);
        groupGButton = (Button) findViewById(R.id.group_g_button);
        groupHButton = (Button) findViewById(R.id.group_h_button);
        teamAButton = (Button) findViewById(R.id.team_a_button);
        teamBButton = (Button) findViewById(R.id.team_b_button);
        possessionA_Button = (Button) findViewById(R.id.possession_team_a);
        possessionB_Button = (Button) findViewById(R.id.possession_team_b);
        shotAccuracyTeamA = (Button) findViewById(R.id.shotPercent_team_a);
        shotAccuracyTeamB = (Button) findViewById(R.id.shotPercent_team_b);
        groupAButton.setBackgroundColor(Color.parseColor("#004bc4"));
        groupBButton.setBackgroundColor(Color.parseColor("#000000"));
        groupCButton.setBackgroundColor(Color.parseColor("#000000"));
        groupDButton.setBackgroundColor(Color.parseColor("#000000"));
        groupEButton.setBackgroundColor(Color.parseColor("#000000"));
        groupFButton.setBackgroundColor(Color.parseColor("#000000"));
        groupGButton.setBackgroundColor(Color.parseColor("#000000"));
        groupHButton.setBackgroundColor(Color.parseColor("#000000"));
        TimerA();
        TimerB();
    }

    /**
     * Method runs when Button A is clicked
     */
    public void AGroup(View view) {
        groupA = true;
        groupB = false;
        groupC = false;
        groupD = false;
        groupE = false;
        groupF = false;
        groupG = false;
        groupH = false;
        teamCountA = 0;
        teamCountB = 1;
        teamAButton.setText(teamGroups[teamCountA]);
        teamBButton.setText(teamGroups[teamCountB]);
        groupAButton.setBackgroundColor(Color.parseColor("#004bc4"));
        groupBButton.setBackgroundColor(Color.parseColor("#000000"));
        groupCButton.setBackgroundColor(Color.parseColor("#000000"));
        groupDButton.setBackgroundColor(Color.parseColor("#000000"));
        groupEButton.setBackgroundColor(Color.parseColor("#000000"));
        groupFButton.setBackgroundColor(Color.parseColor("#000000"));
        groupGButton.setBackgroundColor(Color.parseColor("#000000"));
        groupHButton.setBackgroundColor(Color.parseColor("#000000"));
    }

    /**
     * Method runs when Button B is clicked
     */
    public void BGroup(View view) {
        groupA = false;
        groupB = true;
        groupC = false;
        groupD = false;
        groupE = false;
        groupF = false;
        groupG = false;
        groupH = false;
        teamCountA = 4;
        teamCountB = 5;
        teamAButton.setText(teamGroups[teamCountA]);
        teamBButton.setText(teamGroups[teamCountB]);
        groupAButton.setBackgroundColor(Color.parseColor("#000000"));
        groupBButton.setBackgroundColor(Color.parseColor("#004bc4"));
        groupCButton.setBackgroundColor(Color.parseColor("#000000"));
        groupDButton.setBackgroundColor(Color.parseColor("#000000"));
        groupEButton.setBackgroundColor(Color.parseColor("#000000"));
        groupFButton.setBackgroundColor(Color.parseColor("#000000"));
        groupGButton.setBackgroundColor(Color.parseColor("#000000"));
        groupHButton.setBackgroundColor(Color.parseColor("#000000"));
    }

    /**
     * Method runs when Button C is clicked
     */
    public void CGroup(View view) {
        groupA = false;
        groupB = false;
        groupC = true;
        groupD = false;
        groupE = false;
        groupF = false;
        groupG = false;
        groupH = false;
        teamCountA = 8;
        teamCountB = 9;
        teamAButton.setText(teamGroups[teamCountA]);
        teamBButton.setText(teamGroups[teamCountB]);
        groupAButton.setBackgroundColor(Color.parseColor("#000000"));
        groupBButton.setBackgroundColor(Color.parseColor("#000000"));
        groupCButton.setBackgroundColor(Color.parseColor("#004bc4"));
        groupDButton.setBackgroundColor(Color.parseColor("#000000"));
        groupEButton.setBackgroundColor(Color.parseColor("#000000"));
        groupFButton.setBackgroundColor(Color.parseColor("#000000"));
        groupGButton.setBackgroundColor(Color.parseColor("#000000"));
        groupHButton.setBackgroundColor(Color.parseColor("#000000"));
    }

    /**
     * Method runs when Button D is clicked
     */
    public void DGroup(View view) {
        groupA = false;
        groupB = false;
        groupC = false;
        groupD = true;
        groupE = false;
        groupF = false;
        groupG = false;
        groupH = false;
        teamCountA = 12;
        teamCountB = 13;
        teamAButton.setText(teamGroups[teamCountA]);
        teamBButton.setText(teamGroups[teamCountB]);
        groupAButton.setBackgroundColor(Color.parseColor("#000000"));
        groupBButton.setBackgroundColor(Color.parseColor("#000000"));
        groupCButton.setBackgroundColor(Color.parseColor("#000000"));
        groupDButton.setBackgroundColor(Color.parseColor("#004bc4"));
        groupEButton.setBackgroundColor(Color.parseColor("#000000"));
        groupFButton.setBackgroundColor(Color.parseColor("#000000"));
        groupGButton.setBackgroundColor(Color.parseColor("#000000"));
        groupHButton.setBackgroundColor(Color.parseColor("#000000"));
    }

    /**
     * Method runs when Button E is clicked
     */
    public void EGroup(View view) {
        groupA = false;
        groupB = false;
        groupC = false;
        groupD = false;
        groupE = true;
        groupF = false;
        groupG = false;
        groupH = false;
        teamCountA = 16;
        teamCountB = 17;
        teamAButton.setText(teamGroups[teamCountA]);
        teamBButton.setText(teamGroups[teamCountB]);
        groupAButton.setBackgroundColor(Color.parseColor("#000000"));
        groupBButton.setBackgroundColor(Color.parseColor("#000000"));
        groupCButton.setBackgroundColor(Color.parseColor("#000000"));
        groupDButton.setBackgroundColor(Color.parseColor("#000000"));
        groupEButton.setBackgroundColor(Color.parseColor("#004bc4"));
        groupFButton.setBackgroundColor(Color.parseColor("#000000"));
        groupGButton.setBackgroundColor(Color.parseColor("#000000"));
        groupHButton.setBackgroundColor(Color.parseColor("#000000"));
    }

    /**
     * Method runs when Button F is clicked
     */
    public void FGroup(View view) {
        groupA = false;
        groupB = false;
        groupC = false;
        groupD = false;
        groupE = false;
        groupF = true;
        groupG = false;
        groupH = false;
        teamCountA = 20;
        teamCountB = 21;
        teamAButton.setText(teamGroups[teamCountA]);
        teamBButton.setText(teamGroups[teamCountB]);
        groupAButton.setBackgroundColor(Color.parseColor("#000000"));
        groupBButton.setBackgroundColor(Color.parseColor("#000000"));
        groupCButton.setBackgroundColor(Color.parseColor("#000000"));
        groupDButton.setBackgroundColor(Color.parseColor("#000000"));
        groupEButton.setBackgroundColor(Color.parseColor("#000000"));
        groupFButton.setBackgroundColor(Color.parseColor("#004bc4"));
        groupGButton.setBackgroundColor(Color.parseColor("#000000"));
        groupHButton.setBackgroundColor(Color.parseColor("#000000"));
    }

    /**
     * Method runs when Button G is clicked
     */
    public void GGroup(View view) {
        groupA = false;
        groupB = false;
        groupC = false;
        groupD = false;
        groupE = false;
        groupF = false;
        groupG = true;
        groupH = false;
        teamCountA = 24;
        teamCountB = 25;
        teamAButton.setText(teamGroups[teamCountA]);
        teamBButton.setText(teamGroups[teamCountB]);
        groupAButton.setBackgroundColor(Color.parseColor("#000000"));
        groupBButton.setBackgroundColor(Color.parseColor("#000000"));
        groupCButton.setBackgroundColor(Color.parseColor("#000000"));
        groupDButton.setBackgroundColor(Color.parseColor("#000000"));
        groupEButton.setBackgroundColor(Color.parseColor("#000000"));
        groupFButton.setBackgroundColor(Color.parseColor("#000000"));
        groupGButton.setBackgroundColor(Color.parseColor("#004bc4"));
        groupHButton.setBackgroundColor(Color.parseColor("#000000"));
    }

    /**
     * Method runs when Button H is clicked
     */
    public void HGroup(View view) {
        groupA = false;
        groupB = false;
        groupC = false;
        groupD = false;
        groupE = false;
        groupF = false;
        groupG = false;
        groupH = true;
        teamCountA = 28;
        teamCountB = 29;
        teamAButton.setText(teamGroups[teamCountA]);
        teamBButton.setText(teamGroups[teamCountB]);
        groupAButton.setBackgroundColor(Color.parseColor("#000000"));
        groupBButton.setBackgroundColor(Color.parseColor("#000000"));
        groupCButton.setBackgroundColor(Color.parseColor("#000000"));
        groupDButton.setBackgroundColor(Color.parseColor("#000000"));
        groupEButton.setBackgroundColor(Color.parseColor("#000000"));
        groupFButton.setBackgroundColor(Color.parseColor("#000000"));
        groupGButton.setBackgroundColor(Color.parseColor("#000000"));
        groupHButton.setBackgroundColor(Color.parseColor("#004bc4"));
    }

    /**
     * Method runs when a Group Button is clicked (A,B,C,D,E,F,G,H) and determines
     * the name of the teams to display in Team A. This also sets the counter or
     * number of click to cycle through teams in each group.
     */
    public void teamToDisplay(View view) {
        teamAButton.setText(teamGroups[teamCountA]);
        teamCountA = teamCountA + 1;
        if (groupA == true && teamCountA > 3) {
            teamCountA = 0;
        }
        if (groupB == true && teamCountA > 7) {
            teamCountA = 4;
        }
        if (groupC == true && teamCountA > 11) {
            teamCountA = 8;
        }
        if (groupD == true && teamCountA > 15) {
            teamCountA = 12;
        }
        if (groupE == true && teamCountA > 19) {
            teamCountA = 16;
        }
        if (groupF == true && teamCountA > 23) {
            teamCountA = 20;
        }
        if (groupG == true && teamCountA > 27) {
            teamCountA = 24;
        }
        if (groupH == true && teamCountA > 31) {
            teamCountA = 28;
        }
    }

    /**
     * Method runs when a Group Button is clicked (A,B,C,D,E,F,G,H) and determines
     * the name of the teams to display in Team B. This also sets the counter or
     * number of click to cycle through teams in each group.
     */
    public void teamToDisplayB(View view) {
        teamBButton.setText(teamGroups[teamCountB]);
        teamCountB  = teamCountB + 1;
        if(groupA == true && teamCountB > 3) {
            teamCountB = 0;
        }
        if(groupB == true && teamCountB > 7) {
            teamCountB = 4;
        }
        if(groupC == true && teamCountB > 11) {
            teamCountB = 8;
        }
        if(groupD == true && teamCountB > 15) {
            teamCountB = 12;
        }
        if(groupE == true && teamCountB > 19) {
            teamCountB = 16;
        }
        if(groupF == true && teamCountB > 23) {
            teamCountB = 20;
        }
        if(groupG == true && teamCountB > 27) {
            teamCountB = 24;
        }
        if(groupH == true && teamCountB > 31) {
            teamCountB = 28;
        }
    }

    /**
     * Following methods control update and display of goals for both teams
     * Updates Shot and On Target accordingly
     * Udpates Shot Accuracy Accordingly
     */
    //Update Goals for Team A
    public void addGoalA(View view) {
        goalA = goalA + 1;
        shotA = shotA + 1;
        onTargetA = onTargetA + 1;
        displayGoalA(goalA);
        displayShotA(shotA);
        displayOnTargetA(onTargetA);
        calcAccuracyA();
    }
    //Update Goals for Team B
    public void addGoalB(View view) {
        goalB = goalB + 1;
        shotB = shotB + 1;
        onTargetB = onTargetB + 1;
        displayGoalB(goalB);
        displayShotB(shotB);
        displayOnTargettB(onTargetB);
        calcAccuracyB();
    }
    //Displays Goal count for Team A
    public void displayGoalA (int goal) {
        TextView goalView = (TextView) findViewById(R.id.team_a_score);
        goalView.setText(String.valueOf(goal));

    }
    //Displays Goal count for Team B
    public void displayGoalB (int goal) {
        TextView goalView = (TextView) findViewById(R.id.team_b_score);
        goalView.setText(String.valueOf(goal));
    }

    /**
     * Following methods control update and display of shots for both teams
     * Updates Shot Accuracy Accordingly
     */
    // Update Shots for Team A
    public void addShotA(View view) {
        shotA = shotA + 1;
        displayShotA(shotA);
        calcAccuracyA();
    }
    //Update Shots for Team B
    public void addShotB(View view) {
        shotB = shotB + 1;
        displayShotB(shotB);
        calcAccuracyB();
    }
    //Displays Shots count for Team A
    public void displayShotA (int shots) {
        Button shotsButton = (Button) findViewById(R.id.shots_team_a);
        shotsButton.setText(String.valueOf(shots));
    }
    //Displays Shots count for Team B
    public void displayShotB (int shots) {
        Button shotsButton = (Button) findViewById(R.id.shots_team_b);
        shotsButton.setText(String.valueOf(shots));
    }

    /**
     * Following methods control update and display of On Target for both teams
     * Updates Shots accordingly
     * Updates Shot Accuracy
     */
    // Update On Target for Team A
    public void addOnTargetA(View view) {
        onTargetA = onTargetA + 1;
        shotA = shotA + 1;
        displayOnTargetA(onTargetA);
        displayShotA(shotA);
        calcAccuracyA();
    }
    //Update On Target for Team B
    public void addOnTargetB(View view) {
        onTargetB = onTargetB + 1;
        shotB = shotB + 1;
        displayOnTargettB(onTargetB);
        displayShotB(shotB);
        calcAccuracyB();
    }
    //Displays On Target count for Team A
    public void displayOnTargetA (int target) {
        Button targetButton = (Button) findViewById(R.id.onTarget_team_a);
        targetButton.setText(String.valueOf(target));
    }
    //Displays On Target count for Team B
    public void displayOnTargettB (int target) {
        Button targetButton = (Button) findViewById(R.id.onTarget_team_b);
        targetButton.setText(String.valueOf(target));
    }

    /**
     * Following methods control Shot Accuracy Percentage Calc and Display
     */
    //Update Shot Accuracy Team A
    public void calcAccuracyA() {
        float target = onTargetA;
        float shot = shotA;
        float calc = (target / shot) * 100;
        int accuracy = Math.round(calc);
        displayShotAccuracyA(accuracy);
    }
    //Update Shot Accuracy Team B
    public void calcAccuracyB() {
        float target = onTargetB;
        float shot = shotB;
        float calc = (target / shot) * 100;
        int accuracy = Math.round(calc);
        displayShotAccuracyB(accuracy);
    }
    //Displays Shot Accuracy percentage for Team A
    public void displayShotAccuracyA (int accuracy) {
        shotAccuracyTeamA.setText(Math.round(accuracy) + "%");
    }
    //Displays Shot Accuracy percentage for Team B
    public void displayShotAccuracyB (int accuracy) {
        shotAccuracyTeamB.setText(Math.round(accuracy) + "%");
    }

    /**
     * Following methods controls Corners update and display
     */
    // Update Corners for Team A
    public void addCornerA(View view) {
        cornerA = cornerA + 1;
        displayCornerA(cornerA);
    }
    //Update Corners for Team B
    public void addCornerB(View view) {
        cornerB = cornerB + 1;
        displayCornerB(cornerB);
    }
    //Displays Corners count for Team A
    public void displayCornerA (int corners) {
        Button shotsButton = (Button) findViewById(R.id.corners_team_a);
        shotsButton.setText(String.valueOf(corners));
    }
    //Displays Corners count for Team B
    public void displayCornerB (int corners) {
        Button shotsButton = (Button) findViewById(R.id.corners_team_b);
        shotsButton.setText(String.valueOf(corners));
    }

    /**
     * These Methods run SavedInstanceState
     */
    public void onSaveInstanceStateA(Bundle saveInstanceStateA) {
        saveInstanceStateA.putInt("seconds", secondsA);
        saveInstanceStateA.putBoolean("startRun", startRunA);
    }

    public void onSaveInstanceStateB(Bundle saveInstanceStateB) {
        saveInstanceStateB.putInt("seconds", secondsB);
        saveInstanceStateB.putBoolean("startRun", startRunB);
    }

    /**
     * This method runs when possession Team A is clicked
     * Runs with method timerA
     */
    public void onClickStartA(View view) {
        // Change Color when timer runs Team A. CRASHES APP!
        possessionA_Button.setBackgroundColor(Color.parseColor("#004bc4"));
        possessionB_Button.setBackgroundColor(Color.parseColor("#000000"));
        // Start and Stop appropriate timer
        startRunA = true;
        startRunB = false;
        //Update Possession Stats
        calcPossession();
    }

    /**
     * This method runs when possession Team B is clicked
     * Runs with method timerB
     */
    public void onClickStartB(View view) {
        // Change Color when timer runs Team B.
        possessionA_Button.setBackgroundColor(Color.parseColor("#000000"));
        possessionB_Button.setBackgroundColor(Color.parseColor("#004bc4"));
        // Start and Stop appropriate timer
        startRunB = true;
        startRunA = false;
        //Update Possession Stats
        calcPossession();
    }

    /**
     * This method runs when possession button is clicked
     */
    public void onClickStop(View view) {
        //return background color of possession amount buttons to black
        possessionA_Button.setBackgroundColor(Color.parseColor("#000000"));
        possessionB_Button.setBackgroundColor(Color.parseColor("#000000"));
        //stop both clocks from running
        startRunA = false;
        startRunB = false;
        //Update Possession Stats
        calcPossession();
    }

    /**
     * This method calculates time of possession for each team and displays accordingly
     */
    public void calcPossession() {
        float totalTime = secondsA + secondsB;
        float posA = (secondsA / totalTime) * 100;
        float posB = (secondsB / totalTime) * 100;
        possessionA_Button.setText(Math.round(posA) + "%");
        possessionB_Button.setText(Math.round(posB) + "%");
    }

    /**
     * This method runs when reset button is clicked
     */
    public void onClickReset(View view) {
        //Resets the Possession timer and values
        startRunA = false;
        secondsA = 0;
        startRunB = false;
        secondsB = 0;
        possessionA_Button.setText("0%");
        possessionB_Button.setText("0%");
        //Reset Goals
        goalA = 0;
        goalB = 0;
        displayGoalA(goalA);
        displayGoalB(goalB);
        //Reset Shots
        shotA = 0;
        shotB = 0;
        displayShotA(shotA);
        displayShotB(shotB);
        //Reset On Target and Shot Accuracy
        onTargetA = 0;
        onTargetB = 0;
        displayOnTargetA(onTargetA);
        displayOnTargettB(onTargetB);
        displayShotAccuracyA(0);
        displayShotAccuracyB(0);
        //Reset Corners
        cornerA = 0;
        cornerB = 0;
        displayCornerA(cornerA);
        displayCornerB(cornerB);
        //Reset the Groups and Team Display
        teamCountA = 0;
        teamCountB = 1;
        teamAButton.setText(teamGroups[teamCountA]);
        teamBButton.setText(teamGroups[teamCountB]);
        groupAButton.setBackgroundColor(Color.parseColor("#004bc4"));
        groupBButton.setBackgroundColor(Color.parseColor("#000000"));
        groupCButton.setBackgroundColor(Color.parseColor("#000000"));
        groupDButton.setBackgroundColor(Color.parseColor("#000000"));
        groupEButton.setBackgroundColor(Color.parseColor("#000000"));
        groupFButton.setBackgroundColor(Color.parseColor("#000000"));
        groupGButton.setBackgroundColor(Color.parseColor("#000000"));
        groupHButton.setBackgroundColor(Color.parseColor("#000000"));
    }

    /**
     * This method controls timer for time of possession Team A
     */
    public void TimerA() {
        final Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                //If I wish to display running timer Team A in 00:00:00 format
//                int hours = secondsA / 3600;
//                int minutes = (secondsA % 3600) / 60;
//                int secs = secondsA % 60;
//                String time = String.format("%d:%02d:%02d", hours, minutes, secs);
//                timeView.setText(time);
                if (startRunA) {
                    secondsA++;
                }
                handler.postDelayed(this, 100);
            }
        });
    }

    /**
     * This method controls timer for time of possession Team B
     */
    public void TimerB() {
        final Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                //If I wish to display running timer Team B in 00:00:00 format
//                int hours = secondsB / 3600;
//                int minutes = (secondsB % 3600) / 60;
//                int secs = secondsB % 60;
//                String time = String.format("%d:%02d:%02d", hours, minutes, secs);
//                timeView.setText(time);
                if (startRunB) {
                    secondsB++;
                }
                handler.postDelayed(this, 100);
            }
        });
    }

}

