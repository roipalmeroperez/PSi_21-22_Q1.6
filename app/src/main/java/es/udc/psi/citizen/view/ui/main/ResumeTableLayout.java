package es.udc.psi.citizen.view.ui.main;

import android.content.Context;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class ResumeTableLayout extends TableLayout {
    public ResumeTableLayout(Context context, String data) {
        super(context);
        //String[] rows = data.split(";");

        TableLayout.LayoutParams tableParams = new TableLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
        TableRow.LayoutParams rowParams = new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.WRAP_CONTENT);

        setLayoutParams(tableParams);

        TableRow tableRow = new TableRow(context);
        tableRow.setLayoutParams(rowParams);

        TextView textView = new TextView(context);
        textView.setText(data);

        tableRow.addView(textView);
        addView(tableRow);
    }
}
