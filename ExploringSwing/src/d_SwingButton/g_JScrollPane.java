package d_SwingButton;

import javax.swing.*;
import java.awt.*;

/*
* JScrollPane
* JScrollPane là một container nhẹ tự động xử lý cuộn nội dung của một thành phần khác. Thành phần đang được
* cuộn có thể là một thành phần đơn lẻ, chẳng hạn như một bảng, hoặc một nhóm các thành phần được chứa trong một
* container nhẹ khác, chẳng hạn như JPanel. Trong cả hai trường hợp, nếu đối tượng đang được cuộn lớn hơn khu vực
* hiển thị, thanh cuộn ngang và/hoặc dọc sẽ được cung cấp tự động và thành phần có thể được cuộn qua pane.
* Bởi vì JScrollPane tự động cuộn, nó thường loại bỏ nhu cầu quản lý các thanh cuộn riêng lẻ.
*
* Khu vực hiển thị của một scroll pane được gọi là viewport. Đó là một cửa sổ trong đó thành phần đang được cuộn
* được hiển thị. Do đó, viewport hiển thị phần hiển thị của thành phần đang được cuộn. Các thanh cuộn cuộn thành phần
* qua viewport. Mặc định, JScrollPane sẽ tự động thêm hoặc xóa thanh cuộn khi cần thiết.
*
* Ví dụ, nếu thành phần cao hơn viewport, thanh cuộn dọc sẽ được thêm vào. Nếu thành phần hoàn toàn vừa với viewport,
* thanh cuộn sẽ bị loại bỏ.
*
* JScrollPane định nghĩa một số hàm khởi tạo. Hàm khởi tạo được sử dụng trong chương này được hiển thị như sau:
* JScrollPane(Component comp)
* Thành phần cần cuộn được chỉ định bởi comp. Các thanh cuộn sẽ được hiển thị tự động khi nội dung của pane
* vượt quá kích thước của viewport.
*
* Dưới đây là các bước để sử dụng scroll pane:
* 1. Tạo thành phần cần cuộn.
* 2. Tạo một thể hiện của JScrollPane, truyền vào đối tượng cần cuộn.
* 3. Thêm scroll pane vào content pane.
*
* Ví dụ sau minh họa một scroll pane. Trước tiên, một đối tượng JPanel được tạo, và 400 nút được thêm vào,
* sắp xếp thành 20 cột. Panel này sau đó được thêm vào một scroll pane, và scroll pane được thêm vào content pane.
* Vì panel lớn hơn viewport, thanh cuộn dọc và ngang sẽ xuất hiện tự động. Bạn có thể sử dụng thanh cuộn để cuộn
* các nút vào phạm vi hiển thị.
* */
public class g_JScrollPane {

    g_JScrollPane() {
        JFrame jfrm = new JFrame("Demo JScrollPane");
        jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jfrm.setSize(400, 400);

        //Tạo ra 1 JPanel là một container và chứa 400 nút
        JPanel jp = new JPanel();
        jp.setLayout(new GridLayout(20, 20));

        int b = 0;
        for(int i = 0; i < 20; i++){
            for (int j = 0; j < 20; j++) {
                jp.add(new JButton("Button " + b));
                b++;
            }
        }

        //Tạo ra một JScollPane đưa vào trong cons 1 container
        JScrollPane jsp = new JScrollPane(jp);
        //Thêm scroll pane vào content pane. Vì sử dụng border layout mặc định,
        //scroll pane sẽ được thêm vào vị trí trung tâm (center).
        jfrm.add(jsp, BorderLayout.CENTER);
        jfrm.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new g_JScrollPane();
            }
        });
    }
}
