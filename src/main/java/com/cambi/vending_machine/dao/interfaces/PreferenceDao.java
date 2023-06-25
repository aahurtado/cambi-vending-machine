package com.cambi.vending_machine.dao.interfaces;

import com.cambi.vending_machine.model.preference.Preference;

public interface PreferenceDao {

    void createPreference();
    Preference getPreference();
    void updatePreference();
    void deletePreference();

}
