package com.cydeo.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {

     /*
    In this class, we will be creating the re-usable logic to read from configuration.properties file
     */

    //1- Create object of properties (create object)
    //Make it "private" so we are limiting access to the object
    //"static" is to make sure its created and loaded before everything else
    private static Properties properties = new Properties();

    static {

        try {
            //2- Open the file using FIleInputStream (open file)
            FileInputStream file = new FileInputStream("configuration.properties");

            //3- Load the "properties" object with "file" (load properties)
            properties.load(file);

            //close the file in the memory
            file.close();

        } catch (IOException e) {
            System.out.println("FILE NOT FOUND WITH GIVEN PATH");
            e.printStackTrace();
        }
    }

    //Create a utility method to use the object to read
    //4- Use "properties" object to read value from the file (read properties)

    public static String getProperty(String keyword){

        return properties.getProperty(keyword);
    }
}