/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.android.miwok;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements MainFragment.ClickHandler  {

        private boolean isTwopane;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);

            // Set the content of the activity to use the activity_main.xml layout file
            setContentView(R.layout.activity_main);

            isTwopane = findViewById(R.id.frame_layout) != null;

            if (isTwopane && savedInstanceState == null){
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.frame_layout, new NumbersFragment())
                        .commit();
            }
        }

    @Override
    public void categoryClick(int categoryId) {
        if (isTwopane){
            Fragment fragment;
            int title;
            switch (categoryId) {
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
        }
        else{
            Intent intent = new Intent(this, DetailActivity.class);
            intent.putExtra("CAT", categoryId);
            startActivity(intent);
        }
    }
}
