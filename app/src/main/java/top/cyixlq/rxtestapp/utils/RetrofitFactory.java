package top.cyixlq.rxtestapp.utils;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import top.cyixlq.rxtestapp.model.apiservices.JokerApiService;

/**
 * Created by 24215 on 2018/3/17.
 */

public class RetrofitFactory {
    private final static String BASE_URL="https://www.apiopen.top/";
    private static final long TIMEOUT = 30;
    private static JokerApiService jokerApiService=new Retrofit.Builder()
            .baseUrl(BASE_URL)
            //添加Gson转换器
            .addConverterFactory(GsonConverterFactory.create())
            //// 添加Retrofit到RxJava的转换器
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
            .create(JokerApiService.class);

    public static JokerApiService getJokerApiService(){
        return jokerApiService;
    }

}
