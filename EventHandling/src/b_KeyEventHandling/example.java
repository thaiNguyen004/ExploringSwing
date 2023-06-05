package b_KeyEventHandling;
/*
 * Xử lý sự kiện bàn phím
 * Để xử lý sự kiện bàn phím, bạn sử dụng cùng một kiến trúc chung như ví dụ sự kiện chuột đã được hiển thị
 * trong phần trước. Sự khác biệt, tất nhiên, là bạn sẽ triển khai giao diện KeyListener.
 *
 * Trước khi xem một ví dụ, có ích để xem xét lại cách sự kiện phím được tạo ra. Khi một phím được nhấn,
 * một sự kiện KEY_PRESSED được tạo ra. Điều này dẫn đến việc gọi trình xử lý sự kiện keyPressed(). Khi phím được thả ra,
 * một sự kiện KEY_RELEASED được tạo ra và trình xử lý keyReleased() được thực thi. Nếu một ký tự được tạo ra bởi nhấn phím,
 * sau đó một sự kiện KEY_TYPED được gửi và trình xử lý keyTyped() được gọi. Do đó, mỗi khi người dùng nhấn một phím,
 * ít nhất hai và thường ba sự kiện được tạo ra. Nếu bạn chỉ quan tâm đến các ký tự thực sự, bạn có thể bỏ qua thông tin
 * được truyền bởi sự kiện nhấn và thả phím. Tuy nhiên, nếu chương trình của bạn cần xử lý các phím đặc biệt, như các
 * phím mũi tên hoặc phím chức năng, thì nó phải theo dõi chúng qua trình xử lý keyPressed().
 *
 * Chương trình dưới đây thể hiện đầu vào từ bàn phím. Nó sao chép các phím được nhấn vào cửa sổ và hiển thị
 * trạng thái đã nhấn/đã thả của mỗi phím.
 * */
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class example extends Frame implements KeyListener{

    String msg = "";
    String keyState = "";

    public example () {
        addKeyListener(this);
        addWindowListener(new MyWindowAdapter());
    }
    @Override
    public void keyTyped(KeyEvent e) {
        msg = msg + e.getKeyChar();
        repaint();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        keyState = "Key Down";
        //Code bổ sung
        int key = e.getKeyCode();
        switch (key) {
            case KeyEvent.VK_F1 -> {
                msg = msg + "<F1>";
            }
            case KeyEvent.VK_F2 -> {
                msg = msg + "<F2>";
            }
            case KeyEvent.VK_F3 -> {
                msg = msg + "<F3>";
            }
            case KeyEvent.VK_PAGE_DOWN -> {
                msg = msg + "<PgDn>";
            }
            case KeyEvent.VK_PAGE_UP -> {
                msg = msg + "<PgUp>";
            }
            case KeyEvent.VK_LEFT -> {
                msg = msg + "<Left Arrow>";
            }
            case KeyEvent.VK_RIGHT -> {
                msg = msg + "Right Arrow";
            }
        }

        repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {
        keyState = "Key Up";
        repaint();
    }

    @Override
    public void paint(Graphics g) {
        g.drawString(msg, 20, 100);
        g.drawString(keyState, 20, 50);
    }

    public static void main(String[] args) {
        example appwin = new example();
        appwin.setSize(new Dimension(200,150));
        appwin.setTitle("Key Event Handling");
        appwin.setVisible(true);
    }
}

class MyWindowAdapter extends WindowAdapter {
    @Override
    public void windowClosing(WindowEvent e) {
        System.exit(0);
    }
}

/*Nếu bạn muốn xử lý các phím đặc biệt, như các phím mũi tên hoặc phím chức năng, bạn cần phản ứng với chúng
trong trình xử lý keyPressed(). Chúng không có sẵn thông qua keyTyped(). Để xác định các phím, bạn sử dụng mã
phím ảo của chúng. Ví dụ, chương trình sau đây đầu ra tên của một số phím đặc biệt: trong phần code bổ sung
*/
