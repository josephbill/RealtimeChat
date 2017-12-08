package com.wordpress.pesanmerpati.realtimechat.Adapter;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.wordpress.pesanmerpati.realtimechat.Pojo.ChatMessage;
import com.wordpress.pesanmerpati.realtimechat.R;

import java.util.List;

/**
 * Created by Rohmats on 11/25/2017.
 */

public class MessageAdapter extends ArrayAdapter<ChatMessage> {


    public MessageAdapter(Context context, int resource, List<ChatMessage> objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            convertView = ((Activity) getContext()).getLayoutInflater().inflate(R.layout.item_message, parent, false);
        }

        ImageView mImageViewPhoto = convertView.findViewById(R.id.image_view_photo);
        TextView mTextViewMessage = convertView.findViewById(R.id.text_view_message);
        TextView mTextViewName = convertView.findViewById(R.id.text_view_name);

        ChatMessage message = getItem(position);

        boolean isPhoto = message.getPhotoUrl() != null;
        if (isPhoto) {
            mTextViewMessage.setVisibility(View.GONE);
            mImageViewPhoto.setVisibility(View.VISIBLE);
            Glide.with(mImageViewPhoto.getContext())
                    .load(message.getPhotoUrl())
                    .into(mImageViewPhoto);
        } else {
            mTextViewMessage.setVisibility(View.VISIBLE);
            mImageViewPhoto.setVisibility(View.GONE);
            mTextViewMessage.setText(message.getText());
        }

        mTextViewName.setText(message.getName());

        return convertView;
    }
}
