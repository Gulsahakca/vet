package com.gulsahakca.veterineruygulamasii.RestApi;

import com.gulsahakca.veterineruygulamasii.Models.RegisterPojo;

import retrofit2.Call;

public class ManagerAll extends BaseManager{
    private  static ManagerAll ourInstance = new ManagerAll();

    public  static synchronized ManagerAll getInstance()
    {
        return  ourInstance;
    }

    public Call<RegisterPojo> kayitOl(String mailaddress , String username, String password)
    {
        Call<RegisterPojo> x = getRestApi().registerUser(mailaddress,username,password);
        return  x ;
    }
}
