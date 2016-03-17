/*
 * Copyright (C) 2014 The CyanogenMod Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.cyanogenmod.hardware;

import org.cyanogenmod.hardware.util.FileUtils;
import android.os.SystemProperties;
import java.io.File;

import android.util.Log;

public class TapToWake {

    private static String CONTROL_PATH = "/sys/devices/pci0000:00/0000:00:00.3/i2c-0/0-0020/input/input1/dclick_mode";

    public static boolean isSupported() {
        File f = new File(CONTROL_PATH);

        if(f.exists()) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isEnabled() {
        if (Integer.parseInt(FileUtils.readOneLine(CONTROL_PATH)) == 1) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean setEnabled(boolean status) {
        if (status == true) {
            return FileUtils.writeLine(CONTROL_PATH, "1");
        } else {
            return FileUtils.writeLine(CONTROL_PATH, "0");
        }
    }
}
