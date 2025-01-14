package com.tillekesoft.accessibilityservices;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.content.Context;
import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.objects.collections.List;

@BA.ShortName("OtherJavaFunctions")
/* loaded from: classes.dex */
public class OtherFunctionshere {
    public String numbeformatternew(int i) {
        try {
            return String.format("%05d", Integer.valueOf(i));
        } catch (Exception e) {
            BA.Log(e.getMessage().toString());
            return "";
        }
    }

    public List getAccountsInDev(BA BA) {
        Context context = BA.context;
        List list = new List();
        list.Initialize();
        for (Account account : ((AccountManager) context.getSystemService("account")).getAccounts()) {
            BA.Log("" + account);
            if (account.type.equalsIgnoreCase("com.google")) {
                list.Add(account.name);
            }
        }
        return list;
    }
}
