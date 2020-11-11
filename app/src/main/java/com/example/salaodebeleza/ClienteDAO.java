package com.example.salaodebeleza;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class ClienteDAO extends SQLiteOpenHelper {
    private final String TABELA_LOGIN = "Tab_LOGIN";
    private final String TABELA_CLIENTE = "Tab_CLIENTE";
    private final String TABELA_SERVICO = "Tab_Servico";
//    database constructor.
    public ClienteDAO(@Nullable Context context) {

        super(context, "DB_Salao_Beleza", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String comando = "CREATE TABLE " + TABELA_LOGIN + "(" +
                "ID_LOGIN INTEGER PRIMARY KEY," +
                "ID_CLIENTE INTEGER," +
                "USUARIO VARCHAR(25)," +
                "SENHA VARCHAR(8))";
        db.execSQL(comando);

        String comandoCliente = "CREATE TABLE " + TABELA_CLIENTE + "(" +
                "ID_CLIENTE INTEGER PRIMARY KEY," +
                "NOME VARCHAR(100)," +
                "EMAIL VARCHAR(50)," +
                "TELEFONE VARCHAR(15)," +
                "ENDERECO VARCHAR(50))";
        db.execSQL(comandoCliente);

        String comandoServico = "CREATE TABLE " + TABELA_SERVICO + "(" +
                "ID_SERVICO INTEGER PRIMARY KEY," +
                "NOME VARCHAR(100)," +
                "DESCRICAO VARCHAR(50)," +
                "TEMPO VARCHAR(15))";
        db.execSQL(comandoServico);

    }

    public Long inserir(ClienteDTO clienteDTO){
        ContentValues values = new ContentValues();

        values.put("NOME", clienteDTO.getNome());
        values.put("EMAIL", clienteDTO.getEmail());
        values.put("TELEFONE", clienteDTO.getTelefone());
        values.put("ENDERECO", clienteDTO.getEndereco());

        long nLinhas = getWritableDatabase().insert(TABELA_CLIENTE,  null, values);
        return nLinhas;
    }
    public ArrayList<ClienteDTO> consultarTodos(){
        String comando = "SELECT * FROM " + TABELA_CLIENTE;
        Cursor cursor = getReadableDatabase().rawQuery(comando, null);
        ArrayList<ClienteDTO> listaCliente = new ArrayList<>();

        while (cursor.moveToNext()){
            ClienteDTO clienteDTO = new ClienteDTO();
            clienteDTO.setId(cursor.getInt(0));
            clienteDTO.setNome(cursor.getString(1));
            clienteDTO.setEmail(cursor.getString(2));
            clienteDTO.setTelefone(cursor.getString(3));
            clienteDTO.setEndereco(cursor.getString(4));
            listaCliente.add(clienteDTO);
        }

        return listaCliente;
    }


    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }


}
