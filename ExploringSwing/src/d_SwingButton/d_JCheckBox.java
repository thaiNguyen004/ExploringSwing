package d_SwingButton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

/*
* Ô kiểm (Check Boxes)
* Lớp JCheckBox cung cấp chức năng của một ô kiểm. Lớp cha ngay lập tức của nó là JToggleButton, cung cấp hỗ trợ
* cho các nút hai trạng thái, như đã mô tả. JCheckBox xác định một số hàm tạo (constructors). Hàm tạo được sử dụng
* ở đây là JCheckBox(String str). Nó tạo ra một ô kiểm có văn bản được chỉ định bởi str làm nhãn. Các hàm tạo khác
* cho phép bạn chỉ định trạng thái chọn ban đầu của nút và chỉ định một biểu tượng (icon).
*
* Khi người dùng chọn hoặc bỏ chọn một ô kiểm, một ItemEvent được tạo ra. Bạn có thể nhận được một tham chiếu đến
* JCheckBox đã tạo ra sự kiện bằng cách gọi getItem() trên ItemEvent được truyền vào phương thức itemStateChanged()
* được xác định bởi ItemListener. Cách dễ nhất để xác định trạng thái đã chọn của một ô kiểm là gọi isSelected()
* trên thể hiện JCheckBox.
*
* Ví dụ sau minh họa việc sử dụng ô kiểm. Nó hiển thị bốn ô kiểm và một nhãn. Khi người dùng nhấp vào một ô kiểm,
* một ItemEvent được tạo ra. Trong phương thức itemStateChanged(), getItem() được gọi để nhận một tham chiếu đến
* đối tượng JCheckBox tạo ra sự kiện. Tiếp theo, một cuộc gọi đến isSelected() xác định xem ô kiểm đã được chọn
* hay bỏ chọn. Phương thức getText() lấy văn bản cho ô kiểm đó và sử dụng nó để đặt văn bản trong nhãn.
*
* */
public class d_JCheckBox implements ItemListener {
    JLabel jlab;
    d_JCheckBox() {
        JFrame jfrm = new JFrame("JCheckBox Demo");
        jfrm.setLayout(new FlowLayout());
        jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jfrm.setSize(250, 100);
        jfrm.setLocationRelativeTo(null);

        //Thêm các check boxs vào content pane
        JCheckBox cb = new JCheckBox("C");
        cb.addItemListener(this);
        jfrm.add(cb);

        //Tạo các đối tượng check box bằng cách khởi tạo tiếp các instance cho cb
        cb = new JCheckBox("C++");
        cb.addItemListener(this);
        jfrm.add(cb);

        cb = new JCheckBox("Java");
        cb.addItemListener(this);
        jfrm.add(cb);

        cb = new JCheckBox("Perl");
        cb.addItemListener(this);
        jfrm.add(cb);

        jlab = new JLabel("Select Language");
        jfrm.add(jlab);

        jfrm.setVisible(true);
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        JCheckBox cb = (JCheckBox) e.getItem();
        if(cb.isSelected())
            jlab.setText(cb.getText() + " is selected");
        else
            jlab.setText(cb.getText() + " is cleared");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new d_JCheckBox();
            }
        });
    }
}
