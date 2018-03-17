package top.cyixlq.rxtestapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import top.cyixlq.rxtestapp.contract.JokerContract;
import top.cyixlq.rxtestapp.model.bean.Joker;
import top.cyixlq.rxtestapp.presenter.JokerPresenter;
import top.cyixlq.rxtestapp.view.adapter.JokerAdapter;

public class MainActivity extends AppCompatActivity implements JokerContract.View{

    public static final String TAG="MainActivity";

    JokerPresenter mPresenter;
    JokerAdapter mAdapter;
    List<Joker.DataBean> mList;

    private RecyclerView mRecyclerView;
    private ProgressBar mProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mPresenter=new JokerPresenter(this);
        mRecyclerView=findViewById(R.id.rec);
        mProgressBar=findViewById(R.id.pro);
        initData();
        mPresenter.getJokerList("29","1");
    }

    private void initData(){
        mList=new ArrayList<>();
        mAdapter=new JokerAdapter(mList);
        LinearLayoutManager manager=new LinearLayoutManager(MainActivity.this);
        mRecyclerView.setLayoutManager(manager);
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    public void showJokerList(List<Joker.DataBean> list) {
        mProgressBar.setVisibility(View.VISIBLE);
        mList.addAll(list);
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void getJokerListFinish() {
        mProgressBar.setVisibility(View.GONE);
    }

    @Override
    public void getJokerListErro(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
        Log.e(TAG,msg);
    }
}
