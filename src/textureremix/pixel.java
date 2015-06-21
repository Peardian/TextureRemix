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

/**
 * This class manages color data for a single pixel.
 * It handles colors using integers for each channel,
 * but can read and output the raw binary value as well.
 * @author Peardian
 */
public class pixel {
    int raw = 0;
    int red = 0;
    int green = 0;
    int blue = 0;
    int alpha = 255;
    
    public void pixel(int input) {
        load(input);
    }
    
    void load(int input) {
        raw = input;
        alpha = (input >> 24) & 255;
        red = (input >> 16) & 255;
        green = (input >> 8) & 255;
        blue = input & 255;
    }
    
    void load(int input, boolean noAlpha) {
        raw = input;
        if (noAlpha) {
            alpha = 255;
        } else {
            alpha = (input >> 24) & 255;
        }
        red = (input >> 16) & 255;
        green = (input >> 8) & 255;
        blue = input & 255;
    }
    
    //http://www.javamex.com/tutorials/graphics/bufferedimage_setrgb.shtml
    void buildRaw() {
        raw = (alpha << 24) | (red << 16) | (green << 8) | blue;
    }
    
    int getRaw() {
        buildRaw();
        return raw;
    }
    
    int getRed() {
        return red;
    }
    
    int getGreen() {
        return green;
    }
    
    int getBlue() {
        return blue;
    }
    
    int getAlpha() {
        return alpha;
    }
    
    void setRed(int input) {
        red = input;
        buildRaw();
    }
    
    void setGreen(int input) {
        green = input;
        buildRaw();
    }
    
    void setBlue(int input) {
        blue = input;
        buildRaw();
    }
    
    void setAlpha(int input) {
        alpha = input;
        buildRaw();
    }
    
    void setGrey(int input) {
        red = input;
        green = input;
        blue = input;
        alpha = 255;
        buildRaw();
    }
    
    @Override
    public String toString() {
        return "("+getRed()+","+getGreen()+","+getBlue()+","+getAlpha()+")";
    }
}
