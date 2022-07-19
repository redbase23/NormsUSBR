package com.example.normsusbr;
/*
Активность хост для фрагмента детализации конкретной нормы
 */

import android.content.Context;
import android.content.Intent;
import androidx.fragment.app.Fragment;

public class DetailsActivity extends SingleFragmentActivity{
    public static final String EXTRA_DETAILS ="com.example.normsusbr.details_activvity";

    @Override
    protected Fragment createFragment() {
        return DetailsFragment.newInstance(getIntent().getIntExtra(EXTRA_DETAILS,1));
    }

    //создание интента для вызова активности
    public static Intent newIntent(Context packageContext, int controlNumber){
        Intent intent = new Intent(packageContext,DetailsActivity.class);
        intent.putExtra(EXTRA_DETAILS,controlNumber);
        return intent;
    }
}
