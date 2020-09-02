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

package com.huawei.scene.demo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import com.huawei.scene.demo.arview.ARViewActivity;
import com.huawei.scene.demo.faceview.FaceViewActivity;
import com.huawei.scene.demo.sceneview.SceneViewActivity;

/**
 * MainActivity
 *
 * @author HUAWEI
 * @since 2020-5-13
 */
public class MainActivity extends AppCompatActivity {
    private static final int FACE_VIEW_REQUEST_CODE = 1;
    private static final int AR_VIEW_REQUEST_CODE = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onRequestPermissionsResult(
        int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case FACE_VIEW_REQUEST_CODE:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    startActivity(new Intent(this, FaceViewActivity.class));
                }
                break;
            case AR_VIEW_REQUEST_CODE:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    startActivity(new Intent(this, ARViewActivity.class));
                }
                break;
            default:
                break;
        }
    }

    /**
     * Starts the SceneViewActivity, a callback method which is called upon a tap on the START ACTIVITY button.
     *
     * @param view View that is tapped
     */
    public void onBtnSceneViewDemoClicked(View view) {
        startActivity(new Intent(this, SceneViewActivity.class));
    }

    /**
     * Starts the FaceViewActivity, a callback method which is called upon a tap on the START ACTIVITY button.
     *
     * @param view View that is tapped
     */
    public void onBtnFaceViewDemoClicked(View view) {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA)
            != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(
                this, new String[]{ Manifest.permission.CAMERA }, FACE_VIEW_REQUEST_CODE);
        } else {
            startActivity(new Intent(this, FaceViewActivity.class));
        }
    }

    /**
     * Starts the ARViewActivity, a callback method which is called upon a tap on the START ACTIVITY button.
     *
     * @param view View that is tapped
     */
    public void onBtnARViewDemoClicked(View view) {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA)
            != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(
                this, new String[]{ Manifest.permission.CAMERA }, AR_VIEW_REQUEST_CODE);
        } else {
            startActivity(new Intent(this, ARViewActivity.class));
        }
    }
}
