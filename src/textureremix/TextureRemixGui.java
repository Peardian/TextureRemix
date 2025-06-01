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

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Toolkit;
import java.awt.Point;
import javax.swing.Timer;
import javax.swing.ImageIcon;
import java.io.*;
import javax.imageio.ImageIO;
import java.awt.image.*;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import static textureremix.TextureRemix.outputcount;
import static textureremix.TextureRemix.outputBoxes;

/**
 * The main window for the GUI.
 * @author Peardian
 */
public class TextureRemixGui extends javax.swing.JFrame implements java.awt.event.ActionListener {
    
    public int dragid;
    public char dragchan;
    public int clickid;
    public char clickchan;
    public char hoverin;
    public char hoverout;

    class MyCustomFilter extends javax.swing.filechooser.FileFilter {
        @Override
        public boolean accept(File file) {
            // Allow only directories, or common image files
            return file.isDirectory()
                    || file.getAbsolutePath().endsWith(".bmp")
                    || file.getAbsolutePath().endsWith(".png")
                    || file.getAbsolutePath().endsWith(".tga");
        }
        @Override
        public String getDescription() {
            // This description will be displayed in the dialog,
            // hard-coded = ugly, should be done via I18N
            return "Image documents (*.png, *.bmp, *.tga)";
        }
    }

    /**
     * Creates new form TextureRemixGui
     */
    public TextureRemixGui() {
        initComponents();
        DebugPanel.setVisible(false);
        //Temporary until proper dynamic inputs is implemented
        Inbox1.setVisible(false);
        Inbox2.setVisible(false);
        Inbox3.setVisible(false);
        Inbox4.setVisible(false);
        
        Timer timer = new Timer(100, this);
        timer.start();

        try {
            BufferedImage i = ImageIO.read(getClass().getResource("/icon.png"));
            this.setIconImage(i);
        } catch(Exception e) {
            System.out.println("Error: Failed to load icon! - "+e);
        }
    }

    @Override
    public void actionPerformed(java.awt.event.ActionEvent e) {
        this.repaint();
        updateCursor();
    }
    
    public void updateCursor() {
        String name = "";
        switch (clickchan) {
            case 'r':
                name = "cursorInR.png";
                if (hoverout == 'r' || hoverout == 'g' || hoverout == 'b' || hoverout == 'a') {
                    name = "cursorOutR.png";
                }
                break;
            case 'g':
                name = "cursorInG.png";
                if (hoverout == 'r' || hoverout == 'g' || hoverout == 'b' || hoverout == 'a') {
                    name = "cursorOutG.png";
                }
                break;
            case 'b':
                name = "cursorInB.png";
                if (hoverout == 'r' || hoverout == 'g' || hoverout == 'b' || hoverout == 'a') {
                    name = "cursorOutB.png";
                }
                break;
            case 'a':
                name = "cursorInA.png";
                if (hoverout == 'r' || hoverout == 'g' || hoverout == 'b' || hoverout == 'a') {
                    name = "cursorOutA.png";
                }
                break;
        }
        
        Cursor cursor = new Cursor(Cursor.DEFAULT_CURSOR);
        if (!"".equals(name)) {
            cursor = Toolkit.getDefaultToolkit().createCustomCursor(new ImageIcon(getClass().getResource(name)).getImage(), new Point(4,3), "Have red");
        } else if (hoverin == 'r' || hoverin == 'g' || hoverin == 'b' || hoverin == 'a') {
            cursor = new Cursor(Cursor.HAND_CURSOR);
        }
        
        setCursor(cursor);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fileChooser = new javax.swing.JFileChooser();
        folderChooser = new javax.swing.JFileChooser();
        basePanel = new javax.swing.JPanel();
        this.setGlassPane(new canvasPanel());
        this.getGlassPane().setVisible(true);
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        folderButton = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        Inbox1 = new javax.swing.JPanel();
        Image1Caption = new javax.swing.JLabel();
        split1 = new javax.swing.JLabel();
        inR1 = new javax.swing.JPanel();
        jPanel27 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        inB1 = new javax.swing.JPanel();
        inA1 = new javax.swing.JPanel();
        inG1 = new javax.swing.JPanel();
        Inbox2 = new javax.swing.JPanel();
        Image2Caption = new javax.swing.JLabel();
        split2 = new javax.swing.JLabel();
        inR2 = new javax.swing.JPanel();
        jPanel29 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        inB2 = new javax.swing.JPanel();
        inA2 = new javax.swing.JPanel();
        inG2 = new javax.swing.JPanel();
        Inbox3 = new javax.swing.JPanel();
        Image3Caption = new javax.swing.JLabel();
        split3 = new javax.swing.JLabel();
        inR3 = new javax.swing.JPanel();
        jPanel31 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        inB3 = new javax.swing.JPanel();
        inA3 = new javax.swing.JPanel();
        inG3 = new javax.swing.JPanel();
        Inbox4 = new javax.swing.JPanel();
        Image4Caption = new javax.swing.JLabel();
        split4 = new javax.swing.JLabel();
        inR4 = new javax.swing.JPanel();
        jPanel33 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        inB4 = new javax.swing.JPanel();
        inA4 = new javax.swing.JPanel();
        inG4 = new javax.swing.JPanel();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 134), new java.awt.Dimension(0, 134), new java.awt.Dimension(32767, 134));
        jButton3 = new javax.swing.JButton();
        DebugPanel = new javax.swing.JPanel();
        debugInput = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        debugOutput = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        debugFromCh = new javax.swing.JTextField();
        debugToCh = new javax.swing.JTextField();
        debugLinker = new javax.swing.JButton();
        debugSplitter = new javax.swing.JButton();
        debugInverter = new javax.swing.JButton();
        debugReverser = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        outR1 = new javax.swing.JPanel();
        outG1 = new javax.swing.JPanel();
        outB1 = new javax.swing.JPanel();
        outA1 = new javax.swing.JPanel();
        invertR1 = new javax.swing.JCheckBox();
        invertG1 = new javax.swing.JCheckBox();
        invertA1 = new javax.swing.JCheckBox();
        invertB1 = new javax.swing.JCheckBox();
        clear1 = new javax.swing.JButton();
        gray1 = new javax.swing.JLabel();
        rgb1 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        outR2 = new javax.swing.JPanel();
        outG2 = new javax.swing.JPanel();
        outB2 = new javax.swing.JPanel();
        outA2 = new javax.swing.JPanel();
        invertR2 = new javax.swing.JCheckBox();
        invertG2 = new javax.swing.JCheckBox();
        invertA2 = new javax.swing.JCheckBox();
        invertB2 = new javax.swing.JCheckBox();
        clear2 = new javax.swing.JButton();
        gray2 = new javax.swing.JLabel();
        rgb2 = new javax.swing.JLabel();
        jPanel16 = new javax.swing.JPanel();
        outR3 = new javax.swing.JPanel();
        outG3 = new javax.swing.JPanel();
        outB3 = new javax.swing.JPanel();
        outA3 = new javax.swing.JPanel();
        invertR3 = new javax.swing.JCheckBox();
        invertG3 = new javax.swing.JCheckBox();
        invertA3 = new javax.swing.JCheckBox();
        invertB3 = new javax.swing.JCheckBox();
        clear3 = new javax.swing.JButton();
        gray3 = new javax.swing.JLabel();
        rgb3 = new javax.swing.JLabel();
        jPanel21 = new javax.swing.JPanel();
        outR4 = new javax.swing.JPanel();
        outG4 = new javax.swing.JPanel();
        outB4 = new javax.swing.JPanel();
        outA4 = new javax.swing.JPanel();
        invertR4 = new javax.swing.JCheckBox();
        invertG4 = new javax.swing.JCheckBox();
        invertA4 = new javax.swing.JCheckBox();
        invertB4 = new javax.swing.JCheckBox();
        clear4 = new javax.swing.JButton();
        gray4 = new javax.swing.JLabel();
        rgb4 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        filler2 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 128), new java.awt.Dimension(0, 128), new java.awt.Dimension(32767, 128));
        jLabel7 = new javax.swing.JLabel();

        fileChooser.setFileFilter(new MyCustomFilter());

        folderChooser.setFileSelectionMode(javax.swing.JFileChooser.DIRECTORIES_ONLY);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Texture Remix (Java Alpha)");

        basePanel.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel1.setText("Output Folder:");

        jTextField1.setText((TextureRemix.savepath != "")?TextureRemix.savepath:"Select a folder");
        jTextField1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField1FocusLost(evt);
            }
        });

        folderButton.setText("Browse");
        folderButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                folderButtonActionPerformed(evt);
            }
        });

        jButton2.setText("Load Image(s)");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel1.setToolTipText("Input Images");

        Inbox1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Inbox1.setMaximumSize(new java.awt.Dimension(118, 131));

        Image1Caption.setText("Image 1");
        Image1Caption.setName(""); // NOI18N

        split1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        split1.setForeground(new java.awt.Color(204, 0, 0));
        split1.setText("|||");
        split1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        split1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                split1MouseClicked(evt);
            }
        });

        inR1.setBackground(new java.awt.Color(204, 0, 0));
        inR1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        inR1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        inR1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                inR1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                inR1MouseExited(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                inR1MouseReleased(evt);
            }
        });

        javax.swing.GroupLayout inR1Layout = new javax.swing.GroupLayout(inR1);
        inR1.setLayout(inR1Layout);
        inR1Layout.setHorizontalGroup(
            inR1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );
        inR1Layout.setVerticalGroup(
            inR1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        jPanel27.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel9.setText("C+A");
        jLabel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel9MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel27Layout = new javax.swing.GroupLayout(jPanel27);
        jPanel27.setLayout(jPanel27Layout);
        jPanel27Layout.setHorizontalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel27Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel27Layout.setVerticalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel27Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        inB1.setBackground(new java.awt.Color(64, 64, 204));
        inB1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        inB1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        inB1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                inB1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                inB1MouseExited(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                inB1MouseReleased(evt);
            }
        });

        javax.swing.GroupLayout inB1Layout = new javax.swing.GroupLayout(inB1);
        inB1.setLayout(inB1Layout);
        inB1Layout.setHorizontalGroup(
            inB1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );
        inB1Layout.setVerticalGroup(
            inB1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        inA1.setBackground(new java.awt.Color(153, 153, 153));
        inA1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        inA1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        inA1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                inA1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                inA1MouseExited(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                inA1MouseReleased(evt);
            }
        });

        javax.swing.GroupLayout inA1Layout = new javax.swing.GroupLayout(inA1);
        inA1.setLayout(inA1Layout);
        inA1Layout.setHorizontalGroup(
            inA1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );
        inA1Layout.setVerticalGroup(
            inA1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        inG1.setBackground(new java.awt.Color(0, 204, 0));
        inG1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        inG1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        inG1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                inG1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                inG1MouseExited(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                inG1MouseReleased(evt);
            }
        });

        javax.swing.GroupLayout inG1Layout = new javax.swing.GroupLayout(inG1);
        inG1.setLayout(inG1Layout);
        inG1Layout.setHorizontalGroup(
            inG1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );
        inG1Layout.setVerticalGroup(
            inG1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout Inbox1Layout = new javax.swing.GroupLayout(Inbox1);
        Inbox1.setLayout(Inbox1Layout);
        Inbox1Layout.setHorizontalGroup(
            Inbox1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Inbox1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Image1Caption, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(split1))
            .addGroup(Inbox1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(inR1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(inG1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(inB1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(inA1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jPanel27, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        Inbox1Layout.setVerticalGroup(
            Inbox1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Inbox1Layout.createSequentialGroup()
                .addGroup(Inbox1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Image1Caption)
                    .addComponent(split1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel27, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addGroup(Inbox1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Inbox1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(inR1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(inG1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(inA1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inB1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0))
        );

        Inbox2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Inbox2.setMaximumSize(new java.awt.Dimension(118, 131));

        Image2Caption.setText("Image 2");
        Image2Caption.setName("Image2Caption"); // NOI18N

        split2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        split2.setForeground(new java.awt.Color(204, 0, 0));
        split2.setText("|||");
        split2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        split2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                split2MouseClicked(evt);
            }
        });

        inR2.setBackground(new java.awt.Color(204, 0, 0));
        inR2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        inR2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        inR2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                inR2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                inR2MouseExited(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                inR2MouseReleased(evt);
            }
        });

        javax.swing.GroupLayout inR2Layout = new javax.swing.GroupLayout(inR2);
        inR2.setLayout(inR2Layout);
        inR2Layout.setHorizontalGroup(
            inR2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );
        inR2Layout.setVerticalGroup(
            inR2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        jPanel29.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel11.setText("C+A");
        jLabel11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel11MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel29Layout = new javax.swing.GroupLayout(jPanel29);
        jPanel29.setLayout(jPanel29Layout);
        jPanel29Layout.setHorizontalGroup(
            jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel29Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel29Layout.setVerticalGroup(
            jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel29Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        inB2.setBackground(new java.awt.Color(64, 64, 204));
        inB2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        inB2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        inB2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                inB2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                inB2MouseExited(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                inB2MouseReleased(evt);
            }
        });

        javax.swing.GroupLayout inB2Layout = new javax.swing.GroupLayout(inB2);
        inB2.setLayout(inB2Layout);
        inB2Layout.setHorizontalGroup(
            inB2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );
        inB2Layout.setVerticalGroup(
            inB2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        inA2.setBackground(new java.awt.Color(153, 153, 153));
        inA2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        inA2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        inA2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                inA2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                inA2MouseExited(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                inA2MouseReleased(evt);
            }
        });

        javax.swing.GroupLayout inA2Layout = new javax.swing.GroupLayout(inA2);
        inA2.setLayout(inA2Layout);
        inA2Layout.setHorizontalGroup(
            inA2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );
        inA2Layout.setVerticalGroup(
            inA2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        inG2.setBackground(new java.awt.Color(0, 204, 0));
        inG2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        inG2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        inG2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                inG2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                inG2MouseExited(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                inG2MouseReleased(evt);
            }
        });

        javax.swing.GroupLayout inG2Layout = new javax.swing.GroupLayout(inG2);
        inG2.setLayout(inG2Layout);
        inG2Layout.setHorizontalGroup(
            inG2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );
        inG2Layout.setVerticalGroup(
            inG2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout Inbox2Layout = new javax.swing.GroupLayout(Inbox2);
        Inbox2.setLayout(Inbox2Layout);
        Inbox2Layout.setHorizontalGroup(
            Inbox2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Inbox2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Image2Caption, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(split2))
            .addGroup(Inbox2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(inR2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(inG2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(inB2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(inA2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jPanel29, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        Inbox2Layout.setVerticalGroup(
            Inbox2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Inbox2Layout.createSequentialGroup()
                .addGroup(Inbox2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Image2Caption)
                    .addComponent(split2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel29, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addGroup(Inbox2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Inbox2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(inR2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(inG2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(inA2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inB2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0))
        );

        Inbox3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Inbox3.setMaximumSize(new java.awt.Dimension(118, 131));

        Image3Caption.setText("Image 3");

        split3.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        split3.setForeground(new java.awt.Color(204, 0, 0));
        split3.setText("|||");
        split3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        split3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                split3MouseClicked(evt);
            }
        });

        inR3.setBackground(new java.awt.Color(204, 0, 0));
        inR3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        inR3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        inR3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                inR3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                inR3MouseExited(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                inR3MouseReleased(evt);
            }
        });

        javax.swing.GroupLayout inR3Layout = new javax.swing.GroupLayout(inR3);
        inR3.setLayout(inR3Layout);
        inR3Layout.setHorizontalGroup(
            inR3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );
        inR3Layout.setVerticalGroup(
            inR3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        jPanel31.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel13.setText("C+A");
        jLabel13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel13MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel31Layout = new javax.swing.GroupLayout(jPanel31);
        jPanel31.setLayout(jPanel31Layout);
        jPanel31Layout.setHorizontalGroup(
            jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel31Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel13)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel31Layout.setVerticalGroup(
            jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel31Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel13)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        inB3.setBackground(new java.awt.Color(64, 64, 204));
        inB3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        inB3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        inB3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                inB3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                inB3MouseExited(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                inB3MouseReleased(evt);
            }
        });

        javax.swing.GroupLayout inB3Layout = new javax.swing.GroupLayout(inB3);
        inB3.setLayout(inB3Layout);
        inB3Layout.setHorizontalGroup(
            inB3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );
        inB3Layout.setVerticalGroup(
            inB3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        inA3.setBackground(new java.awt.Color(153, 153, 153));
        inA3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        inA3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        inA3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                inA3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                inA3MouseExited(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                inA3MouseReleased(evt);
            }
        });

        javax.swing.GroupLayout inA3Layout = new javax.swing.GroupLayout(inA3);
        inA3.setLayout(inA3Layout);
        inA3Layout.setHorizontalGroup(
            inA3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );
        inA3Layout.setVerticalGroup(
            inA3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        inG3.setBackground(new java.awt.Color(0, 204, 0));
        inG3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        inG3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        inG3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                inG3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                inG3MouseExited(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                inG3MouseReleased(evt);
            }
        });

        javax.swing.GroupLayout inG3Layout = new javax.swing.GroupLayout(inG3);
        inG3.setLayout(inG3Layout);
        inG3Layout.setHorizontalGroup(
            inG3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );
        inG3Layout.setVerticalGroup(
            inG3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout Inbox3Layout = new javax.swing.GroupLayout(Inbox3);
        Inbox3.setLayout(Inbox3Layout);
        Inbox3Layout.setHorizontalGroup(
            Inbox3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Inbox3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Image3Caption, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(split3))
            .addGroup(Inbox3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(inR3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(inG3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(inB3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(inA3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jPanel31, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        Inbox3Layout.setVerticalGroup(
            Inbox3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Inbox3Layout.createSequentialGroup()
                .addGroup(Inbox3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(split3)
                    .addGroup(Inbox3Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(Image3Caption)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel31, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addGroup(Inbox3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Inbox3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(inR3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(inG3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(inA3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inB3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0))
        );

        Inbox4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Inbox4.setMaximumSize(new java.awt.Dimension(118, 131));

        Image4Caption.setText("Image 4");

        split4.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        split4.setForeground(new java.awt.Color(204, 0, 0));
        split4.setText("|||");
        split4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        split4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                split4MouseClicked(evt);
            }
        });

        inR4.setBackground(new java.awt.Color(204, 0, 0));
        inR4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        inR4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        inR4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                inR4MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                inR4MouseExited(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                inR4MouseReleased(evt);
            }
        });

        javax.swing.GroupLayout inR4Layout = new javax.swing.GroupLayout(inR4);
        inR4.setLayout(inR4Layout);
        inR4Layout.setHorizontalGroup(
            inR4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );
        inR4Layout.setVerticalGroup(
            inR4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        jPanel33.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel14.setText("C+A");
        jLabel14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel14MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel33Layout = new javax.swing.GroupLayout(jPanel33);
        jPanel33.setLayout(jPanel33Layout);
        jPanel33Layout.setHorizontalGroup(
            jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel33Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel14)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel33Layout.setVerticalGroup(
            jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel33Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel14)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        inB4.setBackground(new java.awt.Color(64, 64, 204));
        inB4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        inB4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        inB4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                inB4MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                inB4MouseExited(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                inB4MouseReleased(evt);
            }
        });

        javax.swing.GroupLayout inB4Layout = new javax.swing.GroupLayout(inB4);
        inB4.setLayout(inB4Layout);
        inB4Layout.setHorizontalGroup(
            inB4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );
        inB4Layout.setVerticalGroup(
            inB4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        inA4.setBackground(new java.awt.Color(153, 153, 153));
        inA4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        inA4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        inA4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                inA4MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                inA4MouseExited(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                inA4MouseReleased(evt);
            }
        });

        javax.swing.GroupLayout inA4Layout = new javax.swing.GroupLayout(inA4);
        inA4.setLayout(inA4Layout);
        inA4Layout.setHorizontalGroup(
            inA4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );
        inA4Layout.setVerticalGroup(
            inA4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        inG4.setBackground(new java.awt.Color(0, 204, 0));
        inG4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        inG4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        inG4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                inG4MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                inG4MouseExited(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                inG4MouseReleased(evt);
            }
        });

        javax.swing.GroupLayout inG4Layout = new javax.swing.GroupLayout(inG4);
        inG4.setLayout(inG4Layout);
        inG4Layout.setHorizontalGroup(
            inG4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );
        inG4Layout.setVerticalGroup(
            inG4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout Inbox4Layout = new javax.swing.GroupLayout(Inbox4);
        Inbox4.setLayout(Inbox4Layout);
        Inbox4Layout.setHorizontalGroup(
            Inbox4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Inbox4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Image4Caption, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(split4))
            .addGroup(Inbox4Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(inR4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(inG4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(inB4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(inA4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jPanel33, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        Inbox4Layout.setVerticalGroup(
            Inbox4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Inbox4Layout.createSequentialGroup()
                .addGroup(Inbox4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Image4Caption)
                    .addComponent(split4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel33, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addGroup(Inbox4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Inbox4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(inR4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(inG4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(inA4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inB4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Inbox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Inbox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Inbox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Inbox4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(filler1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(filler1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Inbox4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Inbox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Inbox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Inbox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButton3.setText("Add Output Image");
        jButton3.setEnabled(false);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        DebugPanel.setBackground(new java.awt.Color(238, 216, 169));
        DebugPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        DebugPanel.setName(""); // NOI18N

        jLabel2.setText("Input");

        jLabel3.setText("Output");

        debugOutput.setText("1");

        jLabel4.setText("From Ch");

        jLabel5.setText("To Ch");

        debugLinker.setText("Add Link");
        debugLinker.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                debugLinkerActionPerformed(evt);
            }
        });

        debugSplitter.setText("Split Input");
        debugSplitter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                debugSplitterActionPerformed(evt);
            }
        });

        debugInverter.setText("Invert To Ch");
        debugInverter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                debugInverterActionPerformed(evt);
            }
        });

        debugReverser.setText("Reverse");
        debugReverser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                debugReverserActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout DebugPanelLayout = new javax.swing.GroupLayout(DebugPanel);
        DebugPanel.setLayout(DebugPanelLayout);
        DebugPanelLayout.setHorizontalGroup(
            DebugPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DebugPanelLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(DebugPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(DebugPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(debugInput)
                    .addComponent(debugOutput, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(DebugPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(DebugPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(DebugPanelLayout.createSequentialGroup()
                        .addComponent(debugFromCh, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(debugLinker)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(debugSplitter))
                    .addGroup(DebugPanelLayout.createSequentialGroup()
                        .addComponent(debugToCh, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(debugInverter)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(debugReverser)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        DebugPanelLayout.setVerticalGroup(
            DebugPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DebugPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(DebugPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(debugInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4)
                    .addComponent(debugFromCh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(debugLinker)
                    .addComponent(debugSplitter))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(DebugPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(DebugPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(debugOutput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5)
                        .addComponent(debugToCh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(DebugPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(debugInverter)
                        .addComponent(debugReverser)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel2.setToolTipText("Output Images");

        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        outR1.setBackground(new java.awt.Color(204, 0, 0));
        outR1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        outR1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        outR1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                outR1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                outR1MouseExited(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                outR1MouseReleased(evt);
            }
        });

        javax.swing.GroupLayout outR1Layout = new javax.swing.GroupLayout(outR1);
        outR1.setLayout(outR1Layout);
        outR1Layout.setHorizontalGroup(
            outR1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );
        outR1Layout.setVerticalGroup(
            outR1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        outG1.setBackground(new java.awt.Color(0, 204, 0));
        outG1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        outG1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        outG1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                outG1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                outG1MouseExited(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                outG1MouseReleased(evt);
            }
        });

        javax.swing.GroupLayout outG1Layout = new javax.swing.GroupLayout(outG1);
        outG1.setLayout(outG1Layout);
        outG1Layout.setHorizontalGroup(
            outG1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );
        outG1Layout.setVerticalGroup(
            outG1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        outB1.setBackground(new java.awt.Color(64, 64, 204));
        outB1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        outB1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        outB1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                outB1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                outB1MouseExited(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                outB1MouseReleased(evt);
            }
        });

        javax.swing.GroupLayout outB1Layout = new javax.swing.GroupLayout(outB1);
        outB1.setLayout(outB1Layout);
        outB1Layout.setHorizontalGroup(
            outB1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );
        outB1Layout.setVerticalGroup(
            outB1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        outA1.setBackground(new java.awt.Color(153, 153, 153));
        outA1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        outA1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        outA1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                outA1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                outA1MouseExited(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                outA1MouseReleased(evt);
            }
        });

        javax.swing.GroupLayout outA1Layout = new javax.swing.GroupLayout(outA1);
        outA1.setLayout(outA1Layout);
        outA1Layout.setHorizontalGroup(
            outA1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );
        outA1Layout.setVerticalGroup(
            outA1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        invertR1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                invertR1ActionPerformed(evt);
            }
        });

        invertG1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                invertG1ActionPerformed(evt);
            }
        });

        invertA1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                invertA1ActionPerformed(evt);
            }
        });

        invertB1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                invertB1ActionPerformed(evt);
            }
        });

        clear1.setText("Clear");
        clear1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clear1ActionPerformed(evt);
            }
        });

        gray1.setText("G");
        gray1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                gray1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                gray1MouseExited(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                gray1MouseReleased(evt);
            }
        });

        rgb1.setText("RGB");
        rgb1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                rgb1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                rgb1MouseExited(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                rgb1MouseReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addComponent(clear1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(outR1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(invertR1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(outG1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(outB1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(invertG1)
                                .addGap(9, 9, 9)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(rgb1)
                                    .addComponent(invertB1)))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(gray1)))
                .addGap(6, 6, 6)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(invertA1)
                    .addComponent(outA1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(outR1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(outG1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(outB1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(outA1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(invertG1)
                    .addComponent(invertR1)
                    .addComponent(invertB1)
                    .addComponent(invertA1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(gray1)
                    .addComponent(rgb1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(clear1))
        );

        jPanel11.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        outR2.setBackground(new java.awt.Color(204, 0, 0));
        outR2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        outR2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        outR2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                outR2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                outR2MouseExited(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                outR2MouseReleased(evt);
            }
        });

        javax.swing.GroupLayout outR2Layout = new javax.swing.GroupLayout(outR2);
        outR2.setLayout(outR2Layout);
        outR2Layout.setHorizontalGroup(
            outR2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );
        outR2Layout.setVerticalGroup(
            outR2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        outG2.setBackground(new java.awt.Color(0, 204, 0));
        outG2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        outG2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        outG2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                outG2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                outG2MouseExited(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                outG2MouseReleased(evt);
            }
        });

        javax.swing.GroupLayout outG2Layout = new javax.swing.GroupLayout(outG2);
        outG2.setLayout(outG2Layout);
        outG2Layout.setHorizontalGroup(
            outG2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );
        outG2Layout.setVerticalGroup(
            outG2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        outB2.setBackground(new java.awt.Color(64, 64, 204));
        outB2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        outB2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        outB2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                outB2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                outB2MouseExited(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                outB2MouseReleased(evt);
            }
        });

        javax.swing.GroupLayout outB2Layout = new javax.swing.GroupLayout(outB2);
        outB2.setLayout(outB2Layout);
        outB2Layout.setHorizontalGroup(
            outB2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );
        outB2Layout.setVerticalGroup(
            outB2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        outA2.setBackground(new java.awt.Color(153, 153, 153));
        outA2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        outA2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        outA2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                outA2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                outA2MouseExited(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                outA2MouseReleased(evt);
            }
        });

        javax.swing.GroupLayout outA2Layout = new javax.swing.GroupLayout(outA2);
        outA2.setLayout(outA2Layout);
        outA2Layout.setHorizontalGroup(
            outA2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );
        outA2Layout.setVerticalGroup(
            outA2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        invertR2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                invertR2ActionPerformed(evt);
            }
        });

        invertG2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                invertG2ActionPerformed(evt);
            }
        });

        invertA2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                invertA2ActionPerformed(evt);
            }
        });

        invertB2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                invertB2ActionPerformed(evt);
            }
        });

        clear2.setText("Clear");
        clear2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clear2ActionPerformed(evt);
            }
        });

        gray2.setText("G");
        gray2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                gray2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                gray2MouseExited(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                gray2MouseReleased(evt);
            }
        });

        rgb2.setText("RGB");
        rgb2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                rgb2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                rgb2MouseExited(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                rgb2MouseReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addComponent(clear2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(outR2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(invertR2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel11Layout.createSequentialGroup()
                                .addComponent(outG2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(outB2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel11Layout.createSequentialGroup()
                                .addComponent(invertG2)
                                .addGap(9, 9, 9)
                                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(rgb2)
                                    .addComponent(invertB2))))
                        .addGap(6, 6, 6)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(invertA2)
                            .addComponent(outA2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(gray2)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(outR2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(outG2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(outB2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(outA2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(invertG2)
                    .addComponent(invertR2)
                    .addComponent(invertB2)
                    .addComponent(invertA2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(gray2)
                    .addComponent(rgb2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(clear2))
        );

        jPanel16.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        outR3.setBackground(new java.awt.Color(204, 0, 0));
        outR3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        outR3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        outR3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                outR3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                outR3MouseExited(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                outR3MouseReleased(evt);
            }
        });

        javax.swing.GroupLayout outR3Layout = new javax.swing.GroupLayout(outR3);
        outR3.setLayout(outR3Layout);
        outR3Layout.setHorizontalGroup(
            outR3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );
        outR3Layout.setVerticalGroup(
            outR3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        outG3.setBackground(new java.awt.Color(0, 204, 0));
        outG3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        outG3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        outG3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                outG3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                outG3MouseExited(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                outG3MouseReleased(evt);
            }
        });

        javax.swing.GroupLayout outG3Layout = new javax.swing.GroupLayout(outG3);
        outG3.setLayout(outG3Layout);
        outG3Layout.setHorizontalGroup(
            outG3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );
        outG3Layout.setVerticalGroup(
            outG3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        outB3.setBackground(new java.awt.Color(64, 64, 204));
        outB3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        outB3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        outB3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                outB3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                outB3MouseExited(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                outB3MouseReleased(evt);
            }
        });

        javax.swing.GroupLayout outB3Layout = new javax.swing.GroupLayout(outB3);
        outB3.setLayout(outB3Layout);
        outB3Layout.setHorizontalGroup(
            outB3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );
        outB3Layout.setVerticalGroup(
            outB3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        outA3.setBackground(new java.awt.Color(153, 153, 153));
        outA3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        outA3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        outA3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                outA3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                outA3MouseExited(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                outA3MouseReleased(evt);
            }
        });

        javax.swing.GroupLayout outA3Layout = new javax.swing.GroupLayout(outA3);
        outA3.setLayout(outA3Layout);
        outA3Layout.setHorizontalGroup(
            outA3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );
        outA3Layout.setVerticalGroup(
            outA3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        invertR3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                invertR3ActionPerformed(evt);
            }
        });

        invertG3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                invertG3ActionPerformed(evt);
            }
        });

        invertA3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                invertA3ActionPerformed(evt);
            }
        });

        invertB3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                invertB3ActionPerformed(evt);
            }
        });

        clear3.setText("Clear");
        clear3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clear3ActionPerformed(evt);
            }
        });

        gray3.setText("G");
        gray3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                gray3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                gray3MouseExited(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                gray3MouseReleased(evt);
            }
        });

        rgb3.setText("RGB");
        rgb3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                rgb3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                rgb3MouseExited(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                rgb3MouseReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel16Layout.createSequentialGroup()
                .addComponent(clear3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(outR3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(invertR3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel16Layout.createSequentialGroup()
                                .addComponent(outG3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(outB3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel16Layout.createSequentialGroup()
                                .addComponent(invertG3)
                                .addGap(9, 9, 9)
                                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(rgb3)
                                    .addComponent(invertB3))))
                        .addGap(6, 6, 6)
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(invertA3)
                            .addComponent(outA3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(gray3)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(outR3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(outG3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(outB3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(outA3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(invertG3)
                    .addComponent(invertR3)
                    .addComponent(invertB3)
                    .addComponent(invertA3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(gray3)
                    .addComponent(rgb3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(clear3))
        );

        jPanel21.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        outR4.setBackground(new java.awt.Color(204, 0, 0));
        outR4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        outR4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        outR4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                outR4MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                outR4MouseExited(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                outR4MouseReleased(evt);
            }
        });

        javax.swing.GroupLayout outR4Layout = new javax.swing.GroupLayout(outR4);
        outR4.setLayout(outR4Layout);
        outR4Layout.setHorizontalGroup(
            outR4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );
        outR4Layout.setVerticalGroup(
            outR4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        outG4.setBackground(new java.awt.Color(0, 204, 0));
        outG4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        outG4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        outG4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                outG4MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                outG4MouseExited(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                outG4MouseReleased(evt);
            }
        });

        javax.swing.GroupLayout outG4Layout = new javax.swing.GroupLayout(outG4);
        outG4.setLayout(outG4Layout);
        outG4Layout.setHorizontalGroup(
            outG4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );
        outG4Layout.setVerticalGroup(
            outG4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        outB4.setBackground(new java.awt.Color(64, 64, 204));
        outB4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        outB4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        outB4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                outB4MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                outB4MouseExited(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                outB4MouseReleased(evt);
            }
        });

        javax.swing.GroupLayout outB4Layout = new javax.swing.GroupLayout(outB4);
        outB4.setLayout(outB4Layout);
        outB4Layout.setHorizontalGroup(
            outB4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );
        outB4Layout.setVerticalGroup(
            outB4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        outA4.setBackground(new java.awt.Color(153, 153, 153));
        outA4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        outA4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        outA4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                outA4MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                outA4MouseExited(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                outA4MouseReleased(evt);
            }
        });

        javax.swing.GroupLayout outA4Layout = new javax.swing.GroupLayout(outA4);
        outA4.setLayout(outA4Layout);
        outA4Layout.setHorizontalGroup(
            outA4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );
        outA4Layout.setVerticalGroup(
            outA4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        invertR4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                invertR4ActionPerformed(evt);
            }
        });

        invertG4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                invertG4ActionPerformed(evt);
            }
        });

        invertA4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                invertA4ActionPerformed(evt);
            }
        });

        invertB4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                invertB4ActionPerformed(evt);
            }
        });

        clear4.setText("Clear");
        clear4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clear4ActionPerformed(evt);
            }
        });

        gray4.setText("G");
        gray4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                gray4MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                gray4MouseExited(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                gray4MouseReleased(evt);
            }
        });

        rgb4.setText("RGB");
        rgb4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                rgb4MouseReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel21Layout.createSequentialGroup()
                .addComponent(clear4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel21Layout.createSequentialGroup()
                        .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(outR4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(invertR4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel21Layout.createSequentialGroup()
                                .addComponent(outG4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(outB4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel21Layout.createSequentialGroup()
                                .addComponent(invertG4)
                                .addGap(9, 9, 9)
                                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(rgb4)
                                    .addComponent(invertB4))))
                        .addGap(6, 6, 6)
                        .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(invertA4)
                            .addComponent(outA4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel21Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(gray4)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(outR4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(outG4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(outB4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(outA4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(invertG4)
                    .addComponent(invertR4)
                    .addComponent(invertB4)
                    .addComponent(invertA4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(gray4)
                    .addComponent(rgb4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(clear4))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel21, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(31, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButton4.setText("Save Images");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel7.setText("(or drag-and-drop into the top box)");

        javax.swing.GroupLayout basePanelLayout = new javax.swing.GroupLayout(basePanel);
        basePanel.setLayout(basePanelLayout);
        basePanelLayout.setHorizontalGroup(
            basePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(basePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(basePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(basePanelLayout.createSequentialGroup()
                        .addGroup(basePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(basePanelLayout.createSequentialGroup()
                                .addComponent(jButton2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel7))
                            .addComponent(jButton3)
                            .addGroup(basePanelLayout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(folderButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton4)))
                        .addGap(0, 8, Short.MAX_VALUE))
                    .addGroup(basePanelLayout.createSequentialGroup()
                        .addComponent(filler2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(DebugPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        basePanelLayout.setVerticalGroup(
            basePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(basePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(basePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(basePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(basePanelLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(filler2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(basePanelLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(DebugPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(basePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(folderButton)
                    .addComponent(jButton4)))
        );

        new FileDrop(jPanel1, new FileDrop.Listener(){
            public void  filesDropped( java.io.File[] files ) {
                for( int i = 0; i < files.length; i++ ) {
                    String path = files[i].getAbsolutePath();
                    TextureRemix.loadInput(path);
                }
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(basePanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(basePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //https://netbeans.org/kb/docs/java/gui-filechooser.html
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        int returnVal = fileChooser.showOpenDialog(this);
        if (returnVal == fileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            String path = file.getAbsolutePath();
            TextureRemix.loadInput(path);
        } else {
            System.out.println("File access cancelled by user.");
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    //https://netbeans.org/kb/docs/java/gui-filechooser.html
    private void folderButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_folderButtonActionPerformed
        int returnVal = folderChooser.showOpenDialog(this);
        if (returnVal == folderChooser.APPROVE_OPTION) {
            File file = folderChooser.getSelectedFile();
            jTextField1.setText(file.getAbsolutePath());
            TextureRemix.setPath(file.getAbsolutePath());
        } else {
            System.out.println("File access cancelled by user.");
        }
    }//GEN-LAST:event_folderButtonActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        TextureRemix.saveAll();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void debugLinkerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_debugLinkerActionPerformed
        int in = Integer.parseInt(debugInput.getText());
        int out = Integer.parseInt(debugOutput.getText());
        if (in < 1 || out < 1 || debugFromCh.getText().length() < 1 || debugToCh.getText().length() < 1) {
            System.out.println("Nope.");
            return;
        }
        char fromch = debugFromCh.getText().charAt(0);
        char toch = debugToCh.getText().charAt(0);
        TextureRemix.outputs.get(out).setLink(toch, in, fromch);
    }//GEN-LAST:event_debugLinkerActionPerformed

    private void debugSplitterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_debugSplitterActionPerformed
        int in = Integer.parseInt(debugInput.getText());
        if (in < 1) {
            System.out.println("Nope.");
            return;
        }
        TextureRemix.splitImage(in);
    }//GEN-LAST:event_debugSplitterActionPerformed

    private void debugInverterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_debugInverterActionPerformed
        int out = Integer.parseInt(debugOutput.getText());
        if (out < 1 || debugToCh.getText().length() < 1) {
            System.out.println("Nope.");
            return;
        }
        char toch = debugToCh.getText().charAt(0);
        if (toch == 'r') {
            TextureRemix.outputs.get(out).invertRed = !TextureRemix.outputs.get(out).invertRed;
        }
        if (toch == 'g') {
            TextureRemix.outputs.get(out).invertGreen = !TextureRemix.outputs.get(out).invertGreen;
        }
        if (toch == 'b') {
            TextureRemix.outputs.get(out).invertBlue = !TextureRemix.outputs.get(out).invertBlue;
        }
        if (toch == 'a') {
            TextureRemix.outputs.get(out).invertAlpha = !TextureRemix.outputs.get(out).invertAlpha;
        }
    }//GEN-LAST:event_debugInverterActionPerformed

    private void debugReverserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_debugReverserActionPerformed
        int in = Integer.parseInt(debugInput.getText());
        int out = Integer.parseInt(debugOutput.getText());
        if (in < 1 || out < 1) {
            System.out.println("Nope.");
            return;
        }
        TextureRemix.outputs.get(out).setLink('r', in, 'a');
        TextureRemix.outputs.get(out).setLink('g', in, 'a');
        TextureRemix.outputs.get(out).setLink('b', in, 'a');
        TextureRemix.outputs.get(out).setLink('a', in, 'r');
        TextureRemix.outputs.get(out).generateImage();
    }//GEN-LAST:event_debugReverserActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        int id = outputcount;
        TextureRemix.addOutput();

        //generate output box
        javax.swing.JPanel out = new javax.swing.JPanel();
        outputBoxes.add(id, out);
        out.setSize(100, 120);
        out.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        out.setLocation(10, 6);
        //add label
        javax.swing.JLabel name = new javax.swing.JLabel("Image "+id);
        out.add(name);
        //add ports
        //Red
        javax.swing.JPanel portR = new javax.swing.JPanel();
        portR.setSize(20, 24);
        portR.setBackground(Color.red);
        portR.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        portR.setLocation(4, 0);
        out.add(portR);
        //Green
        javax.swing.JPanel portG = new javax.swing.JPanel();
        portG.setSize(20, 24);
        portG.setBackground(Color.green);
        portG.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        portG.setLocation(28, 0);
        out.add(portG);
        //Blue
        javax.swing.JPanel portB = new javax.swing.JPanel();
        portB.setSize(20, 24);
        portB.setBackground(Color.blue);
        portB.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        portB.setLocation(52, 0);
        out.add(portB);
        //Alpha
        javax.swing.JPanel portA = new javax.swing.JPanel();
        portA.setSize(20, 24);
        portA.setBackground(Color.gray);
        portA.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        portA.setLocation(76, 0);
        out.add(portA);
        //finished
        jPanel2.add(out);
        //update display??????????
        validate();
        out.repaint();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void clear1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clear1ActionPerformed
        TextureRemix.outputs.get(1).setLink('r', 0, 'x');
        TextureRemix.outputs.get(1).setLink('g', 0, 'x');
        TextureRemix.outputs.get(1).setLink('b', 0, 'x');
        TextureRemix.outputs.get(1).setLink('a', 0, 'x');
    }//GEN-LAST:event_clear1ActionPerformed

    private void clear2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clear2ActionPerformed
        TextureRemix.outputs.get(2).setLink('r', 0, 'x');
        TextureRemix.outputs.get(2).setLink('g', 0, 'x');
        TextureRemix.outputs.get(2).setLink('b', 0, 'x');
        TextureRemix.outputs.get(2).setLink('a', 0, 'x');
    }//GEN-LAST:event_clear2ActionPerformed

    private void clear3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clear3ActionPerformed
        TextureRemix.outputs.get(3).setLink('r', 0, 'x');
        TextureRemix.outputs.get(3).setLink('g', 0, 'x');
        TextureRemix.outputs.get(3).setLink('b', 0, 'x');
        TextureRemix.outputs.get(3).setLink('a', 0, 'x');
    }//GEN-LAST:event_clear3ActionPerformed

    private void clear4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clear4ActionPerformed
        TextureRemix.outputs.get(4).setLink('r', 0, 'x');
        TextureRemix.outputs.get(4).setLink('g', 0, 'x');
        TextureRemix.outputs.get(4).setLink('b', 0, 'x');
        TextureRemix.outputs.get(4).setLink('a', 0, 'x');
    }//GEN-LAST:event_clear4ActionPerformed

    public static void ShowError( String msg, String headline ) {
        JOptionPane.showMessageDialog(null, msg, headline, JOptionPane.ERROR_MESSAGE );
    }
    
    public static void ShowMessage( String msg, String headline ) {
        JOptionPane.showMessageDialog(null, msg, headline, JOptionPane.INFORMATION_MESSAGE );
    }
    
    private void ResetSelection() {
        inR1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        inG1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        inB1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        inA1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        inR2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        inG2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        inB2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        inA2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        inR3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        inG3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        inB3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        inA3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        inR4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        inG4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        inB4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        inA4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
    }
    
    private javax.swing.JPanel GetInPanel(char chan, int id) {
        if (chan == 'r') {
            switch(id) {
                case 1: return inR1;
                case 2: return inR2;
                case 3: return inR3;
                case 4: return inR4;
            }
        }
        if (chan == 'g') {
            switch(id) {
                case 1: return inG1;
                case 2: return inG2;
                case 3: return inG3;
                case 4: return inG4;
            }
        }
        if (chan == 'b') {
            switch(id) {
                case 1: return inB1;
                case 2: return inB2;
                case 3: return inB3;
                case 4: return inB4;
            }
        }
        if (chan == 'a') {
            switch(id) {
                case 1: return inA1;
                case 2: return inA2;
                case 3: return inA3;
                case 4: return inA4;
            }
        }
        return null;
    }
    
    private void SetSelection(char inchan, int inid) {
        clickchan = inchan;
        clickid = inid;
        ResetSelection();
        javax.swing.JPanel v = GetInPanel(clickchan, clickid);
        if (v != null) {
            v.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        }
    }
    
    private void invertR1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_invertR1ActionPerformed
        TextureRemix.outputs.get(1).invertRed = invertR1.isSelected();
    }//GEN-LAST:event_invertR1ActionPerformed

    private void invertG1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_invertG1ActionPerformed
        TextureRemix.outputs.get(1).invertGreen = invertG1.isSelected();
    }//GEN-LAST:event_invertG1ActionPerformed

    private void invertB1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_invertB1ActionPerformed
        TextureRemix.outputs.get(1).invertBlue = invertB1.isSelected();
    }//GEN-LAST:event_invertB1ActionPerformed

    private void invertA1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_invertA1ActionPerformed
        TextureRemix.outputs.get(1).invertAlpha = invertA1.isSelected();
    }//GEN-LAST:event_invertA1ActionPerformed

    private void invertR2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_invertR2ActionPerformed
        TextureRemix.outputs.get(2).invertRed = invertR2.isSelected();
    }//GEN-LAST:event_invertR2ActionPerformed

    private void invertG2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_invertG2ActionPerformed
        TextureRemix.outputs.get(2).invertGreen = invertG2.isSelected();
    }//GEN-LAST:event_invertG2ActionPerformed

    private void invertB2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_invertB2ActionPerformed
        TextureRemix.outputs.get(2).invertBlue = invertB2.isSelected();
    }//GEN-LAST:event_invertB2ActionPerformed

    private void invertA2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_invertA2ActionPerformed
        TextureRemix.outputs.get(2).invertAlpha = invertA2.isSelected();
    }//GEN-LAST:event_invertA2ActionPerformed

    private void invertR3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_invertR3ActionPerformed
        TextureRemix.outputs.get(3).invertRed = invertR3.isSelected();
    }//GEN-LAST:event_invertR3ActionPerformed

    private void invertG3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_invertG3ActionPerformed
        TextureRemix.outputs.get(3).invertGreen = invertG3.isSelected();
    }//GEN-LAST:event_invertG3ActionPerformed

    private void invertB3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_invertB3ActionPerformed
        TextureRemix.outputs.get(3).invertBlue = invertB3.isSelected();
    }//GEN-LAST:event_invertB3ActionPerformed

    private void invertA3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_invertA3ActionPerformed
        TextureRemix.outputs.get(3).invertAlpha = invertA3.isSelected();
    }//GEN-LAST:event_invertA3ActionPerformed

    private void invertR4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_invertR4ActionPerformed
        TextureRemix.outputs.get(4).invertRed = invertR4.isSelected();
    }//GEN-LAST:event_invertR4ActionPerformed

    private void invertG4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_invertG4ActionPerformed
        TextureRemix.outputs.get(4).invertGreen = invertG4.isSelected();
    }//GEN-LAST:event_invertG4ActionPerformed

    private void invertB4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_invertB4ActionPerformed
        TextureRemix.outputs.get(4).invertBlue = invertB4.isSelected();
    }//GEN-LAST:event_invertB4ActionPerformed

    private void invertA4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_invertA4ActionPerformed
        TextureRemix.outputs.get(4).invertAlpha = invertA4.isSelected();
    }//GEN-LAST:event_invertA4ActionPerformed

    private void split1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_split1MouseClicked
        //temp until proper dynamic layout is implemented
        TextureRemix.splitImage(1);
    }//GEN-LAST:event_split1MouseClicked

    private void split2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_split2MouseClicked
        //temp until proper dynamic layout is implemented
        TextureRemix.splitImage(2);
    }//GEN-LAST:event_split2MouseClicked

    private void split3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_split3MouseClicked
        //temp until proper dynamic layout is implemented
        TextureRemix.splitImage(3);
    }//GEN-LAST:event_split3MouseClicked

    private void split4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_split4MouseClicked
        //temp until proper dynamic layout is implemented
        TextureRemix.splitImage(4);
    }//GEN-LAST:event_split4MouseClicked

    private void jLabel9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseClicked
        TextureRemix.splitAlpha(1);
    }//GEN-LAST:event_jLabel9MouseClicked

    private void jLabel11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseClicked
        TextureRemix.splitAlpha(2);
    }//GEN-LAST:event_jLabel11MouseClicked

    private void jLabel13MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel13MouseClicked
        TextureRemix.splitAlpha(3);
    }//GEN-LAST:event_jLabel13MouseClicked

    private void jLabel14MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel14MouseClicked
        TextureRemix.splitAlpha(4);
    }//GEN-LAST:event_jLabel14MouseClicked

    private void inR1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_inR1MouseReleased
        //temp until proper dynamic layout is made
        SetSelection('r', 1);
    }//GEN-LAST:event_inR1MouseReleased

    private void inG1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_inG1MouseReleased
        //temp until proper dynamic layout is made
        SetSelection('g', 1);
    }//GEN-LAST:event_inG1MouseReleased

    private void inB1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_inB1MouseReleased
        //temp until proper dynamic layout is made
        SetSelection('b', 1);
    }//GEN-LAST:event_inB1MouseReleased

    private void inA1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_inA1MouseReleased
        //temp until proper dynamic layout is made
        SetSelection('a', 1);
    }//GEN-LAST:event_inA1MouseReleased

    private void inR2MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_inR2MouseReleased
        //temp until proper dynamic layout is made
        SetSelection('r', 2);
    }//GEN-LAST:event_inR2MouseReleased

    private void inG2MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_inG2MouseReleased
        //temp until proper dynamic layout is made
        SetSelection('g', 2);
    }//GEN-LAST:event_inG2MouseReleased

    private void inB2MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_inB2MouseReleased
        //temp until proper dynamic layout is made
        SetSelection('b', 2);
    }//GEN-LAST:event_inB2MouseReleased

    private void inA2MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_inA2MouseReleased
        //temp until proper dynamic layout is made
        SetSelection('a', 2);
    }//GEN-LAST:event_inA2MouseReleased

    private void inR3MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_inR3MouseReleased
        //temp until proper dynamic layout is made
        SetSelection('r', 3);
    }//GEN-LAST:event_inR3MouseReleased

    private void inG3MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_inG3MouseReleased
        //temp until proper dynamic layout is made
        SetSelection('g', 3);
    }//GEN-LAST:event_inG3MouseReleased

    private void inB3MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_inB3MouseReleased
        //temp until proper dynamic layout is made
        SetSelection('b', 3);
    }//GEN-LAST:event_inB3MouseReleased

    private void inA3MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_inA3MouseReleased
        //temp until proper dynamic layout is made
        SetSelection('a', 3);
    }//GEN-LAST:event_inA3MouseReleased

    private void inR4MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_inR4MouseReleased
        //temp until proper dynamic layout is made
        SetSelection('r', 4);
    }//GEN-LAST:event_inR4MouseReleased

    private void inG4MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_inG4MouseReleased
        //temp until proper dynamic layout is made
        SetSelection('g', 4);
    }//GEN-LAST:event_inG4MouseReleased

    private void inB4MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_inB4MouseReleased
        //temp until proper dynamic layout is made
        SetSelection('b', 4);
    }//GEN-LAST:event_inB4MouseReleased

    private void inA4MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_inA4MouseReleased
        //temp until proper dynamic layout is made
        SetSelection('a', 4);
    }//GEN-LAST:event_inA4MouseReleased

    private void outR1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_outR1MouseReleased
        if (clickid < 1) {
            TextureRemix.outputs.get(1).setLink('r', 0, 'x');
            return;
        }
        TextureRemix.outputs.get(1).setLink('r', clickid, clickchan);
        SetSelection('x', 0);
    }//GEN-LAST:event_outR1MouseReleased

    private void outG1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_outG1MouseReleased
        if (clickid < 1) {
            TextureRemix.outputs.get(1).setLink('g', 0, 'x');
            return;
        }
        TextureRemix.outputs.get(1).setLink('g', clickid, clickchan);
        SetSelection('x', 0);
    }//GEN-LAST:event_outG1MouseReleased

    private void outB1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_outB1MouseReleased
        if (clickid < 1) {
            TextureRemix.outputs.get(1).setLink('b', 0, 'x');
            return;
        }
        TextureRemix.outputs.get(1).setLink('b', clickid, clickchan);
        SetSelection('x', 0);
    }//GEN-LAST:event_outB1MouseReleased

    private void outA1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_outA1MouseReleased
        if (clickid < 1) {
            TextureRemix.outputs.get(1).setLink('a', 0, 'x');
            return;
        }
        TextureRemix.outputs.get(1).setLink('a', clickid, clickchan);
        SetSelection('x', 0);
    }//GEN-LAST:event_outA1MouseReleased

    private void outR2MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_outR2MouseReleased
        if (clickid < 1) {
            TextureRemix.outputs.get(2).setLink('r', 0, 'x');
            return;
        }
        TextureRemix.outputs.get(2).setLink('r', clickid, clickchan);
        SetSelection('x', 0);
    }//GEN-LAST:event_outR2MouseReleased

    private void outG2MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_outG2MouseReleased
        if (clickid < 1) {
            TextureRemix.outputs.get(2).setLink('g', 0, 'x');
            return;
        }
        TextureRemix.outputs.get(2).setLink('g', clickid, clickchan);
        SetSelection('x', 0);
    }//GEN-LAST:event_outG2MouseReleased

    private void outB2MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_outB2MouseReleased
        if (clickid < 1) {
            TextureRemix.outputs.get(2).setLink('b', 0, 'x');
            return;
        }
        TextureRemix.outputs.get(2).setLink('b', clickid, clickchan);
        SetSelection('x', 0);
    }//GEN-LAST:event_outB2MouseReleased

    private void outA2MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_outA2MouseReleased
        if (clickid < 1) {
            TextureRemix.outputs.get(2).setLink('a', 0, 'x');
            return;
        }
        TextureRemix.outputs.get(2).setLink('a', clickid, clickchan);
        SetSelection('x', 0);
    }//GEN-LAST:event_outA2MouseReleased

    private void outR3MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_outR3MouseReleased
        if (clickid < 1) {
            TextureRemix.outputs.get(3).setLink('r', 0, 'x');
            return;
        }
        TextureRemix.outputs.get(3).setLink('r', clickid, clickchan);
        SetSelection('x', 0);
    }//GEN-LAST:event_outR3MouseReleased

    private void outG3MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_outG3MouseReleased
        if (clickid < 1) {
            TextureRemix.outputs.get(3).setLink('g', 0, 'x');
            return;
        }
        TextureRemix.outputs.get(3).setLink('g', clickid, clickchan);
        SetSelection('x', 0);
    }//GEN-LAST:event_outG3MouseReleased

    private void outB3MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_outB3MouseReleased
        if (clickid < 1) {
            TextureRemix.outputs.get(3).setLink('b', 0, 'x');
            return;
        }
        TextureRemix.outputs.get(3).setLink('b', clickid, clickchan);
        SetSelection('x', 0);
    }//GEN-LAST:event_outB3MouseReleased

    private void outA3MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_outA3MouseReleased
        if (clickid < 1) {
            TextureRemix.outputs.get(3).setLink('a', 0, 'x');
            return;
        }
        TextureRemix.outputs.get(3).setLink('a', clickid, clickchan);
        SetSelection('x', 0);
    }//GEN-LAST:event_outA3MouseReleased

    private void outR4MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_outR4MouseReleased
        if (clickid < 1) {
            TextureRemix.outputs.get(4).setLink('r', 0, 'x');
            return;
        }
        TextureRemix.outputs.get(4).setLink('r', clickid, clickchan);
        SetSelection('x', 0);
    }//GEN-LAST:event_outR4MouseReleased

    private void outG4MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_outG4MouseReleased
        if (clickid < 1) {
            TextureRemix.outputs.get(4).setLink('g', 0, 'x');
            return;
        }
        TextureRemix.outputs.get(4).setLink('g', clickid, clickchan);
        SetSelection('x', 0);
    }//GEN-LAST:event_outG4MouseReleased

    private void outB4MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_outB4MouseReleased
        if (clickid < 1) {
            TextureRemix.outputs.get(4).setLink('b', 0, 'x');
            return;
        }
        TextureRemix.outputs.get(4).setLink('b', clickid, clickchan);
        SetSelection('x', 0);
    }//GEN-LAST:event_outB4MouseReleased

    private void outA4MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_outA4MouseReleased
        if (clickid < 1) {
            TextureRemix.outputs.get(4).setLink('a', 0, 'x');
            return;
        }
        TextureRemix.outputs.get(4).setLink('a', clickid, clickchan);
        SetSelection('x', 0);
    }//GEN-LAST:event_outA4MouseReleased

    private void gray1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_gray1MouseReleased
        TextureRemix.outputs.get(1).setLinkGray(clickid, clickchan);
        SetSelection('x', 0);
    }//GEN-LAST:event_gray1MouseReleased

    private void rgb1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rgb1MouseReleased
        TextureRemix.outputs.get(1).setLinkRgb(clickid);
        SetSelection('x', 0);
    }//GEN-LAST:event_rgb1MouseReleased

    private void gray2MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_gray2MouseReleased
        TextureRemix.outputs.get(2).setLinkGray(clickid, clickchan);
        SetSelection('x', 0);
    }//GEN-LAST:event_gray2MouseReleased

    private void rgb2MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rgb2MouseReleased
        TextureRemix.outputs.get(2).setLinkRgb(clickid);
        SetSelection('x', 0);
    }//GEN-LAST:event_rgb2MouseReleased

    private void gray3MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_gray3MouseReleased
        TextureRemix.outputs.get(3).setLinkGray(clickid, clickchan);
        SetSelection('x', 0);
    }//GEN-LAST:event_gray3MouseReleased

    private void rgb3MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rgb3MouseReleased
        TextureRemix.outputs.get(3).setLinkRgb(clickid);
        SetSelection('x', 0);
    }//GEN-LAST:event_rgb3MouseReleased

    private void gray4MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_gray4MouseReleased
        TextureRemix.outputs.get(4).setLinkGray(clickid, clickchan);
        SetSelection('x', 0);
    }//GEN-LAST:event_gray4MouseReleased

    private void rgb4MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rgb4MouseReleased
        TextureRemix.outputs.get(4).setLinkRgb(clickid);
        SetSelection('x', 0);
    }//GEN-LAST:event_rgb4MouseReleased

    private void inR1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_inR1MouseEntered
        hoverin = 'r';
    }//GEN-LAST:event_inR1MouseEntered

    private void inR1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_inR1MouseExited
        if (hoverin == 'r') hoverin = 'x';
    }//GEN-LAST:event_inR1MouseExited

    private void inG1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_inG1MouseEntered
        hoverin = 'g';
    }//GEN-LAST:event_inG1MouseEntered

    private void inG1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_inG1MouseExited
        if (hoverin == 'g') hoverin = 'x';
    }//GEN-LAST:event_inG1MouseExited

    private void inB1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_inB1MouseEntered
        hoverin = 'b';
    }//GEN-LAST:event_inB1MouseEntered

    private void inB1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_inB1MouseExited
        if (hoverin == 'b') hoverin = 'x';
    }//GEN-LAST:event_inB1MouseExited

    private void inA1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_inA1MouseEntered
        hoverin = 'a';
    }//GEN-LAST:event_inA1MouseEntered

    private void inA1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_inA1MouseExited
        if (hoverin == 'a') hoverin = 'x';
    }//GEN-LAST:event_inA1MouseExited

    private void inR2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_inR2MouseEntered
        hoverin = 'r';
    }//GEN-LAST:event_inR2MouseEntered

    private void inR2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_inR2MouseExited
        if (hoverin == 'r') hoverin = 'x';
    }//GEN-LAST:event_inR2MouseExited

    private void inG2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_inG2MouseEntered
        hoverin = 'g';
    }//GEN-LAST:event_inG2MouseEntered

    private void inG2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_inG2MouseExited
        if (hoverin == 'g') hoverin = 'x';
    }//GEN-LAST:event_inG2MouseExited

    private void inB2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_inB2MouseEntered
        hoverin = 'b';
    }//GEN-LAST:event_inB2MouseEntered

    private void inB2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_inB2MouseExited
        if (hoverin == 'b') hoverin = 'x';
    }//GEN-LAST:event_inB2MouseExited

    private void inA2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_inA2MouseEntered
        hoverin = 'a';
    }//GEN-LAST:event_inA2MouseEntered

    private void inA2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_inA2MouseExited
        if (hoverin == 'a') hoverin = 'x';
    }//GEN-LAST:event_inA2MouseExited

    private void inR3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_inR3MouseEntered
        hoverin = 'r';
    }//GEN-LAST:event_inR3MouseEntered

    private void inR3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_inR3MouseExited
        if (hoverin == 'r') hoverin = 'x';
    }//GEN-LAST:event_inR3MouseExited

    private void inG3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_inG3MouseEntered
        hoverin = 'g';
    }//GEN-LAST:event_inG3MouseEntered

    private void inG3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_inG3MouseExited
        if (hoverin == 'g') hoverin = 'x';
    }//GEN-LAST:event_inG3MouseExited

    private void inB3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_inB3MouseEntered
        hoverin = 'b';
    }//GEN-LAST:event_inB3MouseEntered

    private void inB3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_inB3MouseExited
        if (hoverin == 'b') hoverin = 'x';
    }//GEN-LAST:event_inB3MouseExited

    private void inA3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_inA3MouseEntered
        hoverin = 'a';
    }//GEN-LAST:event_inA3MouseEntered

    private void inA3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_inA3MouseExited
        if (hoverin == 'a') hoverin = 'x';
    }//GEN-LAST:event_inA3MouseExited

    private void inR4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_inR4MouseEntered
        hoverin = 'r';
    }//GEN-LAST:event_inR4MouseEntered

    private void inR4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_inR4MouseExited
        if (hoverin == 'r') hoverin = 'x';
    }//GEN-LAST:event_inR4MouseExited

    private void inG4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_inG4MouseEntered
        hoverin = 'g';
    }//GEN-LAST:event_inG4MouseEntered

    private void inG4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_inG4MouseExited
        if (hoverin == 'g') hoverin = 'x';
    }//GEN-LAST:event_inG4MouseExited

    private void inB4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_inB4MouseEntered
        hoverin = 'b';
    }//GEN-LAST:event_inB4MouseEntered

    private void inB4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_inB4MouseExited
        if (hoverin == 'b') hoverin = 'x';
    }//GEN-LAST:event_inB4MouseExited

    private void inA4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_inA4MouseEntered
        hoverin = 'a';
    }//GEN-LAST:event_inA4MouseEntered

    private void inA4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_inA4MouseExited
        if (hoverin == 'a') hoverin = 'x';
    }//GEN-LAST:event_inA4MouseExited

    private void outR1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_outR1MouseEntered
        hoverout = 'r';
    }//GEN-LAST:event_outR1MouseEntered

    private void outR1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_outR1MouseExited
        if (hoverout == 'r') hoverout = 'x';
    }//GEN-LAST:event_outR1MouseExited

    private void outG1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_outG1MouseEntered
        hoverout = 'g';
    }//GEN-LAST:event_outG1MouseEntered

    private void outG1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_outG1MouseExited
        if (hoverout == 'g') hoverout = 'x';
    }//GEN-LAST:event_outG1MouseExited

    private void outB1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_outB1MouseEntered
        hoverout = 'b';
    }//GEN-LAST:event_outB1MouseEntered

    private void outB1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_outB1MouseExited
        if (hoverout == 'b') hoverout = 'x';
    }//GEN-LAST:event_outB1MouseExited

    private void outA1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_outA1MouseEntered
        hoverout = 'a';
    }//GEN-LAST:event_outA1MouseEntered

    private void outA1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_outA1MouseExited
        if (hoverout == 'a') hoverout = 'x';
    }//GEN-LAST:event_outA1MouseExited

    private void outR2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_outR2MouseEntered
        hoverout = 'r';
    }//GEN-LAST:event_outR2MouseEntered

    private void outR2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_outR2MouseExited
        if (hoverout == 'r') hoverout = 'x';
    }//GEN-LAST:event_outR2MouseExited

    private void outG2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_outG2MouseEntered
        hoverout = 'g';
    }//GEN-LAST:event_outG2MouseEntered

    private void outG2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_outG2MouseExited
        if (hoverout == 'g') hoverout = 'x';
    }//GEN-LAST:event_outG2MouseExited

    private void outB2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_outB2MouseEntered
        hoverout = 'b';
    }//GEN-LAST:event_outB2MouseEntered

    private void outB2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_outB2MouseExited
        if (hoverout == 'b') hoverout = 'x';
    }//GEN-LAST:event_outB2MouseExited

    private void outA2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_outA2MouseEntered
        hoverout = 'a';
    }//GEN-LAST:event_outA2MouseEntered

    private void outA2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_outA2MouseExited
        if (hoverout == 'a') hoverout = 'x';
    }//GEN-LAST:event_outA2MouseExited

    private void outR3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_outR3MouseEntered
        hoverout = 'r';
    }//GEN-LAST:event_outR3MouseEntered

    private void outR3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_outR3MouseExited
        if (hoverout == 'r') hoverout = 'x';
    }//GEN-LAST:event_outR3MouseExited

    private void outG3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_outG3MouseEntered
        hoverout = 'g';
    }//GEN-LAST:event_outG3MouseEntered

    private void outG3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_outG3MouseExited
        if (hoverout == 'g') hoverout = 'x';
    }//GEN-LAST:event_outG3MouseExited

    private void outB3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_outB3MouseEntered
        hoverout = 'b';
    }//GEN-LAST:event_outB3MouseEntered

    private void outB3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_outB3MouseExited
        if (hoverout == 'b') hoverout = 'x';
    }//GEN-LAST:event_outB3MouseExited

    private void outA3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_outA3MouseEntered
        hoverout = 'a';
    }//GEN-LAST:event_outA3MouseEntered

    private void outA3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_outA3MouseExited
        if (hoverout == 'a') hoverout = 'x';
    }//GEN-LAST:event_outA3MouseExited

    private void outR4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_outR4MouseEntered
        hoverout = 'r';
    }//GEN-LAST:event_outR4MouseEntered

    private void outR4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_outR4MouseExited
        if (hoverout == 'r') hoverout = 'x';
    }//GEN-LAST:event_outR4MouseExited

    private void outG4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_outG4MouseEntered
        hoverout = 'g';
    }//GEN-LAST:event_outG4MouseEntered

    private void outG4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_outG4MouseExited
        if (hoverout == 'g') hoverout = 'x';
    }//GEN-LAST:event_outG4MouseExited

    private void outB4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_outB4MouseEntered
        hoverout = 'b';
    }//GEN-LAST:event_outB4MouseEntered

    private void outB4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_outB4MouseExited
        if (hoverout == 'b') hoverout = 'x';
    }//GEN-LAST:event_outB4MouseExited

    private void outA4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_outA4MouseEntered
        hoverout = 'a';
    }//GEN-LAST:event_outA4MouseEntered

    private void outA4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_outA4MouseExited
        if (hoverout == 'a') hoverout = 'x';
    }//GEN-LAST:event_outA4MouseExited

    private void gray1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_gray1MouseEntered
        hoverout = 'a';
    }//GEN-LAST:event_gray1MouseEntered

    private void gray1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_gray1MouseExited
        hoverout = 'x';
    }//GEN-LAST:event_gray1MouseExited

    private void rgb1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rgb1MouseEntered
        hoverout = 'a';
    }//GEN-LAST:event_rgb1MouseEntered

    private void rgb1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rgb1MouseExited
        hoverout = 'x';
    }//GEN-LAST:event_rgb1MouseExited

    private void gray2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_gray2MouseEntered
        hoverout = 'a';
    }//GEN-LAST:event_gray2MouseEntered

    private void gray2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_gray2MouseExited
        hoverout = 'x';
    }//GEN-LAST:event_gray2MouseExited

    private void rgb2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rgb2MouseEntered
        hoverout = 'a';
    }//GEN-LAST:event_rgb2MouseEntered

    private void rgb2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rgb2MouseExited
        hoverout = 'x';
    }//GEN-LAST:event_rgb2MouseExited

    private void gray3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_gray3MouseEntered
        hoverout = 'a';
    }//GEN-LAST:event_gray3MouseEntered

    private void gray3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_gray3MouseExited
        hoverout = 'x';
    }//GEN-LAST:event_gray3MouseExited

    private void rgb3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rgb3MouseEntered
        hoverout = 'a';
    }//GEN-LAST:event_rgb3MouseEntered

    private void rgb3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rgb3MouseExited
        hoverout = 'x';
    }//GEN-LAST:event_rgb3MouseExited

    private void gray4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_gray4MouseEntered
        hoverout = 'a';
    }//GEN-LAST:event_gray4MouseEntered

    private void gray4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_gray4MouseExited
        hoverout = 'x';
    }//GEN-LAST:event_gray4MouseExited
    private void jTextField1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField1FocusLost
        TextureRemix.setPath(jTextField1.getText());
    }//GEN-LAST:event_jTextField1FocusLost

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TextureRemixGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TextureRemixGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TextureRemixGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TextureRemixGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TextureRemixGui().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel DebugPanel;
    public static javax.swing.JLabel Image1Caption;
    public static javax.swing.JLabel Image2Caption;
    public static javax.swing.JLabel Image3Caption;
    public static javax.swing.JLabel Image4Caption;
    public static javax.swing.JPanel Inbox1;
    public static javax.swing.JPanel Inbox2;
    public static javax.swing.JPanel Inbox3;
    public static javax.swing.JPanel Inbox4;
    private javax.swing.JPanel basePanel;
    private javax.swing.JButton clear1;
    private javax.swing.JButton clear2;
    private javax.swing.JButton clear3;
    private javax.swing.JButton clear4;
    private javax.swing.JTextField debugFromCh;
    private javax.swing.JTextField debugInput;
    private javax.swing.JButton debugInverter;
    private javax.swing.JButton debugLinker;
    private javax.swing.JTextField debugOutput;
    private javax.swing.JButton debugReverser;
    private javax.swing.JButton debugSplitter;
    private javax.swing.JTextField debugToCh;
    private javax.swing.JFileChooser fileChooser;
    private javax.swing.Box.Filler filler1;
    private javax.swing.Box.Filler filler2;
    private javax.swing.JButton folderButton;
    private javax.swing.JFileChooser folderChooser;
    private javax.swing.JLabel gray1;
    private javax.swing.JLabel gray2;
    private javax.swing.JLabel gray3;
    private javax.swing.JLabel gray4;
    public static javax.swing.JPanel inA1;
    public static javax.swing.JPanel inA2;
    public static javax.swing.JPanel inA3;
    public static javax.swing.JPanel inA4;
    public static javax.swing.JPanel inB1;
    public static javax.swing.JPanel inB2;
    public static javax.swing.JPanel inB3;
    public static javax.swing.JPanel inB4;
    public static javax.swing.JPanel inG1;
    public static javax.swing.JPanel inG2;
    public static javax.swing.JPanel inG3;
    public static javax.swing.JPanel inG4;
    public static javax.swing.JPanel inR1;
    public static javax.swing.JPanel inR2;
    public static javax.swing.JPanel inR3;
    public static javax.swing.JPanel inR4;
    private javax.swing.JCheckBox invertA1;
    private javax.swing.JCheckBox invertA2;
    private javax.swing.JCheckBox invertA3;
    private javax.swing.JCheckBox invertA4;
    private javax.swing.JCheckBox invertB1;
    private javax.swing.JCheckBox invertB2;
    private javax.swing.JCheckBox invertB3;
    private javax.swing.JCheckBox invertB4;
    private javax.swing.JCheckBox invertG1;
    private javax.swing.JCheckBox invertG2;
    private javax.swing.JCheckBox invertG3;
    private javax.swing.JCheckBox invertG4;
    private javax.swing.JCheckBox invertR1;
    private javax.swing.JCheckBox invertR2;
    private javax.swing.JCheckBox invertR3;
    private javax.swing.JCheckBox invertR4;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel27;
    private javax.swing.JPanel jPanel29;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel31;
    private javax.swing.JPanel jPanel33;
    private static javax.swing.JTextField jTextField1;
    public static javax.swing.JPanel outA1;
    public static javax.swing.JPanel outA2;
    public static javax.swing.JPanel outA3;
    public static javax.swing.JPanel outA4;
    public static javax.swing.JPanel outB1;
    public static javax.swing.JPanel outB2;
    public static javax.swing.JPanel outB3;
    public static javax.swing.JPanel outB4;
    public static javax.swing.JPanel outG1;
    public static javax.swing.JPanel outG2;
    public static javax.swing.JPanel outG3;
    public static javax.swing.JPanel outG4;
    public static javax.swing.JPanel outR1;
    public static javax.swing.JPanel outR2;
    public static javax.swing.JPanel outR3;
    public static javax.swing.JPanel outR4;
    private javax.swing.JLabel rgb1;
    private javax.swing.JLabel rgb2;
    private javax.swing.JLabel rgb3;
    private javax.swing.JLabel rgb4;
    private javax.swing.JLabel split1;
    private javax.swing.JLabel split2;
    private javax.swing.JLabel split3;
    private javax.swing.JLabel split4;
    // End of variables declaration//GEN-END:variables
}
