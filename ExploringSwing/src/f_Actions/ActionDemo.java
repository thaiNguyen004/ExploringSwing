package f_Actions;
/*
* Để minh họa lợi ích của actions, chúng ta sẽ sử dụng chúng để quản lý thanh công cụ Debug
* đã tạo trong phần trước. Chúng ta cũng sẽ thêm một Debug submenu dưới menu chính Options.
* Debug submenu sẽ chứa các lựa chọn tương tự như Debug toolbar: Set Breakpoint, Clear Breakpoint và Resume.
* Các action cùng hỗ trợ các mục này trong toolbar cũng sẽ hỗ trợ các mục này trong menu.
* Do đó, thay vì phải tạo mã trùng lặp để xử lý cả thanh công cụ và menu, cả hai đều được xử lý bởi các actions.
*
* Bắt đầu bằng cách tạo một lớp nội có tên DebugAction mở rộng AbstractAction, như được hiển thị dưới đây:
*
* */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;



class MenuDemo implements ActionListener {
    JLabel jlab;
    JPopupMenu jpu;


    /*
     * Trong BorderLayout, sự kiện chuột chỉ được chuyển tiếp cho thành phần ở vị trí trung tâm (CENTER).
     * Do đó, nếu bạn gắn JPopupMenu cho JFrame và sử dụng BorderLayout, ngầm hiểu là JPopupMenu có phạm vi là toàn bộ
     * BorderLayout bao gồm tất cả các hướng dẫn đến sự kiện chuột phải sẽ không được truyền đến JPopupMenu
     * và không hiển thị.
     *
     * Cách khắc phục là thay vì sử dụng Frame để chứa JPopupMenu bạn hãy tạo một JPanel để chứa JPopupMenu
     * và thêm JPanel đó vào Content Pane
     *
     * Chương trình đã thay đổi container chứa jlab và jpu từ jframe sang jpanel*/

    JPanel container;
    JPanel jpnCenter;

    //Tạo một lớp nội Action
    /*
    * Lớp DebugAction mở rộng AbstractAction. Nó tạo ra một lớp action sẽ được sử dụng để xác định các thuộc tính
    * liên quan đến menu và toolbar Debug. Constructor của nó có năm tham số cho phép bạn chỉ định các mục sau đây:
    • Tên
    • Icon
    • Mnemonic
    • Accelerator
    • Tooltip
    * Hai mục đầu tiên được truyền vào constructor của AbstractAction thông qua super. Ba thuộc tính còn lại được
    * thiết lập thông qua các cuộc gọi putValue().
    *
    * Phương thức actionPerformed() của DebugAction xử lý các sự kiện cho action. Điều này có nghĩa là khi một
    * phiên bản của DebugAction được sử dụng để tạo một nút thanh công cụ và một mục menu, các sự kiện được tạo ra
    * bởi bất kỳ thành phần nào trong hai thành phần đó đều được xử lý bởi phương thức actionPerformed() trong DebugAction.
    * Lưu ý rằng trình xử lý này hiển thị lựa chọn trong jlab. Ngoài ra, nếu lựa chọn Set Breakpoint được chọn,
    * thì lựa chọn Clear Breakpoint được kích hoạt và lựa chọn Set Breakpoint bị vô hiệu hóa.
    * Nếu lựa chọn Clear Breakpoint được chọn, thì lựa chọn Set Breakpoint được kích hoạt và lựa chọn Clear Breakpoint
    * bị vô hiệu hóa. Điều này minh họa cách một action có thể được sử dụng để kích hoạt hoặc vô hiệu hóa một thành phần.
    * Khi một action bị vô hiệu hóa, nó bị vô hiệu hóa cho tất cả các sử dụng của action đó.
    *
    * Trong trường hợp này, nếu Set Breakpoint bị vô hiệu hóa, thì nó bị vô hiệu hóa cả trong thanh công cụ và trong menu.
    *
    * Tiếp theo, thêm các biến instance DebugAction sau vào MenuDemo:
    * DebugAction setAct;
    * DebugAction clearAct;
    * DebugAction resumeAct;

    Sau đó, tạo ba ImageIcon đại diện cho các tùy chọn Debug, như được hiển thị dưới đây:
    // Tải các hình ảnh cho các actions.
    ImageIcon setIcon = new ImageIcon("setBP.gif");
    ImageIcon clearIcon = new ImageIcon("clearBP.gif");
    ImageIcon resumeIcon = new ImageIcon("resume.gif");

    Bây giờ, tạo các actions quản lý các tùy chọn Debug, như được hiển thị dưới đây.*/
    class DebugAction extends AbstractAction {
        DebugAction (String name, Icon image, int mnem, int accel, String tTip) {
            super(name, image);
            putValue(MNEMONIC_KEY, mnem);
            putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(accel, InputEvent.CTRL_DOWN_MASK));
            putValue(SHORT_DESCRIPTION, tTip);
        }
        //Xử lý các hành động chung cho cả JMenu và JToolBar và JPopupMenu
        @Override
        public void actionPerformed(ActionEvent e) {
            String str = e.getActionCommand();
            jlab.setText(str + " selected");

            //Chuyển đổi trạng thái của setBreakpoint và clearBreakpoint
            if(str.equals("Set Breakpoint")) {
                setAct.setEnabled(false);
                clearAct.setEnabled(true);
            }if(str.equals("Clear Breakpoint")) {
                clearAct.setEnabled(false);
                setAct.setEnabled(true);
            };
        }
    }

    //Tiếp theo, thêm các biến instance DebugAction sau vào MenuDemo:
    DebugAction setAct;
    DebugAction clearAct;
    DebugAction resumeAct;

    MenuDemo() {
        JFrame jfrm = new JFrame("Demo Menu");
        jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jfrm.setSize(220, 200);
        container = new JPanel();
        Image image;

        //Tạo ra 3 instance của DebugAction
        setAct = new DebugAction("Set Breakpoint", null
                , KeyEvent.VK_S, KeyEvent.VK_S, "Set a break point");

        clearAct = new DebugAction("Clear Breakpoint", null
                , KeyEvent.VK_C, KeyEvent.VK_L, "Clear a break point");

        resumeAct = new DebugAction("Resume Breakpoint", null
                , KeyEvent.VK_S, KeyEvent.VK_S, "Resume execute after breakpoint");

        //Ban đầu phải vô hiệu hóa cho options Clear breakpoint
        clearAct.setEnabled(false);

        /*
        * Lưu ý rằng phím tắt cho Set Breakpoint là B và phím tắt cho Clear Breakpoint là L.
        * Lý do sử dụng những phím này thay vì S và C là vì những phím này đã được cấp phát
        * bởi menu File cho Save và Close. Tuy nhiên, chúng vẫn có thể được sử dụng như là
        * mnemonics vì mỗi mnemonics chỉ áp dụng cho menu riêng của nó. Hãy lưu ý rằng
        * action đại diện cho Clear Breakpoint được vô hiệu hóa ban đầu.
        * Nó chỉ được kích hoạt sau khi đã đặt một điểm dừng.
        *
        * Tiếp theo, sử dụng các actions để tạo các nút cho thanh công cụ và sau đó thêm
        * những nút đó vào thanh công cụ, như được hiển thị dưới đây.
        * */


        //Khởi tạo một nhãn sẽ hiển thị các tùy menu item được chọn
        jlab = new JLabel();
        //Set ToolTipText cho JLabel
        jlab.setToolTipText("Hiển thị các mục được chọn");

        //Tạo ra một JMenuBar
        JMenuBar jmb = new JMenuBar();

        //Tạo ra một File menu
        JMenu jmFile = new JMenu("File");
        //Tạo menu File với Mnemonic và Accelerator
        jmFile.setMnemonic(KeyEvent.VK_F);

        //Set Mnemonic cho JMenuItem Open bằng hàm khởi tạo (đối số thứ 2)
        JMenuItem jmiOpen = new JMenuItem("Open", KeyEvent.VK_O);
        //Set Accelerator cho JMenuItem Open
        jmiOpen.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_DOWN_MASK));

        JMenuItem jmiClose = new JMenuItem("Close", KeyEvent.VK_C);
        jmiClose.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.CTRL_DOWN_MASK));

        //Tạo ImageIcon cho JMenuItem Save
        ImageIcon saveIcon = new ImageIcon("E:\\SwingIcon\\save.png");
        saveIcon = new ImageIcon(saveIcon.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH));
        //Tạo ImageIcon cho Save khi disable
        ImageIcon saveDisableIcon = new ImageIcon("E:\\SwingIcon\\disable_icon.png");
        saveDisableIcon = new ImageIcon(saveDisableIcon.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH));

        JMenuItem jmiSave = new JMenuItem("Save", KeyEvent.VK_S);
        jmiSave.setIcon(saveIcon);
        jmiSave.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_DOWN_MASK));

        //Set disable icon cho JMenuItem Save
        jmiSave.setDisabledIcon(saveDisableIcon);
        //Khi icon bị disable nó sẽ có icon tương ứng với icon được set trong phương thức setDisableIcon
        //Lưu ý nhỏ: JMenuItem chỉ hiển thị icon disable khi Component đó được khởi tạo bởi 1 icon
        jmiSave.setEnabled(false);

        JMenuItem jmiExit = new JMenuItem("Exit", KeyEvent.VK_E);
        jmiExit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, InputEvent.CTRL_DOWN_MASK));

        //thêm các menu item vào JMenu
        jmFile.add(jmiOpen);
        jmFile.add(jmiClose);
        jmFile.add(jmiSave);


        jmFile.addSeparator();
        jmFile.add(jmiExit);
        //Thêm JMenu vào JMenuBar
        jmb.add(jmFile);

        //Tạo ra một Options menu
        JMenu jmOptions = new JMenu("Options");

        //Tạo ra một submenu của menu Options Colors và sử dụng JCheckBoxMenuItem
        JMenu jmColors = new JMenu("Colors");
        JCheckBoxMenuItem jmiRed = new JCheckBoxMenuItem("Red");
        JCheckBoxMenuItem jmiGreen = new JCheckBoxMenuItem("Green");
        JCheckBoxMenuItem jmiBlue = new JCheckBoxMenuItem("Blue");
        jmColors.add(jmiRed);
        jmColors.add(jmiGreen);
        jmColors.add(jmiBlue);

        jmOptions.add(jmColors);

        //Tiếp tục tạo ra một submenu của menu Options Priority và sử dụng JRadioButtonMenuItem
        JMenu jmPriority = new JMenu("Priority");
        //Tạo GroupButton
        ButtonGroup groupPriority = new ButtonGroup();
        JRadioButtonMenuItem jmiLow = new JRadioButtonMenuItem("Low");
        JRadioButtonMenuItem jmiHigh = new JRadioButtonMenuItem("High");
        groupPriority.add(jmiLow);
        groupPriority.add(jmiHigh);

        jmPriority.add(jmiLow);
        jmPriority.add(jmiHigh);

        jmOptions.add(jmPriority);

        //Tạo ra một menu item Reset
        JMenuItem jmiReset = new JMenuItem("Reset");
        //Tạo một đường thẳng phân cách 2 option là Colors và Priority với JMenuItem Reset
        jmOptions.addSeparator();
        jmOptions.add(jmiReset);

        //Tạo thêm 1 option nữa mang tên là Debug và sử dụng lớp Action
        JMenu jmDebug = new JMenu("Debug");
        JMenuItem jmiSet = new JMenuItem(setAct);
        JMenuItem jmiClear = new JMenuItem(clearAct);
        JMenuItem jmiResume = new JMenuItem(resumeAct);
        jmDebug.add(jmiSet);
        jmDebug.add(jmiClear);
        jmDebug.add(jmiResume);
        jmOptions.add(jmDebug);

        //Cuối cùng thêm JMenu Options vào JMenuBar
        jmb.add(jmOptions);

        //Tạo ra JMenu Help
        JMenu jmHelp = new JMenu("Help");
        //Tạo ra một đối tượng Icon

        ImageIcon ii = new ImageIcon("E:\\SwingIcon\\flower.png");
        image = ii.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        ii = new ImageIcon(image);
        JMenuItem jmiAbout = new JMenuItem("About", ii); //Thêm đối tượng icon đó vào hàm tạo JMenuItem

        jmHelp.add(jmiAbout);
        jmb.add(jmHelp);

        //Thêm lắng nghe sự kiện cho các JMenuItem
        jmiOpen.addActionListener(this);
        jmiClose.addActionListener(this);
        jmiSave.addActionListener(this);
        jmiExit.addActionListener(this);
        jmiRed.addActionListener(this);
        jmiGreen.addActionListener(this);
        jmiBlue.addActionListener(this);
        jmiLow.addActionListener(this);
        jmiHigh.addActionListener(this);
        jmiReset.addActionListener(this);
        jmiAbout.addActionListener(this);

        container.add(jlab);
        jfrm.add(container);

        //Khởi tạo đối tượng JPopupMenu
        jpu = new JPopupMenu();
        //Tạo các JMenuItem là các mục thành phần trong JPopupMenu
        JMenuItem jmiCut = new JMenuItem("Cut");
        JMenuItem jmiCopy = new JMenuItem("Copy");
        JMenuItem jmiPaste = new JMenuItem("Paste");
        jpu.add(jmiCut);
        jpu.add(jmiCopy);
        jpu.add(jmiPaste);

        //Tạo JMenu Debug vào JPopupMenu
        JMenu jmDebugPopup = new JMenu("Debug");
        JMenuItem jmiSetPopup = new JMenuItem(setAct);
        JMenuItem jmiClearPopup = new JMenuItem(clearAct);
        JMenuItem jmiResumePopup = new JMenuItem(resumeAct);
        jmDebugPopup.add(jmiSetPopup);
        jmDebugPopup.add(jmiClearPopup);
        jmDebugPopup.add(jmiResumePopup);
        jpu.add(jmDebugPopup);

        //Tiếp tục thêm lắng nghe sự kiện cho các JMenuItem
        jmiCut.addActionListener(this);
        jmiCopy.addActionListener(this);
        jmiPaste.addActionListener(this);

        //Sử lý sự kiện sau thì JPopupMenu mới được hiển thị lớp MouseListener
        container.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                //Vì JPopupMenu add sự kiện chuột này nên sự kiện chuột này đại diện cho một sự
                //kích hoạt JPopupMenu thông qua phương thức isPopupTrigger
                if(e.isPopupTrigger())
                    jpu.show(e.getComponent(), e.getX(), e.getY());
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                if(e.isPopupTrigger())
                    jpu.show(e.getComponent(), e.getX(), e.getY());
            }
        });

        //Thêm JPopupMenu vào frame
        container.add(jpu);
        jfrm.add(container);

        //Tạo JToolBar
        JToolBar jtb = new JToolBar("Debug");
        JButton btnSet = new JButton(setAct);
        JButton btnClear = new JButton(clearAct);
        JButton btnResume = new JButton(resumeAct);
        jtb.add(btnSet);
        jtb.add(btnClear);
        jtb.add(btnResume);


        //Vì btnSet btnClear btnResume đã sử dụng action và các sự kiện bên trong action được xây dựng
        //nên nó không cần addActionListener dưới đây nữa
//        btnSet.addActionListener(this);
//        btnClear.addActionListener(this);
//        btnResume.addActionListener(this);

        jfrm.add(jtb, BorderLayout.NORTH);

        //Thêm menu bar vào frame
        jfrm.setJMenuBar(jmb);

        jfrm.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String str = e.getActionCommand();
        if(str.equals("Exit"))
            System.exit(0);
        jlab.setText(str + " selected");
    }
}

public class ActionDemo {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MenuDemo();
            }
        });
    }
}
