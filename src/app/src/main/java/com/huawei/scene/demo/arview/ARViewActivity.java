/*
 * Copyright 2020 Huawei Technologies Co., Ltd.
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

package com.huawei.scene.demo.arview;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;

import com.huawei.hms.scene.sdk.ARView;
import com.huawei.scene.demo.R;

/**
 * ARViewActivity
 *
 * @author HUAWEI
 * @since 2020-8-5
 */
public class ARViewActivity extends Activity {
    private ARView mARView;
    private Button mButton;
    private boolean isLoadResource = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ar_view);
        mARView = findViewById(R.id.ar_view);
        mButton = findViewById(R.id.button);
        Switch mSwitch = findViewById(R.id.show_plane_view);
        mSwitch.setChecked(true);
        mSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                mARView.enablePlaneDisplay(isChecked);
            }
        });
        Toast.makeText(this, "Please move the mobile phone slowly to find the plane", Toast.LENGTH_LONG).show();
    }

    /**
     * Synchronously call the onPause() method of the ARView.
     */
    @Override
    protected void onPause() {
        super.onPause();
        mARView.onPause();
    }

    /**
     * Synchronously call the onResume() method of the ARView.
     */
    @Override
    protected void onResume() {
        super.onResume();
        mARView.onResume();
    }

    /**
     * If quick rebuilding is allowed for the current activity, destroy() of ARView must be invoked synchronously.
     */
    @Override
    protected void onDestroy() {
        super.onDestroy();
        mARView.destroy();
    }

    /**
     * Callback upon a button tap
     *
     * @param view the view
     */
    public void onBtnClearResourceClicked(View view) {
        if (!isLoadResource) {
            // Load 3D model.
            mARView.loadAsset("ARView/scene.gltf");
            float[] scale = new float[] { 0.01f, 0.01f, 0.01f };
            float[] rotation = new float[] { 0.707f, 0.0f, -0.707f, 0.0f };
            // (Optional) Set the initial status.
            mARView.setInitialPose(scale, rotation);
            isLoadResource = true;
            mButton.setText(R.string.btn_text_clear_resource);
        } else {
            // Clear the resources loaded in the ARView.
            mARView.clearResource();
            mARView.loadAsset("");
            isLoadResource = false;
            mButton.setText(R.string.btn_text_load);
        }
    }
}