package com.cambi.vending_machine.dao.interfaces;

import com.cambi.vending_machine.model.stack.PreferenceStack;

public interface PreferenceStackDao {
    public void addStack();

    public PreferenceStack getStack();

    public PreferenceStack updateStack();

    public void deleteStack();
}
