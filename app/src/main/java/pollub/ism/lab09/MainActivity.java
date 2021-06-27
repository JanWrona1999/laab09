package pollub.ism.lab09;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FruitDataProvider fruitDataProvider = new FruitDataProvider(getResources());
        FruitListAdapter fruitListAdapter   = new FruitListAdapter(this, fruitDataProvider);
        RecyclerView fruitListView          = findViewById(R.id.FruitList);

        fruitListView.setAdapter(fruitListAdapter);
        fruitListView.setLayoutManager(new LinearLayoutManager(this));
    }
}