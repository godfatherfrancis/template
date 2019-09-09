package info.highresfelix.contactsandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

/**
 * created by @highresfelix on 2019-09-08
 */

public class MainActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemLongClickListener, AdapterView.OnItemClickListener {
    ListView list;
    EditText name;
    EditText number;
    Button addButton;

    ArrayAdapter<String> contacts;

    public static final String EXTRA_MESSAGE = "info.highresfelix.contactsandroid.CONTACT";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list = (ListView) findViewById(R.id.listView);
        name = (EditText) findViewById(R.id.name);
        number = (EditText) findViewById(R.id.number);
        addButton = (Button) findViewById(R.id.button);

        contacts = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1);
        list.setAdapter(contacts);

        addButton.setOnClickListener(this);
        list.setOnItemClickListener(this);
        list.setOnItemLongClickListener(this);
    }

    @Override
    public void onClick(View view) {
        String inputName = name.getText().toString();
        String inputNumber = number.getText().toString();
        String contact = inputName + " (" + inputNumber + ")";
        contacts.add(contact);
        name.setText("");
        number.setText("");
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
        String contact = contacts.getItem(position);

        // TODO use fragment > activity?
        Intent intent = new Intent(this, ContactActivity.class);
        intent.putExtra(EXTRA_MESSAGE, contact);
        startActivity(intent);
    }

    @Override
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int position, long id) {
        String contact = contacts.getItem(position);
        contacts.remove(contact);
        return true;
    }
}
