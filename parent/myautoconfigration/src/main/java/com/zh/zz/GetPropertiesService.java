package com.zh.zz;

public class GetPropertiesService {

    private  MyAutoProperties myAutoProperties;


    public  String myAuto() {



        return  "Hello"+myAutoProperties.getName();

    }


    public MyAutoProperties getMyAutoProperties() {
        return myAutoProperties;
    }

    public void setMyAutoProperties(MyAutoProperties myAutoProperties) {
        this.myAutoProperties = myAutoProperties;
    }
}
