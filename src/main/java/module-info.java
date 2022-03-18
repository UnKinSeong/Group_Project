module com.ststjl_project.group_project {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;

    opens com.ststjl_project.group_project to javafx.fxml;
    exports com.ststjl_project.group_project;
    exports com.ststjl_project.controllers;
    opens com.ststjl_project.controllers to javafx.fxml;
}