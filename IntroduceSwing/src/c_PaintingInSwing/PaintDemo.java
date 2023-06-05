package c_PaintingInSwing;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

/*
* Một ví dụ về vẽ tranh
* Đây là một chương trình thực hiện các bước trước đó. Nó tạo ra một lớp gọi là PaintPanel mở rộng JPanel.
* Sau đó, chương trình sử dụng một đối tượng của lớp đó để hiển thị các đường thẳng có điểm kết thúc được
* tạo ngẫu nhiên. */

//Lớp này mở rộng JPanel và ghi đè phương thức paintComponent() để các dòng đường thẳng
//ngẫu nhiên được vẽ trong bảng điều khiển
class PanelPaint extends JPanel {
    Insets ins;
    Random rand;

    PanelPaint() {
        //Đặt một đường viền xung quay bảng điều khiển (panel)
        setBorder(BorderFactory.createLineBorder(Color.RED, 5)); //độ dày : 5
        rand = new Random();
    }

    @Override
    protected void paintComponent(Graphics g) {
        //Luôn gọi phương thức super đầu tiên
        super.paintComponent(g);

        int x, y, x2, y2;

        //Lấy chiều cao chiều rộng của component
        int height = getHeight();
        int width = getWidth();

        //Khởi tạo đối tượng viền
        ins = getInsets();

        //Vẽ 10 dòng có điểm cuối được tạo ngẫu nhiên
        for (int i = 0; i < 10; i++) {
            x = rand.nextInt(width - ins.left);
            y = rand.nextInt(height - ins.bottom);
            x2 = rand.nextInt(width - ins.left);
            y2 = rand.nextInt(height - ins.bottom);

            g.drawLine(x, y, x2, y2);
        }
    }
}

public class PaintDemo {
    JLabel jlab;
    PanelPaint pp;

    PaintDemo () {
        JFrame jfrm = new JFrame("Paint Demo");
        jfrm.setSize(200,150);
        jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        pp = new PanelPaint();
        jfrm.add(pp);

        jfrm.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new PaintDemo();
            }
        });
    }
}

/*
* Hãy xem xét chương trình này một cách cẩn thận. Lớp PaintPanel mở rộng JPanel.
* JPanel là một trong những container nhẹ của Swing, có nghĩa là nó là một thành phần có thể được thêm vào nội dung
* của một JFrame. Để xử lý việc vẽ, PaintPanel ghi đè phương thức paintComponent().
*
* Điều này cho phép PaintPanel ghi trực tiếp vào bề mặt của thành phần khi thực hiện việc vẽ. Kích thước của panel
* không được chỉ định vì chương trình sử dụng bố cục mặc định là border layout và panel được thêm vào vị trí trung tâm.
* Điều này dẫn đến panel có kích thước để điền vào trung tâm. Nếu bạn thay đổi kích thước của cửa sổ, kích thước của panel
* sẽ được điều chỉnh tương ứng.
*
* Lưu ý rằng hàm tạo cũng xác định một đường viền màu đỏ có chiều rộng 5 pixel. Điều này được thực hiện bằng cách
* sử dụng phương thức setBorder(), được hiển thị ở đây:
* void setBorder(Border border)
* Border là giao diện Swing bao gồm một đường viền. Bạn có thể lấy một đường viền bằng cách gọi một trong những phương
* thức factory được định nghĩa bởi lớp BorderFactory. Phương thức được sử dụng trong chương trình là createLineBorder(),
* tạo một đường viền đơn giản, được hiển thị ở đây:
*
* static Border createLineBorder(Color clr, int width)
*
* Ở đây, clr xác định màu của đường viền và width xác định chiều rộng của nó theo pixel.
*
* Bên trong việc ghi đè phương thức paintComponent(), lưu ý rằng trước tiên nó gọi super.paintComponent().
* Như đã giải thích, điều này là cần thiết để đảm bảo thành phần được vẽ đúng cách. Tiếp theo, chiều rộng và chiều cao
* của panel được khởi tạo cùng với insets. Những giá trị này được sử dụng để đảm bảo các đường nằm trong khu vực vẽ
* của panel. Khu vực vẽ là tổng chiều rộng và chiều cao của một thành phần trừ đi chiều rộng của đường viền.
* Các tính toán được thiết kế để hoạt động với PaintPanels và các đường viền có kích thước khác nhau.
* Để chứng minh điều này,
* hãy thử thay đổi kích thước của cửa sổ. Các đường vẽ vẫn nằm trong đường viền của panel.
*
* Lớp PaintDemo tạo một PaintPanel và sau đó thêm panel vào nội dung của cửa sổ. Khi ứng dụng được hiển thị lần đầu tiên,
* phương thức ghi đè paintComponent() được gọi và các đường được vẽ. Mỗi khi bạn thay đổi kích thước hoặc ẩn và
* khôi phục cửa sổ, một tập mới các đường được vẽ. Trong tất cả các trường hợp, các đường nằm trong khu vực có thể vẽ được.
* */
