package edu.facemash;

import android.content.Context;
import android.webkit.JavascriptInterface;
import android.widget.Toast;
import edu.facemash.SQLite.Database;

class WebAppInterface {
    private Context mContext;
    private Database db = null;

    /** Instantiate the interface and set the context */
    WebAppInterface(Context c) {
        this.db = new Database(c);
        mContext = c;
    }

    /** Show a toast from the web page */
    @JavascriptInterface
    public void showToast(String toast) {
        Toast.makeText(mContext, toast, Toast.LENGTH_SHORT).show();
    }

    /** get text */
    @JavascriptInterface
    public String getText (String type) {
        String text = "default";

        if (type.equals("1")) {
            text = "meow";
        }

        return text;
    }

    /** get workers from database */
    @JavascriptInterface
    public String getWorkers() {
        return this.db.getWorkers();
    }
}
