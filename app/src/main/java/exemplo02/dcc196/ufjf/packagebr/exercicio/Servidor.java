package exemplo02.dcc196.ufjf.packagebr.exercicio;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Servidor extends Activity {
    private EditText nome,siape;
    private Button entrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_servidor);
        nome=findViewById(R.id.edt_NomeServ);
        siape=findViewById(R.id.edt_Siape);
        entrar=findViewById(R.id.btn_entrarServ);
        entrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent result=new Intent();
                MainActivity.REQUEST=2;
                result.putExtra(MainActivity.NOME,nome.getText().toString());
                result.putExtra(MainActivity.INFO, siape.getText().toString());
                setResult(Activity.RESULT_OK,result);
                finish();
            }
        });
    }
}
