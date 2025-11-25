package com.example.testarapi;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    EditText editNome, editTelefone, editEmail, editId;
    Button btnNovo, btnInserir, btnAtualizar, btnDeletar, btnBuscar;
    ListView listView;

    String IP = "172.16.8.49";  // seu IP do XAMPP

    String URL_READ    = "http://" + IP + "/cadastro43TI/view/read.php";
    String URL_CREATE  = "http://" + IP + "/cadastro43TI/create.php";
    String URL_UPDATE  = "http://" + IP + "/cadastro43TI/update.php";
    String URL_DELETE  = "http://" + IP + "/cadastro43TI/delete.php";

    ArrayAdapter<String> adapter;
    String[] dados;
    JSONArray dadosJson;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editNome     = findViewById(R.id.editNome);
        editTelefone = findViewById(R.id.editTelefone);
        editEmail    = findViewById(R.id.editEmail);
        editId       = findViewById(R.id.editId);

        btnNovo      = findViewById(R.id.btnNovo);
        btnInserir   = findViewById(R.id.btnInserir);
        btnAtualizar = findViewById(R.id.btnAtualizar);
        btnDeletar   = findViewById(R.id.btnDeletar);
        btnBuscar    = findViewById(R.id.btnBuscar);

        listView = findViewById(R.id.listViewContatos);

        btnNovo.setOnClickListener(v -> limparCampos());
        btnInserir.setOnClickListener(v -> inserir());
        btnAtualizar.setOnClickListener(v -> atualizar());
        btnDeletar.setOnClickListener(v -> deletar());
        btnBuscar.setOnClickListener(v -> buscar());

        // CLIQUE NA LISTA → PREENCHER CAMPOS
        listView.setOnItemClickListener((parent, view, position, id) -> {
            try {
                JSONObject obj = dadosJson.getJSONObject(position);

                editId.setText(obj.getString("id"));
                editNome.setText(obj.getString("nome"));
                editTelefone.setText(obj.getString("telefone"));
                editEmail.setText(obj.getString("email"));

            } catch (Exception e) {
                Toast.makeText(this, "Erro ao selecionar item", Toast.LENGTH_SHORT).show();
            }
        });
    }

    void limparCampos() {
        editId.setText("");
        editNome.setText("");
        editTelefone.setText("");
        editEmail.setText("");
    }

    void inserir() {
        String url = URL_CREATE + "?nome=" + editNome.getText() +
                "&telefone=" + editTelefone.getText() +
                "&email=" + editEmail.getText();

        executar(url, "Inserido com sucesso!");
    }

    void atualizar() {
        String url = URL_UPDATE + "?id=" + editId.getText() +
                "&nome=" + editNome.getText() +
                "&telefone=" + editTelefone.getText() +
                "&email=" + editEmail.getText();

        executar(url, "Atualizado com sucesso!");
    }

    void deletar() {
        String url = URL_DELETE + "?id=" + editId.getText();
        executar(url, "Deletado com sucesso!");
    }

    void executar(String url, String mensagem) {
        RequestQueue queue = Volley.newRequestQueue(this);

        StringRequest req = new StringRequest(Request.Method.GET, url,
                response -> {
                    Toast.makeText(this, mensagem, Toast.LENGTH_SHORT).show();
                    buscar();
                },
                error -> Toast.makeText(this, "Erro: " + error, Toast.LENGTH_LONG).show()
        );

        queue.add(req);
    }

    // BUSCAR → ListView Simples
    void buscar() {
        RequestQueue queue = Volley.newRequestQueue(this);

        StringRequest req = new StringRequest(Request.Method.GET, URL_READ,
                response -> {

                    try {
                        dadosJson = new JSONArray(response);
                        dados = new String[dadosJson.length()];

                        for (int i = 0; i < dadosJson.length(); i++) {
                            JSONObject obj = dadosJson.getJSONObject(i);

                            dados[i] =
                                    "Nome: " + obj.getString("nome") + "\n" +
                                            "Telefone: " + obj.getString("telefone") + "\n" +
                                            "Email: " + obj.getString("email");
                        }

                        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, dados);
                        listView.setAdapter(adapter);

                    } catch (Exception e) {
                        Toast.makeText(this, "Erro JSON: " + e, Toast.LENGTH_LONG).show();
                    }

                },
                error -> Toast.makeText(this, "Erro buscar: " + error, Toast.LENGTH_LONG).show()
        );

        queue.add(req);
    }
}
