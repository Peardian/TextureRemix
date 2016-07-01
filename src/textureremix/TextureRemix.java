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
import javax.swing.JOptionPane;

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
    
    public static String getFilenameFromPath( String file ) {
        int i = file.lastIndexOf( "." );
        if( i != -1 ) {
            file = file.substring(0, i);
        }
        i = file.lastIndexOf("/");
        if( i != -1 )
            file = file.substring( i+1 );
        i = file.lastIndexOf("\\");
        if( i != -1 )
            file = file.substring( i+1 );
        return file;
    }
    
    public static void ShowError( String msg, String headline ) {
        JOptionPane.showMessageDialog(null, msg, headline, JOptionPane.ERROR_MESSAGE );
    }
    
    public static void ShowMessage( String msg, String headline ) {
        JOptionPane.showMessageDialog(null, msg, headline, JOptionPane.INFORMATION_MESSAGE );
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
            ShowError( "Error loading file "+file+": "+e.toString(), "Error loading File" );
            return;
        }
        images.add(id, img);
        inputcount++;
        //temporary GUI code until proper dynamic gui is implemented
        if (inputcount == 2) {
            TextureRemixGui.Inbox1.setVisible(true);
            TextureRemixGui.Image1Caption.setText( getFilenameFromPath( file ) );
        }
        if (inputcount == 3) {
            TextureRemixGui.Inbox2.setVisible(true);
            TextureRemixGui.Image2Caption.setText( getFilenameFromPath( file ) );
        }
        if (inputcount == 4) {
            TextureRemixGui.Inbox3.setVisible(true);
            TextureRemixGui.Image3Caption.setText( getFilenameFromPath( file ) );
        }
        if (inputcount == 5) {
            TextureRemixGui.Inbox4.setVisible(true);
            TextureRemixGui.Image4Caption.setText( getFilenameFromPath( file ) );
        }
    }
    
    public static void addOutput() {
        int id = outputcount;
        outputs.add(id, new MyImage(id));
        outputcount++;
    }
    
    public static void saveAll() {
        if( savepath.length() < 1 ) {
            ShowError( "Need to set Output Path first!", "Outputpath Missing" );
            return;
        }
        for (MyImage element : outputs) {
            if (element != null) {
                element.generateImage();
            }
        }
        ShowMessage( "Saving images complete!", "" );
    }
    
    public static void splitImage(int id) {
        if( savepath.length() < 1 ) {
            ShowError( "Need to set Output Path first!", "Outputpath Missing" );
            return;
        }
        images.get(id).splitImage();
        ShowMessage( "Split of Image "+id+" complete!", "" );
    }
    
    public static void splitAlpha(int id) {
        if( savepath.length() < 1 ) {
            ShowError( "Need to set Output Path first!", "Outputpath Missing" );
            return;
        }
        images.get(id).splitAlpha();
        ShowMessage( "Alpha Split of Image "+id+" complete!", "" );
    }
    
    public static void splitAlphaHalf(int id) {
        if( savepath.length() < 1 ) {
            ShowError( "Need to set Output Path first!", "Outputpath Missing" );
            return;
        }
        images.get(id).splitAlphaHalf();
        ShowMessage( "Alpha Half split of Image "+id+" complete!", "" );
    }
    
}
