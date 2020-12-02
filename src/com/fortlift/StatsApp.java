package com.fortlift;

import com.opencsv.CSVReaderBuilder;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.math3.stat.StatUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class StatsApp {

    public void run(String[] args) {
        CommandLine line = parseArguments(args);

        if(line.hasOption("filename")) {
            String filename = line.getOptionValue("filename");
            System.out.println(filename);
            double[] data = readData(filename);
            calculateAndPrintStats(data);
        } else {
            printAppHelp();
        }
    }

    private CommandLine parseArguments(String[] args) {
        Options options = getOptions();
        CommandLine line = null;
        CommandLineParser parser = new DefaultParser();

        try {
            line = parser.parse(options, args);
        } catch (ParseException ex) {
          System.err.println("Failed to parse command line arguments");
          System.err.println(ex.toString());
          printAppHelp();

          System.exit(1);
        }

        return line;
    }

    private double[] readData(String filename) {
        var data = new ArrayList<Double>();
        double[] myData = null;

        try(var reader = Files.newBufferedReader(Paths.get(filename));
            var csvReader = new CSVReaderBuilder(reader).build()){
            String[] nextLine;

            while((nextLine = csvReader.readNext()) != null) {
                for(String s : nextLine){
                    data.add(Double.parseDouble(s));
                }
            }
            myData = ArrayUtils.toPrimitive(data.toArray(new Double[0]));
        } catch (IOException ex) {
            System.err.println("Failed to read file");
            System.err.println(ex.toString());
            System.exit(1);
        }

        return myData;
    }

    private Options getOptions() {
        var options = new Options();
        options.addOption("f", "filename", true, "file name to load data from");
        return options;
    }

    private void printAppHelp() {
        Options options = getOptions();
        var formatter = new HelpFormatter();
        formatter.printHelp("JavaStatsEx", options, true);
    }

    private void calculateAndPrintStats(double[] data) {
        System.out.format("Geometric mean: %f%n", StatUtils.geometricMean(data));
        System.out.format("Arithemtic mean: %f%n", StatUtils.mean(data));
        System.out.format("Max: %f%n", StatUtils.max(data));
        System.out.format("Min: %f%n", StatUtils.min(data));
        System.out.format("Sum: %f%n", StatUtils.sum(data));
        System.out.format("Variance: %f%n", StatUtils.variance(data));
    }
}
