// MainActivityFragment.java
// MainActivityFragment creates and manages a CannonView
package com.bhavin.group_e.cannongame;

import android.media.AudioManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;


public class MainActivityFragment extends Fragment {

   private CannonView cannonView; // custom view to display the game

   // Static factory method for creating fragment instances
   public static MainActivityFragment newInstance() {
      return new MainActivityFragment();
   }

   @Override
   public View onCreateView(LayoutInflater inflater, ViewGroup container,
                            Bundle savedInstanceState) {
      // Inflate the fragment_main.xml layout
      View view = inflater.inflate(R.layout.fragment_main, container, false);

      // Get a reference to the CannonView
      cannonView = view.findViewById(R.id.cannonView);
      return view;
   }

   @Override
   public void onActivityCreated(Bundle savedInstanceState) {
      super.onActivityCreated(savedInstanceState);

      // Allow volume buttons to set game volume
      getActivity().setVolumeControlStream(AudioManager.STREAM_MUSIC);
   }

   @Override
   public void onPause() {
      super.onPause();
      cannonView.stopGame(); // Terminates the game
   }

   @Override
   public void onDestroy() {
      super.onDestroy();
      cannonView.releaseResources(); // Release game resources
   }
}