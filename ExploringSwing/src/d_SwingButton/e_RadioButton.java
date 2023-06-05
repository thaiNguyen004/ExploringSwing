package d_SwingButton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
* Nút Radio
* Nút radio là một nhóm các nút đồng thời, trong đó chỉ có một nút được chọn vào một thời điểm. Chúng được hỗ trợ
* bởi lớp JRadioButton, mở rộng từ JToggleButton. JRadioButton cung cấp một số hàm khởi tạo. Trong ví dụ này, chúng ta
* sử dụng hàm khởi tạo như sau:
* JRadioButton(String str)
* Ở đây, str là nhãn cho nút. Các hàm khởi tạo khác cho phép bạn chỉ định trạng thái chọn ban đầu của nút và
* chỉ định một biểu tượng.
*
* Để kích hoạt tính năng độc quyền giữa các nút radio, chúng cần được cấu hình thành một nhóm. Chỉ có một nút trong
* nhóm được chọn vào một thời điểm. Ví dụ, nếu người dùng nhấp vào một nút radio trong một nhóm, bất kỳ nút đã được
* chọn trước đó trong nhóm đó sẽ tự động bị hủy chọn.
*
* Một nhóm nút được tạo bằng lớp ButtonGroup. Hàm tạo mặc định của nó được gọi cho mục đích này.
* Các phần tử sau đó được thêm vào nhóm nút thông qua phương thức sau:
* void add(AbstractButton ab)
* Ở đây, ab là một tham chiếu đến nút cần được thêm vào nhóm.
*
* Một JRadioButton tạo ra các sự kiện hành động, sự kiện mục và sự kiện thay đổi mỗi khi lựa chọn nút thay đổi.
* Thông thường, sự kiện hành động được xử lý, điều đó có nghĩa là bạn thường sẽ triển khai giao diện ActionListener.
* Hãy nhớ rằng chỉ có một phương thức được định nghĩa bởi ActionListener, đó là actionPerformed ().
* Trong phương thức này, bạn có thể sử dụng nhiều cách khác nhau để xác định nút nào đã được chọn.
*
* Đầu tiên, bạn có thể kiểm tra lệnh hành động của nút bằng cách gọi getActionCommand (). Mặc định, lệnh hành động
* giống như nhãn nút, nhưng bạn có thể đặt lệnh hành động thành một giá trị khác bằng cách gọi setActionCommand ()
* trên nút radio.
*
* Thứ hai, bạn có thể gọi getSource () trên đối tượng ActionEvent và kiểm tra tham chiếu đó với các nút.
*
* Thứ ba, bạn có thể kiểm tra từng nút radio để biết nút nào đang được chọn bằng cách gọi isSelected () trên mỗi nút.
* Cuối cùng, mỗi nút có thể sử dụng bộ xử lý sự kiện hành động riêng của nó được triển khai dưới dạng một lớp
* nội danh ẩn danh hoặc một biểu thức lambda. Hãy nhớ, mỗi khi xảy ra một sự kiện hành động, điều đó có nghĩa là
* nút được chọn đã thay đổi và chỉ có một nút duy nhất sẽ được chọn.
*
* Ví dụ sau minh họa cách sử dụng các nút radio. Ba nút radio được tạo ra. Sau đó, các nút được thêm vào một nhóm nút.
* Như đã giải thích, điều này là cần thiết để tạo ra hành vi độc quyền cho chúng. Nhấp vào một nút radio tạo ra một
* sự kiện hành động, được xử lý bởi actionPerformed (). Trong bộ xử lý đó, phương thức getActionCommand ()
* lấy văn bản liên kết với nút radio và sử dụng nó để đặt văn bản trong một nhãn.
*
* */
public class e_RadioButton implements ActionListener {
    JLabel jlab;
    e_RadioButton() {
        JFrame jfrm = new JFrame("JRadioButton Demo");
        jfrm.setLayout(new FlowLayout());
        jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jfrm.setSize(250, 100);

        //Add radio button to content pane
        JRadioButton b1 = new JRadioButton("A");
        b1.addActionListener(this);
        jfrm.add(b1);

        JRadioButton b2 = new JRadioButton("B");
        b2.addActionListener(this);
        jfrm.add(b2);

        JRadioButton b3 = new JRadioButton("C");
        b3.addActionListener(this);
        jfrm.add(b3);

        ButtonGroup bg = new ButtonGroup();
        bg.add(b1);
        bg.add(b2);
        bg.add(b3);

        jlab = new JLabel("Chọn 1");
        jfrm.add(jlab);

        jfrm.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        jlab.setText("You selected " + e.getActionCommand());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new e_RadioButton();
            }
        });
    }
}
