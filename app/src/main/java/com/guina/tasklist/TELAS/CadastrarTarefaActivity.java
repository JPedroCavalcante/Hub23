package com.guina.tasklist.TELAS;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

import com.guina.tasklist.AppDatabase;
import com.guina.tasklist.R;
import com.guina.tasklist.Tarefa;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class CadastrarTarefaActivity extends AppCompatActivity {

    private EditText edtDescricao;
    private TextView txtData;
    private TextView txtHora;
    private Button btnSalvar;
    private Calendar dataHora = Calendar.getInstance();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar_tarefa);

        edtDescricao = findViewById(R.id.edt_descricao);
        txtData = findViewById(R.id.txt_data);
        txtHora = findViewById(R.id.txt_hora);
        btnSalvar =  findViewById(R.id.btn_salvar);

        txtData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(CadastrarTarefaActivity.this, dateDialog, dataHora.get(Calendar.YEAR), dataHora.get(Calendar.MONTH), dataHora.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

        txtHora.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new TimePickerDialog(CadastrarTarefaActivity.this, timeDialog, dataHora.get(Calendar.HOUR), dataHora.get(Calendar.MINUTE), true).show();
            }
        });

        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(validarDescricao()){
                    Tarefa tarefa = new Tarefa();
                    tarefa.setDescricao(edtDescricao.getText().toString().trim());
                    tarefa.setDataHora(dataHora.getTimeInMillis());
                    AppDatabase.getAppDatabase(CadastrarTarefaActivity.this).tarefaDAO().insert(tarefa);
                    Intent intent = new Intent();
                    intent.putExtra("resposta", "ok");
                    setResult(RESULT_OK, intent);
                    finish();
                }
            }
        });

    }

    DatePickerDialog.OnDateSetListener dateDialog = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
            dataHora.set(Calendar.YEAR, year);
            dataHora.set(Calendar.MONTH, month);
            dataHora.set(Calendar.DAY_OF_MONTH, dayOfMonth);
            SimpleDateFormat formatacao = new SimpleDateFormat("dd/MM/yyyy", Locale.US);
            txtData.setText(formatacao.format(dataHora.getTime()));
        }
    };

    TimePickerDialog.OnTimeSetListener timeDialog = new TimePickerDialog.OnTimeSetListener() {
        @Override
        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
            dataHora.set(Calendar.HOUR, hourOfDay);
            dataHora.set(Calendar.MINUTE, minute);
            SimpleDateFormat formatacao = new SimpleDateFormat("HH:mm", Locale.US);
            txtHora.setText(formatacao.format(dataHora.getTime()));
        }
    };

    public boolean validarDescricao(){
        if (edtDescricao.getText().toString().trim().equals("")){
            edtDescricao.setError("A descrição da tarefa não pode estar em branco!");
            return false;
        }
        edtDescricao.setError(null);
        return true;
    }

}