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

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Point;
import static textureremix.TextureRemix.inputcount;
import static textureremix.TextureRemix.outputs;

/**
 * This is what draws the lines on the GUI linking input and output channels.
 * @author Peardian
 */
public class canvasPanel extends javax.swing.JComponent {
    
    public canvasPanel() {
        this.setVisible(true);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawLines(g);
    }

    //http://zetcode.com/gfx/java2d/basicdrawing/
    private void drawLines(Graphics g) {
        if (inputcount <= 1) {
            return;
        }
        Graphics2D g2d = (Graphics2D) g;

        BasicStroke thick = new BasicStroke(4, BasicStroke.CAP_BUTT, BasicStroke.JOIN_ROUND, 1.0f);
        g2d.setStroke(thick);

        for (MyImage element : outputs) {
            if (element != null) {
                if (element.inputRed > 0) {
                    drawPair(g2d, element.id, 'r', element.inputRed, element.inputRedCh);
                }
                if (element.inputGreen > 0) {
                    drawPair(g2d, element.id, 'g', element.inputGreen, element.inputGreenCh);
                }
                if (element.inputBlue > 0) {
                    drawPair(g2d, element.id, 'b', element.inputBlue, element.inputBlueCh);
                }
                if (element.inputAlpha > 0) {
                    drawPair(g2d, element.id, 'a', element.inputAlpha, element.inputAlphaCh);
                }
            }
        }
        
        
        

        //reset so whole frame doesn't get fat
        BasicStroke thin = new BasicStroke(1, BasicStroke.CAP_BUTT, BasicStroke.JOIN_ROUND, 1.0f);
        g2d.setStroke(thin);
    }
   
    private void drawPair(Graphics2D g2d, int outid, char outchan, int inid, char inchan) {
        int[] xy1 = getOutputCoords(outid, outchan);
        int[] xy2 = getInputCoords(inid, inchan);
        if (inchan == 'r') {
            g2d.setColor(Color.red);
        } else if (inchan == 'g') {
            g2d.setColor(new Color(0,200,0));
        } else if (inchan == 'b') {
            g2d.setColor(Color.blue);
        } else if (inchan == 'a') {
            g2d.setColor(Color.black);
        }
        Point offset = TextureRemixGui.outR1.getRootPane().getLocationOnScreen();
        g2d.drawLine(xy2[0]+12-offset.x, xy2[1]+34-offset.y, xy1[0]+12-offset.x, xy1[1]-offset.y);
    }

    private int[] getOutputCoords(int id, char chan) {
        //temporary code until proper dynamic layout is implemented
        int[] xy = new int[2];
        Point p = new Point();
        if (id == 1) {
            if (chan == 'r') {
                p = TextureRemixGui.outR1.getLocationOnScreen();
            } else if (chan == 'g') {
                p = TextureRemixGui.outG1.getLocationOnScreen();
            } else if (chan == 'b') {
                p = TextureRemixGui.outB1.getLocationOnScreen();
            } else if (chan == 'a') {
                p = TextureRemixGui.outA1.getLocationOnScreen();
            }
        } else if (id == 2) {
            if (chan == 'r') {
                p = TextureRemixGui.outR2.getLocationOnScreen();
            } else if (chan == 'g') {
                p = TextureRemixGui.outG2.getLocationOnScreen();
            } else if (chan == 'b') {
                p = TextureRemixGui.outB2.getLocationOnScreen();
            } else if (chan == 'a') {
                p = TextureRemixGui.outA2.getLocationOnScreen();
            }
        } else if (id == 3) {
            if (chan == 'r') {
                p = TextureRemixGui.outR3.getLocationOnScreen();
            } else if (chan == 'g') {
                p = TextureRemixGui.outG3.getLocationOnScreen();
            } else if (chan == 'b') {
                p = TextureRemixGui.outB3.getLocationOnScreen();
            } else if (chan == 'a') {
                p = TextureRemixGui.outA3.getLocationOnScreen();
            }
        } else if (id == 4) {
            if (chan == 'r') {
                p = TextureRemixGui.outR4.getLocationOnScreen();
            } else if (chan == 'g') {
                p = TextureRemixGui.outG4.getLocationOnScreen();
            } else if (chan == 'b') {
                p = TextureRemixGui.outB4.getLocationOnScreen();
            } else if (chan == 'a') {
                p = TextureRemixGui.outA4.getLocationOnScreen();
            }
        }
        xy[0] = p.x;
        xy[1] = p.y;
        return xy;
    }

    private int[] getInputCoords(int id, char chan) {
        int[] xy = new int[2];
        Point p = new Point();
        if (id == 1) {
            if (chan == 'r') {
                p = TextureRemixGui.inR1.getLocationOnScreen();
            } else if (chan == 'g') {
                p = TextureRemixGui.inG1.getLocationOnScreen();
            } else if (chan == 'b') {
                p = TextureRemixGui.inB1.getLocationOnScreen();
            } else if (chan == 'a') {
                p = TextureRemixGui.inA1.getLocationOnScreen();
            }
        } else if (id == 2) {
            if (chan == 'r') {
                p = TextureRemixGui.inR2.getLocationOnScreen();
            } else if (chan == 'g') {
                p = TextureRemixGui.inG2.getLocationOnScreen();
            } else if (chan == 'b') {
                p = TextureRemixGui.inB2.getLocationOnScreen();
            } else if (chan == 'a') {
                p = TextureRemixGui.inA2.getLocationOnScreen();
            }
        } else if (id == 3) {
            if (chan == 'r') {
                p = TextureRemixGui.inR3.getLocationOnScreen();
            } else if (chan == 'g') {
                p = TextureRemixGui.inG3.getLocationOnScreen();
            } else if (chan == 'b') {
                p = TextureRemixGui.inB3.getLocationOnScreen();
            } else if (chan == 'a') {
                p = TextureRemixGui.inA3.getLocationOnScreen();
            }
        } else if (id == 4) {
            if (chan == 'r') {
                p = TextureRemixGui.inR4.getLocationOnScreen();
            } else if (chan == 'g') {
                p = TextureRemixGui.inG4.getLocationOnScreen();
            } else if (chan == 'b') {
                p = TextureRemixGui.inB4.getLocationOnScreen();
            } else if (chan == 'a') {
                p = TextureRemixGui.inA4.getLocationOnScreen();
            }
        }
        xy[0] = p.x;
        xy[1] = p.y;
        return xy;
    }

}
