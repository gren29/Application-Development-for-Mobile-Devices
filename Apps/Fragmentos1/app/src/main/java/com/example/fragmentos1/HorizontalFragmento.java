package com.example.fragmentos1;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
public class HorizontalFragmento extends Fragment{

    public View onCreateView(LayoutInflater li, ViewGroup vg,Bundle b){
        return li.inflate(R.layout.horizonatl_fragmento, vg, false);
    }
}