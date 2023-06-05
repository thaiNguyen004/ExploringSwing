package b_JLabel_ImageIcon;
/*
* JLabel và ImageIcon
* JLabel là thành phần dễ sử dụng nhất của Swing. Nó tạo ra một nhãn và đã được giới thiệu
* trong chương trước. Ở đây, chúng ta sẽ xem xét JLabel một chút kỹ hơn. JLabel có thể được
* sử dụng để hiển thị văn bản và/hoặc biểu tượng. Nó là một thành phần bị động vì nó không
* phản ứng với đầu vào từ người dùng. JLabel định nghĩa một số hàm tạo. Dưới đây là ba trong
* số chúng:
*
* JLabel(Icon icon)
* JLabel(String str)
* JLabel(String str, Icon icon, int align)
*
* Ở đây, str và icon là văn bản và biểu tượng được sử dụng cho nhãn. Đối số align chỉ
* định căn chỉnh ngang của văn bản và/hoặc biểu tượng trong kích thước của nhãn. Nó phải
* là một trong các giá trị sau: LEFT, RIGHT, CENTER, LEADING hoặc TRAILING. Các hằng số
* này được định nghĩa trong giao diện SwingConstants, cùng với một số hằng số khác được
* sử dụng bởi các lớp Swing.
*
* Lưu ý rằng biểu tượng được chỉ định bằng các đối tượng có kiểu Icon, là một giao diện
* được định nghĩa bởi Swing. Cách đơn giản nhất để có được một biểu tượng là sử dụng
* lớp ImageIcon. ImageIcon triển khai giao diện Icon và bao gồm một hình ảnh. Do đó,
* một đối tượng của lớp ImageIcon có thể được truyền như một đối số cho tham số Icon
* của hàm tạo JLabel. Có một số cách để cung cấp hình ảnh, bao gồm đọc từ một tệp hoặc
* tải từ một URL. Dưới đây là hàm tạo của ImageIcon được sử dụng trong ví dụ trong phần này:
*
* ImageIcon(String filename)
*
* Nó lấy hình ảnh trong tệp có tên là filename.
*
* Biểu tượng và văn bản được liên kết với nhãn có thể được lấy bằng các phương thức sau:
* Icon getIcon()
* String getText()
*
* Biểu tượng và văn bản liên kết với một nhãn có thể được đặt bằng các phương thức sau:
* void setIcon(Icon icon)
* void setText(String str)
*
* Ở đây, icon và str lần lượt là biểu tượng và văn bản. Do đó, bằng cách sử dụng setText(),
* bạn có thể thay đổi văn bản bên trong một nhãn trong quá trình thực thi chương trình.
*
* Chương trình sau minh họa cách tạo và hiển thị một nhãn chứa cả một biểu tượng và một chuỗi.
* Nó bắt đầu bằng cách tạo một đối tượng ImageIcon cho tệp hourglass.png, mô tả một cái bình cát.
* Đây được sử dụng làm đối số thứ hai cho hàm tạo JLabel. Các đối số đầu tiên và cuối cùng
* cho hàm tạo JLabel là văn bản nhãn và căn chỉnh. Cuối cùng, nhãn được thêm vào bảng nội dung.
*
* */

import javax.swing.*;
import java.awt.*;

public class georyAndExample {
    georyAndExample() {
        JFrame jfrm = new JFrame("JLabel demo");
        jfrm.setLayout(new FlowLayout()); //Set layout
        jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jfrm.setSize(260, 120);

        //Tạo ra một icon
        ImageIcon ii = new ImageIcon("E:\\Studyspace\\Java\\source\\ExploringSwing\\ExploringSwing\\src\\b_JLabel_ImageIcon\\img\\hourglass.jpg");

        //Create a label
        //Tạo ra một nhãn
        JLabel jlab = new JLabel("Hourglass", ii, JLabel.CENTER);

        //Thêm JLabel vào content pane
        jfrm.add(jlab);

        //Hiển thị JFrame
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
