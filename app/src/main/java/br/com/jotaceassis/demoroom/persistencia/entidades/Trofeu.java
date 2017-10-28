package br.com.jotaceassis.demoroom.persistencia.entidades;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;

@Entity (tableName = "trofeu",
        foreignKeys = @ForeignKey(entity = Usuario.class,
        parentColumns = "id",
        childColumns = "user_id"))
public class Trofeu {

    @PrimaryKey (autoGenerate = true)
    private int id;
    private String descricao;

    @ColumnInfo(name = "user_id")
    private int userId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

}
