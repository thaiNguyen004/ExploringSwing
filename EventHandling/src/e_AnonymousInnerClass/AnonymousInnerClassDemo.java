package e_AnonymousInnerClass;
/*
* Một lớp Anonymous Inner là một lớp không được gán tên. Phần này minh họa cách một lớp Anonymous Inner có thể giúp
* viết các trình xử lý sự kiện dễ dàng hơn. Hãy xem chương trình được hiển thị trong danh sách tiếp theo.
* Như trước đó, mục tiêu của chương trình là hiển thị chuỗi "Mouse Pressed" khi chuột được nhấn.*/

import java.awt.*;
import java.awt.event.*;
public class AnonymousInnerClassDemo extends Frame {
    String msg = "";

    public AnonymousInnerClassDemo () {
        //Anonymous inner class sử lý sự kiện mouse pressed
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                msg = "Mouse Pressed";
                repaint();
            }
        });

        //Anonymous inner class sử lý sự kiện closing window
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    @Override
    public void paint(Graphics g) {
        g.drawString(msg, 20, 80);
    }

    public static void main(String[] args) {
        AnonymousInnerClassDemo appwin = new AnonymousInnerClassDemo();

        appwin.setTitle("AnonymousInnerClassDemo");
        appwin.setSize(new Dimension(100, 160));
        appwin.setLocationRelativeTo(null);
        appwin.setVisible(true);
    }
}
/*
* Chương trình này có một lớp cấp cao nhất: AnonymousInnerClassDemo. Hàm tạo của nó gọi phương thức
* addMouseListener(). Đối số của nó là một biểu thức định nghĩa và khởi tạo một lớp nội tại ẩn danh.
* Hãy phân tích biểu thức này cẩn thận.
*
* Cú pháp new MouseAdapter(){...} cho biết cho trình biên dịch rằng đoạn mã giữa dấu ngoặc nhọn định nghĩa
* một lớp nội tại ẩn danh. Hơn nữa, lớp này mở rộng từ MouseAdapter. Lớp mới này không có tên, nhưng nó được
* tự động khởi tạo khi biểu thức này được thực thi. Cú pháp này có thể được tổng quát hóa và cũng tương tự
* khi tạo ra các lớp ẩn danh khác, chẳng hạn như khi một WindowAdapter ẩn danh được tạo bởi chương trình.
*
* Vì lớp nội tại ẩn danh này được định nghĩa trong phạm vi của AnonymousInnerClassDemo, nó có quyền truy cập
* vào tất cả các biến và phương thức trong phạm vi của lớp đó. Do đó, nó có thể gọi phương thức repaint()
* và truy cập trực tiếp vào biến msg.
*
* Như vừa được minh họa, cả Inner Class và Anonymous Inner Class giải quyết một số vấn đề phiền toái một cách
* đơn giản nhưng hiệu quả. Chúng cũng cho phép bạn tạo mã hiệu quả hơn.*/
