package e_SwingMenus;
/*
* Một cái nhìn tổng quan về JMenuBar, JMenu và JMenuItem
* Trước khi bạn tạo một menu, bạn cần biết về ba lớp menu cốt lõi: JMenuBar, JMenu và JMenuItem.
* Chúng tạo thành bộ ba lớp tối thiểu cần thiết để xây dựng một menu chính cho một ứng dụng. JMenu
* và JMenuItem cũng được sử dụng bởi các menu xuất hiện. Do đó, các lớp này tạo nên nền tảng của hệ thống menu.
*
* JMenuBar
* Như đã đề cập, JMenuBar trong bản chất là một container cho các menu. Giống như tất cả các thành phần khác,
* nó kế thừa từ JComponent (kế thừa từ Container và Component). Nó chỉ có một constructor, đó là constructor mặc định.
* Do đó, ban đầu thanh menu sẽ trống rỗng và bạn cần điền vào các menu trước khi sử dụng. Mỗi ứng dụng chỉ có một thanh menu.
*
* JMenuBar định nghĩa một số phương thức, nhưng thường bạn chỉ cần sử dụng một phương thức: add().
* Phương thức add() được sử dụng để thêm một JMenu vào thanh menu. Đây là cú pháp của phương thức add():
*
* JMenu add(JMenu menu)
*
* Ở đây, menu là một thể hiện của JMenu được thêm vào thanh menu. Phương thức trả về một tham chiếu đến menu đó.
* Các menu được xếp hàng trong thanh menu từ trái sang phải, theo thứ tự chúng được thêm vào. Nếu bạn muốn thêm một
* menu vào một vị trí cụ thể, bạn có thể sử dụng phiên bản của add() kế thừa từ Container:
*
* Component add(Component menu, int idx)
*
* Ở đây, menu được thêm vào vị trí được chỉ định bởi idx. Chỉ mục bắt đầu từ 0, với 0 là menu ở vị trí cực trái.
*
* Trong một số trường hợp, bạn có thể muốn loại bỏ một menu không còn cần thiết. Bạn có thể làm điều này bằng cách gọi
* phương thức remove(), được kế thừa từ Container. Phương thức này có hai dạng như sau:
*
* void remove(Component menu)
* void remove(int idx)
*
* Ở đây, menu là một tham chiếu đến menu cần xóa, và idx là chỉ mục của menu cần xóa. Chỉ mục bắt đầu từ số không.
*
* Một phương thức khác có ích đôi khi là getMenuCount(), được hiển thị như sau:
* int getMenuCount()
* Nó trả về số lượng các phần tử chứa trong thanh menu. JMenuBar định nghĩa một số phương thức khác mà bạn có thể
* thấy hữu ích trong các ứng dụng đặc biệt. Ví dụ, bạn có thể lấy một mảng các tham chiếu đến các menu trong thanh menu
* bằng cách gọi getSubElements(). Bạn có thể xác định xem một menu có được chọn hay không bằng cách gọi isSelected().
*
* Khi một thanh menu đã được tạo và điền thông tin, nó được thêm vào JFrame bằng cách gọi setJMenuBar()
* trên đối tượng JFrame. (Thanh menu không được thêm vào nội dung pane.) Phương thức setJMenuBar()
* được hiển thị như sau:
*
* void setJMenuBar(JMenuBar mb)
*
* Ở đây, mb là một tham chiếu đến thanh menu. Thanh menu sẽ được hiển thị ở một vị trí được xác định bởi giao diện người dùng.
* Thông thường, đây là ở phía trên cửa sổ.
*
* */
public class b_OverviewJMenuBar_JMenu_JMenuItem {
}
