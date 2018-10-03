package com.example.mani.fragmentapp;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class FeedbackFragment extends Fragment implements RadioGroup.OnCheckedChangeListener, RatingBar.OnRatingBarChangeListener {

    private static final int YES = 0;
    private static final int NO = 1;

    private TextView textViewHeader;
    private RatingBar ratingBar;


    public FeedbackFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View rootView = inflater.inflate(R.layout.fragment_feedback, container, false);

        // initialize all variables here
        textViewHeader = rootView.findViewById(R.id.tv_question);
        ratingBar = rootView.findViewById(R.id.ratingBar);
        final RadioGroup radioGroup = rootView.findViewById(R.id.rg_question);

        // Add listeners here
        radioGroup.setOnCheckedChangeListener(this);
        ratingBar.setOnRatingBarChangeListener(this);

        return rootView;
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        View radioButton = group.findViewById(checkedId);
        int index = group.indexOfChild(radioButton);

        switch (index) {
            case YES:
                textViewHeader.setText(R.string.yes_message);
                break;
            case NO:
                textViewHeader.setText(R.string.no_message);
                break;
            default:
                break;
        }
    }

    @Override
    public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
        Toast.makeText(getContext(), "Your rating is " + rating + " ", Toast.LENGTH_SHORT).show();
    }
}
