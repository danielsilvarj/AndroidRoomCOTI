package db;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import entity.Message;

@Dao
public interface MessageDao {

    @Insert
    void insert(Message message);

    @Query("select * from messages order by id")
    LiveData<List<Message>> listar();

    @Query("select * from messages where id = :param1 order by id")
    LiveData<Message> listarUm (int param1);

    @Update
    void updateMessage (Message message);

    @Delete
    void deleteMessage(Message message);
}
