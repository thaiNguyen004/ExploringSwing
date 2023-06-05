package e_SwingMenus;
/*
* Tạo một thanh công cụ
* Một thanh công cụ là một thành phần có thể được sử dụng như một sự lựa chọn hoặc làm bổ sung cho một menu.
* Một thanh công cụ chứa một danh sách các nút (hoặc thành phần khác) cho phép người dùng truy cập nhanh đến
* các tùy chọn của chương trình. Ví dụ, một thanh công cụ có thể chứa các nút để chọn các tùy chọn về phông chữ
* khác nhau, chẳng hạn như đậm, nghiêng, tô sáng hoặc gạch chân. Những tùy chọn này có thể được chọn mà không
* cần thả xuống từ menu. Thông thường, các nút trên thanh công cụ hiển thị biểu tượng thay vì văn bản,
* tuy nhiên cả hai đều được chấp nhận. Hơn nữa, thông tin gợi ý (tooltips) thường được liên kết với các nút trên
* thanh công cụ dựa trên biểu tượng. Thanh công cụ có thể được đặt ở bất kỳ phía nào của cửa sổ bằng cách kéo
* thanh công cụ, hoặc nó có thể được kéo ra khỏi cửa sổ hoàn toàn, trong trường hợp này nó trở thành thanh công cụ tự do nổi.
*
* Trong Swing, thanh công cụ là các phiên bản của lớp JToolBar. Các hàm tạo của nó cho phép bạn tạo một thanh công cụ
* có hoặc không có tiêu đề. Bạn cũng có thể chỉ định bố cục của thanh công cụ, có thể là ngang hoặc dọc.
* Các hàm tạo của JToolBar được thể hiện dưới đây:
* JToolBar( )
* JToolBar(String title)
* JToolBar(int how)
* JToolBar(String title, int how)
*
* - Hàm tạo đầu tiên tạo một thanh công cụ ngang không có tiêu đề.
* - Hàm tạo thứ hai tạo một thanh công cụ ngang với tiêu đề được chỉ định bởi title.
* Tiêu đề chỉ hiển thị khi thanh công cụ được kéo ra khỏi cửa sổ của nó.
* - Hàm tạo thứ ba tạo một thanh công cụ được xác định theo định hướng bởi how. Giá trị của how phải là
* JToolBar.VERTICAL hoặc JToolBar.HORIZONTAL.
* - Hàm tạo thứ tư tạo một thanh công cụ có tiêu đề được chỉ định bởi title và được xác định theo định hướng bởi how.
*
* Một thanh công cụ thường được sử dụng với một cửa sổ sử dụng bố cục định viền (border layout).
* Có hai lý do cho điều này. Thứ nhất, nó cho phép thanh công cụ được đặt vị trí ban đầu theo một trong bốn vị trí viền.
* Thông thường, vị trí trên cùng được sử dụng. Thứ hai, nó cho phép thanh công cụ được kéo đến bất kỳ bên nào của cửa sổ.
* Ngoài việc kéo thanh công cụ đến các vị trí khác nhau trong cửa sổ, bạn cũng có thể kéo nó ra khỏi cửa sổ.
* Làm như vậy sẽ tạo ra một thanh công cụ không gắn kết (undocked). Nếu bạn chỉ định một tiêu đề khi tạo thanh công cụ,
* tiêu đề đó sẽ được hiển thị khi thanh công cụ không được gắn kết.
*
* Bạn thêm các nút (hoặc các thành phần khác) vào thanh công cụ theo cách tương tự như khi bạn thêm chúng vào thanh menu.
* Đơn giản là gọi phương thức add(). Các thành phần được hiển thị trên thanh công cụ theo thứ tự chúng được thêm vào.
*
* Sau khi bạn đã tạo một thanh công cụ, bạn không thêm nó vào thanh menu (nếu có). Thay vào đó, bạn thêm nó vào container
* của cửa sổ. Như đã đề cập, thông thường bạn sẽ thêm thanh công cụ vào vị trí trên cùng (tức là phía bắc)
* của một bố cục định viền, sử dụng hướng ngang. Thành phần sẽ bị ảnh hưởng được thêm vào phần trung tâm của bố cục định viền.
* Sử dụng phương pháp này khiến chương trình bắt đầu chạy với thanh công cụ ở vị trí mong đợi. Tuy nhiên, bạn có thể kéo
* thanh công cụ đến bất kỳ vị trí nào khác. Tất nhiên, bạn cũng có thể kéo thanh công cụ ra khỏi cửa sổ.
*
* Để minh họa thanh công cụ, chúng ta sẽ thêm một thanh công cụ vào chương trình MenuDemo.
* Thanh công cụ sẽ hiển thị ba tùy chọn gỡ lỗi: đặt một điểm dừng, xóa một điểm dừng và tiếp tục thực thi chương trình.
* Ba bước được thực hiện để thêm thanh công cụ.
*
* Đầu tiên, loại bỏ dòng này khỏi chương trình:
* jfrm.setLayout(new FlowLayout());
* Bằng cách loại bỏ dòng này, JFrame tự động sử dụng bố cục định viền.
*
* Thứ hai, vì BorderLayout đang được sử dụng, hãy thay đổi dòng thêm nhãn jlab vào khung, như được hiển thị dưới đây:
* jfrm.add(jlab, BorderLayout.CENTER);
* Dòng này một cách rõ ràng thêm jlab vào trung tâm của bố cục định viền. (Việc chỉ định rõ ràng vị trí trung tâm kỹ thuật
* không cần thiết vì theo mặc định, các thành phần được thêm vào trung tâm khi sử dụng bố cục định viền.
* Tuy nhiên, việc chỉ định rõ ràng vị trí trung tâm làm cho nó rõ ràng cho bất kỳ ai đọc mã nguồn rằng một bố cục định viền
* đang được sử dụng và jlab được đặt ở trung tâm.)
*
* Tiếp theo, thêm mã sau, tạo thanh công cụ Debug
* </xem code bên dưới: line = 230>
* */

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.*;

class MenuDemo5 implements ActionListener {
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
    MenuDemo5() {
        JFrame jfrm = new JFrame("Demo Menu");
        jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jfrm.setSize(220, 200);
        container = new JPanel();
        Image image;

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

        //Tạo các toolbar buttons
        JButton btnSet = new JButton("Set");
        btnSet.setActionCommand("Set Breakpoint");
        btnSet.setToolTipText("Set Breakpoint");

        JButton btnClear = new JButton("Clear");
        btnClear.setActionCommand("Clear Breakpoint");
        btnClear.setToolTipText("Clear Breakpoint");

        JButton btnResume = new JButton("Resume");
        btnResume.setActionCommand("Resume Breakpoint");
        btnResume.setToolTipText("Resume Breakpoint");

        jtb.add(btnSet);
        jtb.add(btnClear);
        jtb.add(btnResume);

        //Tiếp tục thêm lắng nghe sự kiện cho các JButton như đối với các JMenuItem
        btnSet.addActionListener(this);
        btnClear.addActionListener(this);
        btnResume.addActionListener(this);

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

public class k_JToolBar {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MenuDemo5();
            }
        });
    }
}
