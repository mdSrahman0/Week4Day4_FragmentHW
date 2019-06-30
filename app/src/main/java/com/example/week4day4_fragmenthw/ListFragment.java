package com.example.week4day4_fragmenthw;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class ListFragment extends Fragment {

    ListView listView;
    ArrayList<Celebrity> celebrityList = new ArrayList<>();

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public ListFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static ListFragment newInstance(String param1, String param2) {
        ListFragment fragment = new ListFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list, container, false);

        populateCelebrityList();
        String[] celebsArray = new String[celebrityList.size()];

        // Store all the names of each celebrity into an array, so we can use it for our adapter.
        for (int i = 0; i < celebrityList.size(); i++) {
            celebsArray[i] = celebrityList.get(i).getName();

        }

        listView = view.findViewById(R.id.celebListView);

        // Tried using for loop and just calling celebrityList.get(index).getName(),
        // but it would not work. So just passed in an array of celebrity names
        ArrayAdapter<String> listViewAdapter = new ArrayAdapter<String>(
              getActivity(), android.R.layout.simple_list_item_1, celebsArray);

        listView.setAdapter(listViewAdapter);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // holds the name of the clicked celebrity
                Object a = listView.getItemAtPosition(position);

                // A new celebrity item to be passed into our main activity
                Celebrity selectedCeleb = new Celebrity();

                // Loop thru our celebrityList until we find the name of the celebrity that
                // matches the name of the clicked item. Once found, set selectedCeleb to that object
                for(Celebrity celebrity : celebrityList) {
                    if(celebrity.getName().equals(a.toString())) {
                        selectedCeleb = celebrity;
                    }
                }

                // call interface method
                mListener.sendCelebToMain(selectedCeleb);
            }
        });
    }

    public void populateCelebrityList() {
        celebrityList.add(new Celebrity("Kanye West", "Rapper", "Award winning, life-changing, " +
                "super-controversial and infinitely influential 40-year old rapper/producer.",
                "\"My greatest pain in life is that I will never be able to see myself perform live.\""));
        celebrityList.add(new Celebrity("Quentin Tarantino", "Director",
                "Despite being infamously controversial, Tarantino has crafted some of the most memorable female" +
                        "and African American characters of all time.",
                "\"I was kind of excited about going to jail the first time and I learned some great dialogue.\""));
        celebrityList.add(new Celebrity("Ron Swanson", "Parks and Recreation Director",
                "Leslie Knop's direct superior. Likes dark haired women, breakfast food and Little Sebastian. " +
                        "Also the sexiest character on NBC's Parks and Recreation.",
                "\"When people get too chummy with me, I like to call them by the wrong name to " +
                        "let them know I don’t really care about them.\""));
        celebrityList.add(new Celebrity("John Cena", "Wrestler", "Having the power of invisibility, " +
                "Cena has managed to take out all of his opponenets without breaking a sweat.",
                "\"You can't fly with me, C-E-N-A\n" +
                        "It's a freestyle rap, baby, we don't play\n" +
                        "I come off the dome like every day\n" +
                        "Come at you from both sides like lesbian three ways\""));
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnFragmentInteractionListener {
        void sendCelebToMain(Celebrity c);
    }
}
