/**
 * (C) Copyright 2021 Araf Karsh Hamid
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.fusion.air.microservice.domain.models;

/**
 *
 * @author: Araf Karsh Hamid
 * @version:
 * @date:
 */
public class Product {

    // Product Info
    private String id;
    private String name;
    private String description;
    private String image;
    // Categories
    private String productCategory;
    private String productSubCategory;
    // Product Manufacturer
    private String brand;
    private String model;
    private String manufacturer;
    private int manufacturingYear;
    // Product Price
    private double productPrice;
    private String currency;

    public Product() {
    }

    public String getId() {
        return id;
    }

    public String getModel() {
        return model;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public String getCurrency() {
        return currency;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getImage() {
        return image;
    }

    public int getManufacturingYear() {
        return manufacturingYear;
    }

    public String getProductCategory() {
        return productCategory;
    }

    public String getBrand() {
        return brand;
    }


    public String getProductSubCategory() {
        return productSubCategory;
    }
}
