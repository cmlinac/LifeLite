package com.cmlinac.lifelite;

import android.annotation.TargetApi;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;
import android.widget.Button;


public class LifeCounterActivity extends ActionBarActivity {
    private static SharedPreferences mPrefs;
    private boolean displayRoll = false;
    private int life_total_left = 20;
    private int life_total_right=20;
    private int poison_total_left = 0;
    private int poison_total_right = 0;
    private boolean displayPoison = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_life_counter);
        mPrefs = getSharedPreferences("life_totals", MODE_PRIVATE);

        Button life1 = (Button)findViewById(R.id.p1_life);
        Button life2 = (Button)findViewById(R.id.p2_life);
        String p1_life = mPrefs.getString("p1_life", "20");
        String p2_life = mPrefs.getString("p2_life", "20");
        life1.setText(p1_life);
        life2.setText(p2_life);

    }

    @Override
    protected void onResume() {
        super.onResume();
        mPrefs = getSharedPreferences("life_totals", MODE_PRIVATE);

        Button life1 = (Button)findViewById(R.id.p1_life);
        Button life2 = (Button)findViewById(R.id.p2_life);
        String p1_life = mPrefs.getString("p1_life", "20");
        String p2_life = mPrefs.getString("p2_life", "20");
        life1.setText(p1_life);
        life2.setText(p2_life);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.life_counter, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        switch (item.getItemId()) {
            case R.id.action_settings:
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onStop() {
        super.onStop();
        SharedPreferences.Editor ed = mPrefs.edit();
        Button life1 = (Button)findViewById(R.id.p1_life);
        Button life2 = (Button)findViewById(R.id.p2_life);
        ed.putString("p1_life", life1.getText().toString());
        ed.putString("p2_life", life2.getText().toString());
        ed.apply();
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);
            return rootView;
        }
    }

    public void p1_small_inc(View v) {
        Button lifeTotal = (Button)findViewById(R.id.p1_life);
        if (lifeTotal.getText() != null)  {
            String currentTotal = lifeTotal.getText().toString();
            Integer newTotal = Integer.parseInt(currentTotal) + 1;
            lifeTotal.setText(newTotal.toString());
        }
    }

    public void p1_small_dec(View v) {
        Button lifeTotal = (Button)findViewById(R.id.p1_life);
        if (lifeTotal.getText() != null)  {
            String currentTotal = lifeTotal.getText().toString();
            Integer newTotal = Integer.parseInt(currentTotal) - 1;
            lifeTotal.setText(newTotal.toString());
        }
    }

    public void p1_big_inc(View v) {
        Button lifeTotal = (Button)findViewById(R.id.p1_life);
        if (lifeTotal.getText() != null)  {
            String currentTotal = lifeTotal.getText().toString();
            Integer newTotal = Integer.parseInt(currentTotal) + 5;
            lifeTotal.setText(newTotal.toString());
        }
    }

    public void p1_big_dec(View v) {
        Button lifeTotal = (Button)findViewById(R.id.p1_life);
        if (lifeTotal.getText() != null)  {
            String currentTotal = lifeTotal.getText().toString();
            Integer newTotal = Integer.parseInt(currentTotal) - 5;
            lifeTotal.setText(newTotal.toString());
        }
    }

    public void p2_small_inc(View v) {
        Button lifeTotal = (Button)findViewById(R.id.p2_life);
        if (lifeTotal.getText() != null)  {
            String currentTotal = lifeTotal.getText().toString();
            Integer newTotal = Integer.parseInt(currentTotal) + 1;
            lifeTotal.setText(newTotal.toString());
        }
    }

    public void p2_small_dec(View v) {
        Button lifeTotal = (Button)findViewById(R.id.p2_life);
        if (lifeTotal.getText() != null)  {
            String currentTotal = lifeTotal.getText().toString();
            Integer newTotal = Integer.parseInt(currentTotal) - 1;
            lifeTotal.setText(newTotal.toString());
        }
    }

    public void p2_big_inc(View v) {
        Button lifeTotal = (Button)findViewById(R.id.p2_life);
        if (lifeTotal.getText() != null)  {
            String currentTotal = lifeTotal.getText().toString();
            Integer newTotal = Integer.parseInt(currentTotal) + 5;
            lifeTotal.setText(newTotal.toString());
        }
    }

    public void p2_big_dec(View v) {
        Button lifeTotal = (Button)findViewById(R.id.p2_life);
        if (lifeTotal.getText() != null)  {
            String currentTotal = lifeTotal.getText().toString();
            Integer newTotal = Integer.parseInt(currentTotal) - 5;
            lifeTotal.setText(newTotal.toString());
        }
    }

    public void reset(View v) {
        Button p1Life = (Button)findViewById(R.id.p1_life);
        Button p2Life = (Button)findViewById(R.id.p2_life);
        p1Life.setText(R.string.starting_life);
        p2Life.setText(R.string.starting_life);
        life_total_left = 20;
        life_total_right=20;
        poison_total_left = 0;
        poison_total_right = 0;
    }

    public void roll_d20(View v) {

        displayRoll = !displayRoll;
        Button die = (Button)findViewById(R.id.die);
        if (displayRoll) {
            Integer rand = (int)((Math.random() * 20) + 1);
            die.setText(rand.toString());
        }
        else {
            die.setText("");
        }

    }

    public void poison(View v) {
        Button left = (Button)findViewById(R.id.p1_life);
        Button right = (Button)findViewById(R.id.p2_life);
        displayPoison = !displayPoison;
        if (displayPoison) {
            life_total_left = Integer.parseInt(left.getText().toString());
            life_total_right = Integer.parseInt(right.getText().toString());
            left.setTextColor(Color.parseColor("#458B00"));
            right.setTextColor(Color.parseColor("#458B00"));
            left.setText(((Integer)poison_total_left).toString());
            right.setText(((Integer)poison_total_right).toString());
        }
        else {
            poison_total_left = Integer.parseInt(left.getText().toString());
            poison_total_right = Integer.parseInt(right.getText().toString());
            left.setTextColor(Color.parseColor("#FFFFFF"));
            right.setTextColor(Color.parseColor("#FFFFFF"));
            left.setText(((Integer)life_total_left).toString());
            right.setText(((Integer)life_total_right).toString());
        }

    }

}
