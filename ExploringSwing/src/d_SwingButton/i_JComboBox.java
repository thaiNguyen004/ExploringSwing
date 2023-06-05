package d_SwingButton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
* JComboBox
* Swing cung cấp một combo box (kết hợp giữa một trường văn bản và một danh sách thả xuống) thông qua lớp JComboBox.
* Một combo box thường hiển thị một mục nhập, nhưng nó cũng có thể hiển thị một danh sách thả xuống cho phép
* người dùng chọn một mục nhập khác. Bạn cũng có thể tạo một combo box cho phép người dùng nhập một lựa chọn
* vào trường văn bản.
*
* Trong quá khứ, các mục nhập trong JComboBox được đại diện bằng các tham chiếu đối tượng. Tuy nhiên, bắt đầu
* từ JDK 7, JComboBox đã được làm thành kiểu generic và được khai báo như sau:
* class JComboBox<E>
Ở đây, E đại diện cho loại các mục nhập trong combo box.
*
* Constructor của JComboBox được sử dụng trong ví dụ được hiển thị như sau:
* JComboBox(E[ ] items)
* Ở đây, items là một mảng khởi tạo combo box. Có sẵn các constructor khác.
*
* JComboBox sử dụng ComboBoxModel. Các combo box có thể thay đổi (có thể thay đổi các mục nhập)
* sử dụng MutableComboBoxModel.
*
* Ngoài việc truyền một mảng các mục nhập để hiển thị trong danh sách thả xuống, các mục nhập có thể được
* thêm động vào danh sách lựa chọn thông qua phương thức addItem( ), được hiển thị như sau:
* void addItem(E obj)
* Ở đây, obj là đối tượng được thêm vào combo box. Phương thức này chỉ nên được sử dụng với các combo box có thể thay đổi.
*
* JComboBox tạo ra một sự kiện action khi người dùng chọn một mục từ danh sách. JComboBox cũng tạo ra một
* sự kiện item khi trạng thái của lựa chọn thay đổi, điều này xảy ra khi một mục được chọn hoặc bỏ chọn.
* Do đó, thay đổi một lựa chọn có nghĩa là hai sự kiện item sẽ xảy ra: một cho mục đã bị bỏ chọn và một cho
* mục đã được chọn. Thường thì chỉ cần lắng nghe sự kiện action là đủ, nhưng cả hai loại sự kiện đều có
* sẵn để sử dụng.
*
* Một cách để lấy mục đã chọn trong danh sách là gọi getSelectedItem( ) trên combo box.
* Được hiển thị như sau:
* Object getSelectedItem( )
* Bạn cần ép kiểu giá trị trả về thành loại đối tượng được lưu trữ trong danh sách.
*
* Ví dụ sau minh họa combo box. Combo box chứa các mục nhập cho "Hourglass", "Analog", "Digital"
* và "Stopwatch". Khi một mục đồng hồ được chọn, một nhãn dựa trên biểu tượng được cập nhật để hiển thị nó.
* Bạn có thể thấy là chỉ cần ít mã lệnh là có thể sử dụng thành phần mạnh mẽ này.
*
* */
public class i_JComboBox {
        String[] timepieces = {"flower", "horse", "meter", "tree"};
        String path = "E:\\SwingIcon\\";
    i_JComboBox() {
        JFrame jfrm = new JFrame("Demo JComboBox");
        jfrm.setLayout(new FlowLayout());
        jfrm.setSize(400, 250);
        jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JComboBox<String> cboList = new JComboBox<>(timepieces);

        jfrm.add(cboList);

        JLabel jlab = new JLabel(new ImageIcon(path + "flower.png"));
        JLabel jlab2 = new JLabel();
        cboList.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String str = (String) cboList.getSelectedItem();
                jlab.setIcon(new ImageIcon(path+str+".png"));
            }
        });

        jfrm.add(cboList);
        jfrm.add(jlab);
        jfrm.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new i_JComboBox();
            }
        });
    }
}
