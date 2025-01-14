package ice.smsplus;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.util.Log;
import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.objects.collections.List;
import java.util.HashMap;

@BA.Version(1.0f)
@BA.Author("IceFairy333")
@BA.ShortName("SmsMessages")
/* loaded from: classes.dex */
public class SmsWrapper {
    public static final int TYPE_DRAFT = 3;
    public static final int TYPE_FAILED = 5;
    public static final int TYPE_INBOX = 1;
    public static final int TYPE_OUTBOX = 4;
    public static final int TYPE_QUEUED = 6;
    public static final int TYPE_SENT = 2;
    public static final int TYPE_UNKNOWN = 0;
    private static final String[] projection = {"_id", "thread_id", "address", "read", "type", "body", "person", "date"};

    public List GetByType(int i) {
        return get("type = ?", new String[]{String.valueOf(i)});
    }

    public List GetByThreadId(int i) {
        return get("thread_id = ?", new String[]{String.valueOf(i)});
    }

    public List GetByPersonId(int i) {
        return get("person = ?", new String[]{String.valueOf(i)});
    }

    public List GetUnreadMessages() {
        return get("read = 0", null);
    }

    public List GetAll() {
        return get(null, null);
    }

    public List GetAllSince(long j) {
        return get("date >= ?", new String[]{String.valueOf(j)});
    }

    public boolean deletesms(BA BA, String str) {
        ContentResolver contentResolver = BA.context.getContentResolver();
        Uri parse = Uri.parse("content://sms");
        Log.i("", parse.toString());
        try {
            contentResolver.delete(parse, "_id=" + str, null);
            contentResolver.notifyChange(parse, null);
            return true;
        } catch (Exception e) {
            Log.i("B4A", e.toString());
            return false;
        }
    }

    public List GetBetweenDates(long j, long j2) {
        return get("date >= ? AND date < ?", new String[]{String.valueOf(j), String.valueOf(j2)});
    }

    private List get(String str, String[] strArr) {
        Cursor query = BA.applicationContext.getContentResolver().query(Uri.parse("content://sms"), projection, str, strArr, "date DESC");
        HashMap hashMap = new HashMap();
        for (int i = 0; i < query.getColumnCount(); i++) {
            hashMap.put(query.getColumnName(i), Integer.valueOf(i));
        }
        List list = new List();
        list.Initialize();
        while (query.moveToNext()) {
            String string = query.getString(((Integer) hashMap.get("person")).intValue());
            list.Add(new Sms(query.getInt(((Integer) hashMap.get("_id")).intValue()), query.getInt(((Integer) hashMap.get("thread_id")).intValue()), string == null ? -1 : Integer.parseInt(string), query.getLong(((Integer) hashMap.get("date")).intValue()), query.getInt(((Integer) hashMap.get("read")).intValue()) > 0, query.getInt(((Integer) hashMap.get("type")).intValue()), query.getString(((Integer) hashMap.get("body")).intValue()), query.getString(((Integer) hashMap.get("address")).intValue())));
        }
        query.close();
        return list;
    }

    @BA.ShortName("Sms")
    public static class Sms {
        public String Address;
        public String Body;
        public long Date;

        /* renamed from: Id */
        public int f369Id;
        public int PersonId;
        public boolean Read;
        public int ThreadId;
        public int Type;

        public Sms(int i, int i2, int i3, long j, boolean z, int i4, String str, String str2) {
            this.f369Id = i;
            this.ThreadId = i2;
            this.PersonId = i3;
            this.Date = j;
            this.Read = z;
            this.Type = i4;
            this.Body = str;
            this.Address = str2;
        }

        public Sms() {
        }

        public String toString() {
            return "Id=" + this.f369Id + ", ThreadId=" + this.ThreadId + ", PersonId=" + this.PersonId + ", Date=" + this.Date + ", Read=" + this.Read + ", Type=" + this.Type + ", Body=" + this.Body + ", Address=" + this.Address;
        }
    }
}
