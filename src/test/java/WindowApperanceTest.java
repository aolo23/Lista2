import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import sun.awt.RequestFocusController;
import sun.awt.util.IdentityArrayList;
import sun.java2d.pipe.Region;
import sun.util.logging.PlatformLogger;

import javax.accessibility.AccessibleContext;
import javax.swing.*;
import java.awt.*;
import java.awt.dnd.DropTarget;
import java.awt.event.*;
import java.awt.im.InputContext;
import java.awt.image.BufferStrategy;
import java.awt.peer.ComponentPeer;
import java.beans.PropertyChangeSupport;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Vector;
import java.util.concurrent.atomic.AtomicBoolean;

public class WindowApperanceTest {
    @Mock
    JButton AddTheSeller;
    @Mock
    JButton AddTheBuyer;
    @Mock
    JButton AddTheProduct;
    @Mock
    JButton IssueAnInvoice;
    @Mock
    JTextField term;
    @Mock
    JTextField tplace;
    @Mock
    JComboBox jComboBox;
    @Mock
    Object defaultLookAndFeelDecoratedKey;
    @Mock
    TransferHandler transferHandler;
    @Mock
    JRootPane rootPane;
    @Mock
    AccessibleContext accessibleContext;
    @Mock
    Rectangle maximizedBounds;
    @Mock
    MenuBar menuBar;
    @Mock
    Vector<Window> ownedWindows;
    @Mock
    List<Image> icons;
    @Mock
    Component temporaryLostComponent;
    @Mock
    IdentityArrayList<Window> allWindows;
    @Mock
    Vector<WeakReference<Window>> ownedWindowList;
    @Mock
    WeakReference<Window> weakThis;
    @Mock
    Dialog modalBlocker;
    //Field modalExclusionType of type ModalExclusionType - was not mocked since Mockito doesn't mock a Final class when 'mock-maker-inline' option is not set
    @Mock
    WindowListener windowListener;
    @Mock
    WindowStateListener windowStateListener;
    @Mock
    WindowFocusListener windowFocusListener;
    @Mock
    InputContext inputContext;
    @Mock
    Object inputContextLock;
    @Mock
    Shape shape;
    @Mock
    PlatformLogger log;
    @Mock
    Object anchor;
    @Mock
    AtomicBoolean beforeFirstWindowShown;
    //Field type of type Type - was not mocked since Mockito doesn't mock a Final class when 'mock-maker-inline' option is not set

    @Mock
    PlatformLogger eventLog;
    @Mock
    List<Component> component;
    @Mock
    LayoutManager layoutMgr;
    @Mock
    FocusTraversalPolicy focusTraversalPolicy;
    @Mock
    Set<Thread> printingThreads;
    @Mock
    ContainerListener containerListener;
    @Mock
    Color preserveBackgroundColor;
    @Mock
    PlatformLogger mixingLog;
    @Mock
    Component modalComp;
    //Field modalAppContext of type AppContext - was not mocked since Mockito doesn't mock a Final class when 'mock-maker-inline' option is not set
    @Mock
    PlatformLogger focusLog;
    @Mock
    ComponentPeer peer;
    @Mock
    Container parent;
    //Field appContext of type AppContext - was not mocked since Mockito doesn't mock a Final class when 'mock-maker-inline' option is not set
    @Mock
    Color foreground;
    @Mock
    Color background;
    @Mock
    Font font;
    @Mock
    Font peerFont;
    @Mock
    Cursor cursor;
    //Field locale of type Locale - was not mocked since Mockito doesn't mock a Final class when 'mock-maker-inline' option is not set
    @Mock
    GraphicsConfiguration graphicsConfig;
    @Mock
    BufferStrategy bufferStrategy;
    @Mock
    DropTarget dropTarget;
    @Mock
    Vector<PopupMenu> popups;
    //Field focusTraversalKeys of type Set[] - was not mocked since Mockito doesn't mock arrays
    @Mock
    Object LOCK;
    //Field acc of type AccessControlContext - was not mocked since Mockito doesn't mock a Final class when 'mock-maker-inline' option is not set
    @Mock
    Dimension minSize;
    @Mock
    Dimension prefSize;
    @Mock
    Dimension maxSize;
    //Field componentOrientation of type ComponentOrientation - was not mocked since Mockito doesn't mock a Final class when 'mock-maker-inline' option is not set
    @Mock
    ComponentListener componentListener;
    @Mock
    FocusListener focusListener;
    @Mock
    HierarchyListener hierarchyListener;
    @Mock
    HierarchyBoundsListener hierarchyBoundsListener;
    @Mock
    KeyListener keyListener;
    @Mock
    MouseListener mouseListener;
    @Mock
    MouseMotionListener mouseMotionListener;
    @Mock
    MouseWheelListener mouseWheelListener;
    @Mock
    InputMethodListener inputMethodListener;
    @Mock
    RuntimeException windowClosingException;
    @Mock
    PropertyChangeSupport changeSupport;
    @Mock
    Object objectLock;
    @Mock
    Region compoundShape;
    @Mock
    Region mixingCutoutRegion;
    //Field eventCache of type EventQueueItem[] - was not mocked since Mockito doesn't mock arrays
    @Mock
    Map<Class<?>, Boolean> coalesceMap;
    @Mock
    RequestFocusController requestFocusController;
    @InjectMocks
    WindowApperance windowApperance;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testActionPerformed() throws Exception {
        windowApperance.actionPerformed(null);
    }
}

