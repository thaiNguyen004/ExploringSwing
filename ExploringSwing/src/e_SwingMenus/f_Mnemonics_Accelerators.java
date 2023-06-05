package e_SwingMenus;
/*
* Thêm Mnemonics và Accelerators vào các mục trong menu
* Menu được tạo trong ví dụ trước đó đã hoạt động, nhưng có thể làm cho nó tốt hơn. Trong các ứng dụng thực tế,
* menu thường bao gồm hỗ trợ cho các phím tắt bàn phím vì chúng cho phép người dùng đã có kinh nghiệm lựa chọn
* các mục menu một cách nhanh chóng. Phím tắt bàn phím có hai hình thức: mnemonics và accelerators.
* Đối với menu, mnemonics xác định một phím cho phép bạn chọn một mục từ menu đang hoạt động bằng cách gõ phím đó.
* Do đó, mnemonics cho phép bạn sử dụng bàn phím để chọn một mục từ menu đã được hiển thị.
* Accelerator là một phím cho phép bạn chọn một mục menu mà không cần phải kích hoạt menu trước.
*
* Mnemonic có thể được chỉ định cho các đối tượng JMenuItem và JMenu. Có hai cách để đặt mnemonic cho JMenuItem.
* Đầu tiên, nó có thể được chỉ định khi một đối tượng được xây dựng bằng cách sử dụng constructor này:
*
* JMenuItem(String name, int mnem)
*
* Trong trường hợp này, tên được truyền vào trong name và mnemonic được truyền vào trong mnem.
* Thứ hai, bạn có thể đặt mnemonic bằng cách gọi setMnemonic(). Để chỉ định một mnemonic cho JMenu,
* bạn phải gọi setMnemonic(). Phương thức này được kế thừa bởi cả hai lớp từ AbstractButton và được hiển thị ở dưới đây:
*
* void setMnemonic(int mnem)
*
* Ở đây, mnem chỉ định mnemonic. Nó nên là một trong các hằng số được định nghĩa trong java.awt.event.KeyEvent,
* như KeyEvent.VK_F hoặc KeyEvent.VK_Z.
* (Có một phiên bản khác của setMnemonic() nhận đối số là char, nhưng nó được coi là đã lỗi thời.)
* Mnemonics không phân biệt chữ hoa, vì vậy trong trường hợp của VK_A, việc gõ a hoặc A đều hoạt động.
*
* Mặc định, chữ cái phù hợp đầu tiên trong mục menu sẽ được gạch chân. Trong trường hợp bạn muốn gạch chân một chữ cái
* khác ngoài chữ cái phù hợp đầu tiên, hãy chỉ định chỉ số của chữ cái như một đối số cho setDisplayedMnemonicIndex(),
* được kế thừa bởi cả JMenu và JMenuItem từ AbstractButton. Nó được hiển thị ở dưới đây:
*
* void setDisplayedMnemonicIndex(int idx)
*
* Chỉ số của chữ cái cần được gạch chân được chỉ định bởi idx.
*
* Một accelerator có thể được liên kết với đối tượng JMenuItem. Nó được chỉ định bằng cách gọi setAccelerator(),
* như được hiển thị dưới đây:
*
* void setAccelerator(KeyStroke ks)
*
* Ở đây, ks là tổ hợp phím được nhấn để chọn mục trong menu. KeyStroke là một lớp chứa một số phương thức factory
* tạo ra các loại accelerator keystroke khác nhau. Dưới đây là ba ví dụ:
*
* static KeyStroke getKeyStroke(char ch)
* static KeyStroke getKeyStroke(Character ch, int modifier)
* static KeyStroke getKeyStroke(int ch, int modifier)
*
* Ở đây, ch chỉ định ký tự accelerator. Trong phiên bản đầu tiên, ký tự được chỉ định dưới dạng giá trị char.
* Trong phiên bản thứ hai, nó được chỉ định dưới dạng một đối tượng của kiểu Character. Trong phiên bản thứ ba,
* nó là một giá trị của kiểu KeyEvent, đã được mô tả trước đó. Giá trị của modifier phải là một hoặc nhiều hằng số sau đây,
* được định nghĩa trong lớp java.awt.event.InputEvent:
*
* InputEvent.ALT_DOWN_MASK
* InputEvent.CTRL_DOWN_MASK
* InputEvent.SHIFT_DOWN_MASK
* InputEvent.ALT_GRAPH_DOWN_MASK
* InputEvent.META_DOWN_MASK
*
* Do đó, nếu bạn truyền VK_A cho ký tự phím và InputEvent.CTRL_DOWN_MASK cho modifier,
* tổ hợp phím accelerator sẽ là CTRL-A.
*
* Dãy lệnh sau đây thêm cả mnemonics và accelerators vào menu File được tạo bởi chương trình MenuDemo trong phần trước.
* Sau khi thực hiện thay đổi này, bạn có thể chọn menu File bằng cách gõ ALT-F.
* Sau đó, bạn có thể sử dụng mnemonics O, C, S hoặc E để chọn một tùy chọn.
* Hoặc, bạn có thể trực tiếp chọn một tùy chọn trong menu File bằng cách nhấn CTRL-O, CTRL-C, CTRL-S hoặc CTRL-E.
*
* */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.security.Key;

class MenuDemo implements ActionListener {
    JLabel jlab = new JLabel();
    MenuDemo() {
        JFrame jfrm = new JFrame("Demo Menu");
        jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jfrm.setSize(220, 200);
        jfrm.setLayout(new FlowLayout());

        //Khởi tạo một nhãn sẽ hiển thị các tùy menu item được chọn
        jlab = new JLabel();

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

        JMenuItem jmiSave = new JMenuItem("Save", KeyEvent.VK_S);
        jmiSave.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_DOWN_MASK));

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
        JMenuItem jmiAbout = new JMenuItem("About");
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

public class f_Mnemonics_Accelerators {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MenuDemo();
            }
        });
    }
}
