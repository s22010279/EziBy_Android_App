package com.eziby.eziby_android_app.Classes;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class DbBitmapUtility {

    // convert from bitmap to byte array
    public static String getBase64String(Bitmap bitmap) {
        ByteArrayOutputStream bytesStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, bytesStream);
        byte[] byteArray = bytesStream.toByteArray();
        return Base64.encodeToString(byteArray, Base64.DEFAULT);
    }

    //convert from byte array to bitmap
    public static Bitmap getImage(String previouslyEncodedImage) {
        byte[] byteArray = Base64.decode(previouslyEncodedImage, Base64.DEFAULT);
        return BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
    }

    public static String saveImageToCache(String Directory, Bitmap imageTaken) throws IOException {
        if (imageTaken == null) return null;

        int time = (int) (System.currentTimeMillis());
        String uniqueFileName = String.valueOf(time).replace('-', 'F');

        //create a file to write bitmap data
        File file = new File(Directory, uniqueFileName + ".jpg");
        boolean fileCreated = file.createNewFile();

        if (fileCreated) {
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            imageTaken.compress(Bitmap.CompressFormat.JPEG, 100, bos);
            byte[] bitmapData = bos.toByteArray();

            FileOutputStream fos = new FileOutputStream(file);
            fos.write(bitmapData);
            fos.flush();
            fos.close();
            return file.getPath();
        }
        return null;
    }
}