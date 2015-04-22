package com.tek3.restaurant.adapters;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.http.AndroidHttpClient;
import android.os.AsyncTask;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.tek3.restaurant.R;
import com.tek3.restaurant.adapters.models.Advertising;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpGet;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;

/**
 * Created by mgvaldes on 22/04/15.
 */
public class AdvertisingsCustomArrayAdapter extends ArrayAdapter<Advertising> {
    private LayoutInflater layoutInflater;
    private List<Advertising> advertisingList;
    private HashMap<Integer, Boolean> advertisingImageViewStatus;
    private HashMap<Integer, Bitmap> advertisingBitmapList;
    private HashMap<Integer, ImageView> advertisingImageViewList;

    public AdvertisingsCustomArrayAdapter(Context context, List<Advertising> objects) {
        super(context, 0, objects);

        layoutInflater = LayoutInflater.from(context);
        advertisingList = objects;
        advertisingImageViewStatus = new HashMap<Integer, Boolean>();
        advertisingBitmapList = new HashMap<Integer, Bitmap>();
        advertisingImageViewList = new HashMap<Integer, ImageView>();

        Bitmap loadingBitmap = ((BitmapDrawable)context.getResources().getDrawable(R.drawable.loading_image)).getBitmap();

        for (int i = 0; i < advertisingList.size(); i++) {
            advertisingImageViewStatus.put(i, false);
            advertisingBitmapList.put(i, loadingBitmap);
        }
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        Advertising advertising = getItem(position);

        convertView = layoutInflater.inflate(R.layout.list_item_advertising, null);

        TextView advertisingNameTextView = (TextView) convertView.findViewById(R.id.advertisingNameTextView);
        advertisingNameTextView.setText(advertising.getAdvertisingName());

        ImageView advertisingImageView = (ImageView) convertView.findViewById(R.id.advertisingImageView);

        advertisingImageViewList.put(position, advertisingImageView);

        if (!advertisingImageViewStatus.get(position)) {
            advertisingImageView.setImageBitmap(((BitmapDrawable)getContext().getResources().getDrawable(R.drawable.loading_image)).getBitmap());

            Log.w("CargaDinamicaBitmaps", "Iniciando descargda de promocion: " + advertising.getAdvertisingName() + " en posicion: " + position);
            new HttpRequestTaskDownloadRestaurantCategoryImage(advertising.getAdvertisingImageURL(), position).execute();
        }
        else {
            advertisingImageView.setImageBitmap(advertisingBitmapList.get(position));
        }

        return convertView;
    }

    private class HttpRequestTaskDownloadRestaurantCategoryImage extends AsyncTask<Void, Void, Bitmap> {
        private String advertisingImageURL;
        private Integer advertisingImageViewPosition;

        public HttpRequestTaskDownloadRestaurantCategoryImage(String advertisingImageURL, Integer advertisingImageViewPosition) {
            this.advertisingImageURL = advertisingImageURL;
            this.advertisingImageViewPosition = advertisingImageViewPosition;
        }

        @Override
        protected Bitmap doInBackground(Void... params) {
            final AndroidHttpClient client = AndroidHttpClient.newInstance("Android");
            final HttpGet getRequest = new HttpGet(advertisingImageURL);

            try {
                HttpResponse response = client.execute(getRequest);
                final int statusCode = response.getStatusLine().getStatusCode();

                if (statusCode != HttpStatus.SC_OK) {
                    Log.w("ImageDownloader", "Error " + statusCode + " while retrieving bitmap from " + advertisingImageURL);

                    return null;
                }

                final HttpEntity entity = response.getEntity();

                if (entity != null) {
                    InputStream inputStream = null;

                    try {
                        inputStream = entity.getContent();

                        final Bitmap bitmap = BitmapFactory.decodeStream(inputStream);

                        return bitmap;
                    }
                    finally {
                        if (inputStream != null) {
                            inputStream.close();
                        }

                        entity.consumeContent();
                    }
                }
            }
            catch (Exception e) {
                // Could provide a more explicit error message for IOException or IllegalStateException
                getRequest.abort();

                Log.w("ImageDownloader", "Error while retrieving bitmap from " + advertisingImageURL, e);
                e.printStackTrace();
            }
            finally {
                if (client != null) {
                    client.close();
                }
            }

            return null;
        }

        /**
         * Una vez obtenido el TicketDTO o TicketGroupDTO de Dynamo, dependiendo
         * del modo de validación del dispositivo, manual o automático y el resto
         * de los parámetros de configuración del dispositivo, se procede
         * a realizar la validación del ticket.
         *
         * El resultado de la validación se muestra siempre en uno (modo automático)
         * o mas (modo manual) elementos del tipo TicketValidationDTO. Con este
         * resultado se muestra en la pantalla principal el resultado de la validación
         * del ticket escaneado.
         *
         */
        @Override
        protected void onPostExecute(Bitmap advertisingBitmap) {
            ImageView advertisingImageView = advertisingImageViewList.get(advertisingImageViewPosition);
            advertisingImageView.setImageBitmap(advertisingBitmap);

            advertisingImageViewStatus.put(advertisingImageViewPosition, true);
            advertisingBitmapList.put(advertisingImageViewPosition, advertisingBitmap);

            Log.w("CargaDinamicaBitmaps", "Actualizando bitmap de promocion en posicion: " + advertisingImageViewPosition);
        }
    }
}
