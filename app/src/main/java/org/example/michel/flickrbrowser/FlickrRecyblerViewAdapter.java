package org.example.michel.flickrbrowser;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by michel on 16/04/15.
 */
public class FlickrRecyblerViewAdapter extends RecyclerView.Adapter<FlickrImageViewHolder> {

    private List<Photo> mPhotoList;
    private Context mContext;

    public FlickrRecyblerViewAdapter(Context context, List<Photo> photoList) {

        mContext = context;
        this.mPhotoList = photoList;
    }

    @Override
    public FlickrImageViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.browser, null);
        FlickrImageViewHolder flickrImageViewHolder = new FlickrImageViewHolder(view);

        return flickrImageViewHolder;
    }

    @Override
    public int getItemCount() {
        return (null != mPhotoList ? mPhotoList.size() : 0);
    }
}
