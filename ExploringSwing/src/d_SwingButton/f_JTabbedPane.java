package d_SwingButton;

import javax.swing.*;
import java.awt.*;

/*
* JTabbedPane
* JTabbedPane là một thành phần giao diện người dùng dạng tab. Nó quản lý một tập hợp các thành phần bằng cách liên
* kết chúng với các tab. Khi chọn một tab, thành phần liên kết với tab đó sẽ hiển thị lên phía trước. Tabbed pane rất
* phổ biến trong giao diện người dùng hiện đại và bạn chắc chắn đã sử dụng chúng nhiều lần. Mặc dù tabbed pane có
* tính phức tạp, nhưng việc tạo và sử dụng chúng khá dễ dàng.
*
* JTabbedPane định nghĩa ba hàm khởi tạo. Chúng ta sẽ sử dụng hàm khởi tạo mặc định, tạo ra một thành phần trống
* với các tab được đặt ở trên cùng của pane. Hai hàm khởi tạo khác cho phép bạn chỉ định vị trí của các tab, có thể
* là dọc theo bốn cạnh. JTabbedPane sử dụng mô hình SingleSelectionModel.
*
* Các tab được thêm bằng cách gọi hàm addTab(). Đây là một trong các dạng của hàm đó:
* void addTab(String name, Component comp)
* Ở đây, name là tên cho tab và comp là thành phần được thêm vào tab. Thường thì thành phần được thêm vào một tab
* là một JPanel chứa một nhóm các thành phần liên quan. Kỹ thuật này cho phép một tab chứa một tập hợp các thành phần.
*
* Quy trình chung để sử dụng JTabbedPane được mô tả như sau:
1. Tạo một thể hiện của JTabbedPane.
2. Thêm mỗi tab bằng cách gọi addTab().
3. Thêm tabbed pane vào content pane.
*
* Ví dụ sau minh họa một tabbed pane.
* Tab đầu tiên có tiêu đề "Cities" và chứa bốn nút. Mỗi nút hiển thị tên của một thành phố.
* Tab thứ hai có tiêu đề "Colors" và chứa ba ô kiểm. Mỗi ô kiểm hiển thị tên của một màu sắc.
* Tab thứ ba có tiêu đề "Flavors" và chứa một combo box. Điều này cho phép người dùng chọn một trong ba hương vị.
*
* */
public class f_JTabbedPane {

    f_JTabbedPane() {
        JFrame jfrm = new JFrame("Demo JTabbedPane");
        jfrm.setLayout(new FlowLayout());
        jfrm.setSize(400, 200);
        jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Tạo JTabbedPane
        JTabbedPane jtp = new JTabbedPane();
        jtp.addTab("Cities", new CitiesPanel());
        jtp.addTab("Colors", new ColorsPanel());
        jtp.addTab("Flavors", new FlavorPanel());

        jfrm.add(jtp);
        jfrm.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new f_JTabbedPane();
            }
        });
    }
}

//Tạo các Panel
class CitiesPanel extends JPanel {
    CitiesPanel() {
        JButton btn1 = new JButton("Viet Nam");
        JButton btn2 = new JButton("Japan");
        JButton btn3 = new JButton("USA");
        JButton btn4 = new JButton("France");

        this.add(btn1);
        this.add(btn2);
        this.add(btn3);
        this.add(btn4);
    }
}

class ColorsPanel extends JPanel {
    ColorsPanel() {
        JCheckBox cb1 = new JCheckBox("Red");
        JCheckBox cb2 = new JCheckBox("Blue");
        JCheckBox cb3 = new JCheckBox("Green");
        JCheckBox cb4 = new JCheckBox("Black");
        this.add(cb1); this.add(cb2);
        this.add(cb3); this.add(cb4);
    }
}

class FlavorPanel extends JPanel {
    FlavorPanel() {
        JComboBox<String> cboList = new JComboBox<>();
        cboList.addItem("Chocolate");
        cboList.addItem("Matcha");
        cboList.addItem("Coffee");
        this.add(cboList);
    }
}