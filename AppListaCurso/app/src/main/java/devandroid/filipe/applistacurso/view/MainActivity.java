package devandroid.filipe.applistacurso.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import devandroid.filipe.applistacurso.R;
import devandroid.filipe.applistacurso.model.Pessoa;

public class MainActivity extends AppCompatActivity {

    Pessoa pessoa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pessoa = new Pessoa();
        pessoa.setPrimeiroNome("Filipe");
        pessoa.setSobreNome("Lopes");
        pessoa.setCursoDesejado("Android");
        pessoa.setTelefoneContato("16 9912885742");
    }
}