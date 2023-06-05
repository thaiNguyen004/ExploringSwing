package e_SwingMenus;
/*
* Sử dụng JRadioButtonMenuItem và JCheckBoxMenuItem
* Mặc dù loại menu item được sử dụng trong các ví dụ trước đó là những menu item phổ biến nhất,
* nhưng Swing định nghĩa thêm hai loại khác: check boxes (ô kiểm) và radio buttons (nút radio).
* Những loại item này có thể tối ưu hóa giao diện người dùng bằng cách cho phép menu cung cấp
* chức năng mà nếu không sẽ yêu cầu thêm các thành phần độc lập khác. Đôi khi, việc bao gồm các
* check box hoặc radio button trong một menu đơn giản là cách tự nhiên nhất để đặt một tập hợp
* cụ thể các tính năng.
*
* Dù cho bất kỳ lý do gì, Swing rất dễ sử dụng check box và radio button trong menu, và cả hai
* loại này sẽ được xem xét dưới đây.
*
* Để thêm một check box vào menu, tạo một JCheckBoxMenuItem. Nó định nghĩa một số hàm tạo.
* Đây là hàm tạo được sử dụng trong chương này:
*
* JCheckBoxMenuItem(String name)
*
* Ở đây, name chỉ định tên của item. Trạng thái ban đầu của ô kiểm là chưa được chọn. Nếu bạn muốn
* chỉ định trạng thái ban đầu, bạn có thể sử dụng hàm tạo này:
*
* JCheckBoxMenuItem(String name, boolean state)
*
* Trong trường hợp này, nếu state là true, ô kiểm sẽ được chọn ban đầu. Ngược lại, nó sẽ không
* được chọn. JCheckBoxMenuItem cũng cung cấp các hàm tạo cho phép bạn chỉ định một biểu tượng.
* Dưới đây là một ví dụ:
*
* JCheckBoxMenuItem(String name, Icon icon)
*
* Trong trường hợp này, name chỉ định tên của item và hình ảnh liên kết với item được chuyển
* qua biến icon. Item ban đầu không được chọn. Cũng có các hàm tạo khác được hỗ trợ.
*
* Các check box trong menu hoạt động giống như các check box độc lập. Ví dụ, chúng tạo ra các sự kiện
* hành động và sự kiện mục khi trạng thái của chúng thay đổi. Các check box đặc biệt hữu ích trong menu
* khi bạn có các tùy chọn có thể được chọn và bạn muốn hiển thị trạng thái đã chọn hoặc chưa chọn của chúng.
* Một radio button có thể được thêm vào menu bằng cách tạo một đối tượng của loại JRadioButtonMenuItem.
*
* JRadioButtonMenuItem kế thừa từ JMenuItem. Nó cung cấp một tập hợp các hàm tạo phong phú.
* Đây là một số hàm tạo được sử dụng trong chương này:
*
* JRadioButtonMenuItem(String name)
* JRadioButtonMenuItem(String name, boolean state)
*
* Hàm tạo đầu tiên tạo một menu item radio button chưa được chọn và liên kết với tên được truyền vào biến name.
* Hàm tạo thứ hai cho phép bạn chỉ định trạng thái ban đầu của nút. Nếu state là true, nút sẽ được chọn ban đầu.
* Ngược lại, nó sẽ không được chọn. Các hàm tạo khác cho phép bạn chỉ định một biểu tượng. Dưới đây là một ví dụ:
*
* JRadioButtonMenuItem(String name, Icon icon, boolean state)
*
* Điều này tạo ra một menu item radio button được liên kết với tên được truyền vào biến name và hình ảnh được
* truyền vào biến icon. Nếu state là true, nút sẽ được chọn ban đầu. Ngược lại, nó sẽ không được chọn.
* Có nhiều hàm tạo khác được hỗ trợ.
*
* Một JRadioButtonMenuItem hoạt động giống như một nút radio độc lập, tạo ra các sự kiện mục và hành động.
* Giống như nút radio độc lập, radio button dựa trên menu cần được đặt vào một nhóm nút để chúng hiển thị
* hành vi lựa chọn độc quyền.
*
* Bởi vì cả JCheckBoxMenuItem và JRadioButtonMenuItem kế thừa từ JMenuItem, mỗi loại này có tất cả các
* chức năng được cung cấp bởi JMenuItem. Ngoài các khả năng thêm của check box và radio button, chúng hoạt động
* và được sử dụng như các menu item khác.
*
* Để thử các menu item check box và radio button, trước tiên hãy xóa mã tạo menu Options trong chương trình
* ví dụ MenuDemo. Sau đó thay thế bằng đoạn mã sau, sử dụng check box cho submenu Colors và radio button cho
* submenu Priority.
* */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

class MenuDemo3 implements ActionListener {
    JLabel jlab = new JLabel();
    MenuDemo3() {
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

public class h_CheckBox_Radio {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MenuDemo3();
            }
        });
    }
}
