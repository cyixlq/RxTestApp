package top.cyixlq.rxtestapp.model;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import top.cyixlq.rxtestapp.contract.JokerContract;
import top.cyixlq.rxtestapp.model.apiservices.JokerApiService;
import top.cyixlq.rxtestapp.model.bean.Joker;
import top.cyixlq.rxtestapp.utils.RetrofitFactory;

/**
 * Created by 24215 on 2018/3/17.
 */

public class JokerModel implements JokerContract.Model {
    @Override
    public void getJokerList(String type, String page, Observer<Joker> observer) {
        JokerApiService apiService=RetrofitFactory.getJokerApiService();
        Observable<Joker> observable= apiService.getJokerList(type,page);
        observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }
}
