package e_SwingMenus;
/*
* Bạn có thể thêm hình ảnh vào các mục trong menu hoặc sử dụng hình ảnh thay vì văn bản.
* Cách đơn giản nhất để thêm một hình ảnh là chỉ định nó khi mục menu được tạo bằng cách
* sử dụng một trong các hàm tạo sau:
*
* JMenuItem(Icon image)
* JMenuItem(String name, Icon image)
*
* Hàm tạo đầu tiên tạo một mục menu hiển thị hình ảnh được chỉ định bởi image.
* Hàm tạo thứ hai tạo một mục menu với tên được chỉ định bởi name và hình ảnh được chỉ định bởi image.
* Ví dụ, dưới đây mục menu "About" được liên kết với một hình ảnh khi nó được tạo:
* ImageIcon icon = new ImageIcon("AboutIcon.gif");
* JMenuItem jmiAbout = new JMenuItem("About", icon);
*
* Sau khi thêm này, hình ảnh được chỉ định bởi icon sẽ được hiển thị bên cạnh văn bản "About" khi menu Help được hiển thị.
* Bạn cũng có thể thêm một biểu tượng vào một mục menu sau khi mục đã được tạo bằng cách gọi hàm setIcon(),
* được thừa kế từ AbstractButton.
* Bạn có thể chỉ định căn lề ngang của hình ảnh liên quan đến văn bản bằng cách gọi hàm setHorizontalTextPosition().
*
*
* Bạn có thể chỉ định một biểu tượng bị vô hiệu hóa, được hiển thị khi mục menu bị vô hiệu hóa,
* bằng cách gọi setDisabledIcon(). Thông thường, khi một mục menu bị vô hiệu hóa, biểu tượng mặc định
* sẽ được hiển thị dưới dạng màu xám. Nếu có một biểu tượng bị vô hiệu hóa được chỉ định, thì biểu tượng
* đó sẽ được hiển thị khi mục menu bị vô hiệu hóa.
*
* Một gợi ý là một thông điệp nhỏ mô tả một mục. Nó sẽ tự động hiển thị nếu con trỏ chuột nằm trên mục đó
* trong một khoảng thời gian. Bạn có thể thêm một gợi ý cho một mục menu bằng cách gọi setToolTipText()
* trên mục đó, chỉ định văn bản mà bạn muốn hiển thị. Được mô tả như sau:
* void setToolTipText(String msg)
*
* Trong trường hợp này, msg là chuỗi sẽ được hiển thị khi gợi ý được kích hoạt.
* Ví dụ, đoạn mã sau tạo một gợi ý cho mục "About":
* jmiAbout.setToolTipText("Thông tin về chương trình MenuDemo.");
*
* Một điểm thú vị là setToolTipText() được thừa kế từ JMenuItem từ JComponent.
* Điều này có nghĩa là bạn có thể thêm gợi ý cho các loại thành phần khác, như nút nhấn.
* */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

class MenuDemo2 implements ActionListener {
    JLabel jlab = new JLabel();
    MenuDemo2() {
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

        //Tạo ra một submenu của menu Options
        JMenu jmColors = new JMenu("Colors");
        JMenuItem jmiRed = new JMenuItem("Red");
        JMenuItem jmiGreen = new JMenuItem("Green");
        JMenuItem jmiBlue = new JMenuItem("Blue");
        jmColors.add(jmiRed);
        jmColors.add(jmiGreen);
        jmColors.add(jmiBlue);

        jmOptions.add(jmColors);

        //Tiếp tục tạo ra một submenu của menu Options
        JMenu jmPriority = new JMenu("Priority");
        JMenuItem jmiLow = new JMenuItem("Low");
        JMenuItem jmiHigh = new JMenuItem("High");
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

public class g_addImages_addToolTips {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MenuDemo2();
            }
        });
    }
}
