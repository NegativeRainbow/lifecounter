package edu.washington.danishb.lifecounter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView[] lifeDisplay = new TextView[4];
    Button[] gain1 = new Button[4];
    Button[] lose1 = new Button[4];
    Button[] gain5 = new Button[4];
    Button[] lose5 = new Button[4];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize Views
        lifeDisplay[0] = (TextView) findViewById(R.id.p1life);
        lifeDisplay[1] = (TextView) findViewById(R.id.p2life);
        lifeDisplay[2] = (TextView) findViewById(R.id.p3life);
        lifeDisplay[3] = (TextView) findViewById(R.id.p4life);

        // Initialize Gain 1 Buttons
        gain1[0] = (Button) findViewById(R.id.p1gain1);
        gain1[1] = (Button) findViewById(R.id.p2gain1);
        gain1[2] = (Button) findViewById(R.id.p3gain1);
        gain1[3] = (Button) findViewById(R.id.p4gain1);

        // Initialize Lose 1 Buttons
        lose1[0] = (Button) findViewById(R.id.p1lose1);
        lose1[1] = (Button) findViewById(R.id.p2lose1);
        lose1[2] = (Button) findViewById(R.id.p3lose1);
        lose1[3] = (Button) findViewById(R.id.p4lose1);

        // Initialize Gain 5 Buttons
        gain5[0] = (Button) findViewById(R.id.p1gain5);
        gain5[1] = (Button) findViewById(R.id.p2gain5);
        gain5[2] = (Button) findViewById(R.id.p3gain5);
        gain5[3] = (Button) findViewById(R.id.p4gain5);

        // Initialize Lose 5 Buttons
        lose5[0] = (Button) findViewById(R.id.p1lose5);
        lose5[1] = (Button) findViewById(R.id.p2lose5);
        lose5[2] = (Button) findViewById(R.id.p3lose5);
        lose5[3] = (Button) findViewById(R.id.p4lose5);

        // Add listeners to all of the buttons
        for(int i = 0; i < 4; i++){
            gain1[i].setTag(R.id.change, "+1");
            gain1[i].setTag(R.id.player, Integer.toString(i));
            gain1[i].setOnClickListener(new changeLifeListener());
            lose1[i].setTag(R.id.change, "-1");
            lose1[i].setTag(R.id.player, Integer.toString(i));
            lose1[i].setOnClickListener(new changeLifeListener());
            gain5[i].setTag(R.id.change, "+5");
            gain5[i].setTag(R.id.player, Integer.toString(i));
            gain5[i].setOnClickListener(new changeLifeListener());
            lose5[i].setTag(R.id.change, "-5");
            lose5[i].setTag(R.id.player, Integer.toString(i));
            lose5[i].setOnClickListener(new changeLifeListener());
        }
    }

    public class changeLifeListener implements View.OnClickListener {
        @Override
        public void onClick(View v){
            int player = Integer.parseInt((String)v.getTag(R.id.player));
            int change = Integer.parseInt((String)v.getTag(R.id.change));
            lifeDisplay[player].setText(Integer.parseInt(lifeDisplay[player].getText().toString())
                    + change);
        }
    }
}
