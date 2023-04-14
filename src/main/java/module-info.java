module com.s.challenge {
    requires javafx.controls;
    requires javafx.fxml;
            
                    requires org.kordamp.ikonli.javafx;
                
    opens com.s.challenge to javafx.fxml;
    exports com.s.challenge;
}