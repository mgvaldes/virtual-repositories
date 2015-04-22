package com.tek3.restaurant;

import android.app.Application;
import android.content.SharedPreferences;
import android.content.res.Resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OptionalDataException;
import java.io.StreamCorruptedException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by gaby on 4/17/15.
 */
public class GlobalState extends Application {
    private Map<String, String> languageResources;

    @Override
    public void onCreate() {
        super.onCreate();
    }

    public void loadLanguageResources(String languageOption) {
        //TODO BORRAAAAAAR!!!!!
        SharedPreferences.Editor editor2 = getSharedPreferences(getString(R.string.settings_file_name), 0).edit();
        editor2.putBoolean("init_config_done", false);
        editor2.commit();

        if (!initialConfigurationDone(languageOption)) {
            Map<String, Map<String, String>> allLanguagesResources = loadAllLanguageResourcesInMapStructure();

            writeLanguageResources(allLanguagesResources);

            languageResources = allLanguagesResources.get(languageOption);

            SharedPreferences.Editor editor = getSharedPreferences(getString(R.string.settings_file_name), 0).edit();
            editor.putBoolean("init_config_done", true);
            editor.commit();
        }
        else {
            readLanguageResources(languageOption);
        }
    }

    public void changeLanguageOption(String languageOption) {
        readLanguageResources(languageOption);
    }

    public void readLanguageResources(String languageOption) {
        try {
            FileInputStream fileInputStream = new FileInputStream(new File(this.getFilesDir() + "allLanguagesResources.config"));

            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

            Map<String, Map<String, String>> allLanguagesResources = (HashMap<String, Map<String, String>>) objectInputStream.readObject();
            objectInputStream.close();

            languageResources = allLanguagesResources.get(languageOption);
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        catch (OptionalDataException e) {
            e.printStackTrace();
        }
        catch (StreamCorruptedException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeLanguageResources(Map<String, Map<String, String>> allLanguagesResources) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(new File(this.getFilesDir() + "allLanguagesResources.config"));

            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(allLanguagesResources);
            objectOutputStream.flush();
            objectOutputStream.close();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean initialConfigurationDone(String languageOption) {
        SharedPreferences settings = getSharedPreferences(getString(R.string.settings_file_name), 0);

        return settings.getBoolean("init_config_done", false);
    }

    public Map<String, Map<String, String>> loadAllLanguageResourcesInMapStructure() {
        Resources resources = getResources();

        String[] languageOptions = resources.getStringArray(R.array.languages_options);

        Map<String, Map<String, String>> allLanguagesResources = new HashMap<String, Map<String, String>>();
        Map<String, String> languageResources;

        // Loading 'Spanish' resources:
        languageResources = new HashMap<String, String>();

        // Button Strings
        languageResources.put("client_button_text", resources.getString(R.string.esp_client_button_text));
        languageResources.put("restaurant_button_text", resources.getString(R.string.esp_restaurant_button_text));
        languageResources.put("enter_button_text", resources.getString(R.string.esp_enter_button_text));
        languageResources.put("restaurant_categories_button_text", resources.getString(R.string.esp_restaurant_categories_button_text));

        // TextView Strings
        languageResources.put("restaurant_code_text", resources.getString(R.string.esp_restaurant_code_text));
        languageResources.put("terms_and_conditions_text", resources.getString(R.string.esp_terms_and_conditions_text));
        languageResources.put("restaurant_name_text", resources.getString(R.string.esp_restaurant_name_text));
        languageResources.put("restaurant_description_text", resources.getString(R.string.esp_restaurant_description_text));
        languageResources.put("restaurant_category_name_text", resources.getString(R.string.esp_restaurant_category_name_text));

        allLanguagesResources.put(languageOptions[0], languageResources);

        // Loading 'English' resources:
        languageResources = new HashMap<String, String>();

        // Button Strings
        languageResources.put("client_button_text", resources.getString(R.string.en_client_button_text));
        languageResources.put("restaurant_button_text", resources.getString(R.string.en_restaurant_button_text));
        languageResources.put("enter_button_text", resources.getString(R.string.en_enter_button_text));
        languageResources.put("restaurant_categories_button_text", resources.getString(R.string.en_restaurant_categories_button_text));

        // TextView Strings
        languageResources.put("restaurant_code_text", resources.getString(R.string.en_restaurant_code_text));
        languageResources.put("terms_and_conditions_text", resources.getString(R.string.en_terms_and_conditions_text));
        languageResources.put("restaurant_name_text", resources.getString(R.string.en_restaurant_name_text));
        languageResources.put("restaurant_description_text", resources.getString(R.string.en_restaurant_description_text));
        languageResources.put("restaurant_category_name_text", resources.getString(R.string.en_restaurant_category_name_text));

        allLanguagesResources.put(languageOptions[1], languageResources);

        return allLanguagesResources;
    }

    public Map<String, String> getLanguageResources() {
        return languageResources;
    }

    public void setLanguageResources(Map<String, String> languageResources) {
        this.languageResources = languageResources;
    }
}
