/*
 * Copyright 2021 Huawei Technologies Co., Ltd.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.huawei.scene.demo.faceview;

import android.app.Activity;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.Switch;

import com.huawei.hms.scene.sdk.FaceView;
import com.huawei.hms.scene.sdk.common.LandmarkType;
import com.huawei.scene.demo.R;

/**
 * FaceViewActivity
 *
 * @author HUAWEI
 * @since 2020-8-5
 */
public class FaceViewActivity extends Activity {
    final float[] position = { 0.0f, -0.1f, 0.0f };
    final float[] rotation = { 1.0f, 0.0f, 0.0f, 0.0f };
    final float[] scale = { 0.01f, 0.01f, 0.01f };

    private FaceView mFaceView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_face_view);
        mFaceView = findViewById(R.id.face_view);
        Switch mSwitch = findViewById(R.id.switch_view);
        mSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                mFaceView.clearResource();
                if (isChecked) {
                    // Load asset.
                    int index = mFaceView.loadAsset("FaceView/fox.glb", LandmarkType.TIP_OF_NOSE);
                    // (Optional) Set the initial status.
                    mFaceView.setInitialPose(index, position, scale, rotation);
                }
            }
        });
    }

    /**
     * Synchronously call the onResume() method of the FaceView.
     */
    @Override
    protected void onResume() {
        super.onResume();
        mFaceView.onResume();
    }

    /**
     * Synchronously call the onPause() method of the FaceView.
     */
    @Override
    protected void onPause() {
        super.onPause();
        mFaceView.onPause();
    }

    /**
     * If quick rebuilding is allowed for the current activity, destroy() of FaceView must be invoked synchronously.
     */
    @Override
    protected void onDestroy() {
        super.onDestroy();
        mFaceView.destroy();
    }
}