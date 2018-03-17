package top.cyixlq.rxtestapp.model.apiservices;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;
import top.cyixlq.rxtestapp.model.bean.Joker;

/**
 * Created by 24215 on 2018/3/17.
 */

public interface JokerApiService {
    @GET("satinApi")
    Observable<Joker> getJokerList(@Query("type")String type,@Query("page")String page);
}