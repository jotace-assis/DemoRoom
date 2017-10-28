package br.com.jotaceassis.demoroom;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutCompat;
import android.widget.TextView;

import com.facebook.stetho.Stetho;

import java.util.List;

import br.com.jotaceassis.demoroom.persistencia.AppDatabase;
import br.com.jotaceassis.demoroom.persistencia.entidades.Usuario;

public class MainActivity extends AppCompatActivity {

    private AppDatabase db;
    private TextView tvResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Stetho.initializeWithDefaults(this);

        tvResultado = (TextView) findViewById(R.id.tvResultado);

        StringBuilder sb = new StringBuilder();

        // instancia banco de dados
        db = AppDatabase.getDataBase(this);

        List<Usuario> usuarios = db.usuarioDAO().buscarTodos();
        if (usuarios == null || usuarios.size() == 0) {
            Usuario usuario = new Usuario();
            usuario.setLevel(1);
            usuario.setNome("Joao Carlos");
            usuario.setPontos(1000);

            db.usuarioDAO().adicionarUsuario(usuario);

            sb.append(usuario.getNome())
                    .append(" Pontos: ")
                    .append(usuario.getPontos());

        }
        else {
            for (Usuario usuario : usuarios) {
                sb.append(usuario.getNome())
                        .append(" Pontos: ")
                        .append(usuario.getPontos())
                        .append(System.getProperty("line.separator"));
            }
        }
        tvResultado.setText(sb.toString());

    }
}
