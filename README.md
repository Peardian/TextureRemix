# Texture Remix
---

The purpose of this tool is to provide a quick and easy way for people to mix image channels without needing to be proficient in advanced image editing software.

## Usage
Texture Remix can recombine the RGB and Alpha channels of images to one or more new images. First, load an image (or images) into the top section. Next, connect input channels to output channels by clicking or dragging. *(Note: dragging does not work yet.)* Finally, choose an output folder and click the save button.

*(See the included tutorial images for more detailed instructions.)*

## Design Goal

Anyone with Photoshop can reach the exact same output as this tool, but it requires technical knowledge of the software and a lot of clicking. That is why the central focus of this tool is its user interface rather than the image channel splicing itself.

Users should be able to understand how to use the tool the moment they open it. Even if users do not know about RGBA color space, they should be able to understand the tool's visual feedback to their actions in a way that allows them to experiment and learn.

The visual metaphor of connecting color-coded wires between colored ports was thought up as a way to convey the concept of channels. Only one cable can be plugged into a single output port at a time, and the cables can be yanked out to remove a connection.

## Why Java?

Java was chosen so that the tool can run on any operating system. A web application version using the HTML5 canvas tag was considered, but it was deemed unfit due to the way canvas tags use alpha compositing, which damages the quality of images with transparency.

## What's with the name?

Modern video game engines use various tricks with compressing or consolidating image channels in order to reduce file size and loading times. The main use for this tool is in creating or reversing these kinds of compressed game textures, though it can really be used on any image. Combined with the metaphor of plugging and mixing cables, this created the idea of "remixing" the images.

## Console Usage

Texture Remix can be invoked from the command line to process images without a single click. Writing commands for this tool is just like using the graphical interface, but without the graphics.

### Syntax

The easiest way to understand the command syntax is to look at the normal graphical interface. Each input and output box can be represented by a number, and each of the colored ports per box can be represented by a letter. Therefore, any wire drawn between an input and output can be represented by just two numbers and two letters.

Here are all of the supported command pieces:

**-i "(file path)"** -  Loads an image as the next input file. You can use this as many times as you want.

**-o "(folder path)"** - Sets the output folder. (You need this to save the images!)

**(in num)(in channel)(out num)(out channel)** - Create a connection ("wire") between an input port and an output port. *(Example: `1r2g` = Input #1 Red to Output #2 Green)*

**!(out num)(out channel)** - Set the inversion flag for an output port. *(Example: `!2r` = invert Output #2 Red)*

## Planned Features

I learned Java and how to make GUIs in Java just so that I could make this tool, so the tool is rather rough right now and does not have all of the intended features. Here is a list of features that have not yet been implemented due to the limit of my technical ability.

* Create wires via drag-and-drop
* Drag images into any part of the window to load them.
* Dynamic number of inputs, ability to cancel/clear an input image
* Dynamic number of outputs (maybe?)
* Show equivalent terminal command for current arrangement in graphical interface
* Field to enter terminal command in graphical interface to quickly set wires
* Thumbnails for input images
* Preview thumbnail for output images?
* Animated background behind thumbnails to emphasize transparency
* Remember last-used destination folder when opening the tool
* Default destination to tool location
* Prompt users when saving would overwrite existing file
* Bezier curve wires
* Tooltips and Help text
