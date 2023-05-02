package devandroid.yuri.applistacurso.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import devandroid.yuri.applistacurso.R;
import devandroid.yuri.applistacurso.controller.PessoaController;
import devandroid.yuri.applistacurso.model.Pessoa;

public class MainActivity extends AppCompatActivity {

    SharedPreferences preferences;
    public static final String NOME_PREFERENCES = "pref_listavip";

    Pessoa pessoa;
    Pessoa outraPessoa;

    EditText editPrimeiroNome;
    EditText editSobrenome;
    EditText editNomeCurso;
    EditText editTelefoneContato;

    Button btnLimpar;
    Button btnSalvar;
    Button btnFinalizar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        preferences = getSharedPreferences(NOME_PREFERENCES, 0);
        SharedPreferences.Editor listaVip = preferences.edit();

        PessoaController controller = new PessoaController();
        controller.toString();

        pessoa = new Pessoa();

        pessoa.setPrimeiroNome(preferences.getString("primeiroNome", ""));
        pessoa.setSobrenome(preferences.getString("sobrenome", ""));
        pessoa.setCursoDesejado(preferences.getString("nomeCurso", ""));
        pessoa.setTelefoneContato(preferences.getString("telefoneContato", ""));

        editPrimeiroNome = findViewById(R.id.editPrimeiroNome);
        editSobrenome = findViewById(R.id.editSobrenome);
        editNomeCurso = findViewById(R.id.editNomeCurso);
        editTelefoneContato = findViewById(R.id.editTelefoneContato);

        btnLimpar = findViewById(R.id.btnLimpar);
        btnSalvar = findViewById(R.id.btnSalvar);
        btnFinalizar = findViewById(R.id.btnFinalizar);

        editPrimeiroNome.setText(pessoa.getPrimeiroNome());
        editSobrenome.setText(pessoa.getSobrenome());
        editNomeCurso.setText(pessoa.getCursoDesejado());
        editTelefoneContato.setText(pessoa.getTelefoneContato());

        btnLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editPrimeiroNome.setText("");
                editSobrenome.setText("");
                editNomeCurso.setText("");
                editTelefoneContato.setText("");
            }
        });

        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (
                        editPrimeiroNome.getText().toString().length() != 0 |
                                editSobrenome.getText().toString().length() != 0 |
                                editNomeCurso.getText().toString().length() != 0 |
                                editTelefoneContato.getText().toString().length() != 0
                ) {
                    pessoa.setPrimeiroNome(editPrimeiroNome.getText().toString());
                    pessoa.setSobrenome(editSobrenome.getText().toString());
                    pessoa.setCursoDesejado(editNomeCurso.getText().toString());
                    pessoa.setTelefoneContato(editTelefoneContato.getText().toString());
                    Toast.makeText(MainActivity.this, "Salvo :" + pessoa.toString(), Toast.LENGTH_LONG).show();

                    listaVip.putString("primeiroNome", pessoa.getPrimeiroNome());
                    listaVip.putString("sobrenome", pessoa.getSobrenome());
                    listaVip.putString("nomeCurso", pessoa.getCursoDesejado());
                    listaVip.putString("telefoneContato", pessoa.getTelefoneContato());
                    listaVip.apply();

                    controller.salvar(pessoa);

                    return;

                }

                Toast.makeText(MainActivity.this, "Preencha os campos para salvar", Toast.LENGTH_LONG).show();

            }
        });
        btnFinalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Volte Sempre", Toast.LENGTH_LONG).show();
                finish();
            }
        });


        Log.i("POOAndroid", pessoa.toString());

    }

}