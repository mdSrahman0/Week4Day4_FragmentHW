// Md Sohanur Rahman

package com.example.week4day4_fragmenthw;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

// Create instances of ListFragment (which will display a list of celebrities) and DetailsFragment
// (display information about the selected celebrity).
public class MainActivity extends AppCompatActivity implements ListFragment.OnFragmentInteractionListener {

    FragmentManager fragmentManager;
    ListFragment listFragment;
    DetailsFragment detailsFragment;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragmentManager = getSupportFragmentManager();
        listFragment = ListFragment.newInstance("","");
        detailsFragment = new DetailsFragment();
        
        fragmentManager.beginTransaction().add(R.id.frgListFragment, listFragment)
                .addToBackStack("LIST_FRG").commit();
        fragmentManager.beginTransaction().add(R.id.frgDetailsFragment, detailsFragment)
                .addToBackStack("DETAILS_FRG").commit();
    }

    @Override
    public void sendCelebToMain(Celebrity c) {
        // send the celebrity passed in from the Celebrity fragment to the details fragment
        detailsFragment.setPassedInDescription(c);
    }
}
