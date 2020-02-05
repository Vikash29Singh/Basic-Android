package com.example.lab12_1847253;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

public class Cam_Pic extends Fragment {
    public static final int CAMERA_REQUEST=9999;
    public static final int SELECT_IMAGE=0;
    ImageView imageView;
    View view;
    Button camera,upload,pick;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.cam_pic, container, false);

      imageView= view.findViewById(R.id.img_view);
      camera=view.findViewById(R.id.camera);
      pick=view.findViewById(R.id.pick);
      upload=view.findViewById(R.id.upload);

      camera.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              Intent intent=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
              startActivityForResult(intent,CAMERA_REQUEST);
          }
      });

      pick.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              //  final CharSequence[] items = {"Gallery", "Cancel"};
              AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
              builder.setTitle("Add Image From Gallery");
              builder.setPositiveButton("Gallery", new DialogInterface.OnClickListener() {
                  @Override
                  public void onClick(DialogInterface dialog, int which) {
                      Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                      intent.setType("image/*");
                      startActivityForResult(intent.createChooser(intent, "Select File"), SELECT_IMAGE);
                  }
              });

              builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                  @Override
                  public void onClick(DialogInterface dialog, int which) {
                      Toast toast = Toast.makeText(getContext(),
                              "You Cancelled",
                              Toast.LENGTH_SHORT);

                      toast.show();
                      dialog.dismiss();
                  }
              });
              AlertDialog dialog = builder.create();
              // Display the alert dialog on interface
              dialog.show();

          }
      });

        upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // creating an object for a class mytask
                //telling it to


                    mytask T = new mytask(getContext());
                    T.execute();   // this will call do in background

            }
        });


return view;
    }



    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==CAMERA_REQUEST)
        {
            Bitmap bitmap=(Bitmap) data.getExtras().get("data");
            imageView.setImageBitmap(bitmap );



        }
        if(requestCode==SELECT_IMAGE){
            Uri selectImageUri = data.getData();
            imageView.setImageURI(selectImageUri);


        }


    }







}
