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
import javax.imageio.*;
import java.awt.*;
import java.awt.image.*;
import static textureremix.TextureRemix.savepath;
import static textureremix.TextureRemix.images;

/**
 * Image class used for both input and output images.
 * Manages the input sources and other output settings.
 * @author Peardian
 */
public class MyImage {
    
    int id;
    int width;
    int height;
    int inputRed;
    char inputRedCh;
    int inputGreen;
    char inputGreenCh;
    int inputBlue;
    char inputBlueCh;
    int inputAlpha;
    char inputAlphaCh;
    boolean invertRed;
    boolean invertGreen;
    boolean invertBlue;
    boolean invertAlpha;
    BufferedImage image;
    pixel[][] pix;

    public MyImage(int num) {
        id = num;
    }

    public MyImage(int num, String file) {
        id = num;
        loadImageData(file);
    }
    
    final void loadImageData(String file){
        try {
            image = ImageIO.read(new File(file));
            loadPixels();
            System.out.println("Successfully loaded input file #"+id+": "+file);
        } catch (Exception e) {
            System.out.println("Error: Failed to load file!");
        }
    }
    
    public void blank(int x, int y) {
        image = new BufferedImage(x,y,BufferedImage.TYPE_4BYTE_ABGR);
        loadPixels();
    }
    
    public Dimension getSize() {
        return new Dimension(image.getWidth(null), image.getHeight(null));
    }
    
    public int getWidth() {
        if (image == null) {
            return 0;
        }
        return image.getWidth(null);
    }
    
    public int getHeight() {
        if (image == null) {
            return 0;
        }
        return image.getHeight(null);
    }
    
    public boolean hasAlpha() {
        if (image == null) {
            return false;
        }
        return image.getAlphaRaster() != null;
    }
    
    //http://stackoverflow.com/questions/6524196/java-get-pixel-array-from-image
    void loadPixels() {
        byte[] pixels = ((DataBufferByte) image.getRaster().getDataBuffer()).getData();
        pix = new pixel[getHeight()][getWidth()];
        if (hasAlpha()) {
            final int pixelLength = 4;
            for (int pixel = 0, row = 0, col = 0; pixel < pixels.length; pixel += pixelLength) {
                if (col == getWidth()) {
                    col = 0;
                    row++;
                }
                int argb = 0;
                argb += (((int) pixels[pixel] & 0xff) << 24); // alpha
                argb += ((int) pixels[pixel + 1] & 0xff); // blue
                argb += (((int) pixels[pixel + 2] & 0xff) << 8); // green
                argb += (((int) pixels[pixel + 3] & 0xff) << 16); // red
                pix[row][col] = new pixel();
                pix[row][col].load(argb);
                col++;
            }
        } else {
            final int pixelLength = 3;
            for (int pixel = 0, row = 0, col = 0; pixel < pixels.length; pixel += pixelLength) {
                if (col >= getWidth()) {
                    col = 0;
                    row++;
                }
                int argb = 0;
                argb += -16777216; // 255 alpha
                argb += ((int) pixels[pixel] & 0xff); // blue
                argb += (((int) pixels[pixel + 1] & 0xff) << 8); // green
                argb += (((int) pixels[pixel + 2] & 0xff) << 16); // red
                pix[row][col] = new pixel();
                pix[row][col].load(argb);
                col++;
            }
        }
    }
    
    void applyPixels() {
        for (int row = 0; row < getHeight(); row++) {
            for (int col = 0; col < getWidth(); col++) {
                image.setRGB(col, row, pix[row][col].getRaw());
            }
        }
    }
    
    public int getRed(int row, int col) {
        if (row >= getHeight() || col >= getWidth()) {
            return 0;
        }
        return pix[row][col].getRed();
    }
    
    public int getGreen(int row, int col) {
        if (row >= getHeight() || col >= getWidth()) {
            return 0;
        }
        return pix[row][col].getGreen();
    }
    
    public int getBlue(int row, int col) {
        if (row >= getHeight() || col >= getWidth()) {
            return 0;
        }
        return pix[row][col].getBlue();
    }
    
    public int getAlpha(int row, int col) {
        if (row >= getHeight() || col >= getWidth()) {
            return 255;
        }
        return pix[row][col].getAlpha();
    }
    
    public void setRed(int row, int col, int val) {
        if (invertRed) {
            pix[row][col].setRed((255-val));
        } else {
            pix[row][col].setRed(val);
        }
    }
    
    public void setGreen(int row, int col, int val) {
        if (invertGreen) {
            pix[row][col].setGreen((255-val));
        } else {
            pix[row][col].setGreen(val);
        }
    }
    
    public void setBlue(int row, int col, int val) {
        if (invertBlue) {
            pix[row][col].setBlue((255-val));
        } else {
            pix[row][col].setBlue(val);
        }
    }
    
    public void setAlpha(int row, int col, int val) {
        if (invertAlpha) {
            pix[row][col].setAlpha((255-val));
        } else {
            pix[row][col].setAlpha(val);
        }
    }
    
    public void setGrey(int row, int col, int val) {
        pix[row][col].setGrey(val);
    }
    
    public void setLink(char outchannel, int id, char inchannel) {
        System.out.println("Link: IN "+id+"-"+inchannel+" ==> OUT "+this.id+"-"+outchannel);
        if (outchannel == 'r') {
            inputRed = id;
            inputRedCh = inchannel;
        } else if (outchannel == 'g') {
            inputGreen = id;
            inputGreenCh = inchannel;
        } else if (outchannel == 'b') {
            inputBlue = id;
            inputBlueCh = inchannel;
        } else if (outchannel == 'a') {
            inputAlpha = id;
            inputAlphaCh = inchannel;
        }
    }
    
    public void generateImage() {
        determineSize();
        if (width < 1 && height < 1) {
            return;
        }
        blank(width, height);
        buildImage();
    }

    public int getMaxWidth(int compare) {
        if (compare > getWidth()) {
            return compare;
        }
        return getWidth();
    }

    public int getMaxHeight(int compare) {
        if (compare > getHeight()) {
            return compare;
        }
        return getHeight();
    }
    
    private void determineSize() {
        height = 0;
        width = 0;
        if (inputRed > 0) {
            height = images.get(inputRed).getMaxHeight(height);
            width = images.get(inputRed).getMaxWidth(width);
        }
        if (inputGreen > 0) {
            height = images.get(inputGreen).getMaxHeight(height);
            width = images.get(inputGreen).getMaxWidth(width);
        }
        if (inputBlue > 0) {
            height = images.get(inputBlue).getMaxHeight(height);
            width = images.get(inputBlue).getMaxWidth(width);
        }
        if (inputAlpha > 0) {
            height = images.get(inputAlpha).getMaxHeight(height);
            width = images.get(inputAlpha).getMaxWidth(width);
        }
        System.out.println("Output image size: "+width+"x"+height);
    }
    
    void buildImage() {
        if (inputRed != 0) {
            applyChannel(inputRed, 'r');
        } else if (invertRed) {
            //inverted, so 0 = 255
            fillChannel('r', 0);
        }
        if (inputGreen != 0) {
            applyChannel(inputGreen, 'g');
        } else if (invertGreen) {
            //inverted, so 0 = 255
            fillChannel('g', 0);
        }
        if (inputBlue != 0) {
            applyChannel(inputBlue, 'b');
        } else if (invertBlue) {
            //inverted, so 0 = 255
            fillChannel('b', 0);
        }
        if (inputAlpha != 0) {
            applyChannel(inputAlpha, 'a');
        } else {
            fillChannel('a', 255);
        }
        saveFile();
    }
    
    private void applyChannel(int target, char channel) {
        if (images == null || images.isEmpty() || images.get(target) == null) {
            System.out.println("Bad ID: "+target);
            return;
        }
        char input = 'x';
        if (channel == 'r') {
            input = inputRedCh;
        } else if (channel == 'g') {
            input = inputGreenCh;
        } else if (channel == 'b') {
            input = inputBlueCh;
        } else if (channel == 'a') {
            input = inputAlphaCh;
        }
        for (int row = 0; row < getHeight(); row++) {
            for (int col = 0; col < getWidth(); col++) {
                int val = 0;
                if (input == 'r') {
                    val = images.get(target).getRed(row, col);
                } else if (input == 'g') {
                    val = images.get(target).getGreen(row, col);
                } else if (input == 'b') {
                    val = images.get(target).getBlue(row, col);
                } else if (input == 'a') {
                    val = images.get(target).getAlpha(row, col);
                }
                if (channel == 'r') {
                    setRed(row, col, val);
                } else if (channel == 'g') {
                    setGreen(row, col, val);
                } else if (channel == 'b') {
                    setBlue(row, col, val);
                } else if (channel == 'a') {
                    setAlpha(row, col, val);
                }
            }
        }
    }
    
    void fillChannel(char channel, int val) {
        for (int row = 0; row < getHeight(); row++) {
            for (int col = 0; col < getWidth(); col++) {
                if (channel == 'r') {
                    setRed(row, col, val);
                } else if (channel == 'g') {
                    setGreen(row, col, val);
                } else if (channel == 'b') {
                    setBlue(row, col, val);
                } else if (channel == 'a') {
                    setAlpha(row, col, val);
                }
            }
        }
    }
    
    void saveFile() {
        if (savepath.length() < 1) {
            System.out.println("Error: No output path!");
            return;
        }
        applyPixels();
        File outputfile = new File(savepath+File.separator+"texture"+id+".png");
        try {
            ImageIO.write(image, "png", outputfile);
        } catch (Exception e) {
            System.out.println("Error: Failed to save file!");
        }
    }
    
    void saveFile(String append) {
        if (savepath.length() < 1) {
            System.out.println("Error: No output path!");
            return;
        }
        applyPixels();
        File outputfile = new File(savepath+File.separator+"texture"+id+append+".png");
        try {
            ImageIO.write(image, "png", outputfile);
        } catch (Exception e) {
            System.out.println("Error: Failed to save file!");
        }
    }
    
    void splitImage() {
        MyImage r = new MyImage(id);
        MyImage g = new MyImage(id);
        MyImage b = new MyImage(id);
        MyImage a = new MyImage(id);
        r.blank(getWidth(), getHeight());
        g.blank(getWidth(), getHeight());
        b.blank(getWidth(), getHeight());
        a.blank(getWidth(), getHeight());
        for (int row = 0; row < getHeight(); row++) {
            for (int col = 0; col < getWidth(); col++) {
                r.setGrey(row, col, getRed(row, col));
                g.setGrey(row, col, getGreen(row, col));
                b.setGrey(row, col, getBlue(row, col));
                a.setGrey(row, col, getAlpha(row, col));
            }
        }
        r.saveFile("_r");
        g.saveFile("_g");
        b.saveFile("_b");
        a.saveFile("_a");
    }
}
