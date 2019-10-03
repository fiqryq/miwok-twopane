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

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

public class MainFragment extends Fragment implements View.OnClickListener {

    private ClickHandler mHandler;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main,container,false);

        // Find the View that shows the numbers category
        TextView numbers = (TextView) view.findViewById(R.id.numbers);

        // Set a click listener on that View
        numbers.setOnClickListener(this);

        // Find the View that shows the family category
        TextView family = (TextView) view.findViewById(R.id.family);

        // Set a click listener on that View
        family.setOnClickListener(this);

        // Find the View that shows the colors category
        TextView colors = (TextView) view.findViewById(R.id.colors);

        // Set a click listener on that View
        colors.setOnClickListener(this);

        // Find the View that shows the phrases category
        TextView phrases = (TextView) view.findViewById(R.id.phrases);

        // Set a click listener on that View
        phrases.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View view) {
       mHandler.categoryClick(view.getId());
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mHandler = (ClickHandler) context;
     }

    interface ClickHandler{
        void categoryClick(int categoryId);
    }
}
