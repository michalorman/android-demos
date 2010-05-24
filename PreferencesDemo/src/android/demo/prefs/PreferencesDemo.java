package android.demo.prefs;

import static pl.michalorman.android.core.view.Menu.CONSUME;
import static pl.michalorman.android.core.view.Menu.PROCEED;
import pl.michalorman.android.core.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class PreferencesDemo extends Activity {

    private static final int PREFS_ID = 1;

    private TextView checkbox;
    private TextView ringtone;
    private TextView checkbox2;
    private TextView text;
    private TextView list;

    @Override
    protected void initialize(Bundle bundle) {
        setContentView(R.layout.main);

        checkbox = findView(R.id.checkbox);
        ringtone = findView(R.id.ringtone);
        checkbox2 = findView(R.id.checkbox2);
        text = findView(R.id.text);
        list = findView(R.id.list);
    }

    @Override
    protected void addMenuOptions(Menu menu) {
        menu.add(Menu.NONE, PREFS_ID, Menu.NONE, "Preferences").setIcon(R.drawable.ic_menu_preferences)
                .setAlphabeticShortcut('p');
    }

    @Override
    protected boolean handleOptionsSelection(MenuItem item) {
        switch (item.getItemId()) {
        case PREFS_ID:
            startActivity(new Intent(this, EditPreferences.class));
            return CONSUME;
        }
        return PROCEED;
    }

    @Override
    protected void handleResume() {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        checkbox.setText(String.valueOf(prefs.getBoolean("checkbox", false)));
        ringtone.setText(prefs.getString("ringtone", "<not set>"));
        checkbox2.setText(String.valueOf(prefs.getBoolean("checkbox2", false)));
        text.setText(prefs.getString("text", "<not set>"));
        list.setText(prefs.getString("list", "<not set>"));
    }

}