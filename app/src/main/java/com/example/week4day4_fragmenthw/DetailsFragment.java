package com.example.week4day4_fragmenthw;


import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailsFragment extends Fragment {

    TextView tvName;
    TextView tvProfession;
    TextView tvDetails;
    TextView tvQuote;
    ImageView imgPic;
    public DetailsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_details, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        tvName = view.findViewById(R.id.tvName);
        tvProfession = view.findViewById(R.id.tvProfession);
        tvDetails = view.findViewById(R.id.tvDetails);
        tvQuote = view.findViewById(R.id.tvQuote);
        imgPic = view.findViewById(R.id.imageView);
    }

    public void setPassedInDescription(Celebrity c) {
        tvName.setText(c.getName());
        tvProfession.setText(c.getProfession());
        tvDetails.setText(c.getDetails());
        tvQuote.setText(c.getQuote());
        Drawable drawable = getResources().getDrawable(c.getPhoto());
        imgPic.setImageDrawable(drawable);
    }
}
