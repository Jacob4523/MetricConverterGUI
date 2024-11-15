import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class MetricConverter extends Application {
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Metric Converter App");

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(8);
        grid.setHgap(10);

        Label welcomeLabel = new Label("Welcome to the Metric Converter App!");
        GridPane.setConstraints(welcomeLabel, 0, 0, 2, 1);

        Label validInputsLabel = new Label("Valid conversions: cm = in, km = miles, kg = lb, L = gal");
        GridPane.setConstraints(validInputsLabel, 0, 1, 2, 1); // Span across two columns

        Label conversionLabel = new Label("Enter the conversion (e.g., km = miles):");
        GridPane.setConstraints(conversionLabel, 0, 2);
        TextField conversionInput = new TextField();
        GridPane.setConstraints(conversionInput, 1, 2);

        Label valueLabel = new Label("Enter the value to convert:");
        GridPane.setConstraints(valueLabel, 0, 3);
        TextField valueInput = new TextField();
        GridPane.setConstraints(valueInput, 1, 3);

        Button convertButton = new Button("Convert");
        GridPane.setConstraints(convertButton, 1, 4);

        Label resultLabel = new Label();
        GridPane.setConstraints(resultLabel, 1, 5);

        convertButton.setOnAction(e -> {
            String conversion = conversionInput.getText();
            double inputValue;
            try {
                inputValue = Double.parseDouble(valueInput.getText());
                if (inputValue < 0) {
                    resultLabel.setText("Please enter a value >= 0");
                    return;
                }
            } catch (NumberFormatException ex) {
                resultLabel.setText("Invalid input. Please enter a numeric value.");
                return;
            }

            double outputValue;
            switch (conversion) {
                case "cm = in":
                    outputValue = inputValue * 0.394;
                    resultLabel.setText(inputValue + " cm = " + outputValue + " in");
                    break;
                case "km = miles":
                    outputValue = inputValue * 0.621;
                    resultLabel.setText(inputValue + " km = " + outputValue + " miles");
                    break;
                case "kg = lb":
                    outputValue = inputValue * 2.205;
                    resultLabel.setText(inputValue + " kg = " + outputValue + " lb");
                    break;
                case "L = gal":
                    outputValue = inputValue * 0.264;
                    resultLabel.setText(inputValue + " L = " + outputValue + " gal");
                    break;
                default:
                    resultLabel.setText("Unsupported conversion. Please try again.");
                    break;
            }
        });

        grid.getChildren().addAll(welcomeLabel, validInputsLabel, conversionLabel, conversionInput, valueLabel, valueInput, convertButton, resultLabel);

        Scene scene = new Scene(grid, 400, 200);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
