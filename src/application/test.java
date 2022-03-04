package application;


import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.ScatterChart;
import javafx.scene.chart.StackedAreaChart;
import javafx.scene.chart.StackedBarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.XYChart.Series;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *
 * @author Ram
 */
public class test extends Application {
    //private StackedBarChart chart;
    
    @Override
    public void start(Stage primaryStage) {
        
        primaryStage.setTitle("Sensors");
        
        StackPane root = new StackPane();
        Scene scene = new Scene(root, 500, 350);
        
        CategoryAxis xAxis = new CategoryAxis();
        NumberAxis yAxis = new NumberAxis();
        
        //ScatterChart chart = new ScatterChart(xAxis, yAxis, getChartData());
        
        //LineChart chart = new LineChart(xAxis, yAxis, getChartData());
        //AreaChart chart = new AreaChart(xAxis, yAxis, getChartData());
        
        //StackedAreaChart chart = new StackedAreaChart(xAxis, yAxis, getChartData());
        BarChart chart = new BarChart(xAxis, yAxis, getChartData());
        
        //chart = new StackedBarChart(xAxis, yAxis, getChartData());
        chart.setTitle("Speculations");
        
        Timeline t1 = new Timeline();
        t1.getKeyFrames().add(new KeyFrame(Duration.millis(500),
        (ActionEvent e) ->{
            chart.getData().stream().forEach((series) ->{
                
            });
        }));
        root.getChildren().add(chart);
        
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    private ObservableList<Series<String, Double>> getChartData(){
        double javaValue = 17.56;
        double cValue = 17.06;
        double cppValue = 8.25;
        
        ObservableList<XYChart.Series<String, Double>> data = FXCollections.observableArrayList();
        
        Series<String, Double> java = new Series<>();
        Series<String, Double> c = new Series<>();
        Series<String, Double> cpp = new Series<>();
        
        java.setName("Temperature");
        c.setName("HumiditySol");
        cpp.setName("HumidityAir");
        
        for(int i=2011; i<2021; i++){
            java.getData().add(new XYChart.Data(Integer.toString(i), javaValue));
            javaValue = javaValue + 4 * Math.random() - 0.2;
            
            c.getData().add(new XYChart.Data(Integer.toString(i), cValue));
            cValue = cValue + 4 * Math.random() - 2;
            
            cpp.getData().add(new XYChart.Data(Integer.toString(i), cppValue));
            cppValue = cppValue + 4 * Math.random() - 0.2;
        }
        
        
        data.addAll(java, c, cpp);
        
        return data;
    }
}