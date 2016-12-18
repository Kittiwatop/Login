package com.example.login.adapter;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.login.R;
import com.example.login.model.user;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

/**
 * Created by ON-ONE on 12/18/2016.
 */
public class ListarrayAdapter extends ArrayAdapter<user> {
    private Context mContext;
    private int mLayoutResId;
    private ArrayList<user> mContactList;

    public ListarrayAdapter(Context context, int resource, ArrayList<user> contactList) {
        super(context, resource, contactList);

        this.mContext = context;
        this.mLayoutResId = resource;
        this.mContactList = contactList;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View itemLayout =  convertView;

        if(itemLayout == null) {
            itemLayout = View.inflate(mContext, mLayoutResId, null);// à»ç¹ static method
        }

        ImageView imageView =(ImageView) itemLayout.findViewById(R.id.image);
        TextView nameTextView = (TextView)itemLayout.findViewById(R.id.text);

        user contact = mContactList.get(position);

        String contactName = contact.getName();
        nameTextView.setText(contactName);

        String contactImage = contact.getImage();
        AssetManager am = mContext.getAssets();
        try {
            InputStream steam = am.open(contactImage);
            Drawable imageDrawable = Drawable.createFromStream(steam, null);
            imageView.setImageDrawable(imageDrawable); //รูปแบบ android

        } catch (IOException e) {
            Log.e("ContactListAdapter", "Error open image file: "+ contactImage );
            e.printStackTrace();
        }
        return itemLayout;

    }
}
