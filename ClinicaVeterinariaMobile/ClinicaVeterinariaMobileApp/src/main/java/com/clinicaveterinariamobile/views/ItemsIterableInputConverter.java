/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.clinicaveterinariamobile.views;

/**
 *
 * @author cassioseffrin
 */
import com.gluonhq.connect.converter.InputStreamIterableInputConverter;
import com.gluonhq.connect.converter.JsonConverter;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;
import java.util.Iterator;

public class ItemsIterableInputConverter<E> extends InputStreamIterableInputConverter<E> implements Iterator<E> {

    private JsonArray jsonArray;
    private int index;
    private final JsonConverter<E> converter;

    public ItemsIterableInputConverter(Class<E> targetClass) {
        converter = new JsonConverter<>(targetClass);
    }

    @Override
    public boolean hasNext() {
        return index < jsonArray.size();
    }

    @Override
    public E next() {
        JsonObject jsonObject = jsonArray.getJsonObject(index++);
        return converter.readFromJson(jsonObject);
    }

    @Override
    public Iterator<E> iterator() {
        index = 0;

        try (JsonReader reader = Json.createReader(getInputStream())) {
            JsonObject jsonObject = reader.readObject();
            jsonArray = jsonObject.getJsonArray("items");
        }

        return this;
    }
}