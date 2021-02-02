package com.example.quakereport;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class EarthquakeAdapter extends ArrayAdapter<Earthquake> {
    private static final String LOG_TAG = EarthquakeAdapter.class.getSimpleName();
    private int mResourceLayout;

    public EarthquakeAdapter(@NonNull Context context, int resource, ArrayList<Earthquake> earthquakes) {
        super(context, 0, earthquakes);
        mResourceLayout = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;

        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    this.mResourceLayout, parent, false);
        }

        Earthquake currentQuake = getItem(position);

        TextView magnitudeTextView = listItemView.findViewById(R.id.magnitude_view);
        magnitudeTextView.setText(currentQuake.getMagnitude());

        TextView locationTextView = listItemView.findViewById(R.id.location_view);
        locationTextView.setText(currentQuake.getLocation());

        TextView dateTextView = listItemView.findViewById(R.id.date_view);
        dateTextView.setText(currentQuake.getDate());

        return listItemView;
    }
}
