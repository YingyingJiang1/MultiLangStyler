package pair9;

import Engine.GraphicsHandler;
import Engine.Key;
import Engine.KeyLocker;
import Engine.Keyboard;
import SpriteFont.SpriteFont;
import Utils.Stopwatch;
import java.awt.*;
import java.util.LinkedList;
import java.util.Queue;

// Represents the game's textbox
// will display the text it is given to its textQueue
// each String in the textQueue will be displayed in the textbox, and hitting the interact key will cycle between additional Strings in the queue
// use the newline character in a String in the textQueue to break the text up into a second line if needed
public class Textbox
{

    protected boolean isActive;
    protected final int x = 22,bottomY = 460;
    protected final int topY = 22;
    private Queue<String>textQueue = new LinkedList<String>(),textQueueFlip = new LinkedList<String>();

}
