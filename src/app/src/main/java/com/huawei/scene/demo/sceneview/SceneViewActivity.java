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

package com.huawei.scene.demo.sceneview;

import android.app.Activity;
import android.os.Bundle;
import com.huawei.scene.demo.R;

/**
 * SceneViewActivity
 *
 * @author HUAWEI
 * @since 2020-5-13
 */
public class SceneViewActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // A SampleView is created using XML tags in the res/layout/activity_sample.xml file.
        // You can also create a SampleView in new mode as follows: setContentView(new SampleView(this));
        setContentView(R.layout.activity_sample);
    }
}
