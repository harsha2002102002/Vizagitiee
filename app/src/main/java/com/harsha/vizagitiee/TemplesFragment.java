package com.harsha.vizagitiee;

import android.location.Location;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class TemplesFragment extends Fragment {

    private RecyclerView recyclerView;
    private TempleAdapter adapter;
    private List<Temple> templeList;
    private Location userLocation;

    public TemplesFragment() {
        // Required empty public constructor
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_temples, container, false);
        recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        if (getArguments() != null) {
            double latitude = getArguments().getDouble("latitude");
            double longitude = getArguments().getDouble("longitude");
            userLocation = new Location("");
            userLocation.setLatitude(latitude);
            userLocation.setLongitude(longitude);
        }

        templeList = new ArrayList<>();
        populateTempleList();

        adapter = new TempleAdapter(templeList, userLocation);
        recyclerView.setAdapter(adapter);

        return view;
    }

    private void populateTempleList() {
        templeList.add(new Temple("The Temple is a Hindu shrine dedicated to Lord Vishnu's fierce Narasimha avatar, known for its blend of Kalinga and Dravidian architecture, festivals, and a unique sandalwood-covered idol,built in 11th century.","Simhachalam Temple", "Simhachalam", 17.7664, 83.2505, "https://www.revv.co.in/blogs/wp-content/uploads/2022/03/2010.png"));
        templeList.add(new Temple("Kanaka Mahalakshmi Temple in Vizag is a revered Hindu shrine dedicated to Goddess Lakshmi, known for its spiritual significance and vibrant festivities.","Kanaka Mahalakshmi Temple", "Kancharapalem", 17.7126, 83.2944, "https://vizagtourism.org.in/images/places-to-visit/header/sri-kanaka-mahalakshmi-temple-vizag-tourism-entry-fee-timings-holidays-reviews-header.jpg"));
        templeList.add(new Temple("Kanaka Mahalakshmi Temple in Vizag is a revered Hindu shrine dedicated to Goddess Lakshmi, known for its spiritual significance and vibrant festivities.","ISKON Temple", "Rushikonda", 17.7681, 83.3666, "https://lh3.googleusercontent.com/p/AF1QipOdstMudeMbt4szKr0yGcTxMS78vpxVlLAXKr6U=s1360-w1360-h1020"));
        templeList.add(new Temple("It is known as Narasimha Swamy Konda temple among locals, is situated on Sri Venkateswara Konda hill. Believed to be built in 1866 by a European Captain Blackmoor\n" +
                "\n","Sri Venkateswara Temple", "Rushikonda", 17.7318, 83.3361, "https://vizagtourism.org.in/images/places-to-visit/header/sri-venkateswara-swamy-konda-temple-vizag-tourism-entry-fee-timings-holidays-reviews-header.jpg"));
        templeList.add(new Temple("The king who ruled the Anakapalli area, Sri Kakarlapudi Appalaraju Payakarao, built the temple around 450 years ago, dedicated to his family goddess Kakatambika, the deity was later referred to as Nookalamma.","Nookalamma Temple", "Anakapalle", 17.6805, 83.0107, "https://lh3.googleusercontent.com/p/AF1QipParBwBP8e7VJ8G2xCz3FiuPxRyRihv1DosBkxC=s1360-w1360-h1020"));
        templeList.add(new Temple("Visakhapatnam's Sri Sampath Vinayaka Temple, built in 1962, houses a black marble Ganesha idol and draws devotees seeking blessings for new beginnings.","Sampath Vinayaka Temple", "Asilmetha", 17.7247, 83.3126, "https://lh3.googleusercontent.com/p/AF1QipOaHJtyOeDmGCZeecI7JywCn8gbuSuCxbwNgbqf=s1360-w1360-h1020"));
        templeList.add(new Temple("Ross Hill Church is a Catholic Church, built in 1864, offers scenic sea views and a peaceful Christian sanctuary.","Rose hill Church", "Port Area", 17.6904, 83.2871, "https://lh3.googleusercontent.com/p/AF1QipOipqfooohTYF8kc47emn7rE8AP1ueYhSB0bpjw=s1360-w1360-h1020"));
        templeList.add(new Temple("Bojjana Konda in Anakapalle offers ancient Buddhist caves, stupas, and sculptures  showcasing the influence of Hinayana, Mahayana, and Vajrayana sects of Buddhism, dating back to 4th-9th centuries AD.","Bojjana Konda", "Anakapalle", 17.7103, 83.0160, "https://lh3.googleusercontent.com/p/AF1QipMmSvGyTZRl4hJ1HxvLteSV-u0LcZwQiU4oAPpP=s1360-w1360-h1020"));
        templeList.add(new Temple("This temple is located on Town Main Road in Visakhapatnam. It is known for its spiritual significance and is frequented by devotees for performing Satyanarayana Vratham.","Satyanarayana Swamy Temple", "Jagadamba", 17.7063, 83.3007, "https://lh3.googleusercontent.com/p/AF1QipPKx8eK3KgRDj_diihGJ97OypxfFRYx0QsdKmaH=s1360-w1360-h1020"));

        // Add more temples as needed
    }
}
