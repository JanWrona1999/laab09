package pollub.ism.lab09;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.util.ArrayList;

public class FruitDataProvider implements FruitListAdapter.FruitDataProvider {
    ArrayList<FruitListAdapter.AdapterResources> data = new ArrayList<>();

    @Override
    public ArrayList<FruitListAdapter.AdapterResources> getResources() {
        return data;
    }

    public FruitDataProvider(Resources res) {
        String[] names      = res.getStringArray(R.array.names);
        String[] descs      = res.getStringArray(R.array.descriptions);
        TypedArray images   = res.obtainTypedArray(R.array.pictures);
        for(int i = 0; i < names.length; i++){
            Bitmap bitmap = BitmapFactory.decodeResource(res, images.getResourceId(i, 0));
            data.add(new FruitListAdapter.AdapterResources(names[i], descs[i], bitmap));
        }
    }
}