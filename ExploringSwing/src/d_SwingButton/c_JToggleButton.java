package d_SwingButton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

/*
* JToggleButton
* Một biến thể hữu ích của nút nhấn được gọi là nút chuyển đổi (toggle button). Nút chuyển đổi có hình dạng
* giống nút nhấn thông thường, nhưng hoạt động khác vì nó có hai trạng thái: được nhấn và được thả ra.
* Đó là, khi bạn nhấn vào một nút chuyển đổi, nó sẽ giữ trạng thái được nhấn và không nhảy lên như một
* nút nhấn thông thường. Khi bạn nhấn vào nút chuyển đổi lần thứ hai, nó sẽ được thả ra (nhảy lên).
* Do đó, mỗi lần nhấn vào nút chuyển đổi, nó sẽ chuyển đổi giữa hai trạng thái của nó.
*
* Nút chuyển đổi là các đối tượng của lớp JToggleButton. JToggleButton triển khai AbstractButton.
* Ngoài việc tạo ra các nút chuyển đổi tiêu chuẩn, JToggleButton cũng là một lớp cha cho hai thành phần Swing
* khác cũng đại diện cho các điều khiển hai trạng thái. Đó là JCheckBox và JRadioButton, được mô tả sau trong chương này.
* Do đó, JToggleButton định nghĩa các chức năng cơ bản của tất cả các thành phần hai trạng thái.
*
* JToggleButton định nghĩa một số hàm tạo. Hàm tạo được sử dụng trong ví dụ trong phần này được hiển thị như sau:
* JToggleButton(String str)
* Điều này tạo ra một nút chuyển đổi chứa văn bản được truyền qua biến str. Mặc định, nút được đặt ở trạng thái tắt.
* Các hàm tạo khác cho phép bạn tạo ra các nút chuyển đổi chứa hình ảnh, hoặc hình ảnh và văn bản.
*
* JToggleButton sử dụng một mô hình được định nghĩa bởi một lớp lồng gọi là JToggleButton.ToggleButtonModel.
* Thông thường, bạn không cần tương tác trực tiếp với mô hình để sử dụng một nút chuyển đổi tiêu chuẩn.
*
* Giống như JButton, JToggleButton tạo ra một sự kiện action mỗi khi được nhấn. Tuy nhiên, khác với JButton,
* JToggleButton cũng tạo ra một sự kiện item. Sự kiện này được sử dụng bởi những thành phần hỗ trợ khái niệm lựa chọn.
* Khi một JToggleButton được nhấn vào, nó được chọn. Khi nó được nhấn ra, nó bị bỏ chọn.
*
* Để xử lý các sự kiện item, bạn phải triển khai giao diện ItemListener. Nhớ từ Chương 24, mỗi khi một sự kiện item được
* tạo ra, nó được truyền vào phương thức itemStateChanged() được định nghĩa bởi ItemListener. Bên trong itemStateChanged(),
* phương thức getItem() có thể được gọi trên đối tượng ItemEvent để lấy một tham chiếu đến thể hiện JToggleButton đã
* tạo ra sự kiện. Đây là phương thức getItem():
*
* Object getItem()
*
* Một tham chiếu đến nút được trả về. Bạn cần phải ép kiểu tham chiếu này thành JToggleButton.
*
* Cách đơn giản nhất để xác định trạng thái của một nút chuyển đổi là gọi phương thức isSelected()
* (được kế thừa từ AbstractButton) trên nút đã tạo ra sự kiện. Đây là phương thức isSelected():
*
* boolean isSelected()
*
* Nó trả về true nếu nút đã được chọn và false nếu không.
*
* Dưới đây là một ví dụ sử dụng một nút chuyển đổi. Lưu ý cách item listener hoạt động. Nó đơn giản chỉ gọi
* isSelected() để xác định trạng thái của nút.
*
* */
public class c_JToggleButton {
    c_JToggleButton() {
        JFrame jfrm = new JFrame("JToggle Button Demo");
        jfrm.setLayout(new FlowLayout());
        jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jfrm.setSize(400,200);
        jfrm.setLocationRelativeTo(null);

        //Tạo một Label
        JLabel jlab = new JLabel("Button is off");

        //Tạo ra một toogle button
        JToggleButton jtbtn = new JToggleButton("On/Off");
        jtbtn.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(jtbtn.isSelected())
                    jlab.setText("Button is on");
                else
                    jlab.setText("Button is off");
            }
        });

        //Thêm vào content pane
        jfrm.add(jtbtn);
        jfrm.add(jlab);

        jfrm.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new c_JToggleButton();
            }
        });
    }
}
