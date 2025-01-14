package com.tillekesoft.accessibilityservices;

import android.os.Environment;
import android.util.Log;
import anywheresoftware.b4a.BA;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Calendar;

/* loaded from: classes.dex */
public class Timber {
    private static final boolean PRINT_TO_FILE = false;
    private static final ThreadLocal<String> explicitTag = new ThreadLocal<>();
    public static final String f26D = "D";
    public static final String f27E = "E";
    public static final String f28I = "I";

    public static void m23d(String str, Object... objArr) {
        BA.Log(str + " " + objArr);
    }

    public static void m25i(String str, Object... objArr) {
        BA.Log(str + " " + objArr);
    }

    public static void m24e(Throwable th, String str, Object... objArr) {
        BA.Log(str + " " + objArr);
    }

    private static void printLog(String str, Throwable th, String str2, Object... objArr) {
        String tag;
        String str3;
        tag = getTag();
        String str4 = Calendar.getInstance().getTime().toString() + "    ";
        if (objArr == null || objArr.length <= 0) {
            str3 = str4 + str2;
        } else {
            str3 = str4 + formatMessage(str2, objArr);
        }
        if (th != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(str3);
            sb.append("AndroidBot/Crash detected -> ");
            sb.append(th.getMessage());
            sb.append(" | stackTrace -> ");
            sb.append(th.getStackTrace() != null ? Arrays.toString(th.getStackTrace()) : " empty stackTrace");
            str3 = sb.toString();
        }
        str.hashCode();
        str.hashCode();
        switch (str) {
            case "D":
            case "I":
                if (th != null) {
                    Log.d(tag, str3, th);
                    break;
                } else {
                    largeLog(tag, str3);
                    break;
                }
            case "E":
                if (th != null) {
                    Log.e(tag, str3, th);
                    break;
                } else {
                    Log.e(tag, str3);
                    break;
                }
        }
    }

    private static String getTag() {
        ThreadLocal<String> threadLocal = explicitTag;
        String str = threadLocal.get();
        if (str == null) {
            return "Timber";
        }
        threadLocal.remove();
        return str;
    }

    private static String formatMessage(String str, Object[] objArr) {
        StringBuilder sb = new StringBuilder(str);
        for (Object obj : objArr) {
            sb.append(" | ");
            sb.append(obj.toString());
        }
        return sb.toString();
    }

    public static void largeLog(String str, String str2) {
        if (str2.length() > 4000) {
            Log.d(str, str2.substring(0, 4000));
            largeLog(str, str2.substring(4000));
        } else {
            Log.d(str, str2);
        }
    }

    public static void writeToFile(String str) {
        File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS), "APP_LOGS.txt");
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file, true));
            bufferedWriter.append((CharSequence) str);
            bufferedWriter.newLine();
            bufferedWriter.close();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }
}
