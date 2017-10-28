package br.com.jotaceassis.demoroom.persistencia.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.List;

import br.com.jotaceassis.demoroom.persistencia.entidades.Usuario;

@Dao
public interface UsuarioDAO {

    @Query("SELECT * FROM Usuario")
    List<Usuario> buscarTodos();

    @Query("SELECT * FROM Usuario WHERE id = :userId")
    List<Usuario> buscarPor(int userId);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void adicionarUsuario(Usuario... usuario);

    @Delete
    public void deleteUsers(Usuario... usuario);
}
