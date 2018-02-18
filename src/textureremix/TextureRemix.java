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
        for (String arg : args) {
            
            //parse input with pattern
            Matcher m = p.matcher(arg);
            if (!m.matches()) {
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
    
    public static void setPath(String path) {
        savepath = path;
    }
    
    public static void loadInput(String file) {
        if (inputcount > 4) {
            return;
        }
        int id = inputcount;
        images.add(id, new MyImage(id, file));
        inputcount++;
        //temporary GUI code until proper dynamic gui is implemented
        if (TextureRemixGui.Inbox1==null) {
            return;
        }
        if (inputcount > 1) {
            TextureRemixGui.Inbox1.setVisible(true);
        }
        if (inputcount > 2) {
            TextureRemixGui.Inbox2.setVisible(true);
        }
        if (inputcount > 3) {
            TextureRemixGui.Inbox3.setVisible(true);
        }
        if (inputcount > 4) {
            TextureRemixGui.Inbox4.setVisible(true);
        }
    }
    
    public static void addOutput() {
        int id = outputcount;
        outputs.add(id, new MyImage(id));
        outputcount++;
    }
    
    public static void saveAll() {
        for (MyImage element : outputs) {
            if (element != null) {
                element.generateImage();
            }
        }
    }
    
    public static void splitImage(int id) {
        images.get(id).splitImage();
    }
    
    public static void splitAlpha(int id) {
        images.get(id).splitAlpha();
    }
    
    public static void splitAlphaHalf(int id) {
        images.get(id).splitAlphaHalf();
    }
    
}
