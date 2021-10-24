package vp.ajp;

import java.io.IOException;
import java.io.InputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.text.DecimalFormat;
import java.net.URISyntaxException;
import java.lang.reflect.Method;
import java.lang.reflect.InvocationTargetException;
import java.applet.Applet;

public class App {
    static final String PATH_SEPERATOR = "/";
    static final String PACKAGE_SEPERATOR = ".";
    static final String UPPER_DIRECTORY = "..";
    static final String EXPERIMENTS_FILES_DIRECTORY = "vp/ajp/experiments";
    static final String EXPERIMENTS_ROOT_PACKAGE = "vp.ajp.experiments";
    static final String EXPERIMENTS_FILES_EXTENTION = ".java";
    static final String EXPERIMENTS_MAIN_METHOD_NAME = "main";
    static final String EXPERIMENTS_SELECT_MESSAGE = "Select an experiemnt or a directory: ";
    static String[] ARGS;

    static {

    }

    public static int readInt(BufferedReader br) {
        try {
            return Integer.parseInt(br.readLine());
        } catch (IOException ioException) {
            System.out.println("Unexpected IOException Occured");
            ioException.printStackTrace();
        } catch (NumberFormatException numberFormatException) {
            System.out.println("Entered string is not an integer");
        }
        System.out.println("Reading int as 0");
        return 0;
    }

    public static List<String> getContentsFromParts(List<String> parts) {
        List<String> contents = new ArrayList<String>();

        String path;
        if (parts.isEmpty()) {
            path = EXPERIMENTS_FILES_DIRECTORY;
        } else {
            path = EXPERIMENTS_FILES_DIRECTORY + PATH_SEPERATOR + String.join(PATH_SEPERATOR, parts);
        }

        try {
            InputStream jarInputStream = App.class.getProtectionDomain().getCodeSource().getLocation().openStream();
            ZipInputStream jar = new ZipInputStream(jarInputStream);

            ZipEntry ze = null;
            while ((ze = jar.getNextEntry()) != null) {
                String content = ze.getName();
                String[] contentParts = content.split(PATH_SEPERATOR);
                if (contentParts.length == parts.size() + EXPERIMENTS_FILES_DIRECTORY.split(PATH_SEPERATOR).length + 1
                        && String.join(PATH_SEPERATOR, contentParts).startsWith(path)
                        && (content.endsWith(EXPERIMENTS_FILES_EXTENTION) || !content.contains("."))) {
                    contents.add(contentParts[contentParts.length - 1]);
                }
            }
        } catch (IOException ioException) {
            System.out.println("Error while reading jar file");
        }

        return contents;
    }

    public static Class<?> getClass(List<String> parts) {
        String classname = EXPERIMENTS_ROOT_PACKAGE + PACKAGE_SEPERATOR + String.join(PACKAGE_SEPERATOR, parts);
        classname = classname.replaceAll(EXPERIMENTS_FILES_EXTENTION, "");

        Class<?> progClass = null;
        try {
            progClass = Class.forName(classname);
        } catch (ClassNotFoundException classNotFoundException) {
            System.out.println("Class " + classname + " not found");
        }
        return progClass;
    }

    public static Method getMainMethod(Class<?> progClass) {
        Method mainMethod = null;
        String methodName = EXPERIMENTS_MAIN_METHOD_NAME;
        try {
            mainMethod = progClass.getDeclaredMethod(methodName, String[].class);
        } catch (NoSuchMethodException noSuchMethodException) {
            System.out.println("Method " + methodName + " in Class " + progClass.getName() + " not found");
        } catch (SecurityException securityException) {
            System.out.println("Cannot access Method " + methodName + " of Class " + progClass.getName());
        }
        return mainMethod;
    }

    public static Object invokeMainMethod(Method mainMethod, String[] args) {
        Object result = null;
        try {
            result = mainMethod.invoke(null, new Object[] { args });
        } catch (IllegalAccessException illegalAccessException) {
            System.out.println("Cannot access Method " + mainMethod.getName() + " in Class "
                    + mainMethod.getDeclaringClass().getName());
        } catch (IllegalArgumentException illegalArgumentException) {
            System.out.println("Method " + mainMethod.getName() + " in Class "
                    + mainMethod.getDeclaringClass().getName() + " should accept String[] as single argument");
        } catch (InvocationTargetException invocationTargetException) {
            invocationTargetException.printStackTrace(System.out);
        }
        return result;
    }

    public static void runMain(List<String> parts) {
        Class<?> classToRun = getClass(parts);
        invokeMainMethod(getMainMethod(classToRun), ARGS);
    }

    public static void runApplet(List<String> parts) {
        String classpath = System.getProperty("java.class.path");

        String file = null;

        try {
            String sep = PATH_SEPERATOR;
            String path = sep + EXPERIMENTS_FILES_DIRECTORY + sep + String.join(sep, parts);
            file = App.class.getResource(path).toURI().toString();
        } catch (URISyntaxException uriSyntaxException) {
            System.out.println("Unable to load Java File from JAR");
        }

        List<String> command = Arrays.asList("appletviewer", "-J-classpath", "-J" + classpath, file);

        System.out.println("> " + String.join(" ", command));

        System.out.println("____________________\n\n");

        try {

            Process process = Runtime.getRuntime().exec(command.toArray(new String[] {}));

            // Get input streams
            BufferedReader stdInput = new BufferedReader(new InputStreamReader(process.getInputStream()));
            BufferedReader stdError = new BufferedReader(new InputStreamReader(process.getErrorStream()));

            String s;

            // Read command standard output
            while ((s = stdInput.readLine()) != null) {
                System.out.println(s);
            }

            // Read command errors
            while ((s = stdError.readLine()) != null) {
                System.out.println(s);
            }
        } catch (IOException exception) {
            System.out.println("Unexpected error occured while running java applet");
            System.out.println(exception.getMessage());
        }
    }

    public static void main(String[] args) {
        ARGS = args;
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            boolean repeat;
            List<String> parts = new ArrayList<String>();

            do {
                System.out.println();
                do {
                    List<String> fileContents = getContentsFromParts(parts);
                    if (parts.size() > 0) {
                        fileContents.add(UPPER_DIRECTORY);
                    }

                    int maxDigits = String.valueOf(fileContents.size()).length();
                    DecimalFormat df = new DecimalFormat(String.join("", Collections.nCopies(maxDigits, "0")));

                    for (int i = 0; i < fileContents.size(); i++) {
                        System.out.println(df.format(i + 1) + " => " + fileContents.get(i));
                    }

                    System.out.print(EXPERIMENTS_SELECT_MESSAGE);
                    int selectedIndex = readInt(br) - 1;

                    try {
                        String part = fileContents.get(selectedIndex);
                        if (part.equals(UPPER_DIRECTORY)) {
                            parts.remove(parts.size() - 1);
                        } else {
                            parts.add(part);
                        }
                    } catch (IndexOutOfBoundsException exception) {
                        System.out.println("Invalid " + exception.getMessage());
                        System.out.println("Try Again");
                    }

                    System.out.println();
                } while (!getContentsFromParts(parts).isEmpty());

                if (Applet.class.isAssignableFrom(getClass(parts))) {
                    runApplet(parts);
                } else {
                    runMain(parts);
                }

                for (Thread thread : Thread.getAllStackTraces().keySet()) {
                    if (Thread.currentThread() != thread && !thread.isDaemon()) {
                        try {
                            thread.join();
                        } catch (InterruptedException interruptedException) {
                            System.out.println(interruptedException.getMessage());
                        }
                    }
                }

                System.out.print("Do you want to repeat? (1 for Yes / 0 for No): ");
                repeat = readInt(br) == 1 ? true : false;

                parts.remove(parts.size() - 1);
            } while (repeat);

            br.close();
        } catch (IOException ioException) {
            System.out.println("Unexpected IOException Occured");
            ioException.printStackTrace();
        }
    }
}
