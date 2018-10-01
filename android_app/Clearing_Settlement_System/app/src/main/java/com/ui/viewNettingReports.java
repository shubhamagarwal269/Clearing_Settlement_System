package com.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;



import com.dao.GenerateMemberReport;

import com.dao_impl.GenerateMemberReportImpl;
import com.example.ubuntu.clearing_settlement_system.R;

import com.pojo.MemberReport;


import java.util.List;

public class viewNettingReports extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_netting_reports);
        init();
    }

    public void init(){

        TableLayout tableLayout = (TableLayout) findViewById(R.id.displayLinear);

        GenerateMemberReport dao = new GenerateMemberReportImpl();
        List<MemberReport> list = dao.viewAllMembersReports();

        for (int i = 0; i <list.size(); i++) {
            TableRow row= new TableRow(this);
            TableRow.LayoutParams layoutParams = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT);
            row.setLayoutParams(layoutParams);
            String name = list.get(i).getMemberName();
            Double obli0 = list.get(i).getObligation().get(0);
            Double obli1 = list.get(i).getObligation().get(1);
            Double obli2 = list.get(i).getObligation().get(2);
            Double obli3 = list.get(i).getObligation().get(3);
            Double obli4 = list.get(i).getObligation().get(4);
            Double obli5 = list.get(i).getObligation().get(5);

            TextView nametv = new TextView(this);
            TextView obli0tv = new TextView(this);
            TextView obli1tv = new TextView(this);
            TextView obli2tv = new TextView(this);
            TextView obli3tv = new TextView(this);
            TextView obli4tv = new TextView(this);
            TextView obli5tv = new TextView(this);
            if(i%2==0){
                nametv.setBackgroundResource(R.color.blue);
                obli0tv.setBackgroundResource(R.color.blue);
                obli1tv.setBackgroundResource(R.color.blue);
                obli2tv.setBackgroundResource(R.color.blue);
                obli3tv.setBackgroundResource(R.color.blue);
                obli4tv.setBackgroundResource(R.color.blue);
                obli5tv.setBackgroundResource(R.color.blue);
            }
            else{
                nametv.setBackgroundResource(R.color.blue_dark);
                obli0tv.setBackgroundResource(R.color.blue_dark);
                obli1tv.setBackgroundResource(R.color.blue_dark);
                obli2tv.setBackgroundResource(R.color.blue_dark);
                obli3tv.setBackgroundResource(R.color.blue_dark);
                obli4tv.setBackgroundResource(R.color.blue_dark);
                obli5tv.setBackgroundResource(R.color.blue_dark);
            }
            nametv.setPadding(10,0,10,0);
            obli0tv.setPadding(10,0,10,0);
            obli1tv.setPadding(10,0,10,0);
            obli2tv.setPadding(10,0,10,0);
            obli3tv.setPadding(10,0,10,0);
            obli4tv.setPadding(10,0,10,0);
            obli5tv.setPadding(10,0,10,0);

            nametv.setText(name);
            obli0tv.setText(Double.toString(obli0));
            obli1tv.setText(Double.toString(obli1));
            obli2tv.setText(Double.toString(obli2));
            obli3tv.setText(Double.toString(obli3));
            obli4tv.setText(Double.toString(obli4));
            obli5tv.setText(Double.toString(obli5));

            if(obli0<0){
                obli0tv.setTextColor(getColor(R.color.red));
            }
            else{
                obli0tv.setTextColor(getColor(R.color.green));
            }

            if(obli1<0){
                obli0tv.setTextColor(getColor(R.color.red));
            }
            else{
                obli0tv.setTextColor(getColor(R.color.green));
            }

            if(obli2<0){
                obli0tv.setTextColor(getColor(R.color.red));
            }
            else{
                obli0tv.setTextColor(getColor(R.color.green));
            }

            if(obli3<0){
                obli0tv.setTextColor(getColor(R.color.red));
            }
            else{
                obli0tv.setTextColor(getColor(R.color.green));
            }

            if(obli4<0){
                obli0tv.setTextColor(getColor(R.color.red));
            }
            else{
                obli0tv.setTextColor(getColor(R.color.green));
            }


            if(obli5<0){
                obli0tv.setTextColor(getColor(R.color.red));
            }
            else{
                obli0tv.setTextColor(getColor(R.color.green));
            }




            row.addView(nametv);
            row.addView(obli0tv);
            row.addView(obli1tv);
            row.addView(obli2tv);
            row.addView(obli3tv);
            row.addView(obli4tv);
            row.addView(obli5tv);
            tableLayout.addView(row);
        }
    }
}
