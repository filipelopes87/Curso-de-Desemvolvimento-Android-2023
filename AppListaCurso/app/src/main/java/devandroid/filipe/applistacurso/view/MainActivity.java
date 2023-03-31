package devandroid.filipe.applistacurso.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import devandroid.filipe.applistacurso.R;
import devandroid.filipe.applistacurso.controller.PessoaController;
import devandroid.filipe.applistacurso.model.Pessoa;

public class MainActivity extends AppCompatActivity {
    SharedPreferences preferences;
    public static final String NOME_PREFERENCES = "pref_listaVip";
    PessoaController controller;
    Pessoa pessoa;
    EditText editPrimeiroNome;
    EditText editsobreNome;
    EditText editnomeDocurso;
    EditText editTelefoneContato;
    Button buttonLimpar;
    Button buttonSalvar;
    Button buttonFinalizar;

    //Comentário

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        preferences = getSharedPreferences(NOME_PREFERENCES, 0);
        SharedPreferences.Editor listaVIp = preferences.edit();

        controller = new PessoaController();
        controller.toString();

        pessoa = new Pessoa();
        pessoa.setPrimeiroNome(preferences.getString("primeiroNome","NA"));
        pessoa.setPrimeiroNome(preferences.getString("sobreNome","NA"));
        pessoa.setPrimeiroNome(preferences.getString("cursoDesejado","NA"));
        pessoa.setPrimeiroNome(preferences.getString("telefoneContato","NA"));


        editPrimeiroNome = findViewById(R.id.editPrimeiroNome);
        editsobreNome = findViewById(R.id.editsobreNome);
        editnomeDocurso = findViewById(R.id.editnomeDocurso);
        editTelefoneContato = findViewById(R.id.editTelefoneContato);

        editPrimeiroNome.setText(pessoa.getPrimeiroNome());
        editsobreNome.setText(pessoa.getSobreNome());
        editnomeDocurso.setText(pessoa.getCursoDesejado());
        editTelefoneContato.setText(pessoa.getTelefoneContato());

        buttonSalvar = findViewById(R.id.buttonSalvar);
        buttonLimpar = findViewById(R.id.buttonLimpar);
        buttonFinalizar = findViewById(R.id.buttonFinalizar);

        editPrimeiroNome.setText(pessoa.getPrimeiroNome());
        editsobreNome.setText(pessoa.getSobreNome());
        editnomeDocurso.setText(pessoa.getCursoDesejado());
        editTelefoneContato.setText(pessoa.getTelefoneContato());


        buttonLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editPrimeiroNome.setText("");
                editsobreNome.setText("");
                editnomeDocurso.setText("");
                editTelefoneContato.setText("");
            }
        });

        buttonFinalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Volte Sempre", Toast.LENGTH_LONG).show();
                finish();
            }
        });

        buttonSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                pessoa.setPrimeiroNome(editPrimeiroNome.getText().toString());
                pessoa.setSobreNome(editsobreNome.getText().toString());
                pessoa.setCursoDesejado(editnomeDocurso.getText().toString());
                pessoa.setTelefoneContato(editTelefoneContato.getText().toString());

                Toast.makeText(MainActivity.this, "Salvo com Sucesso", Toast.LENGTH_LONG).show();

                listaVIp.putString("primeiroNome", pessoa.getPrimeiroNome());
                listaVIp.putString("sobreNome", pessoa.getSobreNome());
                listaVIp.putString("cursoDesejado", pessoa.getCursoDesejado());
                listaVIp.putString("telefoneContato", pessoa.getTelefoneContato());
                listaVIp.apply();

                controller.salvar(pessoa);
            }
        });

        Log.i("PooAndroid", pessoa.toString());
    }
}