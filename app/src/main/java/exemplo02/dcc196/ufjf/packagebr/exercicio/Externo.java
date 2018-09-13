package exemplo02.dcc196.ufjf.packagebr.exercicio;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Externo extends Activity {
    private EditText nome, email;
    private Button entrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_externo);

        nome = findViewById(R.id.edt_NomeExt);
        email = findViewById(R.id.edt_email);
        entrar = findViewById(R.id.btn_entrarExt);
        entrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (nome.getText().length() > 0 && email.getText().length() > 0) {
                    Intent result = new Intent();
                    result.putExtra(MainActivity.NOME, nome.getText().toString());
                    result.putExtra(MainActivity.INFO, email.getText().toString());
                    setResult(Activity.RESULT_OK, result);
                    finish();
                } else {
                    TextView erro = findViewById(R.id.error_Ext);
                    erro.setText("Os campos não podem ser vazios");
                }
            }
        });
    }
}
