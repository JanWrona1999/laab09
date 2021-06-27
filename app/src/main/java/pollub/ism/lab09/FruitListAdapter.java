package pollub.ism.lab09;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

public class FruitListAdapter extends RecyclerView.Adapter<FruitListAdapter.FruitDataHolder> {

    public static class AdapterResources {
        public final String name, description;
        public final Bitmap bitmap;

        public AdapterResources(String name, String description, Bitmap bitmap) {
            this.name = name;
            this.description = description;
            this.bitmap = bitmap;
        }
    }

    public interface FruitDataProvider {
        ArrayList<AdapterResources> getResources();
    }

    class FruitDataHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private final FruitListAdapter listAdapter;
        public final TextView fruitName;
        public final ImageView fruitBitmap;

        public FruitDataHolder(@NonNull View itemView, FruitListAdapter adapter) {
            super(itemView);
            fruitName = itemView.findViewById(R.id.FruitListItemName);
            fruitBitmap = itemView.findViewById(R.id.FruitListItemImage);
            listAdapter = adapter;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            AdapterResources item = dataProvider.getResources().get(getLayoutPosition());
            Intent intent = new Intent(context, DetailsActivity.class);
            intent.putExtra("name", item.name);
            intent.putExtra("desc", item.description);

            ByteArrayOutputStream imageStream = new ByteArrayOutputStream();
            item.bitmap.compress(Bitmap.CompressFormat.PNG, 100, imageStream);
            byte[] itemBitmap = imageStream.toByteArray();
            intent.putExtra("bitmap", itemBitmap);
            context.startActivity(intent);
        }

    }

    private final Context context;
    private final FruitDataProvider dataProvider;
    private LayoutInflater inflater;

    public FruitListAdapter(Context context, FruitDataProvider dataProvider) {
        this.context = context;
        this.dataProvider = dataProvider;
        this.inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public FruitDataHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View item = inflater.inflate(R.layout.element_fruitlist, parent, false);
        return new FruitDataHolder(item, this);
    }

    @Override
    public void onBindViewHolder(@NonNull FruitDataHolder holder, int position) {
        AdapterResources item = dataProvider.getResources().get(position);
        holder.fruitName.setText(item.name);
        holder.fruitBitmap.setImageBitmap(item.bitmap);

    }

    @Override
    public int getItemCount() {
        return dataProvider.getResources().size();
    }
}