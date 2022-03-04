module smartgreenhouse {
	requires javafx.controls;
	requires javafx.graphics;
	requires javafx.fxml;
   requires de.jensd.fx.glyphs.fontawesome;
   requires com.jfoenix;
	requires javafx.base;
	requires java.sql;
	requires java.desktop;
	
	opens application to javafx.graphics, javafx.fxml;
	opens controllers to  javafx.fxml;
	opens models to javafx.base, javafx.controls,javafx.fxml;

	
	 
}
