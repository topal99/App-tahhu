package com.tahhu.coba;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class Survey extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ReviewAdapter reviewAdapter;
    private List<Review> reviewList;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_survey);

        recyclerView = findViewById(R.id.recyclerViewSurvey);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        reviewList = new ArrayList<>();
        reviewList.add(new Review("Alice", "4.8", "Great app! Really enjoyed using it."));
        reviewList.add(new Review("Bob", "4,5", "It’s good, but could use some improvements."));
        reviewList.add(new Review("Charlie", "4,8", "Absolutely loved it!"));
        reviewList.add(new Review("Dana", "4,7", "Very useful and easy to use."));

        reviewAdapter = new ReviewAdapter(reviewList);
        recyclerView.setAdapter(reviewAdapter);
        ImageView btnback = findViewById(R.id.back);

        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle click event, for example, open another activity
                Intent intent = new Intent(Survey.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    // Inner class for the Review model
    public static class Review {
        private String userName;
        private String rating;
        private String comment;

        public Review(String userName, String rating, String comment) {
            this.userName = userName;
            this.rating = rating;
            this.comment = comment;
        }

        public String getUserName() {
            return userName;
        }

        public String getRating() {
            return rating;
        }

        public String getComment() {
            return comment;
        }
    }

    // Inner class for the RecyclerView Adapter
    public class ReviewAdapter extends RecyclerView.Adapter<ReviewAdapter.ReviewViewHolder> {
        private List<Review> reviewList;

        public ReviewAdapter(List<Review> reviewList) {
            this.reviewList = reviewList;
        }

        @NonNull
        @Override
        public ReviewViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_survey, parent, false);
            return new ReviewViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull ReviewViewHolder holder, int position) {
            Review review = reviewList.get(position);
            holder.userName.setText(review.getUserName());
            holder.comment.setText(review.getComment());
            holder.ratingBar.setText(review.getRating());
        }

        @Override
        public int getItemCount() {
            return reviewList.size();
        }

        // ViewHolder class for RecyclerView items
        public class ReviewViewHolder extends RecyclerView.ViewHolder {
            TextView userName, comment, ratingBar;


            @SuppressLint("WrongViewCast")
            public ReviewViewHolder(@NonNull View itemView) {
                super(itemView);
                userName = itemView.findViewById(R.id.userName);
                comment = itemView.findViewById(R.id.userReview);
                ratingBar = itemView.findViewById(R.id.userRating);
            }
        }
    }
}
