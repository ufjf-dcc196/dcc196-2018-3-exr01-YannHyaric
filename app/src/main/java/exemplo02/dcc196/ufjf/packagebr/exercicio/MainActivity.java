package exemplo02.dcc196.ufjf.packagebr.exercicio;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.ArrayMap;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {
    private Button btnAluno,btnServ,btnExt;
    private TextView numAlunos,numServ,numExt;
    public static int REQUEST=0;
    private ArrayMap<String,String> alunos,servidores,externos;
    public static final String NOME="nome",INFO="info";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnAluno=findViewById(R.id.btn_Aluno);
        btnServ=findViewById(R.id.btn_Servidor);
        btnExt=findViewById(R.id.btn_Externo);
        numAlunos=findViewById(R.id.numAlunos);
        numServ=findViewById(R.id.numServ);
        numExt=findViewById(R.id.numExt);

        btnAluno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent aluno=new Intent(MainActivity.this,Aluno.class);
                startActivityForResult(aluno,MainActivity.REQUEST);
                }
        });
        btnServ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent servidor=new Intent(MainActivity.this,Servidor.class);
                startActivityForResult(servidor,MainActivity.REQUEST);
                numServ.setText("Servidores: "+Integer.toString(servidores.size()));
            }
        });
        btnExt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent externo=new Intent(MainActivity.this,Externo.class);
                startActivityForResult(externo,MainActivity.REQUEST);
                numExt.setText("Externos"+Integer.toString(externos.size()));
            }
        });

    }
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Bundle resultado=data.getExtras();
        switch (REQUEST){
            case 1:
                alunos.put(resultado.getString(NOME),resultado.getString(INFO));
                numAlunos.setText("Alunos: "+Integer.toString(alunos.size()));
        }
    }
}
