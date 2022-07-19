package com.example.normsusbr;
/*
Активность-хост для фрагмента вывода норм для конкретного раздела
 */

import android.content.Context;
import android.content.Intent;

import androidx.fragment.app.Fragment;

public class SectionNormActivity extends SingleFragmentActivity {
    public static final String EXTRA_SECTION_NORM = "com.example.normsusbr.section_norm_activity";

    @Override
    protected Fragment createFragment() {
        return SectionNormFragment.newInstance(getIntent().getIntExtra(EXTRA_SECTION_NORM,0));
    }

    //создание интента для вызова данной активности
    public static Intent newIntent(Context packageContext, int position) {
        Intent intent = new Intent(packageContext, SectionNormActivity.class);
        intent.putExtra(EXTRA_SECTION_NORM, position);
        return intent;
    }
}
