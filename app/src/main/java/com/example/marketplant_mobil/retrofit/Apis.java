package com.example.marketplant_mobil.retrofit;

public class Apis {

    public static final String URL_001="http://10.0.2.2:8000/v1/";

    public static BlogService getBlogService(){
        return  Cliente.getClient(URL_001).create(BlogService.class);
    }
}
