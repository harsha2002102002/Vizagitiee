package com.harsha.vizagitiee;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.harsha.vizagitiee.Event;
import com.harsha.vizagitiee.EventAdapter;
import com.harsha.vizagitiee.R;

import java.util.ArrayList;
import java.util.List;

public class Jobs extends AppCompatActivity {

    private RecyclerView recyclerView;
    private EventAdapter eventAdapter;
    private List<Event> jobList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jobs);
        FirebaseApp.initializeApp(this);

        // Initialize RecyclerView
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        Window window = this.getWindow();
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(ContextCompat.getColor(this, R.color.white));
        // Initialize jobList and EventAdapter
        jobList = new ArrayList<>();
        eventAdapter = new EventAdapter(Jobs.this, jobList);
        recyclerView.setAdapter(eventAdapter);

        // Initialize Firebase Database reference
        DatabaseReference mDataBase;
        mDataBase = FirebaseDatabase.getInstance("https://manavizag-157cd-default-rtdb.asia-southeast1.firebasedatabase.app/").getReference();

        // Create event object and push data to the database
        Event event1 = new Event("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRtNR4sHzSNRDWgUzo2RhOgi81LvuL9oagxku-HmBL1O94_1JPWS7uU6Bb1PG7I4NvZrXs&usqp=CAU","Simhachalam Giri Pradakshina", "Simhachalam Vizag", "20 July 2024", "Simhachalam Giri Pradakshana is a sacred event at the Simhachalam Temple, where devotees walk around the hill seeking blessings from Lord Narasimha. This religious circumambulation draws pilgrims who participate with deep devotion, making offerings and prayers at the temple.");
        Event event2 = new Event("https://res.cloudinary.com/dwzmsvp7f/image/upload/q_75,f_auto,w_400/c_crop%2Cg_custom%2Fv1720948446%2Fm1iphawrfwvpspdumljn.png","Thrifty X Strangers Meet ( Vizag)", "MYZ - UNO Vizag, Visakhapatnam", "July 21 2024", "Begin the event with our signature Mystery Match activity. You'll be paired with a fellow attendee, but you won't know who they are until later! Engage in intriguing conversations and guess who your mystery partner might be.");
        Event event3 = new Event("https://assets-in.bmscdn.com/nmcms/events/banner/desktop/media-desktop-new-india-baby-olympic-games-vizag-2024-1-2024-7-2-t-4-43-53.jpg","NEW INDIA BABY OLYMPIC GAMES VIZAG 2024","S3 Sports Arena Visakhapatnam","28 July 2024","Hi, champions The young athletes are cordially invited to NIBOG`s thrilling kids sports tournament & Junior sports star Ramp walk. The main goals here are good times, friendliness, and sportsmanship.");
        Event event4 = new Event("https://res.cloudinary.com/dwzmsvp7f/image/upload/q_75,f_auto,w_800/c_crop%2Cg_custom%2Fv1713598281%2Frchoji6a27sfqv98ekvo.png","Karting Nights 7:30 pm - 12 am","Anandapuram Vizag","Everyday"," A Square (Go Karting) is an adventurous theme park for youngsters & children with a play arena, Drive-in, and Race track situated in Anandapuram, Visakhapatnam. The track is considered to be India`s longest track. Come and test your skills on this route with your friends and family.");
        Event event5 = new Event("https://res.cloudinary.com/dwzmsvp7f/image/upload/q_75,f_auto,w_800/c_crop%2Cg_custom%2Fv1713294775%2Fldrrd2mdssxxi1wsnynx.png","Pink 10K Challenge Vizag","Venue to be announced","1st Dec 2024","Pink Marathon is being organized to salute the spirit of womanhood and to spread the message of women's health, safety and education. It is India’s largest Run platform dedicated to supporting women. The run is open to both Male and Female participants.");
        Event event6 = new Event("https://res.cloudinary.com/dwzmsvp7f/image/upload/q_75,f_auto,w_400/c_crop%2Cg_custom%2Fv1721306971%2Fd40nhhfk1h5rxa4zapsd.png","Micless With Merakee - Vizag Edition","VMRDA Children's Arena, Visakhapatnam","1st Dec 2024","Come, let's sing together!!\n" +
                "\n" +
                "No prior music experience required, just your love for music.\n" +
                "\n" +
                "For more information - follow @bandmerakee on Instagram.");
        Event event7 = new Event("https://cdn-az.allevents.in/events5/banners/dff22951f48879dd5c06b32db716379f608959e29357497301735b54e638b191-rimg-w1200-h675-dcfefefe-gmir.jpg?v=1721078525","Visakhapatnam Startup Meet-up","Hill3, IT SEZ, Maduravada , Visakhapatnam","25th July 2024","Hey Vizag Startup Fam, Let's Connect! ☕\n" +
                "\n" +
                "Prepare for an exciting and engaging time at our Startup Meet-up in Visakhapatnam. Visakhapatnam Startup Meetup is an excellent opportunity to sip, chat, and network with entrepreneurs and ecosystem stakeholders.");
 Event event8 = new Event("https://cdn2.allevents.in/thumbs/thumb6694edc26c890.jpg","INDIAN DESIGNER'S HAAT Vizag 0.10","Novotel Vizag","27 July 2024","✨ Presented by Indian Designer's Haat\n" +
         "\n" +
         "? Indulge in Premium Fashion Lifestyle Trends and Unveil Your Style Essence!");
 Event event9 = new Event("data:image/jpeg;base64,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","Sutraa Exhibition @ Vizag","Novotel Hotel Vizag","19-20 July 2024","✨SPECIAL FOR THE MONSOON, ✨\n" +
         "Sutraa Exhibition will enhance your wardrobe with exquisite creations.\n" +
         "Sutraa Exhibition is the place to go if you want to see the best displays.\n" +
         "exciting journey to the stores. Looks that are sun-ready and fresh, perfect for every weekend getaway.");
 Event event10 = new Event("https://res.cloudinary.com/https-highape-com/image/upload/q_auto:eco,f_auto,h_530/v1690371639/tua6wu36bcjk11dreyyr.jpg","Sound Of Freedom Vol 2","GITAM Medical College","26 Aug and 27Aug 2024","et Ready To Experience An Electrifying Night Like Never Before Is All Set To Witness The Grandest Club Gig In Its History  \"Sound Of Freedom\" Vol 2\n" +
         "\n" +
         "This Extraordinary Event Promises To Take You On An Unforgettable Journey Of Pulsating Beats, Heart-Thumping Rhythms, And An Atmosphere Charged With Sheer Euphoria. ");
        mDataBase.child("events").child("event1").setValue(event1);
        mDataBase.child("events").child("event2").setValue(event2);
        mDataBase.child("events").child("event3").setValue(event3);
        mDataBase.child("events").child("event4").setValue(event4);
        mDataBase.child("events").child("event5").setValue(event5);
        mDataBase.child("events").child("event6").setValue(event6);
        mDataBase.child("events").child("event7").setValue(event7);
        mDataBase.child("events").child("event8").setValue(event8);
        mDataBase.child("events").child("event9").setValue(event9);
        mDataBase.child("events").child("event10").setValue(event10);

        // Read from the database
        DatabaseReference jobsRef = mDataBase.child("events");
        jobsRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                jobList.clear(); // Clear existing list

                // Iterate through all job nodes
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    Event job = snapshot.getValue(Event.class); // Convert snapshot to Job object
                    jobList.add(job); // Add job to list
                }

                // Notify adapter of data change
                eventAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w("JobsActivity", "Failed to read value.", error.toException());
            }
        });
    }
}
