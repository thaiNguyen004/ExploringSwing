package d_SwingButton;

import javax.swing.*;
import javax.swing.event.ListSelectionListener;

/*
* JTable là một thành phần hiển thị các hàng và cột dữ liệu. Bạn có thể kéo con trỏ trên các ranh giới cột để
* điều chỉnh kích thước cột. Bạn cũng có thể kéo một cột sang vị trí mới. Tùy thuộc vào cấu hình của nó, bạn
* cũng có thể chọn một hàng, cột hoặc ô trong bảng và thay đổi dữ liệu trong một ô.
*
* JTable là một thành phần phức tạp cung cấp nhiều tùy chọn và tính năng hơn có thể được thảo luận ở đây
* (Nó có thể là thành phần phức tạp nhất của Swing). Tuy nhiên, trong cấu hình mặc định, JTable vẫn cung cấp
* các chức năng đáng kể và dễ sử dụng - đặc biệt là nếu bạn chỉ muốn sử dụng bảng để hiển thị dữ liệu theo
* định dạng bảng. Tổng quan ngắn gọn được trình bày ở đây sẽ giúp bạn hiểu tổng quan về thành phần mạnh mẽ này.
*
* Tương tự như JTree, JTable có nhiều lớp và giao diện liên quan. Chúng được đóng gói trong javax.swing.table.
*
* Ở bản chất, JTable là đơn giản về mặt khái niệm. Đó là một thành phần gồm một hoặc nhiều cột thông tin.
* Ở đầu mỗi cột là một tiêu đề. Ngoài việc mô tả dữ liệu trong một cột, tiêu đề còn cung cấp cơ chế cho phép
* người dùng thay đổi kích thước một cột hoặc thay đổi vị trí của cột trong bảng. JTable không cung cấp khả năng
* cuộn của riêng nó. Thay vào đó, thông thường bạn sẽ bọc một JTable trong một JScrollPane.
*
* JTable cung cấp một số hàm tạo. Trong đoạn mã này, chúng ta sử dụng hàm tạo sau:
* JTable(Object data[][], Object colHeads[]). Ở đây, data là một mảng hai chiều chứa thông tin sẽ được hiển thị
* và colHeads là một mảng một chiều chứa các tiêu đề cột.
*
* JTable dựa trên ba mô hình. Mô hình đầu tiên là mô hình bảng, được định nghĩa bởi giao diện TableModel.
* Mô hình này định nghĩa những thứ liên quan đến hiển thị dữ liệu theo định dạng hai chiều. Mô hình thứ hai là
* mô hình cột bảng, được biểu diễn bởi TableColumnModel. JTable được định nghĩa dựa trên các cột và TableColumnModel
* chỉ định các đặc điểm của một cột. Hai mô hình này được đóng gói trong javax.swing.table.
* Mô hình thứ ba xác định cách các mục được chọn và được chỉ định bởi ListSelectionModel,
* đã được mô tả khi thảo luận về JList.
*
* Một JTable có thể tạo ra nhiều sự kiện khác nhau. Hai sự kiện quan trọng nhất đối với hoạt động của bảng là
* ListSelectionEvent và TableModelEvent. Một ListSelectionEvent được tạo ra khi người dùng chọn một cái gì đó
* trong bảng. Mặc định, JTable cho phép bạn chọn một hoặc nhiều hàng hoàn chỉnh, nhưng bạn có thể thay đổi hành vi
* này để cho phép chọn một hoặc nhiều cột hoặc một hoặc nhiều ô riêng lẻ.
*
* Một TableModelEvent được kích hoạt khi dữ liệu của bảng thay đổi theo một cách nào đó. Xử lý các sự kiện này yêu cầu
* một chút công việc hơn để xử lý các sự kiện được tạo ra bởi các thành phần đã được mô tả trước đó và nằm ngoài
* phạm vi của cuốn sách này. Tuy nhiên, nếu bạn chỉ muốn sử dụng JTable để hiển thị dữ liệu (như ví dụ dưới đây),
* thì bạn không cần xử lý bất kỳ sự kiện nào.
*
* Dưới đây là các bước cần thiết để thiết lập một JTable đơn giản có thể được sử dụng để hiển thị dữ liệu:
1. Tạo một phiên bản của JTable.
2. Tạo một đối tượng JScrollPane, chỉ định bảng là đối tượng cần cuộn.
3. Thêm bảng vào scroll pane.
4. Thêm scroll pane vào nội dung của pane.
*
* Ví dụ dưới đây minh họa cách tạo và sử dụng một bảng đơn giản. Một mảng một chiều các chuỗi có tên colHeads
* được tạo cho các tiêu đề cột. Một mảng hai chiều các chuỗi có tên data được tạo cho các ô trong bảng.
* Bạn có thể thấy rằng mỗi phần tử trong mảng là một mảng gồm ba chuỗi. Các mảng này được truyền vào hàm tạo JTable.
* Bảng được thêm vào một scroll pane, sau đó scroll pane được thêm vào nội dung của pane. Bảng hiển thị dữ liệu
* trong mảng data. Cấu hình mặc định của bảng cũng cho phép chỉnh sửa nội dung của một ô. Những thay đổi ảnh hưởng đến
* mảng gốc, tức là data trong trường hợp này.
*
* */
public class l_JTable {
    String[] colHeads = {"Name", "Extension", "#ID"};
    Object[][] data = {
            {"Nguyên", "2414", "33935"},
            {"Dũng", "5264", "33936"},
            {"Thảo", "4275", "27515"},
            {"Sơn", "2582", "23552"},
            {"Linh", "5111", "51255"},
            {"Linh", "5111", "51255"},
            {"Linh", "5111", "51255"},
            {"Linh", "5111", "51255"},
            {"Linh", "5111", "51255"},
            {"Linh", "5111", "51255"},
            {"Linh", "5111", "51255"},
            {"Linh", "5111", "51255"},
            {"Linh", "5111", "51255"},
            {"Linh", "5111", "51255"},
            {"Linh", "5111", "51255"},
            {"Linh", "5111", "51255"},
            {"Linh", "5111", "51255"},
            {"Linh", "5111", "51255"},
            {"Linh", "5111", "51255"},
            {"Linh", "5111", "51255"}
    };

    JLabel jlab;

    l_JTable() {
        JFrame jfrm = new JFrame("Demo JTable");
        jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jfrm.setSize(300,300);

        //Tạo ra một JTable
        JTable table = new JTable(data, colHeads);


        //Thêm table vào 1 scrollpane
        JScrollPane jsp = new JScrollPane(table);

        jfrm.add(jsp);
        jfrm.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new l_JTable();
            }
        });
    }
}
