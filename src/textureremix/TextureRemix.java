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

        //Todo: remove this once I can do dynamic layouts
        addOutput();
        addOutput();
        addOutput();
        addOutput();

        TextureRemixGui.main(args);
    }
    
    public static void setPath(String path) {
        savepath = path;
    }
    
    public static void loadInput(String file) {
        if (inputcount > 4) {
            return;
        }
        int id = inputcount;
        MyImage img;
        try {
            img = new MyImage(id, file);
        } catch( Exception e ) {
            JOptionPane.showMessageDialog(null, "Error loading file "+file+": "+e.toString(), "Error loading File", JOptionPane.ERROR_MESSAGE );
            return;
        }
        images.add(id, img);
        inputcount++;
        //temporary GUI code until proper dynamic gui is implemented
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
