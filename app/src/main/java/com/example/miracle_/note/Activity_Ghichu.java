package com.example.miracle_.note;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.miracle_.note.Model.Ghichu;
import com.example.miracle_.note.data.DBManager;

import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by MIRACLE- on 03/12/2017.
 */

public class Activity_Ghichu extends AppCompatActivity implements View.OnClickListener {

    private Button btnChonngay,btnChongio,btnLuu,btnThoat;
    private EditText edtNgay,edtGio,edtTieude,edtNoidung;
    int nam,thang,ngay,gio,phut;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ghichu);
        widget();
        final DBManager dbManager = new DBManager(this);
        btnLuu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Ghichu ghichu = taoGhichu();
                if(ghichu != null){
                    dbManager.addGhichu(ghichu);
                    Toast.makeText(Activity_Ghichu.this, "Tạo thành công", Toast.LENGTH_SHORT).show();
                }

            }
        });
        //Hiển thị ngày giờ hiện tại
        String currentDate = new SimpleDateFormat("dd/MM/yyyy").format(new Date());
        edtNgay.setText(currentDate.toString());
        String currentTime = new SimpleDateFormat("HH:mm").format(new Date());
        edtGio.setText(currentTime.toString());

        btnChongio.setOnClickListener(this);
        btnChonngay.setOnClickListener(this);



    }
    public void onClick(View v) {
        if(v==btnChonngay){
            final Calendar calendar = Calendar.getInstance();
            nam = calendar.get(Calendar.YEAR);
            thang = calendar.get(Calendar.MONTH);
            ngay = calendar.get(Calendar.DAY_OF_MONTH);

            DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int month, int day) {
                    edtNgay.setText(day + "/" + (month +1)  + "/" + year );
                }
            }
                    ,nam,thang,ngay);

            datePickerDialog.show();
        }

        if (v==btnChongio){
            final Calendar calendar = Calendar.getInstance();
            gio = calendar.get(Calendar.HOUR_OF_DAY);
            phut = calendar.get(Calendar.MINUTE);

            TimePickerDialog timePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
                @Override
                public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                    edtGio.setText(hourOfDay + ":" + minute);
                }
            }
                    ,gio,phut,false);
            timePickerDialog.show();
        }
    }
    public void widget(){

        btnChongio = (Button)findViewById(R.id.btn_Chongio);
        btnChonngay = (Button)findViewById(R.id.btn_Chonngay);
        btnLuu = (Button)findViewById(R.id.btn_Luu);
        btnThoat = (Button) findViewById(R.id.btn_Thoat);
        edtGio = (EditText)findViewById(R.id.edt_Gio);
        edtNgay = (EditText)findViewById(R.id.edt_Ngay);
        edtNoidung = (EditText)findViewById(R.id.edt_Noidung);
        edtTieude = (EditText)findViewById(R.id.edt_Tieude);

    }

    private Ghichu taoGhichu ()  {

        String tieude = edtTieude.getText().toString();
        String noidung = edtNoidung.getText().toString();
        String date = edtNgay.getText().toString();
        String time = edtGio.getText().toString();

        Ghichu ghichu = new Ghichu(tieude,noidung,date,time);

        return ghichu;
    }
}
