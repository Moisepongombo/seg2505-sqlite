# SQLite – DatabaseProject

Laboratoire SEG2505, semaine 6 : « Enregistrer des données avec SQLite ».

- `Product` : un produit (id, nom, SKU)
- `MyDBHandler` (hérite de `SQLiteOpenHelper`) : crée la table `products` et fournit `addProduct`, `findProduct`, `deleteProduct` et `getAllProducts`
- `MainActivity` : les boutons **ADD**, **FIND** et **DELETE** appellent `newProduct()`, `lookupProduct()` et `removeProduct()`

La base `productDB.db` peut être examinée dans Android Studio avec **App Inspection → Database Inspector**.

Réalisé avec l'aide d'un assistant IA (Claude).
