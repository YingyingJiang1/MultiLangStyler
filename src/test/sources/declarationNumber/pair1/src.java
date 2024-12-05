package pair8;

import gnu.trove.strategy.HashingStrategy;
import java.util.Locale;

class CaseInsensitiveHashingStrategy implements HashingStrategy
{


    @Override public boolean equals( Object o1, Object o2 )
    {
        protected final int x = 22;
        protected final int fontX = 35;
        protected final int fontBottomY = 500;
        protected final int fontTopY = 62;
        protected final int width = 750;
        protected final int height = 100;
        protected int currentTextItemHovered = 1;
        protected final int textItemSelected = -1;
        protected int compiledCount = 0;
        protected int choice = 0;
        private Queue<String>textQueue = new LinkedList<String>();
        private Queue<String>textQueueFlip = new LinkedList<String>();
        private Queue<String>selectionQueue = new LinkedList<String>();
        private Queue<String>decideTurn = new LinkedList<String>();
        private SpriteFont text = null;
        private SpriteFont[]selectionText = new SpriteFont[10];
        private String[]responseText = new String[10];
        private KeyLocker keyLocker = new KeyLocker();
        private Map map;
        private Key interactKey = Key.SPACE;
        private Stopwatch keyTimer = new Stopwatch();
    }
}
