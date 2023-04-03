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

    PessoaController controller;
    Pessoa pessoa;
    Pessoa outraPessoa;
    EditText editTextPrimeiroNome;
    EditText editTextsobreNome;
    EditText editTextnomeDocurso;
    EditText editTextTelefoneContato;
    Button buttonLimpar;
    Button buttonSalvar;
    Button buttonFinalizar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        controller = new PessoaController(MainActivity.this);
        controller.toString();

        pessoa = new Pessoa();
        controller.buscar(pessoa);


        editTextPrimeiroNome = findViewById(R.id.editTextPrimeiroNome);
        editTextsobreNome = findViewById(R.id.editTextsobreNome);
        editTextnomeDocurso = findViewById(R.id.editTextnomeDocurso);
        editTextTelefoneContato = findViewById(R.id.editTextTelefoneContato);

        editTextPrimeiroNome.setText(pessoa.getPrimeiroNome());
        editTextsobreNome.setText(pessoa.getSobreNome());
        editTextnomeDocurso.setText(pessoa.getCursoDesejado());
        editTextTelefoneContato.setText(pessoa.getTelefoneContato());

        buttonSalvar = findViewById(R.id.buttonSalvar);
        buttonLimpar = findViewById(R.id.buttonLimpar);
        buttonFinalizar = findViewById(R.id.buttonFinalizar);

        buttonLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editTextPrimeiroNome.setText("");
                editTextsobreNome.setText("");
                editTextnomeDocurso.setText("");
                editTextTelefoneContato.setText("");

                controller.limpar();
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

                pessoa.setPrimeiroNome(editTextPrimeiroNome.getText().toString());
                pessoa.setSobreNome(editTextsobreNome.getText().toString());
                pessoa.setCursoDesejado(editTextnomeDocurso.getText().toString());
                pessoa.setTelefoneContato(editTextTelefoneContato.getText().toString());

                Toast.makeText(MainActivity.this, "Salvo com Sucesso", Toast.LENGTH_LONG).show();


                controller.salvar(pessoa);
            }
        });

        Log.i("PooAndroid", pessoa.toString());
    }
}