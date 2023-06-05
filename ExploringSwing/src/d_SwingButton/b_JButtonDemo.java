package d_SwingButton;
/*
* JButton
* Lớp JButton cung cấp chức năng của một nút nhấn. Bạn đã thấy một biểu thức đơn giản của nó trong chương trước.
* JButton cho phép một biểu tượng, một chuỗi hoặc cả hai được liên kết với nút nhấn. Ba trong số các constructor
* của nó được hiển thị ở đây:
*
* JButton(Icon icon)
* JButton(String str)
* JButton(String str, Icon icon)
*
* Ở đây, str và icon là chuỗi và biểu tượng được sử dụng cho nút.

* Khi nút được nhấn, một ActionEvent được tạo ra. Bằng cách sử dụng đối tượng ActionEvent được truyền vào
* phương thức actionPerformed() của ActionListener đã đăng ký, bạn có thể lấy chuỗi lệnh hành động được
* liên kết với nút. Mặc định, đây là chuỗi hiển thị bên trong nút. Tuy nhiên, bạn có thể đặt chuỗi lệnh
* hành động bằng cách gọi setActionCommand() trên nút. Bạn có thể lấy chuỗi lệnh hành động bằng cách gọi
* getActionCommand() trên đối tượng sự kiện. Nó được khai báo như sau:
*
* String getActionCommand()
*
* Lệnh hành động xác định nút. Do đó, khi sử dụng hai hoặc nhiều nút trong cùng một ứng dụng, lệnh hành động
* cung cấp một cách dễ dàng để xác định nút nào đã được nhấn.
*
* Trong chương trước, bạn đã thấy một ví dụ về một nút dựa trên văn bản. Sau đây là một ví dụ về một nút dựa
* trên biểu tượng. Nó hiển thị bốn nút nhấn và một nhãn. Mỗi nút hiển thị một biểu tượng đại diện cho một đồng hồ.
* Khi một nút được nhấn, tên của đồng hồ đó được hiển thị trong nhãn.
* */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class b_JButtonDemo implements ActionListener {
    JLabel jlab;
    b_JButtonDemo() {
        JFrame jfrm = new JFrame("JButton Demo");
        jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jfrm.setLayout(new FlowLayout());
        jfrm.setSize(500, 450);

        //Thêm button vào content pane
        //Button với icon


        //1
        ImageIcon horse = new ImageIcon("E:\\SwingIcon\\horse.png");
        //Có thể ảnh sẽ lớn và để thu nhỏ kích thước của ảnh có thể làm như sau:
        //Lấy đối tượng Image từ ImageIcon
        Image originImage = horse.getImage().getScaledInstance(100,100, Image.SCALE_SMOOTH);
        //Phương thức getImage() trả về 1 Image
        //Phương thức getScaledInstance() của Image giúp thay đổi kích thước ảnh
        //Image.SCALE_SMOOTH là một trong các giá trị được sử dụng cho tham số hints của phương thức
        //getScaledInstance() để chỉ định cách thức thu nhỏ ảnh. Giá trị này đại diện cho một thuật toán
        //thu nhỏ ảnh với chất lượng mượt mà
        horse = new ImageIcon(originImage); // Khởi tạo lại ImageIcon
        JButton btn1 = new JButton(horse);
        btn1.setActionCommand("Horse");
        btn1.addActionListener(this);
        jfrm.add(btn1);

        //2
        ImageIcon tree = new ImageIcon("E:\\SwingIcon\\tree.png");
        //Dùng lại đối tượng image bên trên
        originImage = tree.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        tree = new ImageIcon(originImage);
        JButton btn2 = new JButton(tree);
        btn2.setActionCommand("Tree");
        btn2.addActionListener(this);
        jfrm.add(btn2);

        //3
        ImageIcon flower = new ImageIcon("E:\\SwingIcon\\flower.png");
        originImage = flower.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        flower = new ImageIcon(originImage);
        JButton btn3 = new JButton(flower);
        btn3.setActionCommand("Flower");
        btn3.addActionListener(this);
        jfrm.add(btn3);

        //4
        ImageIcon car = new ImageIcon("E:\\SwingIcon\\meter.png");
        originImage = car.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        car = new ImageIcon(originImage);
        JButton btn4 = new JButton(car);
        btn4.setActionCommand("Car");
        btn4.addActionListener(this);
        jfrm.add(btn4);

        jlab = new JLabel("Choose a picture");
        jfrm.add(jlab);

        jfrm.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        jlab.setText("You selected: " + e.getActionCommand());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new b_JButtonDemo();
            }
        });
    }
}
