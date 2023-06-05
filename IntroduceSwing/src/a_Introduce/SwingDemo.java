package a_Introduce;
/*
* Một Ứng dụng Swing Đơn giản
* Các chương trình Swing khác biệt so với cả các chương trình dựa trên giao diện dòng lệnh và các chương trình dựa trên AWT
* được hiển thị trong sách này. Ví dụ, chúng sử dụng một tập hợp thành phần khác và một cấu trúc container khác so với AWT.
* Các chương trình Swing cũng có yêu cầu đặc biệt liên quan đến luồng xử lý. Cách tốt nhất để hiểu cấu trúc của một chương trình
* Swing là thực hành qua một ví dụ.
*
* Trước khi bắt đầu, cần lưu ý rằng trong quá khứ có hai loại chương trình Java mà Swing thường được sử dụng.
* Loại đầu tiên là ứng dụng desktop. Loại chương trình Swing này được sử dụng rộng rãi và là loại chương trình Swing được mô tả ở đây.
* Loại thứ hai là applet. Vì applet hiện đã không còn được khuyến nghị và không phù hợp để sử dụng trong mã mới, nên không
* được thảo luận trong sách này.
*
* Mặc dù rất ngắn gọn, chương trình sau đây cho thấy một cách để viết một ứng dụng Swing. Trong quá trình này,
* nó thể hiện một số tính năng chính của Swing. Nó sử dụng hai thành phần Swing: JFrame và JLabel.
* JFrame là container cấp cao được sử dụng phổ biến cho các ứng dụng Swing. JLabel là thành phần Swing tạo ra một nhãn,
* là một thành phần hiển thị thông tin. Nhãn là thành phần đơn giản nhất của Swing vì nó chỉ hiển thị đầu ra mà không
* phản hồi đầu vào từ người dùng.
* Chương trình sử dụng một container JFrame để chứa một thể hiện của JLabel. Nhãn hiển thị một thông điệp văn bản ngắn.
* */

import javax.swing.*;
public class SwingDemo {
    public SwingDemo() {
        //Create a new JFrame container
        JFrame jfrm = new JFrame("A simple Swing Application");

        //Đặt cho khung một kích thước ban đầu
        //Give the frame an initial size
        jfrm.setSize(275, 100);

        //Terminate the program when the user closes the application
        //Kết thúc chương trình khi người dùng đóng ứng dụng
        jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Create a text-based label
        //Tạo ra một nhãn dựa trên văn bản
        JLabel jlab = new JLabel("Swing là GUI mạnh mẽ");

        //Add the label to the content pane
        //Thêm nhãn vào ngăn nội dung
        jfrm.add(jlab);

        //Display the frame
        jfrm.setVisible(true);
    }

    public static void main(String[] args) {
        //Create the frame on the event dispatching thread
        //Tạo một frame trên luồng sử lý sự kiện
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new SwingDemo();
            }
        });
        /*
        * Luồng xử lý sự kiện (event dispatching thread) là một luồng đặc biệt trong ứng dụng Swing được sử dụng để xử lý
        * sự kiện và cập nhật giao diện người dùng. Nó đảm bảo rằng các sự kiện UI được xử lý một cách tuần tự và không
        * gây xung đột.
        *
        * Khi tạo một frame hoặc thực hiện các thay đổi trên giao diện người dùng trong ứng dụng Swing, chúng ta cần
        * đảm bảo rằng việc này được thực hiện trên luồng xử lý sự kiện. Điều này đảm bảo rằng các thao tác trên
        * giao diện người dùng không xảy ra đồng thời và không gây ra các vấn đề về đồng bộ hóa.
        *
        * Để tạo một frame trên luồng xử lý sự kiện, chúng ta có thể sử dụng phương thức SwingUtilities.invokeLater()
        * hoặc EventQueue.invokeLater(). Điều này đảm bảo rằng việc tạo frame và các thay đổi liên quan đến giao diện
        * người dùng được thực hiện trên luồng xử lý sự kiện.*/
    }
}
/*
* Vì chương trình SwingDemo minh họa một số khái niệm cốt lõi của Swing, chúng ta sẽ xem xét từng dòng code một cẩn thận.
* Chương trình bắt đầu bằng việc import gói javax.swing. Như đã đề cập, gói này chứa các thành phần và mô hình được
* định nghĩa bởi Swing. Ví dụ, javax.swing định nghĩa các lớp thực hiện các nhãn, nút bấm, điều khiển văn bản và menu.
* Nó sẽ được bao gồm trong tất cả các chương trình sử dụng Swing.
*
* Tiếp theo, chương trình khai báo lớp SwingDemo và một hàm khởi tạo cho lớp đó. Hàm khởi tạo là nơi hầu hết các
* hoạt động của chương trình diễn ra. Nó bắt đầu bằng cách tạo một JFrame, sử dụng dòng code này:
*
* JFrame jfrm = new JFrame("A Simple Swing Application");
*
* Điều này tạo ra một container được gọi là jfrm, xác định một cửa sổ hình chữ nhật hoàn chỉnh với thanh tiêu đề,
* các nút đóng, thu nhỏ, phóng to và phục hồi, và một menu hệ thống. Do đó, nó tạo ra một cửa sổ top-level tiêu chuẩn.
* Tiêu đề của cửa sổ được truyền vào trong hàm khởi tạo.
*
* Tiếp theo, cửa sổ được thiết lập kích thước bằng câu lệnh này:
*
* jfrm.setSize(275, 100);
*
* Phương thức setSize() (được kế thừa từ lớp Component của AWT) đặt kích thước của cửa sổ, được chỉ định bằng pixel.
* Dạng chung của phương thức này được hiển thị ở đây:
*
* void setSize(int width, int height)
*
* Trong ví dụ này, chiều rộng của cửa sổ được đặt là 275 và chiều cao được đặt là 100.
*
* Mặc định, khi một cửa sổ top-level được đóng (ví dụ như khi người dùng nhấp vào ô đóng), cửa sổ sẽ được loại bỏ
* khỏi màn hình, nhưng ứng dụng không được kết thúc. Mặc dù hành vi mặc định này hữu ích trong một số tình huống,
* nhưng không phải là những gì cần thiết cho hầu hết các ứng dụng. Thay vào đó, bạn thường muốn ứng dụng toàn bộ
*
* kết thúc khi cửa sổ top-level của nó bị đóng. Có một số cách để đạt được điều này. Cách dễ nhất là gọi
* `setDefaultCloseOperation()`, như chương trình đã làm:
*
* jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
*
* Sau khi thực thi lệnh này, khi đóng cửa sổ, toàn bộ ứng dụng sẽ kết thúc. Dạng chung của `setDefaultCloseOperation()` được hiển thị ở đây:

```
void setDefaultCloseOperation(int what)
```

Giá trị được truyền vào `what` xác định điều gì xảy ra khi cửa sổ được đóng. Ngoài `JFrame.EXIT_ON_CLOSE`, còn có một số tùy chọn khác. Chúng được hiển thị ở đây:

- `DISPOSE_ON_CLOSE`
- `HIDE_ON_CLOSE`
- `DO_NOTHING_ON_CLOSE`

* Tên của chúng phản ánh hành động tương ứng. Những hằng số này được khai báo trong `WindowConstants`,
* là một giao diện được khai báo trong `javax.swing` và được cài đặt bởi `JFrame`.
*
* Dòng code tiếp theo tạo một thành phần `JLabel` trong Swing:
*
* JLabel jlab = new JLabel(" Swing means powerful GUIs.");
*
* `JLabel` là thành phần đơn giản nhất và dễ sử dụng nhất vì nó không chấp nhận đầu vào từ người dùng.
* Nó chỉ hiển thị thông tin, có thể là văn bản, biểu tượng hoặc sự kết hợp của cả hai. Nhãn được tạo bởi chương trình
* này chỉ chứa văn bản, được truyền vào trong hàm khởi tạo của nó.
*
* Dòng code tiếp theo thêm nhãn vào content pane của frame:
* jfrm.add(jlab);
* Như đã giải thích trước đó, tất cả các container top-level có một content pane để lưu trữ các thành phần.
* Do đó, để thêm một thành phần vào frame, bạn phải thêm nó vào content pane của frame. Điều này được thực hiện
* bằng cách gọi `add()` trên tham chiếu `JFrame` (trong trường hợp này là `jfrm`).
* Dạng chung của `add()` được hiển thị ở đây:
*
* Component add(Component comp)
*
* Phương thức `add()` được kế thừa bởi `JFrame` từ lớp `Container` của AWT. Mặc định, content pane đi kèm
* với một `JFrame` sử dụng border layout. Phiên bản của `add()` đã được hiển thị chỉ thêm nhãn vào vị trí trung tâm.
* Phiên bản khác của `add()` cho phép bạn chỉ định một trong các vùng biên. Khi một thành phần được thêm vào trung tâm,
* kích thước của nó được điều chỉnh tự động để phù hợp với kích thước của trung tâm.
*
* Trước khi tiếp tục, cần nhấn mạnh một điểm quan trọng về lịch sử. Trước JDK 5, khi thêm một thành phần vào content pane,
* bạn không thể gọi trực tiếp phương thức `add()` trên một instance của `JFrame`. Thay vào đó, bạn cần gọi `add()`
* trên content pane của đối tượng `JFrame`. Content pane có thể được lấy bằng cách gọi `getContentPane()` trên một
* instance của `JFrame`. Phương thức `getContentPane()` được hiển thị ở đây:
*
* Container getContentPane()
*
* Nó trả về một tham chiếu đến content pane. Phương thức `add()` được gọi trên tham chiếu đó để thêm một thành phần
* vào content pane. Do đó, trong quá khứ, bạn phải sử dụng câu lệnh sau để thêm `jlab` vào `jfrm`:
*
* jfrm.getContentPane().add(jlab); // cách cũ
*
* Ở đây, `getContentPane()` trước tiên lấy một tham chiếu đến content pane, sau đó `add()` thêm thành phần vào container
* liên kết với content pane này. Thủ tục tương tự cũng được yêu cầu để gọi `remove()` để loại bỏ một thành phần
* và `setLayout()` để đặt trình quản lý bố trí cho content pane. Đây là lý do tại sao bạn thường thấy các cuộc gọi
* rõ ràng tới `getContentPane()` trong mã code kế thừa trước phiên bản 5.0. Ngày nay, việc sử dụng `getContentPane()`
* không còn cần thiết. Bạn có thể gọi trực tiếp `add()`, `remove()`, và `setLayout()` trên `JFrame` vì các phương thức
* này đã được thay đổi để hoạt động trên content pane tự động.
*
* Câu lệnh cuối cùng trong hàm tạo `SwingDemo` khiến cửa sổ trở nên hiển thị:
*
* jfrm.setVisible(true);
*
* Phương thức `setVisible()` được kế thừa từ lớp `Component` trong AWT. Nếu đối số của nó là `true`, cửa sổ sẽ được
* hiển thị. Ngược lại, nó sẽ được ẩn đi. Mặc định, một `JFrame` không hiển thị, vì vậy phải gọi `setVisible(true)`
* để hiển thị nó.
*
* Trong phần `main()`, một đối tượng `SwingDemo` được tạo, dẫn đến việc hiển thị cửa sổ và nhãn.
* Lưu ý rằng hàm tạo `SwingDemo` được gọi bằng các dòng code sau:
*
* SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new SwingDemo();
            }
        });
*
*
* Trình tự này khiến một đối tượng SwingDemo được tạo trên luồng xử lý sự kiện (event dispatching thread)
* thay vì trên luồng chính của ứng dụng. Đây là lý do. Nhìn chung, chương trình Swing được điều khiển bởi sự kiện.
*
* Ví dụ, khi người dùng tương tác với một thành phần, một sự kiện được tạo ra. Sự kiện được chuyển đến ứng dụng bằng
* cách gọi một bộ xử lý sự kiện được định nghĩa bởi ứng dụng. Tuy nhiên, bộ xử lý được thực thi trên luồng xử lý sự kiện
* do Swing cung cấp, không phải trên luồng chính của ứng dụng. Do đó, mặc dù bộ xử lý sự kiện được định nghĩa bởi
* chương trình của bạn, chúng được gọi trên một luồng không được tạo bởi chương trình của bạn.
*
* Để tránh các vấn đề (bao gồm nguy cơ bị kẹt), tất cả các thành phần GUI của Swing phải được tạo và cập nhật từ luồng
* xử lý sự kiện, không phải từ luồng chính của ứng dụng. Tuy nhiên, hàm `main()` được thực thi trên luồng chính.
* Do đó, `main()` không thể trực tiếp khởi tạo một đối tượng SwingDemo. Thay vào đó, nó phải tạo một đối tượng Runnable
* thực thi trên luồng xử lý sự kiện và yêu cầu đối tượng này tạo GUI.
*
* Để cho phép mã GUI được tạo trên luồng xử lý sự kiện, bạn phải sử dụng một trong hai phương thức được định nghĩa
* bởi lớp SwingUtilities. Các phương thức này là `invokeLater()` và `invokeAndWait()`. Chúng được hiển thị ở đây:
*
* static void invokeLater(Runnable obj)
* static void invokeAndWait(Runnable obj) throws InterruptedException, InvocationTargetException
*
* Ở đây, `obj` là một đối tượng Runnable mà phương thức `run()` của nó sẽ được gọi bởi luồng xử lý sự kiện.
* Sự khác biệt giữa hai phương thức là `invokeLater()` trả về ngay lập tức, nhưng `invokeAndWait()` đợi cho đến
* khi `obj.run()` trả về. Bạn có thể sử dụng một trong hai phương thức này để gọi một phương thức xây dựng GUI
* cho ứng dụng Swing của bạn, hoặc bất cứ khi nào bạn
* cần thay đổi trạng thái của GUI từ mã không được thực thi bởi luồng xử lý sự kiện. Bình thường, bạn sẽ muốn
* sử dụng `invokeLater()`, như chương trình trước đó đã làm. Tuy nhiên, khi GUI ban đầu cho một applet được xây dựng,
* cần sử dụng `invokeAndWait()`. Do đó, bạn sẽ thấy nó được sử dụng trong mã applet kế thừa cũ.
*/
