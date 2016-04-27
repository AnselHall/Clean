package com.ansel.clean;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ansel.clean.Utils.MemoryStatus;

import butterknife.ButterKnife;

/**
 *
 */
public class ContentFragment extends Fragment{

    private static final String TAG = "tag";
    private Context mContext;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.content_fragment,container,false);
        ButterKnife.bind(this, v);
        mContext = getActivity();

        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        fillData();
    }

    /**
     * 获取设备的内存和存储信息，填充进度条
     */
    private void fillData() {
        //获取存储信息

        if (MemoryStatus.externalMemoryAvailable()) {

            String availableExternalMemorySize = MemoryStatus.formatSize(MemoryStatus.getAvailableExternalMemorySize());
            String availableInternalMemorySize = MemoryStatus.formatSize(MemoryStatus.getAvailableInternalMemorySize());

            String totalExternalMemorySize = MemoryStatus.formatSize(MemoryStatus.getTotalExternalMemorySize());
            String totalInternalMemorySize = MemoryStatus.formatSize(MemoryStatus.getTotalInternalMemorySize());

            String totalMemory = MemoryStatus.formatSize(MemoryStatus.getTotalExternalMemorySize() + MemoryStatus.getTotalInternalMemorySize());

            Log.e(TAG, "fillData: availableExternalMemorySize = " + availableExternalMemorySize + "\n" +
                "   availableInternalMemorySize = " + availableInternalMemorySize + "\n" +
                "   totalExternalMemorySize = " + totalExternalMemorySize +  "\n" +
                "   totalInternalMemorySize = " + totalInternalMemorySize+  "\n" +
                "   totalMemory = " + totalMemory);

        }


    }
}
