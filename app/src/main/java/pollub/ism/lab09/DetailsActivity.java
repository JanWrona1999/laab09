package pollub.ism.lab09;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        TextView fruitName      = (TextView) findViewById(R.id.FruitItemName);
        TextView fruitDesc      = (TextView) findViewById(R.id.FruitItemDesc);
        ImageView fruitBitmap   = (ImageView) findViewById(R.id.FruitItemImage);
        Intent intent           = getIntent();

        if (intent != null) {
            fruitName.setText(intent.getStringExtra("name"));
            fruitDesc.setText(intent.getStringExtra("desc"));

            //Wyjęcie bitmapy z intencji
            byte[] bitmap = intent.getByteArrayExtra("bitmap");
            Bitmap decodedBitmap = BitmapFactory.decodeByteArray(bitmap, 0, bitmap.length);
            fruitBitmap.setImageBitmap(decodedBitmap);
        }
    }
}
