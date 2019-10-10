package db;


import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import entity.Message;

@Database(entities = {Message.class}, version = 1, exportSchema = false)
public abstract class MessageDB extends RoomDatabase {

    private  static  MessageDB INSTANCE = null;

    public abstract MessageDao getMessageDao();

    public static MessageDB getInstance(Context context){

        if (INSTANCE == null){
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(), MessageDB.class, "coti-conteudo.db").build();
        }

        return INSTANCE;
    }
}
