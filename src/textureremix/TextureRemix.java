/*
The MIT License (MIT)

Copyright (c) 2015 Thomas "Peardian" Hernandez

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
 */
package textureremix;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.ArrayList;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

/**
 *
 * @author Peardian
 */
public class TextureRemix {
    
    //start counters at 1 because 0 means no input
    static int inputcount = 1;
    static int outputcount = 1;
    static List<MyImage> images = new ArrayList<>();
    static List<MyImage> outputs = new ArrayList<>();
    static List<javax.swing.JPanel> outputBoxes = new ArrayList<>();
    String[][] map;
    boolean clicked = false;
    boolean dragged = false;
    int[] defaultcolor;
    static String savepath = "";

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Check for savepath persistence file
        LoadPersistedSavePath();

        //setup
        images.add(0,null);
        outputs.add(0,null);
        outputBoxes.add(0,null);
        inputcount = 1;
        outputcount = 1;
        
        if (args.length > 0) {
            terminal(args);
            return;
        }

        //Todo: remove this once I can do dynamic layouts
        addOutput();
        addOutput();
        addOutput();
        addOutput();

        TextureRemixGui.main(args);
    }
    
    public static void terminal(String[] args) {
        List<String> commands = new ArrayList<>();
        for(int i = 0; i < args.length; i++) {
            if ("-o".equals(args[i])) {
                i++;
                setPath(args[i]);
                continue;
            }
            if ("-i".equals(args[i])) {
                i++;
                loadInput(args[i]);
                continue;
            }
            commands.add(args[i]);
        }
        processCommands(commands);
        saveAll();
    }
    
    public static void processCommands(List<String> args) {
        int max = 0;
        int newmax = 0;
        Pattern p = Pattern.compile("(!?)([0-9]+)([rgba]+)([0-9]*)([rgba]*)(!?)");
        Pattern pbit = Pattern.compile("([0-9])x([0-9])");
        for (String arg : args) {
            
            //parse input with pattern
            Matcher m = p.matcher(arg);
            Matcher mbit = pbit.matcher(arg);
            if (mbit.matches()) {
                images.get(Integer.parseInt(mbit.group(1))).splitAlphaBits(Integer.parseInt(mbit.group(2)));
                continue;
            } else if (!m.matches()) {
                System.out.println("Could not read command "+arg);
                continue;
            }
            int num1 = Integer.parseInt(m.group(2));
            char chan1 = m.group(3).charAt(0);
            int num2 = 0;
            if (!"".equals(m.group(4))) {
                num2 = Integer.parseInt(m.group(4));
            }
            char chan2 = 'x';
            if (!"".equals(m.group(5))) {
                chan2 = m.group(5).charAt(0);
            }
            boolean invert = false;
            int invertnum = num2;
            if ("!".equals(m.group(1)) || "!".equals(m.group(6))) {
                invert = true;
            }
            
            //read parsed values
            if (0 == num2 || 'x' == chan2) {
                if (!invert || num2 > 0 || 'x' != chan2) {
                    System.out.println("Incomplete command "+arg);
                    continue;
                }
                invertnum = num1;
            }
            
            //check for highest output number
            if (num2 > max) {
                newmax = num2;
            } else if (0 == num2 && num1 > max) {
                newmax = num1;
            }
            for (; max < newmax; max++) {
                addOutput();
            }
            
            if (invert) {
                if ('r' == chan1) {
                    outputs.get(invertnum).invertRed = true;
                } else if ('g' == chan1) {
                    outputs.get(invertnum).invertGreen = true;
                } else if ('b' == chan1) {
                    outputs.get(invertnum).invertBlue = true;
                } else if ('a' == chan1) {
                    outputs.get(invertnum).invertAlpha = true;
                }
            }
            
            //create link
            if (num2 > 0) {
                System.out.println("Loading output #"+num2+" out of "+outputcount);
                outputs.get(num2).setLink(chan2, num1, chan1);
            }
        }
    }
    
    private static void LoadPersistedSavePath() {
        File f = new File("savepath.txt");
        if (f.exists() && f.isFile()) {
            try {
                List<String> lines = Files.readAllLines(Paths.get(f.getAbsolutePath()), Charset.defaultCharset());
                if (lines.size() > 0) {
                    savepath = lines.get(0);
                } else {
                    System.out.println("File " + f.getAbsolutePath() + " is empty");
                }
            } catch (IOException io) {
                // ignore exception, savepath will be empty
                System.out.println("Error reading file " + f.getAbsolutePath() + ": " + io.toString());
            }
        } else {
            System.out.println("File savepath.txt not found");
        }
    }
    
    private static void SavePersistedSavePath() {
        try {
            Writer writer = new BufferedWriter(
                new OutputStreamWriter(
                    new FileOutputStream("./savepath.txt"),
                    Charset.defaultCharset()
                )
            );
            writer.write(savepath);
            writer.close();
        } catch (IOException io) {
        }
    }
    
    public static void setPath(String path) {
        if (path.contains("Select a folder")) {
            return;
        }
        System.out.println("Savepath set to " + path);
        savepath = path;
        SavePersistedSavePath();
    }
    
    public static String getFilenameFromPath(String file) {
        int i1 = file.lastIndexOf("/");
        if (i1 != -1) {
            file = file.substring(i1 + 1);
        }
        int i2 = file.lastIndexOf("\\");
        if (i2 != -1) {
            file = file.substring(i2 + 1);
        }
        return file;
    }
    
    public static void loadInput(String file) {
        if (inputcount > 4) {
            return;
        }
        int id = inputcount;
        MyImage img;
        try {
            img = new MyImage(id, file);
        } catch (Exception e) {
            TextureRemixGui.ShowError("Error loading file " + file + ": " + e.toString(), "Error loading File");
            return;
        }
        images.add(id, img);
        inputcount++;
        //temporary GUI code until proper dynamic gui is implemented
        if (inputcount == 2) {
            TextureRemixGui.Inbox1.setVisible(true);
            TextureRemixGui.Image1Caption.setText(getFilenameFromPath(file));
            TextureRemixGui.Image1Caption.setToolTipText(file);
        }
        if (inputcount == 3) {
            TextureRemixGui.Inbox2.setVisible(true);
            TextureRemixGui.Image2Caption.setText(getFilenameFromPath(file));
            TextureRemixGui.Image2Caption.setToolTipText(file);
        }
        if (inputcount == 4) {
            TextureRemixGui.Inbox3.setVisible(true);
            TextureRemixGui.Image3Caption.setText(getFilenameFromPath(file));
            TextureRemixGui.Image3Caption.setToolTipText(file);
        }
        if (inputcount == 5) {
            TextureRemixGui.Inbox4.setVisible(true);
            TextureRemixGui.Image4Caption.setText(getFilenameFromPath(file));
            TextureRemixGui.Image4Caption.setToolTipText(file);
        }
    }
    
    public static void addOutput() {
        int id = outputcount;
        outputs.add(id, new MyImage(id));
        outputcount++;
    }
    
    public static void saveAll() {
        if (savepath.length() < 1) {
            TextureRemixGui.ShowError("Need to set Output Path first!", "Outputpath Missing");
            return;
        }
        for (MyImage element : outputs) {
            if (element != null) {
                element.generateImage();
            }
        }
        TextureRemixGui.ShowMessage("Saving images complete!", "");
    }
    
    public static void splitImage(int id) {
        if (savepath.length() < 1) {
            TextureRemixGui.ShowError("Need to set Output Path first!", "Outputpath Missing");
            return;
        }
        images.get(id).splitImage();
        TextureRemixGui.ShowMessage("Split of Image " + id + " complete!", "");
    }
    
    public static void splitAlpha(int id) {
        if (savepath.length() < 1) {
            TextureRemixGui.ShowError("Need to set Output Path first!", "Outputpath Missing");
            return;
        }
        images.get(id).splitAlpha();
        TextureRemixGui.ShowMessage("Color / Alpha Split of Image " + id + " complete!", "");
    }
    
    public static void splitAlphaHalf(int id) {
        if (savepath.length() < 1) {
            TextureRemixGui.ShowError("Need to set Output Path first!", "Outputpath Missing");
            return;
        }
        images.get(id).splitAlphaHalf();
        TextureRemixGui.ShowMessage("Alpha Half split of Image " + id + " complete!", "");
    }
    
}
