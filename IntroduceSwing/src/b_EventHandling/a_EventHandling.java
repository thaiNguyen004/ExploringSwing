package b_EventHandling;

import javax.swing.*;

/*
* Xử lý Sự kiện
Ví dụ trước đã trình bày hình thức cơ bản của một chương trình Swing, nhưng đã bỏ qua một phần quan trọng: xử lý sự kiện.
* Vì JLabel không lấy đầu vào từ người dùng, nên nó không tạo ra sự kiện, do đó không cần xử lý sự kiện. Tuy nhiên,
* các thành phần Swing khác đáp ứng đầu vào từ người dùng và các sự kiện được tạo ra bởi các tương tác đó cần được xử lý.
* Các sự kiện cũng có thể được tạo ra theo cách không liên quan trực tiếp đến đầu vào từ người dùng. Ví dụ, một sự kiện
* được tạo ra khi một bộ đếm thời gian kết thúc. Dù thế nào, xử lý sự kiện là một phần quan trọng của bất kỳ ứng dụng
* dựa trên Swing nào.
*
* Cơ chế xử lý sự kiện được sử dụng bởi Swing là giống như cơ chế được sử dụng bởi AWT. Phương pháp này được gọi là mô hình
* sự kiện giao nhiệm vụ (delegation event model), và nó được mô tả trong Chương 24. Trong nhiều trường hợp, Swing sử dụng
* các sự kiện giống như AWT, và các sự kiện này được đóng gói trong java.awt.event. Các sự kiện cụ thể cho Swing được
* lưu trữ trong javax.swing.event.
*
* Mặc dù sự kiện được xử lý trong Swing theo cách giống như với AWT, việc làm việc qua một ví dụ đơn giản vẫn hữu ích.
* Chương trình sau xử lý sự kiện được tạo ra bởi một nút nhấn Swing. Đầu ra mẫu được hiển thị trong Hình 31-2.
*
* */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class a_EventHandling {

    //Tạo biến thành viên toàn cục
    JLabel jlab;

    a_EventHandling () {
        JFrame jfrm = new JFrame("An event example");

        //specify FlowLayout for the layout manager
        //Chỉ định FLowLayout cho trình quản lý layout
        jfrm.setLayout(new FlowLayout());

        //Give to the frame an initial size
        //Cung cấp kích thước ban đầu cho khung
        jfrm.setSize(220, 90);

        //Terminate the program when user closes the application
        //Kết thúc chương trình khi người dùng đóng ứng dụng
        jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Tạo ra 2 nút bằng Jbutton
        JButton btnAlpha = new JButton("Alpha");
        JButton btnBeta = new JButton("Beta");

        //Tạo lắng nghe sự kiện cho Alpha
        btnAlpha.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jlab.setText("Bạn đã nhấn Alpha");
            }
        });

//        btnBeta.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                jlab.setText("Bạn đã nhấn Beta");
//            }
//        });

        //Sử dụng lambda cho trường hợp này
        btnBeta.addActionListener((e) -> jlab.setText("Bạn đã nhấn Beta"));

        jfrm.add(btnAlpha);
        jfrm.add(btnBeta);

        //Tạo ra một nhãn dựa trên văn bản
        jlab = new JLabel("Vui lòng nhấn nút");
        jfrm.add(jlab);

        jfrm.setVisible(true);

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new a_EventHandling();
            }
        });
    }
}
/*
* Đầu tiên, hãy chú ý rằng chương trình hiện đã import cả hai gói java.awt và java.awt.event. Gói java.awt được cần để
* chứa lớp FlowLayout, hỗ trợ bố trí theo luồng tiêu chuẩn được sử dụng để bố trí các thành phần trong một frame.
* (Xem Chương 26 để biết về các bố trí.) Gói java.awt.event được cần để định nghĩa giao diện ActionListener và lớp ActionEvent.
*
* Constructor a_EventHandling bắt đầu bằng việc tạo một JFrame có tên jfrm. Sau đó, nó đặt bố trí cho content pane của jfrm
* thành FlowLayout. Mặc định, content pane sử dụng BorderLayout làm bố trí. Tuy nhiên, cho ví dụ này, FlowLayout là thuận tiện hơn.
*
* Sau khi đặt kích thước và hoạt động đóng mặc định, a_EventHandling() tạo hai nút nhấn, như được hiển thị dưới đây:

JButton jbtnAlpha = new JButton("Alpha");
JButton jbtnBeta = new JButton("Beta");

* Nút nhấn đầu tiên sẽ chứa văn bản "Alpha" và nút thứ hai sẽ chứa văn bản "Beta". Các nút nhấn Swing là các phiên bản của JButton.
* JButton cung cấp một số constructor. Constructor được sử dụng ở đây là:
*
* JButton(String msg)
*
* Tham số msg xác định chuỗi sẽ được hiển thị bên trong nút. Khi một nút nhấn được nhấn, nó tạo ra một ActionEvent.
* Do đó, JButton cung cấp phương thức addActionListener(), được sử dụng để thêm một action listener.
* (JButton cũng cung cấp removeActionListener() để gỡ bỏ một người nghe, nhưng phương thức này không được sử dụng bởi chương trình.)
* Như đã giải thích trong Chương 24, giao diện ActionListener chỉ định một phương thức: actionPerformed(). Đây là phương thức
* được gọi khi một nút nhấn được nhấn. Nó là trình xử lý sự kiện được gọi khi một sự kiện nhấn nút đã xảy ra.
*
* Tiếp theo, người nghe sự kiện cho các sự kiện hành động của nút được thêm vào bằng đoạn mã được hiển thị dưới đây:
*
        btnAlpha.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jlab.setText("Bạn đã nhấn Alpha");
            }
        });

        btnBeta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jlab.setText("Bạn đã nhấn Beta");
            }
        });
*
* Ở đây, các lớp nội danh (anonymous inner classes) được sử dụng để cung cấp các bộ xử lý sự kiện cho hai nút. Mỗi khi
* một nút được nhấn, chuỗi hiển thị trên jlab được thay đổi để phản ánh nút nào đã được nhấn.
*
* Bắt đầu từ JDK 8, biểu thức lambda cũng có thể được sử dụng để triển khai một số loại bộ xử lý sự kiện. Ví dụ, bộ xử lý
* sự kiện cho nút Alpha có thể được viết như sau:
*
* jbtnAlpha.addActionListener((ae) -> jlab.setText("Alpha was pressed."));
*
* Như bạn có thể thấy, đoạn mã này ngắn gọn hơn. Tất nhiên, phương pháp bạn chọn sẽ phụ thuộc vào tình huống và
* sở thích của riêng bạn.
*
* Tiếp theo, các nút được thêm vào nội dung của jfrm:
* jfrm.add(jbtnAlpha);
* jfrm.add(jbtnBeta);
*
* Cuối cùng, jlab được thêm vào nội dung và cửa sổ được làm hiển thị.
* Khi bạn chạy chương trình, mỗi khi bạn nhấn một nút, một thông báo được hiển thị trên nhãn cho biết nút nào đã được nhấn.
*
* Một điểm cuối cùng: Hãy nhớ rằng tất cả các bộ xử lý sự kiện, như actionPerformed(), được gọi trên luồng xử lý sự kiện.
* Do đó, một bộ xử lý sự kiện phải trả về nhanh chóng để tránh làm chậm ứng dụng. Nếu ứng dụng của bạn cần thực hiện một
* công việc tốn thời gian sau một sự kiện, nó phải sử dụng một luồng riêng biệt.
* */