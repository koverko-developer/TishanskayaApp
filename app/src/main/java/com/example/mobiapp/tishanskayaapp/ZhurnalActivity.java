package com.example.mobiapp.tishanskayaapp;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.mobiapp.tishanskayaapp.adapter.NoteAdapter;
import com.example.mobiapp.tishanskayaapp.classes.Note;
import com.example.mobiapp.tishanskayaapp.db.DBHelper;

import java.util.ArrayList;
import java.util.List;

public class ZhurnalActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    private RecyclerView.LayoutManager mLayoutManager;
    DBHelper dbHelper;
    SQLiteDatabase database;
    Dialog dialogEdit = null;

    int DIALOG_DATE = 1;
    int myYear = 2017;
    int myMonth = 02;
    int myDay = 03;
    int DIALOG_TIME = 2;
    int myHour = 14;
    int myMinute = 35;
    NoteAdapter adapter;
    List<Note> list = new ArrayList<>();

    TextView tvDate, tvTime, tv;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zhurnal);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialogAddNote();
            }
        });

        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        recyclerView = (RecyclerView) findViewById(R.id.zhurnal_recycler);
        recyclerView.setHasFixedSize(true);

        tv = (TextView) findViewById(R.id.zhurnal_tv);

        // используем linear layout manager
        mLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLayoutManager);

        dbHelper = new DBHelper(this);
        database = dbHelper.getWritableDatabase();
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(simpleItemTouchCallback);
        itemTouchHelper.attachToRecyclerView(recyclerView);
        //insertInToDB();
        //list = readDB();
        //adapter = new NoteAdapter(this, list);
        //recyclerView.setAdapter(adapter);
    }

    public List<Note> readDB(){

        List<Note> organizationList = new ArrayList<>();

        try {
            Cursor c = database.query(DBHelper.TABLE_COMPANY, null, null, null, null, null, null);
            c.moveToFirst();
            while (!c.isAfterLast()) {
                int _id = c.getColumnIndex("_id");
                int _date = c.getColumnIndex("_date");
                int _time = c.getColumnIndex("_time");
                int _text = c.getColumnIndex("_text");

                Note object = new Note( c.getInt(_id),
                                        c.getString(_date),
                                        c.getString(_time),
                                        c.getString(_text));

                organizationList.add(object);
                String s = "";
                c.moveToNext();
            }
            c.close();

        }catch (Exception e){
            e.printStackTrace();
        }
        //dbHelper.close();

        return organizationList;
    }

    public void insertInToDB(){
        try {
            ContentValues contentValues = new ContentValues();

            contentValues.put(DBHelper.KEY_DATE, tvDate.getText().toString());
            contentValues.put(DBHelper.KEY_TIME, tvTime.getText().toString());
            contentValues.put(DBHelper.KEY_TEXT, editText.getText().toString());

            database.insert(DBHelper.TABLE_COMPANY, null, contentValues);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public void showDialogAddNote(){

        dialogEdit = new Dialog(this);
        //dialogEdit.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.MATCH_PARENT);
        dialogEdit.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialogEdit.setContentView(R.layout.alert_add_note);


        tvDate = (TextView) dialogEdit.findViewById(R.id.alert_add_note_date);
        tvTime = (TextView) dialogEdit.findViewById(R.id.alert_add_note_time);
        editText = (EditText) dialogEdit.findViewById(R.id.alert_add_note_edit_text);
        Button btn = (Button) dialogEdit.findViewById(R.id.alert_add_note_btn_add);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(tvDate.getText().length()>4 && tvTime.getText().length()>3 &&
                        editText.getText().length()>0) {
                    insertInToDB();
                    dialogEdit.dismiss();
                    //recyclerView.setAdapter(new NoteAdapter(ZhurnalActivity.this, readDB()));
                    setRecycler();
                    Toast.makeText(ZhurnalActivity.this, "Запись добавлена.", Toast.LENGTH_SHORT).show();
                }
                else Toast.makeText(ZhurnalActivity.this, "Заполните все поля", Toast.LENGTH_SHORT).show();
            }
        });

        final ImageView imgDate = (ImageView) dialogEdit.findViewById(R.id.alet_add_note_select_button);
        final ImageView imgTime = (ImageView) dialogEdit.findViewById(R.id.alert_add_note_time_img);
        imgDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialog(DIALOG_DATE);
            }
        });

        imgTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialog(DIALOG_TIME);
            }
        });

        dialogEdit.show();
    }

    protected Dialog onCreateDialog(int id) {
        if (id == DIALOG_DATE) {
            DatePickerDialog tpd = new DatePickerDialog(this, myCallBack, myYear, myMonth, myDay);
            return tpd;
        }else if(id==DIALOG_TIME) {
            TimePickerDialog tpd = new TimePickerDialog(this, myCallBack1, myHour, myMinute, true);
            return tpd;
        }
        return super.onCreateDialog(id);
    }

    DatePickerDialog.OnDateSetListener myCallBack = new DatePickerDialog.OnDateSetListener() {

        public void onDateSet(DatePicker view, int year, int monthOfYear,
                              int dayOfMonth) {
            myYear = year;
            String month = monthOfYear<10 ? String.valueOf("0"+ (monthOfYear+1)) : String.valueOf(monthOfYear+1);

            myDay = dayOfMonth;

            tvDate.setText(myDay + "." + month + "." + myYear);
        }
    };


    TimePickerDialog.OnTimeSetListener myCallBack1 = new TimePickerDialog.OnTimeSetListener() {
        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
            myHour = hourOfDay;
            myMinute = minute;
            tvTime.setText(myHour + ":" + myMinute);
        }
    };

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                // do what you want to be done on home button click event
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    ItemTouchHelper.SimpleCallback simpleItemTouchCallback = new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {

        @Override
        public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
            return false;
        }

        @Override
        public void onSwiped(RecyclerView.ViewHolder viewHolder, int swipeDir) {
            //Remove swiped item from list and notify the RecyclerView
            delete(viewHolder.getLayoutPosition());
            //list.remove(viewHolder.getLayoutPosition());
            //adapter.notifyItemRemoved(viewHolder.getLayoutPosition());
            setRecycler();
        }
    };

    private void delete(int layoutPosition) {

        int id = list.get(layoutPosition).getId();
        try {
            int delCount = database.delete("list", "_id = " + id, null);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void onPostResume() {
        setRecycler();
        super.onPostResume();
    }

    private void setRecycler() {
        if(list!=null) list.clear();
        list = readDB();
        if(list.size()==0) tv.setVisibility(View.VISIBLE);
        else tv.setVisibility(View.GONE);
        adapter = new NoteAdapter(this, list);
        recyclerView.setAdapter(adapter);
    }
}
