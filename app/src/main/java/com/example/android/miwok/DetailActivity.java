package com.example.android.miwok;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        int cat = getIntent().getIntExtra("CAT", R.id.numbers);
        Fragment fragment;
        int title;
        switch (cat) {
            case R.id.numbers:
                fragment = new NumbersFragment();
                title = R.string.category_numbers;
                break;
            case R.id.family:
                fragment = new FamilyFragment();
                title = R.string.category_family;
                break;
            case R.id.colors:
                fragment = new ColorsFragment();
                title = R.string.category_colors;
                break;
            case R.id.phrases:
                fragment = new PhrasesFragment();
                title = R.string.category_phrases;
                break;

            default:
                throw new IllegalArgumentException("category invalid.");

        }
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.frame_layout, fragment)
                .commit();
        getSupportActionBar().setTitle(title);
    }
}
