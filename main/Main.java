package main;

import checker.Checker;
import com.fasterxml.jackson.core.util.DefaultIndenter;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import input.Child;
import input.Input;
import output.AnnualChildren;
import utils.Utils;
import java.io.File;
import java.io.IOException;
import java.util.List;

import static common.Constants.TESTS_SIZE;

/**
 * Class used to run the code
 */
public final class Main {

    private Main() {
        ///constructor for checkstyle
    }
    /**
     * This method is used to call the checker which calculates the score
     * @param args
     *          the arguments used to call the main method
     */
    public static void main(final String[] args) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        for (int i = 1; i <= TESTS_SIZE; i++) {
                String inputPath = "tests/test" + i + ".json";
                String outputPath = "output/out_" + i + ".json";
                Input input = objectMapper.readValue(new File(inputPath), Input.class);

                Simulation game = Simulation.getSimulationInstance();

                List<Child> builderChildren =
                        Utils.buildChildren(input.getInitialData().getChildren());

                AnnualChildren annualChildren = game.run(input, input.getInitialData(),
                        builderChildren, input.getAnnualChanges());

                objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
                DefaultPrettyPrinter prettyPrinter = new DefaultPrettyPrinter();
                prettyPrinter.indentArraysWith(DefaultIndenter.SYSTEM_LINEFEED_INSTANCE);
                objectMapper.writeValue(new File(outputPath), annualChildren);
        }
        Checker.calculateScore();
    }

}
