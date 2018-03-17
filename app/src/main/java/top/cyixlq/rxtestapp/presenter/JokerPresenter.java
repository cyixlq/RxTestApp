package top.cyixlq.rxtestapp.presenter;

import java.util.List;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import top.cyixlq.rxtestapp.contract.JokerContract;
import top.cyixlq.rxtestapp.model.JokerModel;
import top.cyixlq.rxtestapp.model.bean.Joker;

/**
 * Created by 24215 on 2018/3/17.
 */

public class JokerPresenter implements JokerContract.Presenter {

    JokerContract.Model mModel;
    JokerContract.View mView;

    public JokerPresenter(JokerContract.View view){
        mModel=new JokerModel();
        this.mView=view;
    }

    @Override
    public void getJokerList(String type, String page) {
        mModel.getJokerList(type,page,new Observer<Joker>(){

            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(Joker joker) {
                List<Joker.DataBean> list=joker.getData();
                mView.showJokerList(list);
            }

            @Override
            public void onError(Throwable e) {
                mView.getJokerListErro(e.getMessage());
            }

            @Override
            public void onComplete() {
                mView.getJokerListFinish();
            }
        });
    }
}
