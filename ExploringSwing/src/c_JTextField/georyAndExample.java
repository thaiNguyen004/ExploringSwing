package c_JTextField;
/*
* JTextField
* JTextField là thành phần văn bản đơn giản nhất của Swing. Nó cũng có lẽ là thành phần văn bản được sử dụng rộng
* rãi nhất của nó. JTextField cho phép bạn chỉnh sửa một dòng văn bản. Nó được dẫn xuất từ JTextComponent, cung cấp
* chức năng cơ bản chung cho các thành phần văn bản của Swing. JTextField sử dụng giao diện Document cho mô hình của nó.
* Ba hàm tạo của JTextField được hiển thị dưới đây:
*
* JTextField(int cols)
* JTextField(String str, int cols)
* JTextField(String str)
*
* Ở đây, str là chuỗi để hiển thị ban đầu và cols là số cột trong trường văn bản. Nếu không có chuỗi nào được chỉ định,
* trường văn bản sẽ ban đầu trống. Nếu số cột không được chỉ định, trường văn bản sẽ được thay đổi kích thước để vừa với
* chuỗi đã chỉ định.
*
* JTextField sinh ra các sự kiện phản ứng với tương tác của người dùng. Ví dụ, một ActionEvent được phát ra khi người
* dùng nhấn phím Enter. Một CaretEvent được phát ra mỗi khi vị trí của caret (tức là con trỏ) thay đổi. (CaretEvent được
* đóng gói trong gói javax.swing.event.) Có thể có các sự kiện khác. Trong nhiều trường hợp, chương trình của bạn sẽ
* không cần xử lý các sự kiện này. Thay vào đó, bạn chỉ cần lấy chuỗi hiện tại trong trường văn bản khi cần thiết.
* Để lấy văn bản hiện tại trong trường văn bản, gọi getText().
*
* Ví dụ sau minh họa JTextField. Nó tạo ra một JTextField và thêm nó vào bảng nội dung. Khi người dùng nhấn phím Enter,
* một sự kiện hành động được tạo ra. Điều này được xử lý bằng cách hiển thị văn bản trong một nhãn.
* */
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
public class georyAndExample {
    georyAndExample() {
        JFrame jfrm = new JFrame("JTextFieldDemo");
        jfrm.setLayout(new FlowLayout());
        jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jfrm.setSize(260, 120);

        //Thêm một Text Field vào content pane
        JTextField jtf = new JTextField(15);
        jfrm.add(jtf);

        //Thêm một nhãn
        JLabel jlab = new JLabel();
        jfrm.add(jlab);

        //Sử lý Action events
        jtf.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Show text when user press ENTER
                jlab.setText(jtf.getText());
            }
        });

        jfrm.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new georyAndExample();
            }
        });
    }
}
