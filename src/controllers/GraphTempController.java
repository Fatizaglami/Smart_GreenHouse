package controllers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;

public class GraphTempController implements Initializable{
	
	  @FXML
	    private LineChart<?, ?> lineChart;

	    @FXML
	    private CategoryAxis x;

	    @FXML
	    private NumberAxis y;
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
		try {
			iniLineChart2() ;
		} catch (NumberFormatException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	private void iniLineChart2() throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

        BufferedReader inputStream = null;
            XYChart.Series series =new XYChart.Series();
            int m=0;
             try {
                  inputStream = new BufferedReader(new FileReader("D:\\MIOLA\\smartgreen_house\\file.txt"));
                  
                    String l;
                     while ((l = inputStream.readLine()) != null) {
                        // System.out.println("la val "+c);
                        int c= Integer.parseInt(l);
                          if(m==0){
                        	  
         series.getData().add(new XYChart.Data("10s",c));
             System.out.println("la val "+c);
     }

if(m==1){
        series.getData().add(new XYChart.Data("20s",c));
            System.out.println("la val "+c);
   }
    if(m==2){
        series.getData().add(new XYChart.Data("30s",c));
            System.out.println("la val "+c);
    }
    if(m==3){
        series.getData().add(new XYChart.Data("40s",c));
            System.out.println("la val "+c);
    }
if(m==4){
 series.getData().add(new XYChart.Data("50s",c));
     System.out.println("la val "+c);
}
    if(m==5){
        series.getData().add(new XYChart.Data("60s",c)); 
            System.out.println("la val "+c);
    }
  if(m==6){
      series.getData().add(new XYChart.Data("70s",c));  
          System.out.println("la val "+c);
  } m++;
                                     }
                            } finally {
        if (inputStream != null) {
            inputStream.close();}

}
        
        

    
    lineChart.getData().addAll(series);
     lineChart.lookup(".chart-plot-background").setStyle("-fx-background-color: transparent;");
    series.getNode().setStyle("-fx-stroke: #FFD6DC");

 
	}

}
