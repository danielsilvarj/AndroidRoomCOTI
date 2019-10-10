package com.example.myroom;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import db.MessageDB;
import entity.Message;

public class MainActivity extends AppCompatActivity {


    public MessageDB dao;
    EditText txtTitulo;
    EditText txtMessage;
    EditText txtId;
    Message message;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dao = MessageDB.getInstance(getApplicationContext());
        txtTitulo = findViewById(R.id.txtTitulo);
        txtMessage = findViewById(R.id.txtMessage);
        txtId = findViewById(R.id.txtId);

        message = new Message((long) 01,"", "");


    }

    public void gravar(View v){
        message = new Message(null,txtTitulo.getText().toString(), txtMessage.getText().toString());
        dao.getMessageDao().insert(this.message);
        //Toast.makeText(getApplicationContext(),"Dados Gravados", Toast.LENGTH_LONG).show();

        new InnerGravar(getApplicationContext(),message).execute();



    }

    public void listar(View v){


    }

    public void buscar(View v){


    }

    public class InnerGravar extends AsyncTask<String,String,String>{

        private Context context;
        private Message message;

        public InnerGravar(Context context, Message m){
            this.context = context;
            this.message = m;
        }

        @Override
        protected String doInBackground(String... strings){

            try
            {
                dao = MessageDB.getInstance(context);
                dao.getMessageDao().insert(this.message);

                Toast.makeText(getApplicationContext(),"Dados Gravados", Toast.LENGTH_LONG).show();

                return this.message.toString();
            }
            catch (Exception ex){
                return "Não Gravado : " + ex.getMessage();
            }
        }
    }
}
