package e_SwingMenus;
/*
* JMenu
* JMenu đóng gói một menu, mà được điền thông tin bằng JMenuItems. Như đã đề cập, nó được thừa kế từ JMenuItem.
* Điều này có nghĩa là một JMenu có thể là một lựa chọn trong một JMenu khác. Điều này cho phép một menu trở thành
* submenu của menu khác. JMenu định nghĩa một số constructors. Ví dụ, đây là một constructor được sử dụng trong
* các ví dụ trong chương này:
*
* JMenu(String name)
*
* Constructor này tạo một menu có tiêu đề được chỉ định bởi name. Tất nhiên, bạn không cần phải đặt tên cho một menu.
* Để tạo một menu không có tên, bạn có thể sử dụng constructor mặc định:
*
* JMenu()
*
* Cũng hỗ trợ các constructors khác. Trong mỗi trường hợp, menu sẽ trống cho đến khi các menu item được thêm vào.
* JMenu định nghĩa nhiều phương thức. Dưới đây là một mô tả ngắn về một số phương thức thông dụng. Để thêm một mục
* vào menu, sử dụng phương thức add(), có nhiều hình thức, bao gồm hai hình thức được hiển thị dưới đây:
*
* JMenuItem add(JMenuItem item)
* Component add(Component item, int idx)
*
* Ở đây, item là menu item được thêm. Hình thức đầu tiên thêm item vào cuối menu. Hình thức thứ hai thêm item
* vào vị trí được chỉ định bởi idx. Như dự đoán, chỉ mục bắt đầu từ 0. Cả hai hình thức đều trả về một tham chiếu
* đến item được thêm. Đáng chú ý, bạn cũng có thể sử dụng insert() để thêm menu item vào menu.
*
* Bạn có thể thêm một đường phân cách (đối tượng của kiểu JSeparator) vào menu bằng cách gọi addSeparator(),
* được hiển thị như sau:
*
* void addSeparator()
* Đường phân cách được thêm vào cuối menu. Bạn có thể chèn một đường phân cách vào menu bằng cách gọi insertSeparator(),
* được hiển thị như sau:
*
* void insertSeparator(int idx)
*
* Ở đây, idx xác định chỉ mục bắt đầu từ 0 mà đường phân cách sẽ được thêm vào.
* Bạn có thể loại bỏ một mục từ menu bằng cách gọi remove(). Hai hình thức của nó được hiển thị dưới đây:
*
* void remove(JMenuItem menu)
* void remove(int idx)
*
* Trong trường hợp này, menu là một tham chiếu đến mục cần xóa và idx là chỉ mục của mục cần xóa.
* Bạn có thể lấy số lượng các mục trong menu bằng cách gọi getMenuComponentCount(), được hiển thị như sau:
*
* int getMenuComponentCount()
*
* Bạn có thể lấy một mảng các mục trong menu bằng cách gọi getMenuComponents(), được hiển thị như sau:
*
* Component[] getMenuComponents()
* Một mảng chứa các thành phần sẽ được trả về.
*
* */
public class c_georyJMenu {

}
