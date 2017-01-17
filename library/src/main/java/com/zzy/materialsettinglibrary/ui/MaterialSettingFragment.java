package com.zzy.materialsettinglibrary.ui;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zzy.materialsettinglibrary.R;
import com.zzy.materialsettinglibrary.adapters.MaterialSettingListAdapter;
import com.zzy.materialsettinglibrary.model.MaterialSettingList;

/**
 * Created by zzyandzzy on 2017/1/13.
 */

public abstract class MaterialSettingFragment extends Fragment {
    private RecyclerView recyclerView;
    private MaterialSettingListAdapter adapter;
    private MaterialSettingList list = new MaterialSettingList.Builder().build();

    protected abstract MaterialSettingList getMaterialSettingList(Context context);

    public static MaterialSettingFragment newInstance(MaterialSettingFragment fragment){
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.mal_material_setting_fragment,container,false);
        ;
        recyclerView = (RecyclerView) view.findViewById(R.id.mal_recyclerview);
        adapter = new MaterialSettingListAdapter(new MaterialSettingList.Builder().build());
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(adapter);
        recyclerView.setAlpha(0f);
        recyclerView.setTranslationY(40f);
        ListTask listTask = new ListTask(getActivity());
        listTask.execute();
        return view;
    }

    private class ListTask extends AsyncTask<String ,String ,String >{
        Context context;

        public ListTask(Context context){
            this.context = context;
        }
        @Override
        protected String doInBackground(String... params) {
            list = getMaterialSettingList(context);
            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            adapter.swapData(list);
            recyclerView.animate().alpha(1f).translationY(0f).setDuration(200).start();
            super.onPostExecute(s);
            context = null;
        }
    }
}
