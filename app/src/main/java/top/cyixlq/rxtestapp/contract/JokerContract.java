package top.cyixlq.rxtestapp.contract;

import java.util.List;

import io.reactivex.Observer;
import top.cyixlq.rxtestapp.model.bean.Joker;

/**
 * Created by 24215 on 2018/3/17.
 */

public interface JokerContract {
    interface Model {
        void getJokerList(String type,String page,Observer<Joker> observer);
    }

    interface View {
        void showJokerList(List<Joker.DataBean> list);
        void getJokerListFinish();
        void getJokerListErro(String msg);
    }

    interface Presenter {
        void getJokerList(String type,String page);
    }
}
