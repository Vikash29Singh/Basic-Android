package com.example.lab12_1847253;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.widget.Toast;

//set the three parameter properly
//3 parameters - param,progress/update
public class mytask extends AsyncTask<Void, Integer, String> {

    Context ctx;  // define a context to avoid error
    ProgressDialog pd;
    public static final int CAMERA_REQUEST=9999;

    mytask(Context c) {
        ctx = c;
    }

    // at the beginning deifne progress bar with all its parameter

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        pd = new ProgressDialog(ctx);
        pd.setMessage("Uploading...");
        pd.setMax(100);
        pd.setCancelable(true);
        pd.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        pd.setIcon(R.mipmap.ic_launcher);
        pd.show();
    }

    // this is what happens in the background
    //background computation

    @Override
    protected String doInBackground(Void... voids) {

        try {
            for (int i = 1; i <= 100; i++) {
                publishProgress(i);
                Thread.sleep(100);  // if error occurs avoid it through try catch

            }

            return "completed";

        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
            }
    }

    //parameters passes to this method
    //invoked on the UI thread after a call to publishProgress(Progress...).
    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
        pd.setProgress(values[0]);
    }

    //invoked on the UI thread after the background computation finishes.
    //The result of the background computation is passed to this step as a parameter.
    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        AlertDialog.Builder builder=new AlertDialog.Builder(ctx);
        builder.setTitle("Alert")

                .setMessage("Img uploaded succesfully")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        ctx.startActivity(new Intent(ctx,Cam_Pic.class));
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                       // Intent intent=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                       // ctx.For(new Intent(MediaStore.ACTION_IMAGE_CAPTURE),CAMERA_REQUEST);
                        Toast.makeText(ctx, "Sorry an error occured", Toast.LENGTH_SHORT).show();
                    }
                });
        builder.show();
        pd.hide();
        Toast.makeText(ctx, s, Toast.LENGTH_SHORT).show();
    }
}
