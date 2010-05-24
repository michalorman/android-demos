package android.demo.prefs;

import pl.michalorman.android.core.preference.PreferenceActivity;

public class EditPreferences extends PreferenceActivity {

    @Override
    protected int getPreferencesResourceId() {
        return R.xml.preferences;
    }

}
