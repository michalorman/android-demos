package android.demo.rgb;

import pl.michalorman.android.core.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;

public class RGB extends Activity {

    private SeekBar redSeekBar;
    private SeekBar greenSeekBar;
    private SeekBar blueSeekBar;
    private TextView redLabel;
    private TextView greenLabel;
    private TextView blueLabel;
    private TextView colorBox;
    private TextView htmlLabel;

    @Override
    protected void initialize(Bundle bundle) {
        setContentView(R.layout.main);

        redSeekBar = findView(R.id.r_bar);
        greenSeekBar = findView(R.id.g_bar);
        blueSeekBar = findView(R.id.b_bar);
        redLabel = findView(R.id.r_label);
        greenLabel = findView(R.id.g_label);
        blueLabel = findView(R.id.b_label);
        colorBox = findView(R.id.color_box);
        htmlLabel = findView(R.id.html_label);

        initRedSeekBar();
        initGreenSeekBar();
        initBlueSeekBar();
    }

    private void initRedSeekBar() {
        redSeekBar.setMax(255);
        redSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                redLabel.setText(String.valueOf(progress));
                updateColorBox();
            }
        });
    }

    private void initGreenSeekBar() {
        greenSeekBar.setMax(255);
        greenSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                greenLabel.setText(String.valueOf(progress));
                updateColorBox();
            }
        });
    }

    private void initBlueSeekBar() {
        blueSeekBar.setMax(255);
        blueSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                blueLabel.setText(String.valueOf(progress));
                updateColorBox();
            }
        });
    }

    private void updateColorBox() {
        int r = redSeekBar.getProgress();
        int g = greenSeekBar.getProgress();
        int b = blueSeekBar.getProgress();
        colorBox.setBackgroundColor(Color.rgb(r, g, b));
        htmlLabel.setText(String.format("#%02X%02X%02X", r, g, b));
    }
}