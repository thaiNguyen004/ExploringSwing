package d_SwingButton;
/*
* Cây (Trees)
* Một cây là một thành phần hiển thị một cách phân cấp dữ liệu. Người dùng có khả năng mở rộng hoặc thu gọn từng nhánh
* con trong giao diện này. Trong Swing, cây được triển khai bằng lớp JTree. Dưới đây là một số ví dụ về các hàm
* khởi tạo của lớp JTree:
*
* JTree(Object obj [ ])
* JTree(Vector<?> v)
* JTree(TreeNode tn)
*
* Trong biểu thức đầu tiên, cây được tạo từ các phần tử trong mảng obj.
* Biểu thức thứ hai tạo cây từ các phần tử trong vector v.
* Trong biểu thức thứ ba, cây có nút gốc được chỉ định bởi tn.
*
* Mặc dù JTree được đóng gói trong gói javax.swing, các lớp và giao diện hỗ trợ của nó được đóng gói
* trong gói javax.swing.tree. Điều này là do số lượng các lớp và giao diện cần thiết để hỗ trợ JTree khá lớn.
*
* JTree phụ thuộc vào hai mô hình: TreeModel và TreeSelectionModel.
* JTree tạo ra một loạt các sự kiện, nhưng có ba sự kiện liên quan đặc biệt đến cây:
* TreeExpansionEvent, TreeSelectionEvent và TreeModelEvent.
*
* Sự kiện TreeExpansionEvent xảy ra khi một nút được mở rộng hoặc thu gọn.
* Một TreeSelectionEvent được tạo ra khi người dùng chọn hoặc bỏ chọn một nút trong cây.
* Một TreeModelEvent được kích hoạt khi dữ liệu hoặc cấu trúc của cây thay đổi.
* Các lớp lắng nghe cho các sự kiện này là TreeExpansionListener, TreeSelectionListener và TreeModelListener, tương ứng.
* Các lớp sự kiện cây và các giao diện lắng nghe được đóng gói trong javax.swing.event.
*
* Sự kiện được xử lý bởi chương trình mẫu được hiển thị trong phần này là TreeSelectionEvent.
* Để lắng nghe sự kiện này, bạn cần triển khai TreeSelectionListener. Nó chỉ định một phương thức duy nhất,
* được gọi là valueChanged(), nhận đối tượng TreeSelectionEvent. Bạn có thể lấy đường dẫn đến đối tượng đã chọn
* bằng cách gọi phương thức getPath() trên đối tượng sự kiện, như sau:
*
* TreePath getPath()
*
* Phương thức này trả về một đối tượng TreePath mô tả đường dẫn đến nút đã thay đổi. Lớp TreePath đóng gói thông tin
* về một đường dẫn đến một nút cụ thể trong cây.
* Nó cung cấp một số hàm khởi tạo và phương thức. Trong sách này, chỉ phương thức toString() được sử dụng,
* nó trả về một chuỗi mô tả đường dẫn.
*
* Giao diện TreeNode khai báo các phương thức để lấy thông tin về một nút trong cây. Ví dụ, ta có thể lấy tham chiếu
* đến nút cha hoặc một danh sách liệt kê các nút con. Giao diện MutableTreeNode mở rộng TreeNode và khai báo các
* phương thức cho phép chèn và xóa các nút con hoặc thay đổi nút cha.
*
* Lớp DefaultMutableTreeNode triển khai giao diện MutableTreeNode. Nó đại diện cho một nút trong cây.
* Dưới đây là một ví dụ về một trong các hàm khởi tạo của lớp này:
*
* DefaultMutableTreeNode(Object obj)
*
* Ở đây, obj là đối tượng được bao bọc trong nút cây này. Nút cây mới không có nút cha hoặc nút con.
*
* Để tạo một cấu trúc cây, ta có thể sử dụng phương thức add() của DefaultMutableTreeNode. Đây là cú pháp của phương thức:
*
* void add(MutableTreeNode child)
*
* Ở đây, child là một nút cây có thể thay đổi mà sẽ được thêm làm con cho nút hiện tại.
*
* JTree không cung cấp khả năng cuộn (scrolling) của riêng nó. Thay vào đó, thông thường ta đặt một JTree trong một
* JScrollPane. Như vậy, một cây lớn có thể được cuộn qua một khu vực nhìn nhỏ hơn.
*
* Dưới đây là các bước để sử dụng một cây:
1. Tạo một phiên bản của JTree.
2. Tạo một JScrollPane và chỉ định cây là đối tượng cần cuộn.
3. Thêm cây vào scroll pane.
4. Thêm scroll pane vào content pane.
*
* Ví dụ sau minh họa cách tạo một cây và xử lý lựa chọn. Chương trình tạo một phiên bản DefaultMutableTreeNode
* với nhãn "Options". Đây là nút gốc của cấu trúc cây. Các nút cây khác sau đó được tạo ra, và phương thức add()
* được gọi để kết nối các nút này với cây. Một tham chiếu đến nút gốc trong cây được cung cấp làm đối số cho hàm
* khởi tạo JTree. Cây sau đó được cung cấp làm đối số cho hàm khởi tạo JScrollPane. Scroll pane này sau đó được
* thêm vào content pane. Tiếp theo, một nhãn được tạo ra và được thêm vào content pane.
*
* Lựa chọn cây được hiển thị trong nhãn này. Để nhận các sự kiện lựa chọn từ cây, một TreeSelectionListener
* được đăng ký cho cây. Bên trong phương thức valueChanged(), đường dẫn đến lựa chọn hiện tại được lấy và hiển thị.
*
* */

import javax.swing.*;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import java.awt.*;
import javax.swing.tree.*;

//Demonstate JTree
public class k_JTree {
    k_JTree () {
        JFrame jfrm = new JFrame("Demo JTree");
        jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jfrm.setSize(200, 250);

        //Tạo node cha to nhất cho cây
        DefaultMutableTreeNode top = new DefaultMutableTreeNode("Options");

        //Tạo ra node con của node top "A"
        DefaultMutableTreeNode a = new DefaultMutableTreeNode("A");
        top.add(a); //Add node a vào làm node con của node top
        //Tạo ra các node con của node a
        DefaultMutableTreeNode a1 = new DefaultMutableTreeNode("A1");
        a.add(a1);
        DefaultMutableTreeNode a2 = new DefaultMutableTreeNode("A2");
        a.add(a2);

        //Tạo ra node con của node top "B"
        DefaultMutableTreeNode b = new DefaultMutableTreeNode("B");
        top.add(b); //Add node b vào làm node con của node top
        //Tạo ra các node con của node b
        DefaultMutableTreeNode b1 = new DefaultMutableTreeNode("B1");
        b.add(b1);
        DefaultMutableTreeNode b2 = new DefaultMutableTreeNode("B1");
        b.add(b2);

        //Tham chiếu tới node to nhất được dùng làm đối số trong hàm khởi tạo JTree
        JTree tree = new JTree(top);

        //Tạo ra một JScrollPane và add vào content pane
        JScrollPane jsp = new JScrollPane(tree);

        jfrm.add(jsp);

        //Tạo ra một JLabel và add vào content pane
        JLabel jlab = new JLabel();
        //add vào phía nam
        jfrm.add(jlab, BorderLayout.NORTH);

        tree.addTreeSelectionListener(new TreeSelectionListener() {
            @Override
            public void valueChanged(TreeSelectionEvent e) {
                jlab.setText("Đường dẫn của đối tượng đang select: " + e.getPath());
            }
        });

        jfrm.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new k_JTree();
            }
        });
    }

}
