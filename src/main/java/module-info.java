module org.example.projetpoo {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.google.gson;

    opens org.example.projetpoo to javafx.fxml, com.google.gson;
    exports org.example.projetpoo;
}