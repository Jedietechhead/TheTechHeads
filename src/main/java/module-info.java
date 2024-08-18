module com.example.demo11 {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires com.almasb.fxgl.all;
    requires javafx.graphics;

    opens com.example.demo11 to javafx.fxml;
    exports com.example.demo11;
    exports controllers;
    opens controllers to javafx.fxml;
    exports daos;
    opens daos to javafx.fxml;
    exports services;
    opens services to javafx.fxml;
    exports models;
    opens models to javafx.fxml;
}