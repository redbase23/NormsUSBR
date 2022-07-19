package com.example.normsusbr;

import androidx.fragment.app.Fragment;

public class DiamondSawActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return DiamondSawFragment.newInstance();
    }
}
