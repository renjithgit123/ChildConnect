package com.stack.user.childconnect.Fragment;

import android.graphics.PorterDuff;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Spinner;

import com.stack.user.childconnect.R;

/**
 * Created by Renjith M R on 19/7/16.
 */
public class PersonelInfoFragment extends Fragment {
    private Spinner spnGender,spnCountry,spnState;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.personel_info, container, false);
        init(view);
        spnGender.getBackground().setColorFilter(getResources().getColor(R.color.blue), PorterDuff.Mode.SRC_ATOP);
        spnCountry.getBackground().setColorFilter(getResources().getColor(R.color.blue), PorterDuff.Mode.SRC_ATOP);
        spnState.getBackground().setColorFilter(getResources().getColor(R.color.blue), PorterDuff.Mode.SRC_ATOP);
        return  view;
    }/////initialize views
    private void init(View view){
        spnGender=(Spinner)view.findViewById(R.id.spn_gender);
        spnCountry=(Spinner)view.findViewById(R.id.spn_country);
        spnState=(Spinner)view.findViewById(R.id.spn_state);
    }
}
