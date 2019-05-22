package app.m.listas;

import android.app.Dialog;
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
    ArrayAdapter<String> arrayAdapter;
    String countryList[] = {"India", "China", "Australia", "Portugle", "America", "NewZeland"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button) findViewById(R.id.button);
        editText = (EditText) findViewById(R.id.editText);
        text = (TextView) findViewById(R.id.textView);
        simpleList = findViewById(R.id.simpleListView);
        lista = new ArrayList<String>(Arrays.asList(countryList));
        arrayAdapter = new ArrayAdapter<String>(MainActivity.this, R.layout.activity_listview, R.id.textView, lista);

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
        simpleList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view,final int i, long l) {
                Toast mensaje = Toast.makeText(getApplicationContext(), "posicion "+i, Toast.LENGTH_SHORT);
                mensaje.show();

                final Dialog dialog=new Dialog(MainActivity.this);
                dialog.setTitle("Modificar");
                dialog.setContentView(R.layout.activity_opcionesdelista);
                final EditText editText=(EditText)dialog.findViewById(R.id.txtinput);
                editText.setText(lista.get(i));
                Button Editar=(Button)dialog.findViewById(R.id.btdone);
                Button Eliminar = (Button) dialog.findViewById(R.id.btnEliminar);
                Editar.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        lista.set(i,editText.getText().toString());
                        arrayAdapter.notifyDataSetChanged();
                        dialog.dismiss();
                    }
                });
                Eliminar.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        lista.remove(editText.getText().toString());
                        arrayAdapter.notifyDataSetChanged();
                        dialog.dismiss();
                    }
                });
                simpleList.setAdapter(arrayAdapter);
                arrayAdapter.notifyDataSetChanged();
                dialog.show();
            }
        });
    }
}
