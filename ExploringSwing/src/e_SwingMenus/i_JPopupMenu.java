package e_SwingMenus;
/*
* Tạo một Menu Popup
* JPopupMenu có hai hàm tạo. Trong chương này, chỉ sử dụng hàm tạo mặc định:
* JPopupMenu()
* Nó tạo ra một menu popup mặc định. Hàm tạo khác cho phép bạn chỉ định một tiêu đề cho menu.
* Việc hiển thị tiêu đề này phụ thuộc vào giao diện người dùng.
*
* Nói chung, menu popup được xây dựng giống như menu thông thường. Đầu tiên, tạo một đối tượng
* JPopupMenu, sau đó thêm các menu item vào nó. Việc chọn menu item cũng được xử lý theo
* cách tương tự: bằng cách lắng nghe sự kiện hành động. Sự khác biệt chính giữa menu popup
* và menu thông thường là quá trình kích hoạt. Để kích hoạt một menu popup, bạn cần thực hiện ba bước:
*
* Bạn phải đăng ký một bộ lắng nghe cho sự kiện chuột.
* Trong bộ xử lý sự kiện chuột, bạn phải theo dõi sự kích hoạt của menu popup.
* Khi nhận được sự kích hoạt của menu popup, bạn phải hiển thị menu popup bằng cách gọi phương thức show().
*
* Hãy xem xét từng bước một cách kỹ lưỡng.
*
* Một menu popup thường được kích hoạt bằng cách nhấp chuột phải khi con trỏ chuột đặt trên một thành phần
* đã được định nghĩa menu popup. Do đó, sự kích hoạt của menu popup thường được gây ra bằng cách nhấp
* chuột phải vào thành phần hỗ trợ menu popup. Để lắng nghe sự kích hoạt của menu popup,
* bạn cần thực hiện giao diện MouseListener và sau đó đăng ký bộ lắng nghe bằng cách gọi phương thức addMouseListener().
* Như được mô tả trong Chương 24, MouseListener định nghĩa các phương thức được hiển thị dưới đây:
*
* void mouseClicked(MouseEvent me)
* void mouseEntered(MouseEvent me)
* void mouseExited(MouseEvent me)
* void mousePressed(MouseEvent me)
* void mouseReleased(MouseEvent me)
*
* Trong số đó, hai phương thức rất quan trọng đối với menu popup là mousePressed() và mouseReleased().
* Tùy thuộc vào giao diện người dùng đã được cài đặt, một trong hai sự kiện này có thể kích hoạt menu popup.
* Vì lý do này, thường dễ dàng hơn để sử dụng một MouseAdapter để thực hiện giao diện MouseListener và đơn giản
* chỉ ghi đè mousePressed() và mouseReleased().
*
* Lớp MouseEvent định nghĩa một số phương thức, nhưng chỉ có bốn phương thức thông thường cần thiết khi kích hoạt
* một menu popup. Chúng được hiển thị dưới đây:
* int getX()
* int getY()
* boolean isPopupTrigger()
* Component getComponent()
*
* Các phương thức getX() và getY() trả về vị trí X,Y hiện tại của chuột liên quan đến nguồn của sự kiện.
* Chúng được sử dụng để xác định góc trên bên trái của menu popup khi nó được hiển thị. Phương thức isPopupTrigger()
* trả về true nếu sự kiện chuột đại diện cho một sự kích hoạt menu popup và false nếu không. Bạn sẽ sử dụng phương thức
* này để xác định khi nào hiển thị menu popup. Để lấy tham chiếu đến thành phần tạo ra sự kiện chuột,
* gọi phương thức getComponent().
*
* Để hiển thị thực sự menu popup, gọi phương thức show() được định nghĩa bởi JPopupMenu, được hiển thị bên dưới:
*
* void show(Component invoker, int upperX, int upperY)
*
* Ở đây, invoker là thành phần liên quan đến đó menu sẽ được hiển thị. Các giá trị upperX và upperY xác định vị trí X,Y
* của góc trên bên trái của menu, liên quan đến invoker.
* Một cách thông thường để lấy invoker là gọi phương thức getComponent() trên đối tượng sự kiện được truyền vào
* bộ xử lý sự kiện chuột.
*
* Lý thuyết trên có thể được đưa vào thực tế bằng cách thêm một menu Edit popup vào chương trình MenuDemo
* được hiển thị ở đầu chương này. Menu này sẽ có ba mục gọi là Cut, Copy và Paste.
* Bắt đầu bằng cách thêm biến instance sau vào MenuDemo: JPopupMenu jpu;
* */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class MenuDemo4 implements ActionListener {
    JLabel jlab = new JLabel();
    JPopupMenu jpu;
    MenuDemo4() {
        JFrame jfrm = new JFrame("Demo Menu");
        jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jfrm.setSize(220, 200);
        jfrm.setLayout(new FlowLayout());
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

        //Thêm JLabel vào content pane
        jfrm.add(jlab);

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
        jfrm.addMouseListener(new MouseAdapter() {
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
        jfrm.add(jpu);


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
public class i_JPopupMenu {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MenuDemo4();
            }
        });
    }
}
/*
* Đoạn mã này bắt đầu bằng việc tạo một phiên bản của JPopupMenu và lưu trữ nó trong biến jpu.
* Sau đó, nó tạo ra ba mục menu là Cut, Copy và Paste theo cách thông thường, và thêm chúng vào jpu.
* Điều này hoàn thành việc xây dựng menu Edit popup. Menu popup không được thêm vào thanh menu
* hoặc bất kỳ đối tượng nào khác.
*
* Tiếp theo, một MouseListener được thêm vào bằng cách tạo một lớp nội danh vô danh. Lớp này dựa
* trên lớp MouseAdapter, điều đó có nghĩa là bộ lắng nghe chỉ cần ghi đè các phương thức liên quan
* đến menu popup: mousePressed() và mouseReleased(). Bộ chuyển đổi cung cấp các triển khai mặc định
* của các phương thức MouseListener khác. Lưu ý rằng bộ lắng nghe chuột được thêm vào jfrm.
* Điều này có nghĩa là một nhấp chuột nút phải bên trong bất kỳ phần nào của content pane sẽ kích hoạt menu popup.
*
* Các phương thức mousePressed() và mouseReleased()  điều kiện e.isPopupTrigger() được sử dụng để kiểm tra xem
* sự kiện chuột là một sự kích hoạt của chuột phải hay không. isPopupTrigger() trả về true nếu sự kiện chuột được
* coi là sự kích hoạt của chuột phải, và false nếu không phải.
* Invoker được lấy bằng cách gọi getComponent() trên sự kiện chuột. Trong trường hợp này, invoker sẽ là content pane.
* Các tọa độ X, Y của góc trên bên trái được lấy bằng cách gọi getX() và getY(). Điều này làm cho menu hiện lên
* với góc trên bên trái nằm chính xác dưới con trỏ chuột.
*
* Cuối cùng, bạn cũng cần thêm các bộ lắng nghe hành động này vào chương trình. Chúng xử lý các sự kiện hành động
* được kích hoạt khi người dùng chọn một mục từ menu popup.
*
* */