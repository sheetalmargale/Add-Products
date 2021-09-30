package com.example.addproducts.model;

import com.google.gson.annotations.SerializedName;

public class Products {
        @SerializedName("id")
        private Integer id;
        @SerializedName("name")
        private String Name;
        @SerializedName("price")
        private String Price;
        @SerializedName("rating")
        private String Rating;
        @SerializedName("image_url")
        private String Image_url;

        public String getName() {
            return Name;
        }

        public void setName(String name) {
            Name = name;
        }

        public String getPrice() {
            return Price;
        }

        public void setPrice(String price) {
            Price = price;
        }

        public String getRating() {
            return Rating;
        }

        public void setRating(String rating) {
            Rating = rating;
        }

        public String getImage_url() {
            return Image_url;
        }


        public void setImage_url(String image_url) {
            Image_url = image_url;
        }
    public Integer getId() {
        return id;
    }

    public Products(String Name, String Image_url, String Price, String Rating,Integer id) {
        this.Name = Name;
        this.Image_url = Image_url;
        this.Price = Price;
        this.Rating = Rating;
        this.id=id;
    }
}
