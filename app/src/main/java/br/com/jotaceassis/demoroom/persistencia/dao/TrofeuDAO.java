package br.com.jotaceassis.demoroom.persistencia.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

import br.com.jotaceassis.demoroom.persistencia.entidades.Trofeu;
import br.com.jotaceassis.demoroom.persistencia.entidades.Usuario;

@Dao
public interface TrofeuDAO {

    @Query("SELECT * FROM trofeu WHERE id = :id")
    List<Trofeu> buscarTrofeuPorId(int id);

    @Query("SELECT * FROM trofeu WHERE user_id = :userId")
    List<Trofeu> buscarTrofeuPorUsuario(int userId);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void adicionarTrofeu(Trofeu trofeu);

    @Update
    void atualizaTrofeu(Trofeu trofeu);

    @Query("delete from trofeu where id = :id")
    void delete(long id);

}
