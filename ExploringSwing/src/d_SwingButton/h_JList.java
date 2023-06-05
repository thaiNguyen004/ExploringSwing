package d_SwingButton;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.util.List;

/*
* JList
* Trong Swing, lớp danh sách cơ bản được gọi là JList. Nó hỗ trợ việc chọn một hoặc nhiều mục từ danh sách.
* Mặc dù danh sách thường bao gồm chuỗi, nhưng có thể tạo danh sách của bất kỳ đối tượng nào có thể được hiển thị.
* JList được sử dụng rộng rãi trong Java, vì vậy rất ít có khả năng bạn chưa từng nhìn thấy nó trước đây.
*
* Trước đây, các mục trong JList được đại diện dưới dạng các tham chiếu đối tượng. Tuy nhiên, bắt đầu từ JDK 7,
* JList được làm thông qua việc sử dụng generics và được khai báo như sau:
* class JList<E>
* Ở đây, E đại diện cho loại của các mục trong danh sách.
*
* JList cung cấp một số hàm khởi tạo. Hàm khởi tạo được sử dụng ở đây là:
* JList(E[] items)
* Điều này tạo ra một JList chứa các mục trong mảng được chỉ định bởi items.
*
* JList dựa trên hai mô hình. Mô hình đầu tiên là ListModel. Giao diện này xác định cách truy cập dữ liệu của
* danh sách được thực hiện.
* Mô hình thứ hai là giao diện ListSelectionModel, xác định các phương thức xác định mục hoặc các mục được chọn.
* Mặc dù một JList sẽ hoạt động đúng bản thân nó, hầu hết thời gian bạn sẽ bọc một JList bên trong một JScrollPane.
* Điều này cho phép các danh sách dài tự động cuộn, từ đó đơn giản hóa thiết kế GUI. Nó cũng giúp dễ dàng thay đổi
* số lượng mục trong danh sách mà không cần thay đổi kích thước của thành phần JList.
*
* Một JList tạo ra một ListSelectionEvent khi người dùng chọn hoặc thay đổi lựa chọn. Sự kiện này cũng được tạo ra khi
* người dùng bỏ chọn một mục. Nó được xử lý bằng cách triển khai ListSelectionListener. Listener này chỉ định một
* phương thức duy nhất, được gọi là valueChanged(), được hiển thị như sau:
* void valueChanged(ListSelectionEvent le)
* Ở đây, le là một tham chiếu đến sự kiện. Mặc dù ListSelectionEvent cung cấp một số phương thức riêng của nó,
* thường bạn sẽ truy vấn đối tượng JList để xác định điều gì đã xảy ra. Cả ListSelectionEvent và ListSelectionListener
* được đóng gói trong javax.swing.event.
*
* Mặc định, một JList cho phép người dùng chọn nhiều dải mục trong danh sách, nhưng bạn có thể thay đổi hành vi này
* bằng cách gọi setSelectionMode(), được định nghĩa bởi JList. Nó được hiển thị như sau:
* void setSelectionMode(int mode)
* Ở đây, mode xác định chế độ lựa chọn. Nó phải là một trong các giá trị này được định nghĩa bởi ListSelectionModel:
* SINGLE_SELECTION
* SINGLE_INTERVAL_SELECTION
* MULTIPLE_INTERVAL_SELECTION
* Mặc định, lựa chọn nhiều dải cho phép người dùng chọn nhiều dải mục trong danh sách. Với lựa chọn một dải duy nhất,
* người dùng có thể chọn một dải mục duy nhất. Với lựa chọn duy nhất, người dùng chỉ có thể chọn một mục duy nhất.
* Tất nhiên, một mục duy nhất cũng có thể được chọn trong hai chế độ khác. Chúng chỉ cho phép chọn một dải mục.
*
* Bạn có thể lấy chỉ số của mục đầu tiên được chọn, cũng là chỉ số của mục duy nhất được chọn khi sử dụng chế độ
* lựa chọn duy nhất, bằng cách gọi getSelectedIndex(), được hiển thị như sau:
* int getSelectedIndex()
* Chỉ số bắt đầu từ không. Vì vậy, nếu mục đầu tiên được chọn, phương thức này sẽ trả về 0. Nếu không có mục nào
* được chọn, sẽ trả về -1.
*
* Thay vì lấy chỉ số của lựa chọn, bạn có thể lấy giá trị được liên kết với lựa chọn bằng cách gọi getSelectedValue():
* E getSelectedValue()
* Nó trả về một tham chiếu đến giá trị được chọn đầu tiên. Nếu không có giá trị nào được chọn, nó trả về null.
*
* Chương trình sau minh họa một JList đơn giản, chứa một danh sách các thành phố. Mỗi khi một thành phố được chọn
* trong danh sách, một ListSelectionEvent được tạo ra, được xử lý bằng phương thức valueChanged() được định nghĩa bởi
* ListSelectionListener. Nó đáp ứng bằng cách lấy chỉ số của mục đã chọn và hiển thị tên của thành phố đã chọn trong một nhãn.
*
* */
public class h_JList {
    String[] provinces = {"Hà Nội", "Hải Phòng", "Bắc Ninh", "Lào Cai"
            , "TP.Hồ Chí Minh", "Đà Nẵng", "Phú Thọ", "Vĩnh Phúc", "Yên Bái"};
    h_JList() {
        JFrame jfrm = new JFrame("Demo JList");
        jfrm.setLayout(new FlowLayout());
        jfrm.setSize(200, 200);
        jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Tạo một JList
        JList<String> jlist = new JList<>(provinces);

        //Chỉ định selection mode cho JList là single-selection
        jlist.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

        //Nên cho vào trong một JScrollPane
        JScrollPane jsp = new JScrollPane(jlist);
        jsp.setPreferredSize(new Dimension(120, 90));

        //Tạo nhãn hiển thị lựa chọn
        JLabel jlab = new JLabel("Chọn tỉnh");

        //Thêm đối tượng lắng nghe lựa chọn của JList
        jlist.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                //Trong trường hợp mode là SINGLE-SELECTION thì phương thức getSelectionIndex
                //sẽ trả về item đang được select
//                int index = jlist.getSelectedIndex();
//                if(index != -1)
//                    jlab.setText(provinces[index]);
//                else
//                    jlab.setText("Chọn 1 tỉnh");

                List<String> vals = jlist.getSelectedValuesList();
                if(vals != null)
                    jlab.setText(vals+" ");
                else
                    jlab.setText("Chọn tỉnh");
            }
        });

        jfrm.add(jsp);
        jfrm.add(jlab);
        jfrm.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new h_JList();
            }
        });
    }
}
