package com.example.androidrecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    List<User> users;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.Recycler_users);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        final UserAdapter userAdapter= new UserAdapter();
        recyclerView.setAdapter(userAdapter);

        User user1 = new User("Nam", 10);
        User user2 = new User("Hoa", 9);
        User user3 = new User("Mai", 8);

        users = new ArrayList<User>();
        users.add(user1);
        users.add(user2);
        users.add(user3);

        userAdapter.users = users;

        findViewById(R.id.button_add).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "click", Toast.LENGTH_SHORT).show();

                users.add(new User("Mai", 8));

                userAdapter.notifyDataSetChanged();
            }
        });

        findViewById(R.id.button_update).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "click", Toast.LENGTH_SHORT).show();
                users.get(0).name = "Minh";
                userAdapter.notifyDataSetChanged();

            }
        });
    }
}
