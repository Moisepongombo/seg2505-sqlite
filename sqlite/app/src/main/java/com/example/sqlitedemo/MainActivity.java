package com.example.sqlitedemo;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TextView idView;
    private EditText productBox;
    private EditText skuBox;
    private TextView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        idView = findViewById(R.id.productID);
        productBox = findViewById(R.id.productName);
        skuBox = findViewById(R.id.productSku);
        listView = findViewById(R.id.productList);

        refreshList();
    }

    /** Bouton ADD : insère le produit saisi dans la base. */
    public void newProduct(View view) {
        String name = productBox.getText().toString().trim();
        String skuText = skuBox.getText().toString().trim();
        if (name.isEmpty() || skuText.isEmpty()) {
            Toast.makeText(this, "Saisir un nom et un SKU", Toast.LENGTH_SHORT).show();
            return;
        }

        MyDBHandler dbHandler = new MyDBHandler(this);
        Product product = new Product(name, Integer.parseInt(skuText));
        dbHandler.addProduct(product);

        productBox.setText("");
        skuBox.setText("");
        idView.setText("Not assigned");
        Toast.makeText(this, "Produit ajouté : " + name, Toast.LENGTH_SHORT).show();
        refreshList();
    }

    /** Bouton FIND : recherche un produit par son nom. */
    public void lookupProduct(View view) {
        MyDBHandler dbHandler = new MyDBHandler(this);
        Product product = dbHandler.findProduct(productBox.getText().toString().trim());

        if (product != null) {
            idView.setText(String.valueOf(product.getID()));
            skuBox.setText(String.valueOf(product.getSku()));
        } else {
            idView.setText("No Match Found");
        }
    }

    /** Bouton DELETE : supprime un produit par son nom. */
    public void removeProduct(View view) {
        MyDBHandler dbHandler = new MyDBHandler(this);
        boolean result = dbHandler.deleteProduct(productBox.getText().toString().trim());

        if (result) {
            idView.setText("Record Deleted");
            productBox.setText("");
            skuBox.setText("");
        } else {
            idView.setText("No Match Found");
        }
        refreshList();
    }

    /** Affiche le contenu actuel de la table « products ». */
    private void refreshList() {
        List<Product> products = new MyDBHandler(this).getAllProducts();
        if (products.isEmpty()) {
            listView.setText("(table vide)");
            return;
        }
        StringBuilder sb = new StringBuilder();
        for (Product p : products) {
            sb.append(p).append('\n');
        }
        listView.setText(sb.toString().trim());
    }
}
