package swati4star.createpdf.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.io.File;
import java.util.ArrayList;

import swati4star.createpdf.R;

public class PreviewAdapter extends PagerAdapter {

    private final Context mContext;
    private final ArrayList<String> mPreviewItems;
    private final LayoutInflater mInflater;


    public PreviewAdapter(Context context, ArrayList<String> previewItems) {
        mContext = context;
        mPreviewItems = previewItems;
        mInflater = LayoutInflater.from(context);

    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup view, int position) {
        View layout = mInflater.inflate(R.layout.pdf_preview_item, view, false);

        final ImageView imageView = layout.findViewById(R.id.image);

        File fileLocation = new File(mPreviewItems.get(position));

        Picasso.with(mContext).load(fileLocation).into(imageView);
        view.addView(layout, 0);
        return layout;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup collection, int position, @NonNull Object view) {
        collection.removeView((View) view);
    }

    @Override
    public int getCount() {
        return mPreviewItems.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        String pageTitle = String.format(mContext.getResources().getString(R.string.showing_image),
                position + 1, mPreviewItems.size());

        return pageTitle;
    }


}
