module com.s.challenge {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.ikonli.javafx;
    requires com.jfoenix;

    opens com.s.challenge to javafx.fxml;
    exports com.s.challenge;
}