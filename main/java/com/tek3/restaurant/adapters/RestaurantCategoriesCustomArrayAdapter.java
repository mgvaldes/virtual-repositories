package com.tek3.restaurant.adapters;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
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
import com.tek3.restaurant.adapters.models.RestaurantCategory;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpGet;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by root on 15/04/15.
 */
public class RestaurantCategoriesCustomArrayAdapter extends ArrayAdapter<RestaurantCategory> {
    private LayoutInflater layoutInflater;
    private List<RestaurantCategory> restaurantCategoryList;
    private HashMap<Integer, ImageView> restaurantCategoryImageViewList;

    public RestaurantCategoriesCustomArrayAdapter(Context context, int resource, List<RestaurantCategory> objects) {
        super(context, resource, objects);

        layoutInflater = LayoutInflater.from(context);
        restaurantCategoryList = objects;
        restaurantCategoryImageViewList = new HashMap<Integer, ImageView>();
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        RestaurantCategory restaurantCategory = getItem(position);

        convertView = layoutInflater.inflate(R.layout.list_item_restaurant_category, null);

        TextView restaurantCategoryNameTextView = (TextView) convertView.findViewById(R.id.restaurantCategoryNameTextView);
        restaurantCategoryNameTextView.setText(restaurantCategory.getRestaurantCategoryName());

        ImageView restaurantCategoryImageView = (ImageView) convertView.findViewById(R.id.restaurantCategoryImageView);

        restaurantCategoryImageViewList.put(position, restaurantCategoryImageView);



        return convertView;
    }

    private class HttpRequestTaskDownloadRestaurantCategoryImage extends AsyncTask<Void, Void, Bitmap> {
        private String restaurantCategoryImageURL;
        private Integer restaurantCategoryImageViewPosition;

        public HttpRequestTaskDownloadRestaurantCategoryImage(String restaurantCategoryImageURL, Integer restaurantCategoryImageViewPosition) {
            this.restaurantCategoryImageURL = restaurantCategoryImageURL;
            this.restaurantCategoryImageViewPosition = restaurantCategoryImageViewPosition;
        }

        @Override
        protected Bitmap doInBackground(Void... params) {
            final AndroidHttpClient client = AndroidHttpClient.newInstance("Android");
            final HttpGet getRequest = new HttpGet(restaurantCategoryImageURL);

            try {
                HttpResponse response = client.execute(getRequest);
                final int statusCode = response.getStatusLine().getStatusCode();

                if (statusCode != HttpStatus.SC_OK) {
                    Log.w("ImageDownloader", "Error " + statusCode + " while retrieving bitmap from " + restaurantCategoryImageURL);

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

                Log.w("ImageDownloader", "Error while retrieving bitmap from " + restaurantCategoryImageURL, e);
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
        protected void onPostExecute(Bitmap restaurantCategoryImage) {
            ImageView restaurantCategoryImageView = restaurantCategoryImageViewList.get(restaurantCategoryImageViewPosition);
            restaurantCategoryImageView.setImageBitmap(restaurantCategoryImage);
        }
    }
}
