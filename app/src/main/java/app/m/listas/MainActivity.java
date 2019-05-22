package app.m.listas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    ListView simpleList;
    private Button button,Editar,Borrar;
    private EditText editText;
    private TextView text;
    ArrayList<String> lista;
    String countryList[] = {"India", "China", "Australia", "Portugle", "America", "NewZeland"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button) findViewById(R.id.button);
        editText = (EditText) findViewById(R.id.editText);
        text = (TextView) findViewById(R.id.textView);
        Editar = (Button) findViewById(R.id.btn_Editar);
        Borrar = (Button) findViewById(R.id.btn_Borrar);
        simpleList = findViewById(R.id.simpleListView);
        lista = new ArrayList<String>(Arrays.asList(countryList));
        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(MainActivity.this, R.layout.activity_listview, R.id.textView, lista);

        simpleList.setAdapter(arrayAdapter);
        arrayAdapter.notifyDataSetChanged();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nuevo = String.valueOf(editText.getText());
                simpleList.setAdapter(arrayAdapter);
                lista.add(nuevo);
                arrayAdapter.notifyDataSetChanged();
            }
        });

    }
}
