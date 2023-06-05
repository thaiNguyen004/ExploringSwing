/*
* Sử dụng mô hình sự kiện Delegation
Bây giờ bạn đã hiểu về lý thuyết đằng sau mô hình sự kiện Delegation và đã có cái nhìn tổng quan về các
* thành phần của nó, bây giờ là lúc thấy nó trong thực tế. Việc sử dụng mô hình sự kiện Delegation thực sự
* rất dễ dàng. Chỉ cần làm theo hai bước sau:
*
* 1. Triển khai giao diện thích hợp trong lớp nghe sự kiện để nó có thể nhận được loại sự kiện mong muốn.
*
* 2. Triển khai mã để đăng ký và hủy đăng ký (nếu cần thiết) lớp nghe như một người nhận thông báo sự kiện.
*
* Hãy nhớ rằng một nguồn có thể tạo ra nhiều loại sự kiện. Mỗi sự kiện phải được đăng ký riêng biệt.
* Ngoài ra, một đối tượng có thể đăng ký để nhận nhiều loại sự kiện, nhưng nó phải triển khai tất cả
* các giao diện cần thiết để nhận các sự kiện này. Trong mọi trường hợp, trình xử lý sự kiện phải trả về
* nhanh chóng. Như đã giải thích trước đây, trình xử lý sự kiện không được giữ điều khiển trong một
* khoảng thời gian kéo dài.
*
* Để thấy cách mô hình Delegation hoạt động trong thực tế, chúng ta sẽ xem xét các ví dụ xử lý hai bộ tạo
* sự kiện phổ biến: chuột và bàn phím.
*
* Một số khái niệm cơ bản về giao diện AWT
Để thể hiện những nguyên tắc cơ bản của xử lý sự kiện, chúng ta sẽ sử dụng một số chương trình đơn giản dựa
* trên giao diện người dùng (GUI). Như đã nêu trước đây, hầu hết các sự kiện mà chương trình của bạn sẽ phản
* ứng sẽ được tạo ra thông qua tương tác của người dùng với các chương trình GUI. Mặc dù các chương trình GUI
* được hiển thị trong chương này rất đơn giản, nhưng vẫn cần giải thích một số khái niệm quan trọng vì các chương trình
* dựa trên GUI khác với các chương trình dựa trên giao diện dòng lệnh được tìm thấy trong nhiều phần khác của cuốn sách này.
*
* Trước khi bắt đầu, điều quan trọng cần lưu ý là tất cả các phiên bản hiện đại của Java hỗ trợ hai khung công cụ GUI:
* AWT và Swing. AWT là khung công cụ GUI đầu tiên của Java và đối với các chương trình GUI rất đơn giản, nó là cách
* sử dụng dễ nhất. Swing, được xây dựng trên nền tảng của AWT, là khung công cụ GUI thứ hai của Java và là khung công cụ
* phổ biến và được sử dụng rộng rãi nhất. (Một khung công cụ GUI Java thứ ba có tên là JavaFX được cung cấp với
* một số phiên bản gần đây của Java. Tuy nhiên, bắt đầu từ JDK 11, nó không còn là một phần của JDK nữa.) Cả AWT và Swing
* sẽ được thảo luận sau trong cuốn sách này. Tuy nhiên, để thể hiện những nguyên tắc cơ bản của xử lý sự kiện, việc sử dụng
* các chương trình GUI dựa trên AWT đơn giản là lựa chọn phù hợp và được sử dụng ở đây.
*
*
* Có bốn tính năng chính của AWT được sử dụng trong các chương trình sau. Thứ nhất, tất cả đều tạo ra một cửa sổ cấp cao
* bằng cách mở rộng lớp Frame. Lớp Frame định nghĩa một cửa sổ "bình thường" như một cửa sổ có các hộp thu nhỏ, phóng to
* và đóng. Nó có thể được thay đổi kích thước, che phủ và hiển thị lại. Thứ hai, tất cả đều ghi đè phương thức paint()
* để hiển thị đầu ra trên cửa sổ. Phương thức này được hệ thống chạy thời gian gọi để hiển thị đầu ra trên cửa sổ.
* Ví dụ, nó được gọi khi một cửa sổ được hiển thị lần đầu và sau khi một cửa sổ đã được ẩn và sau đó được hiển thị lại.
* Thứ ba, khi chương trình của bạn cần hiển thị đầu ra, bạn không gọi trực tiếp phương thức paint(). Thay vào đó, bạn
* gọi phương thức repaint(). Cơ bản, repaint() yêu cầu AWT gọi phương thức paint(). Bạn sẽ thấy quá trình này hoạt động
* trong các ví dụ tiếp theo. Cuối cùng, khi cửa sổ Frame cấp cao nhất của một ứng dụng được đóng - ví dụ, bằng cách nhấp
* vào hộp đóng - chương trình phải thoát một cách rõ ràng, thường thông qua cuộc gọi System.exit(). Chỉ việc nhấp vào hộp
* đóng mà không kèm theo không làm chương trình kết thúc. Do đó, việc xử lý sự kiện đóng cửa sổ là cần thiết cho một
* chương trình GUI dựa trên AWT.*/
public class s_DelegationOverview {
}
