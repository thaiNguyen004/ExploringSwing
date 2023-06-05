package d_InnerClass;

/*
* Inner Class
* Trong Chương 7, cơ bản về Inner Class đã được giải thích. Ở đây, bạn sẽ thấy tại sao chúng quan trọng.
* Hãy nhớ rằng một Inner Class là một lớp được định nghĩa bên trong một lớp khác, hoặc thậm chí trong một biểu thức.
* Phần này minh họa cách sử dụng Inner Class để đơn giản hóa mã khi sử dụng các lớp adapter sự kiện.
*
* Để hiểu được lợi ích mà Inner Class mang lại, hãy xem chương trình được hiển thị trong danh sách tiếp theo.
* Nó không sử dụng Inner Class. Mục tiêu của chương trình là hiển thị chuỗi "Mouse Pressed" khi chuột được nhấn.
* Tương tự như phương pháp được sử dụng trong ví dụ trước đó, một tham chiếu đến đối tượng MousePressedDemo
* được truyền vào hàm tạo MyMouseAdapter và được lưu trữ. Tham chiếu này được sử dụng để gán một chuỗi cho biến msg
* và gọi phương thức repaint() trên đối tượng nhận sự kiện.
*
* Cải thiện bằng InnerClass bằng file InnerClassDemo.java*/

import java.awt.*;
import java.awt.event.*;
public class MousePressedDemo extends Frame{
    String msg = "";

    public MousePressedDemo() {
        addMouseListener(new MyMouseAdapter(this));
        addWindowListener(new MyWindowAdapter());
    }

    @Override
    public void paint(Graphics g) {
        g.drawString(msg, 20, 100);
    }

    public static void main(String[] args) {
        MousePressedDemo appwin = new MousePressedDemo();

        appwin.setSize(new Dimension(500, 500));
        appwin.setTitle("No inner class");
        appwin.setVisible(true);
    }
}

class MyMouseAdapter extends MouseAdapter {
    //Khởi tạo một tham chiếu đến đối tượng MousePressedDemo
    MousePressedDemo listener;

    public MyMouseAdapter (MousePressedDemo o) {
        listener = o;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        listener.msg = "Mouse Pressed";
        listener.repaint();
    }
}

class MyWindowAdapter extends WindowAdapter {
    @Override
    public void windowClosing(WindowEvent e) {
        System.exit(0);
    }
}
