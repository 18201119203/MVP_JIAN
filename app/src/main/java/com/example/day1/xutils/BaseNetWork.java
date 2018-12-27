package com.example.day1.xutils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class BaseNetWork {

    private static BaseNetWork netWork;
    private BaseNetWork() {
    }

    public BaseNetWork inifNetWorkMode(){
        if (netWork==null){
            synchronized (BaseNetWork.class){
                if (netWork==null){
                    netWork = new BaseNetWork();
                }
            }
        }

        return netWork;
    }


    private String  Connection_wl(String murl){

        try {
            URL url = new URL(murl);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        return null;
    }

    private String GetData(InputStream inputStream) throws IOException {

        StringBuilder stringBuilder = new StringBuilder();
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        for (String tmp = bufferedReader.readLine(); tmp != null ; tmp = bufferedReader.readLine()){

            stringBuilder.append(tmp);
        }

        return stringBuilder.toString();
    }




}
