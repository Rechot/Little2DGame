package dev.codenmore.java2Dgame.utilities;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Utilities {



    public static String loadFileToString(String path) {

        String output = null;
        StringBuilder builder = new StringBuilder();
        try {
            Stream<String> stream = Files.lines(Paths.get(path));
            output = stream.toString(); System.out.println(output); // this will give you "java.util.stream.ReferencePipeline$Head@2ce96982"
            output = stream.map(n -> n.toString()).collect(Collectors.joining("\n"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(output);
        //output = output.replace("\n"," ").replace("\r"," ");
        //System.out.println(output);
        return output;

        /*
        StringBuilder builder = new StringBuilder();
        try{
            BufferedReader br = new BufferedReader(new FileReader((path)));
            String line;
            while ((line = br.readLine()) != null){ builder.append(line + "\n");}
            br.close();
        }catch(IOException e){
            e.printStackTrace();
        }
        return builder.toString();
        */

    }

    public static int parseInt(String number){
        try {
            return Integer.parseInt(number);
        }catch (NumberFormatException e){
            e.printStackTrace();
            return 0;
        }
    }
}