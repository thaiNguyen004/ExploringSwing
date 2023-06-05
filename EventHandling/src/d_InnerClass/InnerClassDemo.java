package d_InnerClass;

/*
* Dưới đây là đoạn mã minh họa cho việc cải thiện chương trình trước đó bằng cách sử dụng một lớp nội tại.
* Ở đây, InnerClassDemo là lớp cấp cao nhất và MyMouseAdapter là một lớp nội tại. Vì MyMouseAdapter được định nghĩa
* trong phạm vi của InnerClassDemo, nó có quyền truy cập vào tất cả các biến và phương thức trong phạm vi của lớp đó.
* Do đó, phương thức mousePressed() có thể gọi trực tiếp phương thức repaint(). Không cần thiết phải làm điều này thông
* qua một tham chiếu được lưu trữ. Tương tự, việc gán giá trị cho biến msg cũng không cần thiết. Do đó, không cần phải
* truyền một tham chiếu tới đối tượng gọi vào MyMouseAdapter(). Hãy lưu ý rằng MyWindowAdapter đã được biến thành một
* lớp nội tại.*/

import jdk.dynalink.beans.StaticClass;

import java.awt.*;
import java.awt.event.*;
public class InnerClassDemo extends Frame{
    String msg = "";

    public InnerClassDemo() {
        addMouseListener(new MyMouseAdapter());
        addWindowListener(new MyWindowAdapter());
    }

    @Override
    public void paint(Graphics g) {
        g.setColor(Color.RED);
        g.drawString(msg, 20, 80);
    }

    //Lớp inner class sử lý sự kiện mouse pressed
    class MyMouseAdapter extends MouseAdapter {
        @Override
        public void mousePressed(MouseEvent e) {
            msg = "Mouse Pressed";
            repaint();
        }
    }

    //Lớp inner class sử lý sự kiện đóng của cửa sổ
    static class MyWindowAdapter extends WindowAdapter {
        @Override
        public void windowClosing(WindowEvent e) {
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        InnerClassDemo appwin = new InnerClassDemo();

        appwin.setTitle("Inner Class Demo");
        appwin.setSize(new Dimension(200,150));
        appwin.setLocationRelativeTo(null);
        appwin.setVisible(true);
    }
}
