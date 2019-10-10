package entity;


import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Objects;

@Entity(tableName = "messages")
public class Message {


    @PrimaryKey(autoGenerate=true)
    public final Long id;
    public final String titulo;
    public final String message;

    public  Message(Long id, String titulo, String message){

        this.id = id;
        this.titulo = titulo;
        this.message = message;
    }


    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public  boolean equals(Object o){

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Message message = (Message) o;
        return Objects.equals(id,message.id) && message.equals(message.message);
    }


    @Override
    public int hashCode(){return Objects.hash(id,message);}

    @Override
    public String toString(){
        return "Message{" + "Id=" + ", Titulo='" + titulo + '\'' + ", Message='" + message + '\'' + '}';

    }

}
